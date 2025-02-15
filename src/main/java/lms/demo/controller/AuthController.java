package lms.demo.controller;

import lms.demo.dao.UserDao;
import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import lms.demo.model.jwtModel.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private UserDao userDao;

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtUtil jwtUtil;


  @PostMapping("/login")
  public String login(@RequestBody UserRequest userRequest) {

    UserResponse dbUser = userDao.findByEmail(userRequest.getEmail());
    if (dbUser != null && userRequest.getPassword().equals(dbUser.getPassword())) {
      return jwtUtil.generateToken(userRequest.getEmail());  // Return the JWT token
    } else {
      throw new RuntimeException("Invalid credentials");
    }
  }
}
