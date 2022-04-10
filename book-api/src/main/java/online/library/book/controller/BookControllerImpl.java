package online.library.book.controller;

import lombok.extern.slf4j.Slf4j;
import online.library.utility.dto.response.ResponseAuthorWithBooks;
import online.library.utility.dto.response.ResponseBookWithAuthor;
import online.library.utility.controller.BookController;
import online.library.utility.model.Book;
import online.library.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<Book> getBookById(Long bookId) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: BookController.getBookById request caught with book id: {}", logId, bookId);
        return ResponseEntity.ok(bookService.getBookById(bookId, logId));
    }

    @Override
    public ResponseEntity<Book> createBook(Book book) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: BookController.createBook request caught with book: {}", logId, book);
        return ResponseEntity.ok(bookService.createBook(book, logId));
    }

    @Override
    public ResponseEntity<List<Book>> listBooks() {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: BookController.listBooks request caught.", logId);
        return ResponseEntity.ok(bookService.getBookList(logId));
    }

    @Override
    public ResponseEntity<List<Book>> searchBooks(String title) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: BookController.searchBooks request caught with book title: {}", logId, title);
        return ResponseEntity.ok(bookService.getBookByTitle(title, logId));
    }

    @Override
    public ResponseEntity<ResponseBookWithAuthor> getBookWithAuthor(Long bookId) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: BookController.getBookWithAuthor request caught with book id: {}", logId, bookId);
        return ResponseEntity.ok(bookService.getBookWithAuthor(bookId, logId));
    }

    @Override
    public ResponseEntity<ResponseAuthorWithBooks> getAuthorWithBooks(Long authorId) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: BookController.getAuthorBooks request caught with author id: {}", logId, authorId);
        return ResponseEntity.ok(bookService.getAuthorWithBooks(authorId, logId));
    }
}

