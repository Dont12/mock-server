package com.example.mockserver.common.exception;

import com.example.mockserver.common.response.ErrorResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseBody> handleException(MethodArgumentNotValidException ex) {
        logger.warn("invalid request", ex);
        return ResponseEntity
            .badRequest()
            .body(new ErrorResponseBody(false, 400, ex.getMessage(), ex));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseBody> handleException(Exception ex) {
        logger.error("error occur!", ex);
        return ResponseEntity
            .internalServerError()
            .body(new ErrorResponseBody(false, 500, ex.getMessage(), ex));
    }
}
