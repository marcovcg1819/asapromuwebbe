package org.asapromu.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="proyectphoto")
@Data
public class Proyectphoto {
	@Id
	@SequenceGenerator(name = "projectphoto_id_seq", sequenceName = "projectphoto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectphoto_id_seq")
	private Long id;
	private Long idProject;
	@Column(name = "photo")
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;
}
