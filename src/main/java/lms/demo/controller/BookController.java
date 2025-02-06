package lms.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import lms.demo.model.BookRequest;
import lms.demo.model.BookResponse;
import lms.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/books")

public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        try {
            return ResponseEntity.ok("Connection successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Health check failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<BookResponse> registerBook(@RequestBody BookRequest bookRequest){
        try {
            if (bookRequest == null) {
                return ResponseEntity.badRequest().body(null);
            }
            BookResponse response = bookService.registerBook(bookRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/retrieve")
    public ResponseEntity<Map<String, Object>> getBook(long id) {
        try {
            Map<String, Object> response = bookService.getBookById(id);

            if (response.get("error") != null) {
                return ResponseEntity.status(404).body(response);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("user", null);
            errorResponse.put("status", null);
            errorResponse.put("error", "Error occurred: " + e.getMessage());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    @GetMapping("/retrieve_all")
    public ResponseEntity<?> getAllBooks(@RequestHeader("Authorization") String token) {
        System.out.println("===================check valid:" + AuthController.isValidToken(token)+ "================");
        if (AuthController.isValidToken(token)) {

            return ResponseEntity.ok(bookService.getAllBooks());
        }
        return ResponseEntity.status(401).body("Unauthorized: Invalid Token");
    }

//    @GetMapping("/retrieve_all")
//    public List<BookResponse> getAllBooks() {
//        return bookService.getAllBooks();
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteBook(long id) {
        try {
            Map<String, Object> response = bookService.deleteBook(id);

            if (response.get("error") != null) {
                return ResponseEntity.status(404).body(response);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("user", null);
            errorResponse.put("status", null);
            errorResponse.put("error", "Error occurred: " + e.getMessage());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookRequest bookRequest, long id){
        try {
            BookResponse response = bookService.updateBook(bookRequest, id);
            if (response == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }

    }


}
