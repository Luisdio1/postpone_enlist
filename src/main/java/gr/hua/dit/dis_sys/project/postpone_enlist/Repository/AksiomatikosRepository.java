package gr.hua.dit.dis_sys.project.postpone_enlist.Repository;

import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.Aksiomatikos;
import gr.hua.dit.dis_sys.project.postpone_enlist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AksiomatikosRepository extends JpaRepository<Aksiomatikos, String> {

    //Custom query to return a user based on the username
    @Query("SELECT u FROM User u WHERE u.username = :name")
    User findByName(@Param("name") String name);

    @Modifying
    @Query(value = "insert into Aksiomatikos (ADT) values (:ADT)", nativeQuery = true)
    void insertAksiomatiko(@Param("ADT") String ADT);

    //Custom query to return a aksiomatiko based on the ADT
    @Query("SELECT a FROM Aksiomatikos a WHERE a.ADT = :ADT")
    Aksiomatikos findByADT(@Param("ADT") String ADT);
}
