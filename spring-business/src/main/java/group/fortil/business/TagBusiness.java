package group.fortil.business;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class TagBusiness implements ITagBusiness {

    @PositiveOrZero(message = "tag_index cannot be negative or null")
    private Long tag_index;

    @NotBlank(message = "Tag blank")
    private String value;

    public TagBusiness(){}
    public TagBusiness(String value) {
        this.value = value;
    }
    public TagBusiness(Long tag_index, String value) {
        this.tag_index = tag_index;
        this.value = value;
    }


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
