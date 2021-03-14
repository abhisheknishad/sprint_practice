package com.cg.apps.task1.customerms.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cg.apps.task1.customerms.entities.Account;
import com.cg.apps.task1.item.entites.Item;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToOne
	private Account account;

	@OneToMany(fetch=FetchType.EAGER)
	Set<Item> broughtItems;

	public Customer() {

	}

	public Customer(String name, Account account) {
		setName(name);
		setAccount(account);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Item> getBroughtItems() {
		return broughtItems;
	}

	public void setBroughtItems(Set<Item> broughtItems) {
		this.broughtItems = broughtItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}