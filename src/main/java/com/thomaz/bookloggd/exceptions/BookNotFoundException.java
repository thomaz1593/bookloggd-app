package com.thomaz.bookloggd.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Produto com ID " + id + " não encontrado");
    }
}
