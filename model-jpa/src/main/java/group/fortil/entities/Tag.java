package group.fortil.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_index")
    private Long tag_index;

    @Column(name = "value")
    private String value;


    public Tag(){}
    public Tag(Long tag_index, String value) {
        this.tag_index = tag_index;
        this.value = value;
    }

    // GETTER AND SETTER


    public Long getTag_index() {
        return tag_index;
    }

    public void setTag_index(Long tag_index) {
        this.tag_index = tag_index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}