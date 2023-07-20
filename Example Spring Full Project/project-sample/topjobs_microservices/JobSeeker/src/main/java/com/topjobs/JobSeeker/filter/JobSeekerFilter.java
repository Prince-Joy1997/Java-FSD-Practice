package com.topjobs.JobSeeker.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JobSeekerFilter extends GenericFilter{

	@SuppressWarnings("rawtypes")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		httpResponse.setHeader("Access-Control-Allow-Origin","*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.setHeader("Access-Control-Allow-Headers", "*");
		
		if (httpRequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
			chain.doFilter(httpRequest, httpResponse);
		}else{
			String authheader = httpRequest.getHeader("Authorization");
			
			if((authheader == null) || (!authheader.startsWith("Bearer"))) {
				throw new ServletException("JWT Token is missing");
			}
			
			String myToken = authheader.substring(7);
			
			try {
				JwtParser jwtParser = Jwts.parser().setSigningKey("topjobkey");
				Jwt jwtObj = jwtParser.parse(myToken);
				Claims claimObj = (Claims)jwtObj.getBody();
				System.out.println("Welcome " + claimObj.getSubject());
			}catch (SignatureException sigex) {
				throw new ServletException("JWT signature mismatch");
			}catch(MalformedJwtException malform) { 
				throw new ServletException("Token is modified by unauthorized user");
			}
		}
		
		chain.doFilter(httpRequest, httpResponse);
	}
}
