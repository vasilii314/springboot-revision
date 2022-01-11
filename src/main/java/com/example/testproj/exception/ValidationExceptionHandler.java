package com.example.testproj.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e, WebRequest req) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", 400);
        body.put("message", "Bad request");
        return ResponseEntity.status(400).body(body);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException e, WebRequest req) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", 400);
        body.put("message", "Bad request");
        return ResponseEntity.status(400).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e, WebRequest req) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", 400);
        body.put("message", "Bad request");
        return ResponseEntity.status(400).body(body);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(RuntimeException e, WebRequest req) {
        Map<String, Object> body = new HashMap<>();;
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", 400);
        body.put("message", "Bad request");
        return ResponseEntity.status(400).body(body);
    }
}
