package elib.service.category;

import elib.entity.Category;

import java.util.List;

public interface CategoryService {
  Category create(Category category);
  Category update(Category category);
  int delete(Category category);
  List<Category> findAll();
  Category find (Long id);
}
