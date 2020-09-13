package com.id.wasta.business.service.impl;


import static com.id.wasta.util.action.CommonConstants.DEFAULT_PASSWORD_CREATION;
import static com.id.wasta.util.action.CommonConstants.EMPLOYEE;
import static com.id.wasta.util.action.CommonConstants.IN_ACTIVE_STATUS;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.id.util.bean.common.SelectListBean;
import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.RequestKeyBean;
import com.id.wasta.bean.TIdUserMaster;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdCommonAddressesEntity;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkViewEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdUserMasterEntity;
import com.id.wasta.business.service.TemplateService;
import com.id.wasta.business.service.UserMasterService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCommonAddressesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCommunicationInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEtUserPasswordResetLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSocialMediaInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationJpaRepository;
import com.id.wasta.exception.HandledException;
import com.id.wasta.util.action.CommonConstants;

@Service 
public class UserMasterServiceImpl implements UserMasterService{
	
	private static final Logger logger = Logger.getLogger(UserMasterServiceImpl.class) ;

	@Resource
	private TIdUserMasterJpaRepository tIdUserMasterJpaRepository;
	
	@Resource
	private TIdCompanyMasterEntitySearchJpaRepository tIdCompanyMasterEntitySearchJpaRepository;
	
	@Resource
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	
	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	
	@Resource
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	
	@Resource 
	private TIdPersonalPrioritiesJpaRepository tIdPersonalPrioritiesJpaRepository;
	
	@Resource 
	private TIdPersonalInformationSearchJpaRepository tIdPersonalInformationEntitySearchJpaRepository;
	
	@Resource
	private TIdBusinessPotentialInfoJpaRepository tIdBusinessPotentialInfoJpaRepository;
	
	@Resource
	private TIdAddPotentialServicesJpaRepository tIdAddPotentialServicesJpaRepository;
	
	@Resource
	private TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	
	@Resource 
	private TIdExperienceInformationJpaRepository tIdExperienceInformationJpaRepository;
	
	@Resource
	private TIdEducationalInformationJpaRepository tIdEducationalInformationJpaRepository;
	
	@Resource
	private TIdProjectsInformationJpaRepository tIdProjectsInformationJpaRepository;
	
	@Resource
	private TIdCompanyContactLinkViewJpaRepository tIdCompanyContactLinkViewJpaRepository;
	
	@Resource
	private TIdProfessionalExpertiseJpaRepository tIdProfessionalExpertiseJpaRepository;
	
	@Resource
	private TIdAdditionalInformationJpaRepository tIdAdditionalInformationJpaRepository;
	
	@Resource
	private TIdAwardsInformationJpaRepository tIdAwardsInformationJpaRepository;
	
	@Resource
	private TIdCommunicationInformationJpaRepository tIdCommunicationInformationJpaRepository;
	
	@Resource
	private TIdRelationshipInformationJpaRepository tIdRelationshipInformationJpaRepository;
	
	@Resource
	private TIdCompanyContactLinkJpaRepository tIdCompanyContactLinkJpaRepository;
	
	@Resource 
	private TIdLanguageInformationJpaRepository tIdLanguageInformationJpaRepository;
	
	@Resource
	private TIdSocialMediaInformationJpaRepository tIdSocialMediaInformationJpaRepository;
	
	@Resource
	private TIdVisitInformationJpaRepository tIdVisitInformationJpaRepository;
	
	@Resource
	private TIdPersonalInterestsJpaRepository tIdPersonalInterestsJpaRepository;
	
	@Resource
	private TIdProfessionalInterestsJpaRepository tIdProfessionalInterestsJpaRepository;
	
	@Resource
	private TIdRecreationInfoJpaRepository tIdRecreationInfoJpaRepository;
	
	@Resource
	private TIdPersonalInfoLinkJpaRepository tIdPersonalInfoLinkJpaRepository;
	
	@Resource
	private TIdEducationalInformationSearchJpaRepository tIdEducationalInformationSearchJpaRepository;
	
	@Resource
	private TIdCommonAddressesJpaRepository tIdCommonAddressesJpaRepository;
	
	@Resource
	private GenericServiceMapper genericServiceMapper;
	
	@Autowired
	private TemplateService templateService;
	
	@Value("${domain.url}")
	private String domainUrl;
	
	@Value("${companyName}")
	private String companyName;
	
	@Value("${fromEmail}")
	private String fromEmail;
	
	@Resource
	private TIdEtUserPasswordResetLinkJpaRepository tIdEtUserPasswordResetLinkJpaRepository;
	
	@Override
	public List<SelectListBean> getUserDtls() {
		return tIdUserMasterJpaRepository.getUserMasterAll();
	}

