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

    public User updateUser(User user);

    public void deleteUser(User user);

    public void makeUserCitizen(User user);

    public void makeUserEmployee(User user);

    public void makeUserAksiomatiko(User user);

    public void updateAuthorityToCitizen(User user);

    public void updateAuthorityToEmployee(User user);

    public void updateAuthorityToAksioamtiko(User user);
}
