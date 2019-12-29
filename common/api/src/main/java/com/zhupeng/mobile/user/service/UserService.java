package com.zhupeng.mobile.user.service;


import com.zhupeng.constant.ServiceConstant;
import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.mobile.user.service.factory.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(contextId = "userServiceInterface" , value = ServiceConstant.PC_USER_SERVICE , fallbackFactory = UserServiceFallbackFactory.class )
public interface UserService {

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    ResponseResult addUser(@RequestBody UserVo userVo);

    @GetMapping("test")
    ResponseResult test();
}
