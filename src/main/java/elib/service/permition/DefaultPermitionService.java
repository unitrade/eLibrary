package elib.service.permition;

import elib.entity.Permition;
import elib.repository.permition.PermitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultPermitionService implements PermitionService {

  private final PermitionRepository permitionRepository;

  @Autowired
  public DefaultPermitionService(PermitionRepository permitionRepository) {
    this.permitionRepository = permitionRepository;
  }

  @Override
  public Permition create(Permition permition) {
    return permitionRepository.create(permition);
  }

  @Override
  public Permition update(Permition permition) {
    return permitionRepository.update(permition);
  }

  @Override
  public int delete(Permition permition) {
    return permitionRepository.delete(permition);
  }

  @Override
  public List<Permition> findAll() {
    return permitionRepository.findAll();
  }

  @Override
  public Permition find(Long id) {
    return permitionRepository.find(id);
  }
}
