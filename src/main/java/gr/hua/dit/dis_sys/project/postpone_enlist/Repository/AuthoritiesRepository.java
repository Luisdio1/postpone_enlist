package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

    @Modifying
    @Query("update Authorities a set a.role = :role where a.ADT = :ADT")
    int updateAuthority(@Param("role") String role, @Param("ADT") String ADT);
}
