package com.taxi.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.management.request.TripEndResponse;
import com.taxi.management.service.TripsDataService;

@RestController
@RequestMapping("/trip")
public class TripsDataController {

	@Autowired
	private TripsDataService tripsDataService;

	@RequestMapping("/getall")
	public List<TripEndResponse> getAllTrips() {

		return tripsDataService.getAllTrips();
	}

	@RequestMapping("/get")
	public List<TripEndResponse> getAllTripsWithCustomerId(
			@RequestParam(value = "customerid", defaultValue = "1") int customerid) {

		return tripsDataService.getTripInfoByCustomerId(customerid);
	}

	@RequestMapping("/get/details")
	public List<TripEndResponse> getAllTripsWithCustomerMobileNumber(
			@RequestParam(value = "customermobilenumber", defaultValue = "9123456789") int customermobilenumber) {

		return tripsDataService.getTripInfoByCustomerMobileNumber(customermobilenumber);
	}

}
