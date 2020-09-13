package com.id.wasta.business.service;

import java.util.List;
import java.util.Map;

import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdAdditionalInformation;
import com.id.wasta.bean.TIdAwardsInformation;
import com.id.wasta.bean.TIdEducationalInformation;
import com.id.wasta.bean.TIdExperienceInformation;
import com.id.wasta.bean.TIdMiscInformation;
import com.id.wasta.bean.TIdProjectsInformation;
import com.id.wasta.bean.TIdRelationshipInformationView;
import com.id.wasta.bean.TIdVisitInformation;
import com.id.wasta.bean.TIdVisitInformationView;
import com.id.wasta.bean.jpa.TIdCommunicationInformationEntity;
import com.id.wasta.bean.jpa.TIdEducationalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdEducationalInstitutesViewEntity;
import com.id.wasta.bean.jpa.TIdExperienceInformationViewEntity;
import com.id.wasta.bean.jpa.TIdLanguageInformationViewEntity;
import com.id.wasta.bean.jpa.TIdMiscInformationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdRelationGroupInfoViewEntity;

public interface DashboardInfoService { 

	AccessBlocks getAwardInfoDtls(DashBoardRequestBean dashBoardRequest);

	AccessBlocks getExperienceInfoDtls(DashBoardRequestBean dashBoardRequest);
	
	TIdExperienceInformationViewEntity getExperienceInfoDtlsById(Long pexKey);
	
	TIdVisitInformationView getVisitInfoDtlsById(Long pivKey);
	
	TIdVisitInformationView getVisitInfoDecode(String decode);

	AccessBlocks getAdditionalInfoDtls(DashBoardRequestBean dashBoardRequest);

	List<TIdMiscInformationEntity> getMiscInfoDtls(Long pinKey, String miscType);

	AccessBlocks getEducationalInfoDtls(DashBoardRequestBean dashBoardRequest);

	AccessBlocks getProjectsInfoDtls(DashBoardRequestBean dashBoardRequest);

	AccessBlocks getCommunicationInfoDtls(DashBoardRequestBean dashBoardRequest);

	List<TIdLanguageInformationViewEntity> getLanguageInfoDtls(Long pinKey);

	List<TIdRelationshipInformationView> getRelationshipInfoDtls(DashBoardRequestBean dashBoardRequest);
	
	List<TIdRelationGroupInfoViewEntity> getRelationshipGrpInfoDtls(Long pinKey, String relationType);

	AccessBlocks getVisitInfoDtls(DashBoardRequestBean dashBoardRequestBean);

	List<TIdPersonalInformationViewEntity> getPersonalInfoDtls(Long profileKey);
	
	TIdEducationalInformation saveEducationInfo(TIdEducationalInformation tIdEducationalInformation)throws Exception;

	TIdExperienceInformation saveExperienceInfo(TIdExperienceInformation tIdExperienceInformation)throws Exception;

	void saveVisitInfo(TIdVisitInformation tIdVisitInformation)throws Exception ;
	
	TIdAdditionalInformation saveAdditionalInfo(TIdAdditionalInformation tIdAdditionalInformation);

	TIdAwardsInformation saveAwardsInfo(TIdAwardsInformation tIdAwardsInformation)throws Exception;

	TIdProjectsInformation saveProjectsInfo(TIdProjectsInformation tIdProjectsInformation) throws Exception;

	TIdMiscInformation saveMiscInfo(TIdMiscInformation tIdMiscInformation);

	TIdMiscInformation saveMiscProfessionalExpertiseInfo(TIdMiscInformation tIdMiscInformation);

	TIdMiscInformation getViewProfExpert(Long pinKey);

	TIdEducationalInformationViewEntity getSpecializationlInfoDtls(Long peiKey);
	
	List<TIdEducationalInstitutesViewEntity> getInstituteInfoDtls(Long profileKey);

	AccessBlocks getRelationshipGrpInfoDtl(DashBoardRequestBean dashBoardRequest);
	
	List<TIdCommunicationInformationEntity> getCommunicationInfoDtl(Long pinKey);
	
	TIdVisitInformation discussionMailConf(TIdVisitInformation tIdVisitInformation);
	
	public List<TIdRelationshipInformationView> getProfAndPerRelationshipInfoDtls(DashBoardRequestBean dashBoardRequest);
	
//	public Map<String, AccessBlocks> getDashBoardProfile(DashBoardRequestBean dashBoardRequestBean);
}

