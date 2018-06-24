package elib.service.publisher;

import elib.entity.Publisher;
import elib.repository.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultPublisherService implements PublisherService {

  private final PublisherRepository publisherRepository;

  @Autowired
  public DefaultPublisherService(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }

  @Override
  public Publisher create(Publisher publisher) {
    return publisherRepository.create(publisher);
  }

  @Override
  public Publisher update(Publisher publisher) {
    return publisherRepository.update(publisher);
  }

  @Override
  public int delete(Publisher publisher) {
    return publisherRepository.delete(publisher);
  }

  @Override
  public List<Publisher> findAll() {
    return publisherRepository.findAll();
  }

  @Override
  public Publisher find(Long id) {
    return publisherRepository.find(id);
  }
}
