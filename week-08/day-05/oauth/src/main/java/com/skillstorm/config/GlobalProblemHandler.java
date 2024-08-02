package com.skillstorm.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.skillstorm.models.Message;

import jakarta.servlet.http.HttpServletRequest;

// this lets this class "advise" any calls to our controllers
// i.e., handle their exceptions
// and lets it package up responses to errors/exceptions as HttpResponse objects
@RestControllerAdvice
public class GlobalProblemHandler {
	
	// for a certain type of problem, here's a method to handle it
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public Message notFound(HttpServletRequest req, Exception e) {
		return new Message("Not found");
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public Message internalError(HttpServletRequest req, Exception e) {
		return new Message(e.getMessage());
	}

}