	@Override
	public List<SelectListBean> getUsergetContactWithoutUserDtls() {
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		SelectListBean selectListBean = null;
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = (List<PersonIndividualExperienceViewEntity>)
				personIndividualExperienceViewJpaRepository.findByUserKeyAndActiveStatusOrderByPinFirstName(0L, CommonConstants.ACTIVE);
		String lastName, designation,  functionArea, role, company;
		
		for(PersonIndividualExperienceViewEntity PersonIndividualExperienceViewEntity : personIndividualExperienceViewEntityList) {
			selectListBean = new SelectListBean();
			selectListBean.setId(PersonIndividualExperienceViewEntity.getPinKey());
			selectListBean.setCode(PersonIndividualExperienceViewEntity.getPinFirstName());
			
			lastName = PersonIndividualExperienceViewEntity.getPinLastName()!=null?" "+PersonIndividualExperienceViewEntity.getPinLastName():"";
			designation = PersonIndividualExperienceViewEntity.getDesignation()!=null?" - "+PersonIndividualExperienceViewEntity.getDesignation():"";
			functionArea = PersonIndividualExperienceViewEntity.getFunctionalArea()!=null?" - "+PersonIndividualExperienceViewEntity.getFunctionalArea():"";
			role = PersonIndividualExperienceViewEntity.getRole()!=null?" - "+PersonIndividualExperienceViewEntity.getRole():"";
			company = PersonIndividualExperienceViewEntity.getCompany()!=null?" - "+PersonIndividualExperienceViewEntity.getCompany():"";
			
			selectListBean.setName(PersonIndividualExperienceViewEntity.getPinFirstName()+lastName+designation+functionArea+role+company); 
			selectListBeanList.add(selectListBean);
		}
		return selectListBeanList;
	}

