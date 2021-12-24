package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

import java.util.Optional;

public interface AksiomatikosService {

    public void approveApplication(int id);

    public Application getApplication(int id);
}
