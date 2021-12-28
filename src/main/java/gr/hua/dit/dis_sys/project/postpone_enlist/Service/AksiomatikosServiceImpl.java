package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.ApplicationNotFoundException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.AksiomatikosRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AksiomatikosServiceImpl implements AksiomatikosService{

    @Autowired
    private AksiomatikosRepository rep;
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

    //Approve an application given the id
    @Transactional
    @Override
    public Application approveApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(2);

        //Get the ADT of current user logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String aks =  authentication.getName();
        User a = rep.findByName(aks);
        app.setADTAks(a.getADT());

        return app;
    }

    //Reject an application given the id
    @Transactional
    @Override
    public Application rejectApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(-2);

        //Get the ADT of current user logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String aks =  authentication.getName();
        User a = rep.findByName(aks);
        app.setADTAks(a.getADT());

        return app;
    }

    //Find all applications
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
