package com.zhupeng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class PcUserApplication {

    public static void main(String[] args) {
        log.info("pc-user业务系统启动中……");
        SpringApplication.run(PcUserApplication.class , args);
        log.info("pc-user业务系统启动完成！");
    }

}
