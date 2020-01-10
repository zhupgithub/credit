package com.zhupeng.master.pc.user.service;


import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.common.sys.entity.vo.UserVo;

public interface UserService {
    ResponseResult addMobileUser(UserVo userVo);
}
