package com.zhupeng.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 */
@Component
public class GlobalSysFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean sys = exchange.getRequest().getQueryParams().containsKey("sys");
        if(sys){
            System.out.println("试一试存在");
        } else {
            System.out.println("ysy不存在");
        }
//        return chain.filter(exchange).then(
//                Mono.fromRunnable(() -> {
//                    System.out.println("成功了");
//                })
//        );
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
