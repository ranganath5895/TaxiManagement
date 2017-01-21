package com.taxi.management.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.management.data.CabData;
import com.taxi.management.service.CabSerice;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	private CabSerice cabSerice;

	@RequestMapping("/getavailablecabs")
	public List<CabData> getAvaialableCabs() {
		Logger.getLogger(this.getClass().getName()).info("Get All Avl Cabs");
		return cabSerice.getAvlCabs();
	}

	@PostMapping("/addnewcab")
	public CabData addNewCab(@RequestBody CabData cabData) {
		Logger.getLogger(this.getClass().getName()).info("Addding New Cab");
		return cabSerice.addNewCab(cabData);
	}
}
