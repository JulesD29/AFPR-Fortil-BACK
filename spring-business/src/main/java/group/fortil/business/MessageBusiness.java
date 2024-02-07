package group.fortil.business;

import group.fortil.entities.Message;
import group.fortil.entities.User;
import jakarta.validation.constraints.*;

import java.util.Date;

public class MessageBusiness implements IMessageBusiness {

    @PositiveOrZero(message = "message_index cannot be negative or null")
    private Long message_index;

    @NotBlank(message = "Message blank")
    private String value;

    @PastOrPresent(message = "Error in message creation date")
    private Date creation_date;

    @PastOrPresent(message = "Error in message modification")
    private Date modification_date;

    @NotNull(message = "User can't be null")
    private UserBusiness userBusiness;

    // Ajouter liste des tags


    // Constructeur
    public MessageBusiness(){}
    public MessageBusiness(String value, Date creation_date, UserBusiness userBusiness) {
        this.value = value;
        this.creation_date = creation_date;
        this.userBusiness=userBusiness;
    }
    public MessageBusiness(Long message_index, String value, Date creation_date, Date modification_date, UserBusiness userBusiness) {
        this.message_index = message_index;
        this.value = value;
        this.creation_date = creation_date;
        this.modification_date = modification_date;
        this.userBusiness=userBusiness;
    }

    public Long getMessage_index() {
        return message_index;
    }

    public void setMessage_index(Long message_index) {
        this.message_index = message_index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }

    public UserBusiness getUser() {
        return userBusiness;
    }

    public void setUser(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

}
