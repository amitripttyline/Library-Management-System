package lms.demo.model;

import java.util.Date;

public class BookResponse {
    private Long id;
    private String status;
    private String description;
    private String added_by;
    private String title;

    private String language;
    private int is_available;
    private Date created_at;
    private Date updated_at;

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String is_deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getIs_available() {
        return is_available;
    }

    public void setIs_available(int is_available) {
        this.is_available = is_available;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", added_by='" + added_by + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", is_available=" + is_available +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", author='" + author + '\'' +
                ", is_deleted='" + is_deleted + '\'' +
                '}';
    }

    public BookResponse(Long id, String status, String description, String added_by, String title, String language, int is_available, Date created_at, Date updated_at, String author, String is_deleted) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.added_by = added_by;
        this.title = title;
        this.language = language;
        this.is_available = is_available;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.author = author;
        this.is_deleted = is_deleted;
    }

    public BookResponse() {
    }


}
