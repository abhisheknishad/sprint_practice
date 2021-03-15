/*package com.cg.apps.task1.item.dao;

import java.util.Random;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.task1.item.entites.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	
	@Autowired
	private EntityManager entityManager;

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

	@Override
	public Item add(Item item) {
		String id = generateItemId();
		item.setId(id);
		entityManager.persist(item);
		return item;
	}

	@Override
	public Item update(Item item) {
		return entityManager.merge(item);
	}

	@Override
	public Item findByID(String itemID) {
		return entityManager.find(Item.class, itemID);
	}

}*/