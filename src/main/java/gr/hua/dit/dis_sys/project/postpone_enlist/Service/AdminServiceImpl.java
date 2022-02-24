package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.*;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.UserAlreadyExistsException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.UserNotFoundException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //Finds a Citizen given the ADT
    @Override
    public Citizen findCitizenByADT(String ADT) {
        Citizen citizen = citRep.findByADT(ADT);
        return citizen;
    }
    //Finds a Aksiomatiko given the ADT
    @Override
    public Aksiomatikos findAksiomatikoByADT(String ADT) {
        Aksiomatikos aksiomatikos = aksRep.findByADT(ADT);
        return aksiomatikos;
    }
    //Finds a Employee given the ADT
    @Override
    public Employee findEmployeeByADT(String ADT) {
        Employee employee = emplRep.findByADT(ADT);
        return employee;
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

            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            rep.save(user);
            citRep.insertCitizen(user.getADT());
            Authorities auth = new Authorities(user.getADT(), "ROLE_USER");
            authRep.save(auth);
            return user;



    }
//        List<User> users = rep.findAll();
//        if(users.stream().map(User::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
//            throw new UserAlreadyExistsException();
//        }
//



    //Updates the users information
    @Override
    public User updateUser(User user, String ADT) {
        return rep.findById(ADT)
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
    public void deleteUser(String ADT) {

        Employee employee = findEmployeeByADT(ADT);
        Aksiomatikos aksiomatikos = findAksiomatikoByADT(ADT);
        Citizen citizen = findCitizenByADT(ADT);
        User user = findUserByADT(ADT);

        if(employee != null) {
            emplRep.delete(employee);
        }
        if(aksiomatikos != null) {
            aksRep.delete(aksiomatikos);
        }
        if(citizen != null) {
            citRep.delete(citizen);
        }
        rep.delete(user);

    }

    //Store to table citizen the user and give him the ROLE_USER
    @Override
    public void makeUserCitizen(String ADT) {

        Citizen cit = new Citizen();
        cit.setADT(ADT);
        citRep.save(cit);
        Authorities auth = new Authorities(ADT, "ROLE_USER");
        authRep.save(auth);

    }


//        List<Citizen> citizens = citRep.findAll();
//        User user = findUserByADT(ADT);
//        if(citizens.stream().map(Citizen::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
//            throw new UserAlreadyExistsException();
//        }
//        citRep.insertCitizen(user.getADT());
//        Authorities auth = new Authorities(user.getADT(), "ROLE_USER");
//        authRep.save(auth);
//    }

    //Store to table employees the user and give him the ROLE_EMPL
    @Override
    public void makeUserEmployee(String ADT) {
        List<Employee> employees = emplRep.findAll();
        User user = findUserByADT(ADT);
        if(employees.stream().map(Employee::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
            throw new UserAlreadyExistsException();
        }
        emplRep.insertEmployee(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_EMPL");
        authRep.save(auth);
    }

    //Store to table aksiomatikos the user and give him the ROLE_AKS
    @Override
    public void makeUserAksiomatiko(String ADT) {
        List<Aksiomatikos> aksiomatikoi = aksRep.findAll();
        User user = findUserByADT(ADT);
        if(aksiomatikoi.stream().map(Aksiomatikos::getADT).filter(user.getADT()::equals).findFirst().isPresent()) {
            throw new UserAlreadyExistsException();
        }
        aksRep.insertAksiomatiko(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_AKS");
        authRep.save(auth);
    }

    //Update the authority of someone to ROLE_USER
    @Override
    public void updateAuthorityToCitizen(String ADT) {
        if (rep.findByADT(ADT) == null) {
            throw new UserNotFoundException(ADT);
        }
        authRep.updateAuthority("ROLE_USER", ADT);
    }

    //Update the authority of someone to ROLE_EMPL
    @Override
    public void updateAuthorityToEmployee(String ADT) {
        if (rep.findByADT(ADT) == null) {
            throw new UserNotFoundException(ADT);
        }
        authRep.updateAuthority("ROLE_EMPL", ADT);
    }

    //Update the authority of someone to ROLE_AKS
    @Override
    public void updateAuthorityToAksioamtiko(String ADT) {
        if (rep.findByADT(ADT) == null) {
            throw new UserNotFoundException(ADT);
        }
        authRep.updateAuthority("ROLE_AKS", ADT);
    }
}
