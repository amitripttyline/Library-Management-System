package lms.demo.service;

import lms.demo.model.BookRequest;
import lms.demo.model.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Map;

public interface BookService {

    public ResponseEntity<String> checkHealth();

    public ResponseEntity<BookResponse> bookRequest(@RequestBody BookRequest bookRequest);

    public ResponseEntity<BookResponse> fetchBookResponse(long id);

    public ResponseEntity<String> deleteBookResponse(long id);

    public ResponseEntity<BookResponse> updateBookResponse(@RequestBody BookRequest bookRequest, long id);

}
