package com.zhupeng.minor.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.zhupeng.**")
public class GatewayApplication {

    public static void main(String[] args) {
        log.info("网关服务启动中……");
        SpringApplication.run(GatewayApplication.class , args);
        log.info("网关服务启动完成！");
    }
}
