package com.google.sps.data;

public class Error extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final String errorMessage;
    private final int code;

    public Error(String message, int code){
        this.errorMessage = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return errorMessage;
    }
}