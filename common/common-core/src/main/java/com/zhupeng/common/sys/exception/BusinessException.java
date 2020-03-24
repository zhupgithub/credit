package com.zhupeng.common.sys.exception;

import lombok.Data;

/**
 * 自定义系统异常
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private String errorMessage;

    public BusinessException(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String message, Integer code, String errorMessage) {
        super(message);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String message, Throwable cause, Integer code, String errorMessage) {
        super(message, cause);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BusinessException(Throwable cause, Integer code, String errorMessage) {
        super(cause);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code, String errorMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
