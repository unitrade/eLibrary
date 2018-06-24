package elib.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class Role
 */

@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Long roleID;

  @Column(name = "role_name", columnDefinition = "varchar (255)")
  private String roleName;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

  public Role() {
  }

  public Role(Long roleID, String roleName) {
    this.roleID = roleID;
    this.roleName = roleName;
  }

  public Long getRoleID() {
    return roleID;
  }

  public void setRoleID(Long roleID) {
    this.roleID = roleID;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Role role = (Role) o;

    if (!roleID.equals(role.roleID)) return false;
    return roleName.equals(role.roleName);
  }

  @Override
  public int hashCode() {
    int result = roleID.hashCode();
    result = 31 * result + roleName.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Role{" +
            "roleID=" + roleID +
            ", roleName='" + roleName + '\'' +
            '}';
  }
}
