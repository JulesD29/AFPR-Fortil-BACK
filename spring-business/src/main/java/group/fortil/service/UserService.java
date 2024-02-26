package group.fortil.service;

import group.fortil.business.UserBusiness;
import group.fortil.entities.User;
import group.fortil.mapper.UserMapper;
import group.fortil.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class UserService implements IUserService<UserBusiness, Serializable> {

    @Autowired
    private UserRepository userRepository;
    // voir pour faire constructeur

    @Autowired
    private UserMapper userMapper;


    private List<User> mapListBusinessToModel(List<UserBusiness> usersBusiness) {
        return usersBusiness.stream().map(e -> userMapper.userBusinessToUser(e)).collect(Collectors.toList());
    }

    private List<UserBusiness> mapListModelToBusiness(List<User> usersBusiness) {
        return usersBusiness.stream().map(e -> userMapper.userToUserBusiness(e)).collect(Collectors.toList());
    }

    private UserBusiness saveModelFromBusiness(UserBusiness userBusiness) {
        return userMapper.userToUserBusiness(userRepository.save(userMapper.userBusinessToUser(userBusiness)));
    }


    @Override
    public UserBusiness create(@Valid UserBusiness userBusiness) {
        return saveModelFromBusiness(userBusiness);
    }

    @Override
    public UserBusiness update(@Valid UserBusiness userBusiness) {
        return saveModelFromBusiness(userBusiness);
    }

    @Override
    public void delete(UserBusiness userBusiness) {
        userRepository.delete(userMapper.userBusinessToUser(userBusiness));
    }

    @Override
    public Optional<UserBusiness> findById(Long id) {
        return userRepository.findById(id).map(model -> userMapper.userToUserBusiness(model));
    }

    @Override
    public List<UserBusiness> findAll() {
        return mapListModelToBusiness((List<User>) userRepository.findAll());
    }


    public UserBusiness findByUserName(String firstName) throws Exception {
        User user = userRepository.findByUserName(firstName);
        if (user == null) {
            throw new Exception("User not found: " + firstName);
        }
        return userMapper.userToUserBusiness(user);
    }

}
