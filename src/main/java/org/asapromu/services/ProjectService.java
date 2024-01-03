package org.asapromu.services;

import java.util.List;

import org.asapromu.entities.Donation;
import org.asapromu.entities.Project;
import org.asapromu.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project save(Project p) {
		return projectRepository.save(p);
	}
	
	public List<Project> getByActiveAndTop(Integer status, Integer top) {
		return projectRepository.findByActiveAndTop(status, top);
	}
	
	public List<Project> getByActive(Integer status) {
		return projectRepository.findByActive(status);
	}
	
	public Project getById(Long id) {
		return projectRepository.findById(id).get();
	}

}
