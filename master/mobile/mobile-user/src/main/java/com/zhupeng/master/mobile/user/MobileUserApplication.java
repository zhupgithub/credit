package com.zhupeng.master.mobile.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zhupeng.common.api.**")//这个注解中的basePackages将会使feign扫描这个包下所有类，将这个包下的类向feign注册
//@ComponentScan(basePackages = "com.zhupeng.**")
public class MobileUserApplication {

    public static void main(String[] args) {
        log.info("mobile-user业务系统启动中……");
        SpringApplication.run(MobileUserApplication.class , args);
        log.info("mobile-user业务系统启动完成！");
    }

}
