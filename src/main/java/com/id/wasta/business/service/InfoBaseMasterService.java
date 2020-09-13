package com.id.wasta.business.service;

import com.id.wasta.bean.TIdInfoBaseMaster;

/**
 * Business Service Interface for entity TIdInfoBaseMaster.
 */
public interface InfoBaseMasterService { 

	TIdInfoBaseMaster findByIbmTypeAndIbmBaseCode(String ibmType, String ibmDescription);
	
}
