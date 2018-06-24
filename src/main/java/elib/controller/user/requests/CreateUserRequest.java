package elib.controller.user.requests;

import elib.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class CreateUserRequest {
  private String userFirstName;
  private String userLastName;
  private String email;
  private String password;
  private String confirmPassword;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  public CreateUserRequest() {
  }

  public CreateUserRequest(String userFirstName, String userLastName, String email, String password, String confirmPassword, LocalDate date) {
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.date = date;
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

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CreateUserRequest that = (CreateUserRequest) o;

    if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null) return false;
    if (userLastName != null ? !userLastName.equals(that.userLastName) : that.userLastName != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (password != null ? !password.equals(that.password) : that.password != null) return false;
    if (confirmPassword != null ? !confirmPassword.equals(that.confirmPassword) : that.confirmPassword != null)
      return false;
    return date != null ? date.equals(that.date) : that.date == null;
  }

  @Override
  public int hashCode() {
    int result = userFirstName != null ? userFirstName.hashCode() : 0;
    result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (confirmPassword != null ? confirmPassword.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CreateUserRequest{" +
            "userFirstName='" + userFirstName + '\'' +
            ", userLastName='" + userLastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", confirmPassword='" + confirmPassword + '\'' +
            ", date=" + date +
            '}';
  }
}
