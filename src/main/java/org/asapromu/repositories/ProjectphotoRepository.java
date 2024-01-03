package org.asapromu.repositories;

import java.util.List;

import org.asapromu.entities.Donationphoto;
import org.asapromu.entities.Proyectphoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectphotoRepository extends JpaRepository<Proyectphoto, Long>{
	List<Proyectphoto> findByIdProject(Long id);
	
}
