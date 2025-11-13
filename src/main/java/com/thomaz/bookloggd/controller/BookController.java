package com.thomaz.bookloggd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomaz.bookloggd.model.Book;
import com.thomaz.bookloggd.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
