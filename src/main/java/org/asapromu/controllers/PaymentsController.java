package org.asapromu.controllers;

import java.sql.Timestamp;

import org.asapromu.models.PayHistoryModel;
import org.asapromu.services.PayhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/admin/v1/payments")
public class PaymentsController {
	
	@Autowired
	private PayhistoryService payhistoryService;
	
	@PostMapping
	public ResponseEntity getBeetwenTwoDate(@RequestBody PayHistoryModel phm) {
		
		
		return new ResponseEntity(payhistoryService.getBetweenTwoDates(Timestamp.valueOf(phm.getDateStart()),Timestamp.valueOf(phm.getDateEnd())), HttpStatus.OK);
	}

}
