package online.library.book;

import online.library.book.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static online.library.book.util.BookTestUtil.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookApiApplication.class)
public class BookRepoTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    public void getAuthorBooks() {
        bookRepo.saveAll(List.of(bookLittlePrinceBuilder.authorId(1L).build(), bookFahrenheit451Builder.authorId(2L).build()));
        var books = bookRepo.getBooksByAuthorId(2L);

        assertEquals(1, books.size());
        assertEquals(bookFahrenheit451.getTitle(), books.get(0).getTitle());
    }
}
