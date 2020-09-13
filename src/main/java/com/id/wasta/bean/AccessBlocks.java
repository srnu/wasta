package com.id.wasta.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsViewEntity;

@JsonInclude(Include.NON_EMPTY)
public class AccessBlocks implements Serializable {

	private static final long serialVersionUID = 1L;

	private String role;

	private List<TIdAwardsInformationView> awardsList;

	private List<TIdExperienceInformationView> experienceList;

	private List<TIdVisitInformationView> visitList;

	private List<TIdAdditionalInformationView> additionalInfoList;

	private List<TIdEducationalInformationView> educationList;

	private List<TIdProjectsInformationView> projectList;

	private CustomerInfoBean customerInfoBean;

	private List<TIdAddPotentialServicesView> potentialServicesList;

	private List<TIdBusinessPotentialInfoView> businessPotentialList;

	private List<TIdPersonalInterestsView> personalInterestList;

	private List<TIdProfessionalExpertiseView> profExpertiseList;

	private List<TIdProfessionalInterestsView> profInterestList;

	private List<TIdRecreationInfoView> recreationList;

	private List<TIdPersonalPriorities> personalPriorityList;

	private List<TIdRelationGroupInfoView> relationShipGroupList;

	private List<TIdCommunicationInformation> communicationInformationList;
	
	private TIdProductAttachment tIdProductAttachment;
	
	private List<TIdRelationshipInformationView> relationShipInformationView;
	
	public List<TIdProfileViewDetailsViewEntity> viewProfileInfoDtls;
	
	public List<TIdProfileFollowDetailsViewEntity> profileFollowInfoDtls;
	
	public List<SelectListBean> starList;
	
	private Integer profileCompletedPercentage;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<TIdAwardsInformationView> getAwardsList() {
		return awardsList;
	}

	public void setAwardsList(List<TIdAwardsInformationView> awardsList) {
		this.awardsList = awardsList;
	}

	public List<TIdExperienceInformationView> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<TIdExperienceInformationView> experienceList) {
		this.experienceList = experienceList;
	}

	public List<TIdVisitInformationView> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<TIdVisitInformationView> visitList) {
		this.visitList = visitList;
	}

	public List<TIdAdditionalInformationView> getAdditionalInfoList() {
		return additionalInfoList;
	}

	public void setAdditionalInfoList(List<TIdAdditionalInformationView> additionalInfoList) {
		this.additionalInfoList = additionalInfoList;
	}

	public List<TIdEducationalInformationView> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<TIdEducationalInformationView> educationList) {
		this.educationList = educationList;
	}

	public List<TIdProjectsInformationView> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<TIdProjectsInformationView> projectList) {
		this.projectList = projectList;
	}

	public CustomerInfoBean getCustomerInfoBean() {
		return customerInfoBean;
	}

	public void setCustomerInfoBean(CustomerInfoBean customerInfoBean) {
		this.customerInfoBean = customerInfoBean;
	}

	public List<TIdAddPotentialServicesView> getPotentialServicesList() {
		return potentialServicesList;
	}

	public void setPotentialServicesList(List<TIdAddPotentialServicesView> potentialServicesList) {
		this.potentialServicesList = potentialServicesList;
	}

	public List<TIdBusinessPotentialInfoView> getBusinessPotentialList() {
		return businessPotentialList;
	}

	public void setBusinessPotentialList(List<TIdBusinessPotentialInfoView> businessPotentialList) {
		this.businessPotentialList = businessPotentialList;
	}

	public List<TIdPersonalInterestsView> getPersonalInterestList() {
		return personalInterestList;
	}

	public void setPersonalInterestList(List<TIdPersonalInterestsView> personalInterestList) {
		this.personalInterestList = personalInterestList;
	}

	public List<TIdProfessionalExpertiseView> getProfExpertiseList() {
		return profExpertiseList;
	}

	public void setProfExpertiseList(List<TIdProfessionalExpertiseView> profExpertiseList) {
		this.profExpertiseList = profExpertiseList;
	}

	public List<TIdProfessionalInterestsView> getProfInterestList() {
		return profInterestList;
	}

	public void setProfInterestList(List<TIdProfessionalInterestsView> profInterestList) {
		this.profInterestList = profInterestList;
	}

	public List<TIdRecreationInfoView> getRecreationList() {
		return recreationList;
	}

	public void setRecreationList(List<TIdRecreationInfoView> recreationList) {
		this.recreationList = recreationList;
	}

	public List<TIdPersonalPriorities> getPersonalPriorityList() {
		return personalPriorityList;
	}

	public void setPersonalPriorityList(List<TIdPersonalPriorities> personalPriorityList) {
		this.personalPriorityList = personalPriorityList;
	}

	public List<TIdRelationGroupInfoView> getRelationShipGroupList() {
		return relationShipGroupList;
	}

	public void setRelationShipGroupList(List<TIdRelationGroupInfoView> relationShipGroupList) {
		this.relationShipGroupList = relationShipGroupList;
	}

	public List<TIdCommunicationInformation> getCommunicationInformationList() {
		return communicationInformationList;
	}

	public void setCommunicationInformationList(List<TIdCommunicationInformation> communicationInformationList) {
		this.communicationInformationList = communicationInformationList;
	}

	public TIdProductAttachment gettIdProductAttachment() {
		return tIdProductAttachment;
	}

	public void settIdProductAttachment(TIdProductAttachment tIdProductAttachment) {
		this.tIdProductAttachment = tIdProductAttachment;
	}

	public List<TIdRelationshipInformationView> getRelationShipInformationView() {
		return relationShipInformationView;
	}

	public void setRelationShipInformationView(List<TIdRelationshipInformationView> relationShipInformationView) {
		this.relationShipInformationView = relationShipInformationView;
	}

	public List<TIdProfileViewDetailsViewEntity> getViewProfileInfoDtls() {
		return viewProfileInfoDtls;
	}

	public void setViewProfileInfoDtls(List<TIdProfileViewDetailsViewEntity> viewProfileInfoDtls) {
		this.viewProfileInfoDtls = viewProfileInfoDtls;
	}

	public List<TIdProfileFollowDetailsViewEntity> getProfileFollowInfoDtls() {
		return profileFollowInfoDtls;
	}

	public void setProfileFollowInfoDtls(List<TIdProfileFollowDetailsViewEntity> profileFollowInfoDtls) {
		this.profileFollowInfoDtls = profileFollowInfoDtls;
	}

	public Integer getProfileCompletedPercentage() {
		return profileCompletedPercentage;
	}

	public void setProfileCompletedPercentage(Integer profileCompletedPercentage) {
		this.profileCompletedPercentage = profileCompletedPercentage;
	}

	public List<SelectListBean> getStarList() {
		return starList;
	}

	public void setStarList(List<SelectListBean> starList) {
		this.starList = starList;
	}
	
	
	
}
