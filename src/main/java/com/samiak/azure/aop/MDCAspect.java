package com.samiak.azure.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class MDCAspect {
    private static final Logger logger = LoggerFactory.getLogger(MDCAspect.class);


    @Before(value = "execution(* com.samiak.azure.*.*.*(..))")
    public void setMDCValues(JoinPoint joinPoint) {
        logger.info("AOP Before");
        String userId = "UserId";
        MDC.put("userId", userId);
    }

    @After(value = "execution(* com.samiak.azure.*.*.*(..))")
    public void clearMDCValues() {
        logger.info("AOP after");
        MDC.clear();
    }

}
