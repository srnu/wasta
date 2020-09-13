package com.id.wasta.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.id.wasta.bean.DeleteInfoBean;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesEntity;
import com.id.wasta.bean.jpa.TIdAdditionalInformationEntity;
import com.id.wasta.bean.jpa.TIdAwardsInformationEntity;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoEntity;
import com.id.wasta.bean.jpa.TIdEducationalInformationEntity;
import com.id.wasta.bean.jpa.TIdExperienceInformationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdPersonalInterestsEntity;
import com.id.wasta.bean.jpa.TIdPersonalPrioritiesEntity;
import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseEntity;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsEntity;
import com.id.wasta.bean.jpa.TIdProjectsInformationEntity;
import com.id.wasta.bean.jpa.TIdRecreationInfoEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInformationEntity;
import com.id.wasta.bean.jpa.TIdVisitInformationEntity;
import com.id.wasta.business.service.DeleteInfoService;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdMiscInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationJpaRepository;
import static com.id.wasta.util.action.CommonConstants.IN_ACTIVE_STATUS;

@Component
public class DeleteInfoServiceImpl implements DeleteInfoService{
	
	@Resource
	private TIdEducationalInformationJpaRepository tIdEducationalInformationJpaRepository;
	@Resource
	private TIdExperienceInformationJpaRepository tIdExperienceInformationJpaRepository;
	@Resource
	private TIdVisitInformationJpaRepository tIdVisitInformationJpaRepository;
	@Resource
	private TIdRelationshipInformationJpaRepository tIdRelationshipInformationJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	@Resource
	private TIdAdditionalInformationJpaRepository tIdAdditionalInformationJpaRepository;
	@Resource
	private TIdAwardsInformationJpaRepository tIdAwardsInformationJpaRepository;
	@Resource
	private TIdMiscInformationJpaRepository tIdMiscInformationJpaRepository;
	@Resource
	private TIdProjectsInformationJpaRepository tIdProjectsInformationJpaRepository;
	@Resource
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository;
	@Resource
	private TIdAddPotentialServicesJpaRepository tIdAddPotentialServicesJpaRepository;
	@Resource
	private TIdBusinessPotentialInfoJpaRepository tIdBusinessPotentialInfoJpaRepository;
	@Resource
	private TIdProfessionalExpertiseJpaRepository tIdProfessionalExpertiseJpaRepository;
	@Resource
	private TIdProfessionalInterestsJpaRepository tIdProfessionalInterestsJpaRepository;
	@Resource
	private TIdRecreationInfoJpaRepository tIdRecreationInfoJpaRepository;
	@Resource
	private TIdPersonalInterestsJpaRepository tIdPersonalInterestsJpaRepository;
	@Resource
	private TIdPersonalPrioritiesJpaRepository tIdPersonalPrioritiesJpaRepository;
	@Resource
	private TIdPersonalInfoLinkJpaRepository tIdPersonalInfoLinkJpaRepository;
	
