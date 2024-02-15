package group.fortil.business;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class UserBusiness implements IUserBusiness{

    @PositiveOrZero(message = "user_index cannot be negative or null")
    private Long user_index;

    @NotNull(message = "firstName cannot be null")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    private String lastName;

    @Email(message = "Email should be valid")
    private String mail;

    @NotNull(message = "password cannot be null")
    private String password;



    // Constructeur de UserBusiness
    public UserBusiness(){}
    public UserBusiness(String firstName, String lastName, String mail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }
    public UserBusiness(Long user_index, String firstName, String lastName, String mail, String password) {
        this.user_index = user_index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }


    public Long getUser_index() {
        return user_index;
    }

    public void setUser_index(Long user_index) {
        this.user_index = user_index;
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
