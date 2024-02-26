package group.fortil.authentification;

import group.fortil.entities.User;
import group.fortil.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private CustomUserDetailsService userDetailsService;

    @Test
    void givenFirstName_whenLoadUserByFirstName_thenReturnAssociatedUser() {
        // Given
        String firstName = "john";
        String password = "password";
        User user = new User();
        user.setFirstName(firstName);
        user.setPassword(password);
        when(userRepository.findByUserName(firstName)).thenReturn(user);
        when(passwordEncoder.encode(password)).thenReturn(password);

        // When
        UserDetails userDetails = userDetailsService.loadUserByUsername(firstName);

        // Then
        assertEquals(firstName, userDetails.getUsername());
        assertEquals(password, userDetails.getPassword());
    }

    @Test
    void givenFirstName_whenLoadUserByFirstName_thenReturnErrorUserNotFound() {
        // Given
        String username = "nonexistent";

        // When/Then
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(username));
    }
}

