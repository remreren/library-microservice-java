package online.library.author.api;

import online.library.author.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AuthorApi {

    @GetMapping("/{id}/")
    ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id);

    @PostMapping("/")
    ResponseEntity<Author> createAuthor(@RequestBody Author author);

    @GetMapping("/list/")
    ResponseEntity<List<Author>> listAuthors();

    @GetMapping("/search/")
    ResponseEntity<List<Author>> searchAuthors(@RequestParam("name") String name);
}
