package org.asapromu.models;

import lombok.Data;

@Data
public class DonationRequestChangeStatusModel {
	private Long idDonation;
	private Integer status;

}
