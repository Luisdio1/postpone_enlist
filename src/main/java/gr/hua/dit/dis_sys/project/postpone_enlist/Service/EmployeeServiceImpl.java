package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.ApplicationNotFoundException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository rep;
    @Autowired
    private ApplicationRepository appRep;

    //Get an application given the id
    //If not found throw an exception
    @Transactional
    @Override
    public Application getApplication(int id) {
        Application app = appRep.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
        return app;
    }

    //Validate an application
    @Transactional
    @Override
    public Application validateApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(1);

        //Get the ADT of current user logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String empl =  authentication.getName();
        User a = rep.findByName(empl);
        app.setADTEmpl(a.getADT());

        return app;
    }

    //Reject an application
    @Transactional
    @Override
    public Application rejectApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(-1);

        //Get the ADT of current user logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String empl =  authentication.getName();
        User a = rep.findByName(empl);
        app.setADTEmpl(a.getADT());

        return app;
    }

    //Get all applications
    @Transactional
    @Override
    public List<Application> findAll() {
        return appRep.findAll();
    }

    //Find user given the username
    @Transactional
    @Override
    public User findByName(String name) {
        return rep.findByName(name);
    }
}
