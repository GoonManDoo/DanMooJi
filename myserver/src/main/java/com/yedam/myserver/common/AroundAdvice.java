package com.yedam.myserver.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp ) 
			  throws Throwable {
		//비지니스수행전 처리내용
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();		
		//비지니스 메서드 호출
		Object obj = pjp.proceed();		
		//비지니스수행후 처리내용
		stopwatch.stop();
		System.out.println("실행시간:"+stopwatch.getTotalTimeMillis());
		return obj;
	}
}
