package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Publisher;
import org.springframework.data.domain.Page;

public interface PublisherService {
    Publisher save(Publisher publisher);
    Publisher get(int id);
    Page<Publisher> cursor(int page, int pageSize);

    Publisher update(Publisher publisher);

    boolean delete(int id);
}
