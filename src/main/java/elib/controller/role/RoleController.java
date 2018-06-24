package elib.controller.role;

import elib.entity.Role;
import elib.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/role")
public class RoleController {

  private final RoleService roleService;

  @Autowired
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @RequestMapping(path = "/get/{roleId}", method = RequestMethod.GET)
  public ResponseEntity getRoleById(@PathVariable Long roleId) {
    roleService.find(roleId);
    return ResponseEntity.ok("Get role by id " + roleId);
  }

  @RequestMapping(path = "/get", method = RequestMethod.GET)
  public ResponseEntity getAllRoles() {
    roleService.findAll();
    return ResponseEntity.ok("Get All roles");
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public ResponseEntity createRole(@RequestBody Role role) {
    roleService.create(role);
    return ResponseEntity.ok("Role created");
  }

  @RequestMapping(path = "/update", method = RequestMethod.PUT)
  public ResponseEntity updateRole(@RequestBody Role role) {
    roleService.update(role);
    return ResponseEntity.ok("Role updated");
  }

  @RequestMapping(path = "/delete/{roleId}", method = RequestMethod.DELETE)
  public ResponseEntity deleteRole(@PathVariable(name = "roleId") Long roleId) {
    return ResponseEntity.ok("Role deleted Id " + roleId);
  }
}