	/*
	 * rejoin time
	 */
	@Override
	public Long userProfileCreation(RequestKeyBean requestKeyBean) { 
		
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findByPinKey(requestKeyBean.getPinKey());
		if(tIdPersonalInformationEntitySearch!=null) {
			if(requestKeyBean.isContactToEmployee()) {
				TIdPersonalInformationEntity  tIdPersnalInformationEntity = new TIdPersonalInformationEntity();
				 tIdPersnalInformationEntity = tIdPersonalInformationJpaRepository.findByPinKey(requestKeyBean.getPinKey()); 
				if(tIdPersnalInformationEntity!=null) {
					tIdPersnalInformationEntity.setPinPreviousStatus(null);
					tIdPersnalInformationEntity.setPinCreatorKey(tIdPersnalInformationEntity.getPinParentKey());
					tIdPersnalInformationEntity.setPinParentKey(null);
					if(tIdPersnalInformationEntity.getPinEmail()!=null) {
						TIdUserMasterEntity tIdUserMaster = tIdUserMasterJpaRepository.findByUserCode(tIdPersnalInformationEntity.getPinEmail());
						if(tIdUserMaster!=null) {
							tIdUserMaster.setUserPinKey(tIdPersnalInformationEntity.getPinKey());
							tIdPersnalInformationEntity.setProfileKey(tIdUserMaster.getUserKey());
							tIdPersonalInformationJpaRepository.save(tIdPersnalInformationEntity);
							tIdUserMasterJpaRepository.save(tIdUserMaster);
							return tIdPersnalInformationEntity.getPinKey();
						}
					}
				} 
				
			}
			// Inactive the Existing personal info & create the duplication info into personal information
	//		TIdPersonalInformationEntitySearch newPersonalInformationEntitySearch = new TIdPersonalInformationEntitySearch();
			
			tIdPersonalInformationEntitySearchJpaRepository.updateActiveStatusParentKey(requestKeyBean.getPinKey(), CommonConstants.ACTIVE,0L, EMPLOYEE);
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(requestKeyBean.getPinKey());
			tIdPersonalInformationEntitySearch.setPinParentKey(personIndividualExperienceViewEntity.getPinCreatorKey());
			tIdPersonalInformationEntitySearch.setActiveStatus(IN_ACTIVE_STATUS);
			tIdPersonalInformationEntitySearch.setPinPreviousStatus(EMPLOYEE);
			if(personIndividualExperienceViewEntity!=null && personIndividualExperienceViewEntity.getUserKey()!=0) {
				tIdUserMasterJpaRepository.DeActivateUser(personIndividualExperienceViewEntity.getUserKey(),0L,0L);
			}
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		}
		return tIdPersonalInformationEntitySearch.getPinKey();
/*
		BeanUtils.copyProperties(tIdPersonalInformationEntitySearch, newPersonalInformationEntitySearch);
		newPersonalInformationEntitySearch.setPinKey(null);
		newPersonalInformationEntitySearch.setActiveStatus( CommonConstants.ACTIVE);
		newPersonalInformationEntitySearch.setLockKey(0L);
		newPersonalInformationEntitySearch.setModifiedOn(new Date());
		newPersonalInformationEntitySearch.setPinParentKey(requestKeyBean.getPinKey());
		if(requestKeyBean.isContactToEmployee()) {
			newPersonalInformationEntitySearch.setPinCreatorKey(null);
		} else {
			newPersonalInformationEntitySearch.setPinCreatorKey(requestKeyBean.getPinKey());
		}
		newPersonalInformationEntitySearch.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
		

		
		//Company Contact Link Information
		List<TIdCompanyContactLinkEntitySearch> listOfTIdCompanyContactLinkEntitySearch=new ArrayList<TIdCompanyContactLinkEntitySearch>();
		if(tIdPersonalInformationEntitySearch.getListOfTIdCompanyContactLink()!=null){
			for (TIdCompanyContactLinkEntitySearch tIdCompanyContactLinkEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdCompanyContactLink())	{
				TIdCompanyContactLinkEntitySearch tIdCompanyContactLinkEntitySearch2  = new TIdCompanyContactLinkEntitySearch();
				BeanUtils.copyProperties(tIdCompanyContactLinkEntitySearch, tIdCompanyContactLinkEntitySearch2);
				tIdCompanyContactLinkEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdCompanyContactLinkEntitySearch2.setLockKey(0L);
				tIdCompanyContactLinkEntitySearch2.setCclKey(null);
				tIdCompanyContactLinkEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				tIdCompanyContactLinkEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				listOfTIdCompanyContactLinkEntitySearch.add(tIdCompanyContactLinkEntitySearch2);
			  }
		}
		if(requestKeyBean.isContactToEmployee()) {
			TIdUserMasterEntity tIdUserMasterEntity = tIdUserMasterJpaRepository.findOne(requestKeyBean.getUserKey());
			if(tIdUserMasterEntity!=null && tIdUserMasterEntity.getUserRelationshipKey()!=null && tIdUserMasterEntity.getUserCompanyKey()!=null){
				TIdCompanyContactLinkEntitySearch tIdCompanyContactLinkEntitySearch3  = new TIdCompanyContactLinkEntitySearch();
				tIdCompanyContactLinkEntitySearch3.setActiveStatus( CommonConstants.ACTIVE);
				tIdCompanyContactLinkEntitySearch3.setLockKey(0L);
				tIdCompanyContactLinkEntitySearch3.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				tIdCompanyContactLinkEntitySearch3.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdCompanyContactLinkEntitySearch3.setTIdReferenceCodesDetail(tIdReferenceCodesDetailJpaRepository.findOne(tIdUserMasterEntity.getUserRelationshipKey()));
				tIdCompanyContactLinkEntitySearch3.setTIdCompanyMaster(tIdCompanyMasterEntitySearchJpaRepository.findOne(tIdUserMasterEntity.getUserCompanyKey()));
				listOfTIdCompanyContactLinkEntitySearch.add(tIdCompanyContactLinkEntitySearch3);
			}
		}
		newPersonalInformationEntitySearch.setListOfTIdCompanyContactLink(listOfTIdCompanyContactLinkEntitySearch);
		
		//Language Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdLanguageInformation()!=null){
			List<TIdLanguageInformationEntitySearch> listOfTIdLanguageInformationEntitySearch=new ArrayList<TIdLanguageInformationEntitySearch>();
			for (TIdLanguageInformationEntitySearch tIdLanguageInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdLanguageInformation())	{
				TIdLanguageInformationEntitySearch tIdLanguageInformationEntitySearch2 = new TIdLanguageInformationEntitySearch();
				BeanUtils.copyProperties(tIdLanguageInformationEntitySearch, tIdLanguageInformationEntitySearch2);
	
				tIdLanguageInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdLanguageInformationEntitySearch2.setLockKey(0L);
				tIdLanguageInformationEntitySearch2.setPliKey(null);
				tIdLanguageInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				tIdLanguageInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				listOfTIdLanguageInformationEntitySearch.add(tIdLanguageInformationEntitySearch2);
			  }
			newPersonalInformationEntitySearch.setListOfTIdLanguageInformation(listOfTIdLanguageInformationEntitySearch);
		}
		
		//Social Media Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdSocialMediaInformation()!=null){
			List<TIdSocialMediaInformationEntitySearch> listOfTIdSocialMediaInformationEntitySearch=new ArrayList<TIdSocialMediaInformationEntitySearch>();
			for (TIdSocialMediaInformationEntitySearch tIdSocialMediaInformationEntity:tIdPersonalInformationEntitySearch.getListOfTIdSocialMediaInformation())	{
				TIdSocialMediaInformationEntitySearch tIdSocialMediaInformationEntity2 = new TIdSocialMediaInformationEntitySearch();
				BeanUtils.copyProperties(tIdSocialMediaInformationEntity, tIdSocialMediaInformationEntity2);

				tIdSocialMediaInformationEntity2.setActiveStatus( CommonConstants.ACTIVE);
				tIdSocialMediaInformationEntity2.setLockKey(0L);
				tIdSocialMediaInformationEntity2.setPsmKey(null);
				tIdSocialMediaInformationEntity2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				tIdSocialMediaInformationEntity2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				listOfTIdSocialMediaInformationEntitySearch.add(tIdSocialMediaInformationEntity2);
			  }
			newPersonalInformationEntitySearch.setListOfTIdSocialMediaInformation(listOfTIdSocialMediaInformationEntitySearch);
		}
								
		//Communication Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdCommunicationInformation()!=null){
			List<TIdCommunicationInformationEntitySearch> listOfTIdCommunicationInformationEntitySearch=new ArrayList<TIdCommunicationInformationEntitySearch>();
			for (TIdCommunicationInformationEntitySearch tIdCommunicationInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdCommunicationInformation())	{
				TIdCommunicationInformationEntitySearch tIdCommunicationInformationEntitySearch2 = new TIdCommunicationInformationEntitySearch();
				BeanUtils.copyProperties(tIdCommunicationInformationEntitySearch, tIdCommunicationInformationEntitySearch2);

				tIdCommunicationInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdCommunicationInformationEntitySearch2.setLockKey(0L);
				tIdCommunicationInformationEntitySearch2.setPcmKey(null);
				tIdCommunicationInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				tIdCommunicationInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				listOfTIdCommunicationInformationEntitySearch.add(tIdCommunicationInformationEntitySearch2);
			  }
			newPersonalInformationEntitySearch.setListOfTIdCommunicationInformation(listOfTIdCommunicationInformationEntitySearch);
		}
		
		//BusinessPotential Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdBusinessPotentialInfo()!=null){
			List<TIdBusinessPotentialInfoEntitySearch> listOfTIdBusinessPotentialInfoEntitySearch=new ArrayList<TIdBusinessPotentialInfoEntitySearch>();
			for (TIdBusinessPotentialInfoEntitySearch tIdBusinessPotentialInfoEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdBusinessPotentialInfo())	{
				TIdBusinessPotentialInfoEntitySearch tIdBusinessPotentialInfoEntitySearch2 = new TIdBusinessPotentialInfoEntitySearch();
				BeanUtils.copyProperties(tIdBusinessPotentialInfoEntitySearch, tIdBusinessPotentialInfoEntitySearch2);

				tIdBusinessPotentialInfoEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdBusinessPotentialInfoEntitySearch2.setLockKey(0L);
				tIdBusinessPotentialInfoEntitySearch2.setKey(null);
				tIdBusinessPotentialInfoEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				tIdBusinessPotentialInfoEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
				listOfTIdBusinessPotentialInfoEntitySearch.add(tIdBusinessPotentialInfoEntitySearch2);
			  }
			newPersonalInformationEntitySearch.setListOfTIdBusinessPotentialInfo(listOfTIdBusinessPotentialInfoEntitySearch);
		}
		
		
		//Additional Potential Services
		if(tIdPersonalInformationEntitySearch.getListOfTIdAddPotentialServices()!=null){
			List<TIdAddPotentialServicesEntitySearch> listOfTIdAddPotentialServiceEntitySearch=new ArrayList<TIdAddPotentialServicesEntitySearch>();
			for (TIdAddPotentialServicesEntitySearch tIdAddPotentialServicesEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdAddPotentialServices())	{
				TIdAddPotentialServicesEntitySearch tIdAddPotentialServicesEntitySearch2 = new TIdAddPotentialServicesEntitySearch();
				BeanUtils.copyProperties(tIdAddPotentialServicesEntitySearch, tIdAddPotentialServicesEntitySearch2);

				tIdAddPotentialServicesEntitySearch2.setKey(null);
				tIdAddPotentialServicesEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdAddPotentialServicesEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdAddPotentialServicesEntitySearch2.setLockKey(0L);
				tIdAddPotentialServicesEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				listOfTIdAddPotentialServiceEntitySearch.add(tIdAddPotentialServicesEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdAddPotentialServices(listOfTIdAddPotentialServiceEntitySearch);
		}
		
		//Experience Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null){
			List<TIdExperienceInformationEntitySearch> listOfTIdExperienceInformationEntitySearch=new ArrayList<TIdExperienceInformationEntitySearch>();
			for (TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation())	{
				TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch2 = new TIdExperienceInformationEntitySearch();
				BeanUtils.copyProperties(tIdExperienceInformationEntitySearch, tIdExperienceInformationEntitySearch2);

				tIdExperienceInformationEntitySearch2.setPexKey(null);
				tIdExperienceInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdExperienceInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdExperienceInformationEntitySearch2.setLockKey(0L);
				tIdExperienceInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				listOfTIdExperienceInformationEntitySearch.add(tIdExperienceInformationEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdExperienceInformation(listOfTIdExperienceInformationEntitySearch);
		}
		
		//Education Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation()!=null){
			List<TIdEducationalInformationEntitySearch> listOfTIdEducationalInformationEntitySearch=new ArrayList<TIdEducationalInformationEntitySearch>();
			for (TIdEducationalInformationEntitySearch tIdEducationalInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation())	{
				TIdEducationalInformationEntitySearch tIdEducationalInformationEntitySearch2 = new TIdEducationalInformationEntitySearch();
				BeanUtils.copyProperties(tIdEducationalInformationEntitySearch, tIdEducationalInformationEntitySearch2);

				tIdEducationalInformationEntitySearch2.setPeiKey(null);
			    tIdEducationalInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdEducationalInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdEducationalInformationEntitySearch2.setLockKey(0L);
				tIdEducationalInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				                
				listOfTIdEducationalInformationEntitySearch.add(tIdEducationalInformationEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdEducationalInformation(listOfTIdEducationalInformationEntitySearch);
		}

		//Project Execution information
		if(tIdPersonalInformationEntitySearch.getListOfTIdProjectsInformation()!=null){
			List<TIdProjectsInformationEntitySearch> listOfTIdProjectsInformationEntitySearch=new ArrayList<TIdProjectsInformationEntitySearch>();
			for (TIdProjectsInformationEntitySearch tIdProjectsInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdProjectsInformation())	{
				TIdProjectsInformationEntitySearch tIdProjectsInformationEntitySearch2 = new TIdProjectsInformationEntitySearch();
				BeanUtils.copyProperties(tIdProjectsInformationEntitySearch, tIdProjectsInformationEntitySearch2);
				
				tIdProjectsInformationEntitySearch2.setPipKey(null);
				tIdProjectsInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdProjectsInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdProjectsInformationEntitySearch2.setLockKey(0L);
				tIdProjectsInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
				                
				listOfTIdProjectsInformationEntitySearch.add(tIdProjectsInformationEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdProjectsInformation(listOfTIdProjectsInformationEntitySearch);
		}

		//Professional Expertise Acquired
		if(tIdPersonalInformationEntitySearch.getListOfTIdProfessionalExpertise()!=null){
			List<TIdProfessionalExpertiseEntitySearch> listOfTIdProfessionalExpertiseEntitySearch=new ArrayList<TIdProfessionalExpertiseEntitySearch>();
			for (TIdProfessionalExpertiseEntitySearch tIdProfessionalExpertiseEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdProfessionalExpertise())	{
				
				TIdProfessionalExpertiseEntitySearch tIdProfessionalExpertiseEntitySearch2 = new TIdProfessionalExpertiseEntitySearch();
				BeanUtils.copyProperties(tIdProfessionalExpertiseEntitySearch, tIdProfessionalExpertiseEntitySearch2);
		
				tIdProfessionalExpertiseEntitySearch2.setPpeKey(null);
				tIdProfessionalExpertiseEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdProfessionalExpertiseEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdProfessionalExpertiseEntitySearch2.setLockKey(0L);
				tIdProfessionalExpertiseEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());             
				listOfTIdProfessionalExpertiseEntitySearch.add(tIdProfessionalExpertiseEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdProfessionalExpertise(listOfTIdProfessionalExpertiseEntitySearch);
		}
				
		//Additional Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdAdditionalInformation()!=null){
			List<TIdAdditionalInformationEntitySearch> listOfTIdAdditionalInformationEntitySearch=new ArrayList<TIdAdditionalInformationEntitySearch>();
			for (TIdAdditionalInformationEntitySearch tIdAdditionalInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdAdditionalInformation())	{
				TIdAdditionalInformationEntitySearch tIdAdditionalInformationEntitySearch2 = new TIdAdditionalInformationEntitySearch();
				BeanUtils.copyProperties(tIdAdditionalInformationEntitySearch, tIdAdditionalInformationEntitySearch2);
				
				tIdAdditionalInformationEntitySearch2.setPiadKey(null);
				tIdAdditionalInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdAdditionalInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdAdditionalInformationEntitySearch2.setLockKey(0L);
				tIdAdditionalInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());             
				listOfTIdAdditionalInformationEntitySearch.add(tIdAdditionalInformationEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdAdditionalInformation(listOfTIdAdditionalInformationEntitySearch);
		}

		//Award & Recognition Information
		if(tIdPersonalInformationEntitySearch.getListOfTIdAwardsInformation()!=null){
			List<TIdAwardsInformationEntitySearch> listOfTIdAwardsInformationEntitySearch=new ArrayList<TIdAwardsInformationEntitySearch>();
			for (TIdAwardsInformationEntitySearch tIdAwardsInformationEntitySearch:tIdPersonalInformationEntitySearch.getListOfTIdAwardsInformation())	{
				TIdAwardsInformationEntitySearch tIdAwardsInformationEntitySearch2 = new TIdAwardsInformationEntitySearch();
				BeanUtils.copyProperties(tIdAwardsInformationEntitySearch, tIdAwardsInformationEntitySearch2);
				
				tIdAwardsInformationEntitySearch2.setPiaKey(null);
				tIdAwardsInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
				tIdAwardsInformationEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
				tIdAwardsInformationEntitySearch2.setLockKey(0L);
				tIdAwardsInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());             
				listOfTIdAwardsInformationEntitySearch.add(tIdAwardsInformationEntitySearch2);
			}
			newPersonalInformationEntitySearch.setListOfTIdAwardsInformation(listOfTIdAwardsInformationEntitySearch);
		}

		//move the 5 boxes to new personal info [employee to contact].
		if(!requestKeyBean.isContactToEmployee() && tIdPersonalInformationEntitySearch.getPinParentKey()!=null 
				&& tIdPersonalInformationEntitySearch.getPinParentKey()!=0){ //Employee to OldContact			

			TIdPersonalInformationEntitySearch oldPersonalInformationEntitySearch=
					tIdPersonalInformationEntitySearchJpaRepository.findByPinKey(tIdPersonalInformationEntitySearch.getPinParentKey());
			
			//Discussion Details
			if(oldPersonalInformationEntitySearch.getListOfTIdVisitInformation()!=null){
				List<TIdVisitInformationEntitySearch> listOfTIdVisitInformationEntitySearch=new ArrayList<TIdVisitInformationEntitySearch>();
				for (TIdVisitInformationEntitySearch tIdVisitInformationEntitySearch:oldPersonalInformationEntitySearch.getListOfTIdVisitInformation())	{	
					TIdVisitInformationEntitySearch tIdVisitInformationEntitySearch2 = new TIdVisitInformationEntitySearch();
					BeanUtils.copyProperties(tIdVisitInformationEntitySearch, tIdVisitInformationEntitySearch2);
					
					tIdVisitInformationEntitySearch2.setActiveStatus(CommonConstants.ACTIVE);
					tIdVisitInformationEntitySearch2.setLockKey(0L);
					tIdVisitInformationEntitySearch2.setPivKey(null);
					tIdVisitInformationEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					tIdVisitInformationEntitySearch2.setTIdPersonalInformation(newPersonalInformationEntitySearch); 
					listOfTIdVisitInformationEntitySearch.add(tIdVisitInformationEntitySearch2);
				  }
				newPersonalInformationEntitySearch.setListOfTIdVisitInformation(listOfTIdVisitInformationEntitySearch);
			}
			
			//Personal Interest
			if(oldPersonalInformationEntitySearch.getListOfTIdPersonalInterests()!=null){
				List<TIdPersonalInterestsEntitySearch> listOfTIdPersonalInterestEntitySearch=new ArrayList<TIdPersonalInterestsEntitySearch>();
				for (TIdPersonalInterestsEntitySearch tIdPersonalInterestsEntitySearch:oldPersonalInformationEntitySearch.getListOfTIdPersonalInterests())	{
					TIdPersonalInterestsEntitySearch tIdPersonalInterestsEntitySearch2 = new TIdPersonalInterestsEntitySearch();
					BeanUtils.copyProperties(tIdPersonalInterestsEntitySearch, tIdPersonalInterestsEntitySearch2);
					
					tIdPersonalInterestsEntitySearch2.setActiveStatus(CommonConstants.ACTIVE);
					tIdPersonalInterestsEntitySearch2.setLockKey(0L);
					tIdPersonalInterestsEntitySearch2.setKey(null);
					tIdPersonalInterestsEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					tIdPersonalInterestsEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
					listOfTIdPersonalInterestEntitySearch.add(tIdPersonalInterestsEntitySearch2);
				  }
				newPersonalInformationEntitySearch.setListOfTIdPersonalInterests(listOfTIdPersonalInterestEntitySearch);
			}
			
			//Professional Interest
			if(oldPersonalInformationEntitySearch.getListOfTIdProfessionalInterests()!=null){
				List<TIdProfessionalInterestsEntitySearch> listOfTIdProfessionalInterestEntitySearch=new ArrayList<TIdProfessionalInterestsEntitySearch>();
				for (TIdProfessionalInterestsEntitySearch tIdProfessionalInterestsEntitySearch:oldPersonalInformationEntitySearch.getListOfTIdProfessionalInterests())	{
					TIdProfessionalInterestsEntitySearch tIdProfessionalInterestsEntitySearch2 = new TIdProfessionalInterestsEntitySearch();
					BeanUtils.copyProperties(tIdProfessionalInterestsEntitySearch,tIdProfessionalInterestsEntitySearch2);
							
					tIdProfessionalInterestsEntitySearch2.setActiveStatus(CommonConstants.ACTIVE);
					tIdProfessionalInterestsEntitySearch2.setLockKey(0L);
					tIdProfessionalInterestsEntitySearch2.setPriKey(null);
					tIdProfessionalInterestsEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					tIdProfessionalInterestsEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
					listOfTIdProfessionalInterestEntitySearch.add(tIdProfessionalInterestsEntitySearch2);
				  }
				newPersonalInformationEntitySearch.setListOfTIdProfessionalInterests(listOfTIdProfessionalInterestEntitySearch);
			}			
			
			//Recreation Information
			if(oldPersonalInformationEntitySearch.getListOfTIdRecreationInfo()!=null){
				List<TIdRecreationInfoEntitySearch> listOfTIdRecreationInfoEntitySearch=new ArrayList<TIdRecreationInfoEntitySearch>();
				for (TIdRecreationInfoEntitySearch tIdRecreationInfoEntitySearch:oldPersonalInformationEntitySearch.getListOfTIdRecreationInfo())	{
					TIdRecreationInfoEntitySearch tIdRecreationInfoEntitySearch2 = new TIdRecreationInfoEntitySearch();
					BeanUtils.copyProperties(tIdRecreationInfoEntitySearch, tIdRecreationInfoEntitySearch2);
					
					tIdRecreationInfoEntitySearch2.setActiveStatus(CommonConstants.ACTIVE);
					tIdRecreationInfoEntitySearch2.setLockKey(0L);
					tIdRecreationInfoEntitySearch2.setReiKey(null);
					tIdRecreationInfoEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					tIdRecreationInfoEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
					listOfTIdRecreationInfoEntitySearch.add(tIdRecreationInfoEntitySearch2);
				  }
				newPersonalInformationEntitySearch.setListOfTIdRecreationInfo(listOfTIdRecreationInfoEntitySearch);
			}
			
			//Personal Priorities
			if(oldPersonalInformationEntitySearch.getListOfTIdPersonalPriorities()!=null){
				List<TIdPersonalPrioritiesEntitySearch> listOfTIdPersonalPrioritiesEntitySearch=new ArrayList<TIdPersonalPrioritiesEntitySearch>();
				for (TIdPersonalPrioritiesEntitySearch tIdPersonalPrioritiesEntitySearch:oldPersonalInformationEntitySearch.getListOfTIdPersonalPriorities())	{
					TIdPersonalPrioritiesEntitySearch tIdPersonalPrioritiesEntitySearch2 = new TIdPersonalPrioritiesEntitySearch();
					BeanUtils.copyProperties(tIdPersonalPrioritiesEntitySearch, tIdPersonalPrioritiesEntitySearch2);

					tIdPersonalPrioritiesEntitySearch2.setKey(null);
				    tIdPersonalPrioritiesEntitySearch2.settIdPersonalInformation(newPersonalInformationEntitySearch); 
					tIdPersonalPrioritiesEntitySearch2.setActiveStatus( CommonConstants.ACTIVE);
					tIdPersonalPrioritiesEntitySearch2.setLockKey(0L);
					tIdPersonalPrioritiesEntitySearch2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					listOfTIdPersonalPrioritiesEntitySearch.add(tIdPersonalPrioritiesEntitySearch2);
				}
				newPersonalInformationEntitySearch.setListOfTIdPersonalPriorities(listOfTIdPersonalPrioritiesEntitySearch);
			}
		}
		
		newPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.save(newPersonalInformationEntitySearch);// New personal info save
		
		//Relationship Information
		tIdRelationshipInformationJpaRepository.updatePrlPinKey(newPersonalInformationEntitySearch.getPinKey(), requestKeyBean.getPinKey());
		
		//Relationship Information Link
		tIdRelationshipInfoLinkJpaRepository.updatePrlkFromPinKey(newPersonalInformationEntitySearch.getPinKey(), requestKeyBean.getPinKey());
		tIdRelationshipInfoLinkJpaRepository.updatePrlkToPinKey(newPersonalInformationEntitySearch.getPinKey(), requestKeyBean.getPinKey());
		
		//Change Creator
		List<Long> toPinKeyList = tIdRelationshipInfoLinkJpaRepository.getPrlkToPinKey(newPersonalInformationEntitySearch.getPinKey());
		if(toPinKeyList.size()>0) {
			tIdPersonalInformationJpaRepository.changeCreatorPinKey(toPinKeyList, newPersonalInformationEntitySearch.getPinKey());
		}
		
		//Personal info link
		TIdPersonalInfoLinkEntity tIdPersonalInfoLinkEntity = new TIdPersonalInfoLinkEntity();
		List<Long> expKey = tIdExperienceInformationJpaRepository.findCurrentExperience(newPersonalInformationEntitySearch.getPinKey(), "Y");
		if(expKey.size()>0) {
			tIdPersonalInfoLinkEntity.setPilPinKey(newPersonalInformationEntitySearch.getPinKey());
			tIdPersonalInfoLinkEntity.setPilPexKey(expKey.get(0));
			tIdPersonalInfoLinkEntity.setPilCurrentlyWorking("Y");
			tIdPersonalInfoLinkJpaRepository.save(tIdPersonalInfoLinkEntity);
		} else {
			expKey = tIdExperienceInformationJpaRepository.findCurrentExperience(newPersonalInformationEntitySearch.getPinKey(), "N");
			if(expKey.size()>0) {
				tIdPersonalInfoLinkEntity.setPilPinKey(newPersonalInformationEntitySearch.getPinKey());
				tIdPersonalInfoLinkEntity.setPilPexKey(expKey.get(0));
				tIdPersonalInfoLinkEntity.setPilCurrentlyWorking("N");
				tIdPersonalInfoLinkJpaRepository.save(tIdPersonalInfoLinkEntity);
			}
		}
		
		//Delete the old contact or employee (if parentKey is not null)
		if(tIdPersonalInformationEntitySearch.getPinParentKey()!=null && tIdPersonalInformationEntitySearch.getPinParentKey()!=0){
			tIdPersonalInformationEntitySearchJpaRepository.delete(tIdPersonalInformationEntitySearch.getPinParentKey());
		}
		
		//New pinKey update into userpinKey[contact to employee] || //Zero going to update into userpinKey-[employee to contact]
		if(requestKeyBean.isContactToEmployee()) {
			//Set NULL value in parentKey column and inactive the current profile
			tIdPersonalInformationEntitySearchJpaRepository.updateActiveStatusParentKey(requestKeyBean.getPinKey(), CommonConstants.INACTIVE,0L, "Contact");
			tIdUserMasterJpaRepository.updateUserPinKey(requestKeyBean.getUserKey(),newPersonalInformationEntitySearch.getPinKey());
		} else {
			//Set NULL value in parentKey column and inactive the current profile
			tIdPersonalInformationEntitySearchJpaRepository.updateActiveStatusParentKey(requestKeyBean.getPinKey(), CommonConstants.INACTIVE,0L, "Employee");
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(requestKeyBean.getPinKey());
			if(personIndividualExperienceViewEntity!=null && personIndividualExperienceViewEntity.getUserKey()!=0) {
				tIdUserMasterJpaRepository.DeActivateUser(personIndividualExperienceViewEntity.getUserKey(),0L,0L);
			}
		}

		return newPersonalInformationEntitySearch.getPinKey();*/
	}

