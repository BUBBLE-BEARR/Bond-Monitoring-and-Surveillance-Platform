package com.project.common.hc.exception;

public class RequestBodyParseException extends BaseException {
    public RequestBodyParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestBodyParseException(String message) {
        super(message);
    }
}
