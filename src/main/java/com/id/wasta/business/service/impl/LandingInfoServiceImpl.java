package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.ACTIVE;
import static com.id.wasta.util.action.CommonConstants.ADD_INFORMATION;
import static com.id.wasta.util.action.CommonConstants.ADD_POTENTIAL;
import static com.id.wasta.util.action.CommonConstants.AWARDS_RECOG;
import static com.id.wasta.util.action.CommonConstants.BUSINESS_POTENTIAL;
import static com.id.wasta.util.action.CommonConstants.DISCUSSION_DETAILS;
import static com.id.wasta.util.action.CommonConstants.EDUCATION;
import static com.id.wasta.util.action.CommonConstants.EMAIL_ID;
import static com.id.wasta.util.action.CommonConstants.EXPERIENCE;
import static com.id.wasta.util.action.CommonConstants.HEADER_INFO;
import static com.id.wasta.util.action.CommonConstants.LANDLINE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.LEFT_MENU_LIST;
import static com.id.wasta.util.action.CommonConstants.MOBILE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.NEW_CONTACT;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INFO;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INTEREST;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_PRIORITIES;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_RELATIONSHIP;
import static com.id.wasta.util.action.CommonConstants.PROFESSIONAL_INTEREST;
import static com.id.wasta.util.action.CommonConstants.PROFESSIONAL_RELATIONSHIP;
import static com.id.wasta.util.action.CommonConstants.PROF_EXPERTISE;
import static com.id.wasta.util.action.CommonConstants.PROJ_EXECUTED;
import static com.id.wasta.util.action.CommonConstants.RECREATION;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.id.wasta.bean.LandingInfoBean;
import com.id.wasta.bean.TIdLandingMaster;
import com.id.wasta.bean.TIdLandingNotification;
import com.id.wasta.bean.TIdProfileFollowDetailsView;
import com.id.wasta.bean.ToolTipBean;
import com.id.wasta.bean.ToolTipNotificationLandBean;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkViewEntity;
import com.id.wasta.bean.jpa.TIdExperienceInformationViewEntity;
import com.id.wasta.bean.jpa.TIdLandingAddInformationEntity;
import com.id.wasta.bean.jpa.TIdLandingAddInformationLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingAddPotentialEntity;
import com.id.wasta.bean.jpa.TIdLandingAddPotentialLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingAwardsRecognitionEntity;
import com.id.wasta.bean.jpa.TIdLandingAwardsRecognitionLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingBusinessPotentialEntity;
import com.id.wasta.bean.jpa.TIdLandingBusinessPotentialLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingDiscussionDtlsEntity;
import com.id.wasta.bean.jpa.TIdLandingDiscussionDtlsLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingEducationEntity;
import com.id.wasta.bean.jpa.TIdLandingEducationLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingEmailEntity;
import com.id.wasta.bean.jpa.TIdLandingEmailLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingExperienceEntity;
import com.id.wasta.bean.jpa.TIdLandingExperienceLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingHomeEntity;
import com.id.wasta.bean.jpa.TIdLandingHomeLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingNotificationEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalInfoEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalInterestEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalInterestLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalPrioritiesEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalPrioritiesLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalRelationshipsEntity;
import com.id.wasta.bean.jpa.TIdLandingPersonalRelationshipsLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingPhoneNoEntity;
import com.id.wasta.bean.jpa.TIdLandingPhoneNoLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingProfessionalExpertiseEntity;
import com.id.wasta.bean.jpa.TIdLandingProfessionalExpertiseLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingProfessionalInterestEntity;
import com.id.wasta.bean.jpa.TIdLandingProfessionalInterestLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingProfessionalRelationshipEntity;
import com.id.wasta.bean.jpa.TIdLandingProfessionalRelationshipLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingProjectExecutedEntity;
import com.id.wasta.bean.jpa.TIdLandingProjectExecutedLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingRecreationEntity;
import com.id.wasta.bean.jpa.TIdLandingRecreationLinkEntity;
import com.id.wasta.bean.jpa.TIdMyContactsLinkEntity;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkViewEntity;
import com.id.wasta.business.service.LandingInfoService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyIndustryLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAddInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAddInformationLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAddPotentialJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAddPotentialLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAwardsRecognitionJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAwardsRecognitionLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingBusinessPotentialJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingBusinessPotentialLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingDiscussionDtlsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingDiscussionDtlsLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingEducationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingEducationLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingEmailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingEmailLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingExperienceJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingExperienceLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingHomeJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingHomeLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingNotificationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalInterestJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalInterestLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalPrioritiesLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalRelationshipsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalRelationshipsLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPhoneNoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPhoneNoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalExpertiseLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalInterestJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalInterestLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalRelationshipJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalRelationshipLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProjectExecutedJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProjectExecutedLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingRecreationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingRecreationLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdMyContactsLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileFollowDetailsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileFollowDetailsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkViewJpaRepository;

/**
 * Implementation of LandingInfoService
 */
@Service
@Transactional
public class LandingInfoServiceImpl implements LandingInfoService {
	
	@Autowired
	private ObjectMapper objectMapper;
	@Resource
	private TIdLandingEmailJpaRepository tIdLandingEmailJpaRepository;
	@Resource
	private TIdLandingPhoneNoJpaRepository tIdLandingPhoneNoJpaRepository;
	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	@Resource
	private TIdLandingHomeJpaRepository tIdLandingHomeJpaRepository;
	@Resource
	private TIdLandingDiscussionDtlsJpaRepository tIdLandingDiscussionDtlsJpaRepository;
	@Resource
	private TIdLandingBusinessPotentialJpaRepository tIdLandingBusinessPotentialJpaRepository;
	@Resource
	private TIdLandingAddPotentialJpaRepository tIdLandingAddPotentialJpaRepository;
	@Resource
	private TIdLandingRecreationJpaRepository tIdLandingRecreationJpaRepository;
	@Resource
	private TIdLandingPersonalInfoJpaRepository tIdLandingPersonalInfoJpaRepository;
	@Resource
	private TIdLandingPersonalInterestJpaRepository tIdLandingPersonalInterestJpaRepository;
	@Resource
	private TIdLandingProfessionalInterestJpaRepository tIdLandingProfessionalInterestJpaRepository;
	@Resource
	private TIdLandingPersonalPrioritiesJpaRepository tIdLandingPersonalPrioritiesJpaRepository;
	@Resource
	private TIdLandingExperienceJpaRepository tIdLandingExperienceJpaRepository;
	@Resource
	private TIdLandingEducationJpaRepository tIdLandingEducationJpaRepository;
	@Resource
	private TIdLandingProjectExecutedJpaRepository tIdLandingProjectExecutedJpaRepository;
	@Resource
	private TIdLandingProfessionalExpertiseJpaRepository tIdLandingProfessionalExpertiseJpaRepository;
	@Resource
	private TIdLandingAwardsRecognitionJpaRepository tIdLandingAwardsRecognitionJpaRepository;
	@Resource
	private TIdLandingAddInformationJpaRepository tIdLandingAddInformationJpaRepository;
	@Resource
	private TIdLandingPersonalRelationshipsJpaRepository tIdLandingPersonalRelationshipsJpaRepository;
	@Resource
	private TIdLandingProfessionalRelationshipJpaRepository tIdLandingProfessionalRelationshipJpaRepository;
	@Resource
	private TIdLandingNotificationJpaRepository tIdLandingNotificationJpaRepository;
	@Resource
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	@Resource
	private TIdPersonalInformationViewJpaRepository tIdPersonalInformationViewJpaRepository;
	@Resource
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	@Resource
	private TIdMyContactsLinkJpaRepository tIdMyContactsLinkJpaRepository;
	@Resource
	private TIdProfileFollowDetailsViewJpaRepository tIdProfileFollowDetailsViewJpaRepository;
	@Resource
	private TIdProfileFollowDetailsJpaRepository tIdProfileFollowDetailsJpaRepository;
	@Resource
	private TIdCompanyIndustryLinkViewJpaRepository tIdCompanyIndustryLinkViewJpaRepository;
	@Resource
	private TIdLandingEmailLinkJpaRepository tIdLandingEmailLinkJpaRepository;
	@Resource
	private TIdLandingPhoneNoLinkJpaRepository tIdLandingPhoneNoLinkJpaRepository;
	@Resource
	private TIdLandingHomeLinkJpaRepository tIdLandingHomeLinkJpaRepository;
	@Resource
	private TIdLandingDiscussionDtlsLinkJpaRepository tIdLandingDiscussionDtlsLinkJpaRepository;
	@Resource
	private TIdLandingBusinessPotentialLinkJpaRepository tIdLandingBusinessPotentialLinkJpaRepository;
	@Resource
	private TIdLandingAddPotentialLinkJpaRepository tIdLandingAddPotentialLinkJpaRepository;
	@Resource
	private TIdLandingRecreationLinkJpaRepository tIdLandingRecreationLinkJpaRepository;
	@Resource
	private TIdLandingPersonalInfoLinkJpaRepository tIdLandingPersonalInfoLinkJpaRepository;
	@Resource
	private TIdLandingPersonalInterestLinkJpaRepository tIdLandingPersonalInterestLinkJpaRepository;
	@Resource
	private TIdLandingProfessionalInterestLinkJpaRepository tIdLandingProfessionalInterestLinkJpaRepository;
	@Resource
	private TIdLandingPersonalPrioritiesLinkJpaRepository tIdLandingPersonalPrioritiesLinkJpaRepository;
	@Resource
	private TIdLandingExperienceLinkJpaRepository tIdLandingExperienceLinkJpaRepository;
	@Resource
	private TIdLandingEducationLinkJpaRepository tIdLandingEducationLinkJpaRepository;
	@Resource
	private TIdLandingProjectExecutedLinkJpaRepository tIdLandingProjectExecutedLinkJpaRepository;
	@Resource
	private TIdLandingProfessionalExpertiseLinkJpaRepository tIdLandingProfessionalExpertiseLinkJpaRepository;
	@Resource
	private TIdLandingAwardsRecognitionLinkJpaRepository tIdLandingAwardsRecognitionLinkJpaRepository;
	@Resource
	private TIdLandingAddInformationLinkJpaRepository tIdLandingAddInformationLinkJpaRepository;
	@Resource
	private TIdLandingPersonalRelationshipsLinkJpaRepository tIdLandingPersonalRelationshipsLinkJpaRepository;
	@Resource
	private TIdLandingProfessionalRelationshipLinkJpaRepository tIdLandingProfessionalRelationshipLinkJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	@Autowired
	private TIdExperienceInformationViewJpaRepository tIdExperienceInformationViewJpaRepository;
	
