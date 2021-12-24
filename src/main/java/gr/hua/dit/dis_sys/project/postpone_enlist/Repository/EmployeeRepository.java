package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