	@Override
	public List<SelectListBean> getEmployeeDtls(Long pinKey) {
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		SelectListBean selectListBean = null;
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = (List<PersonIndividualExperienceViewEntity>)
				personIndividualExperienceViewJpaRepository.findByUserKeyIsNotAndPinKeyIsNotOrderByPinFirstNameAsc(0L, pinKey!=null?pinKey:0L);
		String lastName, designation,  functionArea, role, company;
		
		for(PersonIndividualExperienceViewEntity PersonIndividualExperienceViewEntity : personIndividualExperienceViewEntityList) {
			selectListBean = new SelectListBean();
			selectListBean.setId(PersonIndividualExperienceViewEntity.getPinKey());
			selectListBean.setCode(PersonIndividualExperienceViewEntity.getPinFirstName());
			
			lastName = PersonIndividualExperienceViewEntity.getPinLastName()!=null?" "+PersonIndividualExperienceViewEntity.getPinLastName():"";
			designation = PersonIndividualExperienceViewEntity.getDesignation()!=null?" - "+PersonIndividualExperienceViewEntity.getDesignation():"";
			functionArea = PersonIndividualExperienceViewEntity.getFunctionalArea()!=null?" - "+PersonIndividualExperienceViewEntity.getFunctionalArea():"";
			role = PersonIndividualExperienceViewEntity.getRole()!=null?" - "+PersonIndividualExperienceViewEntity.getRole():"";
			company = PersonIndividualExperienceViewEntity.getCompany()!=null?" - "+PersonIndividualExperienceViewEntity.getCompany():"";
			
			selectListBean.setName(PersonIndividualExperienceViewEntity.getPinFirstName()+lastName+designation+functionArea+role+company); 
			selectListBeanList.add(selectListBean);
		}
		return selectListBeanList;
	}

