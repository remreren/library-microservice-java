package online.library.book.service;

import online.library.author.model.Author;
import lombok.extern.slf4j.Slf4j;
import online.library.book.dto.response.ResponseAuthorWithBooks;
import online.library.book.dto.response.ResponseBookWithAuthor;
import online.library.book.exception.ItemNotFoundException;
import online.library.book.model.Book;
import online.library.book.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorMicroservice authorService;

    public BookService(BookRepo bookRepo, AuthorMicroservice authorService) {
        this.bookRepo = bookRepo;
        this.authorService = authorService;
    }

    public Book getBookById(Long id, String logId) {
        log.debug("LogId {}: BookService.getBookById caught with book id: {}", logId, id);
        return bookRepo.getBookById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    public Book createBook(Book book, String logId) {
        log.debug("LogId {}: BookService.createBook request caught with book: {}", logId, book);
        return bookRepo.save(book);
    }

    public List<Book> getBookList(String logId) {
        log.debug("LogId {}: BookService.getBookById caught.", logId);
        return bookRepo.findAll();
    }

    public List<Book> getBookByTitle(String title, String logId) {
        log.debug("LogId {}: BookService.getBookByTitle caught with book title: {}", logId, title);
        return bookRepo.getBooksByTitle(title.toLowerCase());
    }

    public ResponseBookWithAuthor getBookWithAuthor(Long id, String logId) {
        log.debug("LogId {}: BookService.getBookWithAuthor caught with book id: {}", logId, id);
        Book book = bookRepo.getBookById(id).orElseThrow(() -> new ItemNotFoundException("Book cannot be found."));
        Author author = authorService.getAuthorById(book.getAuthorId()).getBody();
        return new ResponseBookWithAuthor(book, author);
    }

    public ResponseAuthorWithBooks getAuthorWithBooks(Long authorId, String logId) {
        log.debug("LogId {}: BookService.getAuthorBooks caught with author id: {}", logId, authorId);
        List<Book> books = bookRepo.getBooksByAuthorId(authorId);
        Author author = authorService.getAuthorById(authorId).getBody();
        return new ResponseAuthorWithBooks(author, books);
    }
}
