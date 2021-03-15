package com.cg.apps.task1.customerms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.task1.customerms.dto.AddBalanceInCustomerAccount;
import com.cg.apps.task1.customerms.dto.CreateCustomerRequest;
import com.cg.apps.task1.customerms.dto.CustomerDetails;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.service.ICustomerService;
import com.cg.apps.task1.customerms.util.CustomerUtil;
import com.cg.apps.task1.item.dto.ItemDetails;
import com.cg.apps.task1.item.entites.Item;
import com.cg.apps.task1.item.service.IItemService;
import com.cg.apps.task1.item.util.ItemUtil;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private CustomerUtil util;
	
	@Autowired
	private ItemUtil itemUtil;
	
	
	@GetMapping("/byid/{id}")
	public CustomerDetails fetchedCustomer(@PathVariable("id") long customerId) {
		Customer customer=custService.findByID(customerId);
		CustomerDetails details=util.toDetails(customer);
		return details;
	}

	@PostMapping("/createNew")
	public String createCustomer(@RequestBody CreateCustomerRequest requestData) {
		Customer created = custService.createCustomer(requestData.getName());
		return "Customer created with Id "+created.getId();
	}
	
	

	@PutMapping("/addBalance")
	public String CustomerDetails(@RequestBody AddBalanceInCustomerAccount requestData) {
		Customer created = custService.addAmount(requestData.getId(), requestData.getAmountToBeAdded());
		CustomerDetails customer = util.toDetails(created);
		return "Amount Added in Customer Account";
	}
	
	@GetMapping("/customer/{id}")
	public Set<ItemDetails> itemBoughtByCustomer(@PathVariable Long id) {
		Set<Item> itemSet = custService.itemsBoughtByCustomer(id);
		return itemUtil.toDetailSet(itemSet);
	}
	
	
}
	

