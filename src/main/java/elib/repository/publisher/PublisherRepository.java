package elib.repository.publisher;

import elib.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
  Publisher create(Publisher publisher);
  Publisher update(Publisher publisher);
  int delete(Publisher publisher);
  List<Publisher> findAll();
  Publisher find (Long id);
}
