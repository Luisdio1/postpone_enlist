package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.DateUtils;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.*;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

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
    @Transactional
    @Override
    public User findUser(String username) {

        return rep.findByName(username);
    }

    //Finds a User given the ADT
    @Transactional
    @Override
    public User findUserByADT(String ADT) {

        return rep.findByADT(ADT);
    }

    //Finds All Users
    @Transactional
    @Override
    public List<User> findAllUsers() {

        return rep.findAll();
    }

    //Adds a User
    //Probably not needed since this is the register function which shouldnt be done by the admin
    @Transactional
    @Override
    public User addUser(User user) {

        return rep.save(user);
    }

    //Updates the users information
    @Transactional
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
    @Transactional
    @Override
    public void deleteUser(User user) {

        rep.delete(user);
    }

    @Transactional
    @Override
    public void makeUserCitizen(User user) {
        citRep.insertCitizen(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_USER");
        authRep.save(auth);
    }

    @Transactional
    @Override
    public void makeUserEmployee(User user) {
        emplRep.insertEmployee(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_EMPL");
        authRep.save(auth);
    }

    @Transactional
    @Override
    public void makeUserAksiomatiko(User user) {
        aksRep.insertAksiomatiko(user.getADT());
        Authorities auth = new Authorities(user.getADT(), "ROLE_AKS");
        authRep.save(auth);
    }

    @Transactional
    @Override
    public void updateAuthorityToCitizen(User user) {
        authRep.updateAuthority("ROLE_USER", user.getADT());
    }

    @Transactional
    @Override
    public void updateAuthorityToEmployee(User user) {
        authRep.updateAuthority("ROLE_EMPL", user.getADT());
    }

    @Transactional
    @Override
    public void updateAuthorityToAksioamtiko(User user) {
        authRep.updateAuthority("ROLE_AKS", user.getADT());
    }
}
