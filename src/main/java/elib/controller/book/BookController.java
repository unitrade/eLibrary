package elib.controller.book;

import elib.controller.book.requests.CreateBookRequest;
import elib.controller.book.requests.EditBookRequest;
import elib.entity.Author;
import elib.entity.Book;
import elib.entity.Category;
import elib.entity.Publisher;
import elib.service.author.AuthorService;
import elib.service.book.BookService;
import elib.service.category.CategoryService;
import elib.service.publisher.PublisherService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

  private final BookService bookService;
  private final AuthorService authorService;
  private final CategoryService categoryService;
  private final PublisherService publisherService;

  @Autowired
  public BookController(BookService bookService, AuthorService authorService, CategoryService categoryService, PublisherService publisherService) {
    this.bookService = bookService;
    this.authorService = authorService;
    this.categoryService = categoryService;
    this.publisherService = publisherService;
  }

  @RequestMapping(path = "/get/{bookId}", method = RequestMethod.GET)
  public String getBookById(@PathVariable(value = "bookId") Long bookId, Model model) {
      Book book = bookService.find(bookId);
      model.addAttribute("book", book);
    return "book";
  }

  @RequestMapping(path = "/get", method = RequestMethod.GET)
  public ResponseEntity getAllBooks() {
    bookService.findAll();
    return ResponseEntity.ok("Get All books");
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public String createBook(ModelAndView modelAndView, @ModelAttribute(name = "book") CreateBookRequest book,
                                   BindingResult bindingResult,
                                   HttpServletRequest request) {
    Book book1 = new Book();
    book1.setBookName(book.getBookName());

    List<Author> authors = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<Publisher> publishers = new ArrayList<>();
    for (Long authorId: book.getAuthorId()) {
      authors.add(authorService.find(authorId));
    }
    book1.setAuthors(authors);
    for (Long catId: book.getCategoriesId()) {
      categories.add(categoryService.find(catId));
    }
    book1.setCategories(categories);
    for (Long pubId: book.getPublisherId()) {
      publishers.add(publisherService.find(pubId));
    }
    book1.setPublishers(publishers);

    book1.setPages(book.getPages());
    book1.setPublisherDate(book.getPublisherDate().atStartOfDay().toInstant(ZoneOffset.UTC).getEpochSecond());
    book1.setDescription(book.getDescription());
    bookService.create(book1);
    return "books";
  }

  @RequestMapping(path = "/update", method = RequestMethod.POST)
  public String updateBook(Book book) {
    System.out.println("Описание: " + book.toString());
    bookService.update(book);
    return "books";
  }

  @RequestMapping(path = "/delete/{bookId}", method = RequestMethod.GET)
  public String deleteBook(@PathVariable(name = "bookId") Long bookId) {
    Book book = bookService.find(bookId);
    bookService.delete(book);
    return "redirect:/books";
  }

}
