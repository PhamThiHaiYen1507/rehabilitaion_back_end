package com.haiyen.rehap.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResult extends Exception {
    HttpStatus statusCode;

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ExceptionResult(String message, HttpStatus statusCode) {
        super(message);

        this.statusCode = statusCode;
    }

    public ExceptionResult(HttpStatus statusCode) {

        this.statusCode = statusCode;
    }

    public ExceptionResult() {
        super();
    }

    public ExceptionResult(String message) {
        super(message);
    }

    public ExceptionResult(String message, Throwable cause) {
        super(message, cause);
    }

    // Các phương thức khác nếu cần thiết
}
