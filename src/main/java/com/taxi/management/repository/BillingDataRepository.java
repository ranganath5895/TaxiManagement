package com.taxi.management.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.management.data.BillingData;

@Repository
public interface BillingDataRepository extends JpaRepository<BillingData, Integer>{

	public List<BillingData> findByCustomerId(int customerId);
	public List<BillingData> findByBillGenratedDate(Date billGenratedDate);
}
