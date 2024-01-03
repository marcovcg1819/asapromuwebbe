package org.asapromu.repositories;

import java.util.List;

import org.asapromu.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long>{

	List<Donation> findByActive(Integer status);
}
