package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepository rep;
    @Autowired
    private ApplicationRepository appRep;

    @Transactional
    @Override
    public void submitApplication() {

    }

    @Transactional
    @Override
    public Application getApplication(int id) {
        return appRep.getById(id);
    }
}
