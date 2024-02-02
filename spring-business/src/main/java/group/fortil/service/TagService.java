package group.fortil.service;

import group.fortil.business.TagBusiness;
import group.fortil.entities.Tag;
import group.fortil.mapper.TagMapper;
import group.fortil.repository.TagRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class TagService implements ITagService<TagBusiness, Serializable> {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagMapper tagMapper;


//    public List<TagBusiness> transferTagToTagBusiness(){
//        List<TagBusiness> listTagsB = new ArrayList<>();
//        for (Tag tag : tagRepository.findAll())
//            listTagsB.add(tagMapper.tagToTagBusiness(tag));
//        return listTagsB;
//    }
//
//    public List<Tag> transferTagBusinesstoTag(List<TagBusiness> tagBusinessList){
//        List<Tag> listTags = new ArrayList<>();
//        for (TagBusiness tagB : tagBusinessList)
//            listTags.add(tagMapper.tagBusinessToTag(tagB));
//        return listTags;
//
//    }
    

    private List<TagBusiness> mapListModelToBusiness(List<Tag> tagModels) {
        return tagModels.stream().map(e -> tagMapper.tagToTagBusiness(e)).collect(Collectors.toList());
    }

    private List<Tag> mapListBusinessToModel(List<TagBusiness> tagBusiness) {
        return tagBusiness.stream().map(e -> tagMapper.tagBusinessToTag(e)).collect(Collectors.toList());
    }

    private TagBusiness saveModelFromBusiness(TagBusiness tagBusiness) {
        return tagMapper.tagToTagBusiness(tagRepository.save(tagMapper.tagBusinessToTag(tagBusiness)));
    }

    
    
    
    @Override
    public TagBusiness create(@Valid TagBusiness tagBusiness) {
        return saveModelFromBusiness(tagBusiness);
    }

    @Override
    public TagBusiness update(@Valid TagBusiness tagBusiness) {
        return saveModelFromBusiness(tagBusiness);
    }

    @Override
    public List<TagBusiness> findAll() {
        return mapListModelToBusiness(tagRepository.findAll());
    }

    @Override
    public void delete(TagBusiness tagBusiness) {
        tagRepository.delete(tagMapper.tagBusinessToTag(tagBusiness));
    }

    @Override
    public Optional<TagBusiness> findById(Long id) {
        return tagRepository.findById(id).map(model -> tagMapper.tagToTagBusiness(model));
    }


}
