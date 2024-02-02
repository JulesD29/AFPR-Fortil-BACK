package group.fortil.mapper;

import group.fortil.business.MessageBusiness;
import group.fortil.business.TagBusiness;
import group.fortil.entities.Message;
import group.fortil.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);


    /*
    @Mapping(source = "tag.tag_index", target = "tag_index")
    @Mapping(source = "tag.value", target = "value")
    */
    TagBusiness tagToTagBusiness(Tag tag);


    /*
    @Mapping(source = "tagBusiness.tag_index", target = "tag_index")
    @Mapping(source = "tagBusiness.value", target = "value")
    */
    Tag tagBusinessToTag(TagBusiness tagBusiness);

}
