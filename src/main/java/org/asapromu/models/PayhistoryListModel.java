package org.asapromu.models;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PayhistoryListModel {
	private String donationname;
	private Double amount;
	private Timestamp datepay;
	private String datea;

}
