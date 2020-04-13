package com.zhupeng.common.sys.exception;

import com.zhupeng.common.sys.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class DefualtExceptionHandler {

    /**
     * 捕抓到已知异常
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult baseException(BaseException e){
        e.printStackTrace();
        log.error("异常信息：" + e.toString());
        return new ResponseResult(e.getCode() , e.getData() , e.getErrorMessage());
    }


    /**
     * 捕抓到未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception e){
        e.printStackTrace();
        log.error("异常信息：" + e.toString());
        return new ResponseResult(400 , null , e.toString());
    }
}
