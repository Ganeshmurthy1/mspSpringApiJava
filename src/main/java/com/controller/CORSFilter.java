package com.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CORSFilter extends OncePerRequestFilter  {
 

	
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
					throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.trace("CORSFilter-------------doFilterInternal.");
		
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			logger.trace("Sending Header Now....");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
			response.addHeader("Access-Control-Max-Age", "360");
			logger.trace("Done Header Now....");
		}

		filterChain.doFilter(request, response);
	}

}