package com.androsor.spring.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ControllerExceptionHфndler}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 20.09.2022 21:55
 */
@Slf4j
@RestControllerAdvice(basePackages = "com/androsor/spring/http/rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
