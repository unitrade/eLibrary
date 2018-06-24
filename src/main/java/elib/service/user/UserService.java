package elib.service.user;

import elib.entity.User;

import java.util.List;

public interface UserService {
  User create(User user);
  User update(User user);
  int delete(User user);
  List<User> findAll();
  User find (Long id);
}
