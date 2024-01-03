package org.asapromu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.asapromu.entities.Project;
import org.asapromu.entities.Proyectphoto;
import org.asapromu.entities.Settings;
import org.asapromu.models.ProjectRequestModel;
import org.asapromu.services.ProjectService;
import org.asapromu.services.ProjectphotoService;
import org.asapromu.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/web/v1/project")
public class ProjectWebController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectphotoService projectphotoService;
	@Autowired
	private SettingsService settingsService;
	

	@GetMapping
	public ResponseEntity getAll() {
		ProjectRequestModel prm = new ProjectRequestModel();
		List<ProjectRequestModel> prmList = new ArrayList<ProjectRequestModel>();
		List<Proyectphoto> photoList = new ArrayList<Proyectphoto>();
		Settings s = settingsService.getByNamesetting("MAX_VIEW_PROJECTS");
		
		List<Project> proList = projectService.getByActiveAndTop(1, Integer.valueOf(s.getValue()));
		for(Project pr:proList) {
			prm = new ProjectRequestModel();
			photoList = new ArrayList<Proyectphoto>();
			prm.setProject(pr);
			photoList = projectphotoService.getByIdProject(pr.getId());
			prm.setPhotos(photoList);
			prmList.add(prm);
		}
		
		
		return new ResponseEntity(prmList, HttpStatus.OK);
	}
}
