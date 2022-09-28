package com.androsor.logging.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * The {@code SecondAspect}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 27.09.2022 22:34
 */

@Slf4j
@Aspect
public class SecondAspect {

    @Around(value = "com.androsor.logging.aop.FirstAspect.anyFindByIdServiceMethod() " +
            "&& target(service) " +
            "&& args(id)",
            argNames = "pjp,service,id")
    public Object addLoggingAround(ProceedingJoinPoint pjp, Object service, Object id) throws Throwable {
        log.info("AROUND before - invoke findById method in class {}, with id {}", service, id);
        try {
            var result = pjp.proceed();
            log.info("AROUND after returning - invoked findById method in class {}, result {}", service, result);
            return result;
        } catch (Throwable ex) {
            log.info("AROUND after throwing - invoked findById method in class {}, exception {}: {}", service, ex.getClass(), ex.getMessage());
            throw ex;
        } finally {
            log.info("AROUND after (finally) - invoked findById method in class {}", service);
        }
    }
}
