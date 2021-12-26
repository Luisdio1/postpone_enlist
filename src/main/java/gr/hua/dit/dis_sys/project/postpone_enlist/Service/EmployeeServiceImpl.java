package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.ApplicationNotFoundException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository rep;
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
    public Application validateApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(1);
        return app;
    }

    @Transactional
    @Override
    public Application rejectApplication(int id) {
        Application app = getApplication(id);
        app.setStatus(-1);
        return app;
    }

    @Transactional
    @Override
    public List<Application> findAll() {
        return appRep.findAll();
    }
}
