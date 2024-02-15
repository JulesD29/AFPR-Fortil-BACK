package group.fortil.repository;


import group.fortil.entities.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;




@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {group.fortil.JpaConfiguration.class})
public class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    // Just to test good implementation of CRUD methods ...
    @Test
    public void givenTwoTagObject_whenTagFindAll_thenReturnTags() {
        // Given
        Tag tag1 = new Tag("Tag1");
        Tag tag2 = new Tag("Tag2");
        tagRepository.save(tag1);
        tagRepository.save(tag2);


        // When
        List<Tag> tags = (List<Tag>) tagRepository.findAll();

        // Then
        assertEquals(2, tags.size());
        assertTrue(tags.contains(tag1));
        assertTrue(tags.contains(tag2));
    }
}