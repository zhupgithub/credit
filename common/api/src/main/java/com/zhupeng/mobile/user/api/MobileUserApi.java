package com.zhupeng.mobile.user.api;


import com.zhupeng.constant.ServiceConstant;
import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.mobile.user.api.factory.MobileUserApiFallbackFactory;
import com.zhupeng.pc.user.api.factory.PcUserApiFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * mobile端user服务API提供接口，由mobile端user服务来进行维护，其他服务通过继承该接口，提供Feign的调用
 */
@FeignClient(contextId = "mobileUserService" , value = ServiceConstant.MOBILE_USER_SERVICE , fallbackFactory = PcUserApiFallbackFactory.class )
public interface MobileUserApi {

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    ResponseResult addUser(@RequestBody UserVo userVo);

    @GetMapping("test")
    ResponseResult test();
}
