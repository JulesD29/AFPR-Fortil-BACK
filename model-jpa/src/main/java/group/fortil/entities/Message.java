package group.fortil.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_index")
    private Long message_index;

    @Column(name = "value")
    private String value;

    @Column(name = "creation_date")
    private Date creation_date;

    @Column(name = "modification_date")
    private Date modification_date;


    /***
     * On définie ici les liens entre les tables :
     *          - @ManyToOne -> n,1
     *          - @ManyToMany -> n,n
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_index", referencedColumnName = "u_index")
    private User user;

    @ManyToMany
    @JoinTable(name = "Message_Tag",
            joinColumns = @JoinColumn(name = "message_index", referencedColumnName = "m_index", table = "Message"),
            inverseJoinColumns = @JoinColumn(name = "tag_index", referencedColumnName = "t_index", table = "Tag"))
    private List<Tag> tags;



    public Message(){}
    public Message(String value, Date creation_date, User user) {
        this.value = value;
        this.creation_date = creation_date;
        this.user = user;
    }
    public Message(Long message_index, String value, Date creation_date, Date modification_date, User user) {
        this.message_index = message_index;
        this.value = value;
        this.creation_date = creation_date;
        this.modification_date = modification_date;
        this.user=user;
    }



    // GETTER AND SETTER



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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}