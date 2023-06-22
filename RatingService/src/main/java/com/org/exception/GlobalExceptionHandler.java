package com.org.exception;

import com.org.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException e)
    {
        return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage() , false) , HttpStatus.NOT_FOUND);
    }

}
