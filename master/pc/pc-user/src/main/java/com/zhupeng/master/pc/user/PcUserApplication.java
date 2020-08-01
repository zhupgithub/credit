package com.zhupeng.master.pc.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zhupeng.master.pc.user.mapper")
@EnableFeignClients(basePackages = "com.zhupeng.common.api.**")//这个注解中的basePackages将会使feign扫描这个包下所有类，将这个包下的类向feign注册
public class PcUserApplication {

    public static void main(String[] args) {
        log.info("pc-user业务系统启动中……");
        SpringApplication.run(PcUserApplication.class , args);
        log.info("pc-user业务系统启动完成！");
    }

}
