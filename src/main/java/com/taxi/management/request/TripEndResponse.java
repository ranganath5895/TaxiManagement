package com.taxi.management.request;

import java.sql.Timestamp;

public class TripEndResponse {

	private int tripId;
	private long mobileNumber;
	private String customerName;
	private int tripKms;
	private int tripFare;
	private Timestamp travelDate;
	private String tripStatus;

	public TripEndResponse() {

	}

	public TripEndResponse(int tripId, long mobileNumber, String customerName, int tripKms, int tripFare,
			Timestamp travelDate, String tripStatus) {
		super();
		this.tripId = tripId;
		this.mobileNumber = mobileNumber;
		this.customerName = customerName;
		this.tripKms = tripKms;
		this.tripFare = tripFare;
		this.travelDate = travelDate;
		this.tripStatus = tripStatus;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTripKms() {
		return tripKms;
	}

	public void setTripKms(int tripKms) {
		this.tripKms = tripKms;
	}

	public int getTripFare() {
		return tripFare;
	}

	public void setTripFare(int tripFare) {
		this.tripFare = tripFare;
	}

	public Timestamp getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Timestamp travelDate) {
		this.travelDate = travelDate;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "TripEndResponse [tripId=" + tripId + ", mobileNumber=" + mobileNumber + ", customerName=" + customerName
				+ ", tripKms=" + tripKms + ", tripFare=" + tripFare + ", travelDate=" + travelDate + ", tripStatus="
				+ tripStatus + "]";
	}

}
