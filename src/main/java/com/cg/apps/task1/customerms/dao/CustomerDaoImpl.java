/*package com.cg.apps.task1.customerms.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.exception.CustomerNotFoundException;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findByID(Long customerID) {
		Customer customer = entityManager.find(Customer.class, customerID);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer does not exist for ID: " + customerID);
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		customer = entityManager.merge(customer);
		return customer;
	}

}*/