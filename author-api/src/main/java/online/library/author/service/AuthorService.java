package online.library.author.service;

import online.library.author.repo.AuthorRepo;
import lombok.extern.slf4j.Slf4j;
import online.library.utility.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author getAuthorById(Long id, String logId) {
        log.debug("LogId {}: AuthorService.getAuthorById caught with author id: {}.", logId, id);
        return authorRepo.getAuthorById(id).orElseThrow(IllegalStateException::new);
    }

    public Author createAuthor(Author author, String logId) {
        log.debug("LogId {}: AuthorService.createAuthor caught with author: {}.", logId, author);
        return authorRepo.save(author);
    }

    public List<Author> listAuthors(String logId) {
        log.debug("LogId {}: AuthorService.listAuthors caught.", logId);
        return authorRepo.findAll();
    }

    public List<Author> searchAuthors(String name, String logId) {
        log.debug("LogId {}: AuthorService.searchAuthors caught with author name: {}.", logId, name);
        return authorRepo.getAuthorsByName(name.toLowerCase());
    }
}
