package com.zhupeng.service;

import com.zhupeng.entity.ResponseResult;
import com.zhupeng.entity.vo.UserVo;

public interface UserService {
    ResponseResult addMobileUser(UserVo userVo);
}
