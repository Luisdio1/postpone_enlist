package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;

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

    //Constructors
    public Citizen() {
    }

    public Citizen(String ADT, String paper, int applicationId) {
        this.ADT = ADT;
        this.paper = paper;
        this.applicationId = applicationId;
    }

    //Getters And Setters
    public String getADT() {
        return ADT;
    }

    public void setADT(String ADT) {
        this.ADT = ADT;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    //Relations with other tables
    @OneToOne(mappedBy = "citizen" , cascade = CascadeType.ALL)
    private User user;

    @OneToOne(mappedBy = "citizen")
    private Application application;

    @OneToOne
    @JoinColumn(name = "ADT")
    private Authorities authorities;

    @Override
    public String toString() {
        return "Citizen{" +
                "ADT='" + ADT + '\'' +
                ", paper='" + paper + '\'' +
                ", applicationId=" + applicationId +
                ", user=" + user +
                '}';
    }
}
