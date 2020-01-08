package com.zhupeng.service.impl;

import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.mobile.user.api.MobileUserApi;
import com.zhupeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MobileUserApi mobileUserApi;

    @Override
    public ResponseResult addMobileUser(UserVo userVo) {
        return mobileUserApi.addUser(userVo);
    }
}
