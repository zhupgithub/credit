package com.zhupeng.master.pc.user.controller;


import com.zhupeng.common.api.pc.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.master.pc.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("addMobileUser")
    public ResponseResult addMobileUser(UserVo userVo) {
        userVo.setUsername("zhupneg");
        userVo.setAge(12);

        return userService.addMobileUser(userVo);
    }
}
