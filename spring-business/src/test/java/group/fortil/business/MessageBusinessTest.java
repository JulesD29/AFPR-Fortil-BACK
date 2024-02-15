package group.fortil.business;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MessageBusinessTest {


    @Test
    public void givenMessageBusinessObjectAndMessageId_whenSetMessageIdToMessageBusinessObject_thenReturnMessageIdWithGetMethod() {
        // Given
        Long expectedMessageIndex = 123L;
        MessageBusiness messageBusiness = new MessageBusiness();

        // When
        messageBusiness.setMessage_index(expectedMessageIndex);

        // Then
        assertEquals(expectedMessageIndex, messageBusiness.getMessage_index());
    }

    @Test
    public void givenMessageBusinessObjectAndMessageValue_whenSetMessageBusinessValueToMessageObject_thenReturnMessageValueWithGetMethod() {
        // Given
        String expectedValue = "Test Message";
        MessageBusiness messageBusiness = new MessageBusiness();

        // When
        messageBusiness.setValue(expectedValue);

        // Then
        assertEquals(expectedValue, messageBusiness.getValue());
    }

    @Test
    public void givenMessageBusinessObjectAndCreationDate_whenSetCreationDateToMessageBusinessObject_thenReturnCreationDateWithGetMethod() {
        // Given
        Date expectedCreationDate = new Date();
        MessageBusiness messageBusiness = new MessageBusiness();

        // When
        messageBusiness.setCreation_date(expectedCreationDate);

        // Then
        assertEquals(expectedCreationDate, messageBusiness.getCreation_date());
    }

    @Test
    public void givenMessageBusinessObjectAndModificationDate_whenSetModificationDateToMessageBusinessObject_thenReturnModificationDateWithGetMethod() {
        // Given
        Date expectedModificationDate = new Date();
        MessageBusiness messageBusiness = new MessageBusiness();

        // When
        messageBusiness.setModification_date(expectedModificationDate);

        // Then
        assertEquals(expectedModificationDate, messageBusiness.getModification_date());
    }

    @Test
    public void givenMessageBusinessObjectAndUserBusinessObject_whenSetUserBusinessObjectToMessageBusinessObject_thenReturnUserBusinessObjectWithGetMethod() {
        // Given
        UserBusiness expectedUser = new UserBusiness();
        MessageBusiness messageBusiness = new MessageBusiness();

        // When
        messageBusiness.setUser(expectedUser);

        // Then
        assertEquals(expectedUser, messageBusiness.getUser());
    }

    @Test
    public void givenMessageBusinessObjectAndListOfTagsBusiness_whenSetListOfTagsBusinessToMessageBusinessObject_thenReturnListOfTagsBusinessWithGetMethod() {
        // Given
        List<TagBusiness> expectedTags = List.of(new TagBusiness(), new TagBusiness());
        MessageBusiness messageBusiness = new MessageBusiness();

        // When
        messageBusiness.setTagsBusiness(expectedTags);

        // Then
        assertEquals(expectedTags, messageBusiness.getTagsBusiness());
    }

}
