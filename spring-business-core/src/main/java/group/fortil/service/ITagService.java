package group.fortil.service;


import group.fortil.business.ITagBusiness;
import group.fortil.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ITagService<T, I extends Serializable> extends GenericInterfaceService<T, I>{


}
