package com.zhupeng.common.sys.feign;

import cn.hutool.core.bean.BeanUtil;
import com.zhupeng.common.sys.constant.ResultEnum;
import com.zhupeng.common.sys.entity.ResponseResult;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class SelfErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        return BeanUtil.beanToMap(ResponseResult.defaultFailResult(ResultEnum.SERVICE_ERROR));
    }
}
