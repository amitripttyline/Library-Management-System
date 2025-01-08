package lms.demo.controller;


import lms.demo.model.BookResponse;
import lms.demo.model.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/library")

public class UserBookController {
    HashMap<Long, UserResponse> usermap = UserController.userList;
    HashMap<Long, BookResponse> bookmap = BookController.bookList;










}
