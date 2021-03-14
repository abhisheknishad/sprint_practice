package com.cg.apps.task1.item.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.customerms.dao.ICustomerDao;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.item.dao.*;
import com.cg.apps.task1.item.entites.*;
import com.cg.apps.task1.item.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.item.exceptions.InvalidPriceException;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao itemDao;
	
	@Autowired
	private ICustomerDao custDao;

	@Transactional
	@Override
	public Item create(Double price, String description) {
		Item item = new Item(price, description);
		LocalDateTime currentTime = LocalDateTime.now();
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
		Customer customer = custDao.findByID(customerID);
		Item item = findByID(itemID);
		item.setBoughtBy(customer);
		Set<Item> items=customer.getBroughtItems();
		if(items==null){
			items=new HashSet<>();
			customer.setBroughtItems(items);
		}
		items.add(item);
		customer.setBroughtItems(items);
		itemDao.update(item);
		custDao.update(customer);
		return item;
	}

	public void validatePrice(double price) {
		if (price < 0) {
			throw new InvalidPriceException("Price can't be negative");
		}
	}

	public void validateDescription(String description) {
		if (description.isEmpty() || description == null || description.trim().isEmpty()) {
			throw new InvalidDescriptionException("Provide some description");
		}
	}

}
