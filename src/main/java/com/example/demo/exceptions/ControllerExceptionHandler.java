package com.example.demo.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<StandardError> userNotFound(UserNotFoundException e, HttpServletRequest httpServletRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError(e.getMessage(),System.currentTimeMillis(),
                httpServletRequest.getRequestURI(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<StandardError> userNotFound(DataIntegrityViolationException e, HttpServletRequest httpServletRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError("Data Integrity Violation",System.currentTimeMillis(),
                httpServletRequest.getRequestURI(), HttpStatus.BAD_REQUEST.value()));
    }
}
