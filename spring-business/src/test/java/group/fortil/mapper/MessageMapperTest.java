package group.fortil.mapper;

import group.fortil.business.MessageBusiness;
import group.fortil.business.UserBusiness;
import group.fortil.entities.Message;
import group.fortil.entities.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class MessageMapperTest {

    private final MessageMapper messageMapper = MessageMapper.INSTANCE;

    @Test
    public void givenMessageObject_whenMapMessageToMessageBusiness_ReturnComparisonBetweenMessageAttributesAndMessageBusinessAttributes() {
        // Given
        Message message = new Message(123L, "Test Message", new Date(), new User());

        // When
        MessageBusiness messageBusiness = messageMapper.messageToMessageBusiness(message);

        // Then
        assertNotNull(messageBusiness);
        assertEquals(message.getMessage_index(), messageBusiness.getMessage_index());
        assertEquals(message.getValue(), messageBusiness.getValue());
        assertEquals(message.getCreation_date(), messageBusiness.getCreation_date());
        assertEquals(message.getModification_date(), messageBusiness.getModification_date());
        assertNotNull(messageBusiness.getUser());
        assertEquals(message.getUser().getUser_index(), messageBusiness.getUser().getUser_index());
    }

    @Test
    public void givenMessageBusinessObject_whenMapMessageBusinessToMessage_ReturnComparisonBetweenMessageBusinessAttributesAndMessagesAttributes() {
        // Given
        MessageBusiness messageBusiness = new MessageBusiness(123L, "Test Message", new Date(), new UserBusiness());

        // When
        Message message = messageMapper.messageBusinessToMessage(messageBusiness);

        // Then
        assertNotNull(message);
        assertEquals(messageBusiness.getMessage_index(), message.getMessage_index());
        assertEquals(messageBusiness.getValue(), message.getValue());
        assertEquals(messageBusiness.getCreation_date(), message.getCreation_date());
        assertEquals(messageBusiness.getModification_date(), message.getModification_date());
        assertNotNull(message.getUser());
        assertEquals(messageBusiness.getUser().getUser_index(), message.getUser().getUser_index());
    }


}
