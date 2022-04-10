package online.library.book.repo;

import online.library.utility.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("select b from Book b where lower(b.title) like %:title%")
    List<Book> getBooksByTitle(@Param("title") String title);

    @Query("select book from Book book where book.authorId=:authorId")
    List<Book> getBooksByAuthorId(@Param("authorId") Long authorId);

    Optional<Book> getBookById(Long id);
}
