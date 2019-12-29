package com.zhupeng.mobile.user.service.fallback;


import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.mobile.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceFallback implements UserService {

    private Throwable cause;

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ResponseResult addUser(UserVo userVo) {
        log.error("添加失败" + cause.toString());
        return null;
    }

    @Override
    public ResponseResult test() {
        log.error("测试失败" + cause.toString());
        return null;
    }
}
