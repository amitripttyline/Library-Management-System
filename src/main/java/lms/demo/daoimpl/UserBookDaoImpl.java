package lms.demo.daoimpl;

import lms.demo.dao.UserBookDao;
import lms.demo.model.BorrowStatus;
import lms.demo.model.UserBookResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserBookDaoImpl implements UserBookDao {

//  private final JdbcTemplate jdbcTemplate;
//
//  private final RowMapper<UserBookResponse> rowMapper = (ResultSet rs, int rowNum) -> {
//    UserBookResponse userBook = new UserBookResponse();
//    userBook.setId(rs.getLong("id"));
//    // Set other fields from ResultSet
//    return userBook;
//  };
//
//  public UserBookDaoImpl(JdbcTemplate jdbcTemplate) {
//    this.jdbcTemplate = jdbcTemplate;
//  }
//
//  @Override
//  public UserBookResponse save(UserBookResponse userBook) {
//    if (userBook.getId() == null) {
//      // Insert
//      String sql = "INSERT INTO user_books (user_id, book_id, borrow_date, due_date, status) " +
//              "VALUES (?, ?, ?, ?, ?)";
//      jdbcTemplate.update(sql,
//              userBook.getUser().getId(),
//              userBook.getBook().getId(),
//              userBook.getBorrowDate(),
//              userBook.getDueDate(),
//              userBook.getStatus().toString()
//      );
//    } else {
//      // Update
//      String sql = "UPDATE user_books SET return_date = ?, status = ? WHERE id = ?";
//      jdbcTemplate.update(sql,
//              userBook.getReturnDate(),
//              userBook.getStatus().toString(),
//              userBook.getId()
//      );
//    }
//    return userBook;
//  }
//
//  @Override
//  public Optional<UserBookResponse> findById(Long id) {
//    String sql = "SELECT * FROM user_books WHERE id = ?";
//    List<UserBookResponse> results = jdbcTemplate.query(sql, rowMapper, id);
//    return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
//  }
//
//  @Override
//  public List<UserBookResponse> findAll() {
//    return jdbcTemplate.query("SELECT * FROM user_books", rowMapper);
//  }
//
//  @Override
//  public List<UserBookResponse> findByUserId(Long userId) {
//    return jdbcTemplate.query(
//            "SELECT * FROM user_books WHERE user_id = ?",
//            rowMapper,
//            userId
//    );
//  }
//
//  @Override
//  public List<UserBookResponse> findByBookId(Long bookId) {
//    return null;
//  }
//
//  @Override
//  public List<UserBookResponse> findByStatus(BorrowStatus status) {
//    return null;
//  }
//
//  @Override
//  public List<UserBookResponse> findOverdueBooks() {
//    return jdbcTemplate.query(
//            "SELECT * FROM user_books WHERE due_date < ? AND status = ?",
//            rowMapper,
//            LocalDateTime.now(),
//            BorrowStatus.BORROWED.toString()
//    );
//  }
//
//  @Override
//  public List<UserBookResponse> findByUserIdAndStatus(Long userId, BorrowStatus status) {
//    return null;
//  }
//
//  @Override
//  public void delete(Long id) {
//
//  }
//
//  @Override
//  public boolean existsById(Long id) {
//    return false;
//  }
//
//  @Override
//  public int countActiveBooksByUser(Long userId) {
//    return jdbcTemplate.queryForObject(
//            "SELECT COUNT(*) FROM user_books WHERE user_id = ? AND status = ?",
//            Integer.class,
//            userId,
//            BorrowStatus.BORROWED.toString()
//    );
//  }
}
