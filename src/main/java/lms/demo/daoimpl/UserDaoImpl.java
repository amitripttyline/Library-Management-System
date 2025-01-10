package lms.demo.daoimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lms.demo.dao.UserDao;
import lms.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user){
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findById(Long id){
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll(){
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void deleteById(Long id){
        User user = findById(id);
        if(user != null){
            entityManager.remove(user);
        }
    }

    @Override
    public User update(User user){
        return entityManager.merge(user);
    }

    @Override
    public boolean existsById(Long id){
        return findById(id) != null;
    }

}
