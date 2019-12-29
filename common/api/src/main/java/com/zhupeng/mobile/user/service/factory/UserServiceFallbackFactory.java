package com.zhupeng.mobile.user.service.factory;

import com.zhupeng.mobile.user.service.UserService;
import com.zhupeng.mobile.user.service.fallback.UserServiceFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable cause) {
        UserServiceFallback userServiceFallback = new UserServiceFallback();
        userServiceFallback.setCause(cause);
        return userServiceFallback;
    }
}
