package lms.demo.model;

public class AuthRequest {
  private String username;
  private String password;

  // Getters and Setters

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AuthRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public AuthRequest() {
  }

  @Override
  public String toString() {
    return "AuthRequest{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
