package com.zhupeng.master.pc.user.service.impl;

import com.zhupeng.common.api.mobile.user.MobileUserApi;
import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.common.sys.entity.vo.UserVo;
import com.zhupeng.master.pc.user.service.UserService;
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
