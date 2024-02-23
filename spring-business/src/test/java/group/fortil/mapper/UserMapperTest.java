package group.fortil.mapper;


import group.fortil.business.UserBusiness;
import group.fortil.entities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UserMapperTest {

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void givenUserObject_whenMapUserToUserBusiness_ReturnComparisonBetweenUserAttributesAndUserBusinessAttributes() {
        // Given
        User user = new User(123L, "John", "Doe", "john.doe@example.com", "password123", "ROLE_TEST");

        // When
        UserBusiness userBusiness = userMapper.userToUserBusiness(user);

        // Then
        assertNotNull(userBusiness);
        assertEquals(user.getUser_index(), userBusiness.getUser_index());
        assertEquals(user.getFirstName(), userBusiness.getFirstName());
        assertEquals(user.getLastName(), userBusiness.getLastName());
        assertEquals(user.getMail(), userBusiness.getMail());
        assertEquals(user.getPassword(), userBusiness.getPassword());
    }

    @Test
    public void givenUserBusinessObject_whenMapUserBusinessToUser_ReturnComparisonBetweenUserBusinessAttributesAndUserAttributes() {
        // Given
        UserBusiness userBusiness = new UserBusiness(123L, "John", "Doe", "john.doe@example.com", "password123", "ROLE_TEST");

        // When
        User user = userMapper.userBusinessToUser(userBusiness);

        // Then
        assertNotNull(user);
        assertEquals(userBusiness.getUser_index(), user.getUser_index());
        assertEquals(userBusiness.getFirstName(), user.getFirstName());
        assertEquals(userBusiness.getLastName(), user.getLastName());
        assertEquals(userBusiness.getMail(), user.getMail());
        assertEquals(userBusiness.getPassword(), user.getPassword());
    }

}
