package com.teste.exemplo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.exemplo.model.error.ErrorMessage;
import com.teste.exemplo.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {

        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus
                            .NOT_FOUND.value(), e.getMessage());                    
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
