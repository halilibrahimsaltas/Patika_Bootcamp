package dev.patika.library.business.abstracts;


import dev.patika.library.entities.Author;
import dev.patika.library.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorService {
    Author save(Author author);
    Author get(int id);
    Page<Author> cursor(int page, int pageSize);

    Author update(Author author);

    boolean delete(int id);

}
