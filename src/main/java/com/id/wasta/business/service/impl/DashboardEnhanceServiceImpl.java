package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.CONTACT;
import static com.id.wasta.util.action.CommonConstants.EMPLOYEE;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdProductAttachment;
import com.id.wasta.bean.TIdRelationshipInformationView;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsViewEntity;
import com.id.wasta.business.service.CustomerInfoService;
import com.id.wasta.business.service.DashboardEnhanceService;
import com.id.wasta.business.service.DashboardInfoService;
import com.id.wasta.business.service.MiscInfoService;
import com.id.wasta.business.service.ProfileFollowService;
import com.id.wasta.business.service.ReferenceValuesViewService;
import com.id.wasta.business.service.ViewInfoService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;

@Service
public class DashboardEnhanceServiceImpl implements DashboardEnhanceService{
	private static final Logger logger = Logger.getLogger(DashboardEnhanceService.class); 
	
	@Autowired
	private MiscInfoService miscInfoService;
	
	@Autowired
	private DashboardInfoService dashboardInfoService;
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository;
	
	@Autowired
	private ViewInfoService  viewInfoService;
	
	@Autowired
	private ProfileFollowService  profileFollowService;
	
	@Autowired
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	
	@Autowired
	private ReferenceValuesViewService referenceValuesViewService;
	
	@Override
	public AccessBlocks getDashBoardProfile(DashBoardRequestBean dashBoardRequest) throws Exception {
		logger.info("getDashBoardProfile method called....");
		AccessBlocks accessBlocks = new AccessBlocks(); 
		
		accessBlocks = dashboardInfoService.getVisitInfoDtls(dashBoardRequest);
		if(accessBlocks.getVisitList()!=null) {
			accessBlocks.setVisitList(accessBlocks.getVisitList());
		}
		
		accessBlocks = miscInfoService.getBusinessPotential(dashBoardRequest);
		if(accessBlocks.getBusinessPotentialList()!=null && accessBlocks.getBusinessPotentialList().size()>0 && !(accessBlocks.getBusinessPotentialList().isEmpty())) {
			accessBlocks.setBusinessPotentialList(accessBlocks.getBusinessPotentialList());
		}
		
		accessBlocks =miscInfoService.getRecreationInfo(dashBoardRequest);
		if(accessBlocks.getRecreationList()!=null && accessBlocks.getRecreationList().size()>0 && !(accessBlocks.getRecreationList().isEmpty())) {
			accessBlocks.setRecreationList(accessBlocks.getRecreationList());
		}
				
		accessBlocks =miscInfoService.getPotentialServicesInfo(dashBoardRequest);
		if(accessBlocks.getPotentialServicesList()!=null  && accessBlocks.getPotentialServicesList().size()>0 && !(accessBlocks.getPotentialServicesList().isEmpty()) ) {
			accessBlocks.setPotentialServicesList(accessBlocks.getPotentialServicesList());
		}
		
		
		accessBlocks =customerInfoService.viewCustomerInfo(dashBoardRequest);
		if(accessBlocks.getCustomerInfoBean()!=null) {
			accessBlocks.setCustomerInfoBean(accessBlocks.getCustomerInfoBean());
			accessBlocks.setRole(accessBlocks.getRole());
			
		}
		
		return accessBlocks;
	}

