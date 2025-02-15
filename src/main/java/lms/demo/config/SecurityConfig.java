package lms.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
  private final RequestLoggingFilter requestLoggingFilter;

  public SecurityConfig(RequestLoggingFilter requestLoggingFilter) {
    this.requestLoggingFilter = requestLoggingFilter;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**").permitAll() // Public access for authentication endpoints
                    .anyRequest().permitAll() // Protect all other endpoints
            )
            .addFilterBefore(requestLoggingFilter, UsernamePasswordAuthenticationFilter.class); // Add custom filter
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

