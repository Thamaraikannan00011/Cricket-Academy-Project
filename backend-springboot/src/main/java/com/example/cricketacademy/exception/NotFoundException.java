package com.example.cricketacademy.exception;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }
}
