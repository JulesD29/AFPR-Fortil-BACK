package group.fortil.service;

import group.fortil.business.MessageBusiness;
import group.fortil.entities.Message;
import group.fortil.mapper.MessageMapper;
import group.fortil.repository.MessageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class MessageService implements IMessageService<MessageBusiness, Serializable> {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMapper messageMapper;

    private List<Message> mapListBusinessToModel(List<MessageBusiness> messageBusiness) {
        return messageBusiness.stream().map(e -> messageMapper.messageBusinessToMessage(e)).collect(Collectors.toList());
    }

    private List<MessageBusiness> mapListModelToBusiness(List<Message> messageModels) {
        return messageModels.stream().map(e -> messageMapper.messageToMessageBusiness(e)).collect(Collectors.toList());
    }

    private MessageBusiness saveModelFromBusiness(MessageBusiness messageBusiness) {
        return messageMapper.messageToMessageBusiness(messageRepository.save(messageMapper.messageBusinessToMessage(messageBusiness)));
    }




    @Override
    public MessageBusiness create(@Valid MessageBusiness messageBusiness) {
        return saveModelFromBusiness(messageBusiness);
    }

    @Override
    public MessageBusiness update(@Valid MessageBusiness messageBusiness) {
        return saveModelFromBusiness(messageBusiness);
    }

    @Override
    public void delete(MessageBusiness messageBusiness) {
        messageRepository.delete(messageMapper.messageBusinessToMessage(messageBusiness));
    }

    @Override
    public Optional<MessageBusiness> findById(Long id) {
        return messageRepository.findById(id).map(model -> messageMapper.messageToMessageBusiness(model));
    }

    @Override
    public List<MessageBusiness> findAll() {
        return mapListModelToBusiness((List<Message>) messageRepository.findAll());
    }

}
