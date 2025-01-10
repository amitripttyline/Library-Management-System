package lms.demo.dao;

import lms.demo.entity.User;

import java.util.List;

public interface UserDao {

    User save(User user);
    User findById(Long Id);
    List<User> findAll();
    void deleteById(Long id);
    User update(User user);
    boolean existsById(Long id);

}
