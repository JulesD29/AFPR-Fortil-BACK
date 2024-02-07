package group.fortil.controllers;

import group.fortil.business.UserBusiness;
import group.fortil.interfaceControllers.IUserController;
import group.fortil.service.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users-api")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;


    @Override
    @GetMapping("/users")
    public List<UserBusiness> findAll() {
        return userService.findAll();
    }

    @Override
    @GetMapping("/users/{id}")
    public ResponseEntity<UserBusiness> findById(Long id) throws ResourceNotFoundException {
        UserBusiness userBusiness = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id ::" + id));
        return ResponseEntity.ok().body(userBusiness);    }

    @Override
    @PostMapping("/users")
    public UserBusiness create(UserBusiness userBusiness) {
        return userService.create(userBusiness);
    }

    @Override
    @PutMapping("/users/{id}")
    public ResponseEntity<UserBusiness> update(Long id, UserBusiness userDetails) throws ResourceNotFoundException {
        UserBusiness user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setMail(userDetails.getMail());
        user.setPassword(userDetails.getPassword());
        final UserBusiness updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteById(Long id) {
        UserBusiness user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userService.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
