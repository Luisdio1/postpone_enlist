package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;

import java.util.List;

public interface EmployeeService {

    public Application getApplication(int id);

    public Application validateApplication(int id);

    public Application rejectApplication(int id);

    public List<Application> findAll();
}
