package com.cg.apps.task1.customerms.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.customerms.dao.CustomerDaoImpl;
import com.cg.apps.task1.customerms.dao.ICustomerDao;
import com.cg.apps.task1.customerms.entities.*;
import com.cg.apps.task1.customerms.exception.*;
import com.cg.apps.task1.item.entites.Item;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao custDao;
	@Autowired
	private EntityManager entityManager;

	@Override
	public Customer findByID(Long customerID) {
		validateId(customerID);
		Customer customer = custDao.findByID(customerID);
		return customer;
	}

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		validateName(name);
		LocalDateTime time = LocalDateTime.now();
		Account account = new Account(10000.0, time);
		entityManager.persist(account);
		Customer customer = new Customer(name, account);
		custDao.add(customer);
		return customer;
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		validateId(customerId);
		Customer customer = custDao.findByID(customerId);
		Account account = customer.getAccount();
		account.setBalance(account.getBalance() + amount);
		entityManager.persist(account);
		custDao.update(customer);
		return customer;
	}
	
	@Transactional
	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerID) {
		Customer customer = findByID(customerID);
		Set<Item> items=customer.getBroughtItems();
		return items;
	}

	public void validateId(Long id) {
		if (id == null) {
			throw new InvalidIdException("The entered ID " + id + " is invalid");
		}
	}
		public void validateAmount(double amount) {
			if (amount < 0) {
				throw new InvalidAmountException("The entered amount " + amount + " is invalid");
			}
		}

		public void validateName(String name) {
			if (name == null || name.isEmpty() || name.trim().isEmpty()) {
				throw new InvalidNameException("Name cannot be null");
			}
		}



	}
