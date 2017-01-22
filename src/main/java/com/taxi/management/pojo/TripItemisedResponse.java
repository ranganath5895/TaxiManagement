package com.taxi.management.pojo;

import java.sql.Timestamp;

public class TripItemisedResponse {

	private int tripId;
	private int tripKms;
	private int tripFare;
	private Timestamp travelDate;
	private String tripStatus;

	public TripItemisedResponse() {

	}

	public TripItemisedResponse(int tripId, int tripKms, int tripFare, Timestamp travelDate, String tripStatus) {
		super();
		this.tripId = tripId;
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
		return "TripEndResponse [tripId=" + tripId 
				+ ", tripKms=" + tripKms + ", tripFare=" + tripFare + ", travelDate=" + travelDate + ", tripStatus="
				+ tripStatus + "]";
	}

}
