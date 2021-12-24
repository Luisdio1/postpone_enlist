package gr.hua.dit.dis_sys.project.postpone_enlist.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "ADT")
    private String ADT;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "militarynumber")
    private String militaryNumber;

    //Relations with other tables
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="ADT")
    private Aksiomatikos aksiomatikos;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="ADT")
    private Citizen citizen;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="ADT")
    private Employee employee;

    //Constructors
    public User() {
    }

    public User(String ADT, String name, String lastName, String email, String username, String password, String militaryNumber) {
        this.ADT = ADT;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.militaryNumber = militaryNumber;
    }

    //Getters and Setters
    public String getADT() {
        return ADT;
    }

    public void setADT(String ADT) {
        this.ADT = ADT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMilitaryNumber() {
        return militaryNumber;
    }

    public void setMilitaryNumber(String militaryNumber) {
        this.militaryNumber = militaryNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "ADT='" + ADT + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", militaryNumber='" + militaryNumber + '\'' +
                ", aksiomatikos=" + aksiomatikos +
                ", citizen=" + citizen +
                ", employee=" + employee +
                '}';
    }
}
