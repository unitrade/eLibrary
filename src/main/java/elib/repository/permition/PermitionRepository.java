package elib.repository.permition;

import elib.entity.Permition;

import java.util.List;

public interface PermitionRepository {
  Permition create(Permition permition);
  Permition update(Permition permition);
  int delete(Permition permition);
  List<Permition> findAll();
  Permition find (Long id);
}
