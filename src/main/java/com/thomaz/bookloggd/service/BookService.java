package com.thomaz.bookloggd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thomaz.bookloggd.model.Book;
import com.thomaz.bookloggd.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    Book bookTest = new Book();

    public List<Book> getAllBooks() {
        bookTest.setTitle("Test Book");
        bookTest.setAuthor("Test Author");
        bookTest.setIsbn("1234-5678-900");
        bookTest.setGenre("Test Genre");
        bookTest.setDescription("This is a test description");
        bookTest.setCoverUrl("");
        bookRepository.save(bookTest);
        return bookRepository.findAll();
    }
}