	@Override
	public boolean changeStatus(DeleteInfoBean deleteInfoBean) {
		
		if(deleteInfoBean.getCode().equalsIgnoreCase("Education"))
		{
			TIdEducationalInformationEntity  tIdEducationalInformationEntity=tIdEducationalInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdEducationalInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdEducationalInformationJpaRepository.save(tIdEducationalInformationEntity);
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Experience"))
		{
			TIdExperienceInformationEntity  tIdExperienceInformationEntity=tIdExperienceInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdExperienceInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdExperienceInformationJpaRepository.save(tIdExperienceInformationEntity);

			TIdPersonalInfoLinkEntity tIdPersonalInfoLinkEntity = tIdPersonalInfoLinkJpaRepository.findByPilPexKey(deleteInfoBean.getKey());
			if(tIdPersonalInfoLinkEntity != null) {
				Long pexKey = tIdPersonalInfoLinkJpaRepository.work_exp3(tIdPersonalInfoLinkEntity.getPilPinKey());
				if(pexKey!=null) {
					tIdPersonalInfoLinkEntity.setPilPexKey(pexKey);
					tIdPersonalInfoLinkEntity.setPilCurrentlyWorking("N");
					tIdPersonalInfoLinkJpaRepository.save(tIdPersonalInfoLinkEntity);
				} else {
					tIdPersonalInfoLinkJpaRepository.delete(tIdPersonalInfoLinkEntity.getPilKey());
				}
			}
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Discussion"))
		{
			TIdVisitInformationEntity tIdVisitInformationEntity=tIdVisitInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdVisitInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdVisitInformationJpaRepository.save(tIdVisitInformationEntity);
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Relationship"))
		{
			TIdRelationshipInformationEntity  tIdRelationshipInformationEntity=tIdRelationshipInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdRelationshipInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdRelationshipInformationJpaRepository.save(tIdRelationshipInformationEntity);
			TIdRelationshipInfoLinkEntity tIdRelationshipInfoLinkEntity=tIdRelationshipInfoLinkJpaRepository.findByPrlkPrlKey(deleteInfoBean.getKey());
			tIdRelationshipInfoLinkEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdRelationshipInfoLinkJpaRepository.save(tIdRelationshipInfoLinkEntity);
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Additional"))
		{ 
			TIdAdditionalInformationEntity tIdAdditionalInformationEntity=tIdAdditionalInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdAdditionalInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdAdditionalInformationJpaRepository.save(tIdAdditionalInformationEntity);
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Awards"))
		{
			TIdAwardsInformationEntity tIdAwardsInformationEntity=tIdAwardsInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdAwardsInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdAwardsInformationJpaRepository.save(tIdAwardsInformationEntity);
		}
		/*else if(deleteInfoBean.getCode().equalsIgnoreCase("Misc"))
		{
			TIdMiscInformationEntity  tIdMiscInformationEntity=tIdMiscInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdMiscInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdMiscInformationJpaRepository.save(tIdMiscInformationEntity);
		}*/
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Projects"))
		{
			TIdProjectsInformationEntity tIdProjectsInformationEntity=tIdProjectsInformationJpaRepository.findOne(deleteInfoBean.getKey());
			tIdProjectsInformationEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdProjectsInformationJpaRepository.save(tIdProjectsInformationEntity);
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Attachment"))
		{
			TIdProductAttachmentEntity  tIdProductAttachmentEntity=tIdProductAttachmentJpaRepository.findOne(deleteInfoBean.getKey());
			tIdProductAttachmentEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdProductAttachmentJpaRepository.save(tIdProductAttachmentEntity);
		} 
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Potential Services"))
		{
			TIdAddPotentialServicesEntity tIdAddPotentialServicesEntity=tIdAddPotentialServicesJpaRepository.findOne(deleteInfoBean.getKey());
			tIdAddPotentialServicesEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdAddPotentialServicesJpaRepository.save(tIdAddPotentialServicesEntity);
		} 
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Business Potential"))
		{
			TIdBusinessPotentialInfoEntity tIdBusinessPotentialInfoEntity=tIdBusinessPotentialInfoJpaRepository.findOne(deleteInfoBean.getKey());
			tIdBusinessPotentialInfoEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdBusinessPotentialInfoJpaRepository.save(tIdBusinessPotentialInfoEntity);
		} 
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Personal Interests"))
		{
			TIdPersonalInterestsEntity tIdPersonalInterestsEntity=tIdPersonalInterestsJpaRepository.findOne(deleteInfoBean.getKey());
			tIdPersonalInterestsEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdPersonalInterestsJpaRepository.save(tIdPersonalInterestsEntity);
		} 
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Professional Expertise"))
		{
			TIdProfessionalExpertiseEntity tIdProfessionalExpertiseEntity=tIdProfessionalExpertiseJpaRepository.findOne(deleteInfoBean.getKey());
			tIdProfessionalExpertiseEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdProfessionalExpertiseJpaRepository.save(tIdProfessionalExpertiseEntity);
		} 
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Professional Intertests"))
		{
			TIdProfessionalInterestsEntity tIdProfessionalInterestsEntity=tIdProfessionalInterestsJpaRepository.findOne(deleteInfoBean.getKey());
			tIdProfessionalInterestsEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdProfessionalInterestsJpaRepository.save(tIdProfessionalInterestsEntity);
		} 
		else if(deleteInfoBean.getCode().equalsIgnoreCase("Recreation Info"))
		{
			TIdRecreationInfoEntity tIdRecreationInfoEntity=tIdRecreationInfoJpaRepository.findOne(deleteInfoBean.getKey());
			tIdRecreationInfoEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdRecreationInfoJpaRepository.save(tIdRecreationInfoEntity);
		}
		else if(deleteInfoBean.getCode().equalsIgnoreCase("personal Priorities"))
		{
			TIdPersonalPrioritiesEntity tIdPersonalPrioritiesEntity=tIdPersonalPrioritiesJpaRepository.findOne(deleteInfoBean.getKey());
			tIdPersonalPrioritiesEntity.setActiveStatus(IN_ACTIVE_STATUS);
			tIdPersonalPrioritiesJpaRepository.save(tIdPersonalPrioritiesEntity);
		}
		
		else {
			return false;
		}
		return true;
	}
	
	
	

}
