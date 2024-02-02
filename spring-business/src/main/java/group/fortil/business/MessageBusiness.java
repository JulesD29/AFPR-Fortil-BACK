package group.fortil.business;

import group.fortil.entities.Message;
import group.fortil.entities.User;
import jakarta.validation.constraints.*;

public class MessageBusiness implements IMessageBusiness {

    @PositiveOrZero(message = "message_index cannot be negative or null")
    private Long message_index;

    @NotBlank(message = "Message blank")
    private String value;

    @PastOrPresent(message = "Error in message creation date")
    private String creation_date;

    @PastOrPresent(message = "Error in message modification")
    private String modification_date;

    @NotNull(message = "User can't be null")
    private User user;

    // Ajouter liste des tags


    // Constructeur
    public MessageBusiness(){}
    public MessageBusiness(Long message_index, String value, String creation_date, String modification_date, User user) {
        this.message_index = message_index;
        this.value = value;
        this.creation_date = creation_date;
        this.modification_date = modification_date;
        this.user=user;
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

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getModification_date() {
        return modification_date;
    }

    public void setModification_date(String modification_date) {
        this.modification_date = modification_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Message authenticateMessage(Message message) {
        return null;
    }
}
