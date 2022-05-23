package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    //Custom query to return a user based on the username
    @Query("SELECT u FROM User u WHERE u.username = :name")
    User findByName(@Param("name") String name);

    //Custom query to return a user based on the ADT
    @Query("SELECT u FROM User u WHERE u.ADT = :ADT")
    User findByADT(@Param("ADT") String ADT);

}
