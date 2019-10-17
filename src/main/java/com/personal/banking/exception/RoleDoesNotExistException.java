package com.personal.banking.exception;

public class RoleDoesNotExistException extends RuntimeException {

    private String message;
    private int code;

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
}
