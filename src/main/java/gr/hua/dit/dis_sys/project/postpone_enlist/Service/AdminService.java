package gr.hua.dit.dis_sys.project.postpone_enlist.Service;

;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public User findUser(String username);

    public User findUserByADT(String ADT);

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
