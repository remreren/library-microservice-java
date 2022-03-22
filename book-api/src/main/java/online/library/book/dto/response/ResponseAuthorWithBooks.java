package online.library.book.dto.response;

import online.library.author.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.library.book.model.Book;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAuthorWithBooks {
    private Author author;
    private List<Book> books;
}
