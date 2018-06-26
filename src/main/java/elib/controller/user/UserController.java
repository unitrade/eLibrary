package elib.controller.user;

import elib.controller.user.forms.UserForm;
import elib.controller.user.requests.CreateUserRequest;
import elib.entity.Role;
import elib.entity.User;
import elib.service.role.RoleService;
import elib.service.user.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

  private final UserService userService;
  private final RoleService roleService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

//  @RequestMapping(path = "/login", method = RequestMethod.POST)
//  public ResponseEntity login(ModelAndView modelAndView, @ModelAttribute(name = "login") UserForm user,
//                              BindingResult bindingResult,
//                              HttpServletRequest reques){
//    User user1 = new User();
//    user1.setEmail(user.getEmail());
//    return ResponseEntity.ok("Login: " + user1.getEmail());
//  }

  @RequestMapping(path = "/get/{userId}", method = RequestMethod.GET)
  public ResponseEntity getUserById(@PathVariable Long userId) {
    userService.find(userId);
    return ResponseEntity.ok("Get user by id " + userId);
  }

  @RequestMapping(path = "/get", method = RequestMethod.GET)
  public ResponseEntity getAllUsers() {
    userService.findAll();
    return ResponseEntity.ok("Get All users");
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public String createUser(ModelAndView modelAndView, @ModelAttribute(name = "user") CreateUserRequest user,
                                   BindingResult bindingResult,
                                   HttpServletRequest request) {
    User user1 = new User();
    System.out.println(user);
    user1.setUserFirstName(user.getUserFirstName());
    user1.setUserLastName(user.getUserLastName());
    user1.setEmail(user.getEmail());
    user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user1.setDate(user.getDate().atStartOfDay().toInstant(ZoneOffset.UTC).getEpochSecond());
    List<Role> roles = new ArrayList<>();
    roles.add(roleService.find(2L));
    user1.setRoles(roles);
    userService.create(user1);
    return "redirect:/books";
  }

  @RequestMapping(path = "/update", method = RequestMethod.PUT)
  public ResponseEntity updateUser(@RequestBody User user) {
    userService.update(user);
    return ResponseEntity.ok("User updated");
  }

  @RequestMapping(path = "/delete/{userId}", method = RequestMethod.DELETE)
  public ResponseEntity deleteUser(@PathVariable(name = "userId") Long userId) {
    return ResponseEntity.ok("Role deleted Id " + userId);
  }
}
