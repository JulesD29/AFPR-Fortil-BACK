package group.fortil.interfaceControllers;

import group.fortil.business.TagBusiness;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tags-api")
public interface ITagController {

    @GetMapping("/tags")
    List<TagBusiness> findAll();

    @GetMapping("/tags/{id}")
    ResponseEntity<TagBusiness> findById(@PathVariable(value = "id") Long id);

    @PostMapping("/tags")
    TagBusiness create(@Valid @RequestBody TagBusiness tagBusiness);

    @PutMapping("/tags/{id}")
    ResponseEntity<TagBusiness> update(@PathVariable(value = "id") Long id, @Valid @RequestBody TagBusiness tagBusiness);

    @DeleteMapping("/tags/{id}")
    Map<String, Boolean> deleteById(@PathVariable(value = "id") Long id);
}
