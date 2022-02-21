package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Application;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Application getApplication(int id);

    public Application validateApplication(int id);

    public Application rejectApplication(int id);

    public String findAll();

    public User findByName(String name);
}
