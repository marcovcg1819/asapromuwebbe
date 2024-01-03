package org.asapromu.models;

import java.util.List;

import org.asapromu.entities.Project;
import org.asapromu.entities.Proyectphoto;

import lombok.Data;

@Data
public class ProjectRequestModel {
	
	private Project project;
	private List<Proyectphoto> photos;

}
