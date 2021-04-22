package com.github.gudian1618.cgb2011dbsysv1.common.exception;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/22 10:22 下午
 */

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -5397127265770473147L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
