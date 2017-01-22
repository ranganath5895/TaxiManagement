package com.taxi.management.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TripStartRequest {

	private String customerName;
	private long mobileNumber;

	@JsonIgnore
	private int cabId;

	public TripStartRequest() {

	}

	public TripStartRequest(String customerName, long mobileNumber, int cabId) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
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

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	@Override
	public String toString() {
		return "TripEndRequest [customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", cabId=" + cabId
				+ "]";
	}

}
