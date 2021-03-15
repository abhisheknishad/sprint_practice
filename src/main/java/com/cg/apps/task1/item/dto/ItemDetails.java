package com.cg.apps.task1.item.dto;

import java.time.LocalDateTime;

public class ItemDetails {
	private String itemId;
	private double price;
	private String itemDescription;
	private LocalDateTime addedDate;
	
	/*public ItemDetails() {}

	public ItemDetails(String itemId, double price, String itemDescription, LocalDateTime addedDate) {
		this.itemId = itemId;
		this.price = price;
		this.itemDescription = itemDescription;
		this.addedDate = addedDate;
	}*/

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

}
