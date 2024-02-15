package group.fortil.controllers;

import group.fortil.business.UserBusiness;
import group.fortil.exceptions.CustomNotFoundException;
import group.fortil.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<UserBusiness> userList = Arrays.asList(
                new UserBusiness(1L, "John", "Doe", "john@example.com", "password1"),
                new UserBusiness(2L, "Jane", "Doe", "jane@example.com", "password2")
        );
        when(userService.findAll()).thenReturn(userList);

        // When
        List<UserBusiness> result = userController.findAll();

        // Then
        assertNotNull(result);
        assertEquals(userList.size(), result.size());
        assertEquals(userList, result);
    }

    @Test
    public void testFindById_Success() {
        // Given
        Long userId = 1L;
        UserBusiness user = new UserBusiness(userId, "John", "Doe", "john@example.com", "password");
        when(userService.findById(userId)).thenReturn(Optional.of(user));

        // When
        ResponseEntity<UserBusiness> responseEntity = userController.findById(userId);

        // Then
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCode().value());
        assertNotNull(responseEntity.getBody());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void testFindById_NotFound() {
        // Given
        Long userId = 1L;
        when(userService.findById(userId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(CustomNotFoundException.class, () -> userController.findById(userId));
    }

    @Test
    public void testCreate() {
        // Given
        UserBusiness newUser = new UserBusiness(null, "John", "Doe", "john@example.com", "password");
        UserBusiness savedUser = new UserBusiness(1L, "John", "Doe", "john@example.com", "password");
        when(userService.create(newUser)).thenReturn(savedUser);

        // When
        UserBusiness result = userController.create(newUser);

        // Then
        assertNotNull(result);
        assertEquals(savedUser, result);
    }

    @Test
    public void testUpdate_Success() {
        // Given
        Long userId = 1L;
        UserBusiness existingUser = new UserBusiness(userId, "Jane", "Doe", "jane@example.com", "password");
        UserBusiness updatedUser = new UserBusiness(userId, "John", "Doe", "john@example.com", "password");


        when(userService.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userService.update(existingUser)).thenReturn(updatedUser);

        // When
        ResponseEntity<UserBusiness> response = userController.update(userId, updatedUser);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());
    }

    @Test
    public void testUpdate_NotFound() {
        // Given
        Long userId = 1L;
        UserBusiness userDetails = new UserBusiness(null, "John", "Doe", "john@example.com", "password");
        when(userService.findById(userId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(CustomNotFoundException.class, () -> userController.update(userId, userDetails));
    }

    @Test
    public void testDeleteById() {
        // Given
        Long userId = 1L;
        UserBusiness existingUser = new UserBusiness(userId, "John", "Doe", "john@example.com", "password");
        when(userService.findById(userId)).thenReturn(Optional.of(existingUser));

        // When
        Map<String, Boolean> response = userController.deleteById(userId);

        // Then
        assertNotNull(response);
        assertTrue(response.containsKey("deleted"));
        assertTrue(response.get("deleted"));
    }
}
