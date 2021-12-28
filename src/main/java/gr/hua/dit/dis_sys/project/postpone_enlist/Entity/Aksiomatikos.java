package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aksiomatikos")
public class Aksiomatikos {

    @Id
    @Column(name = "ADT")
    @JoinColumn(name = "ADT")
    private String ADT;

    //Relations with other tables
    @OneToOne(mappedBy = "aksiomatikos" , cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "aks")
    private List<Application> applications;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ADT", referencedColumnName="ADT", insertable=false, updatable=false)
    private Authorities authorities;

    //Constructors
    public Aksiomatikos() {
    }

    public Aksiomatikos(String ADT) {
        this.ADT = ADT;
    }

    //Getters and setters
    public String getADT() {
        return ADT;
    }

    public void setADT(String ADT) {
        this.ADT = ADT;
    }

    @Override
    public String toString() {
        return "Aksiomatikos{" +
                "ADT='" + ADT + '\'' +
                ", user=" + user +
                '}';
    }
}