	@Autowired
	private TIdCompanyContactLinkViewJpaRepository tIdCompanyContactLinkViewJpaRepository;
	@Autowired
	private TIdRelationshipInfoLinkViewJpaRepository tIdRelationshipInfoLinkViewJpaRepository;
	
	@Override
	public TIdLandingMaster getLandMenuCount(Date logoutDate, Long loggedPinKey) {
		TIdLandingMaster tIdLandingMaster = new TIdLandingMaster();
		tIdLandingMaster.setLmEmail(tIdLandingEmailJpaRepository.getEmailIdsCount(loggedPinKey));
		tIdLandingMaster.setLmPhoneNo(tIdLandingPhoneNoJpaRepository.getPhoneNumbersCount(loggedPinKey));
		tIdLandingMaster.setLmHome(tIdLandingHomeJpaRepository.getHomesCount(loggedPinKey));
		tIdLandingMaster.setLmDiscussionDtls(tIdLandingDiscussionDtlsJpaRepository.getdiscussDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmBusinessPotential(tIdLandingBusinessPotentialJpaRepository.getBusinPotentialCounts(loggedPinKey));
		tIdLandingMaster.setLmAddPotential(tIdLandingAddPotentialJpaRepository.getAddPotentialsCount(loggedPinKey));
		tIdLandingMaster.setLmRecreation(tIdLandingRecreationJpaRepository.getRecreationDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmPersonalInfo(tIdLandingPersonalInfoJpaRepository.getPersonalInfosCount(loggedPinKey));
		tIdLandingMaster.setLmPersonalInterest(tIdLandingPersonalInterestJpaRepository.getPersonInterestDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmProfessionalInterest(tIdLandingProfessionalInterestJpaRepository.getProfInterestDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmPersonalPriorities(tIdLandingPersonalPrioritiesJpaRepository.getPersonPrioritiesCount(loggedPinKey));
		tIdLandingMaster.setLmExperience(tIdLandingExperienceJpaRepository.getExperienceDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmEducation(tIdLandingEducationJpaRepository.getdiscussDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmProjectExecuted(tIdLandingProjectExecutedJpaRepository.getProjExecutedDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmProfessionalExpertise(tIdLandingProfessionalExpertiseJpaRepository.getProfExpertiesDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmAwardsRecognition(tIdLandingAwardsRecognitionJpaRepository.getAwardsRecogDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmAddInformation(tIdLandingAddInformationJpaRepository.getAddInformationDetsilsCount(loggedPinKey));
		tIdLandingMaster.setLmPersonalRelationships(tIdLandingPersonalRelationshipsJpaRepository.getPersonRelationShDetailsCount(loggedPinKey));
		tIdLandingMaster.setLmProfessionalRelationship(tIdLandingProfessionalRelationshipJpaRepository.getProfRelationShDetailsCount(loggedPinKey)); 
		
		tIdLandingMaster.setUnReadContacts(tIdLandingMaster.getLmEmail()+tIdLandingMaster.getLmPhoneNo()
					+tIdLandingMaster.getLmHome()+tIdLandingMaster.getLmDiscussionDtls()+tIdLandingMaster.getLmBusinessPotential()
					+tIdLandingMaster.getLmAddPotential()+tIdLandingMaster.getLmRecreation()+tIdLandingMaster.getLmPersonalInfo()
					+tIdLandingMaster.getLmPersonalInterest()+tIdLandingMaster.getLmProfessionalInterest()+tIdLandingMaster.getLmPersonalPriorities()
					+tIdLandingMaster.getLmExperience()+tIdLandingMaster.getLmEducation()+tIdLandingMaster.getLmProjectExecuted()
					+tIdLandingMaster.getLmProfessionalExpertise()+tIdLandingMaster.getLmAwardsRecognition()+tIdLandingMaster.getLmAddInformation()
					+tIdLandingMaster.getLmPersonalRelationships()+tIdLandingMaster.getLmProfessionalRelationship());
		return tIdLandingMaster;
	}
	
	@Override
	public List<LandingInfoBean> getLandPageList(String menuType, Date logoutDate, Long loggedPinKey,int page, int size) {
		List<LandingInfoBean> landingInfoBeanList = new ArrayList<LandingInfoBean>();		
		List<LandingInfoBean> sortedLandingInfoBeanList = new ArrayList<LandingInfoBean>();
		
		List<String> menuList = new ArrayList<String>();
		boolean readFlag = false; 
		if(menuType.equals("unReadContacts")) {
			menuList.addAll(LEFT_MENU_LIST);
		} else {
			menuList.add(menuType);
			readFlag = true;
		}
		
		for(String menu : menuList) {
			
			switch(menu) {
				
				case "lmEmail":				
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingEmailJpaRepository.getEmailIds(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingEmailJpaRepository.getEmailIdsNotIn(loggedPinKey));
					break;
					
				case "lmPhoneNo":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingPhoneNoJpaRepository.getPhoneNumbers(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingPhoneNoJpaRepository.getPhoneNumbersNotIn(loggedPinKey));
					break;
								
				case "lmHome":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingHomeJpaRepository.getHomes(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingHomeJpaRepository.getHomesNotIn(loggedPinKey));
					break;
					
				case "lmDiscussionDtls":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingDiscussionDtlsJpaRepository.getdiscussDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingDiscussionDtlsJpaRepository.getdiscussDetailsNotIn(loggedPinKey));
					break;
					
				case "lmBusinessPotential":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingBusinessPotentialJpaRepository.getBusinPotentials(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingBusinessPotentialJpaRepository.getBusinPotentialsNotIn(loggedPinKey));				
					break;
					
				case "lmAddPotential":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingAddPotentialJpaRepository.getAddPotentials(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingAddPotentialJpaRepository.getAddPotentialsNotIn(loggedPinKey));
					break;
					
				case "lmRecreation":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingRecreationJpaRepository.getRecreationDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingRecreationJpaRepository.getRecreationDetailsNotIn(loggedPinKey));
					break;
					
				case "lmPersonalInfo":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingPersonalInfoJpaRepository.getPersonalInfos(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingPersonalInfoJpaRepository.getPersonalInfosNotIn(loggedPinKey));
					break;
					
				case "lmPersonalInterest":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingPersonalInterestJpaRepository.getPersonInterestDetails( loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingPersonalInterestJpaRepository.getPersonInterestDetailsNotIn( loggedPinKey));
					break;
	
				case "lmProfessionalInterest":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingProfessionalInterestJpaRepository.getProfInterestDetails( loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingProfessionalInterestJpaRepository.getProfInterestDetailsNotIn( loggedPinKey));
					break;
					
				case "lmPersonalPriorities":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingPersonalPrioritiesJpaRepository.getPersonPriorities( loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingPersonalPrioritiesJpaRepository.getPersonPrioritiesNotIn( loggedPinKey));
					break;
	
				case "lmExperience":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingExperienceJpaRepository.getExperienceDetails( loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingExperienceJpaRepository.getExperienceDetailsNotIn( loggedPinKey));
					break;
					
				case "lmEducation":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingEducationJpaRepository.getEducationDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingEducationJpaRepository.getEducationDetailsNotIn(loggedPinKey));
					break;
	
				case "lmProjectExecuted":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingProjectExecutedJpaRepository.getProjExecutedDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingProjectExecutedJpaRepository.getProjExecutedDetailsNotIn(loggedPinKey));
					break;
					
				case "lmProfessionalExpertise":	
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingProfessionalExpertiseJpaRepository.getProfExpertiesDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingProfessionalExpertiseJpaRepository.getProfExpertiesDetailsNotIn(loggedPinKey));
					break;
	
				case "lmAwardsRecognition":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingAwardsRecognitionJpaRepository.getAwardsRecogDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingAwardsRecognitionJpaRepository.getAwardsRecogDetailsNotIn(loggedPinKey));
					break;
					
				case "lmAddInformation":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingAddInformationJpaRepository.getAddInformationDetsils(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingAddInformationJpaRepository.getAddInformationDetsilsNotIn(loggedPinKey));
					break;
	
				case "lmPersonalRelationships":	
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingPersonalRelationshipsJpaRepository.getPersonRelationShDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingPersonalRelationshipsJpaRepository.getPersonRelationShDetailsNotIn(loggedPinKey));
					break;
					
				case "lmProfessionalRelationship":
					if(readFlag) {
						landingInfoBeanList.addAll(tIdLandingProfessionalRelationshipJpaRepository.getProfRelationShDetails(loggedPinKey));
					}
					landingInfoBeanList.addAll(tIdLandingProfessionalRelationshipJpaRepository.getProfRelationShDetailsNotIn(loggedPinKey));
					break;
			}
		}
		sortedLandingInfoBeanList = landingInfoBeanList.stream().sorted(Comparator.comparing(LandingInfoBean::getCreatedOn).reversed()).collect(Collectors.toList());
		
		if(((page*size)+size)<sortedLandingInfoBeanList.size()) {
			sortedLandingInfoBeanList = sortedLandingInfoBeanList.subList(page*size, (page*size)+size);
		} else if((page*size)<sortedLandingInfoBeanList.size()) {
			sortedLandingInfoBeanList = sortedLandingInfoBeanList.subList(page*size, sortedLandingInfoBeanList.size());
		} 
		else {
			sortedLandingInfoBeanList.clear();
		}
		
		return  sortedLandingInfoBeanList;
	}
	
	@Override
	public List<LandingInfoBean> getAuditLogList(Long pinKey, int page, int size) {
		List<LandingInfoBean> landingInfoBeanList = new ArrayList<LandingInfoBean>();
		List<LandingInfoBean> sortedLandingInfoBeanList = new ArrayList<LandingInfoBean>();
		
		List<TIdLandingEmailEntity> tIdLandingEmailEntityList = tIdLandingEmailJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingEmailEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingPhoneNoEntity>tIdLandingPhoneNoEntityList = tIdLandingPhoneNoJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingPhoneNoEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingHomeEntity> tIdLandingHomeEntityList = tIdLandingHomeJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingHomeEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingDiscussionDtlsEntity> tIdLandingDiscussionDtlsEntityList = tIdLandingDiscussionDtlsJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingDiscussionDtlsEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingBusinessPotentialEntity> tIdLandingBusinessPotentialEntityList = tIdLandingBusinessPotentialJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingBusinessPotentialEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingAddPotentialEntity> tIdLandingAddPotentialEntityList = tIdLandingAddPotentialJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingAddPotentialEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingRecreationEntity> tIdLandingRecreationEntityList = tIdLandingRecreationJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingRecreationEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingPersonalInfoEntity> tIdLandingPersonalInfoEntityList = tIdLandingPersonalInfoJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingPersonalInfoEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingPersonalInterestEntity> tIdLandingPersonalInterestEntityList = tIdLandingPersonalInterestJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingPersonalInterestEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingProfessionalInterestEntity> tIdLandingProfessionalInterestEntityList = tIdLandingProfessionalInterestJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingProfessionalInterestEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingPersonalPrioritiesEntity> tIdLandingPersonalPrioritiesEntityList = tIdLandingPersonalPrioritiesJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingPersonalPrioritiesEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingExperienceEntity> tIdLandingExperienceEntityList = tIdLandingExperienceJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingExperienceEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingEducationEntity> tIdLandingEducationEntityList = tIdLandingEducationJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingEducationEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingProjectExecutedEntity> tIdLandingProjectExecutedEntityList = tIdLandingProjectExecutedJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingProjectExecutedEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingProfessionalExpertiseEntity> tIdLandingProfessionalExpertiseEntityList = tIdLandingProfessionalExpertiseJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingProfessionalExpertiseEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingAwardsRecognitionEntity> tIdLandingAwardsRecognitionEntityList = tIdLandingAwardsRecognitionJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingAwardsRecognitionEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingAddInformationEntity> tIdLandingAddInformationEntityList = tIdLandingAddInformationJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingAddInformationEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingPersonalRelationshipsEntity> tIdLandingPersonalRelationshipsEntityList = tIdLandingPersonalRelationshipsJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingPersonalRelationshipsEntityList, new TypeReference<List<LandingInfoBean>>() { }));
		
		List<TIdLandingProfessionalRelationshipEntity> tIdLandingProfessionalRelationshipEntityList = tIdLandingProfessionalRelationshipJpaRepository.findByLdContactPinKey(pinKey);
		landingInfoBeanList.addAll(objectMapper.convertValue(tIdLandingProfessionalRelationshipEntityList, new TypeReference<List<LandingInfoBean>>() { }));
				
		//Here we are sorting LandingInfoBean List in descending order based on createdOn Date...!!
		sortedLandingInfoBeanList = landingInfoBeanList.stream().sorted(Comparator.comparing(LandingInfoBean::getCreatedOn).reversed()).collect(Collectors.toList());
		
		/*if(((page*size)+size)<sortedLandingInfoBeanList.size()) {
			sortedLandingInfoBeanList = sortedLandingInfoBeanList.subList(page*size, (page*size)+size);
		} else {
			sortedLandingInfoBeanList.clear();
		}*/
			
		return sortedLandingInfoBeanList;
	}

