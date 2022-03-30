package online.library.author.controller;

import online.library.author.model.Author;
import online.library.author.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/author")
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    public AuthorControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public ResponseEntity<Author> getAuthorById(Long id) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: AuthorService.getAuthorById caught with author id: {}", logId, id);
        return ResponseEntity.ok(authorService.getAuthorById(id, logId));
    }

    @Override
    public ResponseEntity<Author> createAuthor(Author author) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: AuthorService.createAuthor caught with author: {}", logId, author);
        return ResponseEntity.ok(authorService.createAuthor(author, logId));
    }

    @Override
    public ResponseEntity<List<Author>> listAuthors() {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: AuthorService.listAuthors caught.", logId);
        return ResponseEntity.ok(authorService.listAuthors(logId));
    }

    @Override
    public ResponseEntity<List<Author>> searchAuthors(String name) {
        String logId = UUID.randomUUID().toString();
        log.debug("LogId {}: AuthorService.searchAuthors caught with author name: {}.", logId, name);
        return ResponseEntity.ok(authorService.searchAuthors(name, logId));
    }
}
