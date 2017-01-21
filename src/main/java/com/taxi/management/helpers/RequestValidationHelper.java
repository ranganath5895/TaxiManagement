package com.taxi.management.helpers;

import com.taxi.management.data.CabData;
import com.taxi.management.request.TripEndRequest;
import com.taxi.management.request.TripStartRequest;

public class RequestValidationHelper {

	public static void validateCabOnBoardingRequest(CabData cabData){
		
		if( (cabData.getCabDriverName() == null) || (cabData.getCabRegnNumber()==null)){
			throw new IllegalArgumentException("The 'cabDriverName' and 'cabRegnNumber' parameters must not be null or empty");
		}
	}
	
	public static void validateTripEndRequest(TripEndRequest tripEndRequest){
		
		if( (tripEndRequest.getTripKms() <= 0) ){
			throw new IllegalArgumentException("The 'tripKms' parameter must not be null or empty");
		}
	}
	
	public static void validateTripStartRequest(TripStartRequest tripStartRequest){
		
		if( (tripStartRequest.getCustomerName() == null) || (tripStartRequest.getMobileNumber() < 999999999 )){
			throw new IllegalArgumentException("The 'customerName' , 'mobileNumber' parameters must not be null or empty");
		}
	}
}
