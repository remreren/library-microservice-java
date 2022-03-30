package online.library.book.controller;

import online.library.book.dto.response.ResponseAuthorWithBooks;
import online.library.book.dto.response.ResponseBookWithAuthor;
import online.library.book.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BookController {

    @GetMapping("/{bookId}/")
    ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId);

    @PostMapping("/")
    ResponseEntity<Book> createBook(@RequestBody Book book);

    @GetMapping("/list/")
    ResponseEntity<List<Book>> listBooks();

    @GetMapping("/search/")
    ResponseEntity<List<Book>> searchBooks(@RequestParam("title") String title);

    @GetMapping("/{bookId}/with-author/")
    ResponseEntity<ResponseBookWithAuthor> getBookWithAuthor(@PathVariable("bookId") Long bookId);

    @GetMapping("/author/{authorId}/")
    ResponseEntity<ResponseAuthorWithBooks> getAuthorWithBooks(@PathVariable("authorId") Long authorId);
}
