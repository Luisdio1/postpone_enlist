package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "ADT")
    private String ADT;

    @Column(name = "Role")
    private String role;

    //Relations with other tables
    @OneToMany(mappedBy = "authorities")
    private List<Employee> employees;

    @OneToMany(mappedBy = "authorities")
    private List<Citizen> citizens;

    @OneToMany(mappedBy = "authorities")
    private List<Aksiomatikos> aksiomatikoi;

    //Constructors
    public Authorities() {
    }

    public Authorities(String ADT, String role) {
        this.ADT = ADT;
        this.role = role;
    }

    //Getters And Setters
    public String getADT() {
        return ADT;
    }

    public void setADT(String ADT) {
        this.ADT = ADT;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "ADT='" + ADT + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
