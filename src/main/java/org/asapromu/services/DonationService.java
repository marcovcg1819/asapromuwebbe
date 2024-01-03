package org.asapromu.services;

import java.util.List;

import org.asapromu.entities.Donation;
import org.asapromu.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
	@Autowired
	private DonationRepository donationRepository;
	
	public Donation save(Donation don) {
		return donationRepository.save(don);
	}
	
	public Donation getById(Long id) {
		return donationRepository.findById(id).get();
	}
	
	public List<Donation> getByActive(Integer status) {
		return donationRepository.findByActive(status);
	}

}
