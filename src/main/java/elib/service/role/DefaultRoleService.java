package elib.service.role;

import elib.entity.Role;
import elib.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultRoleService implements RoleService {

  private final RoleRepository roleRepository;

  @Autowired
  public DefaultRoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role create(Role role) {
    return roleRepository.create(role);
  }

  @Override
  public Role update(Role role) {
    return roleRepository.update(role);
  }

  @Override
  public int delete(Role role) {
    return roleRepository.delete(role);
  }

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role find(Long id) {
    return roleRepository.find(id);
  }
}
