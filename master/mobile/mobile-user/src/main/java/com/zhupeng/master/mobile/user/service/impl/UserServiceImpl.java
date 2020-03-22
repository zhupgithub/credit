package com.zhupeng.master.mobile.user.service.impl;

import com.zhupeng.common.api.mobile.user.entity.vo.UserVo;
import com.zhupeng.common.api.pc.user.PcUserApi;
import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.master.mobile.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PcUserApi pcUserApi;

    @Override
    public ResponseResult addPcUser(UserVo userVo) {
        com.zhupeng.common.api.pc.user.entity.vo.UserVo userVo1 = new com.zhupeng.common.api.pc.user.entity.vo.UserVo();
        BeanUtils.copyProperties(userVo , userVo1);
        return pcUserApi.addUser(userVo1);
    }
}
