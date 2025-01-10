package lms.demo.serviceimpl;

import lms.demo.dao.UserDao;
import lms.demo.entity.User;
import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import lms.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserResponse registerUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        user.setStatus("User registered successfully");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setIs_active(1);
        User savedUser = userDao.save(user);
        return convertToUserResponse(savedUser);

    }

    @Override
    public UserResponse getUserById(Long id){
        User user = userDao.findById(id);
        return user != null ? convertToUserResponse(user) : null;
    }

    @Override
    public List<UserResponse> getAllUsers(){
        return userDao.findAll().stream().map(this::convertToUserResponse).collect(Collectors.toList());
    }

    @Override
    public String deleteUser(Long id){
        if(!userDao.existsById(id)){
            return "User not found.";
        }
        userDao.deleteById(id);
        return "User delete successfully.";
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id){

        User user = userDao.findById(id);
        if (user == null){
            return null;
        }
        if (userRequest.getName() != null) {
            user.setName(userRequest.getName());
        }
        if (userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }
        if (userRequest.getPassword() != null) {
            user.setPassword(userRequest.getPassword());
        }
        if (userRequest.getPhone() != 0) {
            user.setPhone(userRequest.getPhone());
        }

        user.setStatus("User updated successfully");
        user.setUpdatedAt(new Date());

        User updatedUser = userDao.update(user);
        return convertToUserResponse(updatedUser);
    }

    private UserResponse convertToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setPhone(user.getPhone());
        response.setStatus(user.getStatus());
        response.setCreated_at(user.getCreatedAt());
        response.setUpdated_at(user.getUpdatedAt());
        response.setIs_active(1);
        return response;
    }
}
