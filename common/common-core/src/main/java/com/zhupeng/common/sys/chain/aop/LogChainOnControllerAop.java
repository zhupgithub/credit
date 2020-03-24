package com.zhupeng.common.sys.chain.aop;

import com.zhupeng.common.sys.chain.context.ParentIdContext;
import com.zhupeng.common.sys.chain.context.SpanIdContext;
import com.zhupeng.common.sys.chain.context.TraceIdContext;
import com.zhupeng.common.sys.constant.ServiceConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import java.util.UUID;

@Slf4j
@Aspect
@Order(200)
public class LogChainOnControllerAop {

    @Pointcut("execution(* com.zhupeng..controller.*.*(..))")
    public void LogChainOnControllerAopCut(){}

    @Around("LogChainOnControllerAopCut()")
    public Object logChainOnControllerAop(ProceedingJoinPoint point) throws Throwable{
        //获取traceId,并且设置到MDC和当前线程中
        String traceId = TraceIdContext.getTraceIdOnHttpRequestHeader();
        MDC.put(ServiceConstant.REQUEST_TRACEID , traceId);
        TraceIdContext.setTraceIdOnThreadLocal(traceId);

        //生成当前的parentId，并且设置到MDC和当前线程中
        String parentId = UUID.randomUUID().toString();
        MDC.put(ServiceConstant.REQUEST_PARENTSPANID , parentId);
        ParentIdContext.setParentIdOnThreadLocal(parentId);

        //生成当前的spanId，并且设置到MDC和当前线程中
        String spanId = UUID.randomUUID().toString();
        MDC.put(ServiceConstant.REQUEST_SPANID , spanId);
        SpanIdContext.setSpanIdOnThreadLocal(spanId);

        return point.proceed();
    }

}
