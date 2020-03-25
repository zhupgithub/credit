package com.zhupeng.common.sys.feign;

import feign.Feign;
import feign.RequestInterceptor;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfig {

    /**
     * feign请求加上当前请求接口的headers
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestHeaderInterceptor();
    }

    /**
     * Feign自定义的错误解码器
     * @return
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignErrorDecoder(){
        return HystrixFeign.builder().errorDecoder(new FeignErrorDecoder());
    }


    /**
     * 覆盖spring默认的响应消息格式
     */
    @Bean
    public SelfErrorAttributes defaultRosesErrorAttributes() {
        return new SelfErrorAttributes();
    }

}
