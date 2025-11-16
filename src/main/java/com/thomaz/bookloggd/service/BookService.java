package com.thomaz.bookloggd.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thomaz.bookloggd.enums.BookStatus;
import com.thomaz.bookloggd.exceptions.BookNotFoundException;
import com.thomaz.bookloggd.model.Book;
import com.thomaz.bookloggd.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book newBook(Book book) {
        if (book.getReadingStatus() == null) book.setReadingStatus(BookStatus.WANT_TO_READ);
        if (book.getDateAdded() == null) book.setDateAdded(LocalDate.now());
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book editBookById(Long id, Book book) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setGenre(book.getGenre());
        existingBook.setDescription(book.getDescription());
        existingBook.setCoverUrl(book.getCoverUrl());
        existingBook.setReadingStatus(book.getReadingStatus());
        return bookRepository.save(existingBook);
    }

    public void deleteBookById(Long id) {
        Book existingBook = getBookById(id);
        bookRepository.deleteById(existingBook.getId());
    }
}
