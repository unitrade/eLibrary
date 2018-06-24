package elib.controller.author.requests;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by it-school on 03.06.2018.
 */
public class CreateAuthorRequest {
    private String authorFirstName;
    private String authorLastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String description;

    public CreateAuthorRequest() {
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

        CreateAuthorRequest that = (CreateAuthorRequest) o;

        if (authorFirstName != null ? !authorFirstName.equals(that.authorFirstName) : that.authorFirstName != null)
            return false;
        if (authorLastName != null ? !authorLastName.equals(that.authorLastName) : that.authorLastName != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = authorFirstName != null ? authorFirstName.hashCode() : 0;
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreateAuthorRequest{" +
                "authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
