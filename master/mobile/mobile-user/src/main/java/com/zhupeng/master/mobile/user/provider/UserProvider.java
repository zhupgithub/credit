package com.zhupeng.master.mobile.user.provider;

import com.zhupeng.common.api.mobile.user.MobileUserApi;
import com.zhupeng.common.api.mobile.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/***
 * 服务提供者，提供接口维护
 */
@RefreshScope
@RestController
public class UserProvider implements MobileUserApi {

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
