package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository rep;
    @Autowired
    private ApplicationRepository appRep;

    @Transactional
    @Override
    public Application getApplication(int id) {
        return appRep.getById(id);
    }

    @Transactional
    @Override
    public void validateApplication(int id) {
        getApplication(id).setStatus(2);
    }
}
