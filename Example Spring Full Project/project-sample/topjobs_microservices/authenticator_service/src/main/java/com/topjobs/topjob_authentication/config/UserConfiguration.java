package com.topjobs.topjob_authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class UserConfiguration {

	@Bean
	public Docket getDocket()
	{
		
		return new Docket(DocumentationType.SWAGGER_2).select()
								.apis(RequestHandlerSelectors.basePackage("com.topjobs.topjob_authentication"))
								.build()
								.apiInfo(setDetails())
								.useDefaultResponseMessages(false);
				
		
	}
	
	public ApiInfo setDetails()
	{
		ApiInfoBuilder apibuild=new ApiInfoBuilder();
		apibuild.title("Authenticator").version("Ver 1.1").description("This service contains operations for authentication details")
									.license("divyaswetha.meduri@cgi.com");
		
		return apibuild.build();
	}
	
}
