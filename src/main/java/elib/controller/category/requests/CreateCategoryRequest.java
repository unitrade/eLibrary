package elib.controller.category.requests;

/**
 * Created by it-school on 03.06.2018.
 */
public class CreateCategoryRequest {
    private String categoryName;
    private String description;

    public CreateCategoryRequest(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public CreateCategoryRequest() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateCategoryRequest that = (CreateCategoryRequest) o;

        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreateCategoryRequest{" +
                "categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
