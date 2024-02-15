package group.fortil.service;

import group.fortil.business.MessageBusiness;
import group.fortil.entities.Message;
import group.fortil.mapper.MessageMapper;
import group.fortil.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private MessageMapper messageMapper;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenMessageBusiness_whenCreateNewMessage_thenReturnMessageBusinessEnteredInParameters() {
        // Given
        MessageBusiness inputBusiness = new MessageBusiness();
        Message inputMessage = new Message();

        // When
        when(messageMapper.messageBusinessToMessage(inputBusiness)).thenReturn(inputMessage);
        when(messageRepository.save(inputMessage)).thenReturn(inputMessage);
        when(messageMapper.messageToMessageBusiness(inputMessage)).thenReturn(inputBusiness);
        MessageBusiness result = messageService.create(inputBusiness);

        // Then
        assertEquals(inputBusiness, result);
        verify(messageRepository, times(1)).save(inputMessage);
    }

    @Test
    public void givenMessageBusiness_whenUpdateMessage_thenReturnMessageBusinessUpdated() {
        // Given
        MessageBusiness inputBusiness = new MessageBusiness();
        Message inputMessage = new Message();

        // When
        when(messageMapper.messageBusinessToMessage(inputBusiness)).thenReturn(inputMessage);
        when(messageRepository.save(inputMessage)).thenReturn(inputMessage);
        when(messageMapper.messageToMessageBusiness(inputMessage)).thenReturn(inputBusiness);
        MessageBusiness result = messageService.update(inputBusiness);

        // Then
        assertEquals(inputBusiness, result);
        verify(messageRepository, times(1)).save(inputMessage);
    }

    @Test
    public void givenListOfAllMessages_whenFindAll_thenReturnAllMessages() {
        // Given
        List<Message> messageList = Collections.singletonList(new Message());

        // When
        when(messageRepository.findAll()).thenReturn(messageList);

        // Then
        List<MessageBusiness> result = messageService.findAll();
        assertEquals(messageList.size(), result.size());
    }

    @Test
    public void givenMessageBusinessWhoWillBeDeleted_whenDeleteMessageBusiness_thenReturnNothing() {
        // Given
        MessageBusiness inputBusiness = new MessageBusiness();
        Message inputMessage = new Message();

        // When
        when(messageMapper.messageBusinessToMessage(inputBusiness)).thenReturn(inputMessage);
        messageService.delete(inputBusiness);

        // Then
        verify(messageRepository, times(1)).delete(inputMessage);
    }

    @Test
    public void givenMessageIdentifier_whenFindById_thenReturnMessageAssociatedToThisId() {
        // Given
        Long id = 1L;
        Message message = new Message();
        MessageBusiness expectedBusiness = new MessageBusiness();

        // When
        when(messageRepository.findById(id)).thenReturn(Optional.of(message));
        when(messageMapper.messageToMessageBusiness(message)).thenReturn(expectedBusiness);
        Optional<MessageBusiness> result = messageService.findById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals(expectedBusiness, result.get());
    }


}

