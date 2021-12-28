package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Aksiomatikos;
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
import java.util.Optional;

@Service
public class AksiomatikosServiceImpl implements AksiomatikosService{

    @Autowired
    private AksiomatikosRepository rep;
    @Autowired
    private ApplicationRepository appRep;

    @Transactional
    @Override
    public Application getApplication(int id) {
        Application app = appRep.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
        return app;
    }

    @Transactional
    @Override
    public Application approveApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String aks =  authentication.getName();
        User a = rep.findByName(aks);
        app.setADTAks(a.getADT());
        return app;
    }

    @Transactional
    @Override
    public Application rejectApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(-2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String aks =  authentication.getName();
        User a = rep.findByName(aks);
        app.setADTAks(a.getADT());
        return app;
    }

    @Transactional
    @Override
    public List<Application> findAll() {
        return appRep.findAll();
    }

    @Transactional
    @Override
    public User findByName(String name) {
        return rep.findByName(name);
    }
}
