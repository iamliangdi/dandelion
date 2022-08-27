package org.incubator.dandelion.spring.enums;

/**
 * 自定义HTTP状态码
 *
 * @author liangdi
 * @since 1.0.0
 */
public enum StatusCode {

    OK(200, "OK"),
    ERROR(500, "ERROR");


    private final int code;

    private final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
