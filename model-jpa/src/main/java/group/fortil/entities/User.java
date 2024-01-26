package group.fortil.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "u_index")
    private UUID user_index;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;



    // GETTER AND SETTER

    
    public void setUser_index(UUID user_index) {
        this.user_index = user_index;
    }

    public UUID getUser_index() {
        return user_index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}