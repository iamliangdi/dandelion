package org.incubator.dandelion.spring.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.lang.reflect.Method;

/**
 * 全局异步方法异常捕获
 *
 * @author liangdi
 * @since 1.0.0
 */
@Configuration
public class GlobalAsyncExceptionConfiguration implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new GlobalAsyncUncaughtExceptionHandler();
    }

}

class GlobalAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalAsyncExceptionConfiguration.class);


    @Override
    public void handleUncaughtException(@NonNull Throwable throwable, @NonNull Method method, @NonNull Object... params) {
        logger.warn("[Dandelion][Dandelion-Spring][全局异常捕获] 捕获到异步异常", throwable);
    }

}
