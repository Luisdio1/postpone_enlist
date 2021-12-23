package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aksiomatikos")
public class Aksiomatikos {

    @Id
    @Column(name = "ADT")
    private String ADT;
}
