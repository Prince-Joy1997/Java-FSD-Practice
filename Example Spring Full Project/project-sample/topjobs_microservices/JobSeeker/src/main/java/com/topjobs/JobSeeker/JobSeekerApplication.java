package com.topjobs.JobSeeker;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.topjobs.JobSeeker.filter.JobSeekerFilter;

@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JobSeekerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSeekerApplication.class, args);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean getfilter() {
		UrlBasedCorsConfigurationSource urlConfig = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowCredentials(true);
		List<String> all = Arrays.asList("*");
     
		config.setAllowedOrigins(all);
		config.setAllowedMethods(all);
		config.setAllowedHeaders(all);
     
		urlConfig.registerCorsConfiguration("/**", config);
     
	    FilterRegistrationBean filterBean = new FilterRegistrationBean(new CorsFilter(urlConfig));
	    filterBean.setFilter(new JobSeekerFilter());
//	    filterBean.addUrlPatterns("/jobSeeker/*");
	    filterBean.addUrlPatterns("/jobSeeker/viewAllJobSeekers");
	    filterBean.addUrlPatterns("/jobSeeker/viewJobSeeker");
	    filterBean.addUrlPatterns("/jobSeeker/updateJobSeeker");
	    filterBean.addUrlPatterns("/jobSeeker/updateJobSeekerResume");
	    filterBean.addUrlPatterns("/jobSeeker/deleteJobSeeker");
	    filterBean.addUrlPatterns("/jobSeeker/addJobSeekerApplication");
	    filterBean.addUrlPatterns("/jobSeeker/viewAllApplicationsByJobSeekerId");
	    filterBean.addUrlPatterns("/jobSeeker/viewAllJobSeekersByJobId");
	    filterBean.addUrlPatterns("/jobSeeker/viewAllSelectedJobSeekersByJobId");
	    filterBean.addUrlPatterns("/jobSeeker/viewAllRejectedJobSeekersByJobId");
	    filterBean.addUrlPatterns("/jobSeeker/updateApplicationStatus");
     
		return filterBean;
	}
}
