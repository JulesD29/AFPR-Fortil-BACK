package group.fortil.repository;

import group.fortil.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findMessagesByUserFirstName(String firstName);


}
