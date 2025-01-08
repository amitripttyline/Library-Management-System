package lms.demo.model;

import java.util.Date;

public class UserResponse {
    private String email;
    private String name;
    private long phone;
    private String password;
    private Long id;
    private String status;
    private Date created_at;
    private Date updated_at;

    private int is_active;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public UserResponse(String email, String name, long phone, String password, Long id, String status, Date created_at, Date updated_at, int is_active) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.id = id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_active = is_active;
    }

    public UserResponse() {
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_active=" + is_active +
                '}';
    }
}
