package com.xxc.demo.config;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.exception.SysException;
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

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BizException.class)
    public Response handleBizException(BizException e) {
        // 业务异常，无需记录日志
        return Response.buildFailure(e.getErrCode(), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SysException.class)
    public Response handleSysException(SysException e) {
        // 已知系统异常，打印报错信息
        log.warn("已知系统异常：{} {}", e.getErrCode(), e.getMessage());
        return Response.buildFailure(e.getErrCode(), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        // 未知系统异常，打印堆栈信息
        log.error("位置系统异常： {}", e.getMessage(), e);
        return Response.buildFailure("UNKNOWN_ERROR", e.getMessage());
    }
}
