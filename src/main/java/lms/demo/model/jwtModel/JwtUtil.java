package lms.demo.model.jwtModel;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
  @Value("${jwt.secret}")
  private String secretKey;
  private Key key;
//  private String secretKey;// Use a stronger secret in production
//  private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

  @PostConstruct
  public void init() {
    System.out.println("Secret Key: " + secretKey); // verify secret is loaded
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    key = Keys.hmacShaKeyFor(keyBytes);
    System.out.println("Key initialized: " + (key != null)); // verify key is created
  }

  // Generate a token valid for 10 hours
  public String generateToken(String email) {
    return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 hours
            .signWith(key)
            .compact();
  }

  // Validate the token
//  public boolean validateToken(String token) {
//    try {
//      Jwts.parser().setSigningKey(key).parseClaimsJws(token);
//      return true;
//    } catch (SecurityException | MalformedJwtException e) {
//      log.error("Invalid JWT signature: {}", e.getMessage());
//    } catch (ExpiredJwtException e) {
//      log.error("JWT token is expired: {}", e.getMessage());
//    } catch (UnsupportedJwtException e) {
//      log.error("JWT token is unsupported: {}", e.getMessage());
//    } catch (IllegalArgumentException e) {
//      log.error("JWT claims string is empty: {}", e.getMessage());
//    }
//    return false;
//  }

//  public boolean validateToken(String token) {
//    try {
//      Jwts.parserBuilder()
//              .setSigningKey(key)
//              .build()
//              .parseClaimsJws(token);
//      return true;
//    } catch (SecurityException | MalformedJwtException e) {
//      log.error("Invalid JWT signature: {}", e.getMessage());
//    } catch (ExpiredJwtException e) {
//      log.error("JWT token is expired: {}", e.getMessage());
//    } catch (UnsupportedJwtException e) {
//      log.error("JWT token is unsupported: {}", e.getMessage());
//    } catch (IllegalArgumentException e) {
//      log.error("JWT claims string is empty: {}", e.getMessage());
//    }
//    return false;
//  }
public boolean validateToken(String token) {
  try {
    // Add debug logging
    System.out.println("Attempting to validate token: " + token.substring(0, Math.min(10, token.length())) + "...");
    System.out.println("Using key: " + (key != null ? "Key is present" : "Key is null"));

    Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);
    return true;
  } catch (SecurityException | MalformedJwtException e) {
    log.error("Invalid JWT signature: {}", e.getMessage());
    e.printStackTrace();  // Add full stack trace
  } catch (ExpiredJwtException e) {
    log.error("JWT token is expired: {}", e.getMessage());
    e.printStackTrace();
  } catch (UnsupportedJwtException e) {
    log.error("JWT token is unsupported: {}", e.getMessage());
    e.printStackTrace();
  } catch (IllegalArgumentException e) {
    log.error("JWT claims string is empty or null: {}", e.getMessage());
    System.out.println("Token length: " + (token != null ? token.length() : "null"));
    e.printStackTrace();
  }
  return false;
}

  // Extract email from token
//  public String extractEmail(String token) {
//    Claims claims = Jwts.parser()
//            .setSigningKey(secretKey)
//            .parseClaimsJws(token)
//            .getBody();
//    return claims.getSubject();
//  }
}
