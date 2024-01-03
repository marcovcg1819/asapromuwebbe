package org.asapromu.models;

import java.util.List;

import org.asapromu.entities.Donation;
import org.asapromu.entities.Donationphoto;

import lombok.Data;

@Data
public class DonationRequestModel {
	
	private Donation donation;
	private List<Donationphoto> photos;

}
