package com.skillstorm.config.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.models.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// the intention for this class is to handle any errors/exceptions that occur during the authentication process
// our security config will require this
@Component
public class AuthenticationErrorHandler implements AuthenticationEntryPoint {
	
	private ObjectMapper mapper;
	
	public AuthenticationErrorHandler(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void commence(HttpServletRequest request, 
						 HttpServletResponse response,
						 AuthenticationException authException) throws IOException, ServletException {
		
		Message errorMessage = new Message("Needs authentication");
		String messageJSON = mapper.writeValueAsString(errorMessage);
		
		// setting a status code, can do it this way if you don't know the number or think this is more readable
		// response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setStatus(401);
		
		// setting the content type for the response
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		// writing the stringified object to the response
		response.getWriter().write(messageJSON);
		
		// clearing out of the buffer in the writer for future responses
		response.flushBuffer();
		
	}

}








