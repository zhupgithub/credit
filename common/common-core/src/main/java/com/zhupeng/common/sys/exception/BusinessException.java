package com.zhupeng.common.sys.exception;

import com.zhupeng.common.sys.constant.ResultEnum;
import lombok.Data;

/**
 * 自定义系统异常
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private String errorMessage;

    private Object data;

    public BusinessException() {
        this.code = ResultEnum.DEFAULT_FAIL.getResultCode();
        this.errorMessage = ResultEnum.DEFAULT_FAIL.getResultMessage();
    }

    public BusinessException(Exception e) {
        this.code = ResultEnum.DEFAULT_FAIL.getResultCode();
        this.errorMessage = ResultEnum.DEFAULT_FAIL.getResultMessage() + ":" + e.toString();
    }

    public BusinessException(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BusinessException(Integer code, String errorMessage , Object data) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public BusinessException(ResultEnum resultEnum) {
        this.code = resultEnum.getResultCode();
        this.errorMessage = resultEnum.getResultMessage();
    }

    public BusinessException(ResultEnum resultEnum , Object data) {
        this.code = resultEnum.getResultCode();
        this.errorMessage = resultEnum.getResultMessage();
        this.data = data;
    }



}
