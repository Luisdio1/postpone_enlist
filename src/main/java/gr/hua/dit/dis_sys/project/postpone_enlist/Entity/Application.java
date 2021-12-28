package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aplication")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "paper")
    private String paper;

    @Column(name = "ADT_empl")
    private String ADTEmpl;

    @Column(name = "ADT_cit")
    private String ADTCit;

    @Column(name ="ADT_aks")
    private String ADTAks;

    //Relations with other tables
    @ManyToOne()
    @JoinColumn(name = "ADT_aks", referencedColumnName="ADT", insertable=false, updatable=false)
    private Aksiomatikos aks;

    @OneToOne
    @JoinColumn(name ="ADT_cit" , insertable=false, updatable=false)
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "ADT_empl", referencedColumnName="ADT" , insertable=false, updatable=false)
    private Employee employee;

    //Constructors
    public Application() {
    }

    public Application(int applicationId, Date dateCreated, Date dateModified, int status, String paper, String ADTEmpl, String ADTCit, String ADTAks) {
        this.applicationId = applicationId;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.status = status;
        this.paper = paper;
        this.ADTEmpl = ADTEmpl;
        this.ADTCit = ADTCit;
        this.ADTAks = ADTAks;
    }

    //Copy Constructor in case is needed
    public Application(Application app) {
        this.applicationId = app.getApplicationId();
        this.dateCreated = app.getDateCreated();
        this.dateModified = app.getDateModified();
        this.status = app.getStatus();
        this.paper = app.getPaper();
        this.ADTEmpl = app.getADTEmpl();
        this.ADTCit = app.getADTCit();
        this.ADTAks = app.getADTAks();
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

    public String getPaper(){
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
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
                ", Paper='" + paper + '\'' +
                ", ADTEmpl='" + ADTEmpl + '\'' +
                ", ADTCit='" + ADTCit + '\'' +
                ", ADTAks='" + ADTAks + '\'' +
                '}';
    }
}
