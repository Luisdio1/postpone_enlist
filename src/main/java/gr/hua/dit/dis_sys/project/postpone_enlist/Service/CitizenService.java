package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Citizen;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CitizenService {

    public Application submitApplication(Application app, MultipartFile file);

    public Application getApplication(int id);

    public Application changeApplication(Application app, int id, MultipartFile file);


}
