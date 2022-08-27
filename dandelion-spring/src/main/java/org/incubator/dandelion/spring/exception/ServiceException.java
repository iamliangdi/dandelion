package org.incubator.dandelion.spring.exception;

/**
 * 业务异常
 *
 * @author liangdi
 * @since 1.0.0
 */
public class ServiceException extends RuntimeException {

    protected int code;
    protected String message;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
