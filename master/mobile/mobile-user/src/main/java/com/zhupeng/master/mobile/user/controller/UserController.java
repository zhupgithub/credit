package com.zhupeng.master.mobile.user.controller;


import com.zhupeng.common.api.mobile.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;

import com.zhupeng.common.utils.redis.RedisUtil;
import com.zhupeng.master.mobile.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * feign 使用：
     * 1、请求路径：在类上也有路径
     * 2、fallbackFactory也需要加入到spring管理
     * 3、在配置文件中开启hystrix
     */
    @Autowired
    UserService userService;

    @Value("${username}")
    String username;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("test")
    public String test(){
        UserVo userVo = new UserVo();
        userVo.setUsername("zhuhhh");
        userVo.setAge(100);

        ResponseResult responseResult = userService.addPcUser(userVo);

        redisUtil.hset("com.zhupeng", "test" , "zhp");

        return responseResult + username;
    }
}
