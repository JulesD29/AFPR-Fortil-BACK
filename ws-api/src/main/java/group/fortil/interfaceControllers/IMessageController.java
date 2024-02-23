package group.fortil.interfaceControllers;

import group.fortil.business.MessageBusiness;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("messages-api")
public interface IMessageController {

    @GetMapping("/messages")
    List<MessageBusiness> findAll();

    @GetMapping("/messages/{id}")
    ResponseEntity<MessageBusiness> findById(@PathVariable(value = "id") Long id);

    @GetMapping("/messages/user:{firstName}")
    List<MessageBusiness> findMessagesByUserFirstName(@PathVariable("firstName") String firstName);

    @PostMapping("/messages")
    MessageBusiness create(@Valid @RequestBody MessageBusiness messageBusiness);

    @PutMapping("/messages/{id}")
    ResponseEntity<MessageBusiness> update(@PathVariable(value = "id") Long id, @Valid @RequestBody MessageBusiness messageBusiness);

    @DeleteMapping("/messages/{id}")
    Map<String, Boolean> deleteById(@PathVariable(value = "id") Long id);
}
