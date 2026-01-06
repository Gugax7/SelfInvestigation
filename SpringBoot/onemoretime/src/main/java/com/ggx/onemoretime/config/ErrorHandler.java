package com.ggx.onemoretime.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
  
}
