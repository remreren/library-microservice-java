package online.library.author;

import online.library.author.controller.AuthorControllerImpl;
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
public class AuthorControllerTest {

    private final AuthorService authorService = mock(AuthorService.class);
    private final AuthorControllerImpl authorController = new AuthorControllerImpl(authorService);

    @Test
    public void searchAuthorsTest() {
        when(authorService.searchAuthors(any(), any())).thenReturn(List.of(authorEmre, authorVeli));
        var ret = authorController.searchAuthors("Emre");

        assertEquals(List.of(authorEmre, authorVeli), ret.getBody());
    }
}
