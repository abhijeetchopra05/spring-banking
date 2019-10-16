package com.personal.banking.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends RuntimeException {

    private String message;
    private int code;
    private HttpStatus httpStatus;

    UserAlreadyExistException(String message, int code, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    UserAlreadyExistException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
