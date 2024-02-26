package group.fortil.service;

import group.fortil.business.UserBusiness;
import group.fortil.entities.User;
import group.fortil.mapper.UserMapper;
import group.fortil.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private UserBusiness userBusiness;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void givenUserBusiness_whenCreateNewUser_thenReturnUserBusinessEnteredInParameters() {
        // Given
        UserBusiness inputBusiness = new UserBusiness();
        User inputUser = new User();

        // When
        when(userMapper.userBusinessToUser(inputBusiness)).thenReturn(inputUser);
        when(userRepository.save(inputUser)).thenReturn(inputUser);
        when(userMapper.userToUserBusiness(inputUser)).thenReturn(inputBusiness);
        UserBusiness result = userService.create(inputBusiness);

        // Then
        assertEquals(inputBusiness, result);
        verify(userRepository, times(1)).save(inputUser);
    }

    @Test
    public void givenUserBusiness_whenUpdateUser_thenReturnUserBusinessUpdated() {
        // Given
        UserBusiness inputBusiness = new UserBusiness();
        User inputUser = new User();

        // When
        when(userMapper.userBusinessToUser(inputBusiness)).thenReturn(inputUser);
        when(userRepository.save(inputUser)).thenReturn(inputUser);
        when(userMapper.userToUserBusiness(inputUser)).thenReturn(inputBusiness);
        UserBusiness result = userService.update(inputBusiness);

        // Then
        assertEquals(inputBusiness, result);
        verify(userRepository, times(1)).save(inputUser);
    }

    @Test
    public void givenListOfAllUsers_whenFindAll_thenReturnAllUsers() {
        // Given
        List<User> userList = Collections.singletonList(new User());

        // When
        when(userRepository.findAll()).thenReturn(userList);

        // Then
        List<UserBusiness> result = userService.findAll();
        assertEquals(userList.size(), result.size());
    }

    @Test
    public void givenUserBusinessWhoWillBeDeleted_whenDeleteUserBusiness_thenReturnNothing() {
        // Given
        UserBusiness inputBusiness = new UserBusiness();
        User inputUser = new User();

        // When
        when(userMapper.userBusinessToUser(inputBusiness)).thenReturn(inputUser);
        userService.delete(inputBusiness);

        // Then
        verify(userRepository, times(1)).delete(inputUser);
    }

    @Test
    public void givenUserIdentifier_whenFindById_thenReturnUserAssociatedToThisId() {
        // Given
        Long id = 1L;
        User user = new User();
        UserBusiness expectedBusiness = new UserBusiness();

        // When
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userMapper.userToUserBusiness(user)).thenReturn(expectedBusiness);
        Optional<UserBusiness> result = userService.findById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals(expectedBusiness, result.get());
    }

    @Test
    void givenUserObjectAndFirstName_whenFindUserByUserName_returnCorrectUser() throws Exception {
        // Given
        String username = "testUser";
        User user = new User();
        user.setFirstName(username);

        when(userRepository.findByUserName(username)).thenReturn(user);

        // When
        User resultUser = userRepository.findByUserName(username);

        // Then
        assertEquals(user, resultUser);
    }


}

