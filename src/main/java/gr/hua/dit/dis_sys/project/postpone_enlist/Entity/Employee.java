package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "ADT")
    private String ADT;

    //Relations with other tables
    @OneToOne(mappedBy = "employee" , cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "employee")
    private List<Application> applications;

    @ManyToOne
    @JoinColumn(name = "ADT")
    private Authorities authorities;

    //Constructors
    public Employee() {
    }

    public Employee(String ADT) {
        this.ADT = ADT;
    }

    //Getters And Setters
    public String getADT() {
        return ADT;
    }

    public void setADT(String ADT) {
        this.ADT = ADT;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ADT='" + ADT + '\'' +
                ", user=" + user +
                '}';
    }
}
