package com.topjobs.job.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.support.RequestHandledEvent;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				
				.apis(RequestHandlerSelectors.basePackage("com.topjobs.job"))
				.build()
				.apiInfo(setDetails())
				.useDefaultResponseMessages(false);
	}
	
	public ApiInfo setDetails() {
		ApiInfoBuilder apiBuild = new ApiInfoBuilder();
		apiBuild.title("Job")
				.version("Ver 1.1")
				.description("This app is used to provide job endpoints")
				.license("fernanda.goncalvesrios@cgi.com");
		return apiBuild.build();
	}
	

}
