package com.zhupeng.common.sys.exception;

import com.zhupeng.common.sys.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class DefualtExceptionHandler {

    /**
     * 捕抓到已知异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessException(BusinessException e){
        return new ResponseResult(e.getCode() , null , e.getErrorMessage());
    }


    /**
     * 捕抓到未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception e){
        return new ResponseResult(400 , null , e.toString());
    }
}
