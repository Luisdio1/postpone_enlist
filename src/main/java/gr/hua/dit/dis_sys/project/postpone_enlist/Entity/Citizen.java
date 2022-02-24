package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @Column(name = "ADT")
    @JoinColumn(name = "ADT")
    private String ADT;

    @Column(name = "aplicationid")
    private Integer applicationId;

    //Relations with other tables
    @OneToOne(mappedBy = "citizen")
    private User user;

    @OneToOne(mappedBy = "citizen")
    private Application application;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ADT", referencedColumnName="ADT", insertable=false, updatable=false)
    private Authorities authorities;

    //Constructors
    public Citizen() {
    }

    public Citizen(String ADT, int applicationId) {
        this.ADT = ADT;
        this.applicationId = applicationId;
    }

    //Getters And Setters
    public String getADT() {
        return ADT;
    }

    public void setADT(String ADT) {
        this.ADT = ADT;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "ADT='" + ADT + '\'' +
                ", applicationId=" + applicationId +
                ", user=" + user +
                '}';
    }
}
