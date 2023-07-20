package com.topjobs.Employer;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.topjobs.Employer.filter.EmployerFilter;

@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmployerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployerApplication.class, args);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean getfilter()
	{
		UrlBasedCorsConfigurationSource urlconfig=new UrlBasedCorsConfigurationSource();
     CorsConfiguration config=new CorsConfiguration();
     
     config.setAllowCredentials(true);
     List<String> all=Arrays.asList("*");
     
     config.setAllowedOrigins(all);
     config.setAllowedMethods(all);
     config.setAllowedHeaders(all);
     
     urlconfig.registerCorsConfiguration("/**", config);
     
     FilterRegistrationBean fbean=new FilterRegistrationBean(new CorsFilter(urlconfig));
     fbean.setFilter(new EmployerFilter());
//     fbean.addUrlPatterns("/employer/*");
     fbean.addUrlPatterns("/employer/viewAllEmployer");
     fbean.addUrlPatterns("/employer/viewEmployer");
     fbean.addUrlPatterns("/employer/updateEmployer");
     fbean.addUrlPatterns("/employer/updateAccountStatus");
     fbean.addUrlPatterns("/employer/deleteEmployer");
     fbean.addUrlPatterns("/employer/viewEmployerBystatus");
     
	return fbean;
	}


}
