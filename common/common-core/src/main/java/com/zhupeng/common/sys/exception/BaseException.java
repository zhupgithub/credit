package com.zhupeng.common.sys.exception;

import com.zhupeng.common.sys.constant.ResultEnum;
import lombok.Data;

/**
 * 自定义异常基类
 */
@Data
public class BaseException extends RuntimeException{

    private Integer code;

    private String errorMessage;

    private Object data;

    public BaseException() {
        this.code = ResultEnum.DEFAULT_FAIL.getResultCode();
        this.errorMessage = ResultEnum.DEFAULT_FAIL.getResultMessage();
    }

    public BaseException(Exception e) {
        this.code = ResultEnum.DEFAULT_FAIL.getResultCode();
        this.errorMessage = ResultEnum.DEFAULT_FAIL.getResultMessage() + ":" + e.toString();
    }

    public BaseException(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public BaseException(Integer code, String errorMessage , Object data) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public BaseException(ResultEnum resultEnum) {
        this.code = resultEnum.getResultCode();
        this.errorMessage = resultEnum.getResultMessage();
    }

    public BaseException(ResultEnum resultEnum , Object data) {
        this.code = resultEnum.getResultCode();
        this.errorMessage = resultEnum.getResultMessage();
        this.data = data;
    }

    @Override
    public String toString(){
        return "{" +
                "\"code\":" + code +
                "\"data\":" + data +
                ", \"errorMessage\":\"" + errorMessage + "\"" +"}";
    }
}
