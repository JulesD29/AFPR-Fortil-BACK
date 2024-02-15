package group.fortil.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {group.fortil.JpaConfiguration.class})
public class TagTest {

    @Test
    public void givenTagObjectAndTagId_whenSetTagIdToTagObject_thenReturnTagIdWithGetMethod() {
        // Given
        Long expectedTagIndex = 123L;
        Tag tag = new Tag();

        // When
        tag.setTag_index(expectedTagIndex);

        // Then
        assertEquals(expectedTagIndex, tag.getTag_index());
    }

    @Test
    public void givenTagObjectAndTagValue_whenSetTagValueToTagObject_thenReturnTagValueWithGetMethod() {
        // Given
        String expectedValue = "Test Value";
        Tag tag = new Tag();

        // When
        tag.setValue(expectedValue);

        // Then
        assertEquals(expectedValue, tag.getValue());
    }

}

