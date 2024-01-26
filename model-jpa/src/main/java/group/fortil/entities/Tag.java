package group.fortil.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "t_index")
    private UUID tag_index;

    @Column(name = "value")
    private String value;




    // GETTER AND SETTER


    public UUID getTag_index() {
        return tag_index;
    }

    public void setTag_index(UUID tag_index) {
        this.tag_index = tag_index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}