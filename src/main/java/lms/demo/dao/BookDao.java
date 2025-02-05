package lms.demo.dao;

import lms.demo.model.BookResponse;

import java.util.List;

public interface BookDao {

  BookResponse save(BookResponse bookResponse);
  BookResponse findById(long id);
  List<BookResponse> findAll();
  void deleteById(long id);
  BookResponse update(BookResponse bookResponse);
  boolean existsById(long id);

}
