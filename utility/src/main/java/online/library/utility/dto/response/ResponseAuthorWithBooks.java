package online.library.utility.dto.response;

import online.library.utility.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.library.utility.model.Book;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAuthorWithBooks {
    private Author author;
    private List<Book> books;
}
