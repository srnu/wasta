package com.id.wasta.business.service;

import com.id.nlp.bean.CardDetailsBean;
import com.id.wasta.bean.CustomerInfoBean;

public interface ContactScannerService {

	CustomerInfoBean convertCardToCustomerBean(CardDetailsBean cardDetailsBean);

}
