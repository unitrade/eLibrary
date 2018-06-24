package elib.repository.permition;

import elib.entity.Permition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PermitionRepositoryImPl implements PermitionRepository {

  @PersistenceContext
  public EntityManager em;

  public Permition create(Permition permition) {
    Permition permitionFromDb = em.merge(permition);
    return permitionFromDb;
  }

  public Permition update(Permition permition) {
    Permition permitionFromDb = em.merge(permition);
    return permitionFromDb;
  }

  public int delete(Permition permition) {
    em.remove(permition);
    return 0;
  }

  public List<Permition> findAll() {
    TypedQuery<Permition> namedQuery = em.createQuery("SELECT p FROM Permition p", Permition.class);
    return namedQuery.getResultList();
  }

  public Permition find(Long id) {
    return em.find(Permition.class, id);
  }
}
