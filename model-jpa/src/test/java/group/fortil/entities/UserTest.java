package group.fortil.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {group.fortil.JpaConfiguration.class})
public class UserTest {

    @Test
    public void givenUserObjectAndUserId_whenSetUserIdToUserObject_thenReturnUserIdWithGetMethod() {
        // Given
        Long expectedUserIndex = 123L;
        User user = new User();

        // When
        user.setUser_index(expectedUserIndex);

        // Then
        assertEquals(expectedUserIndex, user.getUser_index());
    }

    @Test
    public void givenUserObjectAndUserFirstName_whenSetUserFirstNameToUserObject_thenReturnUserFirstNameWithGetMethod() {
        // Given
        String expectedFirstName = "John";
        User user = new User();

        // When
        user.setFirstName(expectedFirstName);

        // Then
        assertEquals(expectedFirstName, user.getFirstName());
    }

    @Test
    public void givenUserObjectAndUserLastName_whenSetUserLastNameToUserObject_thenReturnUserLastNameWithGetMethod() {
        // Given
        String expectedLastName = "Doe";
        User user = new User();

        // When
        user.setLastName(expectedLastName);

        // Then
        assertEquals(expectedLastName, user.getLastName());
    }

    @Test
    public void givenUserObjectAndUserMail_whenSetUserMailToUserObject_thenReturnUserMailWithGetMethod() {
        // Given
        String expectedMail = "test@example.com";
        User user = new User();

        // When
        user.setMail(expectedMail);

        // Then
        assertEquals(expectedMail, user.getMail());
    }

    @Test
    public void givenUserObjectAndUserPassword_whenSetUserPasswordToUserObject_thenReturnUserPasswordWithGetMethod() {
        // Given
        String expectedPassword = "password123";
        User user = new User();

        // When
        user.setPassword(expectedPassword);

        // Then
        assertEquals(expectedPassword, user.getPassword());
    }
}

