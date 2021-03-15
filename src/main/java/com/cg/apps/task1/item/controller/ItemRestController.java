package com.cg.apps.task1.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.task1.item.dto.CustomerBuyItem;
import com.cg.apps.task1.item.dto.ItemDetails;
import com.cg.apps.task1.item.entites.Item;
import com.cg.apps.task1.item.service.IItemService;
import com.cg.apps.task1.item.util.ItemUtil;

@RequestMapping("/items")
@RestController
public class ItemRestController {
	@Autowired
	private IItemService itemService;
	
	@Autowired
	private ItemUtil itemUtil;

	
	@GetMapping("/findById/{itemId}")
	public ItemDetails findById(@PathVariable String itemId) {
		Item item = itemService.findByID(itemId);
		ItemDetails details = itemUtil.toDetails(item);
		return details;
	}
	
	@PutMapping("/buyItem")
	public ItemDetails buyItem(@RequestBody CustomerBuyItem requestData) {
		Item item =itemService.buyItem(requestData.getItemId(),requestData.getCustId());
		return itemUtil.toDetails(item);
	}
	
	
}
