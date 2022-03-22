package online.library.author;

import online.library.author.repo.AuthorRepo;
import online.library.author.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static online.library.author.util.AuthorTestUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AuthorApiApplication.class)
public class AuthorServiceTest {

    private final AuthorRepo authorRepo = mock(AuthorRepo.class);
    private final AuthorService authorService = new AuthorService(authorRepo);

    @Test
    public void searchAuthors() {
        when(authorRepo.getAuthorsByName(any())).thenReturn(List.of(authorEmre, authorVeli));
        var ret = authorService.searchAuthors("emre", null);

        assertEquals(List.of(authorEmre, authorVeli), ret);
    }
}
