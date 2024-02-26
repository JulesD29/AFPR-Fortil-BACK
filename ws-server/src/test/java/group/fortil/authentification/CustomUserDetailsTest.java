package group.fortil.authentification;

import group.fortil.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsTest {

    @Test
    void givenOriginalUserAndPassword_whenCreateCustomUserDetails_thenReturnAllDetailsAboutUser() {
        // Given
        User user = new User();
        user.setFirstName("testUser");
        user.setPassword("testPassword");
        user.setRole("ROLE_USER");

        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        when(passwordEncoder.encode("testPassword")).thenReturn("encodedPassword");

        // When
        CustomUserDetails userDetails = new CustomUserDetails(user, passwordEncoder);

        // Then
        assertEquals("testUser", userDetails.getUsername());
        assertEquals("encodedPassword", userDetails.getPassword());
        assertEquals("ROLE_USER", userDetails.getAuthorities().iterator().next().getAuthority());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isEnabled());
    }
}
