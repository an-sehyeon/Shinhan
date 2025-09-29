package com.shinhan.sbroject.aop;
 
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect  
public class LoggingAdvice  {

	@Pointcut("execution(* 	public(..))")
//	@Pointcut("within(com.shinhan.sbroject.controllerfinal.WebBoardController)")
	public void targetMethod() { }  
 
	@Before("targetMethod()")
	public void before2(JoinPoint jp) {
		String fname = jp.getSignature().getName();
		log.info("=============@Before==========" + fname);
	}
	
	@AfterReturning("targetMethod()")
	public void after2(JoinPoint jp) {
		String fname = jp.getSignature().getName();
		log.info("=============@AfterReturning==========" + fname);
	}
	
	@Around("targetMethod()")
	public Object around2(ProceedingJoinPoint jp) throws Throwable {
		log.info("[ LoggingAdvice]" + jp.getSignature().getName());
		Object obj = jp.proceed();
		log.info("[LoggingAdvice] :" +obj );
		log.info("[LoggingAdvice]" + jp.getSignature().getName() + "*******");
		return obj;
	}

}
