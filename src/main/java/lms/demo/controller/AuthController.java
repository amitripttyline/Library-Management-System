package lms.demo.controller;

import lms.demo.model.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

  // Store tokens (can be replaced with a database)
  private static final Map<String, String> tokenStore = new HashMap<>();

  @GetMapping("/health")
  public ResponseEntity<String> checkHealth(){
    try {
      return ResponseEntity.ok("Connection successfully!");
    } catch (Exception e){
      return ResponseEntity.internalServerError().body("Health Check failed " + e.getMessage());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {
    System.out.println("----------------------------------amit auth check------------------------");
    // Hardcoded authentication (Replace with database check)
    System.out.println("username:"+ request.getUsername() + " password:" +  request.getPassword());
    if ("user".equals(request.getUsername()) && "password".equals(request.getPassword())) {
      String token = UUID.randomUUID().toString(); // Generate token
      tokenStore.put(token, request.getUsername()); // Store token
      System.out.println("========post req===========token:" + token + "================" + tokenStore);
      return ResponseEntity.ok(Map.of("token", token));
    }
    return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
  }

  @PostMapping("/logout")
  public ResponseEntity<Map<String, String>> logout(@RequestHeader("Authorization") String token) {
    tokenStore.remove(token);
    return ResponseEntity.ok(Map.of("message", "Logged out successfully"));
  }

    public static boolean isValidToken(String token) {
      System.out.println("======valid check req=============token:" + token + "================" + tokenStore);


      return tokenStore.containsKey(token);
  }
}
