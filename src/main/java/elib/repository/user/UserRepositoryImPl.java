package elib.repository.user;

import elib.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImPl implements UserRepository {

  @PersistenceContext
  public EntityManager em;

  public User create(User user) {
    User userFromDb = em.merge(user);
    return userFromDb;
  }

  public User update(User user) {
    User userFromDb = em.merge(user);
    return userFromDb;
  }

  public int delete(User user) {
    em.remove(user);
    return 0;
  }

  public List<User> findAll() {
    TypedQuery<User> namedQuery = em.createQuery("SELECT u FROM Client u", User.class);
    return namedQuery.getResultList();
  }

  public User find(Long id) {
    return em.find(User.class, id);
  }
}
