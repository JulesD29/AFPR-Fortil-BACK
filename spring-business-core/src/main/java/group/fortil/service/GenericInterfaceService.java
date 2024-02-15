package group.fortil.service;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Validated
public interface GenericInterfaceService<T, I extends Serializable> {


    T create(@Valid T bo);

    T update(@Valid T bo);

    void delete(T bo);

    Optional<T> findById(Long id);

    List<T> findAll();


}
