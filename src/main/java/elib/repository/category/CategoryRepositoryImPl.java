package elib.repository.category;

import elib.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryRepositoryImPl implements CategoryRepository {

  @PersistenceContext
  public EntityManager em;

  public Category create(Category category) {
    Category categoryFromDb = em.merge(category);
    return categoryFromDb;
  }

  public Category update(Category category) {
    Category categoryFromDb = em.merge(category);
    return categoryFromDb;
  }

  public int delete(Category category) {
    em.remove(category);
    return 0;
  }

  public List<Category> findAll() {
    TypedQuery<Category> namedQuery = em.createQuery("SELECT c FROM Category c", Category.class);
    return namedQuery.getResultList();
  }

  public Category find(Long id) {
    return em.find(Category.class, id);
  }
}
