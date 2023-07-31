package com.example.Bitirme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice

public class CustomExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFound(ProductNotFoundException productNotFoundException){
        List<String> detail = new ArrayList<>();
        detail.add(productNotFoundException.getMessage());
        ErrorResponse response= new ErrorResponse("Product Not Found" , detail);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> categoryNotFound(CategoryNotFoundException notFoundException){
        List<String> detail = new ArrayList<>();
        detail.add(notFoundException.getMessage());
        ErrorResponse response =new ErrorResponse("Category Not Found", detail);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProductIdNotFound.class)
    public ResponseEntity<?> IdNotFound(ProductIdNotFound productIdNotFound){
        List<String> detail = new ArrayList<>();
        detail.add(productIdNotFound.getMessage());
        ErrorResponse response = new ErrorResponse("Product Id Not Found" , detail);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryIdNotFound.class)
    public ResponseEntity<?> CategoryIdNotFound(CategoryIdNotFound categoryIdNotFound){
        List<String> detail= new ArrayList<>();
        detail.add(categoryIdNotFound.getMessage());
        ErrorResponse response =new ErrorResponse("Category Id Not Found", detail);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
