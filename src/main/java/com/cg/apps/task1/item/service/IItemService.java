package com.cg.apps.task1.item.service;

import com.cg.apps.task1.item.entites.*;

public interface IItemService {

	public Item create(Double price, String description);

	public Item findByID(String itemID);

	public Item buyItem(String itemID, long customerID);
	
}