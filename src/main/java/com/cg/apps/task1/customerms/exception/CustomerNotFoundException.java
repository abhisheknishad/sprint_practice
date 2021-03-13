package com.cg.apps.task1.customerms.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}