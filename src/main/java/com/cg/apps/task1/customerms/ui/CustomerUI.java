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
			//displayCustomerDetails(customer1);
			Customer customer2 = custService.createCustomer("Arpit");
			//displayCustomerDetails(customer2);
			Long customerFetched = customer1.getId();
			
			
			
			Item item1 =itemService.create(50.0, "frutis");
			Item item2 =itemService.create(100.0, "ice-cream");
			displayItemDetails(item1);
			String itemFetched=item2.getId();
			Item newItem=itemService.buyItem(item1.getId(), customer1.getId());
			//Item newItem2=itemService.buyItem(item2.getId(), customer1.getId());
			
			
			Customer abhishek=custService.addAmount(customerFetched, 1000);
			System.out.println("Displaying amount of Abhishek");
			displayCustomerDetails(abhishek);
			
			customer1=custService.findByID(customerFetched);
			displayCustomerDetails(customer1);
			System.out.println("ITEM details");
			displayItemDetails(item2);
			

		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidCustomerNameException e) {
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
		Set<Item>items=customer.getBroughtItems();
		for(Item item:items) {
			System.out.println("Item "+item.getDescription()+" is bought by "+item.getBoughtBy().getName());
		}
		
	}
	public void displayItemDetails(Item item) {
		System.out.println("ID:"+item.getId()+"\nDescription:"+item.getDescription()+"\nPrice:"+item.getPrice()+"\nAddedDate"+item.getAddedDate());
	}
}
