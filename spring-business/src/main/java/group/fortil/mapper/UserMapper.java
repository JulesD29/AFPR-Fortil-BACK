package group.fortil.mapper;


import group.fortil.business.UserBusiness;
import group.fortil.entities.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /*
    @Mapping(source = "user.user_index", target = "user_index")
    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "user.mail", target = "mail")
    @Mapping(source = "user.password", target = "password")
    */
    UserBusiness userToUserBusiness(User user);


    /*
    @Mapping(source = "userBusiness.user_index", target = "user_index")
    @Mapping(source = "userBusiness.firstName", target = "firstName")
    @Mapping(source = "userBusiness.lastName", target = "lastName")
    @Mapping(source = "userBusiness.mail", target = "mail")
    @Mapping(source = "userBusiness.password", target = "password")
    */
    User userBusinessToUser(UserBusiness userBusiness);

}
