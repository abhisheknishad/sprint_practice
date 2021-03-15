package com.cg.apps.task1.customerms.dto;

import com.cg.apps.task1.customerms.entities.Account;

public class CustomerDetails {

	private long id;
	private String name;
	private long accountId;
	private double balance;

	public CustomerDetails() {
	}

	public CustomerDetails(long id, String name, long accountId, double balance) {
		this.id = id;
		this.name = name;
		this.accountId = accountId;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
