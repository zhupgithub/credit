package com.zhupeng.master.pc.user.controller;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.zhupeng.common.sys.entity.ResponseResult;
import com.zhupeng.master.pc.user.entity.PcUser;
import com.zhupeng.master.pc.user.service.PcUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 后台管理用户表 前端控制器
 * </p>
 *
 * @author zhupeng
 * @since 2020-04-14
 */
@Slf4j
@RestController
@RequestMapping("/pcUserController")
public class PcUserController {

    @Autowired
    PcUserService pcUserService;


    @RequestMapping("addPcUser")
    public ResponseResult addPcUser() {
        PcUser pcUser = new PcUser();
        pcUser.setId(IdWorker.getId());
        pcUser.setBackUserNo(IdWorker.getIdStr());
        pcUser.setRealName("realName");
        pcUser.setPassword("password");
        pcUser.setLoginAccount("realName");
        pcUser.setCreateTime(new Date());

        pcUserService.save(pcUser);

        return ResponseResult.successResult(pcUser);
    }
}
