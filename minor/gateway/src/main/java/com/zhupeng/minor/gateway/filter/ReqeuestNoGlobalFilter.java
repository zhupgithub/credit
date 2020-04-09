package com.zhupeng.minor.gateway.filter;

import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class ReqeuestNoGlobalFilter implements GlobalFilter , Ordered {
    public static final String REQUEST_TRACEID = "X-TRACEID";
    public static final String REQUEST_PARENTSPANID = "X-PARENTID";
    public static final String REQUEST_SPANID = "X-SPANID";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String tranceId = UUID.randomUUID().toString();// FIXME: 2020/3/22 需要修改成使用UUID的工具类，但是现在存在一个redistemplate重写异常
        exchange.getRequest().mutate().header(REQUEST_TRACEID , tranceId);
        MDC.put(REQUEST_TRACEID , tranceId);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE + 100;
    }
}
