package elib.service.book;

import elib.entity.Book;
import elib.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultBookService implements BookService {

  private final BookRepository bookRepository;

  @Autowired
  public DefaultBookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book create(Book book) {
    return bookRepository.create(book);
  }

  @Override
  public Book update(Book book) {
    return bookRepository.update(book);
  }

  @Override
  public int delete(Book book) {
    return bookRepository.delete(book);
  }

  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Book find(Long id) {
    return bookRepository.find(id);
  }
}
