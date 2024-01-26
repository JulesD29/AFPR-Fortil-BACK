package group.fortil.repository;

import group.fortil.entities.Messages;

import org.springframework.data.repository.CrudRepository;


public interface MessagesRepository extends CrudRepository<Messages, Long> {

}
