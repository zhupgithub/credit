package com.zhupeng.pc.user.api.fallback;


import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.pc.user.api.PcUserApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PcUserApiFallback implements PcUserApi {

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
