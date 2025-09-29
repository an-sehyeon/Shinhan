package com.shinhan.sbroject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

//Advice : 
@Slf4j
@Component
@Aspect   
public class StopWatchAdvice  {

	//@Pointcut("execution(* selectAll(..))")
	//public void targetMethod1() {}
	
	@Pointcut("within(com.shinhan.sbroject.controllerfinal.WebBoardController)")
	public void targetMethod2() {}
	
	@Around("targetMethod2()") 
	public Object fffff(ProceedingJoinPoint jp) throws Throwable {


		log.info("[StopWatchAdvice]" + jp.getSignature().getName());
		StopWatch watch = new StopWatch("");
		watch.start();

		Object obj = jp.proceed();
		watch.stop();
		log.info("[StopWatchAdvice]" +  jp.getSignature().getName() + "######");
		log.info("time:" +watch.getTotalTimeMillis() );
		return obj;
	}

}
