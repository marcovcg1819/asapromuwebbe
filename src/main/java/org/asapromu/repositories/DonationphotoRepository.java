package org.asapromu.repositories;

import java.util.List;

import org.asapromu.entities.Donation;
import org.asapromu.entities.Donationphoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationphotoRepository extends JpaRepository<Donationphoto, Long>{
	
	List<Donationphoto> findByIdDonation(Long id);

}
