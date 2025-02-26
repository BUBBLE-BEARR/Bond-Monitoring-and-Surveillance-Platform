package com.project.common.hc.exception;

public class ObjectParseException extends BaseException {
    public ObjectParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectParseException(String message) {
        super(message);
    }
}