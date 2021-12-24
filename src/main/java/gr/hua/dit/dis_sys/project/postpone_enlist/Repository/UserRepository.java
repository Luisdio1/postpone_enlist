package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
