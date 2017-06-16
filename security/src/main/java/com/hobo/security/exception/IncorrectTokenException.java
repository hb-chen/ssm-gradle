package com.hobo.security.exception;

import org.apache.shiro.authc.AuthenticationException;

public class IncorrectTokenException extends AuthenticationException {
    private static final long serialVersionUID = -1;

    public IncorrectTokenException() {
        super();
    }

    public IncorrectTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectTokenException(String message) {
        super(message);
    }

    public IncorrectTokenException(Throwable cause) {
        super(cause);
    }

}
