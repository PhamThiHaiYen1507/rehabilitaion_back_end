// package com.haiyen.rehap.exception;

// import
// org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
// public class GlobalExceptionHandler {
// @ExceptionHandler(Exception.class)
// public ResponseEntity<String> handleException(Exception ex) {
// // Xử lý ngoại lệ và trả về mã lỗi và thông báo tương ứng
// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal
// Server Error");
// }

// @ExceptionHandler(NotFoundException.class)
// public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
// // Xử lý ngoại lệ NotFoundException và trả về mã lỗi và thông báo tương ứng
// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
// }

// // Thêm các phương thức handleException khác tùy theo nhu cầu xử lý ngoại lệ

// }
