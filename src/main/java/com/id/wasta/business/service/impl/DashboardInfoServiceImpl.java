package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.ACTIVESTATUS;
import static com.id.wasta.util.action.CommonConstants.ADD_INFORMATION;
import static com.id.wasta.util.action.CommonConstants.AWARDS_RECOG;
import static com.id.wasta.util.action.CommonConstants.DELETE_STATUS;
import static com.id.wasta.util.action.CommonConstants.DISCUSSION_DETAILS;
import static com.id.wasta.util.action.CommonConstants.EDUCATION;
import static com.id.wasta.util.action.CommonConstants.EXPERIENCE;
import static com.id.wasta.util.action.CommonConstants.HEADER_INFO;
import static com.id.wasta.util.action.CommonConstants.IN_ACTIVE_STATUS;
import static com.id.wasta.util.action.CommonConstants.LANDLINE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.MOBILE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.PENDING_STATUS;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_RELATIONSHIP;
import static com.id.wasta.util.action.CommonConstants.PROFESSIONAL_RELATIONSHIP;
import static com.id.wasta.util.action.CommonConstants.PROJ_EXECUTED;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.CommonConstants;
import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdAdditionalInformation;
import com.id.wasta.bean.TIdAdditionalInformationView;
import com.id.wasta.bean.TIdAwardsInformation;
import com.id.wasta.bean.TIdAwardsInformationView;
import com.id.wasta.bean.TIdCommunicationInformation;
import com.id.wasta.bean.TIdEducationalInformation;
import com.id.wasta.bean.TIdEducationalInformationView;
import com.id.wasta.bean.TIdExperienceInformation;
import com.id.wasta.bean.TIdExperienceInformationView;
import com.id.wasta.bean.TIdMiscInformation;
import com.id.wasta.bean.TIdProjectsInformation;
import com.id.wasta.bean.TIdProjectsInformationView;
import com.id.wasta.bean.TIdRelationGroupInfoView;
import com.id.wasta.bean.TIdRelationshipInformationView;
import com.id.wasta.bean.TIdVisitInformation;
import com.id.wasta.bean.TIdVisitInformationView;
import com.id.wasta.bean.TIdVisitRemarks;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdAdditionalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdAdditionalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdAwardsInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdAwardsInformationViewEntity;
import com.id.wasta.bean.jpa.TIdBusinessTypeMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdCityMasterEntity;
import com.id.wasta.bean.jpa.TIdCityMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdCommunicationInformationEntity;
import com.id.wasta.bean.jpa.TIdCompanyIndustryLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdCompanyMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdCountryMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdDesignationMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdEducationalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdEducationalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdEducationalInstitutesEntitySearch;
import com.id.wasta.bean.jpa.TIdEducationalInstitutesViewEntity;
import com.id.wasta.bean.jpa.TIdExperienceInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdExperienceInformationViewEntity;
import com.id.wasta.bean.jpa.TIdFunctionalAreaMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdLanguageInformationViewEntity;
import com.id.wasta.bean.jpa.TIdMiscInformationEntity;
import com.id.wasta.bean.jpa.TIdMiscInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdProjectsInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdProjectsInformationViewEntity;
import com.id.wasta.bean.jpa.TIdQualificationMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailEntity;
import com.id.wasta.bean.jpa.TIdReferenceCodesHeaderEntity;
import com.id.wasta.bean.jpa.TIdRelationGroupInfoViewEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInformationViewEntity;
import com.id.wasta.bean.jpa.TIdSpecializationInformationEntity;
import com.id.wasta.bean.jpa.TIdSpecializationInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdSpecializationInformationViewEntity;
import com.id.wasta.bean.jpa.TIdSpecializationMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdStateMasterEntity;
import com.id.wasta.bean.jpa.TIdStateMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdVisitInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdVisitInformationViewEntity;
import com.id.wasta.bean.jpa.TIdVisitRemarksEntity;
import com.id.wasta.bean.jpa.TIdVisitRemarksEntitySearch;
import com.id.wasta.business.service.DashboardInfoService;
import com.id.wasta.business.service.ShareInfoService;
import com.id.wasta.business.service.mapper.TIdAdditionalInformationSearchServiceMapper;
import com.id.wasta.business.service.mapper.TIdAwardsInformationSearchServiceMapper;
import com.id.wasta.business.service.mapper.TIdMiscInformationSearchServiceMapper;
import com.id.wasta.business.service.mapper.TIdProjectsInformationSearchServiceMapper;
import com.id.wasta.business.service.mapper.TIdVisitInformationServiceMapper;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessTypeMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessTypeMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCityMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCityMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCommunicationInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyIndustryLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyIndustryLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCountryMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInstitutesSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInstitutesViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdFunctionalAreaMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdFunctionalAreaMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAddInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAwardsRecognitionJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingDiscussionDtlsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingEducationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingExperienceJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProjectExecutedJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdMiscInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdNationalityMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileViewDetailsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdQualificationMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdQualificationMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesHeaderJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationGroupInfoViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSpecializationInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSpecializationInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSpecializationInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSpecializationMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdStateMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdStateMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitRemarksJpaRepository;
import com.id.wasta.exception.HandledException;
import com.id.wasta.util.action.ParametersHash;


@Service
@Transactional
public class DashboardInfoServiceImpl implements DashboardInfoService {
	
	@Resource
	private TIdAwardsInformationJpaRepository tIdAwardsInformationJpaRepository;
	@Resource
	private TIdExperienceInformationViewJpaRepository tIdExperienceInformationViewJpaRepository;
	@Resource
	private TIdAdditionalInformationViewJpaRepository tIdAdditionalInformationViewJpaRepositoty; 
	@Resource
	private TIdMiscInformationJpaRepository   tIdMiscInformationJpaRepository;
	@Resource
	private TIdEducationalInformationViewJpaRepository tIdEducationalInformationViewJpaRepository; 
	@Resource
	private TIdProjectsInformationJpaRepository tIdProjectsInformationJpaRepositiry;
	@Resource
	private TIdCommunicationInformationJpaRepository tIdCommunicationInformationJpaRepository;
	@Resource
	private TIdLanguageInformationViewJpaRepository tIdLanguageInformationViewJpaRepository;
	@Resource
	private TIdRelationshipInformationViewJpaRepository   tIdRelationshipInformationViewJpaRepository;
	@Resource
	private TIdVisitInformationViewJpaRepository tIdVisitInformationViewJpaRepository;
	@Resource
	private TIdProfileViewDetailsJpaRepository  tIdProfileViewDetailsJpaRepository;
	@Resource
	private TIdPersonalInformationViewJpaRepository tIdPersonalInformationViewJpaRepository;
	@Resource
	private TIdEducationalInformationJpaRepository tIdEducationalInformationJpaRepository;
	@Resource
	private TIdCityMasterEntitySearchJpaRepository tIdCityMasterEntitySearchJpaRepository;
	@Resource
	private TIdCountryMasterEntitySearchJpaRepository tIdCountryMasterEntitySearchJpaRepository;
	@Resource
	private TIdStateMasterSearchJpaRepository tIdStateMasterSearchJpaRepository;
	@Resource
	private TIdStateMasterJpaRepository tIdStateMasterJpaRepository;
	@Resource
	private TIdNationalityMasterSearchJpaRepository tIdNationalityMasterEntitySearchJpaRepository;
	@Resource
	private TIdUserMasterViewJpaRepository tIdUserMasterViewJpaRepository;
	@Resource
	private TIdPersonalInformationSearchJpaRepository tIdPersonalInformationEntitySearchJpaRepository;
	@Resource
	private TIdEducationalInstitutesSearchJpaRepository tIdEducationalInstitutesSearchJpaRepository;
	@Resource
	private TIdDesignationMasterEntitySearchJpaRepository  tIdDesignationMasterEntitySearchJpaRepository;
	@Resource
	private TIdBusinessTypeMasterEntitySearchJpaRepository tIdBusinessTypeMasterEntitySearchJpaRepository;
	@Resource
	private TIdCompanyMasterEntitySearchJpaRepository tIdCompanyMasterEntitySearchJpaRepository;
	@Resource
	private TIdFunctionalAreaMasterEntitySearchJpaRepository  	tIdFunctionalAreaMasterEntitySearchJpaRepository;
	@Resource
	private TIdEducationalInformationSearchJpaRepository tIdEducationalInformationSearchJpaRepository;
	@Resource
	private TIdExperienceInformationSearchJpaRepository tIdExperienceInformationSearchJpaRepository;
	@Resource
	private TIdExperienceInformationJpaRepository tIdExperienceInformationJpaRepository;
	@Resource
	private TIdVisitInformationSearchJpaRepository tIdVisitInformationSearchJpaRepository;
	@Resource
	private TIdVisitInformationServiceMapper tIdVisitInformationServiceMapper;
	@Resource
	private GenericServiceMapper genericServiceMapper;
	@Resource
	private TIdAdditionalInformationSearchServiceMapper tIdAdditionalInformationSearchServiceMapper;
	@Resource
	private TIdAwardsInformationSearchServiceMapper tIdAwardsInformationSearchServiceMapper;
	@Resource
	private TIdProjectsInformationSearchServiceMapper tIdProjectsInformationSearchServiceMapper;
	@Resource
	private TIdMiscInformationSearchServiceMapper tIdMiscInformationSearchServiceMapper;
	@Resource
	private TIdQualificationMasterSearchJpaRepository tIdQualificationMasterSearchJpaRepository;
	@Resource
	private TIdSpecializationInformationSearchJpaRepository tIdSpecializationInformationSearchJpaRepository;
	@Resource
	private TIdSpecializationMasterSearchJpaRepository tIdSpecializationMasterSearchJpaRepository;
	@Resource
	private TIdSpecializationInformationJpaRepository tIdSpecializationInformationJpaRepository;
	@Resource
	private TIdSpecializationInformationViewJpaRepository 	tIdSpecializationInformationViewJpaRepository;
	@Resource
	private TIdEducationalInstitutesViewJpaRepository tIdEducationalInstitutesViewJpaRepository;
	@Resource
	private TIdAdditionalInformationJpaRepository tIdAdditionalInformationJpaRepository;
	@Resource
	private TIdAwardsInformationViewJpaRepository tIdAwardsInformationViewJpaRepository;
	@Resource
	private TIdProjectsInformationViewJpaRepository tIdProjectsInformationViewJpaRepository;
	@Resource
	private TIdRelationGroupInfoViewJpaRepository tIdRelationGroupInfoViewJpaRepository;
	@Resource
	private TIdQualificationMasterJpaRepository tIdQualificationMasterJpaRepository;
	@Resource
	private TIdCompanyMasterJpaRepository tIdCompanyMasterJpaRepository;
	@Resource
	private TIdDesignationMasterJpaRepository tIdDesignationMasterJpaRespository;
	@Resource
	private TIdBusinessTypeMasterJpaRepository tIdBusinessTypeMasterJpaRepository;
	@Resource
	private TIdFunctionalAreaMasterJpaRepository tIdFunctionalAreaMasterJpaRepository;
	@Resource
	private TIdReferenceCodesHeaderJpaRepository tIdReferenceCodesHeaderJpaRepository;
	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	@Resource
	private TIdCompanyIndustryLinkViewJpaRepository tIdCompanyIndustryLinkViewJpaRepository;
	@Resource
	private TIdCompanyIndustryLinkJpaRepository tIdCompanyIndustryLinkJpaRepository;
	@Resource
	private TIdPersonalInfoLinkJpaRepository tIdPersonalInfoLinkJpaRepository;
	@Resource
	private TIdCityMasterJpaRepository tIdCityMasterJpaRepository;
	@Resource
	private TIdVisitRemarksJpaRepository tIdVisitRemarksJpaRepository;
	@Resource
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	@Resource
	private TIdPersonalInformationJpaRepository  tIdPersonalInformationJpaRepository;
	@Autowired
	private ShareInfoService shareInfoService;
	@Resource
	private TIdLandingDiscussionDtlsJpaRepository tIdLandingDiscussionDtlsJpaRepository;
	@Resource
	private TIdLandingExperienceJpaRepository tIdLandingExperienceJpaRepository;
	@Resource
	private TIdLandingEducationJpaRepository tIdLandingEducationJpaRepository;
	@Resource
	private TIdLandingProjectExecutedJpaRepository tIdLandingProjectExecutedJpaRepository;
	@Resource
	private TIdLandingAwardsRecognitionJpaRepository tIdLandingAwardsRecognitionJpaRepository;
	@Resource
	private TIdLandingAddInformationJpaRepository tIdLandingAddInformationJpaRepository;
	
	@Value("${domain.url}")
	private String domainUrl;
	
