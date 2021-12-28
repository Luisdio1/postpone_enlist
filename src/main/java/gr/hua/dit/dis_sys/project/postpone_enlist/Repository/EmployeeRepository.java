package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Employee;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    //Custom query to return a user based on the username
    @Query("SELECT u FROM User u WHERE u.username = :name")
    User findByName(@Param("name") String name);

    @Modifying
    @Query(value = "insert into Employee (ADT) values (:ADT)", nativeQuery = true)
    void insertEmployee(@Param("ADT") String ADT);
}
