package com.xxc.demo.config;

import com.alibaba.cola.dto.Response;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.warn("未知异常", e);
        return Response.buildFailure("未知异常", e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageConversionException.class)
    public Response handleHttpMessageConversionException(HttpMessageConversionException e) {
        log.info("参数转换失败：{}", e.getMessage());
        return Response.buildFailure("参数转换失败", e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Response handleValidationException(ValidationException e) {
        log.info("参数验证失败: {}", e.getMessage());
        return Response.buildFailure("参数验证失败", e.getMessage());
    }
}
