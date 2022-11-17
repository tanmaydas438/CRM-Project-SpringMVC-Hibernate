package com.iiitb.crm.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model)
	{
		Customer c=new Customer();
		model.addAttribute("customer",c);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer)
	{
		//System.out.println("Hello");
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model model)
	{
		//int id=1;
		Customer c=customerService.getCustomerById(id);
		model.addAttribute("customer",c);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id)
	{
		//System.out.println("Hello");
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@GetMapping("search")
	public String search(@RequestParam("theSearchName") String fname,
            Model model)
	{
		List<Customer> customers=customerService.search(fname);
		model.addAttribute("customers", customers);
		return "list-customers";
	}
}
