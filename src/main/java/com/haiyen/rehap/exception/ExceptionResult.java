package com.haiyen.rehap.exception;

public class ExceptionResult extends Exception {
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
