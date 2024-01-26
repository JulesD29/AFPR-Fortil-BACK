package group.fortil.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Messages")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_index")
    private Long tag_index;

    @Column(name = "value")
    private String value;

    @ManyToMany
    @JoinTable(name = "Messages_Tags", joinColumns = @JoinColumn(name = "tag_index"), inverseJoinColumns = @JoinColumn(name = "message_index"))
    private List<Messages> messages = new ArrayList<>();




    public Long getTag_index() {
        return tag_index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}