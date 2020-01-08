package com.zhupeng.provider;

import com.zhupeng.controller.UserController;
import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.pc.user.api.PcUserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/***
 * 服务提供者，提供接口维护
 */
@RestController
public class UserProvider implements PcUserApi {

    @Value("${username}")
    String username;

    @Override
    public ResponseResult addUser(UserVo userVo) {
        userVo.setUsername("zhupneg");
        userVo.setAge(12);

        System.out.println("======================================================" + userVo.toString()  + "===" + username);
        return ResponseResult.successResult(userVo);
    }

    @Override
    public ResponseResult test() {
        UserVo userVo = new UserVo();
        userVo.setUsername("zhupneg");
        userVo.setAge(12);

        System.out.println("======================================================" + userVo.toString()   + "===" + username);
        return ResponseResult.successResult(userVo);
    }
}
