package elib.controller.publisher.requests;

/**
 * Created by it-school on 03.06.2018.
 */
public class CreatePublisherRequest {
    private String publisherName;
    private String description;
    private String country;

    public CreatePublisherRequest(String publisherName, String description, String country) {
        this.publisherName = publisherName;
        this.description = description;
        this.country = country;
    }

    public CreatePublisherRequest() {

    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatePublisherRequest that = (CreatePublisherRequest) o;

        if (publisherName != null ? !publisherName.equals(that.publisherName) : that.publisherName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = publisherName != null ? publisherName.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreatePublisherRequest{" +
                "publisherName='" + publisherName + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
