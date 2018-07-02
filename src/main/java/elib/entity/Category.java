package elib.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class Category
 */

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id", columnDefinition = "serial")
  private Long categoryId;

  @Column(name = "category_name", columnDefinition = "varchar (255)")
  private String categoryName;

  @Column(name = "description", columnDefinition = "varchar (255)")
  private String description;

  @ManyToMany(mappedBy = "categories")
  private List<Book> books;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Permition> permitions;

  public Category() {
  }

  public Category(Long categoryID, String categoryName, String description) {
    this.categoryId = categoryID;
    this.categoryName = categoryName;
    this.description = description;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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

  public List<Permition> getPermitions() {
    return permitions;
  }

  public void setPermitions(List<Permition> permitions) {
    this.permitions = permitions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Category category = (Category) o;

    if (!categoryId.equals(category.categoryId)) return false;
    if (!categoryName.equals(category.categoryName)) return false;
    return description.equals(category.description);
  }

  @Override
  public int hashCode() {
    int result = categoryId.hashCode();
    result = 31 * result + categoryName.hashCode();
    result = 31 * result + description.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Category{" +
            "categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", description='" + description + '\'' +
            '}';
  }
}
