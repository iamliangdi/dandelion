package org.incubator.dandelion.spring.vo;

import org.incubator.dandelion.spring.enums.StatusCode;

import java.io.Serializable;

/**
 * 统一响应实体
 *
 * @author liangdi
 * @since 1.0.0
 */
public class Response<T> implements Serializable {

    public int code;

    public String message;

    public T data;

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Response<T> success() {
        return new Response<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage());
    }


    public static <T> Response<T> success(T data) {
        return new Response<>(StatusCode.OK.getCode(), StatusCode.OK.getMessage(), data);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<>(StatusCode.ERROR.getCode(), message);
    }

    public static <T> Response<T> fail(int code, String message) {
        return new Response<>(code, message);
    }

}
