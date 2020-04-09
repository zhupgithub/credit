package com.zhupeng.common.sys.feign;

import com.zhupeng.common.sys.chain.context.SpanIdContext;
import com.zhupeng.common.sys.constant.ServiceConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign 支持请求拦截器，在发送请求前，可以对发送的模板进行操作，
 * 例如设置请求头等属性，自定请求拦截器需要实现 feign.RequestInterceptor 接口，
 * 该接口的方法 apply 有参数 template ，该参数类型为 RequestTemplate，我们可以根据实际情况对请求信息进行调整
 */
public class FeignRequestHeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String spanId = SpanIdContext.getSpanIdOnThreadLocal();

        requestTemplate.header(ServiceConstant.REQUEST_SPANID , spanId);

        //当前feign远程调用环境不是由http接口发起，例如test单元测试中的feign调用或者项目启动后的feign调用
        HttpServletRequest request = null;

        try {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
            request = servletRequestAttributes.getRequest();
        } catch (NullPointerException e) {

            //被调环境中不存在request对象，则不往header里添加当前请求环境的header
            return;
        }
        if (request != null) {
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    requestTemplate.header(name, values);
                }
            }
        }
    }
}
