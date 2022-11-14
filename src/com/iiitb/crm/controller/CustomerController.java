package com.iiitb.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iiitb.crm.dao.CustomerDAO;
import com.iiitb.crm.entity.Customer;
import com.iiitb.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model)
	{
		List<Customer> customers=customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
}
