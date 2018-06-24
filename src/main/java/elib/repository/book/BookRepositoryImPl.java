package elib.repository.book;

import elib.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepositoryImPl implements BookRepository {

  @PersistenceContext
  public EntityManager em;

  public Book create(Book book) {
    Book bookFromDb = em.merge(book);
    return bookFromDb;
  }

  public Book update(Book book) {
    Book bookFromDb = em.merge(book);
    return bookFromDb;
  }

  public int delete(Book book) {
    em.remove(book);
    return 0;
  }

  public List<Book> findAll() {
    TypedQuery<Book> namedQuery = em.createQuery("SELECT b FROM Book b", Book.class);
    return namedQuery.getResultList();
  }

  public Book find(Long id) {
    return em.find(Book.class, id);
  }
}
