package lms.demo.model;

import java.util.Date;

public class UserBookRequest {

    private long user_id;
    private long book_id;

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

    public UserBookRequest(long user_id, long book_id) {
        this.user_id = user_id;
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "UserBookRequest{" +
                "user_id=" + user_id +
                ", book_id=" + book_id +
                '}';
    }
}
