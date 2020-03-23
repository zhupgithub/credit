package com.zhupeng.common.sys.entity;

import com.zhupeng.common.sys.constant.ResultEnum;
import lombok.Data;

@Data
public class ResponseResult {
    //响应码
    private int resultCode;
    //响应数据
    private Object resultData;
    //响应提示信息
    private String resultMessage;

    //Feign的返回值，必须要存在无参的构造函数
    public ResponseResult() {
    }

    public ResponseResult(int resultCode, Object resultData, String resultMessage) {
        this.resultCode = resultCode;
        this.resultData = resultData;
        this.resultMessage = resultMessage;
    }

    public static ResponseResult defaultSuccessResult(){
        return new ResponseResult(ResultEnum.DEFAULT_SUCCESS.getResultCode() , null , ResultEnum.DEFAULT_SUCCESS.getResultMessage());
    }

    public static ResponseResult successResult(Object resultData){
        return new ResponseResult(ResultEnum.DEFAULT_SUCCESS.getResultCode() , resultData , ResultEnum.DEFAULT_SUCCESS.getResultMessage());
    }

    public static ResponseResult defaultFailResult(){
        return new ResponseResult(ResultEnum.DEFAULT_FAIL.getResultCode() , null , ResultEnum.DEFAULT_FAIL.getResultMessage());
    }

    public static ResponseResult defaultFailResult(int resultCode , Object resultData , String resultMessage){
        return new ResponseResult(resultCode , resultData , resultMessage);
    }
}
