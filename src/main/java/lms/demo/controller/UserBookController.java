package lms.demo.controller;


import lms.demo.model.UserBookRequest;
import lms.demo.model.UserBookResponse;
import lms.demo.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/library")
public class UserBookController {

//  @Autowired
//  private final UserBookService userBookService;
//
//  public UserBookController(UserBookService userBookService) {
//    this.userBookService = userBookService;
//  }
//
//  @PostMapping("/borrow")
//  public ResponseEntity<UserBookResponse> borrowBook(@RequestBody UserBookRequest request) {
//    UserBookResponse response = userBookService.borrowBook(request);
//    return ResponseEntity.ok(response);
//  }
//
//  @PostMapping("/{id}/return")
//  public ResponseEntity<UserBookResponse> returnBook(@PathVariable Long id) {
//    UserBookResponse response = userBookService.returnBook(id);
//    return ResponseEntity.ok(response);
//  }
//
//  @PostMapping("/{id}/renew")
//  public ResponseEntity<UserBookResponse> renewBook(@PathVariable Long id) {
//    UserBookResponse response = userBookService.renewBook(id);
//    return ResponseEntity.ok(response);
//  }
//
//  @GetMapping("/{id}")
//  public ResponseEntity<UserBookResponse> getUserBook(@PathVariable Long id) {
//    UserBookResponse response = userBookService.getUserBook(id);
//    return ResponseEntity.ok(response);
//  }
//
//  @GetMapping("/user/{userId}")
//  public ResponseEntity<List<UserBookResponse>> getUserBorrowedBooks(@PathVariable Long userId) {
//    List<UserBookResponse> responses = userBookService.getUserBorrowedBooks(userId);
//    return ResponseEntity.ok(responses);
//  }
//
//  @GetMapping("/overdue")
//  public ResponseEntity<List<UserBookResponse>> getOverdueBooks() {
//    List<UserBookResponse> responses = userBookService.getOverdueBooks();
//    return ResponseEntity.ok(responses);
//  }
//
//  @DeleteMapping("/{id}")
//  public ResponseEntity<Void> deleteUserBook(@PathVariable Long id) {
//    userBookService.deleteUserBook(id);
//    return ResponseEntity.ok(null);
//  }
}
