package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Category;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryService {
    Category save(Category category);
    Category get(int id);
    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    boolean delete(int id);
}
