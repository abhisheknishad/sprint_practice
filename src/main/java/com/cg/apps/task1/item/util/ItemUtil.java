package com.cg.apps.task1.item.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.item.dto.ItemDetails;
import com.cg.apps.task1.item.entites.Item;

@Component
public class ItemUtil {
	
	public ItemDetails toDetails(Item item) {
		ItemDetails details = new ItemDetails();
		details.setItemId(item.getId());
		details.setItemDescription(item.getDescription());
		details.setPrice(item.getPrice());
		details.setAddedDate(item.getAddedDate());
		Customer customer =item.getBoughtBy();
		if(customer!=null) {
			details.setCustId(customer.getId());
			details.setCustName(customer.getName());
		}
		return details;
	}
	
	public Set<ItemDetails> toDetailSet(Set<Item> items) {

		Set<ItemDetails> itemDesired = new HashSet<>();

		for (Item item : items) {
			ItemDetails itemDetails = toDetails(item);
			itemDesired.add(itemDetails);
		}
		return itemDesired;
	}
}

