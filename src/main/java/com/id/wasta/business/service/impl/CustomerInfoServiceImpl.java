package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.ACTIVESTATUS;
import static com.id.wasta.util.action.CommonConstants.CONTACT;
import static com.id.wasta.util.action.CommonConstants.DELETE_STATUS;
import static com.id.wasta.util.action.CommonConstants.DOA;
import static com.id.wasta.util.action.CommonConstants.DOB;
import static com.id.wasta.util.action.CommonConstants.EMAIL_ID;
import static com.id.wasta.util.action.CommonConstants.EMPLOYEE;
import static com.id.wasta.util.action.CommonConstants.GENDER;
import static com.id.wasta.util.action.CommonConstants.HEADER_INFO;
import static com.id.wasta.util.action.CommonConstants.HOMETOWN_ADDRESS;
import static com.id.wasta.util.action.CommonConstants.HOME_ADDRESS;
import static com.id.wasta.util.action.CommonConstants.IN_ACTIVE_STATUS;
import static com.id.wasta.util.action.CommonConstants.LANDLINE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.MOBILE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.NATIONALITY;
import static com.id.wasta.util.action.CommonConstants.OFFICE_ADDRESS;
import static com.id.wasta.util.action.CommonConstants.PENDING_STATUS;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INFO;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.bean.common.SelectListBean;
import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.CustRelShipBean;
import com.id.wasta.bean.CustomerInfoBean;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.RelationShipInfoBean;
import com.id.wasta.bean.TIdProfileAddressDetailsView;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdBusinessTypeMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdCityMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdCommunicationInformationEntity;
import com.id.wasta.bean.jpa.TIdCommunicationInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkEntity;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkViewEntity;
import com.id.wasta.bean.jpa.TIdCompanyIndustryLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdCompanyMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdCountryMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdDesignationMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdEducationalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdExperienceInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdFunctionalAreaMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdLanguageInformationEntity;
import com.id.wasta.bean.jpa.TIdLanguageInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdLanguageInformationViewEntity;
import com.id.wasta.bean.jpa.TIdLanguageMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdMyContactsLinkEntity;
import com.id.wasta.bean.jpa.TIdNationalityMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdProfileAddressDetailsEntity;
import com.id.wasta.bean.jpa.TIdProfileAddressDetailsEntitySearch;
import com.id.wasta.bean.jpa.TIdProfileAddressDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdQualificationMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailEntity;
import com.id.wasta.bean.jpa.TIdReferenceCodesHeaderEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkViewEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInformationEntity;
import com.id.wasta.bean.jpa.TIdSocialMediaInformationEntity;
import com.id.wasta.bean.jpa.TIdSocialMediaInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdStateMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdUserMasterEntity;
import com.id.wasta.business.service.CustomerInfoService;
import com.id.wasta.business.service.MyContactInfoService;
import com.id.wasta.business.service.ShareInfoService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessTypeMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCityMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCommunicationInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCountryMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdFunctionalAreaMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdFunctionalAreaMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdMyContactsLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdNationalityMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileAddressDetailsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileAddressDetailsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdQualificationMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesHeaderJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSocialMediaInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdStateMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdZipCodeMasterSearchJpaRepository;
import com.id.wasta.exception.HandledException;
import com.id.wasta.util.action.CommonConstants;

@Service
@Transactional
public class CustomerInfoServiceImpl implements CustomerInfoService {
	private static final Logger logger = Logger.getLogger(CustomerInfoService.class);

	@Resource
	private TIdPersonalInformationSearchJpaRepository tIdPersonalInformationEntitySearchJpaRepository;
	@Resource
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	@Resource
	private TIdPersonalInformationViewJpaRepository tIdPersonalInformationViewJpaRepository;
	@Resource
	private TIdCompanyContactLinkJpaRepository tIdCompanyContactLinkJpaRepository;
	@Resource
	private TIdPersonalInfoLinkJpaRepository tIdPersonalInfoLinkJpaRepository;
	@Resource
	private TIdCompanyContactLinkViewJpaRepository tIdCompanyContactLinkViewJpaRepository;
	@Resource
	private TIdExperienceInformationSearchJpaRepository tIdExperienceInformationSearchJpaRepository;
	@Resource
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkViewJpaRepository tIdRelationshipInfoLinkViewJpaRepository;
	@Resource
	private TIdCommunicationInformationJpaRepository tIdCommunicationInformationJpaRepository;
	@Resource
	private TIdCityMasterEntitySearchJpaRepository tIdCityMasterEntitySearchJpaRepository;
	@Resource
	private TIdStateMasterSearchJpaRepository tIdStateMasterSearchJpaRepository;
	@Resource
	private TIdCountryMasterEntitySearchJpaRepository tIdCountryMasterEntitySearchJpaRepository;
	@Resource
	private TIdCompanyMasterEntitySearchJpaRepository tIdCompanyMasterEntitySearchJpaRepository;
	@Resource
	private TIdBusinessTypeMasterEntitySearchJpaRepository tIdBusinessTypeMasterEntitySearchJpaRepository;
	@Resource
	private TIdDesignationMasterEntitySearchJpaRepository tIdDesignationMasterEntitySearchJpaRepository;
	@Resource
	private TIdRelationshipInformationJpaRepository tIdRelationshipInformationJpaRepository;
	@Resource
	private TIdNationalityMasterSearchJpaRepository tIdNationalityMasterEntitySearchJpaRepository;
	@Resource
	private TIdSocialMediaInformationJpaRepository tIdSocialMediaInformationJpaRepository;
	@Resource
	private TIdLanguageInformationJpaRepository tIdLanguageInformationJpaRepository;
	@Resource
	private TIdLanguageInformationViewJpaRepository tIdLanguageInformationViewJpaRepository;
	@Resource
	private TIdLanguageMasterJpaRepository tIdLanguageMasterJpaRepository;
	@Resource
	private TIdLanguageMasterSearchJpaRepository tIdLanguageMasterSearchJpaRepository;
	@Resource
	private TIdUserMasterJpaRepository tIdUserMasterJpaRepository;
	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	@Resource
	private TIdReferenceCodesHeaderJpaRepository tIdReferenceCodesHeaderJpaRepository;
	@Resource
	private TIdProfileAddressDetailsJpaRepository tIdProfileAddressDetailsJpaRepository;
	@Resource
	private GenericServiceMapper genericServiceMapper;
	@Resource
	private TIdZipCodeMasterSearchJpaRepository tIdZipCodeMasterSearchJpaRepository;
	@Resource
	private TIdProfileAddressDetailsViewJpaRepository tIdProfileAddressDetailsViewJpaRepository;
	@Resource
	private TIdFunctionalAreaMasterEntitySearchJpaRepository tIdFunctionalAreaMasterEntitySearchJpaRepository;
	@Resource
	private TIdQualificationMasterSearchJpaRepository tIdQualificationMasterSearchJpaRepository;
	@Resource
	private PersonIndividualExperienceViewJpaRepository  personIndividualExperienceViewJpaRepository;
	@Resource
	private TIdUserMasterViewJpaRepository tIdUserMasterViewJpaRepository;
	@Resource
	private TIdMyContactsLinkJpaRepository tIdMyContactsLinkJpaRepository;
	@Autowired
	private ShareInfoService shareInfoService;
	
	@Autowired
	private TIdCompanyMasterJpaRepository tIdCompanyMasterJpaRepository;
	
	@Autowired
	private TIdDesignationMasterJpaRepository tIdDesignationMasterJpaRepository;
	
	@Autowired
	private TIdFunctionalAreaMasterJpaRepository tIdFunctionalAreaMasterJpaRepository;
	
	@Autowired
	MyContactInfoService myContactInfoService;
	
	
	
