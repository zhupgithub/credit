package com.zhupeng.common.api.pc.user.factory;

import com.zhupeng.common.api.pc.user.PcUserApi;
import com.zhupeng.common.api.pc.user.fallback.PcUserApiFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PcUserApiFallbackFactory implements FallbackFactory<PcUserApi> {
    @Override
    public PcUserApi create(Throwable cause) {
        PcUserApiFallback userServiceFallback = new PcUserApiFallback();
        userServiceFallback.setCause(cause);
        return userServiceFallback;
    }
}
