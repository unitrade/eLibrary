package elib.repository.author;

import elib.entity.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoryImPl implements AuthorRepository {

  @PersistenceContext
  public EntityManager em;

  public Author create(Author author) {
    Author authorFromDb = em.merge(author);
    return authorFromDb;
  }

  public Author update(Author author) {
    Author authorFromDb = em.merge(author);
    return authorFromDb;
  }

  public int delete(Author author) {
    em.remove(author);
    return 0;
  }

  public List<Author> findAll() {
    TypedQuery<Author> namedQuery = em.createQuery("SELECT a FROM Author a", Author.class);
    return namedQuery.getResultList();
  }

  public Author find(Long id) {
    return em.find(Author.class, id);
  }
}
