package group.fortil.service;

import group.fortil.business.TagBusiness;
import group.fortil.entities.Tag;
import group.fortil.mapper.TagMapper;
import group.fortil.repository.TagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TagServiceTest {

    @Mock
    private TagRepository tagRepository;

    @Mock
    private TagMapper tagMapper;

    @InjectMocks
    private TagService tagService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void givenTagBusiness_whenCreateNewTag_thenReturnTagBusinessEnteredInParameters() {
        // Given
        TagBusiness inputBusiness = new TagBusiness();
        Tag inputTag = new Tag();

        // When
        when(tagMapper.tagBusinessToTag(inputBusiness)).thenReturn(inputTag);
        when(tagRepository.save(inputTag)).thenReturn(inputTag);
        when(tagMapper.tagToTagBusiness(inputTag)).thenReturn(inputBusiness);
        TagBusiness result = tagService.create(inputBusiness);

        // Then
        assertEquals(inputBusiness, result);
        verify(tagRepository, times(1)).save(inputTag);
    }

    @Test
    public void givenTagBusiness_whenUpdateTag_thenReturnTagBusinessUpdated() {
        // Given
        TagBusiness inputBusiness = new TagBusiness();
        Tag inputTag = new Tag();

        // When
        when(tagMapper.tagBusinessToTag(inputBusiness)).thenReturn(inputTag);
        when(tagRepository.save(inputTag)).thenReturn(inputTag);
        when(tagMapper.tagToTagBusiness(inputTag)).thenReturn(inputBusiness);
        TagBusiness result = tagService.update(inputBusiness);

        // Then
        assertEquals(inputBusiness, result);
        verify(tagRepository, times(1)).save(inputTag);
    }

    @Test
    public void givenListOfAllTags_whenFindAll_thenReturnAllTags() {
        // Given
        List<Tag> tagList = Collections.singletonList(new Tag());

        // When
        when(tagRepository.findAll()).thenReturn(tagList);

        // Then
        List<TagBusiness> result = tagService.findAll();
        assertEquals(tagList.size(), result.size());
    }

    @Test
    public void givenTagBusinessWhoWillBeDeleted_whenDeleteTagBusiness_thenReturnNothing() {
        // Given
        TagBusiness inputBusiness = new TagBusiness();
        Tag inputTag = new Tag();

        // When
        when(tagMapper.tagBusinessToTag(inputBusiness)).thenReturn(inputTag);
        tagService.delete(inputBusiness);

        // Then
        verify(tagRepository, times(1)).delete(inputTag);
    }

    @Test
    public void givenTagIdentifier_whenFindById_thenReturnTagAssociatedToThisId() {
        // Given
        Long id = 1L;
        Tag tag = new Tag();
        TagBusiness expectedBusiness = new TagBusiness();

        // When
        when(tagRepository.findById(id)).thenReturn(Optional.of(tag));
        when(tagMapper.tagToTagBusiness(tag)).thenReturn(expectedBusiness);
        Optional<TagBusiness> result = tagService.findById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals(expectedBusiness, result.get());
    }


}

