package elib.entity;

import javax.persistence.*;

/**
 * Class Permition
 */

@Entity
@Table(name = "permition")
public class Permition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "permition_id")
  private Long permitionId;

  @Column(name = "permition_name")
  private String permitionName;

  @ManyToOne
  @JoinColumn(name="category_id")
  private Category category;

  public Permition() {
  }

  public Permition(Long permitionID, String permitionName) {
    this.permitionId = permitionID;
    this.permitionName = permitionName;
  }

  public Long getPermitionId() {
    return permitionId;
  }

  public void setPermitionId(Long permitionId) {
    this.permitionId = permitionId;
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

    if (!permitionId.equals(permition.permitionId)) return false;
    return permitionName.equals(permition.permitionName);
  }

  @Override
  public int hashCode() {
    int result = permitionId.hashCode();
    result = 31 * result + permitionName.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Permition{" +
            "permitionId=" + permitionId +
            ", permitionName='" + permitionName + '\'' +
            '}';
  }
}
