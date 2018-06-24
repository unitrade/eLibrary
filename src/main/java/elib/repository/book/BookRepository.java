package elib.repository.book;

import elib.entity.Book;

import java.util.List;

public interface BookRepository {
  Book create(Book book);
  Book update(Book book);
  int delete(Book book);
  List<Book> findAll();
  Book find (Long id);
}
