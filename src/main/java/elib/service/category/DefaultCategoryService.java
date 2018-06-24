package elib.service.category;

import elib.entity.Category;
import elib.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultCategoryService implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public DefaultCategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Category create(Category category) {
    return categoryRepository.create(category);
  }

  @Override
  public Category update(Category category) {
    return categoryRepository.update(category);
  }

  @Override
  public int delete(Category category) {
    return categoryRepository.delete(category);
  }

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category find(Long id) {
    return categoryRepository.find(id);
  }
}
