package elib.repository.publisher;

import elib.entity.Publisher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PublisherRepositoryImPl implements PublisherRepository {

  @PersistenceContext
  public EntityManager em;

  public Publisher create(Publisher publisher) {
    Publisher publisherFromDb = em.merge(publisher);
    return publisherFromDb;
  }

  public Publisher update(Publisher publisher) {
    Publisher publisherFromDb = em.merge(publisher);
    return publisherFromDb;
  }

  public int delete(Publisher publisher) {
    em.remove(publisher);
    return 0;
  }

  public List<Publisher> findAll() {
    TypedQuery<Publisher> namedQuery = em.createQuery("SELECT p FROM Publisher p", Publisher.class);
    return namedQuery.getResultList();
  }

  public Publisher find(Long id) {
    return em.find(Publisher.class, id);
  }
}
