package com.org.exception;

import com.org.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ApiResponse> handleException(ResourceNotFoundExceptions ex)
    {
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(ex.getMessage()).success(false).build(), HttpStatus.NOT_FOUND);
    }
}
