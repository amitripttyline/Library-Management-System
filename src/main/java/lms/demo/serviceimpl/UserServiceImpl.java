package lms.demo.serviceimpl;

import lms.demo.dao.UserDao;
import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import lms.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserResponse registerUser(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        userResponse.setName(userRequest.getName());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setPassword(userRequest.getPassword());
        userResponse.setPhone(userRequest.getPhone());
        userResponse.setStatus("User registered successfully");
        userResponse.setCreatedAt(new Date());
        userResponse.setUpdatedAt(new Date());
        userResponse.setIs_active(1);
        UserResponse savedUser = userDao.save(userResponse);
        return convertToUserResponse(savedUser);

    }

    @Override
    public List<UserResponse> getAllUsers(){
        return userDao.findAll().stream().map(this::convertToUserResponse).collect(Collectors.toList());
    }



    public Map<String, Object> getUserById(Long id) {
        Map<String, Object> response = new HashMap<>();

        UserResponse user = userDao.findById(id);

        if (user == null) {
            response.put("user", null);
            response.put("status", null);
            response.put("error", "User not found with id: " + id);
            return response;
        }

        UserResponse userResponse = convertToUserResponse(user);
        response.put("user", userResponse);
        response.put("status", "User retrieved successfully");
        response.put("error", null);

        return response;
    }

    @Override
    public Map<String, Object> deleteUser(Long id) {
        Map<String, Object> response = new HashMap<>();

        UserResponse user = userDao.findById(id);

        if (user == null) {
            response.put("user", null);
            response.put("status", null);
            response.put("error", "User not found with id: " + id);
            return response;
        }

        // Convert to UserResponse before deleting
        UserResponse userResponse = convertToUserResponse(user);

        // Delete the user
        userDao.deleteById(id);

        response.put("user", userResponse);
        response.put("status", "User deleted successfully");
        response.put("error", null);

        return response;
    }


    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id){

        UserResponse userResponse = userDao.findById(id);
        if (userResponse == null){
            return null;
        }
        if (userRequest.getName() != null) {
            userResponse.setName(userRequest.getName());
        }
        if (userRequest.getEmail() != null) {
            userResponse.setEmail(userRequest.getEmail());
        }
        if (userRequest.getPassword() != null) {
            userResponse.setPassword(userRequest.getPassword());
        }
        if (userRequest.getPhone() != 0) {
            userResponse.setPhone(userRequest.getPhone());
        }

        userResponse.setStatus("User updated successfully");
        userResponse.setUpdatedAt(new Date());

        UserResponse updatedUser = userDao.update(userResponse);
        return convertToUserResponse(updatedUser);
    }

    private UserResponse convertToUserResponse(UserResponse user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setPhone(user.getPhone());
        response.setStatus(user.getStatus());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        response.setIs_active(1);
        return response;
    }
}
