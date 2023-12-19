package com.HotelService.HotelService.exception;

import com.HotelService.HotelService.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> exceptionHandler(ResourceNotFoundException exception)
    {
        ApiResponse apiResponse = ApiResponse.builder()
                .message(exception.getMessage())
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
