package com.haiyen.rehap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionResult.class)
    public ResponseEntity<ExceptionJSONInfo> handleExceptionNew(ExceptionResult ex) {
        ExceptionJSONInfo errorResponse;
        if (ex.statusCode == HttpStatus.BAD_REQUEST) {
            if (ex.getMessage().length() == 0) {
                errorResponse = new ExceptionJSONInfo(HttpStatus.BAD_REQUEST.value(), "Error message");
            } else {
                errorResponse = new ExceptionJSONInfo(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
            }

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } else

        {
            errorResponse = new ExceptionJSONInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "INTERNAL_SERVER_ERROR");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
