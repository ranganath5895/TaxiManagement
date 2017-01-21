package com.taxi.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.management.customexceptions.DuplicateRecordException;
import com.taxi.management.data.CustomerData;
import com.taxi.management.repository.CustomerDataRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerDataRepository customerDataRepository;

	public List<CustomerData> getAllCustomers() {
		return customerDataRepository.findAll();
	}

	public CustomerData getCustomerDataWithId(int idCustomer) {

		return customerDataRepository.findOne(idCustomer);
	}
	
	public CustomerData getCustomerDataWithMobileNumber(long mobileNumber) {

		return customerDataRepository.findByCustomerMobilenumber(mobileNumber);
	}

	public CustomerData addNewCustomer(CustomerData customerData) {

		CustomerData inHouseData = customerDataRepository
				.findByCustomerMobilenumber(customerData.getCustomerMobilenumber());

		if (inHouseData == null) {

			if (customerData.getCustomerMobilenumber() < 999999999) {
				throw new IllegalArgumentException("Mobile Number should be 10 digits lenth and should not be Zeros");
			}

			CustomerData cData = customerDataRepository.save(customerData);
			return cData;
		} else {
			throw new DuplicateRecordException("with the Mobile Number already registered : " + inHouseData);
		}

	}

	public CustomerData checkAndAddCustomerifNeeded(CustomerData customerData) {

		CustomerData inHouseData = getCustomerDataWithMobileNumber(customerData.getCustomerMobilenumber());

		if (inHouseData == null) {

			CustomerData cData = addNewCustomer(customerData);

			return cData;
		} else {
			return inHouseData;
		}
	}

}
