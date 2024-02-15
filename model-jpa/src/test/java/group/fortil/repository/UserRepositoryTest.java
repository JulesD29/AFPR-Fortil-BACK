package group.fortil.repository;

import group.fortil.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {group.fortil.JpaConfiguration.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserObject_whenUserFindById_thenReturnUserAttributes() {
        // Given
        User user = new User("John", "Doe", "john.doe@example.com", "password123");
        userRepository.save(user);

        // When
        User retrievedUser = userRepository.findById(user.getUser_index()).orElse(null);

        // Then
        assertNotNull(retrievedUser);
        assertEquals("John", retrievedUser.getFirstName());
        assertEquals("Doe", retrievedUser.getLastName());
        assertEquals("john.doe@example.com", retrievedUser.getMail());
        assertEquals("password123", retrievedUser.getPassword());
    }

}
