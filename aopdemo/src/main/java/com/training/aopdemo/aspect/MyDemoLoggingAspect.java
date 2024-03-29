package com.training.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add call of our related advices for logging
	
	// let's start with an @Before advice
	
	
	//@Before("execution(public void com.training.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(* void com.training.aopdemo.dao.*.*(..)")
	//@Before("execution(* com.training..add*(..))")
	@Before("execution(* com.training.aopdemo.dao.*.*(..))")
	//@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>>> Executing @Before advice on addAccount()");
	}
}