	@Override
	public String saveNotification(TIdLandingNotification tIdLandingNotification) {

		if(tIdLandingNotification.getLdAppRejFlag()==1) {
			tIdLandingNotificationJpaRepository.updateAppRejectFlag(tIdLandingNotification.getLdAppRejFlag(), tIdLandingNotification.getLdKey());
			
		} else {
			TIdLandingNotificationEntity tIdLandingNotificationEntity = new TIdLandingNotificationEntity();
			tIdLandingNotificationEntity.setLdUserPinKey(tIdLandingNotification.getLdUserPinKey());
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdLandingNotification.getLdUserPinKey());
			if(personIndividualExperienceViewEntity != null) {
				tIdLandingNotificationEntity.setLdUserTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
				tIdLandingNotificationEntity.setLdUserName(personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName());
			}
			tIdLandingNotificationEntity.setLdContactPinKey(tIdLandingNotification.getLdContactPinKey());
			personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdLandingNotification.getLdContactPinKey());
			if(personIndividualExperienceViewEntity != null) {
				tIdLandingNotificationEntity.setLdContactTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
				tIdLandingNotificationEntity.setLdContactName(personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName());
				tIdLandingNotificationEntity.setLdCompany(personIndividualExperienceViewEntity.getCompany());
				tIdLandingNotificationEntity.setLdIndustry(tIdCompanyIndustryLinkViewJpaRepository.getName(personIndividualExperienceViewEntity.getPexKey()));
				tIdLandingNotificationEntity.setLdCountry(personIndividualExperienceViewEntity.getPinCountryName());
			}
			tIdLandingNotificationEntity.setLdBoxName(NEW_CONTACT);
			tIdLandingNotificationEntity.setLdFieldName(NEW_CONTACT);
			
			if(tIdLandingNotification.getLdAppRejFlag()==0) {
				tIdLandingNotificationEntity.setLdLatestUpdate(tIdLandingNotificationEntity.getLdUserName()+" has requested to add this contacts in your contact list");
				
			}  else if(tIdLandingNotification.getLdAppRejFlag()==2) {
				
				tIdLandingNotificationJpaRepository.updateAppRejectFlag(tIdLandingNotification.getLdAppRejFlag(), tIdLandingNotification.getLdKey());
				
				tIdLandingNotificationEntity.setLdLatestUpdate(tIdLandingNotificationEntity.getLdUserName()+" has rejected your new contact request");
			}
			
