package com.lcwd.user.service.exceptions;

import com.lcwd.user.service.payload.ApiResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = ApiResponse.builder()
                .message(message)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.status(404).body(apiResponse);
    }

    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = ApiResponse.builder()
                .message(message)
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.status(400).body(apiResponse);
    }
}
