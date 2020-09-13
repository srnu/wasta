package com.id.wasta.bootstrap;

import static com.id.util.CommonConstants.BEAN_PCKG;
import static com.id.util.CommonConstants.ENTITY_PCKG;
import static com.id.util.CommonConstants.ENTITY_SUFFIX;
import static com.id.util.CommonConstants.REPO_PCKG;
import static com.id.util.CommonConstants.resourceEntityMap;
import static com.id.util.CommonConstants.resourceSelectListMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
@Component
public class AppLoader  {

	@PostConstruct
	public void initValues() {
		// TODO Auto-generated method stub
		ENTITY_PCKG="com.id.wasta.bean.jpa";
		REPO_PCKG="com.id.wasta.data.repository.jpa";
		BEAN_PCKG="com.id.wasta.bean";
		ENTITY_SUFFIX="Entity";
		configureCrudResources();
		configureSelectLists();
	}
	
	private void configureCrudResources(){
		resourceEntityMap.put("addnlInfo","TIdAdditionalInformationEntity");
		resourceEntityMap.put("awardsInfo","TIdAwardsInformationEntity");
		resourceEntityMap.put("awardsInfoView","TIdAwardsInformationViewEntity");
		resourceEntityMap.put("bizType","TIdBusinessTypeMasterEntity");
		resourceEntityMap.put("city","TIdCityMasterEntity");
		resourceEntityMap.put("cityView","TIdCityMasterViewEntity");
		resourceEntityMap.put("communicationInfo","TIdCommunicationInformationEntity");
		resourceEntityMap.put("companycontact","TIdCompanyContactLinkEntity");
		resourceEntityMap.put("company","TIdCompanyMasterEntity");
		resourceEntityMap.put("companyView","TIdCompanyMasterViewEntity");
		resourceEntityMap.put("country","TIdCountryMasterEntity");
		resourceEntityMap.put("designation","TIdDesignationMasterEntity");
		resourceEntityMap.put("dynamicDefn","TIdDynamicDefinitionEntity");
		resourceEntityMap.put("educationInfo","TIdEducationalInformationEntity");
		resourceEntityMap.put("institute","TIdEducationalInstitutesEntity");
		resourceEntityMap.put("instituteView","TIdEducationalInstitutesViewEntity");
		resourceEntityMap.put("experienceInfo","TIdExperienceInformationEntity");
		resourceEntityMap.put("functionalArea","TIdFunctionalAreaMasterEntity");
		resourceEntityMap.put("languageInfo","TIdLanguageInformationEntity");
		resourceEntityMap.put("languageMaster","TIdLanguageMasterEntity");
		resourceEntityMap.put("miscInfo","TIdMiscInformationEntity");
		resourceEntityMap.put("nationalityMaster","TIdNationalityMasterEntity");
		resourceEntityMap.put("personalInfo","TIdPersonalInformationEntity");
		resourceEntityMap.put("productAttachment","TIdProductAttachmentEntity");
		resourceEntityMap.put("professionalExpertise","TIdProfessionalExpertiseEntity");
		resourceEntityMap.put("profileHeirarchyDetail","TIdProfileHierarchyDetailEntity");
		resourceEntityMap.put("profileHeirarchyHeader","TIdProfileHierarchyHeaderEntity");
		resourceEntityMap.put("projectsInfo","TIdProjectsInformationEntity");
		resourceEntityMap.put("projectsInfoView","TIdProjectsInformationViewEntity");
		resourceEntityMap.put("qualificationMaster","TIdQualificationMasterEntity");
		resourceEntityMap.put("referenceCodesDetail","TIdReferenceCodesDetailEntity");
		resourceEntityMap.put("referenceCodesHeader","TIdReferenceCodesHeaderEntity");
		resourceEntityMap.put("regionMaster","TIdRegionMasterEntity");
		resourceEntityMap.put("relationShipInfoLink","TIdRelationshipInfoLinkEntity");
		resourceEntityMap.put("relationshipInfo","TIdRelationshipInformationEntity");
		resourceEntityMap.put("rolesMaster","TIdRoleMasterEntity");
		resourceEntityMap.put("shadowContactInfo","TIdShadowContactInformationEntity");
		resourceEntityMap.put("skillMaster","TIdSkillMasterEntity");
		resourceEntityMap.put("skillMasterView","TIdSkillMasterViewEntity");
		resourceEntityMap.put("socialMediaInfo","TIdSocialMediaInformationEntity");
		resourceEntityMap.put("specializationInfo","TIdSpecializationInformationEntity");
		resourceEntityMap.put("splnMaster","TIdSpecializationMasterEntity");
		resourceEntityMap.put("stateMaster","TIdStateMasterEntity");
		resourceEntityMap.put("statusMaster","TIdStatusMasterEntity");
		resourceEntityMap.put("userMaster","TIdUserMasterEntity");
		resourceEntityMap.put("personalInfoLink","TIdUserPersonalInfoLinkEntity");
		resourceEntityMap.put("visitInfo","TIdVisitInformationEntity");
		resourceEntityMap.put("viewProfileInfo","TIdProfileViewDetailsEntity");	
		resourceEntityMap.put("addnlInfoView","TIdAdditionalInformationViewEntity");	
		resourceEntityMap.put("educationInfoView","TIdEducationalInformationViewEntity");	
		resourceEntityMap.put("experienceInfoView","TIdExperienceInformationViewEntity");	
		resourceEntityMap.put("relationshipInfoView","TIdRelationshipInformationViewEntity");
		resourceEntityMap.put("visitInfoView","TIdVisitInformationViewEntity");
		resourceEntityMap.put("addPotentialServices","TIdAddPotentialServicesEntity");
		resourceEntityMap.put("businessPotentialInfo","TIdBusinessPotentialInfoEntity");
		resourceEntityMap.put("personalInterests","TIdPersonalInterestsEntity");
		resourceEntityMap.put("professionalExpertise","TIdProfessionalExpertiseEntity");
		resourceEntityMap.put("professionalInterests","TIdProfessionalInterestsEntity");
		resourceEntityMap.put("recreationInfo","TIdRecreationInfoEntity");
		resourceEntityMap.put("recreationMaster","TIdRecreationMasterEntity");		
		resourceEntityMap.put("personalPriorities","TIdPersonalPrioritiesEntity");	
		resourceEntityMap.put("zipCodeMaster","TIdZipCodeMasterEntity");
		resourceEntityMap.put("profileAddressDetailsView","TIdProfileAddressDetailsViewEntity");
		resourceEntityMap.put("progAccessHeader", "TIdProgAccessHeaderEntity");
		resourceEntityMap.put("progAccessFields", "TIdProgAccessFieldsEntity");
		resourceEntityMap.put("progAccessBlocks", "TIdProgAccessBlocksEntity");
		resourceEntityMap.put("category", "TIdCategoryMasterEntity");
		resourceEntityMap.put("vProgAccessBlocks", "VIdProgAccessBlocksViewEntity");
		resourceEntityMap.put("vProgAccessFields", "VIdProgAccessFieldsViewEntity");
		resourceEntityMap.put("vUserMaster", "TIdUserMasterViewEntity");
		//access blocks curd screens
		resourceEntityMap.put("addinfoBlkAccess", "TIdAddinfoBlkAccessDetailsEntity");
		resourceEntityMap.put("addressBlkAccess", "TIdAddressBlkAccessDetailsEntity");
		resourceEntityMap.put("apsBlkAccess", "TIdApsBlkAccessDetailsEntity");
		resourceEntityMap.put("awardBlkAccess", "TIdAwardBlkAccessDetailsEntity");
		resourceEntityMap.put("eduBlkAccess", "TIdEduBlkAccessDetailsEntity");
		resourceEntityMap.put("bpiBlkAccess", "TIdBpiBlkAccessDetailsEntity");
		resourceEntityMap.put("communicationBlkAccess", "TIdCommunicationBlkAccessDetailsEntity");
		resourceEntityMap.put("expBlkAccess", "TIdExpBlkAccessDetailsEntity");
		resourceEntityMap.put("persInterestBlkAccess", "TIdPersInterestBlkAccessDetailsEntity");
		resourceEntityMap.put("personalInfoBlkAccess", "TIdPersonalInfoBlkAccessDetailsEntity");
		resourceEntityMap.put("persPriorityBlkAccess", "TIdPersPriorityBlkAccessDetailsEntity");
		resourceEntityMap.put("profExpBlkAccess", "TIdProfExpBlkAccessDetailsEntity");
		resourceEntityMap.put("profInterestBlkAccess", "TIdProfInterestBlkAccessDetailsEntity");
		resourceEntityMap.put("projectBlkAccess", "TIdProjectBlkAccessDetailsEntity");
		resourceEntityMap.put("recreationBlkAccess", "TIdRecreationBlkAccessDetailsEntity");
		resourceEntityMap.put("relationInfoBlkAccess", "TIdRelationInfoBlkAccessDetailsEntity");
		resourceEntityMap.put("visitBlkAccess", "TIdVisitBlkAccessDetailsEntity");
		//access  curd screens
		resourceEntityMap.put("addinfoAccess", "TIdAddinfoAccessDetailsEntity");
		resourceEntityMap.put("addressAccess", "TIdAddressAccessDetailsEntity");
		resourceEntityMap.put("apsAccess", "TIdApsAccessDetailsEntity");
		resourceEntityMap.put("awardAccess", "TIdAwardAccessDetailsEntity");
		resourceEntityMap.put("bpiAccess", "TIdBpiAccessDetailsEntity");
		resourceEntityMap.put("communicationAccess", "TIdCommunicationAccessDetailsEntity");
		resourceEntityMap.put("eduAccess", "TIdEduAccessDetailsEntity");
		resourceEntityMap.put("expAccess", "TIdExpAccessDetailsEntity");
		resourceEntityMap.put("persInterestAccess", "TIdPersInterestAccessDetailsEntity");
		resourceEntityMap.put("personalInfoAccess", "TIdPersonalInfoAccessDetailsEntity");
		resourceEntityMap.put("persPriorityAccess", "TIdPersPriorityAccessDetailsEntity");
		resourceEntityMap.put("profExpAccess", "TIdProfExpAccessDetailsEntity");
		resourceEntityMap.put("profInterestAccess", "TIdProfInterestAccessDetailsEntity");
		resourceEntityMap.put("projectAccess", "TIdProjectAccessDetailsEntity");
		resourceEntityMap.put("recreationAccess", "TIdRecreationAccessDetailsEntity");
		resourceEntityMap.put("relationInfoAccess", "TIdRelationInfoAccessDetailsEntity");
		resourceEntityMap.put("visitAccess", "TIdVisitAccessDetailsEntity");
		resourceEntityMap.put("vUserMasterView", "TIdUserMasterViewSearchEntity");
		resourceEntityMap.put("vPersonalIndExpView", "PersonIndividualExperienceViewEntity");
	}
	
