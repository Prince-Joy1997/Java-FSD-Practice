package com.topjobs.topjob_authentication.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.topjobs.topjob_authentication.model.User;


@Aspect
@Component
public class UserAopLog {

	Logger mylog=LoggerFactory.getLogger(UserAopLog.class);
	
	@Before("execution (* com.topjobs.topjob_authentication.controller.UserController.RegisterUser(..))")
	public void beforeRegisterUser(JoinPoint jp)
	{
		mylog.info("RegisterUser was called");
	}

	@After("execution (* com.topjobs.topjob_authentication.controller.UserController.RegisterUser(..))")
	public void afterRegisterUser(JoinPoint jp)
	{
		mylog.info("RegisterUser has executed");
	}
	@AfterReturning("execution (* com.topjobs.topjob_authentication.controller.UserController.RegisterUser(..))")
	public void afterReturningRegisterUser(JoinPoint jp) 
	{
		mylog.info("RegisterUser has executed with a return value");
	}

	@AfterThrowing(pointcut="execution (* com.topjobs.topjob_authentication.controller.UserController.RegisterUser(..))",throwing="excepobj")
	public void afterThrowingRegisterUser( Exception excepobj)
	{
		mylog.warn("exception is raised while regestering user " + excepobj.getMessage());
	}
	


	@Before("execution (* com.topjobs.topjob_authentication.controller.UserController.LoginUser(..))")
	public void beforeLoginUser(JoinPoint jp)
	{
		mylog.info("LoginUser was called");
	}

	@After("execution (* com.topjobs.topjob_authentication.controller.UserController.LoginUser(..))")
	public void afterLoginUser(JoinPoint jp)
	{
		mylog.info("LoginUser has executed");
	}
	@AfterReturning("execution (* com.topjobs.topjob_authentication.controller.UserController.LoginUser(..))")
	public void afterReturningLoginUser(JoinPoint jp) 
	{
		mylog.info("LoginUser has executed with a return value");
	}

	@AfterThrowing(pointcut="execution (* com.topjobs.topjob_authentication.controller.UserController.LoginUser(..))",throwing="excepobj")
	public void afterThrowingLoginUser( Exception excepobj)
	{
		mylog.warn("exception is raised while LoginUser user " + excepobj.getMessage());
	}


//	@Pointcut("execution (* com.topjobs.topjob_authentication.controller.UserController.RegisterUser(..))")
//	public void registeruserpoint()
//	{
//		
//	}



}
