package com.zhupeng.common.sys.chain.context;

import com.zhupeng.common.sys.constant.ServiceConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SpanIdContext {
    private static final ThreadLocal<String> SPANIDTHREADLOCAL = new ThreadLocal<>();

    /**
     * 获取当前线程中的traceId的值
     * @return
     */
    public static String getSpanIdOnThreadLocal(){
        return SPANIDTHREADLOCAL.get();
    }

    /**
     * 设置当前线程中的traceId的值
     */
    public static void setSpanIdOnThreadLocal(String traceId){
        SPANIDTHREADLOCAL.set(traceId);
    }

    /**
     * 移除当前线程中的traceId的值
     */
    public static void remove(){
        SPANIDTHREADLOCAL.remove();
    }

    public static String getSpanIdOnHttpRequestHeader(){
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String traceId = httpServletRequest.getHeader(ServiceConstant.REQUEST_SPANID);

        if(StringUtils.isBlank(traceId)){
            traceId = "";
        }
        return traceId;
    }
}
