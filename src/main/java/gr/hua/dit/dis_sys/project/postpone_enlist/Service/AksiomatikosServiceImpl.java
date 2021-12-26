package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.AksiomatikosRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return appRep.findById(id).get();
    }

    @Transactional
    @Override
    public Application approveApplication(int id) {
        getApplication(id).setStatus(1);
        return getApplication(id);
    }

    @Transactional
    @Override
    public List<Application> findAll() {
        return appRep.findAll();
    }
}
