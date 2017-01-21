package com.taxi.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.management.data.CustomerData;
import com.taxi.management.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/get")
	public CustomerData getCustomerDataWithMobileNumber(@RequestParam(value = "mobilenumber",defaultValue = "" ) long  mobilenumber){
	
		return customerService.getCustomerDataWithMobileNumber(mobilenumber);
	}
	
	@RequestMapping("/getallcustomers")
	public List<CustomerData> getAllCustomerData(){
	
		return customerService.getAllCustomers();
	}
	
	@PostMapping("/addnew")
	public CustomerData addNewCustomer(@RequestBody CustomerData customerData){
		
		return customerService.addNewCustomer(customerData);
	}
}
