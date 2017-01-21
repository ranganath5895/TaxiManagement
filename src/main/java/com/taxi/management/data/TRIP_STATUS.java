package com.taxi.management.data;

public enum TRIP_STATUS {

	TRIP_STARTED("started"), 
	TRIP_IN_PROGRESS("In-Progress"), 
	TRIP_CANCELLED("cancelled"), 
	TRIP_COMPLETED("completed");

	private String tripStatus;

	TRIP_STATUS(String status) {
		this.tripStatus = status;
	}

	public String getTripStatus() {
		return tripStatus;
	}

}
