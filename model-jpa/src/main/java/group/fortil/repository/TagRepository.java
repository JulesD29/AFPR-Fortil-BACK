package group.fortil.repository;

import group.fortil.entities.Tag;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface TagRepository extends CrudRepository<Tag, UUID> {

}
