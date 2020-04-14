package com.zhupeng.common.sys.exception;

import com.zhupeng.common.sys.constant.ResultEnum;
import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BusinessException extends BaseException {

    public BusinessException() {
        super();
    }

    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException(Integer code, String errorMessage) {
        super(code , errorMessage);
    }

    public BusinessException(Integer code, String errorMessage , Object data) {
        super(code , errorMessage , data);
    }

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public BusinessException(ResultEnum resultEnum , Object data) {
        super(resultEnum , data);
    }
}
