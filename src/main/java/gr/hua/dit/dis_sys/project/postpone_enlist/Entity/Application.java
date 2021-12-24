package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aplication")
public class Application {

    @Id
    @Column(name = "aplicationid")
    private int applicationId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_modified")
    private Date dateModified;

    @Column(name = "status")
    private int status;

    @Column(name = "ADT_empl")
    private String ADTEmpl;

    @Column(name = "ADT_cit")
    private String ADTCit;

    @Column(name = "ADT_aks")
    private String ADTAks;

    //Relations with other tables
    @ManyToOne
    @JoinColumn(name ="ADT_aks")
    private Aksiomatikos aksiomatikos;

    @OneToOne
    @JoinColumn(name ="ADT_cit")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "ADT_empl")
    private Employee employee;

    //Constructors
    public Application() {
    }

    public Application(int applicationId, Date dateCreated, Date dateModified, int status, String ADTEmpl, String ADTCit, String ADTAks) {
        this.applicationId = applicationId;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.status = status;
        this.ADTEmpl = ADTEmpl;
        this.ADTCit = ADTCit;
        this.ADTAks = ADTAks;
    }

    //Getters And Setters
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getADTEmpl() {
        return ADTEmpl;
    }

    public void setADTEmpl(String ADTEmpl) {
        this.ADTEmpl = ADTEmpl;
    }

    public String getADTCit() {
        return ADTCit;
    }

    public void setADTCit(String ADTCit) {
        this.ADTCit = ADTCit;
    }

    public String getADTAks() {
        return ADTAks;
    }

    public void setADTAks(String ADTAks) {
        this.ADTAks = ADTAks;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", status=" + status +
                ", ADTEmpl='" + ADTEmpl + '\'' +
                ", ADTCit='" + ADTCit + '\'' +
                ", ADTAks='" + ADTAks + '\'' +
                '}';
    }
}
