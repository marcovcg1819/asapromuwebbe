package org.asapromu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.asapromu.entities.Donation;
import org.asapromu.entities.Donationphoto;
import org.asapromu.models.DonationRequestModel;
import org.asapromu.services.DonationService;
import org.asapromu.services.DonationphotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/web/v1/donation")
public class DonationWebController {
	@Autowired
	private DonationService donationService;
	@Autowired
	private DonationphotoService donationphotoService;
	
	@GetMapping
	public ResponseEntity getAll() {
		DonationRequestModel drm = new DonationRequestModel();
		List<DonationRequestModel> drmList = new ArrayList<DonationRequestModel>();
		List<Donationphoto> photoList = new ArrayList<Donationphoto>();
		List<Donation> donList = donationService.getByActive(1);
		for(Donation dn:donList) {
			drm = new DonationRequestModel();
			photoList = new ArrayList<Donationphoto>();
			drm.setDonation(dn);
			photoList = donationphotoService.getByIdDonation(dn.getId());
			drm.setPhotos(photoList);
			drmList.add(drm);
		}
		
		
		return new ResponseEntity(drmList, HttpStatus.OK);
	}
}
