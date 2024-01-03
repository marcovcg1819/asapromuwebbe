package org.asapromu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.asapromu.entities.Project;
import org.asapromu.entities.Proyectphoto;
import org.asapromu.entities.Settings;
import org.asapromu.models.SettingShowProjects;
import org.asapromu.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/admin/v1/settings")
public class SettingsController {
	@Autowired
	private SettingsService settingsService;
	
	@PatchMapping
	@RequestMapping("/showedProjects")
	public ResponseEntity save(@RequestBody SettingShowProjects ssp) {
		Settings s = settingsService.getByNamesetting("MAX_VIEW_PROJECTS");
		s.setValue(ssp.getShowNumber());
		settingsService.save(s);
		
		return new ResponseEntity(s, HttpStatus.OK);
	}
}
