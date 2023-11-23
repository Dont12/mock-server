package com.example.mockserver.response;

import ch.qos.logback.core.status.Status;

public class ResponseBody<T> {

    private final String status;
    private final T data;

    public ResponseBody(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public static ResponseBody<Void> ok() {
        return new ResponseBody<>("SUCCESS", null);
    }

    public static <T> ResponseBody<T> ok(T data) {
        return new ResponseBody<>("SUCCESS", data);
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
