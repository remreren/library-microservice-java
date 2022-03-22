package online.library.book.dto.response;

import online.library.author.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.library.book.model.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBookWithAuthor {
    private Book book;
    private Author author;
}
