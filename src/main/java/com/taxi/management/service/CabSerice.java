package com.taxi.management.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.taxi.management.customexceptions.DuplicateRecordException;
import com.taxi.management.data.CabData;
import com.taxi.management.helpers.RequestValidationHelper;
import com.taxi.management.repository.CabDataRepository;

@Service
public class CabSerice {

	@Autowired
	private CabDataRepository cabDataRepository;

	public List<CabData> getAvlCabs() {
		return cabDataRepository.findByAvailabilityStatus(true);
	}
	
	public CabData getCabById(int cabId) {
		return cabDataRepository.findOne(cabId);
	}


	public CabData addNewCab(CabData newCabData) {

		RequestValidationHelper.validateCabOnBoardingRequest(newCabData);
		CabData inhouseCabData = cabDataRepository.findByCabRegnNumber(newCabData.getCabRegnNumber());

		if (inhouseCabData == null) {
			newCabData.setAvailabilityStatus(true);
			CabData newCabObj = cabDataRepository.save(newCabData);
			Logger.getLogger(this.getClass().getName()).info("New Data :: " + newCabObj);
			return newCabObj;
		} else {
			throw new DuplicateRecordException("Cab is already registered. " + inhouseCabData);
		}
	}

	public CabData getCustomerDatWithId(int idOfCab) {
		return cabDataRepository.findOne(idOfCab);
	}

	public CabData blockAcab() {

		List<CabData> avlCabs = getAvlCabs();

		if (avlCabs.isEmpty()) {
			return null;
		} else {
			CabData blockedCab = avlCabs.get(0);
			cabDataRepository.updateAvailabilityStatus(blockedCab.getCabId(), false);
			return blockedCab;
		}
	}

	public void unBlockAcab(CabData cabData) {

		cabDataRepository.updateAvailabilityStatus(cabData.getCabId(), true);

	}

}
