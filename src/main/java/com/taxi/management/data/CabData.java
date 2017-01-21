package com.taxi.management.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "cab_data")
@Table(name= "cab_data")
public class CabData {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "cab_id")
	private int cabId;

	@Column(name = "cab_driver_name")
	private String cabDriverName;

	@Column(name = "cab_regn_number")
	private String cabRegnNumber;

	@Column(name = "availability_status")
	@JsonIgnore
	private boolean availabilityStatus;

	public CabData() {

	}

	public CabData(int cabId, String cabDriverName, String cabRegnNumber, boolean availabilityStatus) {
		super();
		this.cabId = cabId;
		this.cabDriverName = cabDriverName;
		this.cabRegnNumber = cabRegnNumber;
		this.availabilityStatus = availabilityStatus;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCabDriverName() {
		return cabDriverName;
	}

	public void setCabDriverName(String cabDriverName) {
		this.cabDriverName = cabDriverName;
	}

	public String getCabRegnNumber() {
		return cabRegnNumber;
	}

	public void setCabRegnNumber(String cabRegnNumber) {
		this.cabRegnNumber = cabRegnNumber;
	}

	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	@Override
	public String toString() {
		return "CabData [cabId=" + cabId + ", cabDriverName=" + cabDriverName + ", cabRegnNumber=" + cabRegnNumber
				+ ", availabilityStatus=" + availabilityStatus + "]";
	}

}
