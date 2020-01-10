package com.zhupeng.minor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminApplication {

    public static void main(String[] args) {
        log.info("admin监控启动中……");
        SpringApplication.run(AdminApplication.class , args);
        log.info("admin监控启动完成！");
    }
//    @Configuration
//    public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().anyRequest().permitAll()
//                    .and().csrf().disable();
//        }
//    }
}
