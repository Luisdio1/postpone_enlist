package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @Column(name = "ADT")
    private String ADT;

    @Column(name = "paper")
    private String paper;

    @Column(name = "aplicationid")
    private int applicationId;
}
