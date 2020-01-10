package com.zhupeng.master.pc.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zhupeng.common.api.**")//这个注解中的basePackages将会扫描这个包下所有类，并且生成对应的对象
@ComponentScan(basePackages = "com.zhupeng.**")
public class PcUserApplication {

    public static void main(String[] args) {
        log.info("pc-user业务系统启动中……");
        SpringApplication.run(PcUserApplication.class , args);
        log.info("pc-user业务系统启动完成！");
    }

}
