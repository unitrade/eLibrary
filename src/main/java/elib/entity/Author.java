package elib.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class Author
 */
@Entity
@Table (name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "author_id", columnDefinition = "serial")
  private Long authorId;

  @Column (name = "author_firstname", columnDefinition = "varchar (255)")
  private String authorFirstName;

  @Column (name = "author_lastname", columnDefinition = "varchar (255)")
  private String authorLastName;

  @Column (name = "date")
  private Long date;

  @Column (name = "description", columnDefinition = "varchar (255)")
  private String description;

  @ManyToMany(mappedBy = "authors")
  private List<Book> books;

  public Author() {
  }

  public Author(Long authorID, String authorFirstName, String authorLastName, Long date, String description, List<Book> books) {
    this.authorId = authorID;
    this.authorFirstName = authorFirstName;
    this.authorLastName = authorLastName;
    this.date = date;
    this.description = description;
    this.books = books;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public String getAuthorFirstName() {
    return authorFirstName;
  }

  public void setAuthorFirstName(String authorFirstName) {
    this.authorFirstName = authorFirstName;
  }

  public String getAuthorLastName() {
    return authorLastName;
  }

  public void setAuthorLastName(String authorLastName) {
    this.authorLastName = authorLastName;
  }

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    if (authorId != null ? !authorId.equals(author.authorId) : author.authorId != null) return false;
    if (authorFirstName != null ? !authorFirstName.equals(author.authorFirstName) : author.authorFirstName != null)
      return false;
    if (authorLastName != null ? !authorLastName.equals(author.authorLastName) : author.authorLastName != null)
      return false;
    if (date != null ? !date.equals(author.date) : author.date != null) return false;
    if (description != null ? !description.equals(author.description) : author.description != null) return false;
    return books != null ? books.equals(author.books) : author.books == null;
  }

  @Override
  public int hashCode() {
    int result = authorId != null ? authorId.hashCode() : 0;
    result = 31 * result + (authorFirstName != null ? authorFirstName.hashCode() : 0);
    result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (books != null ? books.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Author{" +
            "authorId=" + authorId +
            ", authorFirstName='" + authorFirstName + '\'' +
            ", authorLastName='" + authorLastName + '\'' +
            ", date=" + date +
            ", description='" + description + '\'' +
            ", books=" + books +
            '}';
  }
}
