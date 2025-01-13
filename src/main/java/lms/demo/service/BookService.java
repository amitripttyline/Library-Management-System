package lms.demo.service;

import lms.demo.model.BookRequest;
import lms.demo.model.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Component
public interface BookService {


    public Map<String, Object> getBookById(Long id);
    List<BookResponse> getAllBooks();
    public Map<String, Object> deleteBook(Long id);
    BookResponse updateBook(BookRequest bookRequest, Long id);
    BookResponse registerBook(BookRequest bookRequest);

}
