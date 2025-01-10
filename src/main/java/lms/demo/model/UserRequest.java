package lms.demo.model;

public class UserRequest {
    private String email;
    private String name;
    private Long phone;
    private String password;
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

    public UserRequest(String email, String name, long phone, String password) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
