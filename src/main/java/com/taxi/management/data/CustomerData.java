package com.taxi.management.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "customer_data")
public class CustomerData {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_mobilenumber")
	private long customerMobilenumber;

	public CustomerData() {
	}

	public CustomerData(int customerId, String customerName, long customerMobilenumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobilenumber = customerMobilenumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerMobilenumber() {
		return customerMobilenumber;
	}

	public void setCustomerMobilenumber(long customerMobilenumber) {
		this.customerMobilenumber = customerMobilenumber;
	}

	@Override
	public String toString() {
		return "CustomerData [customerId=" + customerId + ", customerName=" + customerName + ", customerMobilenumber="
				+ customerMobilenumber + "]";
	}

}
