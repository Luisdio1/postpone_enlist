package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, String> {
}
