package com.zhupeng.common.sys.hystrix;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

/**
 * hystrix使用多线程管理请求连接池，从主线程到发送基于hystrix的feign请求线程已不在同一个线程内，
 * 而RequestContextHolder是基于ThreadLocal实现的，这就使得线程之间数据断链，
 * 需要通过线程之间的数据传递使得ThreadLocal中存储的currentRequestAttributes接上。hystrix强大在于是支持此扩展操作的。
 *
 *
 * 通过HystrixConcurrencyStrategy自定义策略，解决线程间的数据传递
 */
public class RequestContextHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new RequestAttributeAwareCallable<>(callable, RequestContextHolder.getRequestAttributes());
    }

    static class RequestAttributeAwareCallable<T> implements Callable<T> {

        private final Callable<T> delegate;
        private final RequestAttributes requestAttributes;

        public RequestAttributeAwareCallable(Callable<T> callable, RequestAttributes requestAttributes) {
            this.delegate = callable;
            this.requestAttributes = requestAttributes;
        }

        @Override
        public T call() throws Exception {
            try {
                RequestContextHolder.setRequestAttributes(requestAttributes);
                return delegate.call();
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        }
    }
}

