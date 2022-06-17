package com.yedam.myserver.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.yedam..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void PrintLog(JoinPoint jp) {
		String name = jp.getSignature().getName();
		String arg = jp.getArgs() != null && jp.getArgs().length>0 ? jp.getArgs()[0].toString() : ""; 
		System.out.println("비포 :" + name +":"+ arg);
	
	}
}
