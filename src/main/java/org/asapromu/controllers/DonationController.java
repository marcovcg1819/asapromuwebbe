package org.asapromu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.asapromu.entities.Donation;
import org.asapromu.entities.Donationphoto;
import org.asapromu.models.DonationRequestChangeStatusModel;
import org.asapromu.models.DonationRequestModel;
import org.asapromu.services.DonationService;
import org.asapromu.services.DonationphotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/admin/v1/donation")
public class DonationController {
	@Autowired
	private DonationService donationService;
	@Autowired
	private DonationphotoService donationphotoService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody DonationRequestModel drm) {
		Donation don = donationService.save(drm.getDonation());
		List<Donationphoto> dpl = new ArrayList<Donationphoto>();
		Donationphoto dp = null;
		for(Donationphoto dpa: drm.getPhotos()) {
			dp = new Donationphoto();
			dp.setIdDonation(don.getId());
			dp.setPhoto(dpa.getPhoto());
			donationphotoService.save(dp);
		}
		
		return new ResponseEntity(don, HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping("/{status}")
	public ResponseEntity getAll(@PathVariable(value="status") Integer status) {
		return new ResponseEntity(donationService.getByActive(status), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity changeStatus(@RequestBody DonationRequestChangeStatusModel drcsm) {
		Donation don = donationService.getById(drcsm.getIdDonation());
		don.setActive(drcsm.getStatus());
		donationService.save(don);
		return new ResponseEntity(don, HttpStatus.OK);
	}

}
