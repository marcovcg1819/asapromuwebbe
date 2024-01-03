package org.asapromu.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.asapromu.entities.Payhistory;
import org.asapromu.models.PayhistoryListModel;
import org.asapromu.repositories.PayhistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayhistoryService {
	@Autowired
	private PayhistoryRepository payhistoryRepository;
	
	public Payhistory save(Payhistory ph) {
		return payhistoryRepository.save(ph);
	}
	
	public List<PayhistoryListModel> getBetweenTwoDates(Timestamp start, Timestamp end){
		List<Object[]> listObj = payhistoryRepository.findByTwoDates(start,end);
		List<PayhistoryListModel> listOut = new ArrayList<PayhistoryListModel>();
		PayhistoryListModel pay;
		for(Object[] obj:listObj) {
			pay = new PayhistoryListModel();
			pay.setDonationname((String) obj[0]);
			pay.setAmount((Double) obj[1]);
			pay.setDatepay((Timestamp)obj[2]);
			Timestamp ts = (Timestamp)obj[2];
			Date d = new Date(ts.getTime());
			DateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			pay.setDatea(f.format(d));
			listOut.add(pay);
				
		}
		return listOut;
	}
}