	@Override
	public AccessBlocks getCompleteDashBoardProfile(DashBoardRequestBean dashBoardRequest) throws Exception {
		
		logger.info("getCompleteDashBoardProfile method called....");
		AccessBlocks accessBlocks = new AccessBlocks();
		AccessBlocks accessBlocksTemp = new AccessBlocks();
		
		accessBlocksTemp =customerInfoService.viewCustomerInfo(dashBoardRequest);
		if(accessBlocksTemp.getCustomerInfoBean()!=null) {
			accessBlocks.setCustomerInfoBean(accessBlocksTemp.getCustomerInfoBean());
			accessBlocks.setRole(accessBlocks.getRole());
		}
		
		
		//Discussion Details
		accessBlocksTemp = dashboardInfoService.getVisitInfoDtls(dashBoardRequest);
		if(accessBlocksTemp.getVisitList()!=null) {
			accessBlocks.setVisitList(accessBlocksTemp.getVisitList());
		}
		
		//Business potential
		accessBlocksTemp = miscInfoService.getBusinessPotential(dashBoardRequest);
		if(accessBlocksTemp.getBusinessPotentialList()!=null && accessBlocksTemp.getBusinessPotentialList().size()>0) {
			accessBlocks.setBusinessPotentialList(accessBlocksTemp.getBusinessPotentialList());
		}
		
		//Potential Service
		accessBlocksTemp =miscInfoService.getPotentialServicesInfo(dashBoardRequest);
		if(accessBlocksTemp.getPotentialServicesList()!=null  && accessBlocksTemp.getPotentialServicesList().size()>0) {
			accessBlocks.setPotentialServicesList(accessBlocksTemp.getPotentialServicesList());
		}
		
		//Recreation
		accessBlocksTemp =miscInfoService.getRecreationInfo(dashBoardRequest);
		if(accessBlocksTemp.getRecreationList()!=null && accessBlocksTemp.getRecreationList().size()>0) {
			accessBlocks.setRecreationList(accessBlocksTemp.getRecreationList());
		}
		
		//professional interest
		accessBlocksTemp = miscInfoService.getProfessionalInterests(dashBoardRequest);
		if(accessBlocksTemp.getProfInterestList()!=null && accessBlocksTemp.getProfInterestList().size()>0) {
			accessBlocks.setProfInterestList(accessBlocksTemp.getProfInterestList());
		}
		
		//Personal Interest
		accessBlocksTemp = miscInfoService.getPersonalInterests(dashBoardRequest);
		if(accessBlocksTemp.getPersonalInterestList()!=null && accessBlocksTemp.getPersonalInterestList().size()>0) {
			accessBlocks.setPersonalInterestList(accessBlocksTemp.getPersonalInterestList());
		}
		
		
		//personal Priority
		accessBlocksTemp = miscInfoService.getPersonalPrioritiesInfo(dashBoardRequest);
		if(accessBlocksTemp.getPersonalPriorityList()!=null && accessBlocksTemp.getPersonalPriorityList().size()>0) {
			accessBlocks.setPersonalPriorityList(accessBlocksTemp.getPersonalPriorityList());
		}
		
		//Experience
		accessBlocksTemp = dashboardInfoService.getExperienceInfoDtls(dashBoardRequest);
		
		if(accessBlocksTemp.getExperienceList()!=null && accessBlocksTemp.getExperienceList().size()>0) {
			accessBlocks.setExperienceList(accessBlocksTemp.getExperienceList());
		}
		
		//Education
		accessBlocksTemp = dashboardInfoService.getEducationalInfoDtls(dashBoardRequest);
		if(accessBlocksTemp.getEducationList()!=null && accessBlocksTemp.getEducationList().size()>0) {
			accessBlocks.setEducationList(accessBlocksTemp.getEducationList());
		}
		
		//project Excuted
		accessBlocksTemp = dashboardInfoService.getProjectsInfoDtls(dashBoardRequest);
		if(accessBlocksTemp.getProjectList()!=null && accessBlocksTemp.getProjectList().size()>0) {
			accessBlocks.setProjectList(accessBlocksTemp.getProjectList());
		}
		
		//ProfessionalExpertise
		accessBlocksTemp = miscInfoService.getProfessionalExpertise(dashBoardRequest);
		if(accessBlocksTemp.getProfExpertiseList()!=null && accessBlocksTemp.getProfExpertiseList().size()>0) {
			accessBlocks.setProfExpertiseList(accessBlocksTemp.getProfExpertiseList());
		}		
		
		//AwardInfo
		accessBlocksTemp = dashboardInfoService.getAwardInfoDtls(dashBoardRequest);
		
		if(accessBlocksTemp.getAwardsList()!=null && accessBlocksTemp.getAwardsList().size()>0) {
			accessBlocks.setAwardsList(accessBlocksTemp.getAwardsList());
		}
		
		//AdditionalInfo
		accessBlocksTemp = dashboardInfoService.getAdditionalInfoDtls(dashBoardRequest);
		if(accessBlocksTemp.getAdditionalInfoList()!=null && accessBlocksTemp.getAdditionalInfoList().size()>0) {
			accessBlocks.setAdditionalInfoList(accessBlocksTemp.getAdditionalInfoList());
		}
		
		//RelationshipInfoDtls personal & professional
		List<TIdRelationshipInformationView> listOfRelationshipInfoDtls = dashboardInfoService.getProfAndPerRelationshipInfoDtls(dashBoardRequest);
		if(listOfRelationshipInfoDtls!=null && listOfRelationshipInfoDtls.size()>0) {
			accessBlocks.setRelationShipInformationView(listOfRelationshipInfoDtls);
		}
		
		
		//ViewProfileInfoDtls
		List<TIdProfileViewDetailsViewEntity> listOfviewProfileInfoDtls = viewInfoService.getViewProfileInfoDtls(dashBoardRequest.getPinKey());
		if(listOfviewProfileInfoDtls!=null && listOfviewProfileInfoDtls.size()>0) {
			accessBlocks.setViewProfileInfoDtls(listOfviewProfileInfoDtls);
		}
		
		//profileInfo
		List<TIdProfileFollowDetailsViewEntity> listOfProfileFollowInfoDtls = profileFollowService.getProfileFollowInfoDtls(dashBoardRequest.getPinKey());
		if(listOfProfileFollowInfoDtls.size()>0) {
			accessBlocks.setProfileFollowInfoDtls(listOfProfileFollowInfoDtls);
		}
		
		//RelationShipGroupInfoDetails
		accessBlocksTemp = dashboardInfoService.getRelationshipGrpInfoDtl(dashBoardRequest);
		if(accessBlocksTemp.getRelationShipGroupList()!=null && accessBlocksTemp.getRelationShipGroupList().size()>0) {
			accessBlocks.setRelationShipGroupList(accessBlocksTemp.getRelationShipGroupList());
		}
		
		//Attachement
		TIdProductAttachmentEntity tIdProductAttachmentEntity = tIdProductAttachmentJpaRepository.getPictureObj(dashBoardRequest.getPinKey());
		if(tIdProductAttachmentEntity!=null) {
			TIdProductAttachment tIdProductAttachment = new TIdProductAttachment();
			BeanUtils.copyProperties(tIdProductAttachmentEntity, tIdProductAttachment);
			accessBlocks.settIdProductAttachment(tIdProductAttachment);
		}
		
		//ProfileCompletion Percentage 
		Integer value = viewInfoService.getCompletedProfilePercentageInfo(dashBoardRequest.getPinKey());
		if(value!=null) {
			accessBlocks.setProfileCompletedPercentage(value);
		}
		
		PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity=personIndividualExperienceViewJpaRepository.findOne(dashBoardRequest.getPinKey());
		if(personIndividualExperienceViewEntity.getUserKey()!=0){
			accessBlocks.setRole(EMPLOYEE);
		}else{
			accessBlocks.setRole(CONTACT);
		}
		List<SelectListBean> refList= referenceValuesViewService.getReferences("StarRating", 1l);
		if(refList.size()>0) {
			accessBlocks.setStarList(refList);
		}
		return accessBlocks;
	}
	
	

}
