package com.yedam.myserver.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterLog {

	@AfterReturning(pointcut = "LogAdvice.allpointcut()", returning = "obj")
	public void printLog(JoinPoint jp, Object obj) {
		String name = jp.getSignature().getName();
		System.err.println("에프터:" + name);
		System.out.println(obj);
	}
}

