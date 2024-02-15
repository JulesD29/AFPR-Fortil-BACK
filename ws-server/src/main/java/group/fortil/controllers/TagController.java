package group.fortil.controllers;

import group.fortil.business.TagBusiness;
import group.fortil.exceptions.CustomNotFoundException;
import group.fortil.interfaceControllers.ITagController;
import group.fortil.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tags-api")
public class TagController implements ITagController {

    @Autowired
    private TagService tagService;
    

    @Override
    @GetMapping("/tags")
    public List<TagBusiness> findAll() {
        return tagService.findAll();
    }

    @Override
    @GetMapping("/tags/{id}")
    public ResponseEntity<TagBusiness> findById(Long id)  {
        TagBusiness tagBusiness = tagService.findById(id).orElseThrow(() -> new CustomNotFoundException("Tag not found for this id ::" + id));
        return ResponseEntity.ok().body(tagBusiness);
    }

    @Override
    @PostMapping("/tags")
    public TagBusiness create(TagBusiness tagBusiness) {
        return tagService.create(tagBusiness);
    }

    @Override
    @PutMapping("/tags/{id}")
    public ResponseEntity<TagBusiness> update(Long id, TagBusiness tagDetails)  {
        TagBusiness tag = tagService.findById(id).orElseThrow(() -> new CustomNotFoundException("Tag not found for this id ::" + id));

        tag.setValue(tagDetails.getValue());
        final TagBusiness updatedTag = tagService.update(tag);
        return ResponseEntity.ok(updatedTag);
    }

    @Override
    @DeleteMapping("/tags/{id}")
    public Map<String, Boolean> deleteById(Long id)  {
        TagBusiness tag = tagService.findById(id).orElseThrow(() -> new CustomNotFoundException("Tag not found for this id ::" + id));

        tagService.delete(tag);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
