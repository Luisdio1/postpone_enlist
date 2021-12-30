package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.DateUtils;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.ApplicationAlreadyExistsException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Exceptions.ApplicationNotFoundException;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.ApplicationRepository;
import gr.hua.dit.dis_sys.project.postpone_enlist.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepository rep;
    @Autowired
    private ApplicationRepository appRep;

    //Submit an application
    @Override
    public Application submitApplication(Application application) {
        //If application exists with same ADT throw an exception
        List<Application> apps = appRep.findAll();
        if(apps.stream().map(Application::getADTCit).filter(application.getADTCit()::equals).findFirst().isPresent()) {
            throw new ApplicationAlreadyExistsException();
        }

        return appRep.save(application);
    }

    //Get an application given the id
    //If not found throw an exception
    @Override
    public Application getApplication(int id) {
        Application app = appRep.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
        return app;
    }

    //Update an application
    @Override
    public Application changeApplication(Application app, int id) {
        return appRep.findById(id)
                .map(application -> {
                    //Get Current date
                    try {
                        application.setDateModified(DateUtils.getDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    application.setPaper(app.getPaper());
                    application.setADTCit(app.getADTCit());
                    return appRep.save(application);
                })
                .orElseGet(() -> {
                    return appRep.save(app);
                });
    }
}
