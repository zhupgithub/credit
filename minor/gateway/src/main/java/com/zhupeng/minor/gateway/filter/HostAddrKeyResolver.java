package com.zhupeng.minor.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class HostAddrKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        System.out.println("令牌桶算法");
//        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        return Mono.just(exchange.getRequest().getURI().getPath());
    }

}
