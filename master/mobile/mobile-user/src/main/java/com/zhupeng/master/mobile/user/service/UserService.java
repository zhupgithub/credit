package com.zhupeng.master.mobile.user.service;


import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.common.sys.entity.vo.UserVo;

public interface UserService {
    ResponseResult addPcUser(UserVo userVo);
}
