package elib.repository.role;

import elib.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleRepositoryImPl implements RoleRepository {

  @PersistenceContext
  public EntityManager em;

  public Role create(Role role) {
    Role roleFromDb = em.merge(role);
    return roleFromDb;
  }

  public Role update(Role role) {
    Role roleFromDb = em.merge(role);
    return roleFromDb;
  }

  public int delete(Role role) {
    em.remove(role);
    return 0;
  }

  public List<Role> findAll() {
    TypedQuery<Role> namedQuery = em.createQuery("SELECT r FROM Role r", Role.class);
    return namedQuery.getResultList();
  }

  public Role find(Long id) {
    return em.find(Role.class, id);
  }
}
