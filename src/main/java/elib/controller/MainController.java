package elib.controller;

import elib.controller.author.requests.CreateAuthorRequest;
import elib.controller.book.requests.CreateBookRequest;
import elib.controller.book.requests.EditBookRequest;
import elib.controller.category.requests.CreateCategoryRequest;
import elib.controller.publisher.requests.CreatePublisherRequest;
import elib.controller.user.forms.UserForm;
import elib.controller.user.requests.CreateUserRequest;
import elib.entity.Author;
import elib.entity.Book;
import elib.entity.User;
import elib.service.author.AuthorService;
import elib.service.book.BookService;
import elib.service.category.CategoryService;
import elib.service.publisher.PublisherService;
import elib.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private AuthorService authorService;
  @Autowired
  private BookService bookService;
  @Autowired
  private UserService userService;

  @Autowired
  private PublisherService publisherService;

  @GetMapping("/")
  public String root(Model model){
    model.addAttribute("categories", categoryService.findAll());
    return "index";
  }

  @GetMapping("/index")
  public String index(Model model){
    model.addAttribute("categories", categoryService.findAll());
    return "index";
  }

  @GetMapping("/books")
  public String books(Model model) {
    model.addAttribute("books", bookService.findAll());
    return "books";
  }

  @GetMapping("/signup")
  public String viewSignUp(Model model){
    model.addAttribute("user",new CreateUserRequest());
    return "signup";
  }

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("login", new UserForm());
    return "login";
  }

  @GetMapping("/admin")
  public String admin(Model model){
    model.addAttribute("author", new CreateAuthorRequest());
    model.addAttribute("category", new CreateCategoryRequest());
    model.addAttribute("publisher", new CreatePublisherRequest());
    model.addAttribute("book", new CreateBookRequest());

    model.addAttribute("authors", authorService.findAll());
    model.addAttribute("categories", categoryService.findAll());
    model.addAttribute("publishers", publisherService.findAll());
    return "admin";
  }

  @GetMapping("/update_book/{bookId}")
  public String update(Model model, @PathVariable(required = false, name = "bookId") Long bookId){
//    model.addAttribute("edit", new EditBookRequest());

    model.addAttribute("book", bookService.find(bookId));
    model.addAttribute("authors", authorService.findAll());
    model.addAttribute("categories", categoryService.findAll());
    model.addAttribute("publishers", publisherService.findAll());
    return "update_book";
  }

  @GetMapping("/authors")
  public String author(Model model){
    model.addAttribute("authors", authorService.findAll());
    return "authors";
  }

//  @GetMapping("/update_book")
//  public String update_book(Model model, Long bookId){
//    model.addAttribute("authors", authorService.findAll());
//    model.addAttribute("categories", categoryService.findAll());
//    model.addAttribute("publishers", publisherService.findAll());
//    return "update_book";
//  }

//  @GetMapping("/book")
//  public String book(ModelMap model){
//    model.addAttribute("books", bookService.findAll());
//    return "book";
//  }
}
