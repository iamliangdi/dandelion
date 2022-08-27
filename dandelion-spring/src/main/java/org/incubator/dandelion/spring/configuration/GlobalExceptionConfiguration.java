package org.incubator.dandelion.spring.configuration;

import org.incubator.dandelion.spring.exception.ServiceException;
import org.incubator.dandelion.spring.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获
 *
 * @author liangdi
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionConfiguration {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionConfiguration.class);

    @ExceptionHandler
    public <T> Response<T> serviceExceptionHandler(ServiceException exception, HttpServletRequest request) {
        return Response.fail(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler
    public <T> Response<T> exceptionHandler(Exception exception, HttpServletRequest request) {
        if (exception.getCause() != null) {
            logger.warn("[Dandelion][Dandelion-Spring][全局异常捕获] 捕获到异常", exception);
        }
        return Response.fail("服务器发生异常，请稍后再试");
    }

}
