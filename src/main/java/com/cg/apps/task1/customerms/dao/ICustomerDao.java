package com.cg.apps.task1.customerms.dao;

import com.cg.apps.task1.customerms.entities.Customer;

public interface ICustomerDao {
	Customer add(Customer customer);

	Customer findByID(Long customerID);

	Customer update(Customer customer);
}