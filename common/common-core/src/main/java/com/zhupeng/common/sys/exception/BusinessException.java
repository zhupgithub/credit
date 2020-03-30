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

    public BusinessException() {}


}