			tIdLandingNotificationEntity.setLdAppRejFlag(0L);
			tIdLandingNotificationEntity.setLdToPinKey(tIdLandingNotification.getLdToPinKey());
			personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdLandingNotification.getLdToPinKey());
			if(personIndividualExperienceViewEntity != null) {
				tIdLandingNotificationEntity.setLdToTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
				tIdLandingNotificationEntity.setLdToName(personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName());
			}
			tIdLandingNotificationEntity.setLdReadFlag(false);
			tIdLandingNotificationEntity.setLockKey(1L);
			tIdLandingNotificationEntity.setProfileKey(1L);
			tIdLandingNotificationEntity.setCreatedOn(new Date());
			tIdLandingNotificationEntity.setLdRequest(true);
			tIdLandingNotificationJpaRepository.save(tIdLandingNotificationEntity);		
		}
		return "Success";
	}
	
	@Override
	public boolean removeNotification(TIdLandingNotification tIdLandingNotification) {
		tIdLandingNotificationJpaRepository.deleteNotification(tIdLandingNotification.getLdContactPinKey());
		return true;
	}

	@Override
	public TIdLandingMaster getNotificationLeftMenu(Long loggedPinKey) {
		TIdLandingMaster tIdLandingMaster = new TIdLandingMaster();
		tIdLandingMaster.setLmNewContact(Long.sum(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, NEW_CONTACT),
				tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, "Complete Profile")));
		tIdLandingMaster.setLmEmail(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, HEADER_INFO, EMAIL_ID));
		Long landLine = tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, HEADER_INFO, LANDLINE_NUMBER);
		Long mobile = tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, HEADER_INFO, MOBILE_NUMBER);
		tIdLandingMaster.setLmPhoneNo(landLine+mobile);
		tIdLandingMaster.setLmHome(0L);
		tIdLandingMaster.setLmDiscussionDtls(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, DISCUSSION_DETAILS));
		tIdLandingMaster.setLmBusinessPotential(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, BUSINESS_POTENTIAL));
		tIdLandingMaster.setLmAddPotential(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, ADD_POTENTIAL));
		tIdLandingMaster.setLmRecreation(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, RECREATION));
		tIdLandingMaster.setLmPersonalInfo(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PERSONAL_INFO));
		tIdLandingMaster.setLmPersonalInterest(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PERSONAL_INTEREST));
		tIdLandingMaster.setLmProfessionalInterest(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PROFESSIONAL_INTEREST));
		tIdLandingMaster.setLmPersonalPriorities(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PERSONAL_PRIORITIES));
		tIdLandingMaster.setLmExperience(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, EXPERIENCE));
		tIdLandingMaster.setLmEducation(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, EDUCATION));
		tIdLandingMaster.setLmProjectExecuted(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PROJ_EXECUTED));
		tIdLandingMaster.setLmProfessionalExpertise(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PROF_EXPERTISE));
		tIdLandingMaster.setLmAwardsRecognition(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, AWARDS_RECOG));
		tIdLandingMaster.setLmAddInformation(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, ADD_INFORMATION));
		tIdLandingMaster.setLmPersonalRelationships(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PERSONAL_RELATIONSHIP));
		tIdLandingMaster.setLmProfessionalRelationship(tIdLandingNotificationJpaRepository.getNotificationCount(loggedPinKey, PROFESSIONAL_RELATIONSHIP)); 
		
		tIdLandingMaster.setUnReadContacts(tIdLandingMaster.getLmNewContact()+tIdLandingMaster.getLmEmail()+tIdLandingMaster.getLmPhoneNo()
					+tIdLandingMaster.getLmHome()+tIdLandingMaster.getLmDiscussionDtls()+tIdLandingMaster.getLmBusinessPotential()
					+tIdLandingMaster.getLmAddPotential()+tIdLandingMaster.getLmRecreation()+tIdLandingMaster.getLmPersonalInfo()
					+tIdLandingMaster.getLmPersonalInterest()+tIdLandingMaster.getLmProfessionalInterest()+tIdLandingMaster.getLmPersonalPriorities()
					+tIdLandingMaster.getLmExperience()+tIdLandingMaster.getLmEducation()+tIdLandingMaster.getLmProjectExecuted()
					+tIdLandingMaster.getLmProfessionalExpertise()+tIdLandingMaster.getLmAwardsRecognition()+tIdLandingMaster.getLmAddInformation()
					+tIdLandingMaster.getLmPersonalRelationships()+tIdLandingMaster.getLmProfessionalRelationship());
		return tIdLandingMaster;
	}
	
	public ToolTipNotificationLandBean getToolTipDataNotification(String ldBoxName, Long loggedPinKey, int page, int size){
		ToolTipNotificationLandBean toolTipNotificationLandBean = null;
		List<TIdLandingNotification> sortedLandingInfoBeanList =  getNotificationList(ldBoxName,loggedPinKey,page,size);
		if(sortedLandingInfoBeanList!=null && sortedLandingInfoBeanList.size()>0) {
			toolTipNotificationLandBean = new ToolTipNotificationLandBean();
			toolTipNotificationLandBean.setSortedLandingNotificationList(sortedLandingInfoBeanList);
			Set<Long> pinKeys= new HashSet<Long>();
			for (TIdLandingNotification tIdLandingNotificationObj : sortedLandingInfoBeanList) {
				pinKeys.add(tIdLandingNotificationObj.getLdUserPinKey());
				pinKeys.add(tIdLandingNotificationObj.getLdContactPinKey());
			}
			if(!(pinKeys.isEmpty())) {
				Map<Long,ToolTipBean> toolTipMap =  toolTipService(pinKeys);
				if(!(toolTipMap.isEmpty())) {
					toolTipNotificationLandBean.setToolTipMap(toolTipMap);
				}	
			}
		}
		return toolTipNotificationLandBean;
	}
	
	public ToolTipNotificationLandBean getToolTipDataLanding(String ldBoxName, Date createdOn,  Long loggedPinKey, int page, int size){
		ToolTipNotificationLandBean toolTipNotificationLandBean = null;
		List<LandingInfoBean> sortedLandingInfoBeanList =  getLandPageList(ldBoxName,createdOn,loggedPinKey,page,size);
		if(sortedLandingInfoBeanList!=null && sortedLandingInfoBeanList.size()>0) {
			toolTipNotificationLandBean = new ToolTipNotificationLandBean();
			toolTipNotificationLandBean.setSortedLandingInfoBeanList(sortedLandingInfoBeanList);
			Set<Long> pinKeys= new HashSet<Long>();
			for (LandingInfoBean landingInfoBean : sortedLandingInfoBeanList) {
				pinKeys.add(landingInfoBean.getLdUserPinKey());
				pinKeys.add(landingInfoBean.getLdContactPinKey());
			}
			if(!(pinKeys.isEmpty())) {
				Map<Long,ToolTipBean> toolTipMap =  toolTipService(pinKeys);
				if(!(toolTipMap.isEmpty())) {
					toolTipNotificationLandBean.setToolTipMap(toolTipMap);
				}	
			}
		}
		return toolTipNotificationLandBean;
	}
	
	@Override
	public List<TIdLandingNotification> getNotificationList(String menuType, Long loggedPinKey, int page, int size) {
		List<TIdLandingNotification> tIdLandingNotification = new ArrayList<TIdLandingNotification>();		
		List<TIdLandingNotification> sortedLandingInfoBeanList = new ArrayList<TIdLandingNotification>();
		
		switch(menuType) {
			
			case "unReadContacts":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, false, new PageRequest(page, size)));
				break;
			
			case "lmNewContact":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, NEW_CONTACT, new PageRequest(page, size)));
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, "Complete Profile", new PageRequest(page, size)));
				break;
				
			case "lmEmail":	
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, HEADER_INFO, EMAIL_ID, new PageRequest(page, size)));
				break;
				
			case "lmPhoneNo":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, HEADER_INFO, LANDLINE_NUMBER, new PageRequest(page, size)));
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, HEADER_INFO, MOBILE_NUMBER, new PageRequest(page, size)));
				break;
				
			case "lmHome":
				// To check
				break;
				
			case "lmDiscussionDtls":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, DISCUSSION_DETAILS, new PageRequest(page, size)));
				break;
				
			case "lmBusinessPotential":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, BUSINESS_POTENTIAL, new PageRequest(page, size)));
				break;
				
			case "lmAddPotential":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, ADD_POTENTIAL, new PageRequest(page, size)));
				break;
				
			case "lmRecreation":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, RECREATION, new PageRequest(page, size)));
				break;
				
			case "lmPersonalInfo":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PERSONAL_INFO, new PageRequest(page, size)));
				break;
				
			case "lmPersonalInterest":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PERSONAL_INTEREST, new PageRequest(page, size)));
				break;
				
			case "lmProfessionalInterest":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PROFESSIONAL_INTEREST, new PageRequest(page, size)));
				break;
				
			case "lmPersonalPriorities":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PERSONAL_PRIORITIES, new PageRequest(page, size)));
				break;
				
			case "lmExperience":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, EXPERIENCE, new PageRequest(page, size)));
				break;
				
			case "lmEducation":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, EDUCATION, new PageRequest(page, size)));
				break;
				
			case "lmProjectExecuted":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PROJ_EXECUTED, new PageRequest(page, size)));
				break;
				
			case "lmProfessionalExpertise":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PROF_EXPERTISE, new PageRequest(page, size)));
				break;
				
			case "lmAwardsRecognition":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, AWARDS_RECOG, new PageRequest(page, size)));
				break;
				
			case "lmAddInformation":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, ADD_INFORMATION, new PageRequest(page, size)));
				break;
				
			case "lmPersonalRelationships":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PERSONAL_RELATIONSHIP, new PageRequest(page, size)));
				break;
				
			case "lmProfessionalRelationship":
				tIdLandingNotification.addAll(tIdLandingNotificationJpaRepository.getNotificationList(loggedPinKey, PROFESSIONAL_RELATIONSHIP, new PageRequest(page, size)));
				break;
		}
		
		sortedLandingInfoBeanList = tIdLandingNotification.stream().sorted(Comparator.comparing(TIdLandingNotification::getCreatedOn).reversed()).collect(Collectors.toList());
		return sortedLandingInfoBeanList;
	}
	
	public Map<Long,ToolTipBean> toolTipService(Set<Long> pinKeys) {
		Map<Long,ToolTipBean> toolTipMap =  new LinkedHashMap<Long, ToolTipBean>();
		for (Long pinKey : pinKeys) {
			ToolTipBean toolTipBean = new ToolTipBean();
			
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(pinKey);
			if(personIndividualExperienceViewEntity!=null) {
				if(personIndividualExperienceViewEntity.getPinTitle()!=null) {
					toolTipBean.setTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
					toolTipBean.setFirstName(personIndividualExperienceViewEntity.getPinFirstName());
					toolTipBean.setLastName(personIndividualExperienceViewEntity.getPinLastName());
					toolTipBean.setDesifnation(personIndividualExperienceViewEntity.getDesignation());
					toolTipBean.setFunction(personIndividualExperienceViewEntity.getFunctionalArea());toolTipBean.setIndustry(tIdCompanyIndustryLinkViewJpaRepository.getName(personIndividualExperienceViewEntity.getPexKey()));
					toolTipBean.setRole(personIndividualExperienceViewEntity.getRole());
					toolTipBean.setCompany(personIndividualExperienceViewEntity.getCompany());
					toolTipBean.setPinKey(pinKey);
					toolTipBean.setProfileKey(personIndividualExperienceViewEntity.getProfileKey());
				}
			}
			if(personIndividualExperienceViewEntity.getPexKey()!=null) {
				TIdExperienceInformationViewEntity tIdExperienceInformationViewEntity = tIdExperienceInformationViewJpaRepository.findOne(personIndividualExperienceViewEntity.getPexKey());
				if(tIdExperienceInformationViewEntity!=null) {
					toolTipBean.setCity(tIdExperienceInformationViewEntity.getCity());
					toolTipBean.setCountry(tIdExperienceInformationViewEntity.getCountry());
					toolTipBean.setState(tIdExperienceInformationViewEntity.getState());
					toolTipBean.setPattFileName(personIndividualExperienceViewEntity.getPattInternalFileName());
				}
			}
			
			List<TIdCompanyContactLinkViewEntity> tIdCompanyContactLinkViewEntityList = tIdCompanyContactLinkViewJpaRepository.findByCclPinKey(pinKey);
			 if(tIdCompanyContactLinkViewEntityList.size()>0) {
					 toolTipBean.setRelationship(tIdCompanyContactLinkViewEntityList.get(0).getCclCompanyRelationValue() +" of "+
						 	tIdCompanyContactLinkViewEntityList.get(0).getCclCompanyName());
			} else {
				List<TIdRelationshipInfoLinkViewEntity> tIdRelationshipInfoLinkViewEntityList = tIdRelationshipInfoLinkViewJpaRepository.findByPrlkToPinKey(pinKey);
				 if(tIdRelationshipInfoLinkViewEntityList.size()>0) {
					 toolTipBean.setRelationship(tIdRelationshipInfoLinkViewEntityList.get(0).getPrlkRelationship()+" of " + 
							 tIdRelationshipInfoLinkViewEntityList.get(0).getPinFirstName()+" " +
							 tIdRelationshipInfoLinkViewEntityList.get(0).getPinLirstName());
				 }
			}
			toolTipMap.put(pinKey,toolTipBean);
		}
		return toolTipMap;
	}

	@Override
	public String updateNotification(Long ldKey) {
		int updatedrecordsCount = tIdLandingNotificationJpaRepository.updateNotification(ldKey);
		return updatedrecordsCount+" Records Updated";
	}

	@Override
	public TIdLandingMaster getTopMenuCount(Long pinKey,Date createdOn) {
		TIdLandingMaster tIdLandingMaster = new TIdLandingMaster();
		tIdLandingMaster.setContact(tIdPersonalInformationJpaRepository.getContactCount());
		tIdLandingMaster.setTeam(personIndividualExperienceViewJpaRepository.getProfileCount());
		tIdLandingMaster.setNotification(tIdPersonalInformationJpaRepository.getNotificationCount(pinKey));
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = getMyContactInfoList(pinKey);
		tIdLandingMaster.setMyContact(personIndividualExperienceViewEntityList.size()>0?personIndividualExperienceViewEntityList.size():0L);
		tIdLandingMaster.setFavorite(tIdPersonalInformationJpaRepository.getFavoritesCount(pinKey));
		TIdLandingMaster tIdLandingMaster2 = getLandMenuCount(createdOn, pinKey);
		tIdLandingMaster.setNewUpdate(tIdLandingMaster2.getUnReadContacts());		
		return tIdLandingMaster;
	}
	
	@Override
	public TIdLandingMaster getContactsInfo() {
		TIdLandingMaster tIdLandingMaster = new TIdLandingMaster();
		//Traceable - if any one of the communications(email,mobile and landline) are available. it is treating as a Traceable.
		tIdLandingMaster.setTraceable(tIdPersonalInformationViewJpaRepository.getTraceableCount());
		//Non-Traceable - If any one of the communications(email,mobile and lindline) are not available, it is treating as NotTraceable.
		tIdLandingMaster.setNonTraceable(tIdPersonalInformationViewJpaRepository.getNonTraceableCount());
		return tIdLandingMaster;
	}


	@Override
	public List<PersonIndividualExperienceViewEntity> getMyContactInfoList(Long pinKey) {
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = new ArrayList<PersonIndividualExperienceViewEntity>();   
		List<TIdMyContactsLinkEntity> tIdMyContactsLinkEntityList;

		List<Long> shadowContactsKeys = tIdRelationshipInfoLinkJpaRepository.getPrlkToPinKey(pinKey);
		if(shadowContactsKeys.size()>0) {
			/*TKT/2020/05/002728	
			  Shadow contact shuould not coming in myConcat  thats why we commetted
			List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList2 = personIndividualExperienceViewJpaRepository.findByPinKeyIn(toPinKeyList);
			for(PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity : personIndividualExperienceViewEntityList2) {
				TIdMyContactsLinkEntity tIdMyContactsLinkEntity = tIdMyContactsLinkJpaRepository.getMyContactsFromAndTo(pinKey, personIndividualExperienceViewEntity.getPinKey());
				personIndividualExperienceViewEntity.setStarRating(
						tIdMyContactsLinkEntity!=null?tIdMyContactsLinkEntity.getMclStarRating()!=null?tIdMyContactsLinkEntity.getMclStarRating():0L:0L);
				personIndividualExperienceViewEntityList.add(personIndividualExperienceViewEntity);
			}
			TKT/2020/05/002728	*/
			tIdMyContactsLinkEntityList = tIdMyContactsLinkJpaRepository.findByMclFromPinKeyAndMclToPinKeyNotInAndActiveStatus(pinKey, shadowContactsKeys, ACTIVE);
		} else {
			tIdMyContactsLinkEntityList = tIdMyContactsLinkJpaRepository.findByMclFromPinKeyAndActiveStatus(pinKey, ACTIVE);
		}
		
		for(TIdMyContactsLinkEntity tIdMyContactsLinkEntity : tIdMyContactsLinkEntityList) {
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdMyContactsLinkEntity.getMclToPinKey());
			personIndividualExperienceViewEntity.setStarRating(
					tIdMyContactsLinkEntity.getMclStarRating()!=null?tIdMyContactsLinkEntity.getMclStarRating():0L);
			personIndividualExperienceViewEntityList.add(personIndividualExperienceViewEntity);
		}
		
		return personIndividualExperienceViewEntityList;
	}
	
	

	@Override
	public List<TIdProfileFollowDetailsViewEntity> getMyContactFollowList(Long pinKey) {
		return tIdProfileFollowDetailsViewJpaRepository.findByPfdPinKeyAndActiveStatus(pinKey,"A");
	}
	
	@Override
	public List<TIdProfileFollowDetailsView> getFavoriteFollowList(Long pinKey) {
		List<TIdProfileFollowDetailsViewEntity> tIdProfileFollowDetailsViewEntityList = tIdProfileFollowDetailsViewJpaRepository.findByPfdPinFollowbyKeyAndActiveStatus(pinKey,"A");
		List<TIdProfileFollowDetailsView> tIdProfileFollowDetailsViewList = objectMapper.convertValue(tIdProfileFollowDetailsViewEntityList, new TypeReference<List<TIdProfileFollowDetailsView>>() { });
		
		for(TIdProfileFollowDetailsView tIdProfileFollowDetailsView : tIdProfileFollowDetailsViewList) {
			 PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = 
					 personIndividualExperienceViewJpaRepository.findOne(tIdProfileFollowDetailsView.getPfdPinKey());
				if(personIndividualExperienceViewEntity != null) {
					tIdProfileFollowDetailsView.setCompanyName(personIndividualExperienceViewEntity.getCompany());
					tIdProfileFollowDetailsView.setDesignation(personIndividualExperienceViewEntity.getDesignation());
					tIdProfileFollowDetailsView.setRole(personIndividualExperienceViewEntity.getRole());
					tIdProfileFollowDetailsView.setFunctionalArea(personIndividualExperienceViewEntity.getFunctionalArea());
					tIdProfileFollowDetailsView.setPattInternalFileName(personIndividualExperienceViewEntity.getPattInternalFileName());
					tIdProfileFollowDetailsView.setPattReferenceKey(personIndividualExperienceViewEntity.getPattReferenceKey());
					tIdProfileFollowDetailsView.setPinFirstName(personIndividualExperienceViewEntity.getPinFirstName());
					tIdProfileFollowDetailsView.setPinLastName(personIndividualExperienceViewEntity.getPinLastName());
					tIdProfileFollowDetailsView.setFollowedByProfileKey(personIndividualExperienceViewEntity.getUserKey());
				}
		}
		return tIdProfileFollowDetailsViewList;
	}

	@Override
	public TIdLandingMaster getMyContactLeftMenu(Date logoutDate, Long loggedPinKey, String topMenuType) {
		List<Long> toPinKey = null;
		TIdLandingMaster tIdLandingMaster = new TIdLandingMaster();
		if("myContact".equals(topMenuType)) {
			toPinKey = tIdMyContactsLinkJpaRepository.getMyContactList(loggedPinKey);
		} else {
			toPinKey = tIdProfileFollowDetailsJpaRepository.getMyFollowList(loggedPinKey);
		}
		
		if(toPinKey.size()>0) {
			tIdLandingMaster.setLmEmail(tIdLandingEmailJpaRepository.getEmailIdsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmPhoneNo(tIdLandingPhoneNoJpaRepository.getPhoneNumbersCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmHome(tIdLandingHomeJpaRepository.getHomesCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmDiscussionDtls(tIdLandingDiscussionDtlsJpaRepository.getdiscussDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmBusinessPotential(tIdLandingBusinessPotentialJpaRepository.getBusinPotentialCounts(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmAddPotential(tIdLandingAddPotentialJpaRepository.getAddPotentialsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmRecreation(tIdLandingRecreationJpaRepository.getRecreationDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmPersonalInfo(tIdLandingPersonalInfoJpaRepository.getPersonalInfosCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmPersonalInterest(tIdLandingPersonalInterestJpaRepository.getPersonInterestDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmProfessionalInterest(tIdLandingProfessionalInterestJpaRepository.getProfInterestDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmPersonalPriorities(tIdLandingPersonalPrioritiesJpaRepository.getPersonPrioritiesCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmExperience(tIdLandingExperienceJpaRepository.getExperienceDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmEducation(tIdLandingEducationJpaRepository.getdiscussDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmProjectExecuted(tIdLandingProjectExecutedJpaRepository.getProjExecutedDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmProfessionalExpertise(tIdLandingProfessionalExpertiseJpaRepository.getProfExpertiesDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmAwardsRecognition(tIdLandingAwardsRecognitionJpaRepository.getAwardsRecogDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmAddInformation(tIdLandingAddInformationJpaRepository.getAddInformationDetsilsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmPersonalRelationships(tIdLandingPersonalRelationshipsJpaRepository.getPersonRelationShDetailsCount(logoutDate,toPinKey,loggedPinKey));
			tIdLandingMaster.setLmProfessionalRelationship(tIdLandingProfessionalRelationshipJpaRepository.getProfRelationShDetailsCount(logoutDate,toPinKey,loggedPinKey)); 
		
		tIdLandingMaster.setUnReadContacts(tIdLandingMaster.getLmEmail()+tIdLandingMaster.getLmPhoneNo()
					+tIdLandingMaster.getLmHome()+tIdLandingMaster.getLmDiscussionDtls()+tIdLandingMaster.getLmBusinessPotential()
					+tIdLandingMaster.getLmAddPotential()+tIdLandingMaster.getLmRecreation()+tIdLandingMaster.getLmPersonalInfo()
					+tIdLandingMaster.getLmPersonalInterest()+tIdLandingMaster.getLmProfessionalInterest()+tIdLandingMaster.getLmPersonalPriorities()
					+tIdLandingMaster.getLmExperience()+tIdLandingMaster.getLmEducation()+tIdLandingMaster.getLmProjectExecuted()
					+tIdLandingMaster.getLmProfessionalExpertise()+tIdLandingMaster.getLmAwardsRecognition()+tIdLandingMaster.getLmAddInformation()
					+tIdLandingMaster.getLmPersonalRelationships()+tIdLandingMaster.getLmProfessionalRelationship());
		}
		return tIdLandingMaster;
		
	}

	@Override
	public List<LandingInfoBean> getMyContactLandList(Date logoutDate, Long loggedPinKey, String menuType, String topMenuType) {
		List<LandingInfoBean> landingInfoBeanList = new ArrayList<LandingInfoBean>();
		List<LandingInfoBean> sortedLandingInfoBeanList = new ArrayList<LandingInfoBean>();
		
		List<Long> toPinKey = null;
		if("myContact".equals(topMenuType)) {
			toPinKey = tIdMyContactsLinkJpaRepository.getMyContactList(loggedPinKey);
		} else {
			toPinKey = tIdProfileFollowDetailsJpaRepository.getMyFollowList(loggedPinKey);
		}		
		
		if(toPinKey.size()>0) {
			List<String> menuList = new ArrayList<String>();
			
			if(menuType.equals("unReadContacts")) {
				menuList.addAll(LEFT_MENU_LIST);
			} else {
				menuList.add(menuType);
			}
			
			for(String menu : menuList) {
	
				switch(menu) {
					
					case "lmEmail":
						landingInfoBeanList.addAll(tIdLandingEmailJpaRepository.getEmailIds(logoutDate,toPinKey,loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingEmailJpaRepository.getEmailIdsNotIn(logoutDate,toPinKey,loggedPinKey));				
						break;
						
					case "lmPhoneNo":
						landingInfoBeanList.addAll(tIdLandingPhoneNoJpaRepository.getPhoneNumbers(logoutDate,toPinKey,loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingPhoneNoJpaRepository.getPhoneNumbersNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmHome":
						landingInfoBeanList.addAll(tIdLandingHomeJpaRepository.getHomes(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingHomeJpaRepository.getHomesNotIn(logoutDate, toPinKey, loggedPinKey));				
						break;
		
					case "lmDiscussionDtls":
						landingInfoBeanList.addAll(tIdLandingDiscussionDtlsJpaRepository.getdiscussDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingDiscussionDtlsJpaRepository.getdiscussDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
					
					case "lmBusinessPotential":			
						landingInfoBeanList.addAll(tIdLandingBusinessPotentialJpaRepository.getBusinPotentials(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingBusinessPotentialJpaRepository.getBusinPotentialsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmAddPotential":
						landingInfoBeanList.addAll(tIdLandingAddPotentialJpaRepository.getAddPotentials(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingAddPotentialJpaRepository.getAddPotentialsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmRecreation":
						landingInfoBeanList.addAll(tIdLandingRecreationJpaRepository.getRecreationDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingRecreationJpaRepository.getRecreationDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmPersonalInfo":
						landingInfoBeanList.addAll(tIdLandingPersonalInfoJpaRepository.getPersonalInfos(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingPersonalInfoJpaRepository.getPersonalInfosNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmPersonalInterest":
						landingInfoBeanList.addAll(tIdLandingPersonalInterestJpaRepository.getPersonInterestDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingPersonalInterestJpaRepository.getPersonInterestDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmProfessionalInterest":
						landingInfoBeanList.addAll(tIdLandingProfessionalInterestJpaRepository.getProfInterestDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingProfessionalInterestJpaRepository.getProfInterestDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmPersonalPriorities":
						landingInfoBeanList.addAll(tIdLandingPersonalPrioritiesJpaRepository.getPersonPriorities(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingPersonalPrioritiesJpaRepository.getPersonPrioritiesNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmExperience":
						landingInfoBeanList.addAll(tIdLandingExperienceJpaRepository.getExperienceDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingExperienceJpaRepository.getExperienceDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmEducation":
						landingInfoBeanList.addAll(tIdLandingEducationJpaRepository.getEducationDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingEducationJpaRepository.getEducationDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmProjectExecuted":
						landingInfoBeanList.addAll(tIdLandingProjectExecutedJpaRepository.getProjExecutedDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingProjectExecutedJpaRepository.getProjExecutedDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmProfessionalExpertise":
						landingInfoBeanList.addAll(tIdLandingProfessionalExpertiseJpaRepository.getProfExpertiesDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingProfessionalExpertiseJpaRepository.getProfExpertiesDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmAwardsRecognition":
						landingInfoBeanList.addAll(tIdLandingAwardsRecognitionJpaRepository.getAwardsRecogDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingAwardsRecognitionJpaRepository.getAwardsRecogDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmAddInformation":
						landingInfoBeanList.addAll(tIdLandingAddInformationJpaRepository.getAddInformationDetsils(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingAddInformationJpaRepository.getAddInformationDetsilsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
		
					case "lmPersonalRelationships":
						landingInfoBeanList.addAll(tIdLandingPersonalRelationshipsJpaRepository.getPersonRelationShDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingPersonalRelationshipsJpaRepository.getPersonRelationShDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
						
					case "lmProfessionalRelationship":
						landingInfoBeanList.addAll(tIdLandingProfessionalRelationshipJpaRepository.getProfRelationShDetails(logoutDate, toPinKey, loggedPinKey));
						landingInfoBeanList.addAll(tIdLandingProfessionalRelationshipJpaRepository.getProfRelationShDetailsNotIn(logoutDate, toPinKey, loggedPinKey));
						break;
				}
			}
		}
		//Here we are sorting LandingInfoBean List as descending order based on createdOn Date...!!
		sortedLandingInfoBeanList = landingInfoBeanList.stream().sorted(Comparator.comparing(LandingInfoBean::getCreatedOn).reversed()).collect(Collectors.toList());
		
		return sortedLandingInfoBeanList;
		
	}

	@Override
	public String saveLandPageLink(Long ldKey, Long loggedPinKey, String menuType ) {
		
		switch(menuType) {
			
			case "lmEmail":
				TIdLandingEmailLinkEntity tIdLandingEmailLinkEntity = tIdLandingEmailLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey,loggedPinKey);
				if(tIdLandingEmailLinkEntity==null) {
					tIdLandingEmailLinkEntity = new TIdLandingEmailLinkEntity();
					tIdLandingEmailLinkEntity.setLlLdKey(ldKey);
					tIdLandingEmailLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingEmailLinkEntity.setLockKey(0L);
					tIdLandingEmailLinkEntity.setProfileKey(1L);
					tIdLandingEmailLinkJpaRepository.save(tIdLandingEmailLinkEntity);
				}
			break;
			
			case "lmPhoneNo":
				TIdLandingPhoneNoLinkEntity tIdLandingPhoneNoLinkEntity = tIdLandingPhoneNoLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingPhoneNoLinkEntity==null) {
					tIdLandingPhoneNoLinkEntity = new TIdLandingPhoneNoLinkEntity();
					tIdLandingPhoneNoLinkEntity.setLlLdKey(ldKey);
					tIdLandingPhoneNoLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingPhoneNoLinkEntity.setLockKey(0L);
					tIdLandingPhoneNoLinkEntity.setProfileKey(1L);
					tIdLandingPhoneNoLinkJpaRepository.save(tIdLandingPhoneNoLinkEntity);
				}
				break;
				
			case "lmHome":
				TIdLandingHomeLinkEntity tIdLandingHomeLinkEntity = tIdLandingHomeLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingHomeLinkEntity==null) {
					tIdLandingHomeLinkEntity = new TIdLandingHomeLinkEntity();
					tIdLandingHomeLinkEntity.setLlLdKey(ldKey);
					tIdLandingHomeLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingHomeLinkEntity.setLockKey(0L);
					tIdLandingHomeLinkEntity.setProfileKey(1L);
					tIdLandingHomeLinkJpaRepository.save(tIdLandingHomeLinkEntity);
				}
				break;

			case "lmDiscussionDtls":
				TIdLandingDiscussionDtlsLinkEntity tIdLandingDiscussionDtlsLinkEntity = tIdLandingDiscussionDtlsLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingDiscussionDtlsLinkEntity==null) {
					tIdLandingDiscussionDtlsLinkEntity = new TIdLandingDiscussionDtlsLinkEntity();
					tIdLandingDiscussionDtlsLinkEntity.setLlLdKey(ldKey);
					tIdLandingDiscussionDtlsLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingDiscussionDtlsLinkEntity.setLockKey(0L);
					tIdLandingDiscussionDtlsLinkEntity.setProfileKey(1L);
					tIdLandingDiscussionDtlsLinkJpaRepository.save(tIdLandingDiscussionDtlsLinkEntity);
				}
				break;
			
			case "lmBusinessPotential":
				TIdLandingBusinessPotentialLinkEntity tIdLandingBusinessPotentialLinkEntity = tIdLandingBusinessPotentialLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingBusinessPotentialLinkEntity==null) {
					tIdLandingBusinessPotentialLinkEntity = new TIdLandingBusinessPotentialLinkEntity();
					tIdLandingBusinessPotentialLinkEntity.setLlLdKey(ldKey);
					tIdLandingBusinessPotentialLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingBusinessPotentialLinkEntity.setLockKey(0L);
					tIdLandingBusinessPotentialLinkEntity.setProfileKey(1L);
					tIdLandingBusinessPotentialLinkJpaRepository.save(tIdLandingBusinessPotentialLinkEntity);
				}
				break;

			case "lmAddPotential":
				TIdLandingAddPotentialLinkEntity tIdLandingAddPotentialLinkEntity = tIdLandingAddPotentialLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingAddPotentialLinkEntity==null) {
					tIdLandingAddPotentialLinkEntity = new TIdLandingAddPotentialLinkEntity();
					tIdLandingAddPotentialLinkEntity.setLlLdKey(ldKey);
					tIdLandingAddPotentialLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingAddPotentialLinkEntity.setLockKey(0L);
					tIdLandingAddPotentialLinkEntity.setProfileKey(1L);
					tIdLandingAddPotentialLinkJpaRepository.save(tIdLandingAddPotentialLinkEntity);
				}
				break;
				
			case "lmRecreation":
				TIdLandingRecreationLinkEntity tIdLandingRecreationLinkEntity = tIdLandingRecreationLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingRecreationLinkEntity==null) {
					tIdLandingRecreationLinkEntity = new TIdLandingRecreationLinkEntity();
					tIdLandingRecreationLinkEntity.setLlLdKey(ldKey);
					tIdLandingRecreationLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingRecreationLinkEntity.setLockKey(0L);
					tIdLandingRecreationLinkEntity.setProfileKey(1L);
					tIdLandingRecreationLinkJpaRepository.save(tIdLandingRecreationLinkEntity);
				}
				break;

			case "lmPersonalInfo":
				TIdLandingPersonalInfoLinkEntity tIdLandingPersonalInfoLinkEntity = tIdLandingPersonalInfoLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingPersonalInfoLinkEntity==null) {
					tIdLandingPersonalInfoLinkEntity = new TIdLandingPersonalInfoLinkEntity();
					tIdLandingPersonalInfoLinkEntity.setLlLdKey(ldKey);
					tIdLandingPersonalInfoLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingPersonalInfoLinkEntity.setLockKey(0L);
					tIdLandingPersonalInfoLinkEntity.setProfileKey(1L);
					tIdLandingPersonalInfoLinkJpaRepository.save(tIdLandingPersonalInfoLinkEntity);
				}
				break;
				
			case "lmPersonalInterest":
				TIdLandingPersonalInterestLinkEntity tIdLandingPersonalInterestLinkEntity = tIdLandingPersonalInterestLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingPersonalInterestLinkEntity==null) {
					tIdLandingPersonalInterestLinkEntity = new TIdLandingPersonalInterestLinkEntity();
					tIdLandingPersonalInterestLinkEntity.setLlLdKey(ldKey);
					tIdLandingPersonalInterestLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingPersonalInterestLinkEntity.setLockKey(0L);
					tIdLandingPersonalInterestLinkEntity.setProfileKey(1L);
					tIdLandingPersonalInterestLinkJpaRepository.save(tIdLandingPersonalInterestLinkEntity);
				}
				break;

			case "lmProfessionalInterest":
				TIdLandingProfessionalInterestLinkEntity tIdLandingProfessionalInterestLinkEntity = tIdLandingProfessionalInterestLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingProfessionalInterestLinkEntity==null) {
					tIdLandingProfessionalInterestLinkEntity = new TIdLandingProfessionalInterestLinkEntity();
					tIdLandingProfessionalInterestLinkEntity.setLlLdKey(ldKey);
					tIdLandingProfessionalInterestLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingProfessionalInterestLinkEntity.setLockKey(0L);
					tIdLandingProfessionalInterestLinkEntity.setProfileKey(1L);
					tIdLandingProfessionalInterestLinkJpaRepository.save(tIdLandingProfessionalInterestLinkEntity);
				}
				break;
				
			case "lmPersonalPriorities":
				TIdLandingPersonalPrioritiesLinkEntity tIdLandingPersonalPrioritiesLinkEntity = tIdLandingPersonalPrioritiesLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingPersonalPrioritiesLinkEntity==null) {
					tIdLandingPersonalPrioritiesLinkEntity = new TIdLandingPersonalPrioritiesLinkEntity();
					tIdLandingPersonalPrioritiesLinkEntity.setLlLdKey(ldKey);
					tIdLandingPersonalPrioritiesLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingPersonalPrioritiesLinkEntity.setLockKey(0L);
					tIdLandingPersonalPrioritiesLinkEntity.setProfileKey(1L);
					tIdLandingPersonalPrioritiesLinkJpaRepository.save(tIdLandingPersonalPrioritiesLinkEntity);
				}
				break;

			case "lmExperience":
				TIdLandingExperienceLinkEntity tIdLandingExperienceLinkEntity = tIdLandingExperienceLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingExperienceLinkEntity==null) {
					tIdLandingExperienceLinkEntity = new TIdLandingExperienceLinkEntity();
					tIdLandingExperienceLinkEntity.setLlLdKey(ldKey);
					tIdLandingExperienceLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingExperienceLinkEntity.setLockKey(0L);
					tIdLandingExperienceLinkEntity.setProfileKey(1L);
					tIdLandingExperienceLinkJpaRepository.save(tIdLandingExperienceLinkEntity);
				}
				break;
				
			case "lmEducation":
				TIdLandingEducationLinkEntity tIdLandingEducationLinkEntity = tIdLandingEducationLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingEducationLinkEntity==null) {
					tIdLandingEducationLinkEntity = new TIdLandingEducationLinkEntity();
					tIdLandingEducationLinkEntity.setLlLdKey(ldKey);
					tIdLandingEducationLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingEducationLinkEntity.setLockKey(0L);
					tIdLandingEducationLinkEntity.setProfileKey(1L);
					tIdLandingEducationLinkJpaRepository.save(tIdLandingEducationLinkEntity);
				}
				break;

			case "lmProjectExecuted":
				TIdLandingProjectExecutedLinkEntity tIdLandingProjectExecutedLinkEntity = tIdLandingProjectExecutedLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingProjectExecutedLinkEntity==null) {
					tIdLandingProjectExecutedLinkEntity = new TIdLandingProjectExecutedLinkEntity();
					tIdLandingProjectExecutedLinkEntity.setLlLdKey(ldKey);
					tIdLandingProjectExecutedLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingProjectExecutedLinkEntity.setLockKey(0L);
					tIdLandingProjectExecutedLinkEntity.setProfileKey(1L);
					tIdLandingProjectExecutedLinkJpaRepository.save(tIdLandingProjectExecutedLinkEntity);
				}
				break;
				
			case "lmProfessionalExpertise":
				TIdLandingProfessionalExpertiseLinkEntity tIdLandingProfessionalExpertiseLinkEntity = tIdLandingProfessionalExpertiseLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingProfessionalExpertiseLinkEntity==null) {
					tIdLandingProfessionalExpertiseLinkEntity = new TIdLandingProfessionalExpertiseLinkEntity();
					tIdLandingProfessionalExpertiseLinkEntity.setLlLdKey(ldKey);
					tIdLandingProfessionalExpertiseLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingProfessionalExpertiseLinkEntity.setLockKey(0L);
					tIdLandingProfessionalExpertiseLinkEntity.setProfileKey(1L);
					tIdLandingProfessionalExpertiseLinkJpaRepository.save(tIdLandingProfessionalExpertiseLinkEntity);
				}
				break;

			case "lmAwardsRecognition":
				TIdLandingAwardsRecognitionLinkEntity tIdLandingAwardsRecognitionLinkEntity = tIdLandingAwardsRecognitionLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingAwardsRecognitionLinkEntity==null) {
					tIdLandingAwardsRecognitionLinkEntity = new TIdLandingAwardsRecognitionLinkEntity();
					tIdLandingAwardsRecognitionLinkEntity.setLlLdKey(ldKey);
					tIdLandingAwardsRecognitionLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingAwardsRecognitionLinkEntity.setLockKey(0L);
					tIdLandingAwardsRecognitionLinkEntity.setProfileKey(1L);
					tIdLandingAwardsRecognitionLinkJpaRepository.save(tIdLandingAwardsRecognitionLinkEntity);
				}
				break;
				
			case "lmAddInformation":
				TIdLandingAddInformationLinkEntity tIdLandingAddInformationLinkEntity = tIdLandingAddInformationLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingAddInformationLinkEntity==null) {
					tIdLandingAddInformationLinkEntity = new TIdLandingAddInformationLinkEntity();
					tIdLandingAddInformationLinkEntity.setLlLdKey(ldKey);
					tIdLandingAddInformationLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingAddInformationLinkEntity.setLockKey(0L);
					tIdLandingAddInformationLinkEntity.setProfileKey(1L);
					tIdLandingAddInformationLinkJpaRepository.save(tIdLandingAddInformationLinkEntity);
				}
				break;

			case "lmPersonalRelationships":
				TIdLandingPersonalRelationshipsLinkEntity tIdLandingPersonalRelationshipsLinkEntity = tIdLandingPersonalRelationshipsLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingPersonalRelationshipsLinkEntity==null) {
					tIdLandingPersonalRelationshipsLinkEntity = new TIdLandingPersonalRelationshipsLinkEntity();
					tIdLandingPersonalRelationshipsLinkEntity.setLlLdKey(ldKey);
					tIdLandingPersonalRelationshipsLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingPersonalRelationshipsLinkEntity.setLockKey(0L);
					tIdLandingPersonalRelationshipsLinkEntity.setProfileKey(1L);
					tIdLandingPersonalRelationshipsLinkJpaRepository.save(tIdLandingPersonalRelationshipsLinkEntity);
				}
				break;
				
			case "lmProfessionalRelationship":
				TIdLandingProfessionalRelationshipLinkEntity tIdLandingProfessionalRelationshipLinkEntity = tIdLandingProfessionalRelationshipLinkJpaRepository.findByLlLdKeyAndLlPinKey(ldKey, loggedPinKey);
				if(tIdLandingProfessionalRelationshipLinkEntity==null) {
					tIdLandingProfessionalRelationshipLinkEntity = new TIdLandingProfessionalRelationshipLinkEntity();
					tIdLandingProfessionalRelationshipLinkEntity.setLlLdKey(ldKey);
					tIdLandingProfessionalRelationshipLinkEntity.setLlPinKey(loggedPinKey);
					tIdLandingProfessionalRelationshipLinkEntity.setLockKey(0L);
					tIdLandingProfessionalRelationshipLinkEntity.setProfileKey(1L);
					tIdLandingProfessionalRelationshipLinkJpaRepository.save(tIdLandingProfessionalRelationshipLinkEntity);					
				}
				break;
		}
		return "Success";		
	}

}
