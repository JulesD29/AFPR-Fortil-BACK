package group.fortil.repository;

import group.fortil.entities.Message;

import org.springframework.data.repository.CrudRepository;



public interface MessageRepository extends CrudRepository<Message, Long> {

}
