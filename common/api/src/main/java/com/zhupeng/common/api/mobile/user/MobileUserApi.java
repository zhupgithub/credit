package com.zhupeng.common.api.mobile.user;


import com.zhupeng.common.api.mobile.user.factory.MobileUserApiFallbackFactory;
import com.zhupeng.common.sys.constant.ServiceConstant;
import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.common.sys.entity.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * pc端user服务API提供接口，由pc端user服务来进行维护，其他服务通过继承该接口，提供Feign的调用
 */
@FeignClient(value = ServiceConstant.MOBILE_USER_SERVICE , fallbackFactory = MobileUserApiFallbackFactory.class )
public interface MobileUserApi {

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    ResponseResult addUser(@RequestBody UserVo userVo);

    @GetMapping("test")
    ResponseResult test();
}
