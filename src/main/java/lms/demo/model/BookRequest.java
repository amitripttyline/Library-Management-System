package lms.demo.model;


public class BookRequest {
    private String title;
    private String author;
    private String description;
    private String added_by;
    private String language;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BookRequest(String title, String author, String description, String added_by, String language) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.added_by = added_by;
        this.language = language;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", added_by='" + added_by + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
