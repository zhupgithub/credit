package com.zhupeng.common.sys.http;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<HttpServletRequestFilter> initFilterRegistrationBean(){
        FilterRegistrationBean<HttpServletRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new HttpServletRequestFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("httpServletRequestFilter");
        registrationBean.setOrder(0);

        return registrationBean;
    }

}
