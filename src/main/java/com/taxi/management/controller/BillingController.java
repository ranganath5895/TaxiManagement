package com.taxi.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.management.pojo.ConsolidatedBillResponse;
import com.taxi.management.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/generate")
	public List<ConsolidatedBillResponse> doGenerateBills(){
		
		return billingService.doGenerateBillsForLastMonth();
	}
}
