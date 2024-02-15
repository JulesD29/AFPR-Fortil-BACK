package group.fortil.mapper;

import group.fortil.business.TagBusiness;
import group.fortil.entities.Tag;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TagMapperTest {

    private final TagMapper tagMapper = TagMapper.INSTANCE;

    @Test
    public void givenTagObject_whenMapTagToTagBusiness_ReturnComparisonBetweenTagAttributesAndTagBusinessAttributes() {
        // Given
        Tag tag = new Tag(123L, "Test value");

        // When
        TagBusiness tagBusiness = tagMapper.tagToTagBusiness(tag);

        // Then
        assertNotNull(tagBusiness);
        assertEquals(tag.getTag_index(), tagBusiness.getTag_index());
        assertEquals(tag.getValue(), tagBusiness.getValue());
    }

    @Test
    public void givenTagBusinessObject_whenMapTagBusinessToTag_ReturnComparisonBetweenTagBusinessAttributesAndTagAttributes() {
        // Given
        TagBusiness tagBusiness = new TagBusiness(123L, "Test Value");

        // When
        Tag tag = tagMapper.tagBusinessToTag(tagBusiness);

        // Then
        assertNotNull(tag);
        assertEquals(tagBusiness.getTag_index(), tag.getTag_index());
        assertEquals(tagBusiness.getValue(), tag.getValue());
    }

}
