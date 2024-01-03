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
@Table(name ="donation")
@Data
public class Donation {
	@Id
	@SequenceGenerator(name = "donation_id_seq", sequenceName = "donation_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donation_id_seq")
	private Long id;
	private String donationname;
	private String description;
	private Float goal;
	private Float collected;
	private Integer active;
	private Timestamp datend;

}
