package com.id.wasta.business.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.CommonConstants;
import com.id.wasta.bean.TIdPersonalInformation;
import com.id.wasta.bean.TIdProfileViewDetails;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdChangeLogDetailsEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsEntity;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdTableAuditLogEntity;
import com.id.wasta.business.service.ViewInfoService;
import com.id.wasta.business.service.mapper.TIdProfileViewDetailsServiceMapper;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdChangeLogDetailsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCommunicationInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDashboardMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDashboardTransactionJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLanguageInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileViewDetailsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileViewDetailsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdTableAuditLogJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationJpaRepository;

@Service
@Transactional
public class ViewInfoServiceImpl implements ViewInfoService {

	private static final long serialVersionUID = 1L;

	@Resource
	private TIdProfileViewDetailsViewJpaRepository tIdProfileViewDetailsViewJpaRepository;
	
	@Resource
	private TIdTableAuditLogJpaRepository tIdTableAuditLogJpaRepository;
	
	@Resource
	private TIdChangeLogDetailsJpaRepository tIdChangeLogDetailsJpaRepository;
	
	@Resource
	private TIdProfileViewDetailsJpaRepository tIdProfileViewDetailsJpaRepository;
	
	@Resource
	private TIdProfileViewDetailsServiceMapper tIdProfileViewDetailsServiceMapper;
	
	@Resource
	private TIdDashboardTransactionJpaRepository tIdDashboardTransactionJpaRepository;
	
	@Resource
	private TIdDashboardMasterJpaRepository tIdDashboardMasterJpaRepository;
	
	@Autowired
	private TIdCommunicationInformationJpaRepository tIdCommunicationInformationJpaRepository;
	
	@Autowired
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	
	@Autowired
	private TIdExperienceInformationJpaRepository tIdExperienceInformationJpaRepository;
	
	@Autowired
	private TIdLanguageInformationJpaRepository tIdLanguageInformationJpaRepository;
	@Resource
	private PersonIndividualExperienceViewJpaRepository  personIndividualExperienceViewJpaRepository;
	@Autowired
	private TIdEducationalInformationJpaRepository tIdEducationalInformationJpaRepository;
	
	@Autowired
	private TIdAdditionalInformationJpaRepository tIdAdditionalInformationJpaRepository;
	
	@Autowired
	private TIdAwardsInformationJpaRepository tIdAwardsInformationJpaRepository;
	
	@Autowired
	private TIdProjectsInformationJpaRepository tIdProjectsInformationJpaRepository;
	
	@Autowired
	private TIdRecreationInfoJpaRepository tIdRecreationInfoJpaRepository;
	
	@Autowired
	private TIdBusinessPotentialInfoJpaRepository tIdBusinessPotentialInfoJpaRepository;
	
	@Autowired
	private TIdProfessionalExpertiseJpaRepository tIdProfessionalExpertiseJpaRepository;
	
	@Autowired
	private TIdProfessionalInterestsJpaRepository tIdProfessionalInterestsJpaRepository;
	
	@Autowired
	private TIdPersonalInterestsJpaRepository tIdPersonalInterestsJpaRepository;
	
	@Autowired
	private TIdPersonalPrioritiesJpaRepository tIdPersonalPrioritiesJpaRepository;
	
	@Autowired
	private TIdRelationshipInformationJpaRepository tIdRelationshipInformationJpaRepository;
	
	@Autowired
	private TIdVisitInformationJpaRepository tIdVisitInformationJpaRepository;
	
	@Autowired
	private TIdAddPotentialServicesJpaRepository tIdAddPotentialServicesJpaRepository;
	
	@Autowired
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository;
	
	@Override
	public List<TIdProfileViewDetailsViewEntity> getViewProfileInfoDtls(Long pinKey) {
		return tIdProfileViewDetailsViewJpaRepository.findByPvdPinKey(pinKey);
	}

	@Override
	public List<TIdTableAuditLogEntity> getAudiLogInfoDtls(Long primaryKey) {
		return tIdTableAuditLogJpaRepository.getAuditLogInfo(primaryKey);
	}
	
	@Override
	public List<TIdTableAuditLogEntity> getDistinctAudiLogInfoDtls(Long primaryKey) {
		return tIdTableAuditLogJpaRepository.getDistinctAuditLogInfo(primaryKey);
	}

	@Override
	public List<TIdChangeLogDetailsEntity> getChangeLogDtls(String screenName, Long primaryKey) {
		
		return tIdChangeLogDetailsJpaRepository.findByTchgTableNameAndTchgTableKeyColValue1(screenName, primaryKey);
		}

