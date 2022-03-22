package online.library.author;

import online.library.author.model.Author;
import online.library.author.repo.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static online.library.author.util.AuthorTestUtil.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AuthorApiApplication.class)
public class AuthorRepoTest {

    @Autowired
    private AuthorRepo authorRepo;

    @Test
    public void searchAuthorsTest_multipleAuthors() {
        authorRepo.saveAll(List.of(authorEmre, authorVeli));
        var ret = authorRepo.getAuthorsByName("Emre".toLowerCase());

        assertEquals(1, ret.size());
        assertEquals(authorEmre.getName(), ret.get(0).getName());
    }

    @Test
    public void createAuthorTest() {
        Author ret = authorRepo.save(authorEmre);

        assertNotNull(ret.getId());
        assertEquals(authorEmre.getName(), ret.getName());
    }
}
