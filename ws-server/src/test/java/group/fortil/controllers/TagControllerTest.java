package group.fortil.controllers;

import group.fortil.business.TagBusiness;
import group.fortil.exceptions.CustomNotFoundException;
import group.fortil.service.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TagControllerTest {

    @Mock
    private TagService tagService;

    @InjectMocks
    private TagController tagController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<TagBusiness> tagList = Arrays.asList(
                new TagBusiness(1L, "Tag 1"),
                new TagBusiness(2L, "Tag 2")
        );
        when(tagService.findAll()).thenReturn(tagList);

        // When
        List<TagBusiness> result = tagController.findAll();

        // Then
        assertNotNull(result);
        assertEquals(tagList.size(), result.size());
        assertEquals(tagList, result);
    }

    @Test
    public void testFindById_Success() {
        // Given
        long tagId = 1L;
        TagBusiness tag = new TagBusiness(tagId, "Test Tag");
        when(tagService.findById(tagId)).thenReturn(Optional.of(tag));

        // When
        ResponseEntity<TagBusiness> response = tagController.findById(tagId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tag, response.getBody());
    }

    @Test
    public void testFindById_NotFound() {
        // Given
        long tagId = 1L;
        when(tagService.findById(tagId)).thenReturn(Optional.empty());

        // When
        CustomNotFoundException exception = assertThrows(CustomNotFoundException.class, () -> tagController.findById(tagId));

        // Then
        assertNotNull(exception);
    }

    @Test
    public void testCreate() {
        // Given
        TagBusiness newTag = new TagBusiness(1L, "New Tag");
        when(tagService.create(newTag)).thenReturn(newTag);

        // When
        TagBusiness createdTag = tagController.create(newTag);

        // Then
        assertNotNull(createdTag);
        assertEquals(newTag.getValue(), createdTag.getValue());
        assertNotNull(createdTag.getTag_index());
    }

    @Test
    public void testUpdate_Success() {
        // Given
        long tagId = 1L;
        TagBusiness existingTag = new TagBusiness(tagId, "Existing Tag");
        TagBusiness updatedTag = new TagBusiness(tagId, "Updated Tag");

        when(tagService.findById(tagId)).thenReturn(Optional.of(existingTag));
        when(tagService.update(existingTag)).thenReturn(updatedTag);

        // When
        ResponseEntity<TagBusiness> response = tagController.update(tagId, updatedTag);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedTag, response.getBody());
    }

    @Test
    public void testUpdate_NotFound() {
        // Given
        long tagId = 1L;
        TagBusiness updatedTag = new TagBusiness(tagId, "Updated Tag");

        when(tagService.findById(tagId)).thenReturn(Optional.empty());

        // When
        CustomNotFoundException exception = assertThrows(CustomNotFoundException.class, () -> tagController.update(tagId, updatedTag));

        // Then
        assertNotNull(exception);
    }

    @Test
    public void testDelete_Success() {
        // Given
        long tagId = 1L;
        TagBusiness existingTag = new TagBusiness(tagId, "Existing Tag");

        when(tagService.findById(tagId)).thenReturn(Optional.of(existingTag));

        // When
        Map<String, Boolean> response = tagController.deleteById(tagId);

        // Then
        assertNotNull(response);
        assertTrue(response.get("deleted"));
    }

    @Test
    public void testDelete_NotFound() {
        // Given
        long tagId = 1L;
        when(tagService.findById(tagId)).thenReturn(Optional.empty());

        // When
        CustomNotFoundException exception = assertThrows(CustomNotFoundException.class, () -> tagController.deleteById(tagId));

        // Then
        assertNotNull(exception);
    }
}

