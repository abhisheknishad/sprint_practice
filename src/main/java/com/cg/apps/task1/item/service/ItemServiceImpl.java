package com.cg.apps.task1.item.service;

import java.time.LocalDateTime;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.apps.task1.item.dao.*;
import com.cg.apps.task1.item.entites.*;
import com.cg.apps.task1.item.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.item.exceptions.InvalidPriceException;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	private IItemDao itemDao;
	

	@Transactional
	@Override
	public Item create(Double price, String description) {
		Item item=new Item(price,description);
		LocalDateTime currentTime=LocalDateTime.now();
		item.setAddedDate(currentTime);
		return itemDao.add(item);
	}

	@Override
	public Item findByID(String itemID) {
		return itemDao.findByID(itemID);
	}

	@Transactional
	@Override
	public Item buyItem(String itemID, long customerID) {
		return null;
		
	}
	
	public void validatePrice(double price){
		if(price<0) {
			throw new InvalidPriceException("Price can't be negative");
		}
	}
	public void validateDescription(String description) {
		if(description.isEmpty()||description==null ||description.trim().isEmpty()) {
			throw new InvalidDescriptionException("Provide some description");
		}
	}
	
	
	
	

}