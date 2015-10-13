package com.powerlong.common;

/**
 * Created by Angus on 2015/5/30.
 */

public class SystemException extends BaseException {
    private static final long serialVersionUID = -1344852932375992652L;

    public SystemException() {
    }

    public SystemException(String code) {
        if(code != null) {
            super.exceptionCode = code;
        }

    }

    public SystemException(ExceptionEnum exceptionEnum) {
        if(exceptionEnum != null) {
            super.exceptionCode = exceptionEnum.getCode();
            super.message = exceptionEnum.getMessage();
        }

    }
}
