package com.id.wasta.business.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.id.wasta.bean.jpa.TIdExperienceInformationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;
import com.id.wasta.bean.jpa.TIdUserMasterEntity;
import com.id.wasta.bean.jpa.TIdWastaUsageReportEntity;
import com.id.wasta.business.service.WastaAdhocReportService;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdWastaUsageReportJpaRepository;

@Service
public class WastaAdhocReportServiceImpl implements WastaAdhocReportService{
	
	private static final Logger logger = Logger.getLogger(WastaAdhocReportServiceImpl.class);

	@Autowired
	TIdUserMasterJpaRepository tIdUserMasterJpaRepository;

	@Autowired
	TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	
	@Autowired
	TIdExperienceInformationJpaRepository tIdExperienceInformationJpaRepository; 
	
	@Autowired
	TIdDesignationMasterJpaRepository tIdDesignationMasterJpaRepository;
	
	@Autowired
	TIdVisitInformationJpaRepository tIdVisitInformationJpaRepository;
	
	@Autowired
	TIdBusinessPotentialInfoJpaRepository tIdBusinessPotentialInfoJpaRepository;
	
	@Autowired
	TIdAddPotentialServicesJpaRepository tIdAddPotentialServicesJpaRepository;
	
	@Autowired
	TIdProfessionalInterestsJpaRepository tIdProfessionalInterestsJpaRepository;
	
	@Autowired
	TIdPersonalInterestsJpaRepository tIdPersonalInterestsJpaRepository;
	
	@Autowired
	TIdPersonalPrioritiesJpaRepository tIdPersonalPrioritiesJpaRepository;
	
	@Autowired
	TIdRecreationInfoJpaRepository tIdRecreationInfoJpaRepository; 
	
	@Autowired
	TIdEducationalInformationJpaRepository tIdEducationalInformationJpaRepository;
	
	@Autowired
	TIdProjectsInformationJpaRepository tIdProjectsInformationJpaRepository;
	
	@Autowired
	TIdProfessionalExpertiseJpaRepository tIdProfessionalExpertiseJpaRepository;
	
	@Autowired
	TIdAwardsInformationJpaRepository tIdAwardsInformationJpaRepository;
	
	@Autowired
	TIdAdditionalInformationJpaRepository tIdAdditionalInformationJpaRepository; 
	
	@Autowired
	TIdWastaUsageReportJpaRepository tIdWastaUsageReportJpaRepository;
	
	@Autowired
	TIdProfessionalInterestsJpaRepository tIdProfessionalInterestJpaRepository;
	 
	@Autowired
	TIdProjectsInformationJpaRepository tIdProjectExecutedJpaRepository;
	
