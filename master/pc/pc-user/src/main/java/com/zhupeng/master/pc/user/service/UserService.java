package com.zhupeng.master.pc.user.service;


import com.zhupeng.common.api.pc.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;

public interface UserService {
    ResponseResult addMobileUser(UserVo userVo);
}
