package com.adidas.manish.citypathanalyser.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adidas.manish.citypathanalyser.model.ExceptionJSONInfo;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
  {
 
	@ExceptionHandler(Exception.class)	
	protected ResponseEntity<Object> handleConflict(
			Exception ex, WebRequest request) {
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setError(ex.getMessage());
		HttpHeaders h=new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		        return handleExceptionInternal(ex, response, 
		          h, HttpStatus.BAD_REQUEST, request);
		    }
}
