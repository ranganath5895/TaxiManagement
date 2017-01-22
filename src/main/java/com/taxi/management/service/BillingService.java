package com.taxi.management.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.management.data.BillingData;
import com.taxi.management.data.CustomerData;
import com.taxi.management.data.TRIP_STATUS;
import com.taxi.management.data.TripsData;
import com.taxi.management.pojo.ConsolidatedBillResponse;
import com.taxi.management.pojo.TripItemisedResponse;
import com.taxi.management.repository.BillingDataRepository;

@Service
public class BillingService {

	@Autowired
	private TripsDataService tripsDataService;
	
	@Autowired
	private BillingDataRepository billingDataRepository;
	
	@Autowired
	private CustomerService customerService;

	@Transactional
	public List<ConsolidatedBillResponse> doGenerateBillsForLastMonth() {

		Timestamp today = new Timestamp(new Date().getTime());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date lastMonth = cal.getTime();
		Timestamp lastMonthDay = new Timestamp(lastMonth.getTime());
		
		
		java.sql.Date sqlBillDate = new java.sql.Date(new Date().getTime());

		List<TripsData> pendingBillsInLastMonth = tripsDataService.getTripsDataBetweenDates(lastMonthDay, today);

		Set<Integer> uniqueCustomerIds = new HashSet<Integer>();

		for (TripsData eachTripData : pendingBillsInLastMonth) {
			uniqueCustomerIds.add(eachTripData.getCustomerId());
		}

		List<ConsolidatedBillResponse> bills = new ArrayList<ConsolidatedBillResponse>();
		
		for (Integer eachCustomerId : uniqueCustomerIds) {

			BillingData billingData = new BillingData();
			billingData.setCustomerId(eachCustomerId);
			billingData.setBillGenratedDate(sqlBillDate);
			
			int totalKms = 0,totalCharges = 0;
			
			List<TripsData> tripsForCustomer = new ArrayList<TripsData>();
			
			for (TripsData eachTripData : pendingBillsInLastMonth) {
				
				if( (eachTripData.getCustomerId() == eachCustomerId) && (eachTripData.getTripStatus().equalsIgnoreCase(TRIP_STATUS.TRIP_COMPLETED.getTripStatus()))){
					totalKms = totalKms + eachTripData.getTripKms();
					totalCharges = totalCharges + eachTripData.getTripId();
					tripsForCustomer.add(eachTripData);
				}
			}
			billingData.setTotaFare(totalCharges);
			billingData.setTotalKms(totalKms);
			
			BillingData submittedBill = billingDataRepository.save(billingData);
			
			ConsolidatedBillResponse consolidatedBillResponse = convertConsolidatedBillResponse(eachCustomerId, tripsForCustomer);
			
			bills.add(consolidatedBillResponse);
			
			Logger.getLogger(getClass().getName()).info("Notfied the customer with the Total Bill "+submittedBill);
		}
		
		return bills;
	}
	
	private ConsolidatedBillResponse convertConsolidatedBillResponse(int customerId , List<TripsData> tripsData){
		
		ConsolidatedBillResponse consolidatedBillResponse = new ConsolidatedBillResponse();
		
		int totalKms = 0 , totalFare = 0;
		
		List<TripItemisedResponse> trips = new ArrayList<TripItemisedResponse>();
		
		CustomerData customerData = customerService.getCustomerDataWithId(customerId);
		consolidatedBillResponse.setCustomerInfo(customerData);
		
		for(TripsData eachTrip : tripsData){
			
			totalKms = totalKms + eachTrip.getTripKms();
			totalFare = totalFare + eachTrip.getTotalFare();
			
			TripItemisedResponse tripItemisedResponse = new TripItemisedResponse
					(eachTrip.getTripId(), 
					 eachTrip.getTripKms(), 
					 eachTrip.getTotalFare(), 
					 eachTrip.getTripDate(), 
					 eachTrip.getTripStatus());
			trips.add(tripItemisedResponse);
		}
		
		consolidatedBillResponse.setTotalFare(totalFare);
		consolidatedBillResponse.setTotalKms(totalKms);
		consolidatedBillResponse.setTrips(trips);
		
		return consolidatedBillResponse;
		
	}
}
