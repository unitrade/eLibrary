package elib.controller.book.requests;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class CreateBookRequest {

  private String bookName;
  private List<Long> authorId;
  private List<Long> categoriesId;
  private Integer pages;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate publisherDate;
  private List<Long> publisherId;
  private String description;

  public CreateBookRequest() {
  }

  public CreateBookRequest(String bookName, List<Long> authorId, List<Long> categoriesId, Integer pages, LocalDate publisherDate, List<Long> publisherId, String description) {
    this.bookName = bookName;
    this.authorId = authorId;
    this.categoriesId = categoriesId;
    this.pages = pages;
    this.publisherDate = publisherDate;
    this.publisherId = publisherId;
    this.description = description;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public List<Long> getAuthorId() {
    return authorId;
  }

  public void setAuthorId(List<Long> authorId) {
    this.authorId = authorId;
  }

  public List<Long> getCategoriesId() {
    return categoriesId;
  }

  public void setCategoriesId(List<Long> categoriesId) {
    this.categoriesId = categoriesId;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public LocalDate getPublisherDate() {
    return publisherDate;
  }

  public void setPublisherDate(LocalDate publisherDate) {
    this.publisherDate = publisherDate;
  }

  public List<Long> getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(List<Long> publisherId) {
    this.publisherId = publisherId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CreateBookRequest that = (CreateBookRequest) o;

    if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
    if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
    if (categoriesId != null ? !categoriesId.equals(that.categoriesId) : that.categoriesId != null) return false;
    if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
    if (publisherDate != null ? !publisherDate.equals(that.publisherDate) : that.publisherDate != null) return false;
    if (publisherId != null ? !publisherId.equals(that.publisherId) : that.publisherId != null) return false;
    return description != null ? description.equals(that.description) : that.description == null;
  }

  @Override
  public int hashCode() {
    int result = bookName != null ? bookName.hashCode() : 0;
    result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
    result = 31 * result + (categoriesId != null ? categoriesId.hashCode() : 0);
    result = 31 * result + (pages != null ? pages.hashCode() : 0);
    result = 31 * result + (publisherDate != null ? publisherDate.hashCode() : 0);
    result = 31 * result + (publisherId != null ? publisherId.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CreateBookRequest{" +
            "bookName='" + bookName + '\'' +
            ", authorId=" + authorId +
            ", categoriesId=" + categoriesId +
            ", pages=" + pages +
            ", publisherDate=" + publisherDate +
            ", publisherId=" + publisherId +
            ", description='" + description + '\'' +
            '}';
  }
}