	@Override
	public AccessBlocks getAwardInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdAwardsInformationViewEntity> tIdAwardsInformationViewEntityList = tIdAwardsInformationViewJpaRepository.findByPiaPinKeyAndActiveStatusOrderByPiaKeyDesc(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		TIdAwardsInformationView tIdAwardsInformationView=null;
		List<TIdAwardsInformationView> tIdAwardsInformationViewList=new ArrayList<TIdAwardsInformationView>();
		for (TIdAwardsInformationViewEntity tIdAwardsInformationViewEntity : tIdAwardsInformationViewEntityList) {	
			tIdAwardsInformationView=genericServiceMapper.map(tIdAwardsInformationViewEntity, TIdAwardsInformationView.class);
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdAwardsInformationView.getPiaKey(), tIdAwardsInformationView.getPiaPinKey(), AWARDS_RECOG, null)) {
					tIdAwardsInformationView.setViewAccessFlag(false);
				}
			}
			tIdAwardsInformationViewList.add(tIdAwardsInformationView);
		}
		accessBlocks.setAwardsList(tIdAwardsInformationViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getExperienceInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdExperienceInformationViewEntity> tIdExperienceInformationViewEntityList = tIdExperienceInformationViewJpaRepository.findByPexPinKeyAndActiveStatusOrderByPexKeyDesc(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		TIdExperienceInformationView tIdExperienceInformationView=null;
		List<TIdExperienceInformationView> tIdExperienceInformationViewList=new ArrayList<TIdExperienceInformationView>();
			for (TIdExperienceInformationViewEntity tIdExperienceInformationViewEntity: tIdExperienceInformationViewEntityList) {
				tIdExperienceInformationViewEntity.setListOfTIdCompanyIndustryLinkViewEntity(tIdCompanyIndustryLinkViewJpaRepository.findByCilPexKey(tIdExperienceInformationViewEntity.getPexKey()));
				tIdExperienceInformationView=genericServiceMapper.map(tIdExperienceInformationViewEntity, TIdExperienceInformationView.class);
				if(!dashBoardRequest.isCurrentUser()) {
					if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdExperienceInformationView.getPexKey(), tIdExperienceInformationView.getPexPinKey(), EXPERIENCE, null)) {
						tIdExperienceInformationView.setViewAccessFlag(false);
					}
				}
				tIdExperienceInformationViewList.add(tIdExperienceInformationView);
			}
			accessBlocks.setExperienceList(tIdExperienceInformationViewList);
		return accessBlocks;
	}
	

	@Override
	public TIdExperienceInformationViewEntity getExperienceInfoDtlsById(Long pexKey) {
		TIdExperienceInformationViewEntity tIdExperienceInformationViewEntity=tIdExperienceInformationViewJpaRepository.findOne(pexKey);
		tIdExperienceInformationViewEntity.setListOfTIdCompanyIndustryLinkViewEntity(tIdCompanyIndustryLinkViewJpaRepository.findByCilPexKey(pexKey));
		return tIdExperienceInformationViewEntity;
	}
	
	@Override
	public TIdVisitInformationView getVisitInfoDtlsById(Long pivKey) {
		TIdVisitInformationViewEntity tIdVisitInformationViewEntity = tIdVisitInformationViewJpaRepository.findOne(pivKey);
		TIdVisitInformationView tIdVisitInformationView = genericServiceMapper.map(tIdVisitInformationViewEntity, TIdVisitInformationView.class);
		List<TIdVisitRemarks> tIdVisitRemarksList = new ArrayList<TIdVisitRemarks>();
		for(TIdVisitRemarksEntity tIdVisitRemarksEntity : tIdVisitRemarksJpaRepository.findByPivrPivKey(pivKey)) {
			tIdVisitRemarksList.add(genericServiceMapper.map(tIdVisitRemarksEntity, TIdVisitRemarks.class));
		}
		tIdVisitInformationView.setListOfVisitRemarks(tIdVisitRemarksList);
		return tIdVisitInformationView;
	}
	
	@Override
	public TIdVisitInformationView getVisitInfoDecode(String decode) {
		Long pivKey =Long.parseLong(ParametersHash.decode(decode.toString()));
		TIdVisitInformationViewEntity tIdVisitInformationViewEntity = tIdVisitInformationViewJpaRepository.findOne(pivKey);
		TIdVisitInformationView tIdVisitInformationView = genericServiceMapper.map(tIdVisitInformationViewEntity, TIdVisitInformationView.class);
		List<TIdVisitRemarks> tIdVisitRemarksList = new ArrayList<TIdVisitRemarks>();
		for(TIdVisitRemarksEntity tIdVisitRemarksEntity : tIdVisitRemarksJpaRepository.findByPivrPivKey(pivKey)) {
			tIdVisitRemarksList.add(genericServiceMapper.map(tIdVisitRemarksEntity, TIdVisitRemarks.class));
		}
		tIdVisitInformationView.setListOfVisitRemarks(tIdVisitRemarksList);
		return tIdVisitInformationView;
	}

	@Override
	public AccessBlocks getAdditionalInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdAdditionalInformationViewEntity> tIdAdditionalInformationViewEntityList = tIdAdditionalInformationViewJpaRepositoty.findByPiadPinKeyAndActiveStatusOrderByPiadKeyDesc(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		TIdAdditionalInformationView tIdAdditionalInformationView=null;
		List<TIdAdditionalInformationView> tIdAdditionalInformationViewList=new ArrayList<TIdAdditionalInformationView>();
		for (TIdAdditionalInformationViewEntity tIdAdditionalInformationViewEntity : tIdAdditionalInformationViewEntityList) {					
			tIdAdditionalInformationView=genericServiceMapper.map(tIdAdditionalInformationViewEntity, TIdAdditionalInformationView.class);
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdAdditionalInformationView.getPiadKey(), tIdAdditionalInformationView.getPiadPinKey(), ADD_INFORMATION, null)) {
					tIdAdditionalInformationView.setViewAccessFlag(false);
				}
			}
			tIdAdditionalInformationViewList.add(tIdAdditionalInformationView);
		}
		accessBlocks.setAdditionalInfoList(tIdAdditionalInformationViewList);
		return accessBlocks;
	}

	@Override
	public List<TIdMiscInformationEntity> getMiscInfoDtls(Long pinKey, String miscType) {
		if("Recreation".equals(miscType)) {
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiRecreationIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		}else if("Business_Potential".equals(miscType)){
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiBusinessOpportunitiesIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		}else if("Professional_Info".equals(miscType)){
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiBusinessPotentialIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		}else if("Professional_Expertise".equals(miscType)){
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiProfessionalExpertiseIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		}else if("Professional_Interests".equals(miscType)){
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiProfessionalInterestsIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		}else if("Personal_Interests".equals(miscType)){
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiPersonalInterestsIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		}else if("Personal_Priorities".equals(miscType)){
			return tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiPersonalPrioritiesIsNotNullOrderByPimiKeyDesc(pinKey,CommonConstants.ACTIVE_STATUS);
		} else {
			return null;
		}
	}

	@Override
	public AccessBlocks getEducationalInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdEducationalInformationViewEntity> tIdEducationalInformationViewEntityList=tIdEducationalInformationViewJpaRepository.findByPeiPinKeyAndActiveStatusOrderByPeiKeyDesc(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		TIdEducationalInformationView tIdEducationalInformationView = null;
		List<TIdEducationalInformationView> tIdEducationalInformationViewList = new ArrayList<TIdEducationalInformationView>();
		List<TIdSpecializationInformationViewEntity> tIdSpecializationInformationViewEntityList= null;
		List<String> specializationList = null;
		for(TIdEducationalInformationViewEntity tIdEducationalInformationViewEntity:tIdEducationalInformationViewEntityList){
			tIdSpecializationInformationViewEntityList=
					tIdSpecializationInformationViewJpaRepository.findByPesPeiKeyAndPesSpecializationStatus(tIdEducationalInformationViewEntity.getPeiKey(),ACTIVESTATUS);
			if(tIdSpecializationInformationViewEntityList.size()>0) {
				specializationList=new ArrayList<>();
				for(TIdSpecializationInformationViewEntity tIdSpecializationInformationViewEntity : tIdSpecializationInformationViewEntityList) {
					specializationList.add(tIdSpecializationInformationViewEntity.getPesSpecializationValue());
				}
			}
			tIdEducationalInformationViewEntity.setPeiSpecialization(specializationList);
			tIdEducationalInformationView = genericServiceMapper.map(tIdEducationalInformationViewEntity, TIdEducationalInformationView.class);
			//pending status
			tIdSpecializationInformationViewEntityList=
					tIdSpecializationInformationViewJpaRepository.findByPesPeiKeyAndPesSpecializationStatus(tIdEducationalInformationViewEntity.getPeiKey(),PENDING_STATUS);
			if(tIdSpecializationInformationViewEntityList.size()>0) {
				for(TIdSpecializationInformationViewEntity tIdSpecializationInformationViewEntity : tIdSpecializationInformationViewEntityList) {
					tIdEducationalInformationView.setOtherSpecializationKey(tIdSpecializationInformationViewEntity.getPesSpecializationKey());
					tIdEducationalInformationView.setOtherSpecializationName(tIdSpecializationInformationViewEntity.getPesSpecializationValue());
					tIdEducationalInformationView.setOtherSpecializationStatus(tIdSpecializationInformationViewEntity.getPesSpecializationStatus());
				}
			}
			
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdEducationalInformationView.getPeiKey(), tIdEducationalInformationView.getPeiPinKey(), EDUCATION, null)) {
					tIdEducationalInformationView.setViewAccessFlag(false);
				}
			}
			tIdEducationalInformationViewList.add(tIdEducationalInformationView);
			
		}
		accessBlocks.setEducationList(tIdEducationalInformationViewList);
		return accessBlocks;
	}
	
	@Override
	public TIdEducationalInformationViewEntity getSpecializationlInfoDtls(Long peiKey) {
		TIdEducationalInformationViewEntity tIdEducationalInformationViewEntity=tIdEducationalInformationViewJpaRepository.findOne(peiKey);
		List<TIdSpecializationInformationViewEntity> tIdSpecializationInformationViewEntityList= null;
		if(tIdEducationalInformationViewEntity!=null){
			List<Long> specializationList = null;
			tIdSpecializationInformationViewEntityList=
					tIdSpecializationInformationViewJpaRepository.findByPesPeiKeyAndPesSpecializationStatus(tIdEducationalInformationViewEntity.getPeiKey(), ACTIVESTATUS);
			specializationList=new ArrayList<>();
			if(tIdSpecializationInformationViewEntityList.size()>0) {
				for(TIdSpecializationInformationViewEntity tIdSpecializationInformationViewEntity : tIdSpecializationInformationViewEntityList) {
					specializationList.add(tIdSpecializationInformationViewEntity.getPesSpecializationKey());
				}
			}
			tIdEducationalInformationViewEntity.setPeiSpecializationKey(specializationList);
			
			//pending status
			tIdSpecializationInformationViewEntityList=
					tIdSpecializationInformationViewJpaRepository.findByPesPeiKeyAndPesSpecializationStatus(tIdEducationalInformationViewEntity.getPeiKey(),PENDING_STATUS);
			if(tIdSpecializationInformationViewEntityList.size()>0) {
				for(TIdSpecializationInformationViewEntity tIdSpecializationInformationViewEntity : tIdSpecializationInformationViewEntityList) {
					tIdEducationalInformationViewEntity.setOtherSpecializationKey(tIdSpecializationInformationViewEntity.getPesSpecializationKey());
					tIdEducationalInformationViewEntity.setOtherSpecializationName(tIdSpecializationInformationViewEntity.getPesSpecializationValue());
					tIdEducationalInformationViewEntity.setOtherSpecializationStatus(tIdSpecializationInformationViewEntity.getPesSpecializationStatus());
				}
			}
			
		}
		return tIdEducationalInformationViewEntity;
	}
	
	@Override
	public AccessBlocks getProjectsInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdProjectsInformationViewEntity> tIdProjectsInformationViewEntityList = tIdProjectsInformationViewJpaRepository.findByPipPinKeyAndActiveStatusOrderByPipKeyDesc(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		TIdProjectsInformationView tIdProjectsInformationView = null;
		List<TIdProjectsInformationView> tIdProjectsInformationViewList = new ArrayList<TIdProjectsInformationView>();
		for (TIdProjectsInformationViewEntity tIdProjectsInformationViewEntity : tIdProjectsInformationViewEntityList) {				
			tIdProjectsInformationView = genericServiceMapper.map(tIdProjectsInformationViewEntity, TIdProjectsInformationView.class);
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdProjectsInformationView.getPipKey(), tIdProjectsInformationView.getPipPinKey(), PROJ_EXECUTED, null)) {
					tIdProjectsInformationView.setViewAccessFlag(false);
				}
			}
			tIdProjectsInformationViewList.add(tIdProjectsInformationView);
		}
		accessBlocks.setProjectList(tIdProjectsInformationViewList);
		return accessBlocks;
	}
	
	@Override
	public AccessBlocks getCommunicationInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();	
		List<TIdCommunicationInformationEntity> tIdCommunicationInformationEntityList = tIdCommunicationInformationJpaRepository.findByPcmPinKey(dashBoardRequest.getPinKey());	
		TIdCommunicationInformation tIdCommunicationInformation = null;
		List<TIdCommunicationInformation> tIdCommunicationInformationList = new ArrayList<TIdCommunicationInformation>();
		for (TIdCommunicationInformationEntity tIdCommunicationInformationEntity : tIdCommunicationInformationEntityList) {
			tIdCommunicationInformation = genericServiceMapper.map(tIdCommunicationInformationEntity, TIdCommunicationInformation.class);
			if (tIdCommunicationInformation.getPcmType().equals("M")) {
				if(!dashBoardRequest.isCurrentUser()) {
					if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), dashBoardRequest.getPinKey(), dashBoardRequest.getPinKey(), HEADER_INFO, MOBILE_NUMBER)) {
						tIdCommunicationInformation.setViewAccessFlag(false);
					}
				}
			} else if (tIdCommunicationInformation.getPcmType().equals("L")) {
				if(!dashBoardRequest.isCurrentUser()) {
					if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), dashBoardRequest.getPinKey(), dashBoardRequest.getPinKey(), HEADER_INFO, LANDLINE_NUMBER)) {
						tIdCommunicationInformation.setViewAccessFlag(false);
					}
				}
			}
			tIdCommunicationInformationList.add(tIdCommunicationInformation);
		}
		accessBlocks.setCommunicationInformationList(tIdCommunicationInformationList);
		return accessBlocks;
		
	}

	@Override
	public List<TIdLanguageInformationViewEntity> getLanguageInfoDtls(Long pinKey) {
		return tIdLanguageInformationViewJpaRepository.findByPliPinKey(pinKey);
	}

	@Override
	public List<TIdRelationshipInformationView> getRelationshipInfoDtls(DashBoardRequestBean dashBoardRequest) {
		List<TIdRelationshipInformationView> tIdRelationshipInformationViewList = new ArrayList<TIdRelationshipInformationView>();
		List<TIdRelationshipInformationViewEntity> tIdRelationshipInformationViewEntityList; 
		if(!("").equals(dashBoardRequest.getRelationType())) {
			tIdRelationshipInformationViewEntityList = 
					tIdRelationshipInformationViewJpaRepository.findByPrlPinKeyAndRelationTypeAndActiveStatus(dashBoardRequest.getPinKey(), dashBoardRequest.getRelationType(),ACTIVESTATUS);
		} else {
			tIdRelationshipInformationViewEntityList = tIdRelationshipInformationViewJpaRepository.findByPrlPinKeyAndActiveStatus(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		}
		TIdRelationshipInformationView tIdRelationshipInformationView;
		for(TIdRelationshipInformationViewEntity tIdRelationshipInformationViewEntity : tIdRelationshipInformationViewEntityList) {
			tIdRelationshipInformationView = genericServiceMapper.map(tIdRelationshipInformationViewEntity, TIdRelationshipInformationView.class);
				if(!dashBoardRequest.isCurrentUser()) {
					if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdRelationshipInformationView.getPrlkKey(), tIdRelationshipInformationView.getPrlPinKey(), tIdRelationshipInformationView.getRelationType().equals("Personal")?PERSONAL_RELATIONSHIP:PROFESSIONAL_RELATIONSHIP, null)) {
						tIdRelationshipInformationView.setViewAccessFlag(false);
					}
				}
			tIdRelationshipInformationViewList.add(tIdRelationshipInformationView);
		}
		return tIdRelationshipInformationViewList;
	}
	
	@Override
	public List<TIdRelationshipInformationView> getProfAndPerRelationshipInfoDtls(DashBoardRequestBean dashBoardRequest) {
		List<TIdRelationshipInformationView> tIdRelationshipInformationViewList = new ArrayList<TIdRelationshipInformationView>();
		List<TIdRelationshipInformationViewEntity> tIdRelationshipInformationViewEntityList; 
		List<TIdRelationshipInformationViewEntity> tIdRelationshipInformationViewEntityList2 =  new ArrayList<TIdRelationshipInformationViewEntity>(); 
		for(int i=0;i<2;i++) {
			if(i<1) {
				tIdRelationshipInformationViewEntityList = tIdRelationshipInformationViewJpaRepository.findByPrlPinKeyAndRelationTypeAndActiveStatus(dashBoardRequest.getPinKey(), "Professional",ACTIVESTATUS);
				tIdRelationshipInformationViewEntityList2.addAll(tIdRelationshipInformationViewEntityList);
			}else {
				tIdRelationshipInformationViewEntityList = tIdRelationshipInformationViewJpaRepository.findByPrlPinKeyAndRelationTypeAndActiveStatus(dashBoardRequest.getPinKey(), "Personal",ACTIVESTATUS);
				tIdRelationshipInformationViewEntityList2.addAll(tIdRelationshipInformationViewEntityList);
			}
		}
		TIdRelationshipInformationView tIdRelationshipInformationView;
		for(TIdRelationshipInformationViewEntity tIdRelationshipInformationViewEntity : tIdRelationshipInformationViewEntityList2) {
			tIdRelationshipInformationView = genericServiceMapper.map(tIdRelationshipInformationViewEntity, TIdRelationshipInformationView.class);
				if(!dashBoardRequest.isCurrentUser()) {
					if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdRelationshipInformationView.getPrlkKey(), tIdRelationshipInformationView.getPrlPinKey(), tIdRelationshipInformationView.getRelationType().equals("Personal")?PERSONAL_RELATIONSHIP:PROFESSIONAL_RELATIONSHIP, null)) {
						tIdRelationshipInformationView.setViewAccessFlag(false);
					}
				}
			tIdRelationshipInformationViewList.add(tIdRelationshipInformationView);
		}
		return tIdRelationshipInformationViewList;
	}
	
	
	@Override
	public List<TIdRelationGroupInfoViewEntity> getRelationshipGrpInfoDtls(Long pinKey, String relationType) {
		List<TIdRelationGroupInfoViewEntity> tIdRelationGroupInfoViewEntityList = new ArrayList<TIdRelationGroupInfoViewEntity>();
		if(!relationType.equals("")) {
			tIdRelationGroupInfoViewEntityList = tIdRelationGroupInfoViewJpaRepository.findByPrlPinKeyAndRelationtype(pinKey, relationType);
		} else {
			tIdRelationGroupInfoViewEntityList = tIdRelationGroupInfoViewJpaRepository.findByPrlPinKey(pinKey);
		}
		return tIdRelationGroupInfoViewEntityList;
	}

	@Override
	public AccessBlocks getRelationshipGrpInfoDtl(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdRelationGroupInfoViewEntity> tIdRelationGroupInfoViewEntityList = new ArrayList<TIdRelationGroupInfoViewEntity>();
		if(!dashBoardRequest.getRelationType().equals("")) {
			tIdRelationGroupInfoViewEntityList = tIdRelationGroupInfoViewJpaRepository.findByPrlPinKeyAndRelationtype(dashBoardRequest.getPinKey(), dashBoardRequest.getRelationType());
		} else {
			tIdRelationGroupInfoViewEntityList = tIdRelationGroupInfoViewJpaRepository.findByPrlPinKey(dashBoardRequest.getPinKey());
		}
		TIdRelationGroupInfoView tIdRelationGroupInfoView = new TIdRelationGroupInfoView();
		List<TIdRelationGroupInfoView> tIdRelationGroupInfoViewList = new ArrayList<TIdRelationGroupInfoView>();
		for(TIdRelationGroupInfoViewEntity tIdRelationGroupInfoViewEntity:tIdRelationGroupInfoViewEntityList)
        {
			tIdRelationGroupInfoView = genericServiceMapper.map(tIdRelationGroupInfoViewEntity, TIdRelationGroupInfoView.class);
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdRelationGroupInfoView.getPrlKey(), tIdRelationGroupInfoView.getPrlPinKey(), tIdRelationGroupInfoView.getRelationship(), null)) {
					tIdRelationGroupInfoView.setViewAccessFlag(false);
				}
			}
			tIdRelationGroupInfoViewList.add(tIdRelationGroupInfoView);
		}
		accessBlocks.setRelationShipGroupList(tIdRelationGroupInfoViewList);
		return accessBlocks;
	}
	
	
	@Override
	public AccessBlocks getVisitInfoDtls(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdVisitInformationViewEntity> tIdVisitInformationViewEntityList = tIdVisitInformationViewJpaRepository.findByPivPinKeyAndActiveStatus(dashBoardRequest.getPinKey(),ACTIVESTATUS);
		TIdVisitInformationView tIdVisitInformationView = null;
		List<TIdVisitInformationView> tIdVisitInformationViewList = new ArrayList<TIdVisitInformationView>();
		List<TIdVisitRemarks> visitRemarksList = null; 
		
			for (TIdVisitInformationViewEntity tIdVisitInformationViewEntity : tIdVisitInformationViewEntityList) {
				tIdVisitInformationView = new TIdVisitInformationView();
				tIdVisitInformationView = genericServiceMapper.map(tIdVisitInformationViewEntity, TIdVisitInformationView.class);
				visitRemarksList = new ArrayList<TIdVisitRemarks>();
				
				if(dashBoardRequest.getLoginPinKey().equals(tIdVisitInformationView.getPivCreatedBy())){
					tIdVisitInformationView.setEditAccessFlag(true);
					tIdVisitInformationView.setViewAccessFlag(true);
				}else {
					tIdVisitInformationView.setEditAccessFlag(false);
					boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
													dashBoardRequest.getLoginPinKey(),
													tIdVisitInformationView.getPivKey(), 
													tIdVisitInformationViewEntity.getPivCreatedBy(),
													tIdVisitInformationView.getPivPinKey(),
													DISCUSSION_DETAILS, null);
					tIdVisitInformationView.setViewAccessFlag(viewAccessGranted);
				}
				
				for(TIdVisitRemarksEntity tIdVisitRemarksEntity:tIdVisitRemarksJpaRepository.findByPivrPivKey(tIdVisitInformationView.getPivKey())) {
					visitRemarksList.add(genericServiceMapper.map(tIdVisitRemarksEntity, TIdVisitRemarks.class));
				}
				tIdVisitInformationView.setPivVisitedDate(tIdVisitInformationView.getPivVisitedDate().substring(0,10));
				tIdVisitInformationView.setListOfVisitRemarks(visitRemarksList);

				if(!dashBoardRequest.getLoginPinKey().equals(tIdVisitInformationView.getPivCreatedBy())) {
					tIdVisitInformationView.setEditAccessFlag(false);
					if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), tIdVisitInformationView.getPivKey(), tIdVisitInformationView.getPivPinKey(), DISCUSSION_DETAILS, null)) {
						tIdVisitInformationView.setViewAccessFlag(false);
					}
				}
				tIdVisitInformationViewList.add(tIdVisitInformationView);
			}
			accessBlocks.setVisitList(tIdVisitInformationViewList);	
		return accessBlocks;

	}

	@Override
	public List<TIdPersonalInformationViewEntity> getPersonalInfoDtls(Long profileKey) {
		return tIdPersonalInformationViewJpaRepository.findByProfileKey(profileKey);
	}
	
	@Override
	public List<TIdCommunicationInformationEntity> getCommunicationInfoDtl(Long pinKey) {
		return tIdCommunicationInformationJpaRepository.findByPcmPinKey(pinKey);
	}

	@Override
	public TIdEducationalInformation saveEducationInfo(TIdEducationalInformation tIdEducationalInformation) throws Exception{ 
		TIdQualificationMasterEntitySearch  tIdQualificationMasterEntitySearch =null;
		TIdEducationalInstitutesEntitySearch tIdEducationalInstitutesEntitySearch=null;
		TIdCityMasterEntity tIdCityMasterEntity=null;
		TIdStateMasterEntity tIdStateMasterEntity=null;
		List<TIdStateMasterEntity> tIdStateMasterEntityList=null;
		List<TIdCityMasterEntity> tIdCityMasterEntityList=new ArrayList<TIdCityMasterEntity>();
		List<TIdEducationalInformationEntitySearch> tIdEducationalInformationEntitySearchList = new ArrayList<TIdEducationalInformationEntitySearch>();
		List<TIdSpecializationInformationEntitySearch> tIdSpecializationInformationEntitySearchList = new ArrayList<TIdSpecializationInformationEntitySearch>();
		TIdEducationalInformationEntitySearch  tIdEducationalInformationEntitySearch = new TIdEducationalInformationEntitySearch();
		TIdSpecializationMasterEntitySearch tIdSpecializationMasterEntitySearch=null;
		tIdEducationalInformationEntitySearch.setPeiKey(tIdEducationalInformation.getPeiKey());
		
		if(tIdEducationalInformation.getOtherQualificationName()!=null) {
			if(tIdEducationalInformation.getPeiQualificationKey()!=null && tIdEducationalInformation.getPeiQualificationKey()!=0) {
				tIdQualificationMasterEntitySearch = tIdQualificationMasterSearchJpaRepository.findByNameAndQualificationKeyNotIn(tIdEducationalInformation.getOtherQualificationName(), tIdEducationalInformation.getPeiQualificationKey());
		        if(tIdQualificationMasterEntitySearch!=null) {
		        	if(tIdQualificationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdQualificationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdQualificationMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
		        			tIdQualificationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
		        			tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.save(tIdQualificationMasterEntitySearch);
		        			tIdEducationalInformation.setPeiQualificationKey(tIdQualificationMasterEntitySearch.getQualificationKey());
		        			tIdEducationalInformation.setOtherQualificationName(null);
		        		} else {
		        			throw new DataIntegrityViolationException("Qualification name already exist!!!");
		        		  }
				} else {
					tIdQualificationMasterEntitySearch = tIdQualificationMasterSearchJpaRepository.findOne(tIdEducationalInformation.getPeiQualificationKey());
					tIdQualificationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdQualificationMasterEntitySearch.setName(tIdEducationalInformation.getOtherQualificationName());
					tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.save(tIdQualificationMasterEntitySearch);
					tIdEducationalInformation.setOtherQualificationName(null);
				}
			
			}else {
				tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.findByName(tIdEducationalInformation.getOtherQualificationName());
				if(tIdQualificationMasterEntitySearch!=null){
					if(tIdQualificationMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdQualificationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdQualificationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
						tIdQualificationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
	        			tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.save(tIdQualificationMasterEntitySearch);
						tIdEducationalInformation.setPeiQualificationKey(tIdQualificationMasterEntitySearch.getQualificationKey());
						tIdEducationalInformation.setOtherQualificationName(null);
					} else {
						throw new DataIntegrityViolationException("Qualification name already exist!!!");
					}	
					}
				} 
			}
		if(tIdEducationalInformation.getOtherInstituteName()!=null) {
			if(tIdEducationalInformation.getPeiEduInstituteKey()!=null && tIdEducationalInformation.getPeiEduInstituteKey()!=0) {
				tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.findByNameAndKeyNotIn(tIdEducationalInformation.getOtherInstituteName(), tIdEducationalInformation.getPeiEduInstituteKey());
		        if(tIdEducationalInstitutesEntitySearch!=null) {
		        	if(tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
		        		tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
		        		tIdEducationalInformation.setOtherInstituteKey(tIdEducationalInstitutesEntitySearch.getKey());
		        		tIdEducationalInformation.setOtherInstituteName(null);
		        	} else {
		        			throw new DataIntegrityViolationException("Institute name already exist!!!");
		        	}
				} else {
					tIdEducationalInstitutesEntitySearch = tIdEducationalInstitutesSearchJpaRepository.findByKey(tIdEducationalInformation.getPeiEduInstituteKey());
					tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdEducationalInstitutesEntitySearch.setName(tIdEducationalInformation.getOtherInstituteName());
					tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
					tIdEducationalInformation.setOtherInstituteName(null);
				}
			
			}else{
				tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.findByName(tIdEducationalInformation.getOtherInstituteName());
				if(tIdEducationalInstitutesEntitySearch!=null) {
					if(tIdEducationalInstitutesEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(DELETE_STATUS)||tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
						tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
		        		tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
						tIdEducationalInformation.setPeiEduInstituteKey(tIdEducationalInstitutesEntitySearch.getKey());
						tIdEducationalInformation.setOtherInstituteName(null);
					} else {
						throw new DataIntegrityViolationException("Institute name already exist!!!");
					}
					}
				}
			}
			 
		if(tIdEducationalInformation.getOtherCityName()!=null){
			if(tIdEducationalInformation.getCityKey() !=null && tIdEducationalInformation.getCityKey()!=0) {
		        tIdCityMasterEntityList=tIdCityMasterJpaRepository.findByNameAndKeyNotIn(tIdEducationalInformation.getOtherCityName(), tIdEducationalInformation.getCityKey());
		        if(tIdCityMasterEntityList!=null && tIdCityMasterEntityList.size()>0) {
		        	if(tIdCityMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdCityMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdCityMasterEntityList.get(0).getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdCityMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
		        		tIdCityMasterJpaRepository.save(tIdCityMasterEntityList);// doubt
		        		tIdEducationalInformation.setCityKey(tIdCityMasterEntityList.get(0).getKey());
		        		tIdEducationalInformation.setOtherCityName(null);
	        		} else {
		        			throw new DataIntegrityViolationException("City name already exist!!!");
		        	}
				} else {
					tIdCityMasterEntity = tIdCityMasterJpaRepository.findOne(tIdEducationalInformation.getCityKey());
					tIdCityMasterEntity.setActiveStatus(PENDING_STATUS);
					tIdCityMasterEntity.setName(tIdEducationalInformation.getOtherCityName());
					tIdCityMasterEntity=tIdCityMasterJpaRepository.save(tIdCityMasterEntity);
					tIdEducationalInformation.setOtherCityName(null);
				}
			} else {
			tIdCityMasterEntityList=tIdCityMasterJpaRepository.findByName(tIdEducationalInformation.getOtherCityName());
			if(tIdCityMasterEntityList!=null && tIdCityMasterEntityList.size()>0){
				if(tIdCityMasterEntityList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdCityMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS) 
							||tIdCityMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) {
						tIdCityMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
						tIdCityMasterJpaRepository.save(tIdCityMasterEntityList);
						tIdEducationalInformation.setCityKey(tIdCityMasterEntityList.get(0).getKey());
						tIdEducationalInformation.setOtherCityName(null);
						} else {
							throw new DataIntegrityViolationException("City name already exist!!!");
						}
				}
			} 
			}
		if(tIdEducationalInformation.getOtherStateName()!=null) {
			if(tIdEducationalInformation.getStateKey() !=null && tIdEducationalInformation.getStateKey()!=0) {
				tIdStateMasterEntityList=tIdStateMasterJpaRepository.findByNameAndKeyNotIn(tIdEducationalInformation.getOtherStateName(),tIdEducationalInformation.getStateKey());
		        if(tIdStateMasterEntityList!=null && tIdStateMasterEntityList.size()>0) {
		        	if(tIdStateMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdStateMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdStateMasterEntityList.get(0).getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdStateMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
		        		tIdStateMasterJpaRepository.save(tIdStateMasterEntityList);
		        		tIdEducationalInformation.setStateKey(tIdStateMasterEntityList.get(0).getKey());
		        		tIdEducationalInformation.setOtherStateName(null);
	        		} else {
		        			throw new DataIntegrityViolationException("State name already exist!!!");
		        		  }
				} else {
					tIdStateMasterEntity = tIdStateMasterJpaRepository.findOne(tIdEducationalInformation.getStateKey());
					tIdStateMasterEntity.setActiveStatus(PENDING_STATUS);
					tIdStateMasterEntity.setName(tIdEducationalInformation.getOtherStateName());
					tIdStateMasterEntity=tIdStateMasterJpaRepository.save(tIdStateMasterEntity);
					tIdEducationalInformation.setOtherStateName(null);
				}
			} else {
				tIdStateMasterEntityList = tIdStateMasterJpaRepository.findByName(tIdEducationalInformation.getOtherStateName());
				if(tIdStateMasterEntityList.size()>0) {
				if(tIdStateMasterEntityList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdStateMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS)|| tIdStateMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) 
				{
					tIdStateMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
					tIdStateMasterJpaRepository.save(tIdStateMasterEntityList);
					tIdEducationalInformation.setStateKey(tIdStateMasterEntityList.get(0).getKey());
					tIdEducationalInformation.setOtherStateName(null);
				} else {
					throw new DataIntegrityViolationException("State name already exist!!!");
				}
					}
				}
			}
		List<TIdSpecializationMasterEntitySearch> tIdSpecializationMasterEntitySearchList = null;
		if(tIdEducationalInformation.getOtherSpecializationName()!=null){
			if(tIdEducationalInformation.getOtherSpecializationkey() !=null && tIdEducationalInformation.getOtherSpecializationkey()!=0) {
				tIdSpecializationMasterEntitySearchList =tIdSpecializationMasterSearchJpaRepository.findByNameAndSpecialKeyNotIn(tIdEducationalInformation.getOtherSpecializationName(),tIdEducationalInformation.getOtherSpecializationkey());
		        if(tIdSpecializationMasterEntitySearchList.size()>0) {
					throw new DataIntegrityViolationException("Specialization name already exist!!!");
				} else {
					tIdSpecializationMasterEntitySearch = tIdSpecializationMasterSearchJpaRepository.findOne(tIdEducationalInformation.getOtherSpecializationkey());
					tIdSpecializationMasterEntitySearch.setName(tIdEducationalInformation.getOtherStateName());
					tIdSpecializationMasterEntitySearch=tIdSpecializationMasterSearchJpaRepository.save(tIdSpecializationMasterEntitySearch);
					tIdEducationalInformation.setOtherSpecializationName(null);
				}
			}
			else {
				tIdSpecializationMasterEntitySearch=tIdSpecializationMasterSearchJpaRepository.findByName(tIdEducationalInformation.getOtherSpecializationName());
				if(tIdSpecializationMasterEntitySearch!=null){
					if(tIdSpecializationMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)) {
						 List<Long> peiSpecialization = new ArrayList<Long>();
						 peiSpecialization.add(tIdSpecializationMasterEntitySearch.getSpecialKey()); 
						 peiSpecialization.addAll(tIdEducationalInformation.getPeiSpecialization());  
						 tIdEducationalInformation.setPeiSpecialization(peiSpecialization);
						 tIdEducationalInformation.setOtherSpecializationName(null);
					} else {
						throw new DataIntegrityViolationException("Specialization Name Already Exist!!!");
					}
				}
			}
		}
		
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdEducationalInformation.getPeiPinKey());
		
		tIdEducationalInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		
		if(tIdEducationalInformation.getOtherQualificationName()!=null) // saving others as qualification
		{
			tIdQualificationMasterEntitySearch = new TIdQualificationMasterEntitySearch();
			tIdQualificationMasterEntitySearch.setName(tIdEducationalInformation.getOtherQualificationName());
			tIdQualificationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdQualificationMasterEntitySearch.setProfileKey(1L);
			tIdQualificationMasterEntitySearch.setLockKey(0L);
			tIdQualificationMasterEntitySearch.setActiveFrom(new Date());
			tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.save(tIdQualificationMasterEntitySearch);
			tIdEducationalInformation.setOtherQualificationKey(tIdQualificationMasterEntitySearch.getQualificationKey());
			tIdEducationalInformationEntitySearch.settIdQualificationMaster(tIdQualificationMasterEntitySearch);
			
		} else if(tIdEducationalInformation.getPeiQualificationKey()!=null){
			tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.findOne(tIdEducationalInformation.getPeiQualificationKey());
			tIdEducationalInformationEntitySearch.settIdQualificationMaster(tIdQualificationMasterEntitySearch);
		}
		
		 if(tIdEducationalInformation.getOtherInstituteName()!=null) // saving others as education institute
		{
			tIdEducationalInstitutesEntitySearch =new TIdEducationalInstitutesEntitySearch();
			tIdEducationalInstitutesEntitySearch.setName(tIdEducationalInformation.getOtherInstituteName());
			tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdEducationalInstitutesEntitySearch.setEducationActiveStatusKey(1L);
			tIdEducationalInstitutesEntitySearch.setProfileKey(1L);
			tIdEducationalInstitutesEntitySearch.setLockKey(0L);
			tIdEducationalInstitutesEntitySearch.setActiveFrom(new Date());
			
			if(tIdEducationalInformation.getOtherCityName()!=null){
				tIdCityMasterEntity=new TIdCityMasterEntity();
				tIdCityMasterEntity.setActiveFrom(new Date());
				tIdCityMasterEntity.setName(tIdEducationalInformation.getOtherCityName());
				tIdCityMasterEntity.setActiveStatus(PENDING_STATUS);
				tIdCityMasterEntity.setLockKey(0L);
				tIdCityMasterEntity.setProfileKey(1l);
				tIdCityMasterEntity.setCountryKey(tIdEducationalInformation.getCountryKey());
				tIdCityMasterEntity=tIdCityMasterJpaRepository.save(tIdCityMasterEntity);
				tIdEducationalInstitutesEntitySearch.setEducationCityKey(tIdCityMasterEntity.getKey());
			
			}else if(tIdEducationalInformation.getCityKey()!=null){
				tIdEducationalInstitutesEntitySearch.setEducationCityKey(tIdEducationalInformation.getCityKey());
			}
			
			if(tIdEducationalInformation.getOtherStateName()!=null) {
				tIdStateMasterEntity = new TIdStateMasterEntity();
				tIdStateMasterEntity.setName(tIdEducationalInformation.getOtherStateName());
				tIdStateMasterEntity.setStateAbbreviation(tIdEducationalInformation.getOtherStateName());
				tIdStateMasterEntity.setStateCountryKey(tIdEducationalInformation.getCountryKey());
				tIdStateMasterEntity.setActiveStatus(PENDING_STATUS);
				tIdStateMasterEntity.setActiveFrom(new Date());
				tIdStateMasterEntity.setLockKey(0L);
				tIdStateMasterEntity.setProfileKey(1l);
				tIdStateMasterEntity = tIdStateMasterJpaRepository.save(tIdStateMasterEntity);
				tIdEducationalInstitutesEntitySearch.setEducationStateKey(tIdStateMasterEntity.getKey());

			} else if(tIdEducationalInformation.getStateKey()!=null) {
				tIdEducationalInstitutesEntitySearch.setEducationStateKey(tIdEducationalInformation.getStateKey());
			}
			
			tIdEducationalInstitutesEntitySearch.setEducationCountryKey(tIdEducationalInformation.getCountryKey());
			tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
			tIdEducationalInformation.setOtherInstituteKey(tIdEducationalInstitutesEntitySearch.getKey());
			tIdEducationalInformationEntitySearch.setTIdEducationalInstitutes(tIdEducationalInstitutesEntitySearch);
			
		} else if(tIdEducationalInformation.getPeiEduInstituteKey()!=null){
			tIdEducationalInstitutesEntitySearch =tIdEducationalInstitutesSearchJpaRepository.findOne(tIdEducationalInformation.getPeiEduInstituteKey());
			
			if(tIdEducationalInformation.getOtherCityName()!=null){
				tIdCityMasterEntity=new TIdCityMasterEntity();
				tIdCityMasterEntity.setActiveFrom(new Date());
				tIdCityMasterEntity.setName(tIdEducationalInformation.getOtherCityName());
				tIdCityMasterEntity.setActiveStatus(PENDING_STATUS);
				tIdCityMasterEntity.setLockKey(0L);
				tIdCityMasterEntity.setProfileKey(1l);
				tIdCityMasterEntity.setCountryKey(tIdEducationalInformation.getCountryKey());
				tIdCityMasterEntity=tIdCityMasterJpaRepository.save(tIdCityMasterEntity);
				tIdEducationalInstitutesEntitySearch.setEducationCityKey(tIdCityMasterEntity.getKey());
			
			}else if(tIdEducationalInformation.getCityKey()!=null){
				tIdEducationalInstitutesEntitySearch.setEducationCityKey(tIdEducationalInformation.getCityKey());
			}
			
			if(tIdEducationalInformation.getOtherStateName()!=null) {
				tIdStateMasterEntity = new TIdStateMasterEntity();
				tIdStateMasterEntity.setName(tIdEducationalInformation.getOtherStateName());
				tIdStateMasterEntity.setStateAbbreviation(tIdEducationalInformation.getOtherStateName());
				tIdStateMasterEntity.setStateCountryKey(tIdEducationalInformation.getCountryKey());
				tIdStateMasterEntity.setActiveStatus(PENDING_STATUS);
				tIdStateMasterEntity.setActiveFrom(new Date());
				tIdStateMasterEntity.setLockKey(0L);
				tIdStateMasterEntity.setProfileKey(1l);
				tIdStateMasterEntity = tIdStateMasterJpaRepository.save(tIdStateMasterEntity);
				tIdEducationalInstitutesEntitySearch.setEducationStateKey(tIdStateMasterEntity.getKey());

			} else if(tIdEducationalInformation.getStateKey()!=null) {
				tIdEducationalInstitutesEntitySearch.setEducationStateKey(tIdEducationalInformation.getStateKey());
			}
			
			tIdEducationalInstitutesEntitySearch.setEducationCountryKey(tIdEducationalInformation.getCountryKey());
			tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
			tIdEducationalInformationEntitySearch.setTIdEducationalInstitutes(tIdEducationalInstitutesEntitySearch);
		}
		 
		TIdSpecializationInformationEntitySearch tIdSpecializationInformationEntitySearch = null;
		if(tIdEducationalInformation.getPeiKey()!=null) {
			 List<TIdSpecializationInformationEntity> tIdSpecializationInformationEntityList =
					 tIdSpecializationInformationJpaRepository.findByPesPeiKey(tIdEducationalInformation.getPeiKey());
			 if(tIdSpecializationInformationEntityList.size()>0) {
				 tIdSpecializationInformationJpaRepository.delete(tIdSpecializationInformationEntityList);
			 }
		}
		
		if(tIdEducationalInformation.getOtherSpecializationName()!=null){
			tIdSpecializationInformationEntitySearch=new TIdSpecializationInformationEntitySearch();
			tIdSpecializationMasterEntitySearch=new TIdSpecializationMasterEntitySearch();
			tIdSpecializationMasterEntitySearch.setActiveFrom(new Date());
			tIdSpecializationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdSpecializationMasterEntitySearch.setName(tIdEducationalInformation.getOtherSpecializationName());
			tIdSpecializationMasterEntitySearch.setLockKey(0L);
			tIdSpecializationMasterEntitySearch.setProfileKey(1L);
			tIdSpecializationMasterEntitySearch.setSpecialActiveStatusKey(10L);
			tIdSpecializationMasterEntitySearch=tIdSpecializationMasterSearchJpaRepository.save(tIdSpecializationMasterEntitySearch);
			tIdSpecializationInformationEntitySearch.setTIdSpecializationMaster(tIdSpecializationMasterEntitySearch);
			tIdSpecializationInformationEntitySearch.setTIdEducationalInformation(tIdEducationalInformationEntitySearch);
			tIdSpecializationInformationEntitySearch.setActiveStatus(tIdEducationalInformation.getActiveStatus());
			tIdSpecializationInformationEntitySearch.setLockKey(tIdEducationalInformation.getLockKey());
			tIdSpecializationInformationEntitySearch.setProfileKey(tIdEducationalInformation.getProfileKey());
			tIdSpecializationInformationEntitySearchList.add(tIdSpecializationInformationEntitySearch);
			
			for(Long  specializationKey :tIdEducationalInformation.getPeiSpecialization()){
				tIdSpecializationInformationEntitySearch=new TIdSpecializationInformationEntitySearch();
				tIdSpecializationMasterEntitySearch=tIdSpecializationMasterSearchJpaRepository.findOne(specializationKey);
				tIdSpecializationInformationEntitySearch.setTIdSpecializationMaster(tIdSpecializationMasterEntitySearch);
				tIdSpecializationInformationEntitySearch.setTIdEducationalInformation(tIdEducationalInformationEntitySearch);
				tIdSpecializationInformationEntitySearch.setActiveStatus(tIdEducationalInformation.getActiveStatus());
				tIdSpecializationInformationEntitySearch.setLockKey(tIdEducationalInformation.getLockKey());
				tIdSpecializationInformationEntitySearch.setProfileKey(tIdEducationalInformation.getProfileKey());
				tIdSpecializationInformationEntitySearchList.add(tIdSpecializationInformationEntitySearch);
			}
		} else if(tIdEducationalInformation.getPeiSpecialization()!=null) {
			for(Long  specializationKey :tIdEducationalInformation.getPeiSpecialization()){
				tIdSpecializationInformationEntitySearch=new TIdSpecializationInformationEntitySearch();
				tIdSpecializationMasterEntitySearch=tIdSpecializationMasterSearchJpaRepository.findOne(specializationKey);
				tIdSpecializationInformationEntitySearch.setTIdSpecializationMaster(tIdSpecializationMasterEntitySearch);
				tIdSpecializationInformationEntitySearch.setTIdEducationalInformation(tIdEducationalInformationEntitySearch);
				tIdSpecializationInformationEntitySearch.setActiveStatus(tIdEducationalInformation.getActiveStatus());
				tIdSpecializationInformationEntitySearch.setLockKey(tIdEducationalInformation.getLockKey());
				tIdSpecializationInformationEntitySearch.setProfileKey(tIdEducationalInformation.getProfileKey());
				tIdSpecializationInformationEntitySearchList.add(tIdSpecializationInformationEntitySearch);
			}
		}
		
		tIdEducationalInformationEntitySearch.setListOfTIdSpecializationInformation(tIdSpecializationInformationEntitySearchList);
		
		tIdEducationalInformationEntitySearch.setPeiFromMonth(tIdEducationalInformation.getPeiFromMonth());
		tIdEducationalInformationEntitySearch.setPeiFromYear(tIdEducationalInformation.getPeiFromYear());
		tIdEducationalInformationEntitySearch.setPeiToMonth(tIdEducationalInformation.getPeiToMonth());
		tIdEducationalInformationEntitySearch.setPeiToYear(tIdEducationalInformation.getPeiToYear());
		tIdEducationalInformationEntitySearch.setPeiRemarks(tIdEducationalInformation.getPeiRemarks());
		tIdEducationalInformationEntitySearch.setLockKey(tIdEducationalInformation.getLockKey());
		tIdEducationalInformationEntitySearch.setProfileKey(tIdEducationalInformation.getProfileKey());
		tIdEducationalInformationEntitySearch.setActiveStatus(tIdEducationalInformation.getActiveStatus());
		
		tIdEducationalInformationEntitySearchList.add(tIdEducationalInformationEntitySearch);
		tIdPersonalInformationEntitySearch.setListOfTIdEducationalInformation(tIdEducationalInformationEntitySearchList);
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdEducationalInformation.getPeiKey() == null) {
			tIdLandingEducationJpaRepository.updateLatestUpdate(tIdEducationalInformation.getAuditJson(), 
					tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation().get(0).getPeiKey());
		}
		
		tIdEducationalInformation.setPeiKey(tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation().get(0).getPeiKey());
		return tIdEducationalInformation;
	}
	
	@Override
	public TIdExperienceInformation saveExperienceInfo(TIdExperienceInformation tIdExperienceInformation) throws Exception{
		
		TIdCompanyMasterEntitySearch tIdCompanyMasterEntitySearch = null;
		TIdFunctionalAreaMasterEntitySearch tIdFunctionalAreaMasterEntitySearch = null;
		TIdDesignationMasterEntitySearch tIdDesignationMasterEntitySearch = null;
		TIdReferenceCodesHeaderEntity tIdReferenceCodesHeader = null;
		TIdReferenceCodesDetailEntity  tIdReferenceCodesDetail = null;
		TIdReferenceCodesDetailEntity tIdReferenceCodesDetailEntity=null;
		TIdCityMasterEntitySearch tIdCityMasterEntitySearch=null;
		List<TIdCityMasterEntitySearch> tIdCityMasterEntitySearchList=null;
		TIdStateMasterEntitySearch tIdStateMasterEntitySearch=null;
		List<TIdStateMasterEntitySearch> tIdStateMasterEntitySearchList=null;
		TIdCountryMasterEntitySearch tIdCountryMasterEntitySearch=null;
		TIdCompanyIndustryLinkEntitySearch tIdCompanyIndustryLinkEntitySearch=null;
		TIdBusinessTypeMasterEntitySearch tIdBusinessTypeMasterEntitySearch=null;
		List<TIdCompanyIndustryLinkEntitySearch> tIdCompanyIndustryLinkEntitySearchList=new ArrayList<TIdCompanyIndustryLinkEntitySearch>();
		
		List<TIdExperienceInformationEntitySearch> tIdExperienceInformationEntitySearchList = new ArrayList<TIdExperienceInformationEntitySearch>();
		
		if(tIdExperienceInformation.getOtherCompanyCmsName()!=null) {
			if(tIdExperienceInformation.getPexCompanyCmsKey()!=null && tIdExperienceInformation.getPexCompanyCmsKey()!=0) {
				tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.findByNameAndCompanyKeyNotIn(tIdExperienceInformation.getOtherCompanyCmsName(), tIdExperienceInformation.getPexCompanyCmsKey());
			        if(tIdCompanyMasterEntitySearch!=null) {
			        	if(tIdCompanyMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdCompanyMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
			        			||tIdCompanyMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
			        		tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			        		tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
			        		tIdExperienceInformation.setPexCompanyCmsKey(tIdCompanyMasterEntitySearch.getCompanyKey());
			        		tIdExperienceInformation.setOtherCompanyCmsName(null);
		        		} else {
							throw new DataIntegrityViolationException("Company name already exist!!!");
		        		  }

					} else {
						tIdCompanyMasterEntitySearch = tIdCompanyMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexCompanyCmsKey());
						tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdCompanyMasterEntitySearch.setName(tIdExperienceInformation.getOtherCompanyCmsName());
						tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
						tIdExperienceInformation.setOtherCompanyCmsName(null);
					}
			}
			else {
				tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.findByName(tIdExperienceInformation.getOtherCompanyCmsName());
				if(tIdCompanyMasterEntitySearch!=null){
					if(tIdCompanyMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdCompanyMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) 
						|| tIdCompanyMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
						tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
		        		tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
						tIdExperienceInformation.setPexCompanyCmsKey(tIdCompanyMasterEntitySearch.getCompanyKey());
						tIdExperienceInformation.setOtherCompanyCmsName(null);
					} else {
						throw new DataIntegrityViolationException("Company name already exist!!!");
					}
					
					}
				}
			}
		
		if(tIdExperienceInformation.getOtherCityName()!=null){
			if(tIdExperienceInformation.getPexCityKey()!=null && tIdExperienceInformation.getPexCityKey()!=0) {
				tIdCityMasterEntitySearchList=tIdCityMasterEntitySearchJpaRepository.findByNameAndKeyNotIn(tIdExperienceInformation.getOtherCityName(), tIdExperienceInformation.getPexCityKey());
		        if(tIdCityMasterEntitySearchList.size()>0) {
		        	if(tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdCityMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
		        		tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearchList);
	        			tIdExperienceInformation.setPexCityKey(tIdCityMasterEntitySearchList.get(0).getKey());
	        			tIdExperienceInformation.setOtherCityName(null);
	        		} else {
	        			throw new DataIntegrityViolationException("City name already exist!!!");
	        		}
		        	
				} else {
					tIdCityMasterEntitySearch = tIdCityMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexCityKey());
					tIdCityMasterEntitySearch.setName(tIdExperienceInformation.getOtherCityName());
					tIdCityMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdCityMasterEntitySearch=tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearch);
					tIdExperienceInformation.setOtherCityName(null);
				}
				} else {
					tIdCityMasterEntitySearchList=tIdCityMasterEntitySearchJpaRepository.findByName(tIdExperienceInformation.getOtherCityName());
					if(tIdCityMasterEntitySearchList.size()>0){
						if(tIdCityMasterEntitySearchList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS)|| tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) 
						{
							tIdCityMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
			        		tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearchList);
							tIdExperienceInformation.setPexCityKey(tIdCityMasterEntitySearchList.get(0).getKey());
							tIdExperienceInformation.setOtherCityName(null);
						} else {
							throw new DataIntegrityViolationException("City name already exist!!!");
						}
						}
					}
				}
		if(tIdExperienceInformation.getOtherStateName()!=null) {
			if(tIdExperienceInformation.getPexStateKey() !=null && tIdExperienceInformation.getPexStateKey()!=0) {
				tIdStateMasterEntitySearchList=tIdStateMasterSearchJpaRepository.findByNameAndKeyNotIn(tIdExperienceInformation.getOtherStateName(),tIdExperienceInformation.getPexStateKey());
		        if(tIdStateMasterEntitySearchList.size()>0) {
		        	if(tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdStateMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
		        		tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearchList);
		        		tIdExperienceInformation.setPexStateKey(tIdStateMasterEntitySearchList.get(0).getKey());
		        		tIdExperienceInformation.setOtherStateName(null);
	        		} else {
		        			throw new DataIntegrityViolationException("State name already exist!!!");
        		  }
		        	
				} else {
					tIdStateMasterEntitySearch = tIdStateMasterSearchJpaRepository.findOne(tIdExperienceInformation.getPexStateKey());
					tIdStateMasterEntitySearch.setName(tIdExperienceInformation.getOtherStateName());
					tIdStateMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdStateMasterEntitySearch=tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearch);
					tIdExperienceInformation.setOtherStateName(null);
				}
			} else { 
				tIdStateMasterEntitySearchList = tIdStateMasterSearchJpaRepository.findByName(tIdExperienceInformation.getOtherStateName());
				if(tIdStateMasterEntitySearchList.size()>0) {
					if(tIdStateMasterEntitySearchList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS)|| tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) 
						{
							tIdStateMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
							tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearchList);
							tIdExperienceInformation.setPexStateKey(tIdStateMasterEntitySearchList.get(0).getKey());
							tIdExperienceInformation.setOtherStateName(null);
						} else {
							throw new DataIntegrityViolationException("State name already exist!!!");
						}
					}
				}
			}
		
		if(tIdExperienceInformation.getOtherRoleName()!=null) {
			if(tIdExperienceInformation.getPexRoleKey()!=null && tIdExperienceInformation.getPexRoleKey()!=0) {
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Role");
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValueAndRcdDetailKeyNotIn(tIdReferenceCodesHeader.getRchHeaderKey(), tIdExperienceInformation.getOtherRoleName(), tIdExperienceInformation.getPexRoleKey());
		        if(tIdReferenceCodesDetailEntity!=null) {
		        	if(tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS) 
		        			||tIdReferenceCodesDetailEntity.getActiveStatus().equals(PENDING_STATUS)){
		        			tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
		        			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
		        			tIdExperienceInformation.setPexRoleKey(tIdReferenceCodesDetailEntity.getRcdDetailKey());
		        			tIdExperienceInformation.setOtherRoleName(null);
		        		} else {
		        			throw new DataIntegrityViolationException("Role name already exist!!!");
		        		  }
				} else {
					tIdReferenceCodesDetailEntity = tIdReferenceCodesDetailJpaRepository.findOne(tIdExperienceInformation.getPexRoleKey());
					tIdReferenceCodesDetailEntity.setRcdValue(tIdExperienceInformation.getOtherRoleName());
					tIdReferenceCodesDetailEntity.setRcdAbbreviation(tIdExperienceInformation.getOtherRoleName());
					tIdReferenceCodesDetailEntity.setRcdMeaning(tIdExperienceInformation.getOtherRoleName());
					tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
					tIdExperienceInformation.setOtherRoleName(null);
				}
				
			}else {
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Role");
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(), tIdExperienceInformation.getOtherRoleName());
				if(tIdReferenceCodesDetailEntity!=null){
						if(tIdReferenceCodesDetailEntity.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) 
							|| tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
		        			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
							tIdExperienceInformation.setPexRoleKey(tIdReferenceCodesDetailEntity.getRcdDetailKey());
		        			tIdExperienceInformation.setOtherRoleName(null);
						} else {
							throw new DataIntegrityViolationException("Role name already exist!!!");
						}
						
					}
				}
			}
		
		if(tIdExperienceInformation.getOtherDesignationName()!=null) {
			if(tIdExperienceInformation.getPexDesignationKey()!=null && tIdExperienceInformation.getPexDesignationKey()!=0)
			{
				tIdDesignationMasterEntitySearch = tIdDesignationMasterEntitySearchJpaRepository.findByNameAndKeyNotIn(tIdExperienceInformation.getOtherDesignationName(), tIdExperienceInformation.getPexDesignationKey());
			        if(tIdDesignationMasterEntitySearch!=null) {
			        	if(tIdDesignationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdDesignationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
			        			||tIdDesignationMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
			        		tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			        		tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
			        		tIdExperienceInformation.setPexDesignationKey(tIdDesignationMasterEntitySearch.getKey());
			        		tIdExperienceInformation.setOtherDesignationName(null);
			        	} else {
							throw new DataIntegrityViolationException("Designation name already exist!!!");
						}
					} else {
						tIdDesignationMasterEntitySearch = tIdDesignationMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexDesignationKey());
						tIdDesignationMasterEntitySearch.setName(tIdExperienceInformation.getOtherDesignationName());
						tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
						tIdExperienceInformation.setOtherDesignationName(null);
					}
			}else {
				 tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.findByName(tIdExperienceInformation.getOtherDesignationName());
					if(tIdDesignationMasterEntitySearch!=null){
						if(tIdDesignationMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdDesignationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) 
								|| tIdDesignationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
							tIdExperienceInformation.setPexDesignationKey(tIdDesignationMasterEntitySearch.getKey());
							tIdExperienceInformation.setOtherDesignationName(null);
						} else {
								throw new DataIntegrityViolationException("Designation name already exist!!!");
						}
				}
			}
			
		}
		
		if(tIdExperienceInformation.getOtherFunctionalAreaName()!=null) {
			if(tIdExperienceInformation.getPexFunctionalAreaKey()!=null && tIdExperienceInformation.getPexFunctionalAreaKey()!=0) {
				tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.findByNameAndFunctionKeyNotIn(tIdExperienceInformation.getOtherFunctionalAreaName(), tIdExperienceInformation.getPexFunctionalAreaKey());
			        if(tIdFunctionalAreaMasterEntitySearch!=null) {
			        	if(tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS))
			        	{
			        		tIdFunctionalAreaMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			        		tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.save(tIdFunctionalAreaMasterEntitySearch);
			        		tIdExperienceInformation.setPexFunctionalAreaKey(tIdFunctionalAreaMasterEntitySearch.getFunctionKey());
			        		tIdExperienceInformation.setOtherFunctionalAreaName(null);
			        	} else {
			        		throw new DataIntegrityViolationException("Functional name already exist!!!");
			        	  }
					} else {
						tIdFunctionalAreaMasterEntitySearch = tIdFunctionalAreaMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexFunctionalAreaKey());
						tIdFunctionalAreaMasterEntitySearch.setName(tIdExperienceInformation.getOtherFunctionalAreaName());
						tIdFunctionalAreaMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.save(tIdFunctionalAreaMasterEntitySearch);
						tIdExperienceInformation.setOtherFunctionalAreaName(null);
					}
			}
			else {
				tIdFunctionalAreaMasterEntitySearch = tIdFunctionalAreaMasterEntitySearchJpaRepository.findByName(tIdExperienceInformation.getOtherFunctionalAreaName());
				if(tIdFunctionalAreaMasterEntitySearch!=null){
					if(tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) 
								|| tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdFunctionalAreaMasterEntitySearch.setActiveStatus(PENDING_STATUS);
		        			tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.save(tIdFunctionalAreaMasterEntitySearch);
							tIdExperienceInformation.setPexFunctionalAreaKey(tIdFunctionalAreaMasterEntitySearch.getFunctionKey());
							tIdExperienceInformation.setOtherFunctionalAreaName(null);
							} else {
								throw new DataIntegrityViolationException("Functional name already exist!!!");
							}
					}
				}
			}
			 
		//*************************Some thing wrong 
		if(tIdExperienceInformation.getOtherIndustryName()!=null) {
			tIdBusinessTypeMasterEntitySearch=tIdBusinessTypeMasterEntitySearchJpaRepository.findByName(tIdExperienceInformation.getOtherIndustryName());
			if(tIdBusinessTypeMasterEntitySearch!=null){
				if(tIdBusinessTypeMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdBusinessTypeMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
						||tIdBusinessTypeMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
					
					tIdBusinessTypeMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdBusinessTypeMasterEntitySearchJpaRepository.save(tIdBusinessTypeMasterEntitySearch);
					List<Long> listOfPexBusinessTypeKey = new ArrayList<Long>();
					listOfPexBusinessTypeKey.add(tIdBusinessTypeMasterEntitySearch.getBtmKey());
					tIdExperienceInformation.setListOfPexBusinessTypeKey(listOfPexBusinessTypeKey);
					tIdExperienceInformation.setOtherIndustryName(null);
				} else {
					throw new DataIntegrityViolationException("Industry name already exist!!!");
				}
			}
		}
		
		if (("Y").equals(tIdExperienceInformation.getPexCurrentlyWorking())) {
			List<PersonIndividualExperienceViewEntity> listOfPersonIndividualExperienceViewEntity=null;
			Long designKey = null, functionKey = null, roleKey = null, companyKey = null;
			TIdPersonalInformationEntity tIdPersonalInformationEntity = tIdPersonalInformationJpaRepository.findOne(tIdExperienceInformation.getPexPinKey());
			if(tIdPersonalInformationEntity!=null){
				designKey = tIdExperienceInformation.getPexDesignationKey();
				functionKey = tIdExperienceInformation.getPexFunctionalAreaKey();
				roleKey = tIdExperienceInformation.getPexRoleKey();
				companyKey = tIdExperienceInformation.getPexCompanyCmsKey();
				if(tIdPersonalInformationEntity.getPinFirstName()!=null && !tIdPersonalInformationEntity.getPinFirstName().isEmpty()) {
					if(functionKey!=null && roleKey!=null) {
						listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.
								findByPinFirstNameAndPinLastNameAndDesignationKeyAndFunctionalAreaKeyAndRoleKeyAndCompanyKeyAndPinKeyNotIn(
								tIdPersonalInformationEntity.getPinFirstName(),tIdPersonalInformationEntity.getPinLastName(),
								designKey,functionKey,roleKey, companyKey,tIdExperienceInformation.getPexPinKey());
					} else if(functionKey!=null) {
						listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.
								findByPinFirstNameAndPinLastNameAndDesignationKeyAndFunctionalAreaKeyAndCompanyKeyAndPinKeyNotIn(
								tIdPersonalInformationEntity.getPinFirstName(),tIdPersonalInformationEntity.getPinLastName(),
								designKey,functionKey,companyKey,tIdExperienceInformation.getPexPinKey());
					} else if(roleKey!=null) {
						listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.
								findByPinFirstNameAndPinLastNameAndDesignationKeyAndRoleKeyAndCompanyKeyAndPinKeyNotIn(
								tIdPersonalInformationEntity.getPinFirstName(),tIdPersonalInformationEntity.getPinLastName(),
								designKey,roleKey, companyKey,tIdExperienceInformation.getPexPinKey());
					} else {
						listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.
								findByPinFirstNameAndPinLastNameAndDesignationKeyAndCompanyKeyAndPinKeyNotIn(
								tIdPersonalInformationEntity.getPinFirstName(),tIdPersonalInformationEntity.getPinLastName(),
								designKey,companyKey,tIdExperienceInformation.getPexPinKey());
					}
					if(listOfPersonIndividualExperienceViewEntity.size()>0) {
						throw new HandledException("Same User name,designation,function and company already exist::"+
								String.valueOf(listOfPersonIndividualExperienceViewEntity.get(0).getPinKey()+"-"+listOfPersonIndividualExperienceViewEntity.get(0).getProfileKey()));  
					}
				}
			}
			tIdExperienceInformationJpaRepository.updateCurrentWorkingStatus(tIdExperienceInformation.getPexPinKey(), "N");
		} 
		
		if(tIdExperienceInformation.getPexKey()!=null) {
			tIdCompanyIndustryLinkJpaRepository.delete(tIdCompanyIndustryLinkJpaRepository.findByCilPexKey(tIdExperienceInformation.getPexKey()));
		}
		
		TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch =new TIdExperienceInformationEntitySearch();
		tIdExperienceInformationEntitySearch.setPexKey(tIdExperienceInformation.getPexKey());
		
		TIdPersonalInformationEntitySearch  tIdPersonalInformationEntitySearch =tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexPinKey());
		tIdExperienceInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		
		
		if(tIdExperienceInformation.getOtherCompanyCmsName()!=null) // saving other company
		{
			tIdCompanyMasterEntitySearch = new TIdCompanyMasterEntitySearch();
			tIdCompanyMasterEntitySearch.setName(tIdExperienceInformation.getOtherCompanyCmsName());
			tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdCompanyMasterEntitySearch.setCompanyGroup(PENDING_STATUS);
			tIdCompanyMasterEntitySearch.setLockKey(0L);
			tIdCompanyMasterEntitySearch.setActiveFrom(new Date());
			tIdCompanyMasterEntitySearch.setProfileKey(1L);
			tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
			tIdExperienceInformation.setOtherCompanyCmsKey(tIdCompanyMasterEntitySearch.getCompanyKey());
			tIdExperienceInformationEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearch);
			
		} else if(tIdExperienceInformation.getPexCompanyCmsKey()!=null){
			tIdCompanyMasterEntitySearch =tIdCompanyMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexCompanyCmsKey());
			tIdExperienceInformationEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearch);
		}
		
		if(tIdExperienceInformation.getOtherCityName()!=null){
			tIdCityMasterEntitySearch=new TIdCityMasterEntitySearch();
			tIdCityMasterEntitySearch.setActiveFrom(new Date());
			tIdCityMasterEntitySearch.setName(tIdExperienceInformation.getOtherCityName());
			tIdCityMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdCityMasterEntitySearch.setLockKey(0L);
			tIdCityMasterEntitySearch.setProfileKey(1l);
			tIdCountryMasterEntitySearch=tIdCountryMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexCountryKey());
			tIdCityMasterEntitySearch.setTIdCountryMasterSearch(tIdCountryMasterEntitySearch);
			tIdCityMasterEntitySearch=tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearch);
			tIdExperienceInformationEntitySearch.setTIdCityMasterSearch(tIdCityMasterEntitySearch);
			
		} else if(tIdExperienceInformation.getPexCityKey()!=null){
			tIdExperienceInformationEntitySearch.setTIdCityMasterSearch(tIdCityMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexCityKey()));
		}
		
		if(tIdExperienceInformation.getOtherStateName()!=null) {
			tIdStateMasterEntitySearch = new TIdStateMasterEntitySearch();
			tIdStateMasterEntitySearch.setName(tIdExperienceInformation.getOtherStateName());
			tIdStateMasterEntitySearch.setStateAbbreviation(tIdExperienceInformation.getOtherStateName());
			tIdStateMasterEntitySearch.setStateCountryKey(tIdExperienceInformation.getPexCountryKey());
			tIdStateMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdStateMasterEntitySearch.setActiveFrom(new Date());
			tIdStateMasterEntitySearch.setLockKey(0L);
			tIdStateMasterEntitySearch.setProfileKey(1l);
			tIdStateMasterEntitySearch = tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearch);
			tIdExperienceInformationEntitySearch.setTIdStateMasterSearch(tIdStateMasterEntitySearch);

		} else if(tIdExperienceInformation.getPexStateKey()!=null){
			tIdStateMasterEntitySearch=tIdStateMasterSearchJpaRepository.findOne(tIdExperienceInformation.getPexStateKey());
			tIdExperienceInformationEntitySearch.setTIdStateMasterSearch(tIdStateMasterEntitySearch);
		}
		if(tIdExperienceInformation.getPexCountryKey()!=null){
			tIdCountryMasterEntitySearch=tIdCountryMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexCountryKey());
			tIdExperienceInformationEntitySearch.setTIdCountryMasterSearch(tIdCountryMasterEntitySearch);
		}
		
		if(tIdExperienceInformation.getOtherRoleName()!=null)
		{
			tIdReferenceCodesDetail = new TIdReferenceCodesDetailEntity();
			tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Role");
			tIdReferenceCodesDetail.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
			tIdReferenceCodesDetail.setRcdAbbreviation(tIdExperienceInformation.getOtherRoleName());
			tIdReferenceCodesDetail.setRcdValue(tIdExperienceInformation.getOtherRoleName());
			tIdReferenceCodesDetail.setRcdMeaning(tIdExperienceInformation.getOtherRoleName());
			tIdReferenceCodesDetail.setRcdLowRange(0L);
			tIdReferenceCodesDetail.setRcdHighRange(0L);
			tIdReferenceCodesDetail.setRcdOrderBy(0L);
			tIdReferenceCodesDetail.setActiveStatus(PENDING_STATUS);
			tIdReferenceCodesDetail.setRcdSetAsDefault("N");
			tIdReferenceCodesDetail.setProfileKey(1L);
			tIdReferenceCodesDetail.setLockKey(0L);
			tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetail);
			tIdExperienceInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
			
		} else if(tIdExperienceInformation.getPexRoleKey()!=null){
			tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.findOne(tIdExperienceInformation.getPexRoleKey());
			tIdExperienceInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
		}
		
		if(tIdExperienceInformation.getOtherDesignationName()!=null) // saving other designation
		{
			tIdDesignationMasterEntitySearch=new TIdDesignationMasterEntitySearch();
			tIdDesignationMasterEntitySearch.setName(tIdExperienceInformation.getOtherDesignationName());
			tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdDesignationMasterEntitySearch.setDesigActiveFlag(0L);
			tIdDesignationMasterEntitySearch.setLockKey(0L);
			tIdDesignationMasterEntitySearch.setProfileKey(1L);
			tIdDesignationMasterEntitySearch.setActiveFrom(new Date());
			tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
			tIdExperienceInformation.setOtherDesignationKey(tIdDesignationMasterEntitySearch.getKey());
			tIdExperienceInformationEntitySearch.setTIdDesignationMaster(tIdDesignationMasterEntitySearch);
			
		} else	if(tIdExperienceInformation.getPexDesignationKey()!=null){
			tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexDesignationKey());
			tIdExperienceInformationEntitySearch.setTIdDesignationMaster(tIdDesignationMasterEntitySearch);
		}
		
		if(tIdExperienceInformation.getOtherFunctionalAreaName()!=null) // saving other functional area
		{
			tIdFunctionalAreaMasterEntitySearch = new TIdFunctionalAreaMasterEntitySearch();
			tIdFunctionalAreaMasterEntitySearch.setName(tIdExperienceInformation.getOtherFunctionalAreaName());
			tIdFunctionalAreaMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdFunctionalAreaMasterEntitySearch.setFunctionActiveStatusKey(1L);
			tIdFunctionalAreaMasterEntitySearch.setLockKey(0L);
			tIdFunctionalAreaMasterEntitySearch.setProfileKey(1L);
			tIdFunctionalAreaMasterEntitySearch.setActiveFrom(new Date());
			tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.save(tIdFunctionalAreaMasterEntitySearch);
			tIdExperienceInformation.setOtherFunctionalAreaKey(tIdFunctionalAreaMasterEntitySearch.getFunctionKey());
			tIdExperienceInformationEntitySearch.setTIdFunctionalAreaMaster(tIdFunctionalAreaMasterEntitySearch);
			
		} else if(tIdExperienceInformation.getPexFunctionalAreaKey()!=null){
			tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.findOne(tIdExperienceInformation.getPexFunctionalAreaKey());
			tIdExperienceInformationEntitySearch.setTIdFunctionalAreaMaster(tIdFunctionalAreaMasterEntitySearch);
		}
		
		tIdExperienceInformationEntitySearch.setPexFromMonth(tIdExperienceInformation.getPexFromMonth());
		tIdExperienceInformationEntitySearch.setPexFromYear(tIdExperienceInformation.getPexFromYear());
		tIdExperienceInformationEntitySearch.setPexToMonth(tIdExperienceInformation.getPexToMonth());
		tIdExperienceInformationEntitySearch.setPexToYear(tIdExperienceInformation.getPexToYear());
		tIdExperienceInformationEntitySearch.setPexExperienceYears(tIdExperienceInformation.getPexExperienceYears());
		tIdExperienceInformationEntitySearch.setPexCurrentlyWorking(tIdExperienceInformation.getPexCurrentlyWorking());
		tIdExperienceInformationEntitySearch.setPexRemarks(tIdExperienceInformation.getPexRemarks());
		tIdExperienceInformationEntitySearch.setLockKey(tIdExperienceInformation.getLockKey());
		tIdExperienceInformationEntitySearch.setActiveStatus(tIdExperienceInformation.getActiveStatus());
		tIdExperienceInformationEntitySearch.setProfileKey(tIdExperienceInformation.getProfileKey());
		
		if(tIdExperienceInformation.getOtherIndustryName()!=null){
			tIdCompanyIndustryLinkEntitySearch = new TIdCompanyIndustryLinkEntitySearch();
			tIdBusinessTypeMasterEntitySearch=new TIdBusinessTypeMasterEntitySearch();
			tIdBusinessTypeMasterEntitySearch.setName(tIdExperienceInformation.getOtherIndustryName());
			tIdBusinessTypeMasterEntitySearch.setLockKey(0L);
			tIdBusinessTypeMasterEntitySearch.setProfileKey(1L);
			tIdBusinessTypeMasterEntitySearch.setActiveFrom(new Date());
			tIdBusinessTypeMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdBusinessTypeMasterEntitySearch=tIdBusinessTypeMasterEntitySearchJpaRepository.save(tIdBusinessTypeMasterEntitySearch);
			tIdCompanyIndustryLinkEntitySearch.settIdBusinessTypeMasterEntitySearch(tIdBusinessTypeMasterEntitySearch);
			tIdCompanyIndustryLinkEntitySearch.settIdExperienceInformationEntitySearch(tIdExperienceInformationEntitySearch);
			tIdCompanyIndustryLinkEntitySearch.setCilLockKey(tIdExperienceInformation.getLockKey());
			tIdCompanyIndustryLinkEntitySearchList.add(tIdCompanyIndustryLinkEntitySearch);
		
		} else if(tIdExperienceInformation.getListOfPexBusinessTypeKey()!=null){
			
			for(Long pexBusinessTypeKey : tIdExperienceInformation.getListOfPexBusinessTypeKey() ){
				tIdBusinessTypeMasterEntitySearch=tIdBusinessTypeMasterEntitySearchJpaRepository.findOne(pexBusinessTypeKey);
				tIdCompanyIndustryLinkEntitySearch =new TIdCompanyIndustryLinkEntitySearch();
				tIdCompanyIndustryLinkEntitySearch.settIdBusinessTypeMasterEntitySearch(tIdBusinessTypeMasterEntitySearch);
				tIdCompanyIndustryLinkEntitySearch.settIdExperienceInformationEntitySearch(tIdExperienceInformationEntitySearch);
				tIdCompanyIndustryLinkEntitySearch.setCilLockKey(tIdExperienceInformation.getLockKey());
				tIdCompanyIndustryLinkEntitySearchList.add(tIdCompanyIndustryLinkEntitySearch);
			}
		}
		
		tIdExperienceInformationEntitySearch.setListOfTIdCompanyIndustryLinkEntitySearch(tIdCompanyIndustryLinkEntitySearchList);
		tIdExperienceInformationEntitySearchList.add(tIdExperienceInformationEntitySearch);
		tIdPersonalInformationEntitySearch.setListOfTIdExperienceInformation(tIdExperienceInformationEntitySearchList);
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdExperienceInformation.getPexKey() == null) {
			tIdLandingExperienceJpaRepository.updateLatestUpdate(tIdExperienceInformation.getAuditJson(), 
					tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation().get(0).getPexKey());
		}
		
		tIdExperienceInformation.setPexKey(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation().get(0).getPexKey());

		//save for t_id_personal_info_link
		TIdPersonalInfoLinkEntity tIdPersonalInfoLinkEntity = tIdPersonalInfoLinkJpaRepository.findByPilPinKey(tIdExperienceInformation.getPexPinKey());
		
		if(tIdPersonalInfoLinkEntity==null) {
			tIdPersonalInfoLinkEntity = new TIdPersonalInfoLinkEntity();
			tIdPersonalInfoLinkEntity.setPilPinKey(tIdExperienceInformation.getPexPinKey());
			tIdPersonalInfoLinkEntity.setPilPexKey(tIdExperienceInformation.getPexKey());
			tIdPersonalInfoLinkEntity.setPilCurrentlyWorking(tIdExperienceInformation.getPexCurrentlyWorking());
			tIdPersonalInfoLinkJpaRepository.save(tIdPersonalInfoLinkEntity);
		} else {
			if (("Y").equals(tIdExperienceInformation.getPexCurrentlyWorking())) {
				tIdPersonalInfoLinkEntity.setPilPexKey(tIdExperienceInformation.getPexKey());
				tIdPersonalInfoLinkEntity.setPilCurrentlyWorking(tIdExperienceInformation.getPexCurrentlyWorking());
				tIdPersonalInfoLinkJpaRepository.save(tIdPersonalInfoLinkEntity);
			}
		}
		
		return tIdExperienceInformation;
		
	}
	
	@Override
	public void saveVisitInfo(TIdVisitInformation tIdVisitInformation) throws Exception {
		
		List<TIdVisitInformationEntitySearch> tIdVisitInformationEntitySearchList=new ArrayList<TIdVisitInformationEntitySearch>();
		TIdVisitInformationEntitySearch tIdVisitInformationEntitySearch=new TIdVisitInformationEntitySearch();
		TIdReferenceCodesHeaderEntity tIdReferenceCodesHeader = null;
		TIdReferenceCodesDetailEntity tIdReferenceCodesDetailEntity=null;
		TIdVisitRemarksEntitySearch tIdVisitRemarksEntitySearch=null;
		List<TIdVisitRemarksEntitySearch> visitRemarksList=new ArrayList<TIdVisitRemarksEntitySearch>();
		
		Long contactCreatorPinKey = tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(tIdVisitInformation.getPivPinKey());
		if(contactCreatorPinKey==null || contactCreatorPinKey==0 ) {
			contactCreatorPinKey = tIdVisitInformation.getPivPinKey();
		}
		
		if(tIdVisitInformation.getOtherVisitModeName()!=null) {
			if(tIdVisitInformation.getPivVisitMode() !=null && tIdVisitInformation.getPivVisitMode() !=0) {
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Visit_Mode");
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValueAndRcdDetailKeyNotIn(tIdReferenceCodesHeader.getRchHeaderKey(), tIdVisitInformation.getOtherVisitModeName(), tIdVisitInformation.getPivVisitMode());
		        if(tIdReferenceCodesDetailEntity!=null) {
		        	if(tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS) 
		        			||tIdReferenceCodesDetailEntity.getActiveStatus().equals(PENDING_STATUS)){
		        		tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
		        		tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
		        		tIdVisitInformation.setPivVisitMode(tIdReferenceCodesDetailEntity.getRcdDetailKey());
		        		tIdVisitInformation.setOtherVisitModeName(null);

		        		} else {
		        			throw new DataIntegrityViolationException("Visit mode already exist!!!");
		        		  }
					
				} else {
					tIdReferenceCodesDetailEntity = tIdReferenceCodesDetailJpaRepository.findOne(tIdVisitInformation.getPivVisitMode());
					tIdReferenceCodesDetailEntity.setRcdValue(tIdVisitInformation.getOtherVisitModeName());
					tIdReferenceCodesDetailEntity.setRcdAbbreviation(tIdVisitInformation.getOtherVisitModeName());
					tIdReferenceCodesDetailEntity.setRcdMeaning(tIdVisitInformation.getOtherVisitModeName());
					tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
					tIdVisitInformation.setOtherVisitModeName(null);
				}
			} else {
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Visit_Mode");
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(), tIdVisitInformation.getOtherVisitModeName());
				if(tIdReferenceCodesDetailEntity!=null){
						if(tIdReferenceCodesDetailEntity.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) 
								|| tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
			        		tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
			        		tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
							tIdVisitInformation.setPivVisitMode(tIdReferenceCodesDetailEntity.getRcdDetailKey());
			        		tIdVisitInformation.setOtherVisitModeName(null);
						} else {
							throw new DataIntegrityViolationException("Visit mode already exist!!!");
						}
					}
				}
			}
		
		if(tIdVisitInformation.getOtherVisitPurposeName()!=null) {    //save other visit purpose
			if(tIdVisitInformation.getPivVisitPurpose()!=null && tIdVisitInformation.getPivVisitPurpose()!=0) {
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Visit_Mode");
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValueAndRcdDetailKeyNotIn(tIdReferenceCodesHeader.getRchHeaderKey(), tIdVisitInformation.getOtherVisitPurposeName(), tIdVisitInformation.getPivVisitPurpose());
		        if(tIdReferenceCodesDetailEntity!=null) {
		        	if(tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS) 
		        			||tIdReferenceCodesDetailEntity.getActiveStatus().equals(PENDING_STATUS)){
		        		tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
		        		tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
		        		tIdVisitInformation.setPivVisitPurpose(tIdReferenceCodesDetailEntity.getRcdDetailKey());
		        		tIdVisitInformation.setOtherVisitPurposeName(null);
		        		} else {
		        			throw new DataIntegrityViolationException("Visit purpose already exist!!!");
		        		}
					
				} else {
					tIdReferenceCodesDetailEntity = tIdReferenceCodesDetailJpaRepository.findOne(tIdVisitInformation.getPivVisitPurpose());
					tIdReferenceCodesDetailEntity.setRcdValue(tIdVisitInformation.getOtherVisitPurposeName());
					tIdReferenceCodesDetailEntity.setRcdAbbreviation(tIdVisitInformation.getOtherVisitPurposeName());
					tIdReferenceCodesDetailEntity.setRcdMeaning(tIdVisitInformation.getOtherVisitPurposeName());
					tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
					tIdVisitInformation.setOtherVisitPurposeName(null);
				}
			}
			else {
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Visit Purpose");
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(), tIdVisitInformation.getOtherVisitPurposeName());
				if(tIdReferenceCodesDetailEntity!=null) {
					if(tIdReferenceCodesDetailEntity.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) 
							|| tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
						tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
		        		tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
						tIdVisitInformation.setPivVisitPurpose(tIdReferenceCodesDetailEntity.getRcdDetailKey());
						tIdVisitInformation.setOtherVisitPurposeName(null);
					} else {
						throw new DataIntegrityViolationException("Visit purpose already exist!!!");
					}
				}
			}
		}
			
		if(tIdVisitInformation.getPivKey() != null) {
			tIdVisitRemarksJpaRepository.deleteVisitInfoDtls(tIdVisitInformation.getPivKey());
		}
		
		tIdVisitInformationServiceMapper.mapTIdVisitInformationToTIdVisitInformationEntitySearch(tIdVisitInformation, tIdVisitInformationEntitySearch);
		
		if(tIdVisitInformation.getOtherVisitModeName()!=null){     //save other visit mode
			tIdReferenceCodesDetailEntity=new TIdReferenceCodesDetailEntity();
			tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Visit_Mode");
			tIdReferenceCodesDetailEntity.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
			tIdReferenceCodesDetailEntity.setRcdAbbreviation(tIdVisitInformation.getOtherVisitModeName());
			tIdReferenceCodesDetailEntity.setRcdValue(tIdVisitInformation.getOtherVisitModeName());
			tIdReferenceCodesDetailEntity.setRcdMeaning(tIdVisitInformation.getOtherVisitModeName());
			tIdReferenceCodesDetailEntity.setRcdLowRange(0L);
			tIdReferenceCodesDetailEntity.setRcdHighRange(0L);
			tIdReferenceCodesDetailEntity.setRcdOrderBy(0L);
			tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
			tIdReferenceCodesDetailEntity.setRcdSetAsDefault("N");
			tIdReferenceCodesDetailEntity.setProfileKey(1L);
			tIdReferenceCodesDetailEntity.setLockKey(0L);
			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
			tIdVisitInformation.setOtherVisitModeKey(tIdReferenceCodesDetailEntity.getRcdDetailKey());
			tIdVisitInformationEntitySearch.setTIdReferenceCodesDetail(tIdReferenceCodesDetailEntity);
			
		} else if(tIdVisitInformation.getPivVisitMode()!=null){
			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findOne(tIdVisitInformation.getPivVisitMode());
			tIdVisitInformationEntitySearch.setTIdReferenceCodesDetail(tIdReferenceCodesDetailEntity);
		}
		
		if(tIdVisitInformation.getOtherVisitPurposeName()!=null) {    //save other visit purpose
			tIdReferenceCodesDetailEntity=new TIdReferenceCodesDetailEntity();
			tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Visit Purpose");
			tIdReferenceCodesDetailEntity.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
			tIdReferenceCodesDetailEntity.setRcdAbbreviation(tIdVisitInformation.getOtherVisitPurposeName());
			tIdReferenceCodesDetailEntity.setRcdValue(tIdVisitInformation.getOtherVisitPurposeName());
			tIdReferenceCodesDetailEntity.setRcdMeaning(tIdVisitInformation.getOtherVisitPurposeName());
			tIdReferenceCodesDetailEntity.setRcdLowRange(0L);
			tIdReferenceCodesDetailEntity.setRcdHighRange(0L);
			tIdReferenceCodesDetailEntity.setRcdOrderBy(0L);
			tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
			tIdReferenceCodesDetailEntity.setRcdSetAsDefault("N");
			tIdReferenceCodesDetailEntity.setProfileKey(1L);
			tIdReferenceCodesDetailEntity.setLockKey(0L);
			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
			tIdVisitInformation.setOtherVisitPurposeKey(tIdReferenceCodesDetailEntity.getRcdDetailKey());
			tIdVisitInformationEntitySearch.setTIdReferenceCodesDetail2(tIdReferenceCodesDetailEntity);
			
		} else if(tIdVisitInformation.getPivVisitPurpose()!=null){
			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findOne(tIdVisitInformation.getPivVisitPurpose());
			tIdVisitInformationEntitySearch.setTIdReferenceCodesDetail2(tIdReferenceCodesDetailEntity);
		}
		
		TIdPersonalInformationEntitySearch  tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdVisitInformation.getPivPinKey());
		tIdVisitInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		if (tIdVisitInformation.getListOfVisitRemarks() != null) {
			for (TIdVisitRemarks tIdVisitRemarks : tIdVisitInformation.getListOfVisitRemarks()) {
				tIdVisitRemarksEntitySearch=genericServiceMapper.map(tIdVisitRemarks, TIdVisitRemarksEntitySearch.class);		
				tIdVisitRemarksEntitySearch.settIdVisitInformationSearch(tIdVisitInformationEntitySearch);		
				visitRemarksList.add(tIdVisitRemarksEntitySearch);
			}

		}
		tIdVisitInformationEntitySearch.setListOfVisitRemarks(visitRemarksList);
		tIdVisitInformationEntitySearchList.add(tIdVisitInformationEntitySearch);
		tIdPersonalInformationEntitySearch.setListOfTIdVisitInformation(tIdVisitInformationEntitySearchList);
		tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdVisitInformation.getPivKey() == null) {
			tIdLandingDiscussionDtlsJpaRepository.updateLatestUpdate(tIdVisitInformation.getAuditJson(), 
					tIdPersonalInformationEntitySearch.getListOfTIdVisitInformation().get(0).getPivKey());
		}
		tIdVisitInformation.setPivKey(tIdPersonalInformationEntitySearch.getListOfTIdVisitInformation().get(0).getPivKey());
	}
	
	@Override
	public TIdVisitInformation discussionMailConf(TIdVisitInformation tIdVisitInformation) {
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=null;
		TIdVisitInformationViewEntity tIdVisitInformationViewEntity = tIdVisitInformationViewJpaRepository.findOne(tIdVisitInformation.getPivKey());
		
		Map<String,Object> vmValues = new HashMap<String, Object>();
		vmValues.put("discussedBy",tIdVisitInformationViewEntity.getVisitedBy());
		vmValues.put("discussedWith",tIdVisitInformationViewEntity.getName());
		vmValues.put("relationship",tIdVisitInformationViewEntity.getPivVisitedRelation()+" of "+tIdVisitInformationViewEntity.getPivVisitedCompany());
		vmValues.put("discussionDate",tIdVisitInformationViewEntity.getPivVisitedDate());
		vmValues.put("venue",tIdVisitInformationViewEntity.getVisitMode());
		vmValues.put("purpose",tIdVisitInformationViewEntity.getPivVisitedPurpose());
		vmValues.put("priority",tIdVisitInformationViewEntity.getPriorityName());
		vmValues.put("discussionNote",tIdVisitInformationViewEntity.getPivVisitNotes());
		vmValues.put("url",domainUrl);
		//String pinEmailFrom = null;
		//String toAddress = null;
		
		if(tIdVisitInformationViewEntity.getPivVisitedPinKey()!=null && tIdVisitInformationViewEntity.getPivVisitedPinKey()!=0){
			tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdVisitInformationViewEntity.getPivVisitedPinKey());
			if(!(PENDING_STATUS).equals(tIdVisitInformationViewEntity.getActiveStatus())) {
				if(tIdPersonalInformationEntitySearch!=null && tIdPersonalInformationEntitySearch.getPinEmail()!=null) {
					//pinEmailFrom = tIdPersonalInformationEntitySearch.getPinEmail();
					vmValues.put("fromUserName", tIdPersonalInformationEntitySearch.getPinFirstName()+" "+tIdPersonalInformationEntitySearch.getPinLastName());
				} else {
					//pinEmailFrom = "discussion@info.com";
					vmValues.put("fromUserName", "Discussion");
				}
				vmValues.put("fromPinKey",tIdVisitInformationViewEntity.getPivVisitedPinKey());
				vmValues.put("remarks", "For more details click here");
				vmValues.put("param", "");
			} else {
				vmValues.put("remarks", "For approval/Rejection, Kindly click here");
				vmValues.put("param", "?pivKey="+ParametersHash.encode(tIdVisitInformationViewEntity.getPivKey().toString()));
			}
		}
		
		TIdPersonalInformationEntitySearch secretarySearch = null;
		if(tIdVisitInformationViewEntity.getPivSecretary()!=null && tIdVisitInformationViewEntity.getPivSecretary()!=0){
			secretarySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdVisitInformationViewEntity.getPivSecretary());
		}
		
		if((PENDING_STATUS).equals(tIdVisitInformationViewEntity.getActiveStatus())) {
			if(secretarySearch!=null && secretarySearch.getPinEmail()!=null) {
				//pinEmailFrom = secretarySearch.getPinEmail();
				vmValues.put("fromUserName", secretarySearch.getPinFirstName()+" "+secretarySearch.getPinLastName());
			} else {
				//pinEmailFrom = "discussion@info.com";
				vmValues.put("fromUserName", "Discussion");
			}
			vmValues.put("fromPinKey",tIdVisitInformationViewEntity.getPivSecretary());
			
			/*
			if(tIdPersonalInformationEntitySearch!=null && tIdPersonalInformationEntitySearch.getPinEmail()!=null) {
				toAddress = tIdPersonalInformationEntitySearch.getPinEmail();
			} 
			*/
			vmValues.put("toPinKey",tIdVisitInformationViewEntity.getPivVisitedPinKey());
			
			
		} else if(("R").equals(tIdVisitInformationViewEntity.getActiveStatus())) {
			/*
			if(secretarySearch!=null && secretarySearch.getPinEmail()!=null) {
				toAddress = secretarySearch.getPinEmail();
			}
			*/
			vmValues.put("toPinKey",tIdVisitInformationViewEntity.getPivSecretary());
			
		} else {
			/*
			if(tIdVisitInformationViewEntity.getEmail()!=null){
				toAddress = tIdVisitInformationViewEntity.getEmail();
			}*/
			vmValues.put("toPinKey",tIdVisitInformation.getPivPinKey());
		} 
		
		/*String[] fromAddresslist=pinEmailFrom.split(",");
	 	
		if(toAddress!=null) {
			String[] toAddresslist=toAddress.split(",");
			templateService.createMailTemplateAndSend("DISCUSSION", fromAddresslist[0], toAddresslist, vmValues, null);		
		}*/
		
		return tIdVisitInformation;
	}
	
	@Override
	public TIdAdditionalInformation saveAdditionalInfo(TIdAdditionalInformation tIdAdditionalInformation) {
		TIdCityMasterEntity tIdCityMasterEntity=null;
		List<TIdCityMasterEntity> tIdCityMasterEntityList=null;
		TIdStateMasterEntity tIdStateMasterEntity=null;
		List<TIdStateMasterEntity> tIdStateMasterEntityList=null;
		TIdAdditionalInformationEntitySearch tIdAdditionalInformationEntitySearch =new TIdAdditionalInformationEntitySearch();
		List<TIdAdditionalInformationEntitySearch> tIdAdditionalInformationEntitySearchList=new  ArrayList<TIdAdditionalInformationEntitySearch>();
		
		if(tIdAdditionalInformation.getOtherCityName()!=null){
			if(tIdAdditionalInformation.getPiadCityKey() !=null && tIdAdditionalInformation.getPiadCityKey() !=0) {
		        tIdCityMasterEntityList=tIdCityMasterJpaRepository.findByNameAndKeyNotIn(tIdAdditionalInformation.getOtherCityName(), tIdAdditionalInformation.getPiadCityKey());
		        if(tIdCityMasterEntityList!=null && tIdCityMasterEntityList.size()>0) {
		        	if(tIdCityMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdCityMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdCityMasterEntityList.get(0).getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdCityMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
		        		tIdCityMasterJpaRepository.save(tIdCityMasterEntityList);
		        		tIdAdditionalInformation.setPiadCityKey(tIdCityMasterEntityList.get(0).getKey());
		        		tIdAdditionalInformation.setOtherCityName(null);

		        		} else {
		        			throw new DataIntegrityViolationException("City name already exist!!!");
		        		  }
				} else {
					tIdCityMasterEntity = tIdCityMasterJpaRepository.findByKey(tIdAdditionalInformation.getPiadCityKey());
					tIdCityMasterEntity.setName(tIdAdditionalInformation.getOtherCityName());
					tIdCityMasterEntity.setActiveStatus(PENDING_STATUS);
					tIdCityMasterEntity=tIdCityMasterJpaRepository.save(tIdCityMasterEntity);
					tIdAdditionalInformation.setOtherCityName(null);
				}
			} else { 
				tIdCityMasterEntityList=tIdCityMasterJpaRepository.findByName(tIdAdditionalInformation.getOtherCityName());
				if(tIdCityMasterEntityList.size()>0) {
						if(tIdCityMasterEntityList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdCityMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS)|| tIdCityMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdCityMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
			        		tIdCityMasterJpaRepository.save(tIdCityMasterEntityList);
							tIdAdditionalInformation.setPiadCityKey(tIdCityMasterEntityList.get(0).getKey());
							tIdAdditionalInformation.setOtherCityName(null);
						} else {
							throw new DataIntegrityViolationException("City name already exist!!!");
						}
					}
				} 
			}
		if(tIdAdditionalInformation.getOtherStateName()!=null){
			if(tIdAdditionalInformation.getPiadStateKey() !=null && tIdAdditionalInformation.getPiadStateKey() !=0) {
				tIdStateMasterEntityList=tIdStateMasterJpaRepository.findByNameAndKeyNotIn(tIdAdditionalInformation.getOtherStateName(),tIdAdditionalInformation.getPiadStateKey());
		        if(tIdStateMasterEntityList.size()>0) {
		        	if(tIdStateMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdStateMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdStateMasterEntityList.get(0).getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdStateMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
		        		tIdStateMasterJpaRepository.save(tIdStateMasterEntityList);
		        		tIdAdditionalInformation.setPiadStateKey(tIdStateMasterEntityList.get(0).getKey());
		        		tIdAdditionalInformation.setOtherStateName(null);
		        		} else {
		        			throw new DataIntegrityViolationException("State name already exist!!!");
		        		  }
					
				} else {
					tIdStateMasterEntity = tIdStateMasterJpaRepository.findByKey(tIdAdditionalInformation.getPiadStateKey());
					tIdStateMasterEntity.setActiveStatus(PENDING_STATUS);
					tIdStateMasterEntity.setName(tIdAdditionalInformation.getOtherStateName());
					tIdStateMasterEntity=tIdStateMasterJpaRepository.save(tIdStateMasterEntity);
					tIdAdditionalInformation.setOtherStateName(null);
				}
			} else { 
				tIdStateMasterEntityList=tIdStateMasterJpaRepository.findByName(tIdAdditionalInformation.getOtherStateName());
				if(tIdStateMasterEntityList!=null && tIdStateMasterEntityList.size()>0) {
						if(tIdStateMasterEntityList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdStateMasterEntityList.get(0).getActiveStatus().equals(DELETE_STATUS)|| tIdStateMasterEntityList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) 
						{
							tIdStateMasterEntityList.get(0).setActiveStatus(PENDING_STATUS);
			        		tIdStateMasterJpaRepository.save(tIdStateMasterEntityList);
							tIdAdditionalInformation.setPiadStateKey(tIdStateMasterEntityList.get(0).getKey());
							tIdAdditionalInformation.setOtherStateName(null);
							} else {
								throw new DataIntegrityViolationException("State name already exist!!!");
							}
					}
				} 
			}
		
		tIdAdditionalInformationSearchServiceMapper.mapTIdAdditionalInformationToTIdAdditionalInformationEntitySearch(tIdAdditionalInformation, tIdAdditionalInformationEntitySearch);
		
		
		if(tIdAdditionalInformation.getOtherCityName()!=null){
			tIdCityMasterEntity=new TIdCityMasterEntity();
			tIdCityMasterEntity.setName(tIdAdditionalInformation.getOtherCityName());
			tIdCityMasterEntity.setActiveStatus(PENDING_STATUS);
			tIdCityMasterEntity.setActiveFrom(new Date());
			tIdCityMasterEntity.setLockKey(0L);
			tIdCityMasterEntity.setProfileKey(1l);
			tIdCityMasterEntity.setCountryKey(tIdAdditionalInformation.getPiadCountryKey());
			tIdCityMasterEntity=tIdCityMasterJpaRepository.save(tIdCityMasterEntity);
			tIdAdditionalInformationEntitySearch.setPiadCityKey(tIdCityMasterEntity.getKey());
		}  
		
		if(tIdAdditionalInformation.getOtherStateName()!=null) {
			tIdStateMasterEntity = new TIdStateMasterEntity();
			tIdStateMasterEntity.setName(tIdAdditionalInformation.getOtherStateName());
			tIdStateMasterEntity.setStateAbbreviation(tIdAdditionalInformation.getOtherStateName());
			tIdStateMasterEntity.setActiveStatus(PENDING_STATUS);
			tIdStateMasterEntity.setActiveFrom(new Date());
			tIdStateMasterEntity.setLockKey(0L);
			tIdStateMasterEntity.setProfileKey(1l);
			tIdStateMasterEntity.setStateCountryKey(tIdAdditionalInformation.getPiadCountryKey());
			tIdStateMasterEntity = tIdStateMasterJpaRepository.save(tIdStateMasterEntity);
			tIdAdditionalInformationEntitySearch.setPiadStateKey(tIdStateMasterEntity.getKey());
		} 
		
		if (("Y").equals(tIdAdditionalInformation.getPiadCurrentlyWorking())) {
			tIdAdditionalInformationJpaRepository.updateCurrentWorkingStatus(tIdAdditionalInformation.getPiadPinKey(), "N");
		} 
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdAdditionalInformation.getPiadPinKey());
		tIdAdditionalInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		tIdAdditionalInformationEntitySearchList.add(tIdAdditionalInformationEntitySearch);
		tIdPersonalInformationEntitySearch.setListOfTIdAdditionalInformation(tIdAdditionalInformationEntitySearchList);
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdAdditionalInformation.getPiadKey() == null) {
			tIdLandingAddInformationJpaRepository.updateLatestUpdate(tIdAdditionalInformation.getAuditJson(), 
					tIdPersonalInformationEntitySearch.getListOfTIdAdditionalInformation().get(0).getPiadKey());
		}
		
		tIdAdditionalInformation.setPiadKey(tIdPersonalInformationEntitySearch.getListOfTIdAdditionalInformation().get(0).getPiadKey());
		return tIdAdditionalInformation;
	}

	@Override
	public TIdAwardsInformation saveAwardsInfo(TIdAwardsInformation tIdAwardsInformation) throws Exception {
		
		List<TIdAwardsInformationEntitySearch> tIdAwardsInformationEntitySearchList = new ArrayList<TIdAwardsInformationEntitySearch>();
		TIdAwardsInformationEntitySearch tIdAwardsInformationEntitySearch =new TIdAwardsInformationEntitySearch();
		TIdDesignationMasterEntitySearch tIdDesignationMasterEntitySearch=null;
		TIdEducationalInstitutesEntitySearch tIdEducationalInstitutesEntitySearch=null;
		
		if(tIdAwardsInformation.getOtherPositionName()!=null) {
			if(tIdAwardsInformation.getPiaPosition() !=null && tIdAwardsInformation.getPiaPosition() !=0) {
				tIdDesignationMasterEntitySearch = tIdDesignationMasterEntitySearchJpaRepository.findByNameAndKeyNotIn(tIdAwardsInformation.getOtherPositionName(), tIdAwardsInformation.getPiaPosition());
		        if(tIdDesignationMasterEntitySearch!=null) {
		        	if(tIdDesignationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdDesignationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)
		        			||tIdDesignationMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
		        		tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
		        		tIdAwardsInformation.setPiaPosition(tIdDesignationMasterEntitySearch.getKey());//No Designation Key
		        		tIdAwardsInformation.setOtherPositionName(null);
		        	} else {
		        			throw new DataIntegrityViolationException("Designation name already exist!!!");
		        	}
				} else {
					tIdDesignationMasterEntitySearch = tIdDesignationMasterEntitySearchJpaRepository.findOne(tIdAwardsInformation.getPiaPosition());
					tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdDesignationMasterEntitySearch.setName(tIdAwardsInformation.getOtherPositionName());
					tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
					tIdAwardsInformation.setOtherPositionName(null);
				}
			}
			else {
				tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.findByName(tIdAwardsInformation.getOtherPositionName());
				if(tIdDesignationMasterEntitySearch!=null){
						if(tIdDesignationMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdDesignationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) 
							|| tIdDesignationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			        		tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
							tIdAwardsInformation.setPiaPosition(tIdDesignationMasterEntitySearch.getKey());
							tIdAwardsInformation.setOtherPositionName(null);
						} else {
							throw new DataIntegrityViolationException("Designation name already exist!!!");
						}
					}
				}
			}
		
		if(tIdAwardsInformation.getOtherProvidedByName()!=null) {
			if(tIdAwardsInformation.getPiaProvidedBy()!=null && tIdAwardsInformation.getPiaProvidedBy()!=0) {
				tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.findByNameAndKeyNotIn(tIdAwardsInformation.getOtherProvidedByName(), tIdAwardsInformation.getPiaProvidedBy());
		        if(tIdEducationalInstitutesEntitySearch!=null) {
		        	if(tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
		        		tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
		        		tIdAwardsInformation.setPiaProvidedBy(tIdDesignationMasterEntitySearch.getKey());
		        		tIdAwardsInformation.setOtherProvidedByName(null);
		        	} else {
		        		throw new DataIntegrityViolationException("Educational name already exist!!!");
		        	}
				} else {
					tIdEducationalInstitutesEntitySearch = tIdEducationalInstitutesSearchJpaRepository.findOne(tIdAwardsInformation.getPiaProvidedBy());
					tIdEducationalInstitutesEntitySearch.setName(tIdAwardsInformation.getOtherProvidedByName());
					tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
					tIdAwardsInformation.setOtherProvidedByName(null);
				}
			}
			else {
				tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.findByName(tIdAwardsInformation.getOtherProvidedByName());
				if(tIdEducationalInstitutesEntitySearch!=null){
						if(tIdEducationalInstitutesEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(DELETE_STATUS) 
								|| tIdEducationalInstitutesEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdEducationalInstitutesEntitySearch.setActiveStatus(PENDING_STATUS);
			        		tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
							tIdAwardsInformation.setPiaProvidedBy(tIdDesignationMasterEntitySearch.getKey());
							tIdAwardsInformation.setOtherProvidedByName(null);
						} else {
							throw new DataIntegrityViolationException("Educational name already exist!!!");
						}
					}
				}
			}
		
		tIdAwardsInformationSearchServiceMapper.mapTIdAwardsInformationToTIdAwardsInformationEntitySearch(tIdAwardsInformation, tIdAwardsInformationEntitySearch);
		
		if(tIdAwardsInformation.getOtherPositionName()!=null){       //save other position(Award)
			tIdDesignationMasterEntitySearch=new TIdDesignationMasterEntitySearch();
			tIdDesignationMasterEntitySearch.setActiveFrom(new Date());
			tIdDesignationMasterEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdDesignationMasterEntitySearch.setName(tIdAwardsInformation.getOtherPositionName());
			tIdDesignationMasterEntitySearch.setLockKey(0L);
			tIdDesignationMasterEntitySearch.setProfileKey(1L);
			tIdDesignationMasterEntitySearch.setDesigActiveFlag(0L);
			tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
			tIdAwardsInformation.setOtherPositionKey(tIdDesignationMasterEntitySearch.getKey());
			tIdAwardsInformationEntitySearch.setPiaPosition(tIdDesignationMasterEntitySearch.getKey());
		} 
		
		if(tIdAwardsInformation.getOtherProvidedByName()!=null) {
			tIdEducationalInstitutesEntitySearch=new TIdEducationalInstitutesEntitySearch();
			tIdEducationalInstitutesEntitySearch.setActiveFrom(new Date());
			tIdEducationalInstitutesEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdEducationalInstitutesEntitySearch.setEducationActiveStatusKey(1L);
			//tIdEducationalInstitutesEntitySearch.setEducationCityKey(tIdAwardsInformation.getCityKey());
			//tIdEducationalInstitutesEntitySearch.setEducationCountryKey(tIdAwardsInformation.getCountryKey());
			//tIdEducationalInstitutesEntitySearch.setEducationStateKey(tIdAwardsInformation.getStateKey());
			tIdEducationalInstitutesEntitySearch.setLockKey(0L);
			tIdEducationalInstitutesEntitySearch.setName(tIdAwardsInformation.getOtherProvidedByName());
			tIdEducationalInstitutesEntitySearch.setProfileKey(1L);
			tIdEducationalInstitutesEntitySearch=tIdEducationalInstitutesSearchJpaRepository.save(tIdEducationalInstitutesEntitySearch);
			tIdAwardsInformation.setOtherProvidedByKey(tIdEducationalInstitutesEntitySearch.getKey());
			tIdAwardsInformationEntitySearch.setPiaProvidedBy(tIdEducationalInstitutesEntitySearch.getKey());
			
		}
		
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdAwardsInformation.getPiaPinKey());
		tIdAwardsInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		tIdAwardsInformationEntitySearchList.add(tIdAwardsInformationEntitySearch);
		tIdPersonalInformationEntitySearch.setListOfTIdAwardsInformation(tIdAwardsInformationEntitySearchList);
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdAwardsInformation.getPiaKey() == null) {
			tIdLandingAwardsRecognitionJpaRepository.updateLatestUpdate(tIdAwardsInformation.getAuditJson(), 
					tIdPersonalInformationEntitySearch.getListOfTIdAwardsInformation().get(0).getPiaKey());
		}
		
		tIdAwardsInformation.setPiaKey(tIdPersonalInformationEntitySearch.getListOfTIdAwardsInformation().get(0).getPiaKey());
		return tIdAwardsInformation;
	}

	@Override
	public TIdProjectsInformation saveProjectsInfo(TIdProjectsInformation tIdProjectsInformation) throws Exception {
		TIdCompanyMasterEntitySearch tIdCompanyMasterEntitySearch = null;
		List<TIdProjectsInformationEntitySearch> tIdProjectsInformationEntitySearchList = new ArrayList<TIdProjectsInformationEntitySearch>();
		TIdProjectsInformationEntitySearch  tIdProjectsInformationEntitySearch=new  TIdProjectsInformationEntitySearch();
		
		if(tIdProjectsInformation.getOtherCompanyName()!=null) {
			if(tIdProjectsInformation.getPipCompanyCmsKey()!=null && tIdProjectsInformation.getPipCompanyCmsKey()!=0) {
				tIdCompanyMasterEntitySearch = tIdCompanyMasterEntitySearchJpaRepository.findByNameAndCompanyKeyNotIn(tIdProjectsInformation.getOtherCompanyName(), tIdProjectsInformation.getPipCompanyCmsKey());
		        if(tIdCompanyMasterEntitySearch!=null) {
		        	if(tIdCompanyMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdCompanyMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)||tIdCompanyMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS))
		        	{
		        		tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
		        		tIdCompanyMasterEntitySearch = tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
		        		tIdProjectsInformation.setPipCompanyCmsKey(tIdCompanyMasterEntitySearch.getCompanyKey());
		        		tIdProjectsInformation.setOtherCompanyName(null);
		        	} else {
		        		throw new DataIntegrityViolationException("Company name already exist!!!");
	        		}
				} else {
					tIdCompanyMasterEntitySearch = tIdCompanyMasterEntitySearchJpaRepository.findOne(tIdProjectsInformation.getPipCompanyCmsKey());
					tIdCompanyMasterEntitySearch.setName(tIdProjectsInformation.getOtherCompanyName());
					tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdCompanyMasterEntitySearch = tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
					tIdProjectsInformation.setOtherCompanyName(null);
				}
				
			}else {
				tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.findByName(tIdProjectsInformation.getOtherCompanyName());
				if(tIdCompanyMasterEntitySearch!=null){
						if(tIdCompanyMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdCompanyMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) || tIdCompanyMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) 
						{
							tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			        		tIdCompanyMasterEntitySearch = tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
							tIdProjectsInformation.setPipCompanyCmsKey(tIdCompanyMasterEntitySearch.getCompanyKey());
							tIdProjectsInformation.setOtherCompanyName(null);
						} else {
							throw new DataIntegrityViolationException("Company name already exist!!!");
						}
					}
				}
			}
		
		tIdProjectsInformationSearchServiceMapper.mapTIdProjectsInformationToTIdProjectsInformationEntitySearch(tIdProjectsInformation, tIdProjectsInformationEntitySearch);
		
		if(tIdProjectsInformation.getOtherCompanyName()!=null)  //save other Company(projects)
		{
			tIdCompanyMasterEntitySearch = new TIdCompanyMasterEntitySearch();
			tIdCompanyMasterEntitySearch.setName(tIdProjectsInformation.getOtherCompanyName());
			tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdCompanyMasterEntitySearch.setCompanyGroup(PENDING_STATUS);
			tIdCompanyMasterEntitySearch.setLockKey(0L);
			tIdCompanyMasterEntitySearch.setActiveFrom(new Date());
			tIdCompanyMasterEntitySearch.setProfileKey(1L);
			tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
			tIdProjectsInformation.setOtherCompanyCmsKey(tIdCompanyMasterEntitySearch.getCompanyKey());
			tIdProjectsInformationEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearch);
			
		} else if(tIdProjectsInformation.getPipCompanyCmsKey()!=null){
			tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.findOne(tIdProjectsInformation.getPipCompanyCmsKey());
			tIdProjectsInformationEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearch);
		}
		
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdProjectsInformation.getPipPinKey());
		tIdProjectsInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		tIdProjectsInformationEntitySearchList.add(tIdProjectsInformationEntitySearch);
        tIdPersonalInformationEntitySearch.setListOfTIdProjectsInformation(tIdProjectsInformationEntitySearchList);
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdProjectsInformation.getPipKey() == null) {
			tIdLandingProjectExecutedJpaRepository.updateLatestUpdate(tIdProjectsInformation.getAuditJson(), 
					tIdPersonalInformationEntitySearch.getListOfTIdProjectsInformation().get(0).getPipKey());
		}		
		
		tIdProjectsInformation.setPipKey(tIdPersonalInformationEntitySearch.getListOfTIdProjectsInformation().get(0).getPipKey());
		return tIdProjectsInformation;
	}

	@Override
	public TIdMiscInformation saveMiscInfo(TIdMiscInformation tIdMiscInformation) {
		
		List<TIdMiscInformationEntitySearch> tIdMiscInformationEntitySearchList = new ArrayList<TIdMiscInformationEntitySearch>();
		TIdMiscInformationEntitySearch  tIdMiscInformationEntitySearch =new  TIdMiscInformationEntitySearch();
		tIdMiscInformationSearchServiceMapper.mapTIdMiscInformationToTIdMiscInformationEntitySearch(tIdMiscInformation, tIdMiscInformationEntitySearch);
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdMiscInformation.getPimiPinKey());
		tIdMiscInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		tIdMiscInformationEntitySearchList.add(tIdMiscInformationEntitySearch);
        tIdPersonalInformationEntitySearch.setListOfTIdMiscInformation(tIdMiscInformationEntitySearchList);
        tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		tIdMiscInformation.setPimiKey(tIdPersonalInformationEntitySearch.getListOfTIdMiscInformation().get(0).getPimiKey());
		return tIdMiscInformation;
	}

	@Override
	public TIdMiscInformation saveMiscProfessionalExpertiseInfo(TIdMiscInformation tIdMiscInformation) {
		List<TIdMiscInformationEntity> tIdMiscInformationEntityList=null;
		if(tIdMiscInformation.getPimiKey()!=null){
			tIdMiscInformationEntityList=tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiProfessionalExpertiseKeyIsNotNull(tIdMiscInformation.getPimiPinKey(),ACTIVESTATUS);
			if(tIdMiscInformationEntityList!=null && tIdMiscInformationEntityList.size()>0 ){
				tIdMiscInformationJpaRepository.delete(tIdMiscInformationEntityList);
			}
		}
		List<TIdMiscInformationEntitySearch> tIdMiscInformationEntitySearchList = new ArrayList<TIdMiscInformationEntitySearch>();
		TIdMiscInformationEntitySearch  tIdMiscInformationEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdMiscInformation.getPimiPinKey());
		if(tIdMiscInformation.getPimiProfessionalExpertiseMap()!=null){
			for(Map.Entry<Long,String> entry:tIdMiscInformation.getPimiProfessionalExpertiseMap().entrySet()){	
				tIdMiscInformationEntitySearch =new  TIdMiscInformationEntitySearch();
				tIdMiscInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
				tIdMiscInformationEntitySearch.setPimiProfessionalExpertise(entry.getValue());
				tIdMiscInformationEntitySearch.setPimiProfessionalExpertiseKey(entry.getKey());
				tIdMiscInformationEntitySearch.setLockKey(tIdMiscInformation.getLockKey());
				tIdMiscInformationEntitySearch.setProfileKey(tIdMiscInformation.getProfileKey());
				tIdMiscInformationEntitySearch.setActiveStatus(tIdMiscInformation.getActiveStatus());
				tIdMiscInformationEntitySearchList.add(tIdMiscInformationEntitySearch);
			}
		}
		
		if(tIdMiscInformationEntitySearchList.size()>0) {
			tIdPersonalInformationEntitySearch.setListOfTIdMiscInformation(tIdMiscInformationEntitySearchList);
			tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		}
		tIdMiscInformation.setPimiKey(tIdPersonalInformationEntitySearch.getListOfTIdMiscInformation().get(0).getPimiKey());
		return tIdMiscInformation;
	}

	@Override
	public TIdMiscInformation getViewProfExpert(Long pinKey) {
		List<TIdMiscInformationEntity> tIdMiscInformationEntityList=tIdMiscInformationJpaRepository.findByPimiPinKeyAndActiveStatusAndPimiProfessionalExpertiseKeyIsNotNull(pinKey,ACTIVESTATUS);
		TIdMiscInformation tIdMiscInformation = null;
		if(tIdMiscInformationEntityList.size()>0){
			tIdMiscInformation = new TIdMiscInformation();
			tIdMiscInformation.setPimiKey(tIdMiscInformationEntityList.get(0).getPimiKey());
			tIdMiscInformation.setPimiPinKey(tIdMiscInformationEntityList.get(0).getPimiPinKey());
			tIdMiscInformation.setProfileKey(tIdMiscInformationEntityList.get(0).getProfileKey());
			tIdMiscInformation.setLockKey(tIdMiscInformationEntityList.get(0).getLockKey());
			HashMap<Long, String> map = new HashMap<>();
			for(TIdMiscInformationEntity tIdMiscInformationEntity : tIdMiscInformationEntityList) {
				map.put(tIdMiscInformationEntity.getPimiProfessionalExpertiseKey(),tIdMiscInformationEntity.getPimiProfessionalExpertise());
			}
			tIdMiscInformation.setPimiProfessionalExpertiseMap(map);
		}
		return tIdMiscInformation;
	}

	@Override
	public List<TIdEducationalInstitutesViewEntity> getInstituteInfoDtls(Long profileKey) {
		return tIdEducationalInstitutesViewJpaRepository.findByProfileKeyAndActiveStatus(profileKey, CommonConstants.ACTIVE_STATUS);
	}


}
