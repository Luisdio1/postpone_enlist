package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CitizenRepository extends JpaRepository<Citizen, String> {

    @Modifying
    @Query(value = "insert into Citizen (ADT) values (:ADT)", nativeQuery = true)
    void insertCitizen(@Param("ADT") String ADT);
}
