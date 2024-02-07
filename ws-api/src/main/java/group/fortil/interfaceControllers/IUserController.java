package group.fortil.interfaceControllers;


import group.fortil.business.UserBusiness;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users-api")
public interface IUserController {

    @GetMapping("/users")
    List<UserBusiness> findAll();

    @GetMapping("/users/{id}")
    ResponseEntity<UserBusiness> findById(@PathVariable(value = "id") Long id);

    @PostMapping("/users")
    UserBusiness create(@Valid @RequestBody UserBusiness userBusiness);

    @PutMapping("/users/{id}")
    ResponseEntity<UserBusiness> update(@PathVariable(value = "id") Long id, @Valid @RequestBody UserBusiness userBusiness);

    @DeleteMapping("/users/{id}")
    Map<String, Boolean> deleteById(@PathVariable(value = "id") Long id);
    
}
