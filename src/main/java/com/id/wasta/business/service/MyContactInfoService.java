package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.OverallRatingBean;
import com.id.wasta.bean.TIdMyContactsLink;
import com.id.wasta.bean.jpa.TIdMyContactsLinkEntity;
import com.id.wasta.bean.jpa.TIdMyContactsLinkViewEntity;

public interface MyContactInfoService {

	List<SelectListBean> getCustDtlsWithExpInfo();

	String saveOrUpdateMycontact(TIdMyContactsLink tIdMyContactsLink);
	
	boolean removeMycontact(TIdMyContactsLink tIdMyContactsLink);

	TIdMyContactsLinkEntity checkMyContact(TIdMyContactsLink tIdMyContactsLink);
	
	List<TIdMyContactsLinkViewEntity> listOfMyContact(TIdMyContactsLink tIdMyContactsLink);

	OverallRatingBean connectionDtls(TIdMyContactsLink tIdMyContactsLink);

}
