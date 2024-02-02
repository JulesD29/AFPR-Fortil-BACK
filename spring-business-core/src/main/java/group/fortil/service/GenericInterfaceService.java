package group.fortil.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface GenericInterfaceService<T, I extends Serializable> {


    T create(T bo);

    T update(T bo);

    void delete(T bo);

    Optional<T> findById(Long id);

    List<T> findAll();


}