	@Override
	public Long saveCustomerInfo(CustomerInfoBean customerInfoBean) throws Exception {
		String dobStr=null;
		TIdCompanyContactLinkEntitySearch tIdCompanyContactLinkEntitySearch =null;	
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch = null;
		List<TIdExperienceInformationEntitySearch> tIdExperienceInformationEntitySearchList =  new ArrayList<TIdExperienceInformationEntitySearch>();
		TIdCommunicationInformationEntitySearch tIdCommunicationInformationEntitySearch = null;
		List<TIdCommunicationInformationEntitySearch> tIdCommunicationInformationEntitySearchList = new ArrayList<TIdCommunicationInformationEntitySearch>();
		List<TIdCompanyContactLinkEntitySearch> tIdCompanyContactLinkEntitySearchList = new ArrayList<TIdCompanyContactLinkEntitySearch>();
		TIdRelationshipInfoLinkEntity tIdRelationshipInfoLinkEntity = null;
		TIdSocialMediaInformationEntitySearch tIdSocialMediaInformationEntitySearch = null;
		List<TIdSocialMediaInformationEntitySearch> tIdSocialMediaInformationEntitySearchList =   new ArrayList<TIdSocialMediaInformationEntitySearch>();
		List<TIdLanguageInformationEntitySearch> tIdLanguageInformationEntitySearchList = new ArrayList<TIdLanguageInformationEntitySearch>();
		TIdUserMasterEntity tIdUserMasterEntity = null;
		TIdReferenceCodesDetailEntity  tIdReferenceCodesDetail = null;
		TIdReferenceCodesDetailEntity tIdReferenceCodesDetailEntity=null;
		TIdFunctionalAreaMasterEntitySearch tIdFunctionalAreaMasterEntitySearch=null;
		List<TIdProfileAddressDetailsEntitySearch> tIdProfileAddressDetailsEntitySearchList = new ArrayList<TIdProfileAddressDetailsEntitySearch>(); 
		TIdProfileAddressDetailsEntitySearch tIdProfileAddressDetailsEntitySearch = null;
		TIdDesignationMasterEntitySearch tIdDesignationMasterEntitySearch=null;
		TIdCompanyMasterEntitySearch tIdCompanyMasterEntitySearch=null;
		TIdCompanyIndustryLinkEntitySearch tIdCompanyIndustryLinkEntitySearch = null;
		List<TIdCompanyIndustryLinkEntitySearch> tIdCompanyIndustryLinkEntitySearchList=new ArrayList<TIdCompanyIndustryLinkEntitySearch>();
		TIdBusinessTypeMasterEntitySearch tIdBusinessTypeMasterEntitySearch=null;
		TIdEducationalInformationEntitySearch tIdEducationalInformationEntitySearch = null;
		List<TIdEducationalInformationEntitySearch> tIdEducationalInformationEntitySearchList=new ArrayList<TIdEducationalInformationEntitySearch>();
		TIdQualificationMasterEntitySearch tIdQualificationMasterEntitySearch=null;
		TIdCityMasterEntitySearch tIdCityMasterEntitySearch=null;
		List<TIdCityMasterEntitySearch> tIdCityMasterEntitySearchList=null;
		TIdCountryMasterEntitySearch tIdCountryMasterEntitySearch=null;
		TIdStateMasterEntitySearch tIdStateMasterEntitySearch=null;
		List<TIdStateMasterEntitySearch> tIdStateMasterEntitySearchList=null;
		TIdLanguageMasterEntitySearch tIdLanguageMasterEntitySearch=null;
		TIdLanguageInformationEntitySearch tIdLanguageInformationEntitySearch = null;
		TIdReferenceCodesHeaderEntity tIdReferenceCodesHeader=null;
		
		if(userValidate(customerInfoBean)) {
			tIdPersonalInformationEntitySearch = new TIdPersonalInformationEntitySearch();
				if(customerInfoBean.getOtherTitleName()!=null)
				{
					if(customerInfoBean.getTitle()!=null && customerInfoBean.getTitle()!=0) {
						tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Title");
						tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValueAndRcdDetailKeyNotIn(tIdReferenceCodesHeader.getRchHeaderKey(), customerInfoBean.getOtherTitleName(), customerInfoBean.getTitle());
				        if(tIdReferenceCodesDetailEntity!=null) {
				        	if(tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(PENDING_STATUS)){
				        		tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
				        		tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
				        		customerInfoBean.setTitle(tIdReferenceCodesDetailEntity.getRcdDetailKey());
				        		customerInfoBean.setOtherTitleName(null);
				        	} else {
				        		throw new DataIntegrityViolationException("Title name already exist!!!");
				        	}
						} else {
							tIdReferenceCodesDetailEntity = tIdReferenceCodesDetailJpaRepository.findOne(customerInfoBean.getTitle());
							tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
							tIdReferenceCodesDetailEntity.setRcdValue(customerInfoBean.getOtherTitleName());
							tIdReferenceCodesDetailEntity.setRcdAbbreviation(customerInfoBean.getOtherTitleName());
							tIdReferenceCodesDetailEntity.setRcdMeaning(customerInfoBean.getOtherTitleName());
							tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
							customerInfoBean.setOtherTitleName(null);
						}
					}
						else {
							tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Title");
							tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(), customerInfoBean.getOtherTitleName());
							if(tIdReferenceCodesDetailEntity!=null){
									if(tIdReferenceCodesDetailEntity.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) 
											|| tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
										tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
						        		tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
										customerInfoBean.setTitle(tIdReferenceCodesDetailEntity.getRcdDetailKey());
						        		customerInfoBean.setOtherTitleName(null);
									} else {
										throw new HandledException("Title name already exist!!!");
									}

									
								}
						}
				
				
				if(customerInfoBean.getListOfTIdProfileAddressDetailsView()!=null && customerInfoBean.getListOfTIdProfileAddressDetailsView().size()>0) {
					for(TIdProfileAddressDetailsView tIdProfileAddressDetailsView : customerInfoBean.getListOfTIdProfileAddressDetailsView()) {
						if(tIdProfileAddressDetailsView.getPadOtherCityName()!=null){
							tIdCityMasterEntitySearchList=tIdCityMasterEntitySearchJpaRepository.findByName(tIdProfileAddressDetailsView.getPadOtherCityName());
							if(tIdCityMasterEntitySearchList.size()>0){
								if(tIdCityMasterEntitySearchList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) 
										|| tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS)) {
									tIdCityMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
									tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearchList);
									tIdProfileAddressDetailsView.setPadCityKey(tIdCityMasterEntitySearchList.get(0).getKey());
									tIdProfileAddressDetailsView.setPadOtherCityName(null);
								} else {
									throw new HandledException("City name already exist!!!");
								}
							}
						}
						if(tIdProfileAddressDetailsView.getPadOtherStateName()!=null) {
							tIdStateMasterEntitySearchList = tIdStateMasterSearchJpaRepository.findByName(tIdProfileAddressDetailsView.getPadOtherStateName());
							if(tIdStateMasterEntitySearchList.size()>0) {
								if(tIdStateMasterEntitySearchList.get(0).getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS)|| tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS))
									tIdStateMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
									tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearchList);
									tIdProfileAddressDetailsView.setPadStateKey(tIdStateMasterEntitySearchList.get(0).getKey());
									tIdProfileAddressDetailsView.setPadOtherStateName(null);
								} else {
									throw new HandledException("State name already exist!!!");
								}
							}
						}
					}
				}
				
				if(customerInfoBean.getOtherLanguage()!=null) {
					tIdLanguageMasterEntitySearch=tIdLanguageMasterSearchJpaRepository.findByName(customerInfoBean.getOtherLanguage());
					if(tIdLanguageMasterEntitySearch!=null) {
						if(tIdLanguageMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdLanguageMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdLanguageMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							List<TIdLanguageInformationViewEntity> languageEntityList = new ArrayList<TIdLanguageInformationViewEntity>();
							tIdLanguageMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdLanguageMasterSearchJpaRepository.save(tIdLanguageMasterEntitySearch);
							TIdLanguageInformationViewEntity languageEntity = new TIdLanguageInformationViewEntity();
							languageEntity.setPliLanguageKey(tIdLanguageMasterEntitySearch.getKey());
							languageEntityList.add(languageEntity);
							customerInfoBean.setLanguage(languageEntityList);
							customerInfoBean.setOtherLanguage(null);
						} else {
							throw new HandledException("Language already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getOtherCompanyName()!=null) {
					tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.findByName(customerInfoBean.getOtherCompanyName());
					if(tIdCompanyMasterEntitySearch!=null){
						if(tIdCompanyMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdCompanyMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdCompanyMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
							tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);	
							tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
							customerInfoBean.setCompanyKey(tIdCompanyMasterEntitySearch.getCompanyKey());
							customerInfoBean.setOtherCompanyName(null);
						} else {
							throw new HandledException("Company name already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getOtherDesignName()!=null) {
					tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.findByName(customerInfoBean.getOtherDesignName());
						if(tIdDesignationMasterEntitySearch!=null){
				        	if(tIdDesignationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdDesignationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) ||tIdDesignationMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
				        		tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
				        		tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
				        		customerInfoBean.setDesignKey(tIdDesignationMasterEntitySearch.getKey());
								customerInfoBean.setOtherDesignName(null);
				        	} else {
								throw new DataIntegrityViolationException("Designation name already exist!!!");
							}
						}
				}
				
				if(customerInfoBean.getOtherRoleName()!=null) {
					tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Role");
					tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.
							findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(),customerInfoBean.getOtherRoleName());
					if(tIdReferenceCodesDetailEntity!=null){
						if(tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdReferenceCodesDetailEntity.getActiveStatus().equals(PENDING_STATUS)){
							tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
							tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
							customerInfoBean.setRoleKey(tIdReferenceCodesDetailEntity.getRcdDetailKey());
							customerInfoBean.setOtherRoleName(null);
						} else {
							throw new HandledException("Role name already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getOtherFunctionName()!=null) {
					tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.findByName(customerInfoBean.getOtherFunctionName());
					if(tIdFunctionalAreaMasterEntitySearch!=null){
						if(tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdFunctionalAreaMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
							tIdFunctionalAreaMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdFunctionalAreaMasterEntitySearchJpaRepository.save(tIdFunctionalAreaMasterEntitySearch);
							customerInfoBean.setFunctionKey(tIdFunctionalAreaMasterEntitySearch.getFunctionKey());
							customerInfoBean.setOtherFunctionName(null);
						} else {
							throw new HandledException("Functional area name already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getOtherStateName()!=null) {
					tIdStateMasterEntitySearchList = tIdStateMasterSearchJpaRepository.findByName(customerInfoBean.getOtherStateName());
					if(tIdStateMasterEntitySearchList!=null && tIdStateMasterEntitySearchList.size()>0) {
						if(tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(PENDING_STATUS)){
							tIdStateMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
							tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearchList);
							customerInfoBean.setStateKey(tIdStateMasterEntitySearchList.get(0).getKey());
							customerInfoBean.setOtherStateName(null);
						} else {
							throw new HandledException("State name already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getOtherCityName()!=null){
					tIdCityMasterEntitySearchList=tIdCityMasterEntitySearchJpaRepository.findByName(customerInfoBean.getOtherCityName());
					if(tIdCityMasterEntitySearchList!=null && tIdCityMasterEntitySearchList.size()>0){
						if(tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(PENDING_STATUS)){
							tIdCityMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
							tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearchList);
							customerInfoBean.setCityKey(tIdCityMasterEntitySearchList.get(0).getKey());
							customerInfoBean.setOtherCityName(null);
						} else {
							throw new HandledException("City name already exist!!!");
						}
					}
				}

				if(customerInfoBean.getOtherIndustryName()!=null){
					tIdBusinessTypeMasterEntitySearch=tIdBusinessTypeMasterEntitySearchJpaRepository.findByName(customerInfoBean.getOtherIndustryName());
					if(tIdBusinessTypeMasterEntitySearch!=null){
						if(tIdBusinessTypeMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdBusinessTypeMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdBusinessTypeMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
							tIdBusinessTypeMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdBusinessTypeMasterEntitySearchJpaRepository.save(tIdBusinessTypeMasterEntitySearch); 
							List<Long> listOfbusinessKey = new ArrayList<Long>();
							listOfbusinessKey.add(tIdBusinessTypeMasterEntitySearch.getBtmKey());
							customerInfoBean.setListOfbusinessKey(listOfbusinessKey);
							customerInfoBean.setOtherIndustryName(null);
						} else {
							throw new HandledException("Industry name already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getOtherEducationName()!=null){
					tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.findByName(customerInfoBean.getOtherEducationName());
					if(tIdQualificationMasterEntitySearch!=null){
						if(tIdQualificationMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)||tIdQualificationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdQualificationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							List<Long> listOfDegreeKey = new ArrayList<Long>();
							tIdQualificationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdQualificationMasterSearchJpaRepository.save(tIdQualificationMasterEntitySearch);
							listOfDegreeKey.add(tIdQualificationMasterEntitySearch.getQualificationKey());
							customerInfoBean.setListOfDegreeKey(listOfDegreeKey);
							customerInfoBean.setOtherEducationName(null);
						} else {
							throw new HandledException("Qualification name already exist!!!");
						}
					}
				}
				
				if(customerInfoBean.getPinKey()!=null) {
					
					tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
					List<TIdCommunicationInformationEntity> communicationList = tIdCommunicationInformationJpaRepository.findByPcmPinKey(customerInfoBean.getPinKey());  
					if(communicationList.size()>0) {
						tIdCommunicationInformationJpaRepository.delete(communicationList);
					}
					
					List<TIdProfileAddressDetailsEntity> profileAddDetailsList = tIdProfileAddressDetailsJpaRepository.findByPadPinKey(customerInfoBean.getPinKey());
					if(profileAddDetailsList.size()>0) {
						tIdProfileAddressDetailsJpaRepository.delete(profileAddDetailsList);
					}
					
					List<TIdSocialMediaInformationEntity> socialMediaInfoList = tIdSocialMediaInformationJpaRepository.findByPsmPinKey(customerInfoBean.getPinKey());
					if(socialMediaInfoList.size()>0) {
						tIdSocialMediaInformationJpaRepository.delete(socialMediaInfoList);
					}
					
					List<TIdLanguageInformationEntity> languageIngoList = tIdLanguageInformationJpaRepository.findByPliPinKey(customerInfoBean.getPinKey());
					if(languageIngoList.size()>0) {
						tIdLanguageInformationJpaRepository.delete(languageIngoList);
					}
					
					List<TIdCompanyContactLinkEntity> tIdCompanyContactLinkEntityList = tIdCompanyContactLinkJpaRepository.findByCclPinKey(customerInfoBean.getPinKey());
					if(tIdCompanyContactLinkEntityList.size()>0) {
						tIdCompanyContactLinkJpaRepository.delete(tIdCompanyContactLinkEntityList);
					}
					
					List<TIdRelationshipInfoLinkEntity> tIdRelationshipInfoLinkEntityList = tIdRelationshipInfoLinkJpaRepository.findByPrlkToPinKeyAndPrlkContact(customerInfoBean.getPinKey(),1L);
					if(tIdRelationshipInfoLinkEntityList.size()>0) {
						tIdRelationshipInfoLinkJpaRepository.delete(tIdRelationshipInfoLinkEntityList);
					}
					
				} else {
					//Prepare the experience info
					tIdExperienceInformationEntitySearch=new TIdExperienceInformationEntitySearch();
					if(customerInfoBean.getOtherCompanyName()!=null) // saving other company
					{
						tIdCompanyMasterEntitySearch = new TIdCompanyMasterEntitySearch();
						tIdCompanyMasterEntitySearch.setName(customerInfoBean.getOtherCompanyName());
						tIdCompanyMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdCompanyMasterEntitySearch.setCompanyGroup(PENDING_STATUS);
						tIdCompanyMasterEntitySearch.setLockKey(0L);
						tIdCompanyMasterEntitySearch.setActiveFrom(new Date());
						tIdCompanyMasterEntitySearch.setProfileKey(1L);
						tIdCompanyMasterEntitySearch=tIdCompanyMasterEntitySearchJpaRepository.save(tIdCompanyMasterEntitySearch);
						tIdExperienceInformationEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearch);
						
					} else if(customerInfoBean.getCompanyKey()!=null){
						tIdCompanyMasterEntitySearch =tIdCompanyMasterEntitySearchJpaRepository.findOne(customerInfoBean.getCompanyKey());
						tIdExperienceInformationEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearch);
					}
	
					if(customerInfoBean.getOtherDesignName()!=null) // saving other designation
					{
						tIdDesignationMasterEntitySearch=new TIdDesignationMasterEntitySearch();
						tIdDesignationMasterEntitySearch.setName(customerInfoBean.getOtherDesignName());
						tIdDesignationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdDesignationMasterEntitySearch.setDesigActiveFlag(0L);
						tIdDesignationMasterEntitySearch.setLockKey(0L);
						tIdDesignationMasterEntitySearch.setProfileKey(1L);
						tIdDesignationMasterEntitySearch.setActiveFrom(new Date());
						tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.save(tIdDesignationMasterEntitySearch);
						tIdExperienceInformationEntitySearch.setTIdDesignationMaster(tIdDesignationMasterEntitySearch);
					
					} else	if(customerInfoBean.getDesignKey()!=null){
						tIdDesignationMasterEntitySearch=tIdDesignationMasterEntitySearchJpaRepository.findOne(customerInfoBean.getDesignKey());
						tIdExperienceInformationEntitySearch.setTIdDesignationMaster(tIdDesignationMasterEntitySearch);
					}
					
					if(customerInfoBean.getOtherRoleName()!=null)
					{
						tIdReferenceCodesDetail = new TIdReferenceCodesDetailEntity();
						tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Role");
						tIdReferenceCodesDetail.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
						tIdReferenceCodesDetail.setRcdAbbreviation(customerInfoBean.getOtherRoleName());
						tIdReferenceCodesDetail.setRcdValue(customerInfoBean.getOtherRoleName());
						tIdReferenceCodesDetail.setRcdMeaning(customerInfoBean.getOtherRoleName());
						tIdReferenceCodesDetail.setRcdLowRange(0L);
						tIdReferenceCodesDetail.setRcdHighRange(0L);
						tIdReferenceCodesDetail.setRcdOrderBy(0L);
						tIdReferenceCodesDetail.setActiveStatus(PENDING_STATUS);
						tIdReferenceCodesDetail.setRcdSetAsDefault("N");
						tIdReferenceCodesDetail.setProfileKey(1L);
						tIdReferenceCodesDetail.setLockKey(0L);
						tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetail);
						tIdExperienceInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
						
					} else if(customerInfoBean.getRoleKey()!=null){
						tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.findOne(customerInfoBean.getRoleKey());
						tIdExperienceInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
						
					}
					
					if(customerInfoBean.getOtherFunctionName()!=null) // saving other functional area
					{
						tIdFunctionalAreaMasterEntitySearch = new TIdFunctionalAreaMasterEntitySearch();
						tIdFunctionalAreaMasterEntitySearch.setName(customerInfoBean.getOtherFunctionName());
						tIdFunctionalAreaMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdFunctionalAreaMasterEntitySearch.setFunctionActiveStatusKey(1L);
						tIdFunctionalAreaMasterEntitySearch.setLockKey(0L);
						tIdFunctionalAreaMasterEntitySearch.setProfileKey(1L);
						tIdFunctionalAreaMasterEntitySearch.setActiveFrom(new Date());
						tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.save(tIdFunctionalAreaMasterEntitySearch);
						tIdExperienceInformationEntitySearch.setTIdFunctionalAreaMaster(tIdFunctionalAreaMasterEntitySearch);
						
					} else if(customerInfoBean.getFunctionKey()!=null) {
						
						tIdFunctionalAreaMasterEntitySearch=tIdFunctionalAreaMasterEntitySearchJpaRepository.findOne(customerInfoBean.getFunctionKey());
						tIdExperienceInformationEntitySearch.setTIdFunctionalAreaMaster(tIdFunctionalAreaMasterEntitySearch);
					}
					
					if(customerInfoBean.getCountryKey()!=null){
						tIdCountryMasterEntitySearch=tIdCountryMasterEntitySearchJpaRepository.findOne(customerInfoBean.getCountryKey());
						tIdExperienceInformationEntitySearch.setTIdCountryMasterSearch(tIdCountryMasterEntitySearch);
					}
					
					if(customerInfoBean.getOtherStateName()!=null) {
						tIdStateMasterEntitySearch = new TIdStateMasterEntitySearch();
						tIdStateMasterEntitySearch.setName(customerInfoBean.getOtherStateName());
						tIdStateMasterEntitySearch.setStateAbbreviation(customerInfoBean.getOtherStateName());
						tIdStateMasterEntitySearch.setStateCountryKey(customerInfoBean.getCountryKey());
						tIdStateMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdStateMasterEntitySearch.setActiveFrom(new Date());
						tIdStateMasterEntitySearch.setLockKey(0L);
						tIdStateMasterEntitySearch.setProfileKey(1l);
						tIdStateMasterEntitySearch = tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearch);
						tIdExperienceInformationEntitySearch.setTIdStateMasterSearch(tIdStateMasterEntitySearch);

					} else if(customerInfoBean.getStateKey()!=null) {
						tIdStateMasterEntitySearch=tIdStateMasterSearchJpaRepository.findOne(customerInfoBean.getStateKey());
						tIdExperienceInformationEntitySearch.setTIdStateMasterSearch(tIdStateMasterEntitySearch);
					}
					
					if(customerInfoBean.getOtherCityName()!=null){
						tIdCityMasterEntitySearch=new TIdCityMasterEntitySearch();
						tIdCityMasterEntitySearch.setActiveFrom(new Date());
						tIdCityMasterEntitySearch.setName(customerInfoBean.getOtherCityName());
						tIdCityMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdCityMasterEntitySearch.setLockKey(0L);
						tIdCityMasterEntitySearch.setProfileKey(1l);
						tIdCountryMasterEntitySearch=tIdCountryMasterEntitySearchJpaRepository.findOne(customerInfoBean.getCountryKey());
						tIdCityMasterEntitySearch.setTIdCountryMasterSearch(tIdCountryMasterEntitySearch);
						tIdCityMasterEntitySearch=tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearch);
						tIdExperienceInformationEntitySearch.setTIdCityMasterSearch(tIdCityMasterEntitySearch);
						
					} else if(customerInfoBean.getCityKey()!=null) {
						tIdExperienceInformationEntitySearch.setTIdCityMasterSearch(tIdCityMasterEntitySearchJpaRepository.findOne(customerInfoBean.getCityKey()));
					}
					
					tIdExperienceInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdExperienceInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdExperienceInformationEntitySearch.setPexCurrentlyWorking("Y");
					tIdExperienceInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);

					if(customerInfoBean.getOtherIndustryName()!=null){
						tIdCompanyIndustryLinkEntitySearch = new TIdCompanyIndustryLinkEntitySearch();
						tIdBusinessTypeMasterEntitySearch=new TIdBusinessTypeMasterEntitySearch();
						tIdBusinessTypeMasterEntitySearch.setName(customerInfoBean.getOtherIndustryName());
						tIdBusinessTypeMasterEntitySearch.setLockKey(0L);
						tIdBusinessTypeMasterEntitySearch.setProfileKey(1L);
						tIdBusinessTypeMasterEntitySearch.setActiveFrom(new Date());
						tIdBusinessTypeMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdBusinessTypeMasterEntitySearch=tIdBusinessTypeMasterEntitySearchJpaRepository.save(tIdBusinessTypeMasterEntitySearch);
						tIdCompanyIndustryLinkEntitySearch.settIdBusinessTypeMasterEntitySearch(tIdBusinessTypeMasterEntitySearch);
						tIdCompanyIndustryLinkEntitySearch.settIdExperienceInformationEntitySearch(tIdExperienceInformationEntitySearch);
						tIdCompanyIndustryLinkEntitySearch.setCilLockKey(customerInfoBean.getLockKey());
						tIdCompanyIndustryLinkEntitySearchList.add(tIdCompanyIndustryLinkEntitySearch);
					} 
					
					if(customerInfoBean.getListOfbusinessKey()!=null&&customerInfoBean.getListOfbusinessKey().size()>0) {
						for(Long businessKey:customerInfoBean.getListOfbusinessKey())
						{
							tIdCompanyIndustryLinkEntitySearch = new TIdCompanyIndustryLinkEntitySearch();
							tIdBusinessTypeMasterEntitySearch=tIdBusinessTypeMasterEntitySearchJpaRepository.findOne(businessKey);
							tIdCompanyIndustryLinkEntitySearch.settIdBusinessTypeMasterEntitySearch(tIdBusinessTypeMasterEntitySearch);
							tIdCompanyIndustryLinkEntitySearch.settIdExperienceInformationEntitySearch(tIdExperienceInformationEntitySearch);
							tIdCompanyIndustryLinkEntitySearch.setCilLockKey(customerInfoBean.getLockKey());
							tIdCompanyIndustryLinkEntitySearchList.add(tIdCompanyIndustryLinkEntitySearch);
						}
					}
					
					tIdExperienceInformationEntitySearch.setListOfTIdCompanyIndustryLinkEntitySearch(tIdCompanyIndustryLinkEntitySearchList);
					tIdExperienceInformationEntitySearchList.add(tIdExperienceInformationEntitySearch);
					
					tIdPersonalInformationEntitySearch.setListOfTIdExperienceInformation(tIdExperienceInformationEntitySearchList);
					
					
					//Prepare the List of education info
					if(customerInfoBean.getOtherEducationName()!=null){
						tIdEducationalInformationEntitySearch = new TIdEducationalInformationEntitySearch();
						tIdQualificationMasterEntitySearch = new TIdQualificationMasterEntitySearch();
						tIdQualificationMasterEntitySearch.setName(customerInfoBean.getOtherEducationName());
						tIdQualificationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdQualificationMasterEntitySearch.setProfileKey(1L);
						tIdQualificationMasterEntitySearch.setLockKey(0L);
						tIdQualificationMasterEntitySearch.setActiveFrom(new Date());
						tIdQualificationMasterEntitySearch=tIdQualificationMasterSearchJpaRepository.save(tIdQualificationMasterEntitySearch);
						tIdEducationalInformationEntitySearch.settIdQualificationMaster(tIdQualificationMasterEntitySearch);
						tIdEducationalInformationEntitySearch.setLockKey(customerInfoBean.getLockKey());
						tIdEducationalInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
						tIdEducationalInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
						tIdEducationalInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
						tIdEducationalInformationEntitySearchList.add(tIdEducationalInformationEntitySearch);
					} 
					
					if(customerInfoBean.getListOfDegreeKey()!=null&&customerInfoBean.getListOfDegreeKey().size()>0){
						for(Long degreeKey:customerInfoBean.getListOfDegreeKey()){
							tIdEducationalInformationEntitySearch = new TIdEducationalInformationEntitySearch();
							tIdEducationalInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
							tIdEducationalInformationEntitySearch.settIdQualificationMaster(tIdQualificationMasterSearchJpaRepository.findOne(degreeKey));
							tIdEducationalInformationEntitySearch.setLockKey(customerInfoBean.getLockKey());
							tIdEducationalInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
							tIdEducationalInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
							tIdEducationalInformationEntitySearchList.add(tIdEducationalInformationEntitySearch);
						}
					}
					
					tIdPersonalInformationEntitySearch.setListOfTIdEducationalInformation(tIdEducationalInformationEntitySearchList);
				}
				
				if(customerInfoBean.getOtherTitleName()!=null)
				{
					tIdReferenceCodesDetail = new TIdReferenceCodesDetailEntity();
					tIdReferenceCodesDetail.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
					tIdReferenceCodesDetail.setRcdAbbreviation(customerInfoBean.getOtherTitleName());
					tIdReferenceCodesDetail.setRcdValue(customerInfoBean.getOtherTitleName());
					tIdReferenceCodesDetail.setRcdMeaning(customerInfoBean.getOtherTitleName());
					tIdReferenceCodesDetail.setRcdLowRange(0L);
					tIdReferenceCodesDetail.setRcdHighRange(0L);
					tIdReferenceCodesDetail.setRcdOrderBy(0L);
					tIdReferenceCodesDetail.setActiveStatus(PENDING_STATUS);
					tIdReferenceCodesDetail.setRcdSetAsDefault("N");
					tIdReferenceCodesDetail.setProfileKey(1L);
					tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetail);
					tIdPersonalInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
				
				} else {
					tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.findOne(customerInfoBean.getTitle());
					tIdPersonalInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
				}
				
				tIdPersonalInformationEntitySearch.setPinFirstName(customerInfoBean.getFirstName());
				tIdPersonalInformationEntitySearch.setPinLastName(customerInfoBean.getLastName());
				tIdPersonalInformationEntitySearch.setPinNickName(customerInfoBean.getNickName());
				tIdPersonalInformationEntitySearch.setPinGender(customerInfoBean.getGender());
				tIdPersonalInformationEntitySearch.setPinEmail(customerInfoBean.getEmailId());
				tIdPersonalInformationEntitySearch.setPinDob(customerInfoBean.getDob());
				if(customerInfoBean.getDob()!=null){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					 try{
						  dobStr=formatter.format(customerInfoBean.getDob());
					 } catch(Exception e) {
				            e.printStackTrace();
					 }
				}	 
				tIdPersonalInformationEntitySearch.setPinDobStr(dobStr);
				tIdPersonalInformationEntitySearch.setPinDoa(customerInfoBean.getDoa());
				tIdPersonalInformationEntitySearch.setPinAddress(customerInfoBean.getAddress());
				tIdPersonalInformationEntitySearch.setPinRemarks(customerInfoBean.getRemarks());
				
				
				if(customerInfoBean.getListOfTIdProfileAddressDetailsView()!=null && customerInfoBean.getListOfTIdProfileAddressDetailsView().size()>0) {
					
					for(TIdProfileAddressDetailsView tIdProfileAddressDetailsView : customerInfoBean.getListOfTIdProfileAddressDetailsView()) {
						tIdProfileAddressDetailsEntitySearch = new TIdProfileAddressDetailsEntitySearch();
						
						tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findOne(tIdProfileAddressDetailsView.getPadAddressType());
						tIdProfileAddressDetailsEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetailEntity);
						tIdProfileAddressDetailsEntitySearch.setPadPinzip(tIdProfileAddressDetailsView.getPadPinzip());
						
						if(tIdProfileAddressDetailsView.getPadCountryKey()!=null) {
							tIdCountryMasterEntitySearch=tIdCountryMasterEntitySearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadCountryKey());
							tIdProfileAddressDetailsEntitySearch.settIdCountryMasterSearch(tIdCountryMasterEntitySearch);
						}
						
						if(tIdProfileAddressDetailsView.getPadOtherStateName()!=null) {
							tIdStateMasterEntitySearch = new TIdStateMasterEntitySearch();
							tIdStateMasterEntitySearch.setName(tIdProfileAddressDetailsView.getPadOtherStateName());
							tIdStateMasterEntitySearch.setStateAbbreviation(tIdProfileAddressDetailsView.getPadOtherStateName());
							tIdStateMasterEntitySearch.setStateCountryKey(tIdProfileAddressDetailsView.getPadCountryKey());
							tIdStateMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdStateMasterEntitySearch.setActiveFrom(new Date());
							tIdStateMasterEntitySearch.setLockKey(0L);
							tIdStateMasterEntitySearch.setProfileKey(1l);
							tIdStateMasterEntitySearch = tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearch);
							tIdProfileAddressDetailsEntitySearch.settIdStateMasterSearch(tIdStateMasterEntitySearch);

						} else if(tIdProfileAddressDetailsView.getPadStateKey()!=null) {
							tIdStateMasterEntitySearch=tIdStateMasterSearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadStateKey());
							tIdProfileAddressDetailsEntitySearch.settIdStateMasterSearch(tIdStateMasterEntitySearch);
						}
						
						if(tIdProfileAddressDetailsView.getPadOtherCityName()!=null){
							tIdCityMasterEntitySearch=new TIdCityMasterEntitySearch();
							tIdCityMasterEntitySearch.setActiveFrom(new Date());
							tIdCityMasterEntitySearch.setName(tIdProfileAddressDetailsView.getPadOtherCityName());
							tIdCityMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdCityMasterEntitySearch.setLockKey(0L);
							tIdCityMasterEntitySearch.setProfileKey(1l);
							tIdCityMasterEntitySearch.setTIdCountryMasterSearch(tIdCountryMasterEntitySearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadCountryKey()));
							tIdCityMasterEntitySearch=tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearch);
							tIdProfileAddressDetailsEntitySearch.settIdCityMasterSearch(tIdCityMasterEntitySearch);
							
						} else if(tIdProfileAddressDetailsView.getPadCityKey()!=null) {
							tIdProfileAddressDetailsEntitySearch.settIdCityMasterSearch(tIdCityMasterEntitySearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadCityKey()));
						}
						
						tIdProfileAddressDetailsEntitySearch.setPadAddressLine1(tIdProfileAddressDetailsView.getPadAddressLine1());
						tIdProfileAddressDetailsEntitySearch.setPadAddressLine2(tIdProfileAddressDetailsView.getPadAddressLine2());
						tIdProfileAddressDetailsEntitySearch.setProfileKey(tIdProfileAddressDetailsView.getProfileKey());
						tIdProfileAddressDetailsEntitySearch.setActiveStatus(tIdProfileAddressDetailsView.getActiveStatus());
						tIdProfileAddressDetailsEntitySearch.setLockKey(tIdProfileAddressDetailsView.getLockKey());
						tIdProfileAddressDetailsEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
						tIdProfileAddressDetailsEntitySearchList.add(tIdProfileAddressDetailsEntitySearch);
					}
					
					tIdPersonalInformationEntitySearch.setListOfTIdProfileAddressDetails(tIdProfileAddressDetailsEntitySearchList);
				}
				
				if(customerInfoBean.getNationalityKey()!=null) {
					TIdNationalityMasterEntitySearch tIdNationalityMasterEntitySearch=tIdNationalityMasterEntitySearchJpaRepository.findOne(customerInfoBean.getNationalityKey());
					tIdPersonalInformationEntitySearch.settIdNationalityMasterSearch(tIdNationalityMasterEntitySearch);
				}
				tIdPersonalInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
				tIdPersonalInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
				
				if(customerInfoBean.getOtherLanguage()!=null) { // Other language save in language master table
					tIdLanguageMasterEntitySearch = new TIdLanguageMasterEntitySearch();
					tIdLanguageMasterEntitySearch.setName(customerInfoBean.getOtherLanguage());
					tIdLanguageMasterEntitySearch.setActiveFrom(new Date());
					tIdLanguageMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdLanguageMasterEntitySearch.setLockKey(0L);
					tIdLanguageMasterEntitySearch.setProfileKey(1L);
					tIdLanguageMasterEntitySearch = tIdLanguageMasterSearchJpaRepository.save(tIdLanguageMasterEntitySearch);
					
					//language information save
					tIdLanguageInformationEntitySearch = new TIdLanguageInformationEntitySearch();
					tIdLanguageInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdLanguageInformationEntitySearch.setTIdLanguageMaster(tIdLanguageMasterEntitySearch);
					tIdLanguageInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdLanguageInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdLanguageInformationEntitySearchList.add(tIdLanguageInformationEntitySearch);
				}

				if(customerInfoBean.getLanguage()!=null && customerInfoBean.getLanguage().size()>0) {
					for(TIdLanguageInformationViewEntity tIdLanguageInformationViewEntity : customerInfoBean.getLanguage()) {
						tIdLanguageInformationEntitySearch = new TIdLanguageInformationEntitySearch();
						tIdLanguageInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
						tIdLanguageInformationEntitySearch.setTIdLanguageMaster(
								tIdLanguageMasterSearchJpaRepository.findOne(tIdLanguageInformationViewEntity.getPliLanguageKey()));
						tIdLanguageInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
						tIdLanguageInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
						tIdLanguageInformationEntitySearchList.add(tIdLanguageInformationEntitySearch);
					}
				}
				tIdPersonalInformationEntitySearch.setListOfTIdLanguageInformation(tIdLanguageInformationEntitySearchList);
				
				if(customerInfoBean.getCustRelShipBeanList()!=null) {
					for(CustRelShipBean custRelShipBean : customerInfoBean.getCustRelShipBeanList()) {
						if(custRelShipBean.getUserPinKey()==null) {
							tIdCompanyContactLinkEntitySearch = new TIdCompanyContactLinkEntitySearch();
							tIdCompanyContactLinkEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
							tIdCompanyContactLinkEntitySearch.setTIdReferenceCodesDetail(tIdReferenceCodesDetailJpaRepository.findOne(custRelShipBean.getCorpRelationKey()));
							tIdCompanyContactLinkEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearchJpaRepository.findOne(custRelShipBean.getGroupCmKey()));
							tIdCompanyContactLinkEntitySearch.setActiveStatus(ACTIVESTATUS); 
							tIdCompanyContactLinkEntitySearch.setProfileKey(customerInfoBean.getProfileKey()); 
							tIdCompanyContactLinkEntitySearchList.add(tIdCompanyContactLinkEntitySearch);
						}
					}
				}
				
				tIdPersonalInformationEntitySearch.setListOfTIdCompanyContactLink(tIdCompanyContactLinkEntitySearchList);
				
				if(customerInfoBean.getMobile()!=null && !"".equals(customerInfoBean.getMobile())) {
					tIdCommunicationInformationEntitySearch = new TIdCommunicationInformationEntitySearch();
					tIdCommunicationInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdCommunicationInformationEntitySearch.setPcmType("M");
					tIdCommunicationInformationEntitySearch.setPcmDescription(customerInfoBean.getMobile().replace(" ", ""));
					tIdCommunicationInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdCommunicationInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdCommunicationInformationEntitySearchList.add(tIdCommunicationInformationEntitySearch);
				}
				if(customerInfoBean.getLandLine()!=null && !"".equals(customerInfoBean.getLandLine())) {
					tIdCommunicationInformationEntitySearch = new TIdCommunicationInformationEntitySearch();
					tIdCommunicationInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdCommunicationInformationEntitySearch.setPcmType("L");
					tIdCommunicationInformationEntitySearch.setPcmDescription(customerInfoBean.getLandLine().replace(" ", ""));
					tIdCommunicationInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdCommunicationInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdCommunicationInformationEntitySearchList.add(tIdCommunicationInformationEntitySearch);
				}
				tIdPersonalInformationEntitySearch.setListOfTIdCommunicationInformation(tIdCommunicationInformationEntitySearchList);
				
				if(customerInfoBean.getLinkedIn()!=null) {
					tIdSocialMediaInformationEntitySearch = new TIdSocialMediaInformationEntitySearch();
					tIdSocialMediaInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdSocialMediaInformationEntitySearch.setPsmType("L");
					tIdSocialMediaInformationEntitySearch.setPsmId(customerInfoBean.getLinkedIn());
					tIdSocialMediaInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdSocialMediaInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdSocialMediaInformationEntitySearchList.add(tIdSocialMediaInformationEntitySearch);
				}
				if(customerInfoBean.getFacebook()!=null) {
					tIdSocialMediaInformationEntitySearch = new TIdSocialMediaInformationEntitySearch();
					tIdSocialMediaInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdSocialMediaInformationEntitySearch.setPsmType("F");
					tIdSocialMediaInformationEntitySearch.setPsmId(customerInfoBean.getFacebook());
					tIdSocialMediaInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdSocialMediaInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdSocialMediaInformationEntitySearchList.add(tIdSocialMediaInformationEntitySearch);
				}
				if(customerInfoBean.getTwitter()!=null) {
					tIdSocialMediaInformationEntitySearch = new TIdSocialMediaInformationEntitySearch();
					tIdSocialMediaInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdSocialMediaInformationEntitySearch.setPsmType("T");
					tIdSocialMediaInformationEntitySearch.setPsmId(customerInfoBean.getTwitter());
					tIdSocialMediaInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdSocialMediaInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdSocialMediaInformationEntitySearchList.add(tIdSocialMediaInformationEntitySearch);
				}
				tIdPersonalInformationEntitySearch.setListOfTIdSocialMediaInformation(tIdSocialMediaInformationEntitySearchList);
				
				tIdPersonalInformationEntitySearch.setModifiedOn(new Date());
				
				if(customerInfoBean.getCreatorPinKey()!=null && customerInfoBean.getPinKey()==null) {
					tIdPersonalInformationEntitySearch.setPinCreatorKey(customerInfoBean.getCreatorPinKey());
				}
				tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
				
				//
				if(tIdPersonalInformationEntitySearch.getPinCreatorKey().equals(0l)) {
					tIdPersonalInformationEntitySearch.setPinCreatorKey(tIdPersonalInformationEntitySearch.getPinKey());
					tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
				}

				
				//save for t_id_personal_info_link
				if(tIdExperienceInformationEntitySearch!=null) {
					TIdPersonalInfoLinkEntity tIdPersonalInfoLinkEntity = new TIdPersonalInfoLinkEntity();
					tIdPersonalInfoLinkEntity.setPilPinKey(tIdPersonalInformationEntitySearch.getPinKey());
					tIdPersonalInfoLinkEntity.setPilPexKey(tIdExperienceInformationEntitySearch.getPexKey());
					tIdPersonalInfoLinkEntity.setPilCurrentlyWorking(tIdExperienceInformationEntitySearch.getPexCurrentlyWorking());
					tIdPersonalInfoLinkJpaRepository.save(tIdPersonalInfoLinkEntity);
				}
				
				//Add the relationship
				TIdRelationshipInformationEntity tIdRelationshipInformationEntity = null;
				if(customerInfoBean.getCustRelShipBeanList()!=null) {
					for(CustRelShipBean custRelShipBean : customerInfoBean.getCustRelShipBeanList()) {
						if(custRelShipBean.getUserPinKey()!=null) {
							tIdRelationshipInformationEntity = new TIdRelationshipInformationEntity();
							tIdRelationshipInformationEntity.setPrlPinKey(custRelShipBean.getUserPinKey());
							tIdRelationshipInformationEntity.setPrlTitle(tIdPersonalInformationEntitySearch.gettIdReferenceCodesDetail().getRcdDetailKey());
							tIdRelationshipInformationEntity.setPrlFirstName(customerInfoBean.getFirstName());
							tIdRelationshipInformationEntity.setPrlLastName(customerInfoBean.getLastName());
							tIdRelationshipInformationEntity.setActiveStatus(ACTIVESTATUS);
							tIdRelationshipInformationEntity.setLockKey(0L);
							tIdRelationshipInformationEntity.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
							tIdRelationshipInformationEntity = tIdRelationshipInformationJpaRepository.save(tIdRelationshipInformationEntity);
							
							TIdRelationshipInfoLinkEntity tIdRelationshipInfoLinkEntity2 = new TIdRelationshipInfoLinkEntity();
							tIdRelationshipInfoLinkEntity2.setPrlkPrlKey(tIdRelationshipInformationEntity.getPrlKey());
							tIdRelationshipInfoLinkEntity2.setPrlkRelationType(custRelShipBean.getCorpRelationName());
							tIdRelationshipInfoLinkEntity2.setPrlkRelationship(custRelShipBean.getCorpRelationName());
							tIdRelationshipInfoLinkEntity2.setPrlkRelationshipKey(custRelShipBean.getCorpRelationKey());
							tIdRelationshipInfoLinkEntity2.setPrlkFromPinKey(custRelShipBean.getUserPinKey());
							tIdRelationshipInfoLinkEntity2.setPrlkToPinKey(tIdPersonalInformationEntitySearch.getPinKey());
							tIdRelationshipInfoLinkEntity2.setPrlkContact(1L);
							tIdRelationshipInfoLinkEntity2.setActiveStatus(ACTIVESTATUS);
							tIdRelationshipInfoLinkEntity2.setLockKey(0L);
							tIdRelationshipInfoLinkEntity2.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
							tIdRelationshipInfoLinkJpaRepository.save(tIdRelationshipInfoLinkEntity2);
						}
					}
				}
				
				if(customerInfoBean.getRelationId()!=null) {
					tIdRelationshipInfoLinkEntity = tIdRelationshipInfoLinkJpaRepository.findByPrlkPrlKey(customerInfoBean.getRelationId());
					if(tIdRelationshipInfoLinkEntity!=null) {
						tIdRelationshipInfoLinkEntity.setPrlkToPinKey(tIdPersonalInformationEntitySearch.getPinKey());
						tIdRelationshipInfoLinkJpaRepository.save(tIdRelationshipInfoLinkEntity);
					}
				} else {
					if(customerInfoBean.getPinKey()==null && customerInfoBean.isActualCust()) {
						tIdUserMasterEntity = tIdUserMasterJpaRepository.findOne(tIdPersonalInformationEntitySearch.getProfileKey());
						if(tIdUserMasterEntity!=null) {
							tIdUserMasterEntity.setUserPinKey(tIdPersonalInformationEntitySearch.getPinKey());
							tIdUserMasterJpaRepository.save(tIdUserMasterEntity);
						}
					}
				}
			} 
			else {
				throw new HandledException("User info already available");  
			}
			
			return tIdPersonalInformationEntitySearch.getPinKey();
	}
	
	@SuppressWarnings("unused")
	public boolean userValidate(CustomerInfoBean customerInfoBean) throws HandledException {
		List<PersonIndividualExperienceViewEntity> listOfPersonIndividualExperienceViewEntity=new ArrayList<PersonIndividualExperienceViewEntity>();
		Long designKey = null, functionKey = null, roleKey = null, companyKey = null, pinKey = null;
		
		String designName =null,functionName=null,roleName=null,companyName=null;
		
		if(customerInfoBean.getPinKey()!=null) {
			pinKey = customerInfoBean.getPinKey();
		
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(pinKey);
			if(personIndividualExperienceViewEntity!=null){
				designKey = personIndividualExperienceViewEntity.getDesignationKey();
				functionKey = personIndividualExperienceViewEntity.getFunctionalAreaKey();
				roleKey = personIndividualExperienceViewEntity.getRoleKey();
				companyKey = personIndividualExperienceViewEntity.getCompanyKey();
			}
		} else {
			pinKey = 0L;
			designKey = customerInfoBean.getDesignKey();
			designName =(designKey>0)?tIdDesignationMasterJpaRepository.getDesignationName(designKey):customerInfoBean.getOtherDesignName();
			
			if(customerInfoBean.getFunctionKey()!=null) {
				functionKey = customerInfoBean.getFunctionKey();
				functionName = (functionKey>0)?tIdFunctionalAreaMasterJpaRepository.getFuctionalAreaName(functionKey):customerInfoBean.getOtherFunctionName();
			}
			
			if(customerInfoBean.getRoleKey()!=null) {
				roleKey = customerInfoBean.getRoleKey();
				roleName =(roleKey>0)?tIdReferenceCodesDetailJpaRepository.getRoleName(roleKey):customerInfoBean.getOtherRoleName();
			}
			
			companyKey = customerInfoBean.getCompanyKey();
			companyName=(companyKey>0)?tIdCompanyMasterJpaRepository.getCompanyName(companyKey):customerInfoBean.getOtherCompanyName();
			
		}
		
		/*
		 * tIdDesignationMasterJpaRepository.getDesignationName(customerInfoBean.
		 * getDesignKey()); tIdFunctionalAreaMasterJpaRepository
		 */
			/*
			design = (customerInfoBean.getDesignName()!=null)?customerInfoBean.getDesignName():customerInfoBean.getOtherDesignName();
			function = (customerInfoBean.getFunctionName()!=null)?customerInfoBean.getFunctionName():customerInfoBean.getOtherFunctionName();
			role = (customerInfoBean.getRole()!=null)?customerInfoBean.getRole():customerInfoBean.getOtherRoleName();
			company =(customerInfoBean.getCompanyName()!=null)?customerInfoBean.getCompanyName():customerInfoBean.getOtherCompanyName();
		
		*/
		if(customerInfoBean.getFirstName()!=null && !customerInfoBean.getFirstName().isEmpty()) {
			if(functionKey!=null && roleKey!=null) {
				if(functionKey!=null && roleKey!=null) {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationKeyAndFunctionalAreaKeyAndRoleKeyAndCompanyKeyAndPinKeyNotIn(
						customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designKey,functionKey,roleKey, companyKey,pinKey);
				} else if(functionKey!=null) {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationKeyAndFunctionalAreaKeyAndCompanyKeyAndPinKeyNotIn(
						customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designKey,functionKey,companyKey,pinKey);
				} else if(roleKey!=null) {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationKeyAndRoleKeyAndCompanyKeyAndPinKeyNotIn(
						customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designKey,roleKey, companyKey,pinKey);
				} else{
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationKeyAndCompanyKeyAndPinKeyNotIn(
							customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designKey,companyKey,pinKey);
				}
			}
			if(!(listOfPersonIndividualExperienceViewEntity.size()>0)) {
				if(functionName!=null && roleName!=null) {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationAndFunctionalAreaAndRoleAndCompanyAndPinKeyNotIn(
						customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designName,functionName,roleName, companyName,pinKey);
				}
				else if(functionName!=null) {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationAndFunctionalAreaAndCompanyAndPinKeyNotIn(
						customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designName,functionName,companyName,pinKey);
				} else if(roleName!=null) {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationAndRoleAndCompanyAndPinKeyNotIn(
						customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designName,roleName, companyName,pinKey);
				} else {
					listOfPersonIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findByPinFirstNameAndPinLastNameAndDesignationAndCompanyAndPinKeyNotIn(
							customerInfoBean.getFirstName(),customerInfoBean.getLastName(),designName,companyName,pinKey);
				}
			}

			if(listOfPersonIndividualExperienceViewEntity.size()>0) {
				throw new HandledException("Same User name,designation,function and company already exist::"+String.valueOf(listOfPersonIndividualExperienceViewEntity.get(0).getPinKey()+"-"+listOfPersonIndividualExperienceViewEntity.get(0).getProfileKey()));  
			}
		}
		
		return true;
	}
	
	@Override
	public AccessBlocks viewCustomerInfo(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();	
		CustomerInfoBean customerInfoBean = null;
		TIdPersonalInformationViewEntity tIdPersonalInformationViewEntity = tIdPersonalInformationViewJpaRepository.findOne(dashBoardRequest.getPinKey());
		
		//Temp fix as currentuser is posted from ui as true always
		if(tIdPersonalInformationViewEntity.getPinCreatorKey().equals(dashBoardRequest.getLoginPinKey())){
			dashBoardRequest.setCurrentUser(true);
		}else {
			dashBoardRequest.setCurrentUser(false);
		}
		
		if(tIdPersonalInformationViewEntity!=null) {
			
			customerInfoBean = new CustomerInfoBean();
			customerInfoBean.setPinKey(dashBoardRequest.getPinKey());
			customerInfoBean.setTitle(tIdPersonalInformationViewEntity.getPinTitle());
			customerInfoBean.setTitleName(tIdPersonalInformationViewEntity.getPinTitleName());
			customerInfoBean.setFirstName(tIdPersonalInformationViewEntity.getPinFirstName());
			customerInfoBean.setLastName(tIdPersonalInformationViewEntity.getPinLastName());
			customerInfoBean.setNickName(tIdPersonalInformationViewEntity.getPinNickName());
			customerInfoBean.setGender(tIdPersonalInformationViewEntity.getPinGender());
			customerInfoBean.setDob(tIdPersonalInformationViewEntity.getPinDob());
			customerInfoBean.setDoa(tIdPersonalInformationViewEntity.getPinDoa());
			customerInfoBean.setEmailId(tIdPersonalInformationViewEntity.getPinEmail());
			customerInfoBean.setNationalityKey(tIdPersonalInformationViewEntity.getPinNationalityKey());
			customerInfoBean.setNationality(tIdPersonalInformationViewEntity.getNationality());
			
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, GENDER)) {
					customerInfoBean.setGenderViewAccessFlag(false);
				}
			}
			
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, DOB)) {
					customerInfoBean.setDobViewAccessFlag(false);
				}
			}
			
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, DOA)) {
					customerInfoBean.setDoaViewAccessFlag(false);
				}
			} 
			
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), HEADER_INFO, EMAIL_ID)) {
					customerInfoBean.setEmailViewAccessFlag(false);
				}
			} 
			
			customerInfoBean.setAddress(tIdPersonalInformationViewEntity.getPinAddress());

			customerInfoBean.setCityKey(tIdPersonalInformationViewEntity.getPinCityKey());
			customerInfoBean.setCity(tIdPersonalInformationViewEntity.getCity());
			
			customerInfoBean.setStateKey(tIdPersonalInformationViewEntity.getPinStateKey());
			customerInfoBean.setState(tIdPersonalInformationViewEntity.getState());
	
			customerInfoBean.setCountryKey(tIdPersonalInformationViewEntity.getPinCountryKey());
			customerInfoBean.setCountry(tIdPersonalInformationViewEntity.getCountry());
	
			if(!dashBoardRequest.isCurrentUser()) {
				if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, NATIONALITY)) {
					customerInfoBean.setNationViewAccessFlag(false);
				}
			} 
			
			customerInfoBean.setRemarks(tIdPersonalInformationViewEntity.getPinRemarks());
			customerInfoBean.setProfileKey(tIdPersonalInformationViewEntity.getProfileKey());
			customerInfoBean.setLockKey(tIdPersonalInformationViewEntity.getLockKey());
			
			List<TIdProfileAddressDetailsViewEntity> tIdProfileAddressDetailsViewEntityList = tIdProfileAddressDetailsViewJpaRepository.findByPadPinKeyOrderByPadAddressType(customerInfoBean.getPinKey());
			if(tIdProfileAddressDetailsViewEntityList!=null && tIdProfileAddressDetailsViewEntityList.size()>0) {
				List<TIdProfileAddressDetailsView> tIdProfileAddressDetailsViewList = new ArrayList<TIdProfileAddressDetailsView>();
				TIdProfileAddressDetailsView tIdProfileAddressDetailsView2 = null;
				for(TIdProfileAddressDetailsViewEntity tIdProfileAddressDetailsViewEntity : tIdProfileAddressDetailsViewEntityList) {
					tIdProfileAddressDetailsView2 = new TIdProfileAddressDetailsView();
					tIdProfileAddressDetailsView2 = genericServiceMapper.map(tIdProfileAddressDetailsViewEntity, TIdProfileAddressDetailsView.class);
						
					if((tIdProfileAddressDetailsView2 .getAddressTypeAbbreviation().equals(HOME_ADDRESS))) {
						if(!dashBoardRequest.isCurrentUser()) {
							if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, HOME_ADDRESS)) {
								tIdProfileAddressDetailsView2.setViewAccessFlag(false);
							}
						}
						
					} else if(tIdProfileAddressDetailsView2 .getAddressTypeAbbreviation().equals(OFFICE_ADDRESS)) {
						if(!dashBoardRequest.isCurrentUser()) {
							if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, OFFICE_ADDRESS)) {
								tIdProfileAddressDetailsView2.setViewAccessFlag(false);
							}
						}
						
					} else if(tIdProfileAddressDetailsView2 .getAddressTypeAbbreviation().equals(HOMETOWN_ADDRESS)) {
						if(!dashBoardRequest.isCurrentUser()) {
							if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), PERSONAL_INFO, HOMETOWN_ADDRESS)) {
								tIdProfileAddressDetailsView2.setViewAccessFlag(false);
							}
						}
					}
					
					tIdProfileAddressDetailsViewList.add(tIdProfileAddressDetailsView2);
				}
				customerInfoBean.setListOfTIdProfileAddressDetailsView(tIdProfileAddressDetailsViewList);
			}			
			
			List<TIdCompanyContactLinkViewEntity> tIdCompanyContactLinkViewEntityList = tIdCompanyContactLinkViewJpaRepository.findByCclPinKey(dashBoardRequest.getPinKey());
			List<CustRelShipBean> custRelShipBeanList = new ArrayList<CustRelShipBean>();
			CustRelShipBean custRelShipBean = null;
			for(TIdCompanyContactLinkViewEntity tIdCompanyContactLinkViewEntity : tIdCompanyContactLinkViewEntityList){
				custRelShipBean = new CustRelShipBean();
				custRelShipBean.setPrimaryKey(tIdCompanyContactLinkViewEntity.getCclKey());
				custRelShipBean.setGroupCmKey(tIdCompanyContactLinkViewEntity.getCclCompanyKey());
				custRelShipBean.setGroupCmName(tIdCompanyContactLinkViewEntity.getCclCompanyName());
				custRelShipBean.setCorpRelationKey(tIdCompanyContactLinkViewEntity.getCclCompanyRelation());
				custRelShipBean.setCorpRelationName(tIdCompanyContactLinkViewEntity.getCclCompanyRelationValue());
				custRelShipBean.setLockKey(tIdCompanyContactLinkViewEntity.getLockKey());
				custRelShipBeanList.add(custRelShipBean);
			}
			
			List<TIdCommunicationInformationEntity> tIdCommunicationInformationEntityList = tIdCommunicationInformationJpaRepository.findByPcmPinKey(dashBoardRequest.getPinKey());
				for(TIdCommunicationInformationEntity tIdCommunicationInformationEntity : tIdCommunicationInformationEntityList) {
					if(tIdCommunicationInformationEntity.getPcmType().equals("M")) {
						customerInfoBean.setMobile(tIdCommunicationInformationEntity.getPcmDescription());
						if(!dashBoardRequest.isCurrentUser()) {
							if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), HEADER_INFO, MOBILE_NUMBER)) {
								customerInfoBean.setMobileViewAccessFlag(false);
							}
						} 
					} else if(tIdCommunicationInformationEntity.getPcmType().equals("L")) {
						customerInfoBean.setLandLine(tIdCommunicationInformationEntity.getPcmDescription());
						if(!dashBoardRequest.isCurrentUser()) {
							if(!shareInfoService.chkShareInfoDtls(dashBoardRequest.getLoginPinKey(), customerInfoBean.getPinKey(), customerInfoBean.getPinKey(), HEADER_INFO, LANDLINE_NUMBER)) {
								customerInfoBean.setLandLineViewAccessFlag(false);
							} 
						} 
					}
				}
			
			List<TIdSocialMediaInformationEntity> tIdSocialMediaInformationEntityList = tIdSocialMediaInformationJpaRepository.findByPsmPinKey(dashBoardRequest.getPinKey());
				for(TIdSocialMediaInformationEntity tIdSocialMediaInformationEntity : tIdSocialMediaInformationEntityList) {
					if(tIdSocialMediaInformationEntity.getPsmType().equals("L")) {
						customerInfoBean.setLinkedIn(tIdSocialMediaInformationEntity.getPsmId());
					} else if(tIdSocialMediaInformationEntity.getPsmType().equals("F")) {
						customerInfoBean.setFacebook(tIdSocialMediaInformationEntity.getPsmId());
					} else if(tIdSocialMediaInformationEntity.getPsmType().equals("T")) {
						customerInfoBean.setTwitter(tIdSocialMediaInformationEntity.getPsmId());
					}
				}
			
			customerInfoBean.setLanguage(tIdLanguageInformationViewJpaRepository.findByPliPinKey(dashBoardRequest.getPinKey()));
		/*	
			List<TIdLanguageInformationViewEntity> listOftIdLanguageInformationView =  tIdLanguageInformationViewJpaRepository.findByPliPinKey(dashBoardRequest.getPinKey());
			if(listOftIdLanguageInformationView!=null && listOftIdLanguageInformationView.size()>0) {
				CustLanguageBean custLanguageBean= null;
				List<CustLanguageBean> listCustLanguageBean = new ArrayList<CustLanguageBean>();
				for (TIdLanguageInformationViewEntity tIdLanguageInformationViewEntity : listOftIdLanguageInformationView) {
					custLanguageBean= new CustLanguageBean();
					custLanguageBean.setLanguageKey(tIdLanguageInformationViewEntity.getPliLanguageKey());
					custLanguageBean.setLockKey(tIdLanguageInformationViewEntity.getLockKey());
					custLanguageBean.setPrimaryKey(tIdLanguageInformationViewEntity.getPliKey());
					listCustLanguageBean.add(custLanguageBean);
				}
				customerInfoBean.setListCustLanguageBean(listCustLanguageBean);
			}
		*/
			
			List<TIdRelationshipInfoLinkViewEntity> tIdRelationshipInfoLinkViewEntityList = tIdRelationshipInfoLinkViewJpaRepository.findByPrlkToPinKey(dashBoardRequest.getPinKey());

			List<RelationShipInfoBean> relationShipInfoBeanList = new ArrayList<RelationShipInfoBean>();
			RelationShipInfoBean relationShipInfoBean = null;
			for(TIdRelationshipInfoLinkViewEntity tIdRelationshipInfoLinkViewEntity : tIdRelationshipInfoLinkViewEntityList) {
				if(tIdRelationshipInfoLinkViewEntity.getPrlkContact()==0) {
					relationShipInfoBean = new RelationShipInfoBean();
					relationShipInfoBean.setRelShip(tIdRelationshipInfoLinkViewEntity.getPrlkRelationship());
					relationShipInfoBean.setRelShipFirstName(tIdRelationshipInfoLinkViewEntity.getPinFirstName()+" " +tIdRelationshipInfoLinkViewEntity.getPinLirstName());
					relationShipInfoBean.setRelShipPinKey(tIdRelationshipInfoLinkViewEntity.getPrlkFromPinKey());
					relationShipInfoBean.setRelShipProfileKey(tIdRelationshipInfoLinkViewEntity.getProfileKey());
					relationShipInfoBeanList.add(relationShipInfoBean);
				} else {
					custRelShipBean = new CustRelShipBean();
					custRelShipBean.setPrimaryKey(tIdRelationshipInfoLinkViewEntity.getPrlkKey());
					custRelShipBean.setGroupCmKey(tIdRelationshipInfoLinkViewEntity.getPrlkFromPinKey());
					custRelShipBean.setGroupCmName(tIdRelationshipInfoLinkViewEntity.getPinFirstName()+" " +tIdRelationshipInfoLinkViewEntity.getPinLirstName());
					custRelShipBean.setCorpRelationKey(tIdRelationshipInfoLinkViewEntity.getPrlkRelationshipKey());
					custRelShipBean.setCorpRelationName(tIdRelationshipInfoLinkViewEntity.getPrlkRelationship());
					custRelShipBean.setUserPinKey(tIdRelationshipInfoLinkViewEntity.getPrlkFromPinKey());
					custRelShipBean.setLockKey(tIdRelationshipInfoLinkViewEntity.getLockKey());
					custRelShipBeanList.add(custRelShipBean);
				}
			}
			customerInfoBean.setCustRelShipBeanList(custRelShipBeanList);
			customerInfoBean.setListOfRelationship(relationShipInfoBeanList);
			accessBlocks.setCustomerInfoBean(customerInfoBean);
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity=personIndividualExperienceViewJpaRepository.findOne(tIdPersonalInformationViewEntity.getPinKey());
			if(personIndividualExperienceViewEntity.getUserKey()!=0){
				accessBlocks.setRole(EMPLOYEE);
			}else{
				accessBlocks.setRole(CONTACT);
			}
		}
		return accessBlocks;
	}

	@Override
	public  List<SelectListBean> getCustomerDtls() {
		return tIdPersonalInformationJpaRepository.getCustInfoAll();
	}

	@Override
	public boolean initialValidation(CustomerInfoBean customerInfoBean) {
		List<TIdPersonalInformationEntity> tIdPersonalInformationEntityList = null;
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		if(customerInfoBean.getFirstName()!=null && !customerInfoBean.getFirstName().isEmpty()) {
			tIdPersonalInformationEntityList = tIdPersonalInformationJpaRepository.
					findByPinFirstNameAndPinLastNameAndPinKeyNotInAndActiveStatus(customerInfoBean.getFirstName(),customerInfoBean.getLastName(), pinKey, CommonConstants.ACTIVE);
			if(tIdPersonalInformationEntityList.size()>0) {
				return false; 
			}
		} 
		return true;
	}

	@Override
	public List<PersonIndividualExperienceViewEntity> listOfDetails() {
		return (List<PersonIndividualExperienceViewEntity>) personIndividualExperienceViewJpaRepository.findAll();
	}

	@Override
	public List<PersonIndividualExperienceViewEntity> listOfExistingUser(CustomerInfoBean customerInfoBean) {
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		return personIndividualExperienceViewJpaRepository.
				findByPinFirstNameAndPinLastNameAndPinKeyNotInAndActiveStatus(customerInfoBean.getFirstName(), customerInfoBean.getLastName(), pinKey, CommonConstants.ACTIVE);
	}
	
	@Override
	public List<PersonIndividualExperienceViewEntity> listOfExisEmailUser(CustomerInfoBean customerInfoBean) {
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		List<Long> pinKeyList = new ArrayList<Long>();
		List<Long> objList =  tIdPersonalInformationJpaRepository.findByPinEmail(customerInfoBean.getEmailId(),pinKey);
		for(Object obj : objList) {
			BigInteger val =(BigInteger) obj;
			pinKeyList.add(val.longValue());
		}
		return personIndividualExperienceViewJpaRepository.findByPinKeyIn(pinKeyList);
	}
	
	@Override
	public List<PersonIndividualExperienceViewEntity> listOfExisMobileUser(CustomerInfoBean customerInfoBean) {
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		List<Long> pinKeyList = new ArrayList<Long>();
		String mobile = customerInfoBean.getMobile().replaceAll("[^+0-9,-]", "");
		List<Long> objList =   tIdPersonalInformationViewJpaRepository.findByMobile(mobile,pinKey);
		for(Object obj : objList) {
			BigInteger val =(BigInteger) obj;
			pinKeyList.add(val.longValue());
		}
		return personIndividualExperienceViewJpaRepository.findByPinKeyIn(pinKeyList);
	}

	@Override
	public List<PersonIndividualExperienceViewEntity> listOfExisLandLineUser(CustomerInfoBean customerInfoBean) {
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		List<Long> pinKeyList = new ArrayList<Long>();
		String landLine = customerInfoBean.getLandLine().replaceAll("[^+0-9,-]", "");
		List<Long> objList =   tIdPersonalInformationViewJpaRepository.findByLandLine(landLine,pinKey);
		for(Object obj : objList) {
			BigInteger val =(BigInteger) obj;
			pinKeyList.add(val.longValue());
		}
		return personIndividualExperienceViewJpaRepository.findByPinKeyIn(pinKeyList);
	}	
	
	@Override
	public String updateCreator(Long pinKey, Long creatorPinKey) {
		tIdPersonalInformationJpaRepository.updateCreatorPinKey(pinKey,creatorPinKey);
		return "Creator Updated";
	}

	@Override
	public boolean checkProfile(Long loginPinKey, Long currentPinKey) {
		TIdPersonalInformationEntity tIdPersonalInformationEntity = tIdPersonalInformationJpaRepository.findOne(currentPinKey);
		if(tIdPersonalInformationEntity.getPinCreatorKey()!=null) {
			if(loginPinKey.equals(tIdPersonalInformationEntity.getPinCreatorKey())) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * This method used for assign releaved user contact to some other user 
	 */
	
	

	@Override
	public String changeCreator(CustomerInfoBean customerInfoBean) {
		
//		myContactInfoService.saveOrUpdateMycontact(tIdMyContactsLink)
		
		
		Long creatorKey = personIndividualExperienceViewJpaRepository.getCreatorKeyByPinKey(customerInfoBean.getListOfPinKey().get(0));//here based  on one pinkey getting creator key 
		PersonIndividualExperienceViewEntity personIndividualExperienceView = personIndividualExperienceViewJpaRepository.getPersonalObjByCreatorKey(customerInfoBean.getCreatorPinKey());
		tIdPersonalInformationJpaRepository.updateProfileKeyAndCreatorKey(customerInfoBean.getListOfPinKey(),personIndividualExperienceView.getUserKey(),personIndividualExperienceView.getPinCreatorKey(),creatorKey);//here we are updating the profileKey parentKey
		tIdMyContactsLinkJpaRepository.removeMclToPinKey(customerInfoBean.getListOfPinKey());
		
		/*
		List<TIdMyContactsLinkEntity> myContacLinkList = new ArrayList<TIdMyContactsLinkEntity>();
		TIdMyContactsLinkEntity tIdMyContactsLinkEntity = null;
		for(Long toPinKey : customerInfoBean.getListOfPinKey()) {
			tIdMyContactsLinkEntity = new TIdMyContactsLinkEntity();
			tIdMyContactsLinkEntity.setMclFromPinKey(customerInfoBean.getCreatorPinKey());
			tIdMyContactsLinkEntity.setMclToPinKey(toPinKey);
			tIdMyContactsLinkEntity.setActiveStatus(CommonConstants.ACTIVE);
			tIdMyContactsLinkEntity.setMclStarRating(0L);
			tIdMyContactsLinkEntity.setLockKey(0L);
			tIdMyContactsLinkEntity.setProfileKey(1L);
			myContacLinkList.add(tIdMyContactsLinkEntity);
		}
		tIdMyContactsLinkJpaRepository.save(myContacLinkList);
		return "Creator Changed";
		*/
		TIdMyContactsLinkEntity tIdMyContactsLinkEntity = null;
		List<TIdMyContactsLinkEntity> listOfTIdMyContactsLinkEntity = new ArrayList<TIdMyContactsLinkEntity>();
		for(Long toPinKey : customerInfoBean.getListOfPinKey()) {
			PersonIndividualExperienceViewEntity personIndividualExperienceViewObj=personIndividualExperienceViewJpaRepository.findOne(toPinKey);
			
			tIdMyContactsLinkEntity = new TIdMyContactsLinkEntity();
			tIdMyContactsLinkEntity=tIdMyContactsLinkJpaRepository.findByMclFromPinKeyAndMclToPinKey(customerInfoBean.getCreatorPinKey(),toPinKey);
			if(tIdMyContactsLinkEntity==null) {
				
				tIdMyContactsLinkEntity = new TIdMyContactsLinkEntity();
				tIdMyContactsLinkEntity.setMclFromPinKey(customerInfoBean.getCreatorPinKey());//logged userPinkey
				tIdMyContactsLinkEntity.setMclToPinKey(toPinKey);//contactPinkey
				tIdMyContactsLinkEntity.setLockKey(0L);
				tIdMyContactsLinkEntity.setProfileKey(personIndividualExperienceViewObj.getProfileKey());
			}
			tIdMyContactsLinkEntity.setActiveStatus(personIndividualExperienceViewObj.getActiveStatus());
			tIdMyContactsLinkEntity.setMclStarRating(personIndividualExperienceViewObj.getStarRating()!=null?personIndividualExperienceViewObj.getStarRating():0L);
			listOfTIdMyContactsLinkEntity.add(tIdMyContactsLinkEntity);
			
			}
		tIdMyContactsLinkJpaRepository.save(listOfTIdMyContactsLinkEntity);
					
		return "Creator Changed";
		
	}

	@Override
	public boolean emailInitialVal(CustomerInfoBean customerInfoBean) {
		List<TIdPersonalInformationEntity> tIdPersonalInformationEntityList = null;
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		if(customerInfoBean.getEmailId()!=null && !customerInfoBean.getEmailId().isEmpty()) {
			tIdPersonalInformationEntityList = tIdPersonalInformationJpaRepository.findByPinKeyNotInAndPinEmail(pinKey,customerInfoBean.getEmailId());
			if(tIdPersonalInformationEntityList.size()>0) {
				return true; 
			}
		} 
		return false;
	}

	@Override
	public boolean mobileInitialVal(CustomerInfoBean customerInfoBean) {
		List<TIdPersonalInformationViewEntity> tIdPersonalInformationViewEntityList = null;
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		if(customerInfoBean.getMobile()!=null && !customerInfoBean.getMobile().isEmpty()) {
			String mobile = customerInfoBean.getMobile().replaceAll("[^+0-9,-]", "");
			tIdPersonalInformationViewEntityList = tIdPersonalInformationViewJpaRepository.findByPinKeyNotInAndMobile(pinKey,mobile);
			if(tIdPersonalInformationViewEntityList.size()>0) {
				return true; 
			}
		}
		return false;
	}

	@Override
	public boolean landlineInitialVal(CustomerInfoBean customerInfoBean) {
		List<TIdPersonalInformationViewEntity> tIdPersonalInformationViewEntityList = null;
		Long pinKey = customerInfoBean.getPinKey()!=null?customerInfoBean.getPinKey():0L;
		if(customerInfoBean.getLandLine()!=null && !customerInfoBean.getLandLine().isEmpty()) {
			String landLine = customerInfoBean.getLandLine().replaceAll("[^+0-9,-]", "");
			tIdPersonalInformationViewEntityList = tIdPersonalInformationViewJpaRepository.findByPinKeyNotInAndLandLine(pinKey,landLine);
			if(tIdPersonalInformationViewEntityList.size()>0) {
				return true; 
			}
		}
		return false;
	}

	@Override
	public List<SelectListBean> getEmployeeList(String activeStatus) {
		List<Long> pinKeyList = new ArrayList<Long>();
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = new ArrayList<PersonIndividualExperienceViewEntity>();
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		
		if(CommonConstants.INACTIVE.equals(activeStatus)) {
			pinKeyList = tIdPersonalInformationJpaRepository.findDeactiveEmployeeList("Employee", CommonConstants.INACTIVE);
			if(pinKeyList.size()>0) {
				personIndividualExperienceViewEntityList = personIndividualExperienceViewJpaRepository.findByPinKeyInOrderByPinFirstName(pinKeyList);
			}
		} else {
			personIndividualExperienceViewEntityList = personIndividualExperienceViewJpaRepository.findByUserKeyIsNotOrderByPinFirstName(0L);
		}
		
		if(personIndividualExperienceViewEntityList.size()>0) {
			SelectListBean selectListBean = null;
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
		}
		return selectListBeanList;
	}

	
	@Override
	public List<SelectListBean> getContactsList(Long pinCreatorKey) {
	
		/*
		 * Here we are excluding the shadow contacts from MyContacts (we are calling from Admin)
		 */
		List<Long> shadowContactsKeys = tIdRelationshipInfoLinkJpaRepository.getPrlkToPinKey(pinCreatorKey);
		if(shadowContactsKeys.size()>0) {
			return tIdPersonalInformationJpaRepository.getContactsList(pinCreatorKey,shadowContactsKeys);
		}
		else {
			return tIdPersonalInformationJpaRepository.getContactsList1(pinCreatorKey);
		}
	}

	@Override
	public Long saveNameDtls(CustomerInfoBean customerInfoBean) throws Exception {
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdReferenceCodesHeaderEntity tIdReferenceCodesHeader=null;
		TIdReferenceCodesDetailEntity  tIdReferenceCodesDetailEntity = null;
		
		if(userValidate(customerInfoBean)) {
			
			if(customerInfoBean.getOtherTitleName()!=null)
			{
				if(customerInfoBean.getTitle()!=null && customerInfoBean.getTitle()!=0) {
					tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Title");
					tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValueAndRcdDetailKeyNotIn(tIdReferenceCodesHeader.getRchHeaderKey(), customerInfoBean.getOtherTitleName(), customerInfoBean.getTitle());
			        if(tIdReferenceCodesDetailEntity!=null) {
			        	if(tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS) ||tIdReferenceCodesDetailEntity.getActiveStatus().equals(PENDING_STATUS)){
			        		tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
			        		tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
			        		customerInfoBean.setTitle(tIdReferenceCodesDetailEntity.getRcdDetailKey());
			        		customerInfoBean.setOtherTitleName(null);
			        	} else {
			        		throw new DataIntegrityViolationException("Title name already exist!!!");
			        	}
					} else {
						tIdReferenceCodesDetailEntity = tIdReferenceCodesDetailJpaRepository.findOne(customerInfoBean.getTitle());
						tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
		        		tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
						tIdReferenceCodesDetailEntity.setRcdValue(customerInfoBean.getOtherTitleName());
						tIdReferenceCodesDetailEntity.setRcdAbbreviation(customerInfoBean.getOtherTitleName());
						tIdReferenceCodesDetailEntity.setRcdMeaning(customerInfoBean.getOtherTitleName());
						tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
						customerInfoBean.setOtherTitleName(null);
					}
				} else {
						tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Title");
						tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(), customerInfoBean.getOtherTitleName());
						if(tIdReferenceCodesDetailEntity!=null){
								if(tIdReferenceCodesDetailEntity.getActiveStatus().equalsIgnoreCase(PENDING_STATUS) || tIdReferenceCodesDetailEntity.getActiveStatus().equals(DELETE_STATUS) 
										|| tIdReferenceCodesDetailEntity.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
									tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
					        		tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
									customerInfoBean.setTitle(tIdReferenceCodesDetailEntity.getRcdDetailKey());
					        		customerInfoBean.setOtherTitleName(null);
								} else {
									throw new HandledException("Title name already exist!!!");
								}

								
							}
					}
			}
			
			tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
			
			if(customerInfoBean.getOtherTitleName()!=null)
			{
				tIdReferenceCodesDetailEntity = new TIdReferenceCodesDetailEntity();
				tIdReferenceCodesDetailEntity.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
				tIdReferenceCodesDetailEntity.setRcdAbbreviation(customerInfoBean.getOtherTitleName());
				tIdReferenceCodesDetailEntity.setRcdValue(customerInfoBean.getOtherTitleName());
				tIdReferenceCodesDetailEntity.setRcdMeaning(customerInfoBean.getOtherTitleName());
				tIdReferenceCodesDetailEntity.setRcdLowRange(0L);
				tIdReferenceCodesDetailEntity.setRcdHighRange(0L);
				tIdReferenceCodesDetailEntity.setRcdOrderBy(0L);
				tIdReferenceCodesDetailEntity.setActiveStatus(PENDING_STATUS);
				tIdReferenceCodesDetailEntity.setRcdSetAsDefault("N");
				tIdReferenceCodesDetailEntity.setProfileKey(1L);
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetailEntity);
				tIdPersonalInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetailEntity);
			
			} else {
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findOne(customerInfoBean.getTitle());
				tIdPersonalInformationEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetailEntity);
			}
			
			tIdPersonalInformationEntitySearch.setPinFirstName(customerInfoBean.getFirstName());
			tIdPersonalInformationEntitySearch.setPinLastName(customerInfoBean.getLastName());
			if(customerInfoBean.getNickName()!=null) {
				tIdPersonalInformationEntitySearch.setPinNickName(customerInfoBean.getNickName());
			}
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		}
		if(customerInfoBean.getPinKey()!=null && customerInfoBean.getFromPinKey()!=null) {
			tIdRelationshipInfoLinkJpaRepository.updateRelationShip(customerInfoBean.getFromPinKey(),customerInfoBean.getPinKey(),customerInfoBean.getRelationship());
		}
		return tIdPersonalInformationEntitySearch.getPinKey();
	}

	@Override
	public Long saveRelationShipDtls(CustomerInfoBean customerInfoBean) {
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdCompanyContactLinkEntitySearch tIdCompanyContactLinkEntitySearch =null;
		List<TIdCompanyContactLinkEntitySearch> tIdCompanyContactLinkEntitySearchList = new ArrayList<TIdCompanyContactLinkEntitySearch>();
		TIdRelationshipInformationEntity tIdRelationshipInformationEntity = null;
		tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
		List<Long> primaryKeys = tIdCompanyContactLinkJpaRepository.getListOfCclKeysByUserKey(customerInfoBean.getPinKey());//customerInfoBean.getPinKey()
		if(primaryKeys!=null && primaryKeys.size()>0) {
			List<Long> uiPrimaryKey = new ArrayList<Long>();
			if(customerInfoBean.getCustRelShipBeanList()!=null && customerInfoBean.getCustRelShipBeanList().size()>0) {
				for(CustRelShipBean custRelShipBean : customerInfoBean.getCustRelShipBeanList()) {
					if(custRelShipBean.getPrimaryKey()!=null)
						uiPrimaryKey.add(custRelShipBean.getPrimaryKey());
				}
			}
			if(uiPrimaryKey.isEmpty()) {
				uiPrimaryKey.add(0l);
			}
				primaryKeys.retainAll(uiPrimaryKey);
				if(primaryKeys.isEmpty()) {
					tIdCompanyContactLinkJpaRepository.deleteUserKey(customerInfoBean.getPinKey());
				}
				else {
					tIdCompanyContactLinkJpaRepository.deleteByPrimaryKeys(primaryKeys,customerInfoBean.getPinKey());
				}
		}
		
		primaryKeys = tIdRelationshipInfoLinkJpaRepository.getListOfPrlkKeyByUserKey(customerInfoBean.getPinKey(),1L);//customerInfoBean.getPinKey()
		if(primaryKeys!=null && primaryKeys.size()>0) {
			List<Long> uiPrimaryKey = new ArrayList<Long>();
			if(customerInfoBean.getCustRelShipBeanList()!=null && customerInfoBean.getCustRelShipBeanList().size()>0) {
				for(CustRelShipBean custRelShipBean : customerInfoBean.getCustRelShipBeanList()) {
					if(custRelShipBean.getPrimaryKey()!=null)
					uiPrimaryKey.add(custRelShipBean.getPrimaryKey());
				}
			}
			if(uiPrimaryKey.isEmpty()) {
				uiPrimaryKey.add(0l);
			}
			List<Long> prlPrlKey = null;
				primaryKeys.retainAll(uiPrimaryKey);
				if(primaryKeys.isEmpty()) {
					prlPrlKey = tIdRelationshipInfoLinkJpaRepository.findprlkPrlKey(customerInfoBean.getPinKey(),1L);
					tIdRelationshipInfoLinkJpaRepository.deleteUserKey(customerInfoBean.getPinKey(),1L);
				}
				else {
					prlPrlKey = tIdRelationshipInfoLinkJpaRepository.findPrlkPrlKeyList(primaryKeys,customerInfoBean.getPinKey(),1L);
					tIdRelationshipInfoLinkJpaRepository.deleteByPrimaryKeys(primaryKeys,customerInfoBean.getPinKey(),1L);
				}
				if(prlPrlKey.size()>0) {
					tIdRelationshipInformationJpaRepository.deleteUserKey(prlPrlKey);
				}
		}
		
		if(customerInfoBean.getCustRelShipBeanList()!=null) {
			for(CustRelShipBean custRelShipBean : customerInfoBean.getCustRelShipBeanList()) {
				if(custRelShipBean.getUserPinKey()==null) {
					tIdCompanyContactLinkEntitySearch = new TIdCompanyContactLinkEntitySearch();
					tIdCompanyContactLinkEntitySearch.setCclKey(custRelShipBean.getPrimaryKey());
					tIdCompanyContactLinkEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdCompanyContactLinkEntitySearch.setTIdReferenceCodesDetail(tIdReferenceCodesDetailJpaRepository.findOne(custRelShipBean.getCorpRelationKey()));
					tIdCompanyContactLinkEntitySearch.setTIdCompanyMaster(tIdCompanyMasterEntitySearchJpaRepository.findOne(custRelShipBean.getGroupCmKey()));
					tIdCompanyContactLinkEntitySearch.setActiveStatus(ACTIVESTATUS); 
					tIdCompanyContactLinkEntitySearch.setLockKey(custRelShipBean.getLockKey());
					tIdCompanyContactLinkEntitySearch.setProfileKey(customerInfoBean.getProfileKey()); 
					tIdCompanyContactLinkEntitySearchList.add(tIdCompanyContactLinkEntitySearch);
				}
			}
		}
		tIdPersonalInformationEntitySearch.setListOfTIdCompanyContactLink(tIdCompanyContactLinkEntitySearchList);
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		//Add the relationship
		if(customerInfoBean.getCustRelShipBeanList()!=null) {
			for(CustRelShipBean custRelShipBean : customerInfoBean.getCustRelShipBeanList()) {
				if(custRelShipBean.getUserPinKey()!=null) {
					tIdRelationshipInformationEntity = new TIdRelationshipInformationEntity();
					tIdRelationshipInformationEntity.setPrlPinKey(custRelShipBean.getUserPinKey());
					tIdRelationshipInformationEntity.setPrlTitle(tIdPersonalInformationEntitySearch.gettIdReferenceCodesDetail().getRcdDetailKey());
					tIdRelationshipInformationEntity.setPrlFirstName(customerInfoBean.getFirstName());
					tIdRelationshipInformationEntity.setPrlLastName(customerInfoBean.getLastName());
					tIdRelationshipInformationEntity.setActiveStatus(ACTIVESTATUS);
					tIdRelationshipInformationEntity.setLockKey(custRelShipBean.getLockKey());
					tIdRelationshipInformationEntity.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					
					tIdRelationshipInformationEntity = tIdRelationshipInformationJpaRepository.save(tIdRelationshipInformationEntity);
					TIdRelationshipInfoLinkEntity tIdRelationshipInfoLinkEntity = new TIdRelationshipInfoLinkEntity();
					tIdRelationshipInfoLinkEntity.setPrlkKey(custRelShipBean.getPrimaryKey());
					tIdRelationshipInfoLinkEntity.setPrlkPrlKey(tIdRelationshipInformationEntity.getPrlKey());
					tIdRelationshipInfoLinkEntity.setPrlkRelationType(custRelShipBean.getCorpRelationName());
					tIdRelationshipInfoLinkEntity.setPrlkRelationship(custRelShipBean.getCorpRelationName());
					tIdRelationshipInfoLinkEntity.setPrlkRelationshipKey(custRelShipBean.getCorpRelationKey());
					tIdRelationshipInfoLinkEntity.setPrlkFromPinKey(custRelShipBean.getUserPinKey());
					tIdRelationshipInfoLinkEntity.setPrlkToPinKey(tIdPersonalInformationEntitySearch.getPinKey());
					tIdRelationshipInfoLinkEntity.setPrlkContact(1L);
					tIdRelationshipInfoLinkEntity.setActiveStatus(ACTIVESTATUS);
					tIdRelationshipInfoLinkEntity.setLockKey(custRelShipBean.getLockKey());
					tIdRelationshipInfoLinkEntity.setProfileKey(tIdPersonalInformationEntitySearch.getProfileKey());
					tIdRelationshipInfoLinkJpaRepository.save(tIdRelationshipInfoLinkEntity);
				}
			}
		}
			
		return tIdPersonalInformationEntitySearch.getPinKey();
	}
	@Override
	public Long saveLanguageDtls(CustomerInfoBean customerInfoBean) throws Exception {
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdLanguageMasterEntitySearch tIdLanguageMasterEntitySearch=null;
		List<TIdLanguageInformationEntitySearch> tIdLanguageInformationEntitySearchList = new ArrayList<TIdLanguageInformationEntitySearch>();
		TIdLanguageInformationEntitySearch tIdLanguageInformationEntitySearch = null;
		
		if(customerInfoBean.getOtherLanguage()!=null) {
			tIdLanguageMasterEntitySearch=tIdLanguageMasterSearchJpaRepository.findByName(customerInfoBean.getOtherLanguage());
			if(tIdLanguageMasterEntitySearch!=null) {
				if(tIdLanguageMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS) ||tIdLanguageMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS) 
						||tIdLanguageMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)){
					tIdLanguageMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdLanguageMasterSearchJpaRepository.save(tIdLanguageMasterEntitySearch);
					List<TIdLanguageInformationViewEntity> languageEntityList = new ArrayList<TIdLanguageInformationViewEntity>();
					TIdLanguageInformationViewEntity languageEntity = new TIdLanguageInformationViewEntity();
					languageEntity.setPliLanguageKey(tIdLanguageMasterEntitySearch.getKey());
					languageEntityList.add(languageEntity);
					customerInfoBean.setLanguage(languageEntityList);
					customerInfoBean.setOtherLanguage(null);
				} else {
							throw new HandledException("Language already exist!!!");
				}
			}
		}
		
		tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
		
