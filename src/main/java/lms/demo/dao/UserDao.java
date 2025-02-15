package lms.demo.dao;

import lms.demo.model.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserDao {

    UserResponse save(UserResponse userResponse);
    UserResponse findById(Long Id);
    UserResponse findByEmail(String email);

    List<UserResponse> findAll();
    void deleteById(Long id);
    UserResponse update(UserResponse userResponse);
    boolean existsById(Long id);

}
