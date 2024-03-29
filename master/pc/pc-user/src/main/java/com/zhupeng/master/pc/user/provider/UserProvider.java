package com.zhupeng.master.pc.user.provider;

import com.zhupeng.common.api.pc.user.PcUserApi;
import com.zhupeng.common.api.pc.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/***
 * 服务提供者，提供接口维护
 */
@Slf4j
@RefreshScope
@RestController
public class UserProvider implements PcUserApi {

    @Value("${username}")
    String username;

    @Override
    public ResponseResult addUser(UserVo userVo) {
        userVo.setUsername("zhupneg");
        userVo.setAge(12);

        log.info("======================================================" + userVo.toString()  + "===" + username);
        float a = 1/0;
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
