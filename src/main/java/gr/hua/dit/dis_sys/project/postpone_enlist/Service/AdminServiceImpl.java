package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.*;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.UserAlreadyExistsException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.UserNotFoundException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private CitizenRepository citRep;
    @Autowired
    private EmployeeRepository emplRep;
    @Autowired
    private AksiomatikosRepository aksRep;
    @Autowired
    private UserRepository rep;
    @Autowired
    private AuthoritiesRepository authRep;

    //Finds a User given the username
    @Override
    public User findUser(String username) {

        User user = rep.findByName(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return user;
    }

    //Finds a User given the ADT
    @Override
    public User findUserByADT(String ADT) {
        User user = rep.findByADT(ADT);
        if (user == null) {
            throw new UserNotFoundException(ADT);
        }
        return user;
    }

    //Finds All Users
    @Override
    public List<User> findAllUsers() {

        return rep.findAll();
    }

    //Adds a User
    //Probably not needed since this is the register function which shouldn't be done by the admin
    @Override
    public User addUser(User user) {
        List<User> users = rep.findAll();
        if(users.stream().map(User::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
            throw new UserAlreadyExistsException();
        }

        return rep.save(user);
    }

    //Updates the users information
    @Override
    public User updateUser(User user) {
        return rep.findById(user.getADT())
                .map(newUser -> {
                    newUser.setADT(user.getADT());
                    newUser.setName(user.getName());
                    newUser.setLastName(user.getLastName());
                    newUser.setEmail(user.getEmail());
                    newUser.setUsername(user.getUsername());
                    newUser.setPassword(user.getPassword());
                    newUser.setMilitaryNumber(user.getMilitaryNumber());
                    return rep.save(newUser);
                })
                .orElseGet(() -> {
                    return rep.save(user);
                });
    }

    //Deletes a user
    @Override
    public void deleteUser(User user) {

        rep.delete(user);
    }

    //Store to table users the user and give him the ROLE_USER
    @Override
    public void makeUserCitizen(User user) {
        List<Citizen> citizens = citRep.findAll();
        if(citizens.stream().map(Citizen::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
            throw new UserAlreadyExistsException();
        }
        citRep.insertCitizen(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_USER");
        authRep.save(auth);
    }

    //Store to table employees the user and give him the ROLE_EMPL
    @Override
    public void makeUserEmployee(User user) {
        List<Employee> employees = emplRep.findAll();
        if(employees.stream().map(Employee::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
            throw new UserAlreadyExistsException();
        }
        emplRep.insertEmployee(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_EMPL");
        authRep.save(auth);
    }

    //Store to table aksiomatikos the user and give him the ROLE_AKS
    @Override
    public void makeUserAksiomatiko(User user) {
        List<Aksiomatikos> aksiomatikoi = aksRep.findAll();
        if(aksiomatikoi.stream().map(Aksiomatikos::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
            throw new UserAlreadyExistsException();
        }
        aksRep.insertAksiomatiko(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_AKS");
        authRep.save(auth);
    }

    //Update the authority of someone to ROLE_USER
    @Override
    public void updateAuthorityToCitizen(User user) {
        if (rep.findByADT(user.getADT()) == null) {
            throw new UserNotFoundException(user.getADT());
        }
        authRep.updateAuthority("ROLE_USER", user.getADT());
    }

    //Update the authority of someone to ROLE_EMPL
    @Override
    public void updateAuthorityToEmployee(User user) {
        if (rep.findByADT(user.getADT()) == null) {
            throw new UserNotFoundException(user.getADT());
        }
        authRep.updateAuthority("ROLE_EMPL", user.getADT());
    }

    //Update the authority of someone to ROLE_AKS
    @Override
    public void updateAuthorityToAksioamtiko(User user) {
        if (rep.findByADT(user.getADT()) == null) {
            throw new UserNotFoundException(user.getADT());
        }
        authRep.updateAuthority("ROLE_AKS", user.getADT());
    }
}
