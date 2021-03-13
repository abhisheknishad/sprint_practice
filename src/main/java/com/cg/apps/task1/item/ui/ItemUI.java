package com.cg.apps.task1.item.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.task1.item.entites.Item;
import com.cg.apps.task1.item.service.IItemService;

@Component
public class ItemUI {
	
	@Autowired
	private IItemService itemService;
	
	public void start() {
		Item item =itemService.create(50.0, "frutis");
		Item item2 =itemService.create(100.0, "ice-cream");
		displayItemDetails(item);
		String itemFetched=item2.getId();

	}
	public void displayItemDetails(Item item) {
		System.out.println("ID:"+item.getId()+"\nDescription:"+item.getDescription()+"\nPrice:"+item.getPrice()+"\nAddedDate"+item.getAddedDate());
	}

}
