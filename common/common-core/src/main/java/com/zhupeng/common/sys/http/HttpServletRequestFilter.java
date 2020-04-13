package com.zhupeng.common.sys.http;

import com.zhupeng.common.sys.chain.context.SpanIdContext;
import com.zhupeng.common.sys.constant.ServiceConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class HttpServletRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest){
            request = new MutableHttpServletRequest((HttpServletRequest)request);

//            //生成当前的spanId，并且设置到MDC和当前线程中
//            String spanId = UUID.randomUUID().toString();
//            MDC.put(ServiceConstant.REQUEST_SPANID , spanId);
//            SpanIdContext.setSpanIdOnThreadLocal(spanId);
//            ((MutableHttpServletRequest)request).addHeader(ServiceConstant.REQUEST_SPANID , spanId);
        }
        chain.doFilter(request , response);
    }

    @Override
    public void destroy() {

    }
}
