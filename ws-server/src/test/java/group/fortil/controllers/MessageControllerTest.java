package group.fortil.controllers;

import group.fortil.business.MessageBusiness;
import group.fortil.business.UserBusiness;
import group.fortil.exceptions.CustomNotFoundException;
import group.fortil.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        UserBusiness userBusiness = new UserBusiness();
        List<MessageBusiness> messageList = Arrays.asList(
                new MessageBusiness(1L, "Message 1", new Date(), userBusiness),
                new MessageBusiness(2L, "Message 2", new Date(),  userBusiness)
        );
        when(messageService.findAll()).thenReturn(messageList);

        // When
        List<MessageBusiness> result = messageController.findAll();

        // Then
        assertNotNull(result);
        assertEquals(messageList.size(), result.size());
        assertEquals(messageList, result);
    }

    @Test
    public void testFindById_Success() {
        // Given
        long messageId = 1L;
        UserBusiness userBusiness = new UserBusiness();
        MessageBusiness message = new MessageBusiness(1L, "Message 1", new Date(), userBusiness);
        when(messageService.findById(messageId)).thenReturn(Optional.of(message));

        // When
        ResponseEntity<MessageBusiness> response = messageController.findById(messageId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void testFindById_NotFound() {
        // Given
        long messageId = 1L;
        when(messageService.findById(messageId)).thenReturn(Optional.empty());

        // When
        CustomNotFoundException exception = assertThrows(CustomNotFoundException.class, () -> messageController.findById(messageId));

        // Then
        assertNotNull(exception);
    }

    @Test
    public void testCreate() {
        // Given
        UserBusiness userBusiness = new UserBusiness();
        MessageBusiness newMessage = new MessageBusiness(1L, "Message 1", new Date(), userBusiness);
        when(messageService.create(newMessage)).thenReturn(newMessage);

        // When
        MessageBusiness createdMessage = messageController.create(newMessage);

        // Then
        assertNotNull(createdMessage);
        assertEquals(newMessage.getValue(), createdMessage.getValue());
        assertNotNull(createdMessage.getMessage_index());
    }

    @Test
    public void testUpdate_Success() {
        // Given
        long messageId = 1L;
        UserBusiness userBusiness = new UserBusiness();
        MessageBusiness existingMessage = new MessageBusiness(messageId, "Existing message", new Date(), userBusiness);
        MessageBusiness updatedMessage = new MessageBusiness(messageId, "Updated message", new Date(), userBusiness);

        when(messageService.findById(messageId)).thenReturn(Optional.of(existingMessage));
        when(messageService.update(existingMessage)).thenReturn(updatedMessage);

        // When
        ResponseEntity<MessageBusiness> response = messageController.update(messageId, updatedMessage);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedMessage, response.getBody());
    }

    @Test
    public void testUpdate_NotFound() {
        // Given
        long messageId = 1L;
        UserBusiness userBusiness = new UserBusiness();
        MessageBusiness updatedMessage = new MessageBusiness(messageId, "Updated message", new Date(), userBusiness);

        when(messageService.findById(messageId)).thenReturn(Optional.empty());

        // When
        CustomNotFoundException exception = assertThrows(CustomNotFoundException.class, () -> messageController.update(messageId, updatedMessage));

        // Then
        assertNotNull(exception);
    }

    @Test
    public void testDelete_Success() {
        // Given
        long messageId = 1L;
        UserBusiness userBusiness = new UserBusiness();
        MessageBusiness existingMessage = new MessageBusiness(messageId, "Existing message", new Date(), userBusiness);

        when(messageService.findById(messageId)).thenReturn(Optional.of(existingMessage));

        // When
        Map<String, Boolean> response = messageController.deleteById(messageId);

        // Then
        assertNotNull(response);
        assertTrue(response.get("deleted"));
    }

    @Test
    public void testDelete_NotFound() {
        // Given
        long messageId = 1L;
        when(messageService.findById(messageId)).thenReturn(Optional.empty());

        // When
        CustomNotFoundException exception = assertThrows(CustomNotFoundException.class, () -> messageController.deleteById(messageId));

        // Then
        assertNotNull(exception);
    }
}

