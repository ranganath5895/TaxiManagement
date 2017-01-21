package com.taxi.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.management.data.CustomerData;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, Integer> {

	public List<CustomerData> findByCustomerName(String customerName);

	public CustomerData findByCustomerMobilenumber(long customerMobilenumber);
}
