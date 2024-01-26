package group.fortil.repository;

import group.fortil.entities.Message;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface MessageRepository extends CrudRepository<Message, UUID> {

}
