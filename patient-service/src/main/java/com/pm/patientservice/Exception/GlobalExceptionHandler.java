package com.pm.patientservice.Exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String>  errors =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error ->  errors.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(EmailNotExistEception.class)
    public ResponseEntity<Map<String,String>> handleEmailNotExistException(EmailNotExistEception ex){
     log.warn("Email already Exist {}",ex.getMessage());
        Map<String,String>  errors =new HashMap<>();
        errors.put("message","Email Already Exist");
        return ResponseEntity.badRequest().body(errors);
    }
}
