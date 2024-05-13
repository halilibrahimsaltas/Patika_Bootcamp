package dev.patika.library.business.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import dev.patika.library.entities.Book;

@Repository
public interface BookService  {
    Book save(Book book);
    Book get(int id);
    Page<Book> cursor(int page, int pageSize);

    Book update(Book book);

    boolean delete(int id);
}
