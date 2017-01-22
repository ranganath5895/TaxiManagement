package com.taxi.management.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "bills_data")
public class BillingData {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "bills_data_id")
	private int billsDataId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "total_kms")
	private int totalKms;

	@Column(name = "totalFare")
	private int totaFare;

	@Column(name = "bill_genrated_date")
	private Date billGenratedDate;

	public BillingData() {

	}

	public BillingData(int billsDataId, int customerId, int totalKms, int totaFare, Date billGenratedDate) {
		super();
		this.billsDataId = billsDataId;
		this.customerId = customerId;
		this.totalKms = totalKms;
		this.totaFare = totaFare;
		this.billGenratedDate = billGenratedDate;
	}

	public int getBillsDataId() {
		return billsDataId;
	}

	public void setBillsDataId(int billsDataId) {
		this.billsDataId = billsDataId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTotalKms() {
		return totalKms;
	}

	public void setTotalKms(int totalKms) {
		this.totalKms = totalKms;
	}

	public int getTotaFare() {
		return totaFare;
	}

	public void setTotaFare(int totaFare) {
		this.totaFare = totaFare;
	}

	public Date getBillGenratedDate() {
		return billGenratedDate;
	}

	public void setBillGenratedDate(Date billGenratedDate) {
		this.billGenratedDate = billGenratedDate;
	}

	@Override
	public String toString() {
		return "BillingData [billsDataId=" + billsDataId + ", customerId=" + customerId + ", totalKms=" + totalKms
				+ ", totaFare=" + totaFare + ", billGenratedDate=" + billGenratedDate + "]";
	}

}
