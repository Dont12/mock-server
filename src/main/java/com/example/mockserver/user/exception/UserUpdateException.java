package com.example.mockserver.user.exception;

public class UserUpdateException extends RuntimeException {

    public UserUpdateException() {
    }

    public UserUpdateException(String message) {
        super(message);
    }

    public UserUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
