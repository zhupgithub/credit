package com.zhupeng.master.mobile.user.service.impl;

import com.zhupeng.common.api.pc.user.PcUserApi;
import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.common.sys.entity.vo.UserVo;
import com.zhupeng.master.mobile.user.service.UserService;
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
