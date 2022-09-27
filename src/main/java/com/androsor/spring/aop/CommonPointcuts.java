package com.androsor.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * The {@code CommonPointcuts}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 27.09.2022 22:25
 */
@Aspect
@Component
public class CommonPointcuts {

    /*
        @within - check annotation on the class level
     */
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }

    /*
        within - check class type name
    */
    @Pointcut("within(com.androsor.spring.service..*Service)")
    public void isServiceLayer() {
    }
}
