package lms.demo.daoimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lms.demo.dao.UserDao;
import lms.demo.model.UserResponse;
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
    public UserResponse save(UserResponse userResponse){
        entityManager.persist(userResponse);
        return userResponse;
    }

    @Override
    public UserResponse findById(Long id){
        return entityManager.find(UserResponse.class, id);
    }

    @Override
    public UserResponse findByEmail(String email) {
        String query = "SELECT u FROM UserResponse u WHERE u.email = :email";
        return entityManager.createQuery(query, UserResponse.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UserResponse> findAll(){
        return entityManager.createQuery("SELECT u FROM UserResponse u", UserResponse.class).getResultList();
    }

    @Override
    public void deleteById(Long id){
        UserResponse userResponse = findById(id);
        if(userResponse != null){
            entityManager.remove(userResponse);
        }
    }
    @Override
    public UserResponse update(UserResponse userResponse){
        return entityManager.merge(userResponse);
    }

    @Override
    public boolean existsById(Long id){
        return findById(id) != null;
    }

}
