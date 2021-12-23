package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aplication")
public class Application {

    @Id
    @Column(name = "aplicationid")
    private int applicationId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_modified")
    private Date dateModified;

    @Column(name = "status")
    private int status;

    @Column(name = "ADT_empl")
    private String ADTEmpl;

    @Column(name = "ADT_cit")
    private String ADTCit;

    @Column(name = "ADT_aks")
    private String ADTAks;
}
