package lms.demo.model;

import java.util.Date;

public class UserBookResponse {


    private long id;
    private long user_id;
    private long book_id;
    private Date created_at;
    private Date updated_at;
    private Date due_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
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

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public UserBookResponse(long id, long user_id, long book_id, Date created_at, Date updated_at, Date due_date) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "UserBookResponse{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", due_date=" + due_date +
                '}';
    }
}
