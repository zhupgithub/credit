package com.zhupeng.mobile.user.api.fallback;


import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.mobile.user.api.MobileUserApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 公用的降级方法和降级工厂 ， 当没有特殊要求时，可以使用这里的公用降级方法和降级工厂；
 * 当存在特使要求时，可以自己在自己服务内实现自己的降级方法和降级工厂
 */
@Slf4j
@Component
public class MobileUserApiFallback implements MobileUserApi {

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
