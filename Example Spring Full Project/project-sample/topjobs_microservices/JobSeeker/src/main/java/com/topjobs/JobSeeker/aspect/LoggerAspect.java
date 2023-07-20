package com.topjobs.JobSeeker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	// Create Logger
	Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	

	//*************************************************************************************
	// registerJobSeeker
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.registerJobSeeker(..))")
	public void beforeRegisterJobSeeker(JoinPoint jp){
		logger.info("registerJobSeeker was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.registerJobSeeker(..))")
	public void afterRegisterJobSeeker(JoinPoint jp){
		logger.info("registerJobSeeker has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.registerJobSeeker(..))")
	public void afterReturningRegisterJobSeeker(JoinPoint jp){
		logger.info("registerJobSeeker has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.registerJobSeeker(..))", throwing="e")
	public void afterThrowingRegisterJobSeeker(Exception e){
		logger.warn("registerJobSeeker has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// viewAllJobSeekers
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekers(..))")
	public void beforeViewAllJobSeekers(JoinPoint jp){
		logger.info("viewAllJobSeekers was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekers(..))")
	public void afterViewAllJobSeekers(JoinPoint jp){
		logger.info("viewAllJobSeekers has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekers(..))")
	public void afterReturningViewAllJobSeekers(JoinPoint jp){
		logger.info("viewAllJobSeekers has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekers(..))", throwing="e")
	public void afterThrowingViewAllJobSeekers(Exception e){
		logger.warn("viewAllJobSeekers has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// viewJobSeeker
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewJobSeeker(..))")
	public void beforeViewJobSeeker(JoinPoint jp){
		logger.info("viewJobSeeker was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewJobSeeker(..))")
	public void afterViewJobSeeker(JoinPoint jp){
		logger.info("viewJobSeeker has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewJobSeeker(..))")
	public void afterReturningViewJobSeeker(JoinPoint jp){
		logger.info("viewJobSeeker has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewJobSeeker(..))", throwing="e")
	public void afterThrowingViewJobSeeker(Exception e){
		logger.warn("viewJobSeeker has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// updateJobSeeker
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeeker(..))")
	public void beforeUpdateJobSeeker(JoinPoint jp){
		logger.info("updateJobSeeker was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeeker(..))")
	public void afterUpdateJobSeeker(JoinPoint jp){
		logger.info("updateJobSeeker has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeeker(..))")
	public void afterReturningUpdateJobSeeker(JoinPoint jp){
		logger.info("updateJobSeeker has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeeker(..))", throwing="e")
	public void afterThrowingUpdateJobSeeker(Exception e){
		logger.warn("updateJobSeeker has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// updateJobSeekerResume
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeekerResume(..))")
	public void beforeUpdateJobSeekerResume(JoinPoint jp){
		logger.info("updateJobSeekerResume was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeekeResume(..))")
	public void afterUpdateJobSeekerResume(JoinPoint jp){
		logger.info("updateJobSeekerResume has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeekerResume(..))")
	public void afterReturningUpdateJobSeekerResume(JoinPoint jp){
		logger.info("updateJobSeekerResume has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateJobSeekerResume(..))", throwing="e")
	public void afterThrowingUpdateJobSeekerResume(Exception e){
		logger.warn("updateJobSeekerResume has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// deleteJobSeeker
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.deleteJobSeeker(..))")
	public void beforeDeleteJobSeeker(JoinPoint jp){
		logger.info("deleteJobSeeker was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.deleteJobSeeker(..))")
	public void afterDeleteJobSeeker(JoinPoint jp){
		logger.info("deleteJobSeeker has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.deleteJobSeeker(..))")
	public void afterReturningDeleteJobSeeker(JoinPoint jp){
		logger.info("deleteJobSeeker has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.deleteJobSeeker(..))", throwing="e")
	public void afterThrowingDeleteJobSeeker(Exception e){
		logger.warn("deleteJobSeeker has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// addJobSeekerApplication
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.addJobSeekerApplication(..))")
	public void beforeAddJobSeekerApplication(JoinPoint jp){
		logger.info("addJobSeekerApplication was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.addJobSeekerApplication(..))")
	public void afterAddJobSeekerApplication(JoinPoint jp){
		logger.info("addJobSeekerApplication has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.addJobSeekerApplication(..))")
	public void afterReturningAddJobSeekerApplication(JoinPoint jp){
		logger.info("addJobSeekerApplication has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.addJobSeekerApplication(..))", throwing="e")
	public void afterThrowingAddJobSeekerApplication(Exception e){
		logger.warn("addJobSeekerApplication has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// viewAllApplicationsByJobSeekerId
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllApplicationsByJobSeekerId(..))")
	public void beforeViewAllApplicationsByJobSeekerId(JoinPoint jp){
		logger.info("viewAllApplicationsByJobSeekerId was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllApplicationsByJobSeekerId(..))")
	public void afterViewAllApplicationsByJobSeekerId(JoinPoint jp){
		logger.info("viewAllApplicationsByJobSeekerId has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllApplicationsByJobSeekerId(..))")
	public void afterReturningViewAllApplicationsByJobSeekerId(JoinPoint jp){
		logger.info("viewAllApplicationsByJobSeekerId has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllApplicationsByJobSeekerId(..))", throwing="e")
	public void afterThrowingViewAllApplicationsByJobSeekerId(Exception e){
		logger.warn("viewAllApplicationsByJobSeekerId has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// viewAllJobSeekersByJobId
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekersByJobId(..))")
	public void beforeViewAllJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllJobSeekersByJobId was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekersByJobId(..))")
	public void afterViewAllJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllJobSeekersByJobId has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekersByJobId(..))")
	public void afterReturningViewAllJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllJobSeekersByJobId has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllJobSeekersByJobId(..))", throwing="e")
	public void afterThrowingViewAllJobSeekersByJobId(Exception e){
		logger.warn("viewAllJobSeekersByJobId has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// viewAllSelectedJobSeekersByJobId
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllSelectedJobSeekersByJobId(..))")
	public void beforeViewAllSelectedJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllSelectedJobSeekersByJobId was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllSelectedJobSeekersByJobId(..))")
	public void afterViewAllSelectedJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllSelectedJobSeekersByJobId has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllSelectedJobSeekersByJobId(..))")
	public void afterReturningViewAllSelectedJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllSelectedJobSeekersByJobId has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllSelectedJobSeekersByJobId(..))", throwing="e")
	public void afterThrowingViewAllSelectedJobSeekersByJobId(Exception e){
		logger.warn("viewAllSelectedJobSeekersByJobId has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// viewAllRejectedJobSeekersByJobId
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllRejectedJobSeekersByJobId(..))")
	public void beforeViewAllRejectedJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllRejectedJobSeekersByJobId was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllRejectedJobSeekersByJobId(..))")
	public void afterViewAllRejectedJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllRejectedJobSeekersByJobId has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllRejectedJobSeekersByJobId(..))")
	public void afterReturningViewAllRejectedJobSeekersByJobId(JoinPoint jp){
		logger.info("viewAllRejectedJobSeekersByJobId has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.viewAllRejectedJobSeekersByJobId(..))", throwing="e")
	public void afterThrowingViewAllRejectedJobSeekersByJobId(Exception e){
		logger.warn("viewAllRejectedJobSeekersByJobId has executed with an exception message: " + e.getMessage());
	}
	
	//*************************************************************************************
	// updateApplicationStatus
	//*************************************************************************************
	@Before("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateApplicationStatus(..))")
	public void beforeUpdateApplicationStatus(JoinPoint jp){
		logger.info("updateApplicationStatus was called.");
	}
	
	@After("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateApplicationStatus(..))")
	public void afterUpdateApplicationStatus(JoinPoint jp){
		logger.info("updateApplicationStatus has executed.");
	}
	
	@AfterReturning("execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateApplicationStatus(..))")
	public void afterReturningUpdateApplicationStatus(JoinPoint jp){
		logger.info("updateApplicationStatus has executed with a return value.");
	}
	
	@AfterThrowing(pointcut="execution (* com.topjobs.JobSeeker.controller.JobSeekerController.updateApplicationStatus(..))", throwing="e")
	public void afterThrowingUpdateApplicationStatus(Exception e){
		logger.warn("updateApplicationStatus has executed with an exception message: " + e.getMessage());
	}
}
