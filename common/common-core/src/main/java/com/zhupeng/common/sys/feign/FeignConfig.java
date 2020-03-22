package com.zhupeng.common.sys.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    /**
     * feign请求加上当前请求接口的headers
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestHeaderInterceptor();
    }

}
