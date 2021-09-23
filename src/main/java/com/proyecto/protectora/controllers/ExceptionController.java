package com.proyecto.protectora.controllers;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	Logger log = LoggerFactory.getLogger(EntityNotFoundException.class);
	

	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest request, Exception e) {
		log.error("Request " + request.getRequestURL() + "Threw an Exception", e);
        
		return "error/error-specific";
	}

}