	@Override
	public String userCreationMail(Long userId) {
		String[] toAddress=new String[1];
		String userDob="",defaultPassword="";
		Integer length;
		TIdUserMasterEntity tIdUserMasterEntity=tIdUserMasterJpaRepository.findOne(userId);
		if(tIdUserMasterEntity!=null){
			try {
				SimpleDateFormat sdfDestination = new SimpleDateFormat("ddyyyy");
				userDob = sdfDestination.format(tIdUserMasterEntity.getUserDateOfBirth());
				if(tIdUserMasterEntity.getUserFirstName()!=null){
					Integer fl =tIdUserMasterEntity.getUserFirstName().length();
					Integer ll =  tIdUserMasterEntity.getUserLastName().length();
					if(tIdUserMasterEntity.getUserFirstName().length()>3) {
						defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName().substring(0, 4))+userDob;
					} else {
						if(fl+ll<5) {
							if(fl==1 ||fl==2 ) {
								defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName().concat(tIdUserMasterEntity.getUserLastName().substring(0, ll)))+userDob;
							} 
							else {
								defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName().concat(tIdUserMasterEntity.getUserLastName().substring(0, 1)))+userDob;
							}
						}
						else {
							length = Math.abs(4-fl);
							defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName().concat(tIdUserMasterEntity.getUserLastName().substring(0, length)))+userDob;
						}
						
					}
				}
	
				Map<String, Object> vmValues = new HashMap<String, Object>();
				vmValues.put("companyName",companyName);
				vmValues.put("activationURL", domainUrl+"Login/NewUser?userActivationId="+tIdUserMasterEntity.getUserKey());
				vmValues.put("userName",tIdUserMasterEntity.getUserDisplayName());
				vmValues.put("emailId",tIdUserMasterEntity.getUserCode());
				vmValues.put("defaultPassword",defaultPassword);
			      
				toAddress[0]=tIdUserMasterEntity.getUserCode();
				templateService.createMailTemplateAndSend(DEFAULT_PASSWORD_CREATION,fromEmail, toAddress, vmValues, null);					
				tIdUserMasterEntity.setUserPasswordModified("L");
				tIdUserMasterJpaRepository.save(tIdUserMasterEntity);
				
			} catch (Exception e) {
				logger.error("userCreationMail method having error : "+e.getStackTrace());
			}
		} else {
			return "failure";
		}
		return "success";
	}
	
	public String md5Algo(String password) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
	 }

	@Override
	public TIdUserMaster checkUserRegisteration(Long userActivationId) throws Exception {
		TIdUserMasterEntity tIdUserMasterEntity=tIdUserMasterJpaRepository.findOne(userActivationId);
		if(tIdUserMasterEntity!=null && tIdUserMasterEntity.getActiveStatus()==1){
			throw new HandledException("User already registered");
		}else if(tIdUserMasterEntity!=null){
			TIdCommonAddressesEntity tIdCommonAddressesEntity=tIdCommonAddressesJpaRepository.findOne(tIdUserMasterEntity.getUserAddressLink());
			TIdUserMaster tIdUserMaster = genericServiceMapper.map(tIdUserMasterEntity,TIdUserMaster.class);
			tIdUserMaster.setUserEmail(tIdCommonAddressesEntity.getCommEmail());
			return tIdUserMaster;
		}else
			return null;
	}

	@Override
	public String updateRelationship(Long userKey) {
		TIdUserMasterEntity tIdUserMasterEntity=tIdUserMasterJpaRepository.findOne(userKey);
		if(tIdUserMasterEntity.getUserPinKey()!=0) {
			ArrayList<String> listValue = new ArrayList<String>();
			listValue.add("Employee");
			listValue.add("Management");
			List<TIdCompanyContactLinkViewEntity> tIdCompanyContactLinkViewEntityList = 
					tIdCompanyContactLinkViewJpaRepository.findByCclPinKeyAndCclCompanyRelationValueIn(tIdUserMasterEntity.getUserPinKey(), listValue);
			if(tIdCompanyContactLinkViewEntityList.size()>0) {
				tIdCompanyContactLinkJpaRepository.updateRelationship(tIdUserMasterEntity.getUserRelationshipKey(),
						tIdUserMasterEntity.getUserCompanyKey(),tIdCompanyContactLinkViewEntityList.get(0).getCclKey());
			}
		}
		return "success";
	}
	
}
