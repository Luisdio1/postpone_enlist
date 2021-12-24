package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aksiomatikos")
public class Aksiomatikos {

    @Id
    @Column(name = "ADT")
    private String ADT;

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

    //Relations with other tables
    @OneToOne(mappedBy = "aksiomatiikos" , cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "aksiomatikos")
    private List<Application> applications;

    @OneToOne
    @JoinColumn(name = "ADT")
    private Authorities authorities;

    @Override
    public String toString() {
        return "Aksiomatikos{" +
                "ADT='" + ADT + '\'' +
                ", user=" + user +
                '}';
    }
}
