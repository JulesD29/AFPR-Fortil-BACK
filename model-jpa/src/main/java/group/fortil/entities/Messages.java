package group.fortil.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_index")
    private Long message_index;

    @Column(name = "value")
    private String value;

    @Column(name = "creation_date")
    private String creation_date;

    @Column(name = "modification_date")
    private String modification_date;

    @ManyToOne
    @JoinColumn(name = "user_index")
    private Users user_index;




    public Long getMessage_index() {
        return message_index;
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

}