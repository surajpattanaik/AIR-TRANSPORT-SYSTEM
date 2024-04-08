package com.air.exception;


import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.air.exception.bean.ErrorDetails;
import com.air.exception.bean.ResourceNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,WebRequest req){
		
		ErrorDetails error=new ErrorDetails(LocalDate.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Object> handleAllException(RuntimeException ex,WebRequest req){
		
		ErrorDetails error=new ErrorDetails(LocalDate.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex,WebRequest req){
		
		ErrorDetails error=new ErrorDetails(LocalDate.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		
	}

}
