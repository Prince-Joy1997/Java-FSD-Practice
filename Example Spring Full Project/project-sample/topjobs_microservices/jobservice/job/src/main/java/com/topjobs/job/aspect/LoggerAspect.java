package com.topjobs.job.aspect;

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
		// addJob
		//*************************************************************************************
		@Before("execution (* com.topjobs.job.controller.JobController.addJob(..))")
		public void beforeAddJob(JoinPoint jp){
			logger.info("addJob was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.addJob(..))")
		public void afterAddJob(JoinPoint jp){
			logger.info("addJob has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.addJob(..))")
		public void afterReturningAddJob(JoinPoint jp){
			logger.info("addJob has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.addJob(..))", throwing="e")
		public void afterThrowingAddJob(Exception e){
			logger.warn("addJob has executed with an exception message: " + e.getMessage());
		}
		
		//*************************************************************************************
		// viewJobs
		//*************************************************************************************
		@Before("execution (* com.topjobs.job.controller.JobController.viewJobs(..))")
		public void beforeViewJobs(JoinPoint jp){
			logger.info("viewJobs was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.viewJobs(..))")
		public void afterViewJobs(JoinPoint jp){
			logger.info("viewJobs has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.viewJobs(..))")
		public void afterReturningViewJobs(JoinPoint jp){
			logger.info("viewJobs has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.viewJobs(..))", throwing="e")
		public void afterThrowingViewJobs(Exception e){
			logger.warn("viewJobs has executed with an exception message: " + e.getMessage());
		}
		
		
		//*************************************************************************************
		// deleteJob
		//*************************************************************************************
		@Before("execution (* com.topjobs.job.controller.JobController.deleteJob(..))")
		public void beforeDeleteJob(JoinPoint jp){
			logger.info("deleteJob was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.deleteJob(..))")
		public void afterDeleteJob(JoinPoint jp){
			logger.info("deleteJob has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.deleteJob(..))")
		public void afterReturningDeleteJob(JoinPoint jp){
			logger.info("deleteJob has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.deleteJob(..))", throwing="e")
		public void afterThrowingDeleteJob(Exception e){
			logger.warn("deleteJob has executed with an exception message: " + e.getMessage());
		}
		
		
//		//*************************************************************************************
//		// viewJobById
//		//*************************************************************************************
		@Before("execution (* com.topjobs.job.controller.JobController.viewJobById(..))")
		public void beforeViewJobById(JoinPoint jp){
			logger.info("viewJobById was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.viewJobById(..))")
		public void afterViewJobById(JoinPoint jp){
			logger.info("viewJobById has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.viewJobById(..))")
		public void afterReturningViewJobById(JoinPoint jp){
			logger.info("viewJobById has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.viewJobById(..))", throwing="e")
		public void afterThrowingViewJobById(Exception e){
			logger.warn("viewJobById has executed with an exception message: " + e.getMessage());
		}
//		
		//*************************************************************************************
		// viewAllJobsByEmployerId
		//*************************************************************************************
		
		@Before("execution (* com.topjobs.job.controller.JobController.viewAllJobsByEmployerId(..))")
		public void beforeViewAllJobsByEmployerId(JoinPoint jp){
			logger.info("viewAllJobsByEmployerId was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.viewAllJobsByEmployerId(..))")
		public void afterViewAllJobsByEmployerId(JoinPoint jp){
			logger.info("viewAllJobsByEmployerId has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.viewAllJobsByEmployerId(..))")
		public void afterReturningViewAllJobsByEmployerId(JoinPoint jp){
			logger.info("viewAllJobsByEmployerId has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.viewAllJobsByEmployerId(..))", throwing="e")
		public void afterThrowingViewAllJobsByEmployerId(Exception e){
			logger.warn("viewAllJobsByEmployerId has executed with an exception message: " + e.getMessage());
		}
		
		//*************************************************************************************
		// updateJobById
		//*************************************************************************************
		
		@Before("execution (* com.topjobs.job.controller.JobController.updateJobById(..))")
		public void beforeUpdateJobById(JoinPoint jp){
			logger.info("updateJobById was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.updateJobById(..))")
		public void afterUpdateJobById(JoinPoint jp){
			logger.info("updateJobById has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.updateJobById(..))")
		public void afterReturningUpdateJobById(JoinPoint jp){
			logger.info("updateJobById has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.updateJobById(..))", throwing="e")
		public void afterThrowingUpdateJobById(Exception e){
			logger.warn("updateJobById has executed with an exception message: " + e.getMessage());
		}
		
//		//*************************************************************************************
//		// updateJobStatus
//		//*************************************************************************************
		@Before("execution (* com.topjobs.job.controller.JobController.updateJobStatus(..))")
		public void beforeUpdateJobStatus(JoinPoint jp){
			logger.info("updateJobStatus was called.");
		}
		
		@After("execution (* com.topjobs.job.controller.JobController.updateJobStatus(..))")
		public void afterUpdateJobStatus(JoinPoint jp){
			logger.info("updateJobStatus has executed.");
		}
		
		@AfterReturning("execution (* com.topjobs.job.controller.JobController.updateJobStatus(..))")
		public void afterReturningUpdateJobStatus(JoinPoint jp){
			logger.info("updateJobStatus has executed with a return value.");
		}
		
		@AfterThrowing(pointcut="execution (* com.topjobs.job.controller.JobController.updateJobStatus(..))", throwing="e")
		public void afterThrowingUpdateJobStatus(Exception e){
			logger.warn("updateJobStatus has executed with an exception message: " + e.getMessage());
		}
	
}
