package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

import java.util.List;

public interface AksiomatikosService {

    public Application approveApplication(int id);

    public Application rejectApplication(int id);

    public Application getApplication(int id);

    public List<Application> findAll();
}
