package com.iiitb.crm.service;

import java.util.List;

import com.iiitb.crm.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);
	public List<Customer> search(String fname);
}

