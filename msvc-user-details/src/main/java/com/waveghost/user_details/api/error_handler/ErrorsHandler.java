package com.waveghost.user_details.api.error_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.waveghost.user_details.api.dtos.response.error.ErrorResponse;
import com.waveghost.user_details.api.dtos.response.error.ErrorsResponse;
import com.waveghost.user_details.infrastructure.errors.UserDetailAlreadyExistException;
import com.waveghost.user_details.infrastructure.errors.UserDetailNotFoundException;

@RestControllerAdvice
public class ErrorsHandler {

    @ExceptionHandler({
        UserDetailNotFoundException.class,
        UserDetailAlreadyExistException.class
    })
    public ResponseEntity<ErrorResponse> handleSingleErrors(RuntimeException ex) {
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsResponse> handleValidError(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(
            ErrorsResponse.builder()
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList())
                .build()
        );
    }
}
