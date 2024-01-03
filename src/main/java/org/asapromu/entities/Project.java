package org.asapromu.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="project")
@Data
public class Project {
	
	@Id
	@SequenceGenerator(name = "project_id_seq", sequenceName = "project_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
	private Long id;
	private String projectname;
	private String description;
	private Integer active;
	private String site;
	private Timestamp datedo;
	private Timestamp datend;

}
