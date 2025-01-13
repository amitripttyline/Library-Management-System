package lms.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "books")
public class BookResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "ISBN cannot be null")
    @Column(nullable = false, unique = true)
    private Long isbn;
    private String status;
    @NotBlank(message = "Author name is required")
    @Column(nullable = false)
    private String author;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;
    private String description;
    @NotBlank(message = "Added-by is required")
    @Column(nullable = false)
    private String added_by;
    private String language;
    private int is_available;
    private Date created_at;
    private Date updated_at;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public BookResponse(Long id, Long isbn, String status, String author, String title, String description, String added_by, String language, int is_available, Date created_at, Date updated_at) {
        this.id = id;
        this.isbn = isbn;
        this.status = status;
        this.author = author;
        this.title = title;
        this.description = description;
        this.added_by = added_by;
        this.language = language;
        this.is_available = is_available;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public BookResponse() {
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", added_by='" + added_by + '\'' +
                ", language='" + language + '\'' +
                ", is_available=" + is_available +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
