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
@Table(name ="payhistory")
@Data
public class Payhistory {
	@Id
	@SequenceGenerator(name = "payhistory_id_seq", sequenceName = "payhistory_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payhistory_id_seq")
	private Long id;
	private Long idDonation;
	private Float amount;
	private Timestamp datepay;
	

}
