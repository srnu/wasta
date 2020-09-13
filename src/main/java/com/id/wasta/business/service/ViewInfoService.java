package com.id.wasta.business.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.id.wasta.bean.TIdProfileViewDetails;
import com.id.wasta.bean.jpa.TIdChangeLogDetailsEntity;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdTableAuditLogEntity;

public interface ViewInfoService extends Serializable{

	List<TIdProfileViewDetailsViewEntity> getViewProfileInfoDtls(Long pinKey);
	
	List<TIdTableAuditLogEntity> getAudiLogInfoDtls(Long primaryKey);
	
	List<TIdTableAuditLogEntity> getDistinctAudiLogInfoDtls(Long primaryKey);

	List<TIdChangeLogDetailsEntity> getChangeLogDtls(String screenName, Long primaryKey);

	TIdProfileViewDetails saveProfileDtls(TIdProfileViewDetails tIdProfileViewDetails);

	BigDecimal getProfileCompletePercentDtls(Long pinKey);
	
	Integer getCompletedProfilePercentageInfo(Long pinKey);

	
}
