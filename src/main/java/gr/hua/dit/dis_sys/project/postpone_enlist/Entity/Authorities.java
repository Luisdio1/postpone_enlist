package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "ADT")
    private String ADT;

    @Column(name = "Role")
    private String role;

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

    //Relations with other tables
    @OneToOne(mappedBy = "authorities")
    private Employee employee;

    //Relations with other tables
    @OneToOne(mappedBy = "authorities")
    private Citizen citizen;

    //Relations with other tables
    @OneToOne(mappedBy = "authorities")
    private Aksiomatikos aksiomatikos;
}
