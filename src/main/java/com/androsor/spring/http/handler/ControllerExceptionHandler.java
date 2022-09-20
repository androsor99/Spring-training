package com.androsor.spring.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ControllerExceptionHendler}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 20.09.2022 21:55
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, HttpServletRequest httpServletRequest) {
        log.error("Failed to return response", exception);
        return "error/error500";
    }
}
