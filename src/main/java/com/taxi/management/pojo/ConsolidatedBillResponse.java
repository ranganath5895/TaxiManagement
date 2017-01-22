package com.taxi.management.pojo;

import java.util.List;

import com.taxi.management.data.CustomerData;

public class ConsolidatedBillResponse {

	private CustomerData customerInfo;
	private int totalKms;
	private int totalFare;
	private List<TripItemisedResponse> trips;

	public ConsolidatedBillResponse() {

	}

	public ConsolidatedBillResponse(CustomerData customerInfo, int totalKms, int totalFare,
			List<TripItemisedResponse> trips) {
		super();
		this.customerInfo = customerInfo;
		this.totalKms = totalKms;
		this.totalFare = totalFare;
		this.trips = trips;
	}

	public CustomerData getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerData customerInfo) {
		this.customerInfo = customerInfo;
	}

	public int getTotalKms() {
		return totalKms;
	}

	public void setTotalKms(int totalKms) {
		this.totalKms = totalKms;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public List<TripItemisedResponse> getTrips() {
		return trips;
	}

	public void setTrips(List<TripItemisedResponse> trips) {
		this.trips = trips;
	}

	@Override
	public String toString() {
		return "ConsolidatedBillResponse [customerInfo=" + customerInfo + ", totalKms=" + totalKms + ", totalFare="
				+ totalFare + ", trips=" + trips + "]";
	}

}
