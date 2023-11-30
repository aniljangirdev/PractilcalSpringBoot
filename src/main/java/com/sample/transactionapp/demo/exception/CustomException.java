package com.sample.transactionapp.demo.exception;

import com.sample.transactionapp.demo.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> exceptionBadRequest(Exception e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        return ResponseEntity.internalServerError().body(errorDetails);
    }
}
