package lms.demo.controller;


import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    long countId = 0;
    public static HashMap<Long, UserResponse> userList = new HashMap<>();

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        try {
            return ResponseEntity.ok("Connection successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Health check failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> userRequest(@RequestBody UserRequest userRequest) {
        try {

            if (userRequest == null) {
                return ResponseEntity.badRequest().body(null);
            }

            UserResponse userResponse = new UserResponse();
            userResponse.setId(++countId);
            userResponse.setName(userRequest.getName());
            userResponse.setPhone(userRequest.getPhone());
            userResponse.setEmail(userRequest.getEmail());
            userResponse.setPassword(userRequest.getPassword());
            userResponse.setStatus("User registered successfully");
            userResponse.setCreated_at(new Date());
            userResponse.setUpdated_at(new Date());
            userResponse.setIs_active(1);

            userList.put(countId, userResponse);

            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<UserResponse> fetchUserResponse(long id) {
        try {
            UserResponse value = null;
            for (Map.Entry<Long, UserResponse> element : userList.entrySet()) {
                if (element.getKey() == id) {
                    value = element.getValue();
                }
            }
            return ResponseEntity.ok(value);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

//    @GetMapping("/search")
//    public ResponseEntity<Map<Long, UserResponse>> searchUsers(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String phone) {
//        try {
//            Map<Long, UserResponse> filteredUsers = userList.entrySet().stream()
//                    .filter(entry -> (name == null || entry.getValue().getName().equalsIgnoreCase(name)) &&
//                            (email == null || entry.getValue().getEmail().equalsIgnoreCase(email)) &&
//                            (phone == 0 || entry.getValue().getPhone()))
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//            if (filteredUsers.isEmpty()) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(filteredUsers);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(null);
//        }
//    }



    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserResponse(long id) {
        try{
            UserResponse removedValue = userList.remove(id);
            if (removedValue == null) {
                return ResponseEntity.status(404).body("User not found.");
            }
            return ResponseEntity.ok("User deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponse> fetchUserResponse(@RequestBody UserRequest userRequest, long id) {

        try {
            if (!userList.containsKey(id)) {
                throw new RuntimeException("User not found with id: " + id);
            }
            UserResponse value = null;
            for(Map.Entry<Long, UserResponse> element : userList.entrySet()) {

                if (element.getKey() == id) {
                    value = element.getValue();

                    if (userRequest.getName() != null) {
                        value.setName(userRequest.getName());
                    }
                    if (userRequest.getEmail() != null) {
                        value.setEmail(userRequest.getEmail());
                    }
                    if (userRequest.getPassword() != null) {
                        value.setPassword(userRequest.getPassword());
                    }
                    if (userRequest.getPhone() != 0) {
                        value.setPhone(userRequest.getPhone());
                    }

                    value.setStatus("User updated successfully");
                    long currentUpdMillis = System.currentTimeMillis();
                    // Convert milliseconds to Date object
                    Date updDate = new Date(currentUpdMillis);
                    value.setUpdated_at(updDate);
                }
            }

            return ResponseEntity.ok(value);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }

    }
}
