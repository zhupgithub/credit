package com.zhupeng.common.sys.chain.context;

import com.zhupeng.common.sys.constant.ServiceConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ParentIdContext {

    private static final ThreadLocal<String> PARENTIDTHREADLOCAL = new ThreadLocal<>();

    /**
     * 获取当前线程中的traceId的值
     * @return
     */
    public static String getParentIdOnThreadLocal(){
        return PARENTIDTHREADLOCAL.get();
    }

    /**
     * 设置当前线程中的traceId的值
     */
    public static void setParentIdOnThreadLocal(String traceId){
        PARENTIDTHREADLOCAL.set(traceId);
    }

    /**
     * 移除当前线程中的traceId的值
     */
    public static void remove(){
        PARENTIDTHREADLOCAL.remove();
    }

    public static String getParentIdOnHttpRequestHeader(){
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String traceId = httpServletRequest.getHeader(ServiceConstant.REQUEST_PARENTSPANID);

        if(StringUtils.isBlank(traceId)){
            traceId = "";
        }
        return traceId;
    }
}
