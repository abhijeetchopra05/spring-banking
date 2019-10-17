package com.personal.banking.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<CustomResponseException> handleException() {
        return new ResponseEntity<>(new CustomResponseException(1000, "User already exist"), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RoleDoesNotExistException.class)
    public ResponseEntity<CustomResponseException> handleRoleDoesNotExistException() {
        return new ResponseEntity<>(new CustomResponseException(1001, "Role does not exist"), HttpStatus.NOT_FOUND);
    }
}
