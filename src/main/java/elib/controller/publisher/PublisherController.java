package elib.controller.publisher;

import elib.controller.publisher.requests.CreatePublisherRequest;
import elib.entity.Publisher;
import elib.service.publisher.PublisherService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/publisher")
public class PublisherController {

  private final PublisherService publisherService;

  @Autowired
  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  @RequestMapping(path = "/get/{publisherId}", method = RequestMethod.GET)
  public ResponseEntity getPublisherById(@PathVariable Long publisherId) {
    publisherService.find(publisherId);
    return ResponseEntity.ok("Get publisher by id " + publisherId);
  }

  @RequestMapping(path = "/get", method = RequestMethod.GET)
  public ResponseEntity getAllPublishers() {
    publisherService.findAll();
    return ResponseEntity.ok("Get All publishers");
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public ResponseEntity createPublisher(ModelAndView modelAndView, @ModelAttribute(name = "publisher")CreatePublisherRequest publisher,
                                        BindingResult bindingResult,
                                        HttpServletRequest request) {
    Publisher publisher1 = new Publisher();
    publisher1.setPublisherName(publisher.getPublisherName());
    publisher1.setDescription(publisher.getDescription());
    publisher1.setCountry(publisher.getCountry());
    publisherService.create(publisher1);
    return ResponseEntity.ok("Publisher created");
  }

  @RequestMapping(path = "/update", method = RequestMethod.PUT)
  public ResponseEntity updatePublisher(@RequestBody Publisher publisher) {
    publisherService.update(publisher);
    return ResponseEntity.ok("Publisher updated");
  }

  @RequestMapping(path = "/delete/{publisherId}", method = RequestMethod.DELETE)
  public ResponseEntity deletePublisher(@PathVariable(name = "publisherId") Long publisherId) {
    return ResponseEntity.ok("Publisher deleted Id " + publisherId);
  }
}