	@Autowired
	TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	
	
	
	
	
	
	
	@Scheduled(cron = "${wastaAdhocSchedule}")
	@Override
	public void wastaUsageReport() {
		
		
		logger.debug("wastaUsageReport method executed");
		tIdWastaUsageReportJpaRepository.deleteAll();
		
		List<TIdUserMasterEntity> allUsers=tIdUserMasterJpaRepository.getAllUSer();
		List<TIdWastaUsageReportEntity> listOfTIdWastaUsageReportEntity = new ArrayList<TIdWastaUsageReportEntity>();
		
		
		Long othersCount;
		if(allUsers.size()>0) {
			TIdWastaUsageReportEntity tIdWastaUsageReportEntityObj =  null;
			for (TIdUserMasterEntity tIdUserMasterEntity : allUsers) {
				if(tIdUserMasterEntity.getUserPinKey()>0 && !(tIdUserMasterEntity.getUserPasswordModified().equalsIgnoreCase("L")) ) {
					TIdPersonalInformationEntity tIdPersonalInformation = tIdPersonalInformationJpaRepository.findByPinKey(tIdUserMasterEntity.getUserPinKey());
					TIdExperienceInformationEntity tIdExperienceInformationEntity = tIdExperienceInformationJpaRepository.getPresentExperience(tIdPersonalInformation.getPinKey());
					Long totalNoOfContacts = tIdPersonalInformationJpaRepository.getTotalContactsByUser(tIdUserMasterEntity.getUserPinKey());
						if(tIdExperienceInformationEntity!=null &&tIdPersonalInformation!=null) {
							tIdWastaUsageReportEntityObj = new TIdWastaUsageReportEntity();
							if(tIdUserMasterEntity.getUserPinKey()==1) {
									LocalDate todayDatel =LocalDate.now();
									ZoneId defaultZoneId = ZoneId.systemDefault();
									Date todayDate = Date.from(todayDatel.atStartOfDay(defaultZoneId).toInstant());//convert to Local Formate to Date
									Long noOfDiscussionDetails = tIdVisitInformationJpaRepository.getTotalDiscussionsByUserOnDate(tIdUserMasterEntity.getUserPinKey(),todayDate);
									Long noOfBusinessDetasils = tIdBusinessPotentialInfoJpaRepository.getNoOfBusinessUpdatedByUserOnDate(tIdUserMasterEntity.getUserPinKey(),todayDate);
									Long noOfAdditionalPotential = tIdAddPotentialServicesJpaRepository.getNoOfAddPotentialUdatedByUserOnDate(tIdUserMasterEntity.getUserPinKey(),todayDate);
									Long noOfNewContacts = tIdPersonalInformationJpaRepository.getNewContactsCreatedOnDate(tIdUserMasterEntity.getUserPinKey(),todayDate);
									othersCount = tIdProfessionalInterestsJpaRepository.getNoOfProfessionalIntrest(tIdUserMasterEntity.getUserPinKey(),todayDate);
									othersCount = Long.sum(othersCount, tIdPersonalInterestsJpaRepository.getTotalpersonalIntrest(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdPersonalPrioritiesJpaRepository.getTotalPersonalPriorities(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdRecreationInfoJpaRepository.getTotalRecreation(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdExperienceInformationJpaRepository.getToatlExperience(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdEducationalInformationJpaRepository.getTotalEducational(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdProjectExecutedJpaRepository.getTotalProjects(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdProfessionalExpertiseJpaRepository.getTotalProfessionalExpertise(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdAwardsInformationJpaRepository.getTotalAwards(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdAdditionalInformationJpaRepository.getAdditionalInfo(tIdUserMasterEntity.getUserPinKey(),todayDate));
									othersCount =Long.sum(othersCount, tIdRelationshipInfoLinkJpaRepository.getPersonalProfessionalRelationCount(tIdUserMasterEntity.getUserPinKey(),"Personal",todayDate));
									othersCount =Long.sum(othersCount, tIdRelationshipInfoLinkJpaRepository.getPersonalProfessionalRelationCount(tIdUserMasterEntity.getUserPinKey(),"Professional",todayDate));
									
									if(othersCount==1) {
										System.out.println(tIdUserMasterEntity.getUserPinKey());
									}
									tIdWastaUsageReportEntityObj.setUsageUserkey(tIdUserMasterEntity.getUserKey());
									tIdWastaUsageReportEntityObj.setUsagePinkey(tIdPersonalInformation.getPinKey());
									tIdWastaUsageReportEntityObj.setUsageStatus(tIdUserMasterEntity.getActiveStatus());
									tIdWastaUsageReportEntityObj.setUsageNoOfTotalContact(totalNoOfContacts);
									tIdWastaUsageReportEntityObj.setUsageDesignationkey(tIdExperienceInformationEntity.getPexDesignationKey());
									tIdWastaUsageReportEntityObj.setUsageFunctionkey(tIdExperienceInformationEntity.getPexFunctionalAreaKey());
									tIdWastaUsageReportEntityObj.setUsageRolekey(tIdExperienceInformationEntity.getPexRoleKey());
									tIdWastaUsageReportEntityObj.setUsageCompanykey(tIdExperienceInformationEntity.getPexCompanyCmsKey());
									tIdWastaUsageReportEntityObj.setUsageNoOfNewContact(noOfNewContacts);
									tIdWastaUsageReportEntityObj.setUsageNoOfDiscussion(noOfDiscussionDetails);
									tIdWastaUsageReportEntityObj.setUsageNoOfBusinessPotential(noOfBusinessDetasils);
									tIdWastaUsageReportEntityObj.setUsageNoOfAdditionalService(noOfAdditionalPotential);
									tIdWastaUsageReportEntityObj.setUsageOthers(othersCount);
									tIdWastaUsageReportEntityObj.setUsageDate(todayDate);
									tIdWastaUsageReportEntityObj.setUsageLastBuildDate(new Date());
									tIdWastaUsageReportEntityObj.setLockKey(0l);
									tIdWastaUsageReportEntityObj.setProfileKey(1l);
									listOfTIdWastaUsageReportEntity.add(tIdWastaUsageReportEntityObj);
							}
							
						}else {
							tIdWastaUsageReportEntityObj = new TIdWastaUsageReportEntity();
							tIdWastaUsageReportEntityObj.setUsageUserkey(tIdUserMasterEntity.getUserKey());
							tIdWastaUsageReportEntityObj.setLockKey(0l);
							tIdWastaUsageReportEntityObj.setProfileKey(1l);
							/*
							tIdWastaUsageReportEntityObj.setUsagePinkey(13l);
							tIdWastaUsageReportEntityObj.setUsageStatus(tIdUserMasterEntity.getActiveStatus());
							tIdWastaUsageReportEntityObj.setUsageCompanykey(876l);
							tIdWastaUsageReportEntityObj.setUsageNoOfTotalContact(0l);
							
							tIdWastaUsageReportEntityObj.setUsageDate(new Date());
							tIdWastaUsageReportEntityObj.setUsageLastBuildDate(new Date());
							tIdWastaUsageReportEntityObj.setUsageDesignationkey(1l);
							tIdWastaUsageReportEntityObj.setUsageFunctionkey(221l);
							tIdWastaUsageReportEntityObj.setUsageRolekey(765l);
							tIdWastaUsageReportEntityObj.setUsageNoOfNewContact(0l);
							tIdWastaUsageReportEntityObj.setUsageNoOfDiscussion(0l);
							tIdWastaUsageReportEntityObj.setUsageNoOfBusinessPotential(0l);
							tIdWastaUsageReportEntityObj.setUsageNoOfAdditionalService(0l);
							tIdWastaUsageReportEntityObj.setUsageOthers(0l);
							*/
							listOfTIdWastaUsageReportEntity.add(tIdWastaUsageReportEntityObj);
						}
					}else {
						
						tIdWastaUsageReportEntityObj = new TIdWastaUsageReportEntity();
						tIdWastaUsageReportEntityObj.setUsageUserkey(tIdUserMasterEntity.getUserKey());
						tIdWastaUsageReportEntityObj.setLockKey(0l);
						tIdWastaUsageReportEntityObj.setProfileKey(1l);
						/*
						tIdWastaUsageReportEntityObj.setUsagePinkey(13l);
						tIdWastaUsageReportEntityObj.setUsageStatus(tIdUserMasterEntity.getActiveStatus());
						tIdWastaUsageReportEntityObj.setUsageCompanykey(876l);
						tIdWastaUsageReportEntityObj.setUsageNoOfTotalContact(0l);
						tIdWastaUsageReportEntityObj.setLockKey(0l);
						tIdWastaUsageReportEntityObj.setProfileKey(1l);
						tIdWastaUsageReportEntityObj.setUsageDate(new Date());
						tIdWastaUsageReportEntityObj.setUsageLastBuildDate(new Date());
						tIdWastaUsageReportEntityObj.setUsageDesignationkey(1l);
						tIdWastaUsageReportEntityObj.setUsageFunctionkey(221l);
						tIdWastaUsageReportEntityObj.setUsageRolekey(765l);
						tIdWastaUsageReportEntityObj.setUsageNoOfNewContact(0l);
						tIdWastaUsageReportEntityObj.setUsageNoOfDiscussion(0l);
						tIdWastaUsageReportEntityObj.setUsageNoOfBusinessPotential(0l);
						tIdWastaUsageReportEntityObj.setUsageNoOfAdditionalService(0l);
						tIdWastaUsageReportEntityObj.setUsageOthers(0l);
						*/
						listOfTIdWastaUsageReportEntity.add(tIdWastaUsageReportEntityObj);
						
					}
			}
			tIdWastaUsageReportJpaRepository.save(listOfTIdWastaUsageReportEntity);
			}
	}
	

}

