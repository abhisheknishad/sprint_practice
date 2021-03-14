package com.cg.apps.task1.customerms.ui;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.exception.*;
import com.cg.apps.task1.customerms.service.ICustomerService;
import com.cg.apps.task1.item.entites.Item;
import com.cg.apps.task1.item.service.IItemService;
import com.cg.apps.task1.item.ui.*;

@Component
public class CustomerUI {
	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private IItemService itemService;

	public void start() {
		try {
			Customer customer1 = custService.createCustomer("Abhishek");
			displayCustomerDetails(customer1);
			Customer customer2 = custService.createCustomer("Arpit");
			displayCustomerDetails(customer2);
			Long customerFetched = customer1.getId();
			
			Item item1 =itemService.create(50.0, "frutis");
			Item item2 =itemService.create(100.0, "ice-cream");
			displayItemDetails(item1);
			String itemFetched=item2.getId();

			Item newItem=itemService.buyItem(item1.getId(), customer1.getId());
			Item newItem2=itemService.buyItem(item2.getId(), customer1.getId());
			Set<Item>items=custService.itemsBoughtByCustomer(customerFetched);
			for(Item item:items) {
				System.out.println("Item "+item.getDescription()+" is bought by "+item.getBoughtBy().getName());
			}
			
			//displayCustomerDetails(customer1);
			

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

	public void displayCustomerDetails(Customer customer) {
		System.out.println("Id:" + customer.getId() + "\nName:" + customer.getName() + "\nAccountBalance:"
				+ customer.getAccount().getBalance());
		
	}
	public void displayItemDetails(Item item) {
		System.out.println("ID:"+item.getId()+"\nDescription:"+item.getDescription()+"\nPrice:"+item.getPrice()+"\nAddedDate"+item.getAddedDate());
	}
}
