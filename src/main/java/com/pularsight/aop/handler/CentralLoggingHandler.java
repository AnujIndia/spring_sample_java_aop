package com.pularsight.aop.handler;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CentralLoggingHandler {
	

	@Around("execution(* com.pularsight.repository.*.*(..))")
	private Object anyOldTransfer(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("---Anuj Logs Here");
		String packageName = pjp.getSignature().getDeclaringTypeName();
	    String methodName = pjp.getSignature().getName();
	    System.out.println("hijacked arguments : " + Arrays.toString(pjp.getArgs()));
	    long start = System.currentTimeMillis();
	    if(!pjp.getSignature().getName().equals("initBinder")) {
	      System.out.println("Entering method [" + packageName + "." + methodName +  "]");
	    }
	    Object output = pjp.proceed();
	    long elapsedTime = System.currentTimeMillis() - start;
	    if(!methodName.equals("initBinder")) {
	    	System.out.println("Exiting method [" + packageName + "." + methodName + "]; exec time (ms): " + elapsedTime);
	    }
	    return output;
	
	

	}
}
