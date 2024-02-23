package group.fortil.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserBusinessTest {

    @Test
    public void givenUserBusinessObjectAndUserId_whenSetUserIdToUserBusinessObject_thenReturnUserIdWithGetMethod() {
        // Given
        Long expectedUserBusinessIndex = 123L;
        UserBusiness userBusiness = new UserBusiness();

        // When
        userBusiness.setUser_index(expectedUserBusinessIndex);

        // Then
        assertEquals(expectedUserBusinessIndex, userBusiness.getUser_index());
    }

    @Test
    public void givenUserBusinessObjectAndUserFirstName_whenSetUserFirstNameToUserBusinessObject_thenReturnUserFirstNameWithGetMethod() {
        // Given
        String expectedFirstName = "John";
        UserBusiness userBusiness = new UserBusiness();

        // When
        userBusiness.setFirstName(expectedFirstName);

        // Then
        assertEquals(expectedFirstName, userBusiness.getFirstName());
    }

    @Test
    public void givenUserBusinessObjectAndUserLastName_whenSetUserLastNameToUserBusinessObject_thenReturnUserLastNameWithGetMethod() {
        // Given
        String expectedLastName = "Doe";
        UserBusiness userBusiness = new UserBusiness();

        // When
        userBusiness.setLastName(expectedLastName);

        // Then
        assertEquals(expectedLastName, userBusiness.getLastName());
    }

    @Test
    public void givenUserBusinessObjectAndUserMail_whenSetUserMailToUserBusinessObject_thenReturnUserMailWithGetMethod() {
        // Given
        String expectedMail = "test@example.com";
        UserBusiness userBusiness = new UserBusiness();

        // When
        userBusiness.setMail(expectedMail);

        // Then
        assertEquals(expectedMail, userBusiness.getMail());
    }

    @Test
    public void givenUserBusinessObjectAndUserPassword_whenSetUserPasswordToUserBusinessObject_thenReturnUserPasswordWithGetMethod() {
        // Given
        String expectedPassword = "password123";
        UserBusiness userBusiness = new UserBusiness();

        // When
        userBusiness.setPassword(expectedPassword);

        // Then
        assertEquals(expectedPassword, userBusiness.getPassword());
    }

    @Test
    public void givenUserBusinessObjectAndUserRole_whenSetUserRoleToUserBusinessObject_thenReturnUserRoleWithGetMethod() {
        // Given
        String expectedRole = "ROLE_TEST";
        UserBusiness userBusiness = new UserBusiness();

        // When
        userBusiness.setRole(expectedRole);

        // Then
        assertEquals(expectedRole, userBusiness.getRole());
    }
}
