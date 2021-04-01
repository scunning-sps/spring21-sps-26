package com.google.sps.data;

public class Error{
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