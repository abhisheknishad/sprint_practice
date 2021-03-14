package com.cg.apps.task1.customerms.service;

import java.util.Set;

import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.item.entites.Item;

public interface ICustomerService {
	Customer findByID(Long customerID);

	Customer createCustomer(String name);

	Customer addAmount(Long customerId, double amount);

	Set<Item> itemsBoughtByCustomer(Long customerID);
}