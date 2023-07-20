package com.topjobs.Employer.aspect;

import java.util.List;

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

import com.topjobs.Employer.model.Employer;

@Aspect
@Component
public class LoggerAspect {
	    
	Logger mylog=LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut("execution (* com.topjobs.Employer.controller.EmployerController.registerEmployer(..))")
	public void registerEmployerpoint() {}
	
	@Before("registerEmployerpoint()")
	public void beforeUpdateUser(JoinPoint jp)
	{  mylog.info("---------------------------------------------------Before Employer is registered");  }
	
	@Around("registerEmployerpoint()")
	public Object aroundregisterEmployer(ProceedingJoinPoint proceedobj) throws Throwable{
		Object obj = proceedobj.proceed();
		try {
			ResponseEntity response = (ResponseEntity) obj;
			Employer employer = (Employer)response.getBody();
			mylog.info("----------------------------------------------Around Employer is registered");
		}catch(Exception e){ }
		return obj;
	}

	@After("registerEmployerpoint()")
	public void afterregisterEmployer(JoinPoint jp)
	{  mylog.info("---------------------------------------------- After Employer is registered"); }
	
	@AfterThrowing(pointcut="registerEmployerpoint()",throwing="excepobj")
	public void handleexcRegisterEmployer( Exception excepobj)
	{ mylog.warn("----------------------------------------------exception is raised while registering Employer " + excepobj.getMessage()); }
//---------------------------------------------------------------------------------------------------------------------------------------------------

	@Pointcut("execution (* com.topjobs.Employer.controller.EmployerController.viewAllEmployer(..))")
	public void viewAllEmployerpoint() {}
	
	@Before("viewAllEmployerpoint()")
	public void beforeviewAllEmployerpoint(JoinPoint jp)
	{  mylog.info("----------------------------------------------  Before viewAllEmployer");  }
	
	@Around("viewAllEmployerpoint()")
	public Object aroundviewAllEmployerpoint(ProceedingJoinPoint proceedobj) throws Throwable{
		Object obj = proceedobj.proceed();
		try {
			ResponseEntity response = (ResponseEntity) obj;
			List employer = (List)response.getBody();
			mylog.info("----------------------------------------------Around viewAllEmployer");
		}catch(Exception e){ }
		return obj;
	}

	@After("viewAllEmployerpoint()")
	public void afterviewAllEmployerpoint(JoinPoint jp)
	{  mylog.info("---------------------------------------------- After viewAllEmployer"); }
	
	@AfterThrowing(pointcut="viewAllEmployerpoint()",throwing="excepobj")
	public void handleexcviewAllEmployerpoint( Exception excepobj)
	{ mylog.warn("----------------------------------------------exception is raised while viewAllEmployerpoint" + excepobj.getMessage()); }
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------

		@Pointcut("execution (* com.topjobs.Employer.controller.EmployerController.viewEmployer(..))")
		public void viewEmployerpoint() {}
		
		@Before("viewEmployerpoint()")
		public void beforeviewEmployerpoint(JoinPoint jp)
		{  mylog.info("----------------------------------------------  Before viewEmployerpoint");  }
		
		@Around("viewEmployerpoint()")
		public Object aroundviewEmployerpoint(ProceedingJoinPoint proceedobj) throws Throwable{
			Object obj = proceedobj.proceed();
			try {
				ResponseEntity response = (ResponseEntity) obj;
				Employer employer = (Employer)response.getBody();
				mylog.info("----------------------------------------------Around viewAllEmployer");
			}catch(Exception e){ }
			return obj;
		}

		@After("viewEmployerpoint()")
		public void afterviewEmployerpoint(JoinPoint jp)
		{  mylog.info("---------------------------------------------- After viewEmployerpoint"); }
		
		@AfterThrowing(pointcut="viewEmployerpoint()",throwing="excepobj")
		public void handleexcviewEmployerpoint( Exception excepobj)
		{ mylog.warn("----------------------------------------------exception is raised while viewEmployerpoint" + excepobj.getMessage()); }
		
//updateEmployerpoint---------------------------------------------------------------------------------------------------------------------------------------------------

