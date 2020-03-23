package com.zhupeng.master.mobile.user.service;


import com.zhupeng.common.api.mobile.user.entity.vo.UserVo;
import com.zhupeng.common.sys.entity.ResponseResult;

public interface UserService {
    ResponseResult addPcUser(UserVo userVo);
}
