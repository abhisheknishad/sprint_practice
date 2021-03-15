package com.cg.apps.task1.item.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.task1.item.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.item.exceptions.InvalidPriceException;

@RestControllerAdvice
public class ItemCentralizedExceptionHandler {
	
	@ExceptionHandler(InvalidDescriptionException.class)
	public String invalidDescriptionException(InvalidDescriptionException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidPriceException.class)
	public String invalidPriceException(InvalidPriceException e) {
		return e.getMessage();
	}

}
