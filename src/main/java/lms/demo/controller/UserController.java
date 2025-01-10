package lms.demo.controller;


import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import lms.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth(){
        try {
            return ResponseEntity.ok("Connection successfully!");
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Health Check failed " + e.getMessage());
        }
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest){
        try {
            if (userRequest == null) {
                return ResponseEntity.badRequest().body(null);
            }
            UserResponse response = userService.registerUser(userRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<UserResponse> getUser(Long id){
        try{
            UserResponse response = userService.getUserById(id);
            if(response == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/retrieve_all")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(Long id){
        try {
            String result = userService.deleteUser(id);
            if(result.contains("not found")){
                return ResponseEntity.status(404).body(result);
            }
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, Long id){
        try {
            UserResponse response = userService.updateUser(userRequest, id);
            if (response == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }

    }



}
