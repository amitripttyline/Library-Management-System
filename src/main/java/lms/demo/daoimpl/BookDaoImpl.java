package lms.demo.daoimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lms.demo.dao.BookDao;
import lms.demo.model.BookResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Component
public class BookDaoImpl implements BookDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public BookResponse save(BookResponse bookResponse) {
//    System.out.println("================save=======================");
//    System.out.println(entityManager);
//    entityManager.persist(bookResponse);
//    System.out.println(entityManager+"======================================="+bookResponse);
//    return bookResponse;
    try {
//      if (bookResponse.existsByIsbn(book.getIsbn())) {
//        throw new RuntimeException("ISBN must be unique");
//      }
      System.out.println("Book Response before persist: " + bookResponse);
      entityManager.persist(bookResponse);
      entityManager.flush();  // Force synchronization with the database
      System.out.println("Book Response after persist: " + bookResponse);
      return bookResponse;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public BookResponse findById(long id) {
    return entityManager.find(BookResponse.class, id);
  }

  @Override
  public List<BookResponse> findAll() {
    return entityManager.createQuery("SELECT b FROM BookResponse b", BookResponse.class).getResultList();
  }

  @Override
  public void deleteById(long id) {
    BookResponse bookResponse = findById(id);
    if(bookResponse != null){
      entityManager.remove(bookResponse);
    }
  }

  @Override
  public BookResponse update(BookResponse bookResponse) {
    return entityManager.merge(bookResponse);
  }

  @Override
  public boolean existsById(long id) {
    return findById(id) != null;
  }
}
