package group.fortil.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TagBusinessTest {

    @Test
    public void givenTagBusinessObjectAndTagId_whenSetTagIdToTagBusinessObject_thenReturnTagIdWithGetMethod() {
        // Given
        Long expectedTagIndex = 123L;
        TagBusiness tagBusiness = new TagBusiness();

        // When
        tagBusiness.setTag_index(expectedTagIndex);

        // Then
        assertEquals(expectedTagIndex, tagBusiness.getTag_index());
    }

    @Test
    public void givenTagBusinessObjectAndTagValue_whenSetTagValueToTagObject_thenReturnTagValueWithGetMethod() {
        // Given
        String expectedValue = "Test Tag";
        TagBusiness tagBusiness = new TagBusiness();

        // When
        tagBusiness.setValue(expectedValue);

        // Then
        assertEquals(expectedValue, tagBusiness.getValue());
    }

}
