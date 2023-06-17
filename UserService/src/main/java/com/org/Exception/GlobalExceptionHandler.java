package com.org.Exception;

import com.org.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> invalidResource(ResourceNotFoundException e)
    {
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(e.getMessage()).successfull(false).build(), HttpStatus.NOT_FOUND);
    }
}
