package com.id.wasta.business.service;

import com.id.wasta.bean.TIdRelationshipInformation;
import com.id.wasta.bean.jpa.TIdRelationshipInformationViewEntity;

public interface RelationshipInfoService {

	TIdRelationshipInformation saveRelationshipDtls(TIdRelationshipInformation tIdRelationshipInformation) throws Exception;
	
	TIdRelationshipInformationViewEntity relationViewDtls(Long relationId);
	
	boolean chkRelationStatus(Long fromPinKey, Long toPinKey);
	
}
