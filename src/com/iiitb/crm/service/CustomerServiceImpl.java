package com.iiitb.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.crm.dao.CustomerDAO;
import com.iiitb.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers()
	{
		return customerDAO.getCustomers();
	}
	
	@Transactional
	@Override
	public void addCustomer(Customer customer)
	{
		customerDAO.addCustomer(customer);
	}
	
	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}
	
	@Transactional
	@Override
	public void deleteCustomer(int id)
	{
		customerDAO.deleteCustomer(id);
	}
	
	
	@Transactional
	@Override
	public List<Customer> search(String fname){
		return customerDAO.search(fname);
	}
	
}
