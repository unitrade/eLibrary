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
  private Long roleId;

  @Column(name = "role_name", columnDefinition = "varchar (255)")
  private String roleName;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

  public Role() {
  }

  public Role(Long roleID, String roleName) {
    this.roleId = roleID;
    this.roleName = roleName;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
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

    if (!roleId.equals(role.roleId)) return false;
    return roleName.equals(role.roleName);
  }

  @Override
  public int hashCode() {
    int result = roleId.hashCode();
    result = 31 * result + roleName.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Role{" +
            "roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            '}';
  }
}
