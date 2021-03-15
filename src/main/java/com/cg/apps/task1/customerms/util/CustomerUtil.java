package com.cg.apps.task1.customerms.util;

import java.util.*;

import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerms.dto.CustomerDetails;
import com.cg.apps.task1.customerms.entities.Customer;
@Component
public class CustomerUtil {
	
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails details = new CustomerDetails();
		details.setId(customer.getId());
		details.setName(customer.getName());
		details.setAccountId(customer.getAccount().getAccountId());
		details.setBalance(customer.getAccount().getBalance());
		return details;
		
	}
	
}
