package elib.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class Permition
 */

@Entity
@Table(name = "permition")
public class Permition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "permition_id")
  private Long permitionID;

  @Column(name = "permition_name")
  private String permitionName;

  @ManyToOne
  @JoinColumn(name="category_id")
  private Category category;

  public Permition() {
  }

  public Permition(Long permitionID, String permitionName) {
    this.permitionID = permitionID;
    this.permitionName = permitionName;
  }

  public Long getPermitionID() {
    return permitionID;
  }

  public void setPermitionID(Long permitionID) {
    this.permitionID = permitionID;
  }

  public String getPermitionName() {
    return permitionName;
  }

  public void setPermitionName(String permitionName) {
    this.permitionName = permitionName;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Permition permition = (Permition) o;

    if (!permitionID.equals(permition.permitionID)) return false;
    return permitionName.equals(permition.permitionName);
  }

  @Override
  public int hashCode() {
    int result = permitionID.hashCode();
    result = 31 * result + permitionName.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Permition{" +
            "permitionID=" + permitionID +
            ", permitionName='" + permitionName + '\'' +
            '}';
  }
}
