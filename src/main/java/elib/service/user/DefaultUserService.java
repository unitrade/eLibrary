package elib.service.user;

import elib.entity.User;
import elib.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public DefaultUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User create(User user) {
    return userRepository.create(user);
  }

  @Override
  public User update(User user) {
    return userRepository.update(user);
  }

  @Override
  public int delete(User user) {
    return userRepository.delete(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User find(Long id) {
    return userRepository.find(id);
  }

}
