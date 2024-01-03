package org.asapromu.controllers;

import java.sql.Timestamp;

import org.asapromu.entities.Donation;
import org.asapromu.entities.Payhistory;
import org.asapromu.models.DonateRequestModel;
import org.asapromu.services.DonationService;
import org.asapromu.services.PayhistoryService;
import org.asapromu.util.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/admin/v1/donate")
public class DonateController {
	@Autowired
	private PayhistoryService payhistoryService;
	@Autowired
	private DonationService donationService;
	@Autowired
	private Payment pay;
	
	@PostMapping
	public ResponseEntity save(@RequestBody DonateRequestModel drm) {
		Payhistory ph = new Payhistory();
		if(pay.pay(drm)) {
			ph.setAmount(drm.getAmount());
			ph.setDatepay(new Timestamp(System.currentTimeMillis()));
			ph.setIdDonation(drm.getIdDonation());
			payhistoryService.save(ph);
			Donation don = donationService.getById(drm.getIdDonation());
			don.setCollected(don.getCollected() + drm.getAmount());
			donationService.save(don);
		}
		
		return new ResponseEntity(ph, HttpStatus.OK);
	}
}
