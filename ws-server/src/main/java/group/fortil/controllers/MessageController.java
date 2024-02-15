package group.fortil.controllers;

import group.fortil.business.MessageBusiness;
import group.fortil.exceptions.CustomNotFoundException;
import group.fortil.interfaceControllers.IMessageController;
import group.fortil.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public ResponseEntity<MessageBusiness> findById(Long id)  {
        MessageBusiness messageBusiness = messageService.findById(id).orElseThrow(() -> new CustomNotFoundException("Message not found for this id ::" + id));
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
    public ResponseEntity<MessageBusiness> update(Long id, MessageBusiness messageDetails) {
        MessageBusiness message = messageService.findById(id).orElseThrow(() -> new CustomNotFoundException("Message not found for this id ::" + id));

        if(!Objects.equals(message.getUser().getUser_index(), messageDetails.getUser().getUser_index()))
            return ResponseEntity.badRequest().body(messageDetails); // User who tries to modify is not the one who creates the message !

        message.setValue(messageDetails.getValue());
        message.setModification_date(new Date());
        //message.setUser(messageDetails.getUser());

        MessageBusiness updatedMessage = messageService.update(message);
        return ResponseEntity.ok(updatedMessage);

    }

    @Override
    @DeleteMapping("/messages/{id}")
    public Map<String, Boolean> deleteById(Long id)  {
        MessageBusiness message = messageService.findById(id).orElseThrow(() -> new CustomNotFoundException("Message not found for this id ::" + id));

        messageService.delete(message);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
