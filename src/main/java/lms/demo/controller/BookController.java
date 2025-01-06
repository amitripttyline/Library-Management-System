package lms.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import lms.demo.model.BookRequest;
import lms.demo.model.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class BookController {
     long countId = 0;
     HashMap<Long, BookResponse> bookList = new HashMap<>();
    @Autowired

    @GetMapping("/health/amit")
    public String checkHealth() {
        return "Connection successfully!";
    }

    // Store the last book request
    private BookRequest lastBookRequest;

    @PostMapping("/request")
    public ResponseEntity<BookResponse> bookRequest(@RequestBody BookRequest bookRequest) {
        // Store the request for later use
        this.lastBookRequest = bookRequest;
        if (lastBookRequest == null) {
            return ResponseEntity.badRequest().build();
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setId(++countId);
        bookResponse.setTitle(lastBookRequest.getTitle());
        bookResponse.setStatus("Book registered successfully");

        bookResponse.setDescription(lastBookRequest.getDescription());
        bookResponse.setAuthor(lastBookRequest.getAuthor());
        bookResponse.setAdded_by(lastBookRequest.getAdded_by());
        bookResponse.setLanguage(lastBookRequest.getLanguage());
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
    }



    @GetMapping("/fetch/{id}")
    public ResponseEntity<BookResponse> fetchbookResponse(long id) {
        BookResponse value = null;
        for(Map.Entry<Long, BookResponse> element : bookList.entrySet()) {
            if (element.getKey() == id) {
                value = element.getValue();

            }
        }
        return ResponseEntity.ok(value);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponse> deletebookResponse(long id) {
        BookResponse removedValue = bookList.remove(id);
//        for(Map.Entry<Long, BookResponse> element : bookList.entrySet()) {
//            if (element.getKey() == id) {
//                value = element.getValue();
//                bookList.remove(element);
//
//            }
//        }
        return ResponseEntity.ok(removedValue);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponse> fetchbookResponse(@RequestBody BookRequest bookRequest, long id) {
        System.out.println("I am here part 1" + bookList);
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
        System.out.println("I am here with value" + value);
        System.out.println("I am here with list" + bookList);


        return ResponseEntity.ok(value);    }
}
