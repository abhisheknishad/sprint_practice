package com.cg.apps.task1.item.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.customerms.dao.ICustomerRepository;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.service.CustomerServiceImpl;
import com.cg.apps.task1.item.dao.*;
import com.cg.apps.task1.item.entites.*;
import com.cg.apps.task1.item.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.item.exceptions.InvalidPriceException;
import com.cg.apps.task1.item.exceptions.ItemNotFoundException;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemRepository itemRepo;
	
	@Autowired
	private ICustomerRepository custRepo;
	
	@Autowired
	private CustomerServiceImpl custService;
	
	public static String generateItemId() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int generatedDigit = random.nextInt(9);
			builder.append(generatedDigit);
		}
		String itemId = builder.toString();
		return "ITEMID-"+itemId;
	}

	@Transactional
	@Override
	public Item create(Double price, String description) {
		/*Item item = new Item(price, description);
		LocalDateTime currentTime = LocalDateTime.now();
		item.setAddedDate(currentTime);
		return itemDao.add(item);*/
		
		Item item = new Item(price, description);
		LocalDateTime currentTime = LocalDateTime.now();
		item.setAddedDate(currentTime);
		String itemID = generateItemId();
		item.setId(itemID);
		return itemRepo.save(item);
	}

	@Override
	public Item findByID(String itemID) {
		// return itemDao.findByID(itemID);
		
		Optional<Item>optional=itemRepo.findById(itemID);
		if(!optional.isPresent()) {
			throw new ItemNotFoundException("Item not found for item"+itemID);
		}
		return optional.get();
	}
	
	
	@Transactional
	@Override
	public Item buyItem(String itemID, long customerID) {
		/*Customer customer = custDao.findByID(customerID);
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
		return item;*/
		
		Customer customer = custService.findByID(customerID);
		Item item = findByID(itemID);
		item.setBoughtBy(customer);
		Set<Item> items=customer.getBroughtItems();
		if(items==null){
			items=new HashSet<>();
			customer.setBroughtItems(items);
		}
		items.add(item);
		customer.setBroughtItems(items);
		itemRepo.save(item);
		custRepo.save(customer);
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
