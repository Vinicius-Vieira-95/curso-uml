package com.curso.vnc.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogConfig {
	
	Logger log = LogManager.getLogger(LogConfig.class);
	
	@Pointcut("execution(public * com.curso.vnc.controllers..*(..)))")
	private void metodoPublicoControllers() {
	}
	
	@Before(value =  "metodoPublicoControllers()")
	public void logBeforeExecution(JoinPoint joinPoint) {
		  log.info("Entrando no método: {} com argumentos: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
	}
	
	@Around(value =  "metodoPublicoControllers()")
	public Object logAroundExecution(ProceedingJoinPoint joinPoint) throws Throwable {
	    String methodName = joinPoint.getSignature().getName();
	    log.debug(">> {}() - {}", methodName, joinPoint.getArgs());
	    Object result = joinPoint.proceed();
	    log.debug("<< {}() - {}", methodName, result);
	    return result;
	}
	
	@After(value =  "metodoPublicoControllers()")
	public void logAfterExecution(JoinPoint joinPoint) {
		  log.info("Saindo no método: {}", joinPoint.getSignature().toShortString());
	}
	
	@AfterThrowing(pointcut = "metodoPublicoControllers()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Throwable exception) {
	    String methodName = joinPoint.getSignature().getName();
	    log.error("<< {}() - {}", methodName, exception.getMessage());
	}

}
