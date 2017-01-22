package com.taxi.management.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.management.data.CustomerData;
import com.taxi.management.data.TRIP_STATUS;
import com.taxi.management.data.TripsData;
import com.taxi.management.pojo.TripEndResponse;
import com.taxi.management.repository.TripsDataRepository;

@Service
public class TripsDataService {

	@Autowired
	private TripsDataRepository tripsDataRepository;

	@Autowired
	private CustomerService customerService;

	public List<TripsData> getTripsDataByCustomerId(int customerId) {
		return tripsDataRepository.findByCustomerId(customerId);
	}

	public List<TripsData> getTripsDataByCabId(int cabId) {
		return tripsDataRepository.findByCabId(cabId);
	}

	public List<TripsData> getTripsDataByTripDate(Timestamp tripDate) {
		return tripsDataRepository.findByTripDate(tripDate);
	}

	public List<TripsData> getTripsDataBetweenDates(Timestamp tripStartDate, Timestamp tripEndDate) {
		return tripsDataRepository.findByTripDateBetween(tripStartDate, tripEndDate);
	}

	public TripsData getOnGoingTripDataByCustomerMobileNumber(long mobileNumber) {

		CustomerData customerData = customerService.getCustomerDataWithMobileNumber(mobileNumber);

		if (customerData == null) {
			throw new IllegalArgumentException("No User registered (or) No On-Going trip");
		}

		return tripsDataRepository.findByCustomerIdAndTripStatus(customerData.getCustomerId(),
				TRIP_STATUS.TRIP_STARTED.getTripStatus());
	}

	public List<TripEndResponse> getTripInfoByCustomerId(int customerId) {
		List<TripsData> tripsData = tripsDataRepository.findByCustomerId(customerId);
		List<TripEndResponse> tripDetails = new ArrayList<TripEndResponse>();

		for (TripsData each : tripsData) {
			tripDetails.add(convertTripsDataToTripEndResponse(each));
		}

		return tripDetails;
	}

	public List<TripEndResponse> getTripInfoByCustomerMobileNumber(long customerMobileNumber) {

		CustomerData customerData = customerService.getCustomerDataWithMobileNumber(customerMobileNumber);

		if (customerData == null) {
			throw new IllegalArgumentException("No User registered with mobilenumber :: " + customerMobileNumber);
		}

		List<TripsData> tripsData = tripsDataRepository.findByCustomerId(customerData.getCustomerId());
		List<TripEndResponse> tripDetails = new ArrayList<TripEndResponse>();

		for (TripsData each : tripsData) {
			tripDetails.add(convertTripsDataToTripEndResponse(each));
		}

		return tripDetails;
	}

	public List<TripEndResponse> getAllTrips() {
		List<TripsData> tripsData = tripsDataRepository.findAll();
		List<TripEndResponse> tripDetails = new ArrayList<TripEndResponse>();

		for (TripsData each : tripsData) {
			tripDetails.add(convertTripsDataToTripEndResponse(each));
		}

		return tripDetails;
	}

	private TripEndResponse convertTripsDataToTripEndResponse(TripsData tripData) {

		TripEndResponse tripEndResponse = new TripEndResponse();

		CustomerData customerData = customerService.getCustomerDataWithId(tripData.getCustomerId());

		tripEndResponse.setCustomerName(customerData.getCustomerName());
		tripEndResponse.setMobileNumber(customerData.getCustomerMobilenumber());
		tripEndResponse.setTripFare(tripData.getTotalFare());
		tripEndResponse.setTripId(tripData.getTripId());
		tripEndResponse.setTripKms(tripData.getTripKms());
		tripEndResponse.setTravelDate(tripData.getTripDate());
		tripEndResponse.setTripStatus(tripData.getTripStatus());

		return tripEndResponse;
	}

}
