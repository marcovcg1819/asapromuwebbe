package org.asapromu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.asapromu.entities.Project;
import org.asapromu.entities.Proyectphoto;
import org.asapromu.models.ProjectRequestChangeStatusModel;
import org.asapromu.models.ProjectRequestModel;
import org.asapromu.services.ProjectService;
import org.asapromu.services.ProjectphotoService;
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
@RequestMapping("/api/asapromu/admin/v1/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectphotoService projectphotoService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody ProjectRequestModel prm) {
		Project pro = projectService.save(prm.getProject());
		List<Proyectphoto> ppl = new ArrayList<Proyectphoto>();
		Proyectphoto pp = null;
		for(Proyectphoto ppa: prm.getPhotos()) {
			pp = new Proyectphoto();
			pp.setIdProject(pro.getId());
			pp.setPhoto(ppa.getPhoto());
			projectphotoService.save(pp);
		}
		
		return new ResponseEntity(pro, HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping("/{status}")
	public ResponseEntity getAll(@PathVariable(value="status") Integer status) {
		return new ResponseEntity(projectService.getByActive(status), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity changeStatus(@RequestBody ProjectRequestChangeStatusModel drcsm) {
		Project pro = projectService.getById(drcsm.getIdProject());
		pro.setActive(drcsm.getStatus());
		projectService.save(pro);
		return new ResponseEntity(pro, HttpStatus.OK);
	}

}
