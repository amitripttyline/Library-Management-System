package lms.demo.service;

import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public interface UserService {
    public Map<String, Object> getUserById(Long id);
    List<UserResponse> getAllUsers();
    public Map<String, Object> deleteUser(Long id);
   UserResponse updateUser(UserRequest userRequest, Long id);
    UserResponse registerUser(UserRequest userRequest);
}
