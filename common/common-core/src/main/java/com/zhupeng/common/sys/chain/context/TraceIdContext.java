package com.zhupeng.common.sys.chain.context;


import com.zhupeng.common.sys.constant.ServiceConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class TraceIdContext {

    private static final ThreadLocal<String> TRACEIDTHREADLOCAL = new ThreadLocal<>();

    /**
     * 获取当前线程中的traceId的值
     * @return
     */
    public static String getTraceIdOnThreadLocal(){
        return TRACEIDTHREADLOCAL.get();
    }

    /**
     * 设置当前线程中的traceId的值
     */
    public static void setTraceIdOnThreadLocal(String traceId){
        TRACEIDTHREADLOCAL.set(traceId);
    }

    /**
     * 移除当前线程中的traceId的值
     */
    public static void remove(){
        TRACEIDTHREADLOCAL.remove();
    }

    public static String getTraceIdOnHttpRequestHeader(){
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String traceId = httpServletRequest.getHeader(ServiceConstant.REQUEST_TRACEID);

        if(StringUtils.isBlank(traceId)){
            traceId = "";
        }
        return traceId;
    }
}
