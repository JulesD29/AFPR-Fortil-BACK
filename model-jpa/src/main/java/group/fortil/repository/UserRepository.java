package group.fortil.repository;

import group.fortil.entities.User;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface UserRepository extends CrudRepository<User, UUID> {

}
