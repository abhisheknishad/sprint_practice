package com.cg.apps.task1.customerms.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.task1.customerms.exception.CustomerNotFoundException;
import com.cg.apps.task1.customerms.exception.InvalidAmountException;
import com.cg.apps.task1.customerms.exception.InvalidCustomerNameException;
import com.cg.apps.task1.customerms.exception.InvalidIdException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
		public String handleCustomerNotFoundException(CustomerNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidAmountException.class)
	public String handleInvalidAmountNotFoundException(InvalidAmountException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidIdException.class)
	public String handleInvalidIdException(InvalidIdException e){
		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidCustomerNameException.class)
	public String handleInvalidCustomerName(InvalidCustomerNameException e) {
		return e.getMessage();
	}
}
