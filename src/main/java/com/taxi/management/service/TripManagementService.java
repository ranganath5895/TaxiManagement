package com.taxi.management.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.management.customexceptions.DuplicateRecordException;
import com.taxi.management.data.CabData;
import com.taxi.management.data.CustomerData;
import com.taxi.management.data.TRIP_STATUS;
import com.taxi.management.data.TripsData;
import com.taxi.management.helpers.TripChargeCalc;
import com.taxi.management.pojo.TripEndRequest;
import com.taxi.management.pojo.TripEndResponse;
import com.taxi.management.pojo.TripStartRequest;
import com.taxi.management.repository.TripsDataRepository;

@Service
public class TripManagementService {

	@Autowired
	private TripsDataRepository tripsDataRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CabSerice cabService;

	@Autowired
	private TripsDataService tripsDataService;

	@Transactional
	public TripsData doTripStart(TripStartRequest tripStartRequest) {

		CabData cabData = cabService.blockAcab();
		CustomerData tempCustomerData = new CustomerData();
		tempCustomerData.setCustomerMobilenumber(tripStartRequest.getMobileNumber());
		tempCustomerData.setCustomerName(tripStartRequest.getCustomerName());

		CustomerData customerData = customerService.checkAndAddCustomerifNeeded(tempCustomerData);

		TripsData OnGoingTripData = tripsDataService
				.getOnGoingTripDataByCustomerMobileNumber(tripStartRequest.getMobileNumber());

		if (OnGoingTripData != null) {
			throw new DuplicateRecordException(" Customer already started a Trip " + OnGoingTripData);
		}

		TripsData tripData = new TripsData();
		tripData.setCabId(cabData.getCabId());
		tripData.setCustomerId(customerData.getCustomerId());
		tripData.setTripDate(new Timestamp(new Date().getTime()));
		tripData.setTripStatus(TRIP_STATUS.TRIP_STARTED.getTripStatus());

		TripsData submittedTrip = tripsDataRepository.save(tripData);

		return submittedTrip;

	}

	@Transactional
	public TripsData doTripCancel(TripsData tripData) {

		doUnBlockCab(tripData);
		
		tripsDataRepository.updateTripStatus(tripData.getTripId(), TRIP_STATUS.TRIP_CANCELLED.getTripStatus());

		return tripsDataRepository.findOne(tripData.getTripId());
	}

	@Transactional
	public TripEndResponse doTripEnd(TripEndRequest tripEndRequest, TripsData tripData) {

		TripEndResponse tripEndResponse = new TripEndResponse();

		int tripTotalFare = TripChargeCalc.tripFareCaluculation(tripEndRequest.getTripKms());

		CustomerData incomingCustomerInfo = new CustomerData();
		incomingCustomerInfo.setCustomerMobilenumber(tripEndRequest.getMobileNumber());
		incomingCustomerInfo.setCustomerName(tripEndRequest.getCustomerName());

		tripsDataRepository.updateCompletedTripInfo(tripData.getTripId(), tripEndRequest.getTripKms(), tripTotalFare,
				TRIP_STATUS.TRIP_COMPLETED.getTripStatus());

		doUnBlockCab(tripData);

		tripEndResponse.setTripId(tripData.getTripId());
		tripEndResponse.setCustomerName(incomingCustomerInfo.getCustomerName());
		tripEndResponse.setMobileNumber(incomingCustomerInfo.getCustomerMobilenumber());
		tripEndResponse.setTripFare(tripTotalFare);
		tripEndResponse.setTripKms(tripEndRequest.getTripKms());
		tripEndResponse.setTravelDate(tripData.getTripDate());
		tripEndResponse.setTripStatus(TRIP_STATUS.TRIP_COMPLETED.getTripStatus());

		return tripEndResponse;

	}

	private void doUnBlockCab(TripsData tripData) {

		CabData blockedCabData = cabService.getCabById(tripData.getCabId());

		cabService.unBlockAcab(blockedCabData);
	}
}
