package lms.demo.serviceimpl;


import jakarta.transaction.Transactional;
import lms.demo.dao.UserBookDao;
import lms.demo.model.BorrowStatus;
import lms.demo.model.UserBookRequest;
import lms.demo.model.UserBookResponse;
import lms.demo.service.UserBookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserBookServiceImpl implements UserBookService {

//  private final UserBookDao userBookDao;
//  private static final int MAX_BOOKS_PER_USER = 5;
//  private static final double FINE_RATE_PER_DAY = 1.0;
//
//  public UserBookServiceImpl(UserBookDao userBookDao) {
//    this.userBookDao = userBookDao;
//  }
//
//  @Override
//  @Transactional
//  public UserBookResponse borrowBook(UserBookRequest request) {
//    // Check if user has reached maximum books limit
//    int activeBooks = userBookDao.countActiveBooksByUser(request.getUserId());
////    if (activeBooks >= MAX_BOOKS_PER_USER) {
////      throw new CustomException("Maximum books limit reached", HttpStatus.BAD_REQUEST);
////    }
//
//    UserBookResponse userBook = new UserBookResponse();
//    // Set userBook properties
//    userBook.setBorrowDate(LocalDateTime.parse(request.getBorrowDate()));
//    userBook.setDueDate(LocalDateTime.parse(request.getDueDate()));
//    userBook.setStatus(BorrowStatus.BORROWED);
//
//    userBook = userBookDao.save(userBook);
//    return mapToUserBookResponse(userBook);
//  }
//
//  @Override
//  @Transactional
//  public UserBookResponse returnBook(Long id) {
////    UserBookResponse userBook = userBookDao.findById(id)
////            .orElseThrow(() -> new CustomException("UserBook not found", HttpStatus.NOT_FOUND));
////
////    if (userBook.getStatus() == BorrowStatus.RETURNED) {
////      throw new CustomException("Book already returned", HttpStatus.BAD_REQUEST);
////    }
////
////    userBook.setReturnDate(LocalDateTime.now());
////    userBook.setStatus(BorrowStatus.RETURNED);
////
////    userBook = userBookDao.save(userBook);
////    return mapToUserBookResponse(userBook);
//    return null;
//  }
//
//  @Override
//  public UserBookResponse renewBook(Long id) {
//    return null;
//  }
//
//  @Override
//  public UserBookResponse getUserBook(Long id) {
//    return null;
//  }
//
//  @Override
//  public List<UserBookResponse> getAllUserBooks() {
//    return null;
//  }
//
//  @Override
//  public List<UserBookResponse> getUserBorrowedBooks(Long userId) {
//    return null;
//  }
//
//  @Override
//  public List<UserBookResponse> getOverdueBooks() {
//    return null;
//  }
//
//  @Override
//  public void deleteUserBook(Long id) {
//
//  }
//
//
//  private UserBookResponse mapToUserBookResponse(UserBookResponse userBook) {
//    UserBookResponse response = new UserBookResponse();
//    response.setId(userBook.getId());
//    response.setBorrowDate(userBook.getBorrowDate());
//    response.setDueDate(userBook.getDueDate());
//    response.setStatus(userBook.getStatus());
//    response.setRemarks(userBook.getRemarks());
//
//    if (userBook.getReturnDate() != null) {
//      response.setReturnDate(userBook.getReturnDate());
//    }
//
//    response.setOverdue(userBook.isOverdue());
//    response.setDaysOverdue((int) userBook.getDaysOverdue());
//    response.setFineAmount(userBook.getDaysOverdue() * FINE_RATE_PER_DAY);
//
//    return response;
//  }

}