	@Pointcut("execution (* com.topjobs.Employer.controller.EmployerController.updateEmployer(..))")
	public void updateEmployerpoint() {}
	
	@Before("updateEmployerpoint()")
	public void beforeupdateEmployerpoint(JoinPoint jp)
	{  mylog.info("----------------------------------------------  Before updateEmployerpoint");  }
	
	@Around("updateEmployerpoint()")
	public Object aroundupdateEmployerpoint(ProceedingJoinPoint proceedobj) throws Throwable{
		Object obj = proceedobj.proceed();
		try {
			ResponseEntity response = (ResponseEntity) obj;
			Employer employer = (Employer)response.getBody();
			mylog.info("----------------------------------------------Around updateEmployerpoint");
		}catch(Exception e){ }
		return obj;
	}

	@After("updateEmployerpoint()")
	public void afterupdateEmployerpoint(JoinPoint jp)
	{  mylog.info("---------------------------------------------- After updateEmployerpoint"); }
	
	@AfterThrowing(pointcut="updateEmployerpoint()",throwing="excepobj")
	public void handleexcupdateEmployerpoint( Exception excepobj)
	{ mylog.warn("----------------------------------------------exception is raised while updateEmployerpoint" + excepobj.getMessage()); }


//updateaccountStatuspoint---------------------------------------------------------------------------------------------------------------------------------------------------

	@Pointcut("execution (* com.topjobs.Employer.controller.EmployerController.updateaccountStatus(..))")
	public void updateaccountStatuspoint() {}
	
	@Before("updateaccountStatuspoint()")
	public void beforeupdateaccountStatuspoint(JoinPoint jp)
	{  mylog.info("----------------------------------------------  Before updateaccountStatuspoint");  }
	
	@Around("updateaccountStatuspoint()")
	public Object aroundupdateaccountStatuspoint(ProceedingJoinPoint proceedobj) throws Throwable{
		Object obj = proceedobj.proceed();
		try {
			ResponseEntity response = (ResponseEntity) obj;
			String employer = (String)response.getBody();
			mylog.info("----------------------------------------------Around updateaccountStatuspoint");
		}catch(Exception e){ }
		return obj;
	}

	@After("updateaccountStatuspoint()")
	public void afterupdateaccountStatuspoint(JoinPoint jp)
	{  mylog.info("--------------------------------------------------After updateaccountStatuspoint"); }
	
	@AfterThrowing(pointcut="updateaccountStatuspoint()",throwing="excepobj")
	public void handleexcupdateaccountStatuspoint( Exception excepobj)
	{ mylog.warn("---------------------------------------------------exception is raised while updateaccountStatuspoint" + excepobj.getMessage()); }

//---------------------------------------------------------------------------------------------------------------------------------------------------

	@Pointcut("execution (* com.topjobs.Employer.controller.EmployerController.deleteEmployer(..))")
	public void deleteEmployerpoint() {}
	
	@Before("deleteEmployerpoint()")
	public void beforedeleteEmployerpoint(JoinPoint jp)
	{  mylog.info("----------------------------------------------Before deleteEmployerpoint");  }
	
	@Around("deleteEmployerpoint()")
	public Object arounddeleteEmployerpoint(ProceedingJoinPoint proceedobj) throws Throwable{
		Object obj = proceedobj.proceed();
		try {
			ResponseEntity response = (ResponseEntity) obj;
			String employer = (String)response.getBody();
			mylog.info("----------------------------------------------Around deleteEmployerpoint");
		}catch(Exception e){ }
		return obj;
	}

	@After("deleteEmployerpoint()")
	public void afterdeleteEmployerpoint(JoinPoint jp)
	{  mylog.info("---------------------------------------------- After deleteEmployerpoint"); }
	
	@AfterThrowing(pointcut="deleteEmployerpoint()",throwing="excepobj")
	public void handleexcdeleteEmployerpoint( Exception excepobj)
	{ mylog.warn("----------------------------------------------exception is raised while deleteEmployerpoint" + excepobj.getMessage()); }




}