//		List<TIdLanguageInformationEntity> languageIngoList = tIdLanguageInformationJpaRepository.findByPliPinKey(customerInfoBean.getPinKey());
		
		List<Long> primaryKeys = tIdLanguageInformationJpaRepository.getListOfPrimaryKeysByPinKey(customerInfoBean.getPinKey());
		
		if(primaryKeys!=null && primaryKeys.size()>0) {
			List<Long> uiPrimaryKey = new ArrayList<Long>();
			if(customerInfoBean.getLanguage()!=null && customerInfoBean.getLanguage().size()>0) {
				for(TIdLanguageInformationViewEntity tIdLanguageInformationViewEntity : customerInfoBean.getLanguage()) {
					if(tIdLanguageInformationViewEntity.getPliKey()!=null)
						uiPrimaryKey.add(tIdLanguageInformationViewEntity.getPliKey());
				}
			}
			if(uiPrimaryKey.isEmpty()) {
				uiPrimaryKey.add(0l);
			}
				primaryKeys.retainAll(uiPrimaryKey);
				if(primaryKeys.isEmpty()) {
					tIdLanguageInformationJpaRepository.deleteByUserKey(customerInfoBean.getPinKey());
				}
				else {
					tIdLanguageInformationJpaRepository.deleteByPrimaryKeys(primaryKeys,customerInfoBean.getPinKey());
				}
		}
		
		/*
		  if(languageIngoList.size()>0) {
		  	tIdLanguageInformationJpaRepository.delete(languageIngoList); 
		  }
		 */
		
		if(customerInfoBean.getOtherLanguage()!=null) { // Other language save in language master table
			tIdLanguageMasterEntitySearch = new TIdLanguageMasterEntitySearch();
			tIdLanguageMasterEntitySearch.setName(customerInfoBean.getOtherLanguage());
			tIdLanguageMasterEntitySearch.setActiveFrom(new Date());
			tIdLanguageMasterEntitySearch.setActiveStatus(PENDING_STATUS);
			tIdLanguageMasterEntitySearch.setLockKey(0L);
			tIdLanguageMasterEntitySearch.setProfileKey(1L);
			tIdLanguageMasterEntitySearch = tIdLanguageMasterSearchJpaRepository.save(tIdLanguageMasterEntitySearch);
			
			//language information save
			tIdLanguageInformationEntitySearch = new TIdLanguageInformationEntitySearch();
			tIdLanguageInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdLanguageInformationEntitySearch.setTIdLanguageMaster(tIdLanguageMasterEntitySearch);
			tIdLanguageInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdLanguageInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
			tIdLanguageInformationEntitySearchList.add(tIdLanguageInformationEntitySearch);
		}
		/*
		if(customerInfoBean.getListCustLanguageBean()!=null && customerInfoBean.getListCustLanguageBean().size()>0) {
			for(CustLanguageBean custLanguageBean : customerInfoBean.getListCustLanguageBean()) {
				if(custLanguageBean.getPrimaryKey()==null) {
					tIdLanguageInformationEntitySearch = new TIdLanguageInformationEntitySearch();
					tIdLanguageInformationEntitySearch.setPliKey(custLanguageBean.getPrimaryKey());
					tIdLanguageInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdLanguageInformationEntitySearch.setTIdLanguageMaster(tIdLanguageMasterSearchJpaRepository.findOne(custLanguageBean.getLanguageKey()));
					tIdLanguageInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdLanguageInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdLanguageInformationEntitySearch.setLockKey(custLanguageBean.getLockKey());
					tIdLanguageInformationEntitySearchList.add(tIdLanguageInformationEntitySearch);
				}
			}
		}
		*/
		if(customerInfoBean.getLanguage()!=null && customerInfoBean.getLanguage().size()>0) {
			for(TIdLanguageInformationViewEntity tIdLanguageInformationViewEntity : customerInfoBean.getLanguage()) {
				if(tIdLanguageInformationViewEntity.getPliKey()==null) {
					tIdLanguageInformationEntitySearch = new TIdLanguageInformationEntitySearch();
					tIdLanguageInformationEntitySearch.setPliKey(tIdLanguageInformationViewEntity.getPliKey());
					tIdLanguageInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
					tIdLanguageInformationEntitySearch.setTIdLanguageMaster(tIdLanguageMasterSearchJpaRepository.findOne(tIdLanguageInformationViewEntity.getPliLanguageKey()));
					tIdLanguageInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
					tIdLanguageInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
					tIdLanguageInformationEntitySearch.setLockKey(tIdLanguageInformationViewEntity.getLockKey());
					tIdLanguageInformationEntitySearchList.add(tIdLanguageInformationEntitySearch);
				}
			}
		}
		tIdPersonalInformationEntitySearch.setListOfTIdLanguageInformation(tIdLanguageInformationEntitySearchList);
		
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		return tIdPersonalInformationEntitySearch.getPinKey();
	}

	@Override
	public Long saveEmailDtls(CustomerInfoBean customerInfoBean) {
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
		tIdPersonalInformationEntitySearch.setPinEmail(customerInfoBean.getEmailId());
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		return tIdPersonalInformationEntitySearch.getPinKey();
	}

	@Override
	public Long savePhoneNoDtls(CustomerInfoBean customerInfoBean) {
		TIdCommunicationInformationEntitySearch tIdCommunicationInformationEntitySearch = null;
		List<TIdCommunicationInformationEntitySearch> tIdCommunicationInformationEntitySearchList = new ArrayList<TIdCommunicationInformationEntitySearch>();
		
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
		
		List<TIdCommunicationInformationEntity> communicationList = tIdCommunicationInformationJpaRepository.findByPcmPinKey(customerInfoBean.getPinKey());  
		if(communicationList.size()>0) {
			tIdCommunicationInformationJpaRepository.delete(communicationList);
		}
		
		if(customerInfoBean.getMobile()!=null && !"".equals(customerInfoBean.getMobile())) {
			tIdCommunicationInformationEntitySearch = new TIdCommunicationInformationEntitySearch();
			tIdCommunicationInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdCommunicationInformationEntitySearch.setPcmType("M");
			tIdCommunicationInformationEntitySearch.setPcmDescription(customerInfoBean.getMobile().replace(" ", ""));
			tIdCommunicationInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdCommunicationInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
			tIdCommunicationInformationEntitySearchList.add(tIdCommunicationInformationEntitySearch);
		}
		if(customerInfoBean.getLandLine()!=null && !"".equals(customerInfoBean.getLandLine())) {
			tIdCommunicationInformationEntitySearch = new TIdCommunicationInformationEntitySearch();
			tIdCommunicationInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdCommunicationInformationEntitySearch.setPcmType("L");
			tIdCommunicationInformationEntitySearch.setPcmDescription(customerInfoBean.getLandLine().replace(" ", ""));
			tIdCommunicationInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdCommunicationInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
			tIdCommunicationInformationEntitySearchList.add(tIdCommunicationInformationEntitySearch);
		}
		tIdPersonalInformationEntitySearch.setListOfTIdCommunicationInformation(tIdCommunicationInformationEntitySearchList);
		
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		return tIdPersonalInformationEntitySearch.getPinKey();
	}

	@Override
	public Long savePersonalDtls(CustomerInfoBean customerInfoBean) throws Exception {
		TIdSocialMediaInformationEntitySearch tIdSocialMediaInformationEntitySearch = null;
		TIdReferenceCodesDetailEntity tIdReferenceCodesDetailEntity=null;
		TIdCityMasterEntitySearch tIdCityMasterEntitySearch=null;
		TIdCountryMasterEntitySearch tIdCountryMasterEntitySearch=null;
		TIdStateMasterEntitySearch tIdStateMasterEntitySearch=null;
		List<TIdSocialMediaInformationEntitySearch> tIdSocialMediaInformationEntitySearchList =   new ArrayList<TIdSocialMediaInformationEntitySearch>();
		List<TIdProfileAddressDetailsEntitySearch> tIdProfileAddressDetailsEntitySearchList = new ArrayList<TIdProfileAddressDetailsEntitySearch>(); 
		List<TIdCityMasterEntitySearch> tIdCityMasterEntitySearchList=null;
		List<TIdStateMasterEntitySearch> tIdStateMasterEntitySearchList=null;
		TIdProfileAddressDetailsEntitySearch tIdProfileAddressDetailsEntitySearch = null;
		String dobStr=null;
		
		if(customerInfoBean.getListOfTIdProfileAddressDetailsView()!=null && customerInfoBean.getListOfTIdProfileAddressDetailsView().size()>0) {
			for(TIdProfileAddressDetailsView tIdProfileAddressDetailsView : customerInfoBean.getListOfTIdProfileAddressDetailsView()) {
				if(tIdProfileAddressDetailsView.getPadOtherCityName()!=null){
					tIdCityMasterEntitySearchList=tIdCityMasterEntitySearchJpaRepository.findByName(tIdProfileAddressDetailsView.getPadOtherCityName());
					if(tIdCityMasterEntitySearchList!=null && tIdCityMasterEntitySearchList.size()>0){
						if(tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdCityMasterEntitySearchList.get(0).getActiveStatus().equals(PENDING_STATUS)){
							tIdCityMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
							tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearchList);
							tIdProfileAddressDetailsView.setPadCityKey(tIdCityMasterEntitySearchList.get(0).getKey());
							tIdProfileAddressDetailsView.setPadOtherCityName(null);
						} else {
							throw new HandledException("City name already exist!!!");
						}
					}
				}
				if(tIdProfileAddressDetailsView.getPadOtherStateName()!=null) {
					tIdStateMasterEntitySearchList = tIdStateMasterSearchJpaRepository.findByName(tIdProfileAddressDetailsView.getPadOtherStateName());
					if(tIdStateMasterEntitySearchList.size()>0) {
						if(tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(DELETE_STATUS) ||tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(IN_ACTIVE_STATUS) 
								||tIdStateMasterEntitySearchList.get(0).getActiveStatus().equals(PENDING_STATUS)){
							tIdStateMasterEntitySearchList.get(0).setActiveStatus(PENDING_STATUS);
							tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearchList);
							tIdProfileAddressDetailsView.setPadStateKey(tIdStateMasterEntitySearchList.get(0).getKey());
							tIdProfileAddressDetailsView.setPadOtherStateName(null);
						} else {
							throw new HandledException("State name already exist!!!");
						}
					}
				}
			}
		}
		
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch =  tIdPersonalInformationEntitySearchJpaRepository.findOne(customerInfoBean.getPinKey());
		
		List<TIdProfileAddressDetailsEntity> profileAddDetailsList = tIdProfileAddressDetailsJpaRepository.findByPadPinKey(customerInfoBean.getPinKey());
		if(profileAddDetailsList.size()>0) {
			tIdProfileAddressDetailsJpaRepository.delete(profileAddDetailsList);
		}
		
		List<TIdSocialMediaInformationEntity> socialMediaInfoList = tIdSocialMediaInformationJpaRepository.findByPsmPinKey(customerInfoBean.getPinKey());
		if(socialMediaInfoList.size()>0) {
			tIdSocialMediaInformationJpaRepository.delete(socialMediaInfoList);
		}
		
		tIdPersonalInformationEntitySearch.setPinGender(customerInfoBean.getGender());		
		if(customerInfoBean.getNationalityKey()!=null) {
			TIdNationalityMasterEntitySearch tIdNationalityMasterEntitySearch=tIdNationalityMasterEntitySearchJpaRepository.findOne(customerInfoBean.getNationalityKey());
			tIdPersonalInformationEntitySearch.settIdNationalityMasterSearch(tIdNationalityMasterEntitySearch);
		}
		tIdPersonalInformationEntitySearch.setPinDob(customerInfoBean.getDob());
		if(customerInfoBean.getDob()!=null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 try{
				  dobStr=formatter.format(customerInfoBean.getDob());
			 } catch(Exception e) {
				 	logger.error("opps! error occured in savePersonalDtls method while converting date formate");
		            e.printStackTrace();
			 }
		}	 
		tIdPersonalInformationEntitySearch.setPinDobStr(dobStr);
		tIdPersonalInformationEntitySearch.setPinDoa(customerInfoBean.getDoa());		

		if(customerInfoBean.getLinkedIn()!=null) {
			tIdSocialMediaInformationEntitySearch = new TIdSocialMediaInformationEntitySearch();
			tIdSocialMediaInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdSocialMediaInformationEntitySearch.setPsmType("L");
			tIdSocialMediaInformationEntitySearch.setPsmId(customerInfoBean.getLinkedIn());
			tIdSocialMediaInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
			tIdSocialMediaInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdSocialMediaInformationEntitySearchList.add(tIdSocialMediaInformationEntitySearch);
		}
		if(customerInfoBean.getFacebook()!=null) {
			tIdSocialMediaInformationEntitySearch = new TIdSocialMediaInformationEntitySearch();
			tIdSocialMediaInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdSocialMediaInformationEntitySearch.setPsmType("F");
			tIdSocialMediaInformationEntitySearch.setPsmId(customerInfoBean.getFacebook());
			tIdSocialMediaInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
			tIdSocialMediaInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdSocialMediaInformationEntitySearchList.add(tIdSocialMediaInformationEntitySearch);
		}
		if(customerInfoBean.getTwitter()!=null) {
			tIdSocialMediaInformationEntitySearch = new TIdSocialMediaInformationEntitySearch();
			tIdSocialMediaInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdSocialMediaInformationEntitySearch.setPsmType("T");
			tIdSocialMediaInformationEntitySearch.setPsmId(customerInfoBean.getTwitter());
			tIdSocialMediaInformationEntitySearch.setProfileKey(customerInfoBean.getProfileKey());
			tIdSocialMediaInformationEntitySearch.setActiveStatus(ACTIVESTATUS);
			tIdSocialMediaInformationEntitySearchList.add(tIdSocialMediaInformationEntitySearch);
		}
		tIdPersonalInformationEntitySearch.setListOfTIdSocialMediaInformation(tIdSocialMediaInformationEntitySearchList);
		
		if(customerInfoBean.getListOfTIdProfileAddressDetailsView()!=null && customerInfoBean.getListOfTIdProfileAddressDetailsView().size()>0) {
			
			for(TIdProfileAddressDetailsView tIdProfileAddressDetailsView : customerInfoBean.getListOfTIdProfileAddressDetailsView()) {
				tIdProfileAddressDetailsEntitySearch = new TIdProfileAddressDetailsEntitySearch();
				
				tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findOne(tIdProfileAddressDetailsView.getPadAddressType());
				tIdProfileAddressDetailsEntitySearch.settIdReferenceCodesDetail(tIdReferenceCodesDetailEntity);
				tIdProfileAddressDetailsEntitySearch.setPadPinzip(tIdProfileAddressDetailsView.getPadPinzip());
				
				if(tIdProfileAddressDetailsView.getPadCountryKey()!=null) {
					tIdCountryMasterEntitySearch=tIdCountryMasterEntitySearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadCountryKey());
					tIdProfileAddressDetailsEntitySearch.settIdCountryMasterSearch(tIdCountryMasterEntitySearch);
				}
				
				if(tIdProfileAddressDetailsView.getPadOtherStateName()!=null) {
					tIdStateMasterEntitySearch = new TIdStateMasterEntitySearch();
					tIdStateMasterEntitySearch.setName(tIdProfileAddressDetailsView.getPadOtherStateName());
					tIdStateMasterEntitySearch.setStateAbbreviation(tIdProfileAddressDetailsView.getPadOtherStateName());
					tIdStateMasterEntitySearch.setStateCountryKey(tIdProfileAddressDetailsView.getPadCountryKey());
					tIdStateMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdStateMasterEntitySearch.setActiveFrom(new Date());
					tIdStateMasterEntitySearch.setLockKey(0L);
					tIdStateMasterEntitySearch.setProfileKey(1l);
					tIdStateMasterEntitySearch = tIdStateMasterSearchJpaRepository.save(tIdStateMasterEntitySearch);
					tIdProfileAddressDetailsEntitySearch.settIdStateMasterSearch(tIdStateMasterEntitySearch);

				} else if(tIdProfileAddressDetailsView.getPadStateKey()!=null) {
					tIdStateMasterEntitySearch=tIdStateMasterSearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadStateKey());
					tIdProfileAddressDetailsEntitySearch.settIdStateMasterSearch(tIdStateMasterEntitySearch);
				}
				
				if(tIdProfileAddressDetailsView.getPadOtherCityName()!=null){
					tIdCityMasterEntitySearch=new TIdCityMasterEntitySearch();
					tIdCityMasterEntitySearch.setActiveFrom(new Date());
					tIdCityMasterEntitySearch.setName(tIdProfileAddressDetailsView.getPadOtherCityName());
					tIdCityMasterEntitySearch.setActiveStatus(PENDING_STATUS);
					tIdCityMasterEntitySearch.setLockKey(0L);
					tIdCityMasterEntitySearch.setProfileKey(1l);
					tIdCityMasterEntitySearch.setTIdCountryMasterSearch(tIdCountryMasterEntitySearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadCountryKey()));
					tIdCityMasterEntitySearch=tIdCityMasterEntitySearchJpaRepository.save(tIdCityMasterEntitySearch);
					tIdProfileAddressDetailsEntitySearch.settIdCityMasterSearch(tIdCityMasterEntitySearch);
					
				} else if(tIdProfileAddressDetailsView.getPadCityKey()!=null) {
					tIdProfileAddressDetailsEntitySearch.settIdCityMasterSearch(tIdCityMasterEntitySearchJpaRepository.findOne(tIdProfileAddressDetailsView.getPadCityKey()));
				}
				
				tIdProfileAddressDetailsEntitySearch.setPadAddressLine1(tIdProfileAddressDetailsView.getPadAddressLine1());
				tIdProfileAddressDetailsEntitySearch.setPadAddressLine2(tIdProfileAddressDetailsView.getPadAddressLine2());
				tIdProfileAddressDetailsEntitySearch.setProfileKey(tIdProfileAddressDetailsView.getProfileKey());
				tIdProfileAddressDetailsEntitySearch.setActiveStatus(tIdProfileAddressDetailsView.getActiveStatus());
				tIdProfileAddressDetailsEntitySearch.setLockKey(tIdProfileAddressDetailsView.getLockKey());
				tIdProfileAddressDetailsEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
				tIdProfileAddressDetailsEntitySearchList.add(tIdProfileAddressDetailsEntitySearch);
			}
			
			tIdPersonalInformationEntitySearch.setListOfTIdProfileAddressDetails(tIdProfileAddressDetailsEntitySearchList);
		}
		
		tIdPersonalInformationEntitySearch.setPinRemarks(customerInfoBean.getRemarks());
		
		tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		return tIdPersonalInformationEntitySearch.getPinKey();
	}
	
}
