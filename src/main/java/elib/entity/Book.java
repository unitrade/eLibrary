package elib.entity;

/**
 * Class Book
 */

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "book_id", columnDefinition = "serial")
  private Long bookID;

  @Column(name = "book_name", columnDefinition = "varchar (255)")
  private String bookName;

  @Column(name = "pages")
  private Integer pages;

  @Column(name = "publisher_date")
  private Long publisherDate;

  @Column(name = "description", columnDefinition = "varchar (255)")
  private String description;

  @ManyToMany
  @JoinTable(name = "book_publisher",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = { @JoinColumn(name = "publisher_id") })
  private List<Publisher> publishers;

  @ManyToMany
  @JoinTable(name = "book_author",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = { @JoinColumn(name = "author_id") })
  private List<Author> authors;

  @ManyToMany
  @JoinTable(name = "book_category",
          joinColumns = { @JoinColumn(name = "book_id") },
          inverseJoinColumns = { @JoinColumn(name = "category_id") })
  private List<Category> categories;

  public Book() {
  }

  public Book(Long bookID, String bookName, String description, Integer pages,
              Long publisherDate) {
    this.bookID = bookID;
    this.bookName = bookName;
    this.description = description;
    this.pages = pages;
    this.publisherDate = publisherDate;
  }

  public Long getBookID() {
    return bookID;
  }

  public void setBookID(Long bookID) {
    this.bookID = bookID;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public Long getPublisherDate() {
    return publisherDate;
  }

  public void setPublisherDate(Long publisherDate) {
    this.publisherDate = publisherDate;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public List<Publisher> getPublishers() {
    return publishers;
  }

  public void setPublishers(List<Publisher> publishers) {
    this.publishers = publishers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (bookID != null ? !bookID.equals(book.bookID) : book.bookID != null) return false;
    if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
    if (pages != null ? !pages.equals(book.pages) : book.pages != null) return false;
    if (publisherDate != null ? !publisherDate.equals(book.publisherDate) : book.publisherDate != null) return false;
    return description != null ? description.equals(book.description) : book.description == null;
  }

  @Override
  public int hashCode() {
    int result = bookID != null ? bookID.hashCode() : 0;
    result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
    result = 31 * result + (pages != null ? pages.hashCode() : 0);
    result = 31 * result + (publisherDate != null ? publisherDate.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookID=" + bookID +
            ", bookName='" + bookName + '\'' +
            ", pages=" + pages +
            ", publisherDate=" + publisherDate +
            ", description='" + description + '\'' +
            '}';
  }
}
