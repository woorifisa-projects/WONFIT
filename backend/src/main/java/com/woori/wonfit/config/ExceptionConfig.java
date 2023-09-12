package com.woori.wonfit.config;

public class ExceptionConfig extends Exception {

    public ExceptionConfig() {
        super();
    }

    public ExceptionConfig(String message) {
        super(message);
    }

    public ExceptionConfig(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionConfig(Throwable cause) {
        super(cause);
    }
}
