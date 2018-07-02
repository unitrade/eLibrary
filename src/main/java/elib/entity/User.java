package elib.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Class User
 */

@Entity
@Table(name = "client")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", columnDefinition = "serial")
  private Long userId;

  @Column(name = "user_first_name", columnDefinition = "varchar (255)")
  private String userFirstName;

  @Column(name = "user_last_name", columnDefinition = "varchar (255)")
  private String userLastName;

  @Column(name = "email", columnDefinition = "varchar (255)")
  private String email;

  @Column(name = "password", columnDefinition = "varchar (255)")
  private String password;

  @Column(name = "age")
  private Long date;

  @ManyToMany
  @JoinTable(name = "client_role",
          joinColumns = { @JoinColumn(name = "client_id") },
          inverseJoinColumns = { @JoinColumn(name = "role_id") })
  private List<Role> roles;

  public User() {
  }

  public User(Long userID, String userFirstName, String userLastName, String email, String password, Long date) {
    this.userId = userID;
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.email = email;
    this.password = password;
    this.date = date;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserFirstName() {
    return userFirstName;
  }

  public void setUserFirstName(String userFirstName) {
    this.userFirstName = userFirstName;
  }

  public String getUserLastName() {
    return userLastName;
  }

  public void setUserLastName(String userLastName) {
    this.userLastName = userLastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
    if (userFirstName != null ? !userFirstName.equals(user.userFirstName) : user.userFirstName != null) return false;
    if (userLastName != null ? !userLastName.equals(user.userLastName) : user.userLastName != null) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;
    return date != null ? date.equals(user.date) : user.date == null;
  }

  @Override
  public int hashCode() {
    int result = userId != null ? userId.hashCode() : 0;
    result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
    result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userFirstName='" + userFirstName + '\'' +
            ", userLastName='" + userLastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", age=" + date +
            '}';
  }
}
