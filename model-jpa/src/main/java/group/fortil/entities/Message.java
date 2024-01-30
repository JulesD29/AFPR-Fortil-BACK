package group.fortil.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "m_index")
    private UUID message_index;

    @Column(name = "value")
    private String value;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creation_date;

    @Column(name = "modification_date")
    @Temporal(TemporalType.DATE)
    private Date modification_date;


    /***
     * On définie ici les liens entre les tables :
     *          - @ManyToOne -> n,1
     *          - @ManyToMany -> n,n
     */
    @Nonnull
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_index", referencedColumnName = "u_index")
    private User user;

    @ManyToMany
    @JoinTable(name = "Message_Tag",
            joinColumns = @JoinColumn(name = "message_index", referencedColumnName = "m_index", table = "Message"),
            inverseJoinColumns = @JoinColumn(name = "tag_index", referencedColumnName = "t_index", table = "Tag"))
    private List<Tag> tags;



    // GETTER AND SETTER



    public UUID getMessage_index() {
        return message_index;
    }

    public void setMessage_index(UUID message_index) {
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

    @Nonnull
    public User getUser() {
        return user;
    }

    public void setUser(@Nonnull User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}