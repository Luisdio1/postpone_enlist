package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

public interface EmployeeService {

    public Application getApplication(int id);

    public void validateApplication(int id);
}
