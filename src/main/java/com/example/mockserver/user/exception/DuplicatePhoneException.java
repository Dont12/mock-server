package com.example.mockserver.user.exception;

public class DuplicatePhoneException extends DuplicateValueException {

    public DuplicatePhoneException() {
    }

    public DuplicatePhoneException(String message) {
        super(message);
    }

    public DuplicatePhoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
