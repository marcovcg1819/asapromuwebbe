package org.asapromu.services;

import java.util.List;

import org.asapromu.entities.Donationphoto;
import org.asapromu.entities.Proyectphoto;
import org.asapromu.repositories.ProjectphotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectphotoService {
	@Autowired
	private ProjectphotoRepository projectphotoRepository;
	
	public Proyectphoto save(Proyectphoto pp) {
		return projectphotoRepository.save(pp);
	}
	
	public List<Proyectphoto> getByIdProject(Long idProject) {
		return projectphotoRepository.findByIdProject(idProject);
	}
	

}
