package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "ADT")
    private String ADT;
}
