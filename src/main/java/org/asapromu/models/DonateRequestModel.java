package org.asapromu.models;

import lombok.Data;

@Data
public class DonateRequestModel {
	private String creditCardNumber;
	private String crediCardName;
	private String creditCardExpiration;
	private String creditCardCCV;
	private Long idDonation;
	private Float amount;

}
