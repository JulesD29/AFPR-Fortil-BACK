package group.fortil.mapper;

import group.fortil.business.MessageBusiness;
import group.fortil.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);


    /*
    @Mapping(source = "message.message_index", target = "message_index")
    @Mapping(source = "message.value", target = "value")
    @Mapping(source = "message.creation_date", target = "creation_date")
    @Mapping(source = "message.modification_date", target = "modification_date")
    @Mapping(source = "message.user", target = "user")
    */
    MessageBusiness messageToMessageBusiness(Message message);

    /*
    @Mapping(source = "messageBusiness.message_index", target = "message_index")
    @Mapping(source = "messageBusiness.value", target = "value")
    @Mapping(source = "messageBusiness.creation_date", target = "creation_date")
    @Mapping(source = "messageBusiness.modification_date", target = "modification_date")
    @Mapping(source = "messageBusiness.user", target = "user")
    */
    Message messageBusinessToMessage(MessageBusiness messageBusiness);

}
