package elib.service.book;

import elib.entity.Book;

import java.util.List;

public interface BookService {
  Book create(Book book);
  Book update(Book book);
  int delete(Book book);
  List<Book> findAll();
  Book find (Long id);
}
