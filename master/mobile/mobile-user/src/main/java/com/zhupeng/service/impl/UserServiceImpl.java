package com.zhupeng.service.impl;

import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;
import com.zhupeng.pc.user.api.PcUserApi;
import com.zhupeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PcUserApi pcUserApi;

    @Override
    public ResponseResult addPcUser(UserVo userVo) {
        return pcUserApi.addUser(userVo);
    }
}
