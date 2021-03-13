package com.cg.apps.task1.customerms.service;

import com.cg.apps.task1.customerms.entities.Customer;

public interface ICustomerService {
	Customer findByID(Long customerID);

	Customer createCustomer(String name);
	
	Customer addAmount(Long customerId, double amount);		
}