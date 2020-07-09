package com.example.helloworld.exception;

import com.example.helloworld.controller.ExceptionController1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(assignableTypes = {ExceptionController1.class})
@ResponseBody
public class GlobalExceptionHandler1 {
    ErrorResponse1 illegalArgumentResponse = new ErrorResponse1(new IllegalArgumentException("参数错误！"));
    ErrorResponse1 resourseNotFoundResponse = new ErrorResponse1(new ResourceNotFoundException1("资源不存在！"));

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse1> exceptionHandler(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException1) {
            return ResponseEntity.status(404).body(resourseNotFoundResponse);
        }
        return null;
    }
}
