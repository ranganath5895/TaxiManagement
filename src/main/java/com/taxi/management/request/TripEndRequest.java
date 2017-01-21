package com.taxi.management.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TripEndRequest {

	private String customerName;

	private long mobileNumber;

	private int tripKms;

	@JsonIgnore
	private int cabId;

	public TripEndRequest() {

	}

	public TripEndRequest(String customerName, long mobileNumber, int tripKms, int cabId) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.tripKms = tripKms;
		this.cabId = cabId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getTripKms() {
		return tripKms;
	}

	public void setTripKms(int tripKms) {
		this.tripKms = tripKms;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	@Override
	public String toString() {
		return "TripEndRequest [customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", tripKms="
				+ tripKms + ", cabId=" + cabId + "]";
	}

}
