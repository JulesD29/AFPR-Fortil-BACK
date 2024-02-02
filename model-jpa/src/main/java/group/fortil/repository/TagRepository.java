package group.fortil.repository;

import group.fortil.entities.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface TagRepository extends ListCrudRepository<Tag, Long> {

}
