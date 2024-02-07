package group.fortil.controllers;

import group.fortil.business.MessageBusiness;
import group.fortil.interfaceControllers.IMessageController;
import group.fortil.service.MessageService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("messages-api")
public class MessageController implements IMessageController {

    @Autowired
    private MessageService messageService;

    @Override
    @GetMapping("/messages")
    public List<MessageBusiness> findAll() {
        return messageService.findAll();
    }

    @Override
    @GetMapping("/messages/{id}")
    public ResponseEntity<MessageBusiness> findById(Long id) throws ResourceNotFoundException {
        MessageBusiness messageBusiness = messageService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found for this id ::" + id));
        return ResponseEntity.ok().body(messageBusiness);
    }

    @Override
    @PostMapping("/messages")
    public MessageBusiness create(MessageBusiness messageBusiness) {
        messageBusiness.setCreation_date(new Date());
        return messageService.create(messageBusiness);
    }

    @Override
    @PutMapping("/messages/{id}")
    public ResponseEntity<MessageBusiness> update(Long id, MessageBusiness messageDetails) throws ResourceNotFoundException {
        MessageBusiness message = messageService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found"));

        message.setValue(messageDetails.getValue());
        message.setModification_date(new Date());
        message.setUser(messageDetails.getUser());

        MessageBusiness updatedMessage = messageService.update(message);
        return ResponseEntity.ok(updatedMessage);

    }

    @Override
    @DeleteMapping("/messages/{id}")
    public Map<String, Boolean> deleteById(Long id) throws ResourceNotFoundException {
        MessageBusiness message = messageService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found"));

        messageService.delete(message);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
