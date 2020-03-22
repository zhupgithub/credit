package com.zhupeng.common.api.pc.user;



import com.zhupeng.common.api.pc.user.factory.PcUserApiFallbackFactory;
import com.zhupeng.common.sys.constant.ServiceConstant;
import com.zhupeng.common.sys.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zhupeng.common.api.pc.user.entity.vo.UserVo;

/**
 * pc端user服务API提供接口，由pc端user服务来进行维护，其他服务通过继承该接口，提供Feign的调用
 */
@FeignClient(value = ServiceConstant.PC_USER_SERVICE , fallbackFactory = PcUserApiFallbackFactory.class )
public interface PcUserApi {

    @RequestMapping(value = "userProvider/remote/addUser" , method = RequestMethod.POST)
    ResponseResult addUser(@RequestBody UserVo userVo);

    @GetMapping("userProvider/remote/test")
    ResponseResult test();
}
