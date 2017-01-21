package com.taxi.management.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "trips_data")
@Table(name = "trips_data")
public class TripsData {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "trip_id")
	private int tripId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "cab_id")
	private int cabId;

	@Column(name = "trip_kms")
	private int tripKms;

	@Column(name = "total_fare")
	private int totalFare;

	@Column(name = "trip_date")
	private Timestamp tripDate;

	@Column(name = "trip_status")
	private String tripStatus;

	public TripsData() {
	}

	public TripsData(int tripId, int customerId, int cabId, int tripKms, int totalFare, Timestamp tripDate,
			String tripStatus) {
		super();
		this.tripId = tripId;
		this.customerId = customerId;
		this.cabId = cabId;
		this.tripKms = tripKms;
		this.totalFare = totalFare;
		this.tripDate = tripDate;
		this.tripStatus = tripStatus;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public int getTripKms() {
		return tripKms;
	}

	public void setTripKms(int tripKms) {
		this.tripKms = tripKms;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public Timestamp getTripDate() {
		return tripDate;
	}

	public void setTripDate(Timestamp tripDate) {
		this.tripDate = tripDate;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "TripsData [tripId=" + tripId + ", customerId=" + customerId + ", cabId=" + cabId + ", tripKms="
				+ tripKms + ", totalFare=" + totalFare + ", tripDate=" + tripDate + ", tripStatus=" + tripStatus + "]";
	}

}
