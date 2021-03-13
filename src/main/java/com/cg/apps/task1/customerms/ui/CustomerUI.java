package com.cg.apps.task1.customerms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.exception.*;
import com.cg.apps.task1.customerms.service.ICustomerService;

@Component
public class CustomerUI {
	@Autowired
	private ICustomerService service;

	public void start() {
		try {
			Customer customer = service.createCustomer("Abhishek");
			DisplayCustomerDetails(customer);
			Customer customer2=service.createCustomer("Arpit");
			Long customerFetched = customer.getId();
		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
		} catch (InvalidAmountException e) {
			System.out.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void DisplayCustomerDetails(Customer customer) {
		System.out.println("Id:"+customer.getId()+"\nName:"+customer.getName()+"\nAccountBalance:"+customer.getAccount().getBalance());
	}
}
