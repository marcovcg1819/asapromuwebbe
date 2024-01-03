package org.asapromu.util;

import org.asapromu.models.DonateRequestModel;
import org.springframework.stereotype.Component;

@Component
public class Payment {
	
	public boolean pay(DonateRequestModel drm) {
		return true;
	}

}
