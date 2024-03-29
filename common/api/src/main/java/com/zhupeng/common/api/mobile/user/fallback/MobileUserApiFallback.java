package com.zhupeng.common.api.mobile.user.fallback;


import com.zhupeng.common.api.mobile.user.MobileUserApi;
import com.zhupeng.common.api.mobile.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MobileUserApiFallback implements MobileUserApi {

    private Throwable cause;

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ResponseResult addUser(UserVo userVo) {
        log.error("添加失败 , 失败详细信息：{}" ,  cause.toString());
        return null;
    }

    @Override
    public ResponseResult test() {
        log.error("测试失败 , 失败详细信息：{}" ,  cause.toString());
        return null;
    }
}
