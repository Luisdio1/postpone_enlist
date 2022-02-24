package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Aksiomatikos;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Citizen;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Employee;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public User findUser(String username);

    public User findUserByADT(String ADT);

    //Finds a Citizen given the ADT
    Citizen findCitizenByADT(String ADT);

    //Finds a Aksiomatiko given the ADT
    Aksiomatikos findAksiomatikoByADT(String ADT);

    //Finds a Employee given the ADT
    Employee findEmployeeByADT(String ADT);

    public List<User> findAllUsers();

    public User addUser(User user);

    public User updateUser(User user, String ADT);

    public void deleteUser(String ADT);

    public void makeUserCitizen(String ADT);

    public void makeUserEmployee(String ADT);

    public void makeUserAksiomatiko(String ADT);

    public void updateAuthorityToCitizen(String ADT);

    public void updateAuthorityToEmployee(String ADT);

    public void updateAuthorityToAksioamtiko(String ADT);
}
