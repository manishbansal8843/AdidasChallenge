package com.adidas.manish.cityapi.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@AfterThrowing(pointcut = "execution(* com.adidas.manish.cityapi.service.*.*(..))", throwing = "exception")
	public void logExceptionFromService(Exception exception) throws Exception {	
			log(exception);			
	}
	
	@Around("execution(* com.adidas.manish.cityapi.service.*.*(..))")
    public Object logDetails(ProceedingJoinPoint joinPoint) throws Throwable {
            log("Before executing method "+joinPoint.getSignature());
            Object ret=joinPoint.proceed();
            log("After  executing method"+joinPoint.getSignature());
            return ret;
}
	
	private void log(Exception e) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
	private void log(String m) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info(m);
	}
}
