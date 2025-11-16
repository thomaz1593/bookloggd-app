package com.thomaz.bookloggd.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private List<String> errors;
    
    // Construtor para erros simples
    public ErrorResponse(String message, int status) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Construtor para erros de validação (múltiplos erros)
    public ErrorResponse(List<String> errors,int status) {
        this.status = status;
        this.errors = errors;
        this.message = "Validation failed";
        this.timestamp = LocalDateTime.now();
    }

    // Construtor para erro genérico
    public ErrorResponse(int status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
