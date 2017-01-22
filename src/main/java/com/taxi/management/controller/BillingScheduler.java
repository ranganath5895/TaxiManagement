package com.taxi.management.controller;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.taxi.management.service.BillingService;

@Component
public class BillingScheduler {

	@Autowired
	private BillingService billingService;
	
	private static final SimpleDateFormat dateFormat = 
	        new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	    @Scheduled(cron = "0 0 0 1 * ?")
	    public void sendBillsToCustomers() {
	    	
	    	Logger.getLogger(getClass().getName()).info("Bills Generation Started ::: "+dateFormat);
	    	billingService.doGenerateBillsForLastMonth();
	    	Logger.getLogger(getClass().getName()).info("Bills Generation Completed ::: "+dateFormat);
	    }
}
