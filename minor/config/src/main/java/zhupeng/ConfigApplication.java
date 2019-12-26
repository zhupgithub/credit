package zhupeng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args) {
        log.info("配置中心启动中……");
        SpringApplication.run(ConfigApplication.class , args);
        log.info("配置中心启动完成！");
    }
}
