package com.yihuan.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.yihuan.util.Util;

@Component
@Aspect
public class ExceptionAspect {

	@AfterThrowing(pointcut="within(com.yihuan.service..*)",throwing="excep")
	public void execute(Exception excep){
		Util.log2Error("Service∑¢…˙“Ï≥££∫", excep);
	}
}
