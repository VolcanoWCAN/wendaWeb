package com.nowcoder.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.nowcoder.controller.IndexController.*(..))")
    public void beforeMethod(){
         logger.info("before method" + new Date());
    }

    @After("execution(* com.nowcoder.controller.IndexController.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder();
        for(Object arg : joinPoint.getArgs()){
            sb.append("arg:" + arg.toString() + "|");
        }
        logger.info("after method" + new Date() + sb.toString());
    }
}
