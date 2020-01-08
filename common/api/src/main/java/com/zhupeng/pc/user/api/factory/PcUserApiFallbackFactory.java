package com.zhupeng.pc.user.api.factory;

import com.zhupeng.pc.user.api.PcUserApi;
import com.zhupeng.pc.user.api.fallback.PcUserApiFallback;
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
