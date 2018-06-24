package elib.controller.permition;

import elib.entity.Permition;
import elib.service.permition.PermitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/permition")
public class PermitionController {

  private final PermitionService permitionService;

  @Autowired
  public PermitionController(PermitionService permitionService) {
    this.permitionService = permitionService;
  }

  @RequestMapping(path = "/get/{permitionId}", method = RequestMethod.GET)
  public ResponseEntity getPermitionById(@PathVariable Long permitionId) {
    permitionService.find(permitionId);
    return ResponseEntity.ok("Get permition by id " + permitionId);
  }

  @RequestMapping(path = "/get", method = RequestMethod.GET)
  public ResponseEntity getAllPermitions() {
    permitionService.findAll();
    return ResponseEntity.ok("Get All permitions");
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public ResponseEntity createPermition(@RequestBody Permition permition) {
    permitionService.create(permition);
    return ResponseEntity.ok("Permition created");
  }

  @RequestMapping(path = "/update", method = RequestMethod.PUT)
  public ResponseEntity updateBook(@RequestBody Permition permition) {
    permitionService.update(permition);
    return ResponseEntity.ok("Permition updated");
  }

  @RequestMapping(path = "/delete/{permitionId}", method = RequestMethod.DELETE)
  public ResponseEntity deletePermition(@PathVariable(name = "permitionId") Long permitionId) {
    return ResponseEntity.ok("Book deleted Id " + permitionId);
  }
}
