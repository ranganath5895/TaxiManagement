package com.taxi.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.management.data.TripsData;
import com.taxi.management.helpers.RequestValidationHelper;
import com.taxi.management.request.TripEndRequest;
import com.taxi.management.request.TripEndResponse;
import com.taxi.management.request.TripStartRequest;
import com.taxi.management.service.TripManagementService;
import com.taxi.management.service.TripsDataService;

@RestController
@RequestMapping("/trip/manage")
public class TripManagementController {

	@Autowired
	private TripManagementService tripManagementService;
	
	@Autowired
	private TripsDataService tripsDataService;
	
	@PostMapping("/start")
	public TripsData doStartTrip(@RequestBody TripStartRequest tripStartRequest){
		
		RequestValidationHelper.validateTripStartRequest(tripStartRequest);

		TripsData tripsData = tripManagementService.doTripStart(tripStartRequest);
			
		return tripsData;
		
	}
	
	@PostMapping("/complete")
	public TripEndResponse doCompleteTrip(@RequestBody TripEndRequest tripEndRequest){
		
		RequestValidationHelper.validateTripEndRequest(tripEndRequest);
		
		TripsData onGoingTripData = tripsDataService.getOnGoingTripDataByCustomerMobileNumber(tripEndRequest.getMobileNumber());
		
		if(onGoingTripData == null){
			throw new IllegalArgumentException("No On-Going trips to complete");
		}
		
		TripEndResponse tripsData = tripManagementService.doTripEnd(tripEndRequest,onGoingTripData);
		
		return tripsData;
	}
	
	@PostMapping("/cancel")
	public TripsData doCanCelTrip(@RequestBody TripStartRequest tripStartRequest){
		
		RequestValidationHelper.validateTripStartRequest(tripStartRequest);
		
		TripsData onGoingTripData = tripsDataService.getOnGoingTripDataByCustomerMobileNumber(tripStartRequest.getMobileNumber());
		
		if(onGoingTripData == null){
			throw new IllegalArgumentException("No On-Going trips to Cancel");
		}
		
		TripsData tripsData = tripManagementService.doTripCancel(onGoingTripData);
		
		return tripsData;
	}
}
