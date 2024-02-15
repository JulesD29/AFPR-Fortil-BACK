package group.fortil.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {group.fortil.JpaConfiguration.class})
public class MessageTest {

    @Test
    public void givenMessageObjectAndMessageId_whenSetMessageIdToMessageObject_thenReturnMessageIdWithGetMethod() {
        // Given
        Long expectedMessageIndex = 123L;
        Message message = new Message();

        // When
        message.setMessage_index(expectedMessageIndex);

        // Then
        assertEquals(expectedMessageIndex, message.getMessage_index());
    }

    @Test
    public void givenMessageObjectAndMessageValue_whenSetMessageValueToMessageObject_thenReturnMessageValueWithGetMethod() {
        // Given
        String expectedValue = "Test Message";
        Message message = new Message();

        // When
        message.setValue(expectedValue);

        // Then
        assertEquals(expectedValue, message.getValue());
    }

    @Test
    public void givenMessageObjectAndCreationDate_whenSetCreationDateToMessageObject_thenReturnCreationDateWithGetMethod() {
        // Given
        Date expectedCreationDate = new Date();
        Message message = new Message();

        // When
        message.setCreation_date(expectedCreationDate);

        // Then
        assertEquals(expectedCreationDate, message.getCreation_date());
    }

    @Test
    public void givenMessageObjectAndModificationDate_whenSetModificationDateToMessageObject_thenReturnModificationDateWithGetMethod() {
        // Given
        Date expectedModificationDate = new Date();
        Message message = new Message();

        // When
        message.setModification_date(expectedModificationDate);

        // Then
        assertEquals(expectedModificationDate, message.getModification_date());
    }

    @Test
    public void givenMessageObjectAndUserObject_whenSetUserObjectToMessageObject_thenReturnUserObjectWithGetMethod() {
        // Given
        User expectedUser = new User();
        Message message = new Message();

        // When
        message.setUser(expectedUser);

        // Then
        assertEquals(expectedUser, message.getUser());
    }

    @Test
    public void givenMessageObjectAndListOfTags_whenSetListOfTagsToMessageObject_thenReturnListOfTagsWithGetMethod() {
        // Given
        List<Tag> expectedTags = List.of(new Tag(), new Tag());
        Message message = new Message();

        // When
        message.setTags(expectedTags);

        // Then
        assertEquals(expectedTags, message.getTags());
    }
}

