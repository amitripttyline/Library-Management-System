package lms.demo.serviceimpl;

import lms.demo.dao.BookDao;
import lms.demo.model.BookRequest;
import lms.demo.model.BookResponse;
import lms.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public BookResponse registerBook(BookRequest bookRequest){
      System.out.println("==================register=====================");
        BookResponse bookResponse = new BookResponse();

        bookResponse.setIsbn(bookRequest.getIsbn());
        bookResponse.setTitle(bookRequest.getTitle());
        bookResponse.setStatus("Book registered successfully");

        bookResponse.setDescription(bookRequest.getDescription());
        bookResponse.setAuthor(bookRequest.getAuthor());
        bookResponse.setAdded_by(bookRequest.getAdded_by());
        bookResponse.setLanguage(bookRequest.getLanguage());
        bookResponse.setIs_available(1);
        bookResponse.setCreated_at(new Date());
        bookResponse.setUpdated_at(new Date());
        BookResponse savedBook = bookDao.save(bookResponse);
        return convertToBookResponse(savedBook);
    }

    public Map<String, Object> getBookById(Long id){
        Map<String, Object> response = new HashMap<>();

        BookResponse book = bookDao.findById(id);

        if (book == null) {
            response.put("book", null);
            response.put("status", null);
            response.put("error", "Book not found with id: " + id);
            return response;
        }

        BookResponse bookResponse = convertToBookResponse(book);
        response.put("user", bookResponse);
        response.put("status", "User retrieved successfully");
        response.put("error", null);

        return response;

    }
    public List<BookResponse> getAllBooks(){
        return bookDao.findAll().stream().map(this::convertToBookResponse).collect(Collectors.toList());
    }
    public Map<String, Object> deleteBook(Long id){
        Map<String, Object> response = new HashMap<>();

        BookResponse book = bookDao.findById(id);

        if (book == null) {
            response.put("book", null);
            response.put("status", null);
            response.put("error", "Book not found with id: " + id);
            return response;
        }

        // Convert to BookResponse before deleting
        BookResponse bookResponse = convertToBookResponse(book);

        // Delete the user
        bookDao.deleteById(id);

        response.put("user", bookResponse);
        response.put("status", "Book deleted successfully");
        response.put("error", null);

        return response;

    }
    public BookResponse updateBook(BookRequest bookRequest, Long id){
        BookResponse bookResponse = bookDao.findById(id);

        if (bookResponse == null){
            return null;
        }

        if (bookRequest.getIsbn() != 0) {
            bookResponse.setIsbn(bookRequest.getIsbn());
        }

        if (bookRequest.getTitle() != null) {
            bookResponse.setTitle(bookRequest.getTitle());
        }
        if (bookRequest.getAuthor() != null) {
            bookResponse.setAuthor(bookRequest.getAuthor());
        }
        if (bookRequest.getAdded_by() != null) {
            bookResponse.setAdded_by(bookRequest.getAdded_by());
        }
        if (bookRequest.getDescription() != null) {
            bookResponse.setDescription(bookRequest.getDescription());
        }
        if (bookRequest.getLanguage() != null) {
            bookResponse.setLanguage(bookRequest.getLanguage());
        }


        bookResponse.setStatus("User updated successfully");
        bookResponse.setUpdated_at(new Date());

        BookResponse updatedBook = bookDao.update(bookResponse);
        return convertToBookResponse(updatedBook);

    }

    private BookResponse convertToBookResponse(BookResponse book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setStatus(book.getStatus());
        response.setDescription(book.getDescription());
        response.setAuthor(book.getAuthor());
        response.setAdded_by(book.getAdded_by());
        response.setLanguage(book.getLanguage());
        response.setIs_available(1);
        response.setCreated_at(new Date());
        response.setUpdated_at(new Date());
        return response;
    }
}
