package com.zhupeng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MobileUserApplication {

    public static void main(String[] args) {
        log.info("手机端---用户模块启动中……");
        SpringApplication.run(MobileUserApplication.class , args);
        log.info("手机端---用户模块启动完成！");
    }

}
