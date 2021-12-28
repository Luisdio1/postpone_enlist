package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

public interface CitizenService {

    public Application submitApplication(Application app);

    public Application getApplication(int id);

    public Application changeApplication(Application app, int id);
}