	@Override
	public TIdProfileViewDetails saveProfileDtls(TIdProfileViewDetails tIdProfileViewDetails) {
		
		TIdProfileViewDetailsEntity tIdProfileViewDetailsEntity = tIdProfileViewDetailsJpaRepository.findByPvdPinKeyAndPvdPinViewedbyKey(tIdProfileViewDetails.getPvdPinKey(),tIdProfileViewDetails.getPvdPinViewedbyKey());
		if(tIdProfileViewDetailsEntity==null) {
			tIdProfileViewDetailsEntity = new TIdProfileViewDetailsEntity();
			tIdProfileViewDetailsServiceMapper.mapTIdProfileViewDetailsToTIdProfileViewDetailsEntity(tIdProfileViewDetails, tIdProfileViewDetailsEntity);
			tIdProfileViewDetailsEntity.setActiveStatus(CommonConstants.ACTIVE_STATUS);
		} 
		tIdProfileViewDetailsEntity.setPvdViewedDate(new Date());
		tIdProfileViewDetailsEntity=tIdProfileViewDetailsJpaRepository.save(tIdProfileViewDetailsEntity);
		tIdProfileViewDetails.setPvdKey(tIdProfileViewDetailsEntity.getPvdKey());
		return tIdProfileViewDetails;
	}

	@Override
	public BigDecimal getProfileCompletePercentDtls(Long pinKey) {
		return tIdDashboardTransactionJpaRepository.findByDtPinKey(pinKey).multiply(new BigDecimal(100)).divide(tIdDashboardMasterJpaRepository.getMasterEntities(),0, RoundingMode.HALF_UP);
	}

	@Override
	public Integer getCompletedProfilePercentageInfo(Long pinKey) {
		
		PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity=personIndividualExperienceViewJpaRepository.findOne(pinKey);
		if(personIndividualExperienceViewEntity!=null && personIndividualExperienceViewEntity.getUserKey()!=0){
			int percentage1 = (int) Math.round((employeePercentage(pinKey)/14.0) * 100D);
			tIdPersonalInformationJpaRepository.savePercentage(pinKey,Long.valueOf(percentage1));
			return Integer.valueOf(percentage1);
			
		}else{
			
			Integer count = employeePercentage(pinKey);
			List<Long> primaryKey = new ArrayList<Long>();
			primaryKey =  tIdRecreationInfoJpaRepository.findReiPinKey(pinKey);
			if(primaryKey.size()>0) {
				count++;
			}
			
			primaryKey =  tIdProfessionalInterestsJpaRepository.findPriPinKey(pinKey);
			if(primaryKey.size()>0) {
				count++;
			}
			
			primaryKey =  tIdPersonalInterestsJpaRepository.findPeriPinKey(pinKey);
			if(primaryKey.size()>0) {
				count++;
			}
			
			primaryKey =  tIdPersonalPrioritiesJpaRepository.findPerpPinKey(pinKey);
			if(primaryKey.size()>0) {
				count++;
			}
			
			primaryKey =  tIdVisitInformationJpaRepository.findPivPinKey(pinKey);
			if(primaryKey.size()>0) {
				count++;
			}
			
			int percentage1 = (int) Math.round((count/19.0) * 100D);
			tIdPersonalInformationJpaRepository.savePercentage(pinKey,Long.valueOf(percentage1));
			return Integer.valueOf(percentage1);
		}
	}
	
	public Integer employeePercentage(Long pinKey) {
		Integer count = 0;
		List<Long> pimaryKeys = new ArrayList<Long>();
	
		pimaryKeys = tIdCommunicationInformationJpaRepository.getPrimaryKeyByPcmPinKey(pinKey);
		if(pimaryKeys!=null && pimaryKeys.size()>0) {
			count++;
		}
		
		TIdPersonalInformationEntity tIdPersonalInformationObj = tIdPersonalInformationJpaRepository.getEmailId(pinKey);
		if(tIdPersonalInformationObj!=null) {
			count++;
			if(tIdPersonalInformationObj.getPinEmail()!=null && !(tIdPersonalInformationObj.getPinEmail().isEmpty()) ) {
				count++;
			}
		}
		
		pimaryKeys = tIdLanguageInformationJpaRepository.getListOfPrimaryKeysByPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdExperienceInformationJpaRepository.getPrimaryKeysByUserKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdEducationalInformationJpaRepository.findPeiPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdAdditionalInformationJpaRepository.findPiadPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdAwardsInformationJpaRepository.findPiaPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdProjectsInformationJpaRepository.findPipPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdBusinessPotentialInfoJpaRepository.findBpiPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdProfessionalExpertiseJpaRepository.findPpePinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdRelationshipInformationJpaRepository.getPrlKeyByPrlPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdAddPotentialServicesJpaRepository.findApsPinKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		pimaryKeys =  tIdProductAttachmentJpaRepository.getPrimaryKey(pinKey);
		if(pimaryKeys.size()>0) {
			count++;
		}
		
		return count;
		
	}
	
}
