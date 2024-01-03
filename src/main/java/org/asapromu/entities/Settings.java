package org.asapromu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="settings")
@Data
public class Settings {
	@Id
	@SequenceGenerator(name = "settings_id_seq", sequenceName = "settings_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settings_id_seq")
	private Long id;
	private String namesetting;
	private String value;
	
}
