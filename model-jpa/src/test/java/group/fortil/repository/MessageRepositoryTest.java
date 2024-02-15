package group.fortil.repository;

import group.fortil.entities.Message;
import group.fortil.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {group.fortil.JpaConfiguration.class})
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;


    // Just to test good implementation of CRUD methods ...
    @Test
    public void givenMessageObject_whenMessageFindById_thenReturnMessageAttributes() {
        // Given
        User user = new User("John", "Doe", "john.doe@example.com", "password123");
        userRepository.save(user);

        Message message = new Message("Test Message", new Date(), user);
        messageRepository.save(message);

        // When
        Message retrievedMessage = messageRepository.findById(message.getMessage_index()).orElse(null);

        // Then
        assertNotNull(retrievedMessage);
        assertEquals("Test Message", retrievedMessage.getValue());
        assertNotNull(retrievedMessage.getCreation_date());
        assertEquals(user, retrievedMessage.getUser());
    }

}
