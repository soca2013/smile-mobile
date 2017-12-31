package com.smile.core.exceptions;

public class BussinessException extends Exception {

    private int code;

    private String errorMessage;


    public BussinessException(int code, String errorMessage) {
        super();
        this.errorMessage = errorMessage;
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
