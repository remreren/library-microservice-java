package online.library.utility.dto.response;

import online.library.utility.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.library.utility.model.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBookWithAuthor {
    private Book book;
    private Author author;
}
