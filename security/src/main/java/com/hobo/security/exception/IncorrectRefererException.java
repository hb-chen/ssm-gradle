package com.hobo.security.exception;

import org.apache.shiro.authc.AuthenticationException;

public class IncorrectRefererException extends AuthenticationException {
    private static final long serialVersionUID = -1;

    public IncorrectRefererException() {
        super();
    }

    public IncorrectRefererException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRefererException(String message) {
        super(message);
    }

    public IncorrectRefererException(Throwable cause) {
        super(cause);
    }

}
