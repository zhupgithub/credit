package com.zhupeng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;


@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class RegisterApplication {

    public static void main(String[] args) {
        log.info("注册中心启动中……");
        SpringApplication.run(RegisterApplication.class , args);
        log.info("注册中心启动完成！");
    }

    @Bean
    public HttpFirewall allowUrlEncodeedSlashHttpFirewall(){
        return new DefaultHttpFirewall();
    }
}
