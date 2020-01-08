package com.zhupeng.mobile.user.api.factory;

import com.zhupeng.mobile.user.api.MobileUserApi;
import com.zhupeng.mobile.user.api.fallback.MobileUserApiFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 公用的降级方法和降级工厂 ， 当没有特殊要求时，可以使用这里的公用降级方法和降级工厂；
 * 当存在特使要求时，可以自己在自己服务内实现自己的降级方法和降级工厂
 */
@Component
public class MobileUserApiFallbackFactory implements FallbackFactory<MobileUserApi> {
    @Override
    public MobileUserApi create(Throwable cause) {
        MobileUserApiFallback userServiceFallback = new MobileUserApiFallback();
        userServiceFallback.setCause(cause);
        return userServiceFallback;
    }
}
