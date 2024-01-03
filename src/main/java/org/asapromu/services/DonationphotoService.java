package org.asapromu.services;

import java.util.List;

import org.asapromu.entities.Donationphoto;
import org.asapromu.repositories.DonationphotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationphotoService {

@Autowired
private DonationphotoRepository donationphotoRepository;

	public Donationphoto save(Donationphoto dp) {
		return donationphotoRepository.save(dp);
	}

	public List<Donationphoto> getByIdDonation(Long idDonation) {
		return donationphotoRepository.findByIdDonation(idDonation);
	}
	
}
