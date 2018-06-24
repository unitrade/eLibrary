package elib.controller.author;

import elib.controller.author.requests.CreateAuthorRequest;
import elib.entity.Author;
import elib.service.author.AuthorService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZoneOffset;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping(path = "/get/{authorId}", method = RequestMethod.GET)
    public String getAuthorById(@PathVariable(value = "authorId") Long authorId, Model model) {
      Author author = authorService.find(authorId);
      model.addAttribute("auth", author);
    return "author";
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity getAllAuthors() {
      authorService.findAll();
      return ResponseEntity.ok("Get All authors");
    }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public ResponseEntity createAuthor(ModelAndView modelAndView, @ModelAttribute(name = "author")CreateAuthorRequest author,
                                     BindingResult bindingResult,
                                     HttpServletRequest request) {
    Author author1 = new Author();
    author1.setAuthorFirstName(author.getAuthorFirstName());
    author1.setAuthorLastName(author.getAuthorLastName());
    author1.setDescription(author.getDescription());
    author1.setDate(author.getDate().atStartOfDay().toInstant(ZoneOffset.UTC).getEpochSecond());
    authorService.create(author1);
    return ResponseEntity.ok("Author created" + author.toString());
  }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateAuthor(@RequestBody Author author) {
      authorService.update(author);
      return ResponseEntity.ok("Author updated");
    }

    @RequestMapping(path = "/delete/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAuthor(@PathVariable(name = "authorId") Long authorId) {
      return ResponseEntity.ok("Author deleted Id " + authorId);
    }
}

