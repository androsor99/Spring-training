package com.androsor.spring.aop;

import com.androsor.spring.validation.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * The {@code FirstAspect}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 27.09.2022 11:41
 */
@Slf4j
@Aspect
@Component
public class FirstAspect {

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

    /*
        this - check AOP proxy class type
        target - check target object class type
     */
    @Pointcut("this(org.springframework.data.repository.Repository)")
    //    @Pointcut("target(org.springframework.data.repository.Repository)")
    public void isRepositoryLayer() {

    }

    /*
       @annotation - check annotation on method level
    */
    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {
    }

    /*
        args - check method param type
        * - any param type
        .. - 0+ any params type
     */
    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model,..)")
    public void hasModelParam() {
    }

    /*
       @args - check annotation on the param type
       * - any param type
       .. - 0+ any params type
    */
    @Pointcut("isControllerLayer() && @args(com.androsor.spring.validation.UserInfo,..)")
    public void hasUserInfoParamAnnotation() {
    }

    /*
      bean - check bean name
   */
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {
    }

    /*
        execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     */
    @Pointcut("execution(public * com.androsor.spring.service.*Service.findById(*))")
    public void anyFindByIdServiceMethod() {
    }

    @Before(value = "anyFindByIdServiceMethod() " +
            "&& args(id) " +
            "&& target(service) " +
            "&& this(serviceProxy)" +
            "&& @within(transactional)",
            argNames = "joinPoint,id,service,serviceProxy,transactional")
    public void addLogging(JoinPoint joinPoint,
                           Object id,
                           Object service,
                           Object serviceProxy,
                           Transactional transactional) {
        log.info("invoke findById method in class {}, with id {}", service, id);
    }
}
