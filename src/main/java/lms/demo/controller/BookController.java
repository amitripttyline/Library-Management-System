package lms.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import lms.demo.model.BookRequest;
import lms.demo.model.BookResponse;
import lms.demo.model.UserRequest;
import lms.demo.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/books")

public class BookController {
     long countId = 0;
     public static HashMap<Long, BookResponse> bookList = new HashMap<>();
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        try {
            return ResponseEntity.ok("Connection successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Health check failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<BookResponse> bookRequest(@RequestBody BookRequest bookRequest) {
        try {

            if (bookRequest == null) {
                return ResponseEntity.badRequest().body(null);
            }

            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(++countId);
            bookResponse.setTitle(bookRequest.getTitle());
            bookResponse.setStatus("Book registered successfully");

            bookResponse.setDescription(bookRequest.getDescription());
            bookResponse.setAuthor(bookRequest.getAuthor());
            bookResponse.setAdded_by(bookRequest.getAdded_by());
            bookResponse.setLanguage(bookRequest.getLanguage());
            bookResponse.setIs_available(1);
            long currentMillis = System.currentTimeMillis();
            // Convert milliseconds to Date object
            Date currentDate = new Date(currentMillis);
            bookResponse.setCreated_at(currentDate);
            long currentUpdMillis = System.currentTimeMillis();
            // Convert milliseconds to Date object
            Date updDate = new Date(currentUpdMillis);
            bookResponse.setUpdated_at(updDate);
            bookResponse.setIs_deleted("false");

            bookList.put(countId, bookResponse);
            System.out.println(bookList);

            return ResponseEntity.ok(bookResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<BookResponse> fetchbookResponse(long id) {
        try {
            BookResponse value = null;
            for(Map.Entry<Long, BookResponse> element : bookList.entrySet()) {
                if (element.getKey() == id) {
                    value = element.getValue();

                }
            }
            return ResponseEntity.ok(value);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBookResponse(long id) {
        try{
            BookResponse removedValue = bookList.remove(id);
            if (removedValue == null) {
                return ResponseEntity.status(404).body("Book not found.");
            }
            return ResponseEntity.ok("Book deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error occurred: " + e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<BookResponse> fetchBookResponse(@RequestBody BookRequest bookRequest, long id) {
        try {
            if (!bookList.containsKey(id)) {
                throw new RuntimeException("Book not found with id: " + id);
            }
            BookResponse value = null;
            for(Map.Entry<Long, BookResponse> element : bookList.entrySet()) {

                if (element.getKey() == id) {
                    value = element.getValue();

                    if (bookRequest.getTitle() != null) {
                        value.setTitle(bookRequest.getTitle());
                    }
                    if (bookRequest.getAuthor() != null) {
                        value.setAuthor(bookRequest.getAuthor());
                    }
                    if (bookRequest.getAdded_by() != null) {
                        value.setAdded_by(bookRequest.getAdded_by());
                    }
                    if (bookRequest.getDescription() != null) {
                        value.setDescription(bookRequest.getDescription());
                    }
                    if (bookRequest.getLanguage() != null) {
                        value.setLanguage(bookRequest.getLanguage());
                    }
                    value.setStatus("Book updated successfully");
                    long currentUpdMillis = System.currentTimeMillis();
                    // Convert milliseconds to Date object
                    Date updDate = new Date(currentUpdMillis);
                    value.setUpdated_at(updDate);
                }
            }
            return ResponseEntity.ok(value);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }

    }
}
