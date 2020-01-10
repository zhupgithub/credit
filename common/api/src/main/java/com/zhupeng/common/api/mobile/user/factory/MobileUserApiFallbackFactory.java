package com.zhupeng.common.api.mobile.user.factory;

import com.zhupeng.common.api.mobile.user.MobileUserApi;
import com.zhupeng.common.api.mobile.user.fallback.MobileUserApiFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MobileUserApiFallbackFactory implements FallbackFactory<MobileUserApi> {
    @Override
    public MobileUserApi create(Throwable cause) {
        MobileUserApiFallback userServiceFallback = new MobileUserApiFallback();
        userServiceFallback.setCause(cause);
        return userServiceFallback;
    }
}
