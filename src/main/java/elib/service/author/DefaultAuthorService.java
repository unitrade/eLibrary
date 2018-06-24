package elib.service.author;

import elib.entity.Author;
import elib.repository.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultAuthorService implements AuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public DefaultAuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public Author create(Author author) {
    return authorRepository.create(author);
  }

  @Override
  public Author update(Author author) {
    return authorRepository.update(author);
  }

  @Override
  public int delete(Author author) {
    return authorRepository.delete(author);
  }

  @Override
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public Author find(Long id) {
    return authorRepository.find(id);
  }
}
