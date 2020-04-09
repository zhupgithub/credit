package com.zhupeng.common.sys.feign;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhupeng.common.sys.constant.ResultEnum;
import com.zhupeng.common.sys.exception.BusinessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;

/**
 * Feign自定义的错误解码器
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        log.info("Feign自定义的错误解码器");
        String resposeBody;
        try {
            if (response == null || response.body() == null) {
                if (response != null && response.status() == 404) {
                    return new BusinessException(ResultEnum.REMOTE_SERVICE_NULL);
                } else {
                    return new BusinessException(ResultEnum.SERVICE_ERROR);
                }
            }
            resposeBody = IoUtil.read(response.body().asInputStream(), "UTF-8");
        } catch (IOException e) {
            return new BusinessException(ResultEnum.IO_ERROR);
        }
        JSONObject parse = JSON.parseObject(resposeBody);
        Integer code = parse.getInteger("code");
        String message = parse.getString("message");
        if (message == null) {
            message = ResultEnum.DEFAULT_FAIL.SERVICE_ERROR.getResultMessage();
        }
        if (code == null) {

            //status为spring默认返回的数据
            Integer status = parse.getInteger("status");

            if (status == null) {
                return new BusinessException(ResultEnum.SERVICE_ERROR.getResultCode(), message);
            } else {
                return new BusinessException(status, message);
            }
        } else {
            return new BusinessException(code, message);
        }
    }
}
