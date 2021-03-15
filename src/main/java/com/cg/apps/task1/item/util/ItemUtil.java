package com.cg.apps.task1.item.util;

import org.springframework.stereotype.Component;

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
		return details;
	}
	

}
