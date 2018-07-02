package elib.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class Publisher
 */

@Entity
@Table(name = "publisher")
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "publisher_id")
  private Long publisherId;

  @Column(name = "publisher_name", columnDefinition = "varchar (255)")
  private String publisherName;

  @Column(name = "description", columnDefinition = "varchar (255)")
  private String description;

  @Column(name = "country", columnDefinition = "varchar (100)")
  private String country;

  @ManyToMany(mappedBy = "publishers")
  private List<Book> books;

  public Publisher() {
  }

  public Publisher(Long publisherID, String publisherName, String description, String country) {
    this.publisherId = publisherID;
    this.publisherName = publisherName;
    this.description = description;
    this.country = country;
  }

  public Long getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(Long publisherId) {
    this.publisherId = publisherId;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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

    Publisher publisher = (Publisher) o;

    if (!publisherId.equals(publisher.publisherId)) return false;
    if (!publisherName.equals(publisher.publisherName)) return false;
    if (!description.equals(publisher.description)) return false;
    return country.equals(publisher.country);
  }

  @Override
  public int hashCode() {
    int result = publisherId.hashCode();
    result = 31 * result + publisherName.hashCode();
    result = 31 * result + description.hashCode();
    result = 31 * result + country.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Publisher{" +
            "publisherId=" + publisherId +
            ", publisherName='" + publisherName + '\'' +
            ", description='" + description + '\'' +
            ", country='" + country + '\'' +
            '}';
  }
}