	private void configureSelectLists(){
		resourceSelectListMap.put("statusMaster","TIdStatusMasterEntity");
		resourceSelectListMap.put("functionalAreas","TIdFunctionalAreaMasterEntity");
		resourceSelectListMap.put("city","TIdCityMasterEntity");
		resourceSelectListMap.put("countries","TIdCountryMasterEntity");
		resourceSelectListMap.put("stateMaster","TIdStateMasterEntity");
		resourceSelectListMap.put("specializations","TIdSpecializationMasterEntity");
		resourceSelectListMap.put("skills","TIdSkillMasterEntity");
		resourceSelectListMap.put("regions","TIdRegionMasterEntity");
		resourceSelectListMap.put("nationalities","TIdNationalityMasterEntity");
		resourceSelectListMap.put("languages","TIdLanguageMasterEntity");
		resourceSelectListMap.put("institute","TIdEducationalInstitutesEntity");
		resourceSelectListMap.put("education","TIdEducationMasterEntity");
		resourceSelectListMap.put("company","TIdCompanyMasterEntity");
		resourceSelectListMap.put("designation","TIdDesignationMasterEntity");
		resourceSelectListMap.put("bizType","TIdBusinessTypeMasterEntity");
		resourceSelectListMap.put("groupcompanies","TIdCompanyMasterEntity");
		resourceSelectListMap.put("userMaster","TIdUserMasterViewEntity");
		resourceSelectListMap.put("qualificationMaster","TIdQualificationMasterEntity");
		resourceSelectListMap.put("recreation","TIdRecreationMasterEntity");
		resourceSelectListMap.put("zipCode","TIdZipCodeMasterEntity");
		resourceSelectListMap.put("educationalInstitutes", "TIdEducationalInstitutesViewEntity");
		
	}

}
