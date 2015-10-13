package com.powerlong.common;

/**
 * Created by Angus on 2015/5/30.
 */



public class BaseException extends Exception {
    private static final long serialVersionUID = 1L;
    protected String exceptionCode;
    protected String message;

    public BaseException() {
    }

    public BaseException(String code) {
        if (code != null) {
            this.exceptionCode = code;
        }

    }

    public BaseException(ExceptionEnum exceptionEnum) {
        if (exceptionEnum != null) {
            this.exceptionCode = exceptionEnum.getCode();
            this.message = exceptionEnum.getMessage();
        }

    }

    public BaseException(String code, String message) {
        if (code != null) {
            this.exceptionCode = code;
        }

        if (message != null) {
            this.message = message;
        }

    }

    public String getExceptionCode() {
        return this.exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
