package dev.patika.library.business.abstracts;


import dev.patika.library.entities.Author;
import dev.patika.library.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(int id);
    Page<BookBorrowing> cursor(int page, int pageSize);

    BookBorrowing update(BookBorrowing bookBorrowing);

    boolean delete(int id);
}
