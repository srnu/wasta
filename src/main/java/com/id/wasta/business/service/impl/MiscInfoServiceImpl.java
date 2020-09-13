package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.ADD_POTENTIAL;
import static com.id.wasta.util.action.CommonConstants.BUSINESS_POTENTIAL;
import static com.id.wasta.util.action.CommonConstants.DELETE_STATUS;
import static com.id.wasta.util.action.CommonConstants.IN_ACTIVE_STATUS;
import static com.id.wasta.util.action.CommonConstants.PENDING_STATUS;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INTEREST;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_PRIORITIES;
import static com.id.wasta.util.action.CommonConstants.PROFESSIONAL_INTEREST;
import static com.id.wasta.util.action.CommonConstants.PROF_EXPERTISE;
import static com.id.wasta.util.action.CommonConstants.RECREATION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdAddPotentialServices;
import com.id.wasta.bean.TIdAddPotentialServicesView;
import com.id.wasta.bean.TIdBusinessPotentialInfo;
import com.id.wasta.bean.TIdBusinessPotentialInfoView;
import com.id.wasta.bean.TIdPersonalInterests;
import com.id.wasta.bean.TIdPersonalInterestsView;
import com.id.wasta.bean.TIdPersonalPriorities;
import com.id.wasta.bean.TIdProfessionalExpertise;
import com.id.wasta.bean.TIdProfessionalExpertiseView;
import com.id.wasta.bean.TIdProfessionalInterests;
import com.id.wasta.bean.TIdProfessionalInterestsView;
import com.id.wasta.bean.TIdRecreationInfo;
import com.id.wasta.bean.TIdRecreationInfoView;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesEntitySearch;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesViewEntity;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoEntitySearch;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoViewEntity;
import com.id.wasta.bean.jpa.TIdCountryMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInterestsEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInterestsViewEntity;
import com.id.wasta.bean.jpa.TIdPersonalPrioritiesEntity;
import com.id.wasta.bean.jpa.TIdPersonalPrioritiesEntitySearch;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseEntitySearch;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseViewEntity;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsEntitySearch;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsViewEntity;
import com.id.wasta.bean.jpa.TIdRecreationInfoEntitySearch;
import com.id.wasta.bean.jpa.TIdRecreationInfoViewEntity;
import com.id.wasta.bean.jpa.TIdRecreationMasterEntitySearch;
import com.id.wasta.bean.jpa.TIdSkillMasterEntitySearch;
import com.id.wasta.business.service.MiscInfoService;
import com.id.wasta.business.service.ShareInfoService;
import com.id.wasta.business.service.mapper.TIdAddPotentialServicesServiceMapper;
import com.id.wasta.business.service.mapper.TIdBusinessPotentialInfoServiceMapper;
import com.id.wasta.business.service.mapper.TIdPersonalInterestsServiceMapper;
import com.id.wasta.business.service.mapper.TIdPersonalPrioritiesServiceMapper;
import com.id.wasta.business.service.mapper.TIdProfessionalExpertiseServiceMapper;
import com.id.wasta.business.service.mapper.TIdProfessionalInterestsServiceMapper;
import com.id.wasta.business.service.mapper.TIdRecreationInfoServiceMapper;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCountryMasterEntitySearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingAddPotentialJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingBusinessPotentialJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalInterestJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalInterestJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingRecreationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdSkillMasterSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterViewJpaRepository;
import com.id.wasta.exception.HandledException;

@Service
@Transactional
public class MiscInfoServiceImpl implements MiscInfoService {

	@Resource
	private TIdAddPotentialServicesServiceMapper tIdAddPotentialServicesServiceMapper;
	@Resource
	private TIdPersonalInformationSearchJpaRepository tIdPersonalInformationEntitySearchJpaRepository;
	@Resource
	private TIdBusinessPotentialInfoServiceMapper tIdBusinessPotentialInfoServiceMapper;
	@Resource
	private TIdPersonalInterestsServiceMapper tIdPersonalInterestsServiceMapper;
	@Resource
	private TIdProfessionalExpertiseServiceMapper tIdProfessionalExpertiseServiceMapper;
	@Resource
	private TIdProfessionalInterestsServiceMapper tIdProfessionalInterestsServiceMapper;
	@Resource
	private TIdRecreationInfoServiceMapper tIdRecreationInfoServiceMapper;
	@Resource
	private TIdRecreationMasterSearchJpaRepository tIdRecreationMasterSearchJpaRepository;
	@Resource
	private TIdSkillMasterSearchJpaRepository tIdSkillMasterSearchJpaRepository;
	@Resource
	private TIdAddPotentialServicesViewJpaRepository tIdAddPotentialServicesViewJpaRepository;

	@Resource
	private TIdPersonalInterestsViewJpaRepository tIdPersonalInterestsViewJpaRepository;
	@Resource
	private TIdProfessionalExpertiseViewJpaRepository tIdProfessionalExpertiseViewJpaRepository;
	@Resource
	private TIdProfessionalInterestsViewJpaRepository tIdProfessionalInterestsViewJpaRepository;
	@Resource
	private TIdRecreationInfoViewJpaRepository tIdRecreationInfoViewJpaRepository;
	@Resource
	private TIdPersonalPrioritiesServiceMapper tIdPersonalPrioritiesServiceMapper;
	@Resource
	private TIdRecreationInfoSearchJpaRepository tIdRecreationInfoSearchJpaRepository;
	@Resource
	private TIdPersonalPrioritiesSearchJpaRepository tIdPersonalPrioritiesSearchJpaRepository;
	@Resource
	private TIdProfessionalInterestsSearchJpaRepository tIdProfessionalInterestsSearchJpaRepository;
	@Resource
	private TIdProfessionalExpertiseSearchJpaRepository tIdProfessionalExpertiseSearchJpaRepository;
	@Resource
	private GenericServiceMapper genericServiceMapper;
	@Resource
	private TIdPersonalInterestsSearchJpaRepository tIdPersonalInterestsSearchJpaRepository;
	@Resource
	private TIdBusinessPotentialInfoSearchJpaRepository tIdBusinessPotentialInfoSearchJpaRepository;
	@Resource
	private TIdAddPotentialServicesSearchJpaRepository tIdAddPotentialServicesSearchJpaRepository;
	@Resource
	private TIdPersonalPrioritiesJpaRepository tIdPersonalPrioritiesJpaRepository;
	@Resource
	private TIdCountryMasterEntitySearchJpaRepository tIdCountryMasterEntitySearchJpaRepository;
	@Resource
	private TIdUserMasterViewJpaRepository tIdUserMasterViewJpaRepository;
	@Resource
	private TIdLandingAddPotentialJpaRepository tIdLandingAddPotentialJpaRepository;
	@Resource
	private TIdLandingBusinessPotentialJpaRepository tIdLandingBusinessPotentialJpaRepository;
	@Resource
	private TIdLandingPersonalInterestJpaRepository tIdLandingPersonalInterestJpaRepository;
	@Resource
	private TIdLandingProfessionalExpertiseJpaRepository tIdLandingProfessionalExpertiseJpaRepository;
	@Resource
	private TIdLandingProfessionalInterestJpaRepository tIdLandingProfessionalInterestJpaRepository;
	@Resource
	private TIdLandingRecreationJpaRepository tIdLandingRecreationJpaRepository;
	@Resource
	private TIdLandingPersonalPrioritiesJpaRepository tIdLandingPersonalPrioritiesJpaRepository;
	@Autowired
	private ShareInfoService shareInfoService;

	@Autowired
	private TIdBusinessPotentialInfoViewJpaRepository tIdBusinessPotentialInfoViewJpaRepository;
	
	@Autowired
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;

	@Override
	public List<TIdAddPotentialServices> savePotentialServicesInfo(List<TIdAddPotentialServices> tIdAddPotentialServices) throws Exception {
		List<TIdAddPotentialServicesEntitySearch> tIdAddPotentialServicesSearchList = null;
		TIdAddPotentialServicesEntitySearch tIdAddPotentialServicesEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearch = null;
		TIdCountryMasterEntitySearch tIdCountryMasterEntitySearch = null;

		for (TIdAddPotentialServices potentialServ : tIdAddPotentialServices) {
			if (potentialServ.getOtherSkillName() != null) {
				if (potentialServ.getApsSkillKey() != null && potentialServ.getApsSkillKey() != 0) {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategoryAndKeyNotIn(potentialServ.getOtherSkillName(), 783L,
									potentialServ.getApsSkillKey());
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							potentialServ.setApsSkillKey(tIdSkillMasterEntitySearch.getKey());
							potentialServ.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Add potential services name already exist!!!");
						}

					} else {
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findOne(potentialServ.getApsSkillKey());
						tIdSkillMasterEntitySearch.setName(potentialServ.getOtherSkillName());
						tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
						potentialServ.setOtherSkillName(null);
					}

				} else {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategory(potentialServ.getOtherSkillName(), 783L);
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							potentialServ.setApsSkillKey(tIdSkillMasterEntitySearch.getKey());
							potentialServ.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Add potential services name already exist!!!");
						}
					}
				}
			}
		}

		for (TIdAddPotentialServices potentialServices : tIdAddPotentialServices) {
			tIdAddPotentialServicesSearchList = new ArrayList<TIdAddPotentialServicesEntitySearch>();
			if (potentialServices.getKey() != null) {
				tIdAddPotentialServicesEntitySearch = tIdAddPotentialServicesSearchJpaRepository
						.findOne(potentialServices.getKey());
			} else {
				tIdAddPotentialServicesEntitySearch = new TIdAddPotentialServicesEntitySearch();
			}

			tIdAddPotentialServicesServiceMapper.mapTIdAddPotentialServicesToTIdAddPotentialServicesEntitySearch(
					potentialServices, tIdAddPotentialServicesEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(potentialServices.getApsPinKey());
			tIdAddPotentialServicesEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);

			if (potentialServices.getOtherSkillName() != null) {
				tIdSkillMasterEntitySearch = new TIdSkillMasterEntitySearch();
				tIdSkillMasterEntitySearch.setName(potentialServices.getOtherSkillName());
				tIdSkillMasterEntitySearch.setLockKey(0L);
				tIdSkillMasterEntitySearch.setProfileKey(1L);
				tIdSkillMasterEntitySearch.setSkillCategory(783L);
				tIdSkillMasterEntitySearch.setActiveFrom(new Date());
				tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
				tIdSkillMasterEntitySearch.setSkillActiveStatusKey(1L);
				tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
				tIdAddPotentialServicesEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearch);

			} else if (potentialServices.getApsSkillKey() != null) {
				tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
						.findOne(potentialServices.getApsSkillKey());
				tIdAddPotentialServicesEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearch);
			}
			if (potentialServices.getApsCityKey() != null) {
				tIdCountryMasterEntitySearch = tIdCountryMasterEntitySearchJpaRepository
						.findOne(potentialServices.getApsCityKey());
				tIdAddPotentialServicesEntitySearch.settIdCountryMasterSearch(tIdCountryMasterEntitySearch);
			}
			tIdAddPotentialServicesSearchList.add(tIdAddPotentialServicesEntitySearch);
			tIdPersonalInformationEntitySearch.setListOfTIdAddPotentialServices(tIdAddPotentialServicesSearchList);
			tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);

			if (potentialServices.getKey() == null) {
				tIdLandingAddPotentialJpaRepository.updateLatestUpdate(potentialServices.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdAddPotentialServices().get(0).getKey());
			}
		}

		return tIdAddPotentialServices;
	}

	@Override
	public List<TIdBusinessPotentialInfo> saveBusinessPotentialInfo(
			List<TIdBusinessPotentialInfo> tIdBusinessPotentialInfo) throws Exception {
		List<TIdBusinessPotentialInfoEntitySearch> tIdBusinessPotentialInfoEntitySearchList = null;
		TIdBusinessPotentialInfoEntitySearch tIdBusinessPotentialInfoEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearchMst = null;
		TIdCountryMasterEntitySearch tIdCountryMasterEntitySearch = null;

		for (TIdBusinessPotentialInfo businessPotential : tIdBusinessPotentialInfo) {
			if (businessPotential.getOtherSkillName() != null) {
				if (businessPotential.getBpiSkillKey() != null && businessPotential.getBpiSkillKey() != 0) {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategoryAndKeyNotIn(businessPotential.getOtherSkillName(), 784L,businessPotential.getBpiSkillKey());
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							businessPotential.setBpiSkillKey(tIdSkillMasterEntitySearch.getKey());
							//usinessPotential.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Business potential name already exist!!!");
						}
					}
					//Commented by Raj as existing approved master data name gets updated which should not 
					/*
						 * else { tIdSkillMasterEntitySearch =
						 * tIdSkillMasterSearchJpaRepository.findOne(businessPotential.getBpiSkillKey());
						 * tIdSkillMasterEntitySearch.setName(businessPotential.getOtherSkillName());
						 * tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						 * tIdSkillMasterEntitySearch =
						 * tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch); }
					*/
					businessPotential.setOtherSkillName(null);
				} else {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategory(businessPotential.getOtherSkillName(), 784L);
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							businessPotential.setBpiSkillKey(tIdSkillMasterEntitySearch.getKey());
							businessPotential.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Business potential name already exist!!!");
						}
					}
				}
			}
		}
		for (TIdBusinessPotentialInfo businessPotentialInfo : tIdBusinessPotentialInfo) {
			tIdBusinessPotentialInfoEntitySearchList = new ArrayList<TIdBusinessPotentialInfoEntitySearch>();
			if (businessPotentialInfo.getKey() != null) {
				tIdBusinessPotentialInfoEntitySearch = tIdBusinessPotentialInfoSearchJpaRepository
						.findOne(businessPotentialInfo.getKey());
			} else {
				tIdBusinessPotentialInfoEntitySearch = new TIdBusinessPotentialInfoEntitySearch();
			}

			tIdBusinessPotentialInfoServiceMapper.mapTIdBusinessPotentialInfoToTIdBusinessPotentialInfoEntitySearch(
					businessPotentialInfo, tIdBusinessPotentialInfoEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(businessPotentialInfo.getBpiPinKey());
			tIdBusinessPotentialInfoEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);

			if (businessPotentialInfo.getOtherSkillName() != null) {
				tIdSkillMasterEntitySearchMst = new TIdSkillMasterEntitySearch();
				tIdSkillMasterEntitySearchMst.setName(businessPotentialInfo.getOtherSkillName());
				tIdSkillMasterEntitySearchMst.setLockKey(0L);
				tIdSkillMasterEntitySearchMst.setProfileKey(1L);
				tIdSkillMasterEntitySearchMst.setSkillCategory(784L);
				tIdSkillMasterEntitySearchMst.setActiveFrom(new Date());
				tIdSkillMasterEntitySearchMst.setActiveStatus(PENDING_STATUS);
				tIdSkillMasterEntitySearchMst.setSkillActiveStatusKey(1L);
				tIdSkillMasterEntitySearchMst = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearchMst);
				tIdBusinessPotentialInfoEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearchMst);

			} else if (businessPotentialInfo.getBpiSkillKey() != null) {
				tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
						.findOne(businessPotentialInfo.getBpiSkillKey());
				tIdBusinessPotentialInfoEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearch);
			}
			if (businessPotentialInfo.getBpiCityKey() != null) {
				tIdCountryMasterEntitySearch = tIdCountryMasterEntitySearchJpaRepository
						.findOne(businessPotentialInfo.getBpiCityKey());
				tIdBusinessPotentialInfoEntitySearch.settIdCountryMasterSearch(tIdCountryMasterEntitySearch);
			}

			tIdBusinessPotentialInfoEntitySearchList.add(tIdBusinessPotentialInfoEntitySearch);
			tIdPersonalInformationEntitySearch
					.setListOfTIdBusinessPotentialInfo(tIdBusinessPotentialInfoEntitySearchList);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.save(tIdPersonalInformationEntitySearch);

			if (businessPotentialInfo.getKey() == null) {
				tIdLandingBusinessPotentialJpaRepository.updateLatestUpdate(businessPotentialInfo.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdBusinessPotentialInfo().get(0).getKey());
			}
		}

		return tIdBusinessPotentialInfo;
	}

	@Override
	public List<TIdPersonalInterests> savePersonalInterestsInfo(List<TIdPersonalInterests> tIdPersonalInterests)
			throws Exception {
		List<TIdPersonalInterestsEntitySearch> tIdPersonalInterestsEntitySearchList = null;
		TIdPersonalInterestsEntitySearch tIdPersonalInterestsEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearchMst = null;

		//Only owner can create the data
		Long contactCreatorPinKey = tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(tIdPersonalInterests.get(0).getPeriPinKey());
		if(contactCreatorPinKey==null || contactCreatorPinKey==0 ) {
			contactCreatorPinKey = tIdPersonalInterests.get(0).getPeriPinKey();
		}
		
		for (TIdPersonalInterests personalInt : tIdPersonalInterests) {
			if (personalInt.getOtherSkillName() != null) {
				if (personalInt.getPeriSkillKey() != null && personalInt.getPeriSkillKey() != 0) {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
							.findByNameAndSkillCategoryAndKeyNotIn(personalInt.getOtherSkillName(), 780L,
									personalInt.getPeriSkillKey());
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							personalInt.setPeriSkillKey(tIdSkillMasterEntitySearch.getKey());
							personalInt.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Personal interests already exist!!!");
						}
					} else {
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findOne(personalInt.getPeriSkillKey());
						tIdSkillMasterEntitySearch.setName(personalInt.getOtherSkillName());
						tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
						personalInt.setOtherSkillName(null);
					}

				} else {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategory(personalInt.getOtherSkillName(), 780L);
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							personalInt.setPeriSkillKey(tIdSkillMasterEntitySearch.getKey());
							personalInt.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Personal interests  already exist!!!");
						}
					}
				}
			}
		}
		for (TIdPersonalInterests personalInterests : tIdPersonalInterests) {
			tIdPersonalInterestsEntitySearchList = new ArrayList<TIdPersonalInterestsEntitySearch>();
			if (personalInterests.getKey() != null) {
				tIdPersonalInterestsEntitySearch = tIdPersonalInterestsSearchJpaRepository
						.findOne(personalInterests.getKey());
			} else {
				tIdPersonalInterestsEntitySearch = new TIdPersonalInterestsEntitySearch();
			}

			tIdPersonalInterestsServiceMapper.mapTIdPersonalInterestsToTIdPersonalInterestsEntitySearch(
					personalInterests, tIdPersonalInterestsEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(personalInterests.getPeriPinKey());
			tIdPersonalInterestsEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdPersonalInterestsEntitySearch.setPeriCreatedBy(contactCreatorPinKey); 
			if (personalInterests.getOtherSkillName() != null) {
				tIdSkillMasterEntitySearchMst = new TIdSkillMasterEntitySearch();
				tIdSkillMasterEntitySearchMst.setName(personalInterests.getOtherSkillName());
				tIdSkillMasterEntitySearchMst.setLockKey(0L);
				tIdSkillMasterEntitySearchMst.setProfileKey(1L);
				tIdSkillMasterEntitySearchMst.setSkillCategory(780L);
				tIdSkillMasterEntitySearchMst.setActiveFrom(new Date());
				tIdSkillMasterEntitySearchMst.setActiveStatus(PENDING_STATUS);
				tIdSkillMasterEntitySearchMst.setSkillActiveStatusKey(1L);
				tIdSkillMasterEntitySearchMst = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearchMst);
				tIdPersonalInterestsEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearchMst);

			} else if (personalInterests.getPeriSkillKey() != null) {
				tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
						.findOne(personalInterests.getPeriSkillKey());
				tIdPersonalInterestsEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearch);
			}

			tIdPersonalInterestsEntitySearchList.add(tIdPersonalInterestsEntitySearch);
			tIdPersonalInformationEntitySearch.setListOfTIdPersonalInterests(tIdPersonalInterestsEntitySearchList);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.save(tIdPersonalInformationEntitySearch);

			if (personalInterests.getKey() == null) {
				tIdLandingPersonalInterestJpaRepository.updateLatestUpdate(personalInterests.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdPersonalInterests().get(0).getKey());
			}
		}

		return tIdPersonalInterests;
	}

	@Override
	public List<TIdProfessionalExpertise> saveProfessionalExpertiseInfo(
			List<TIdProfessionalExpertise> tIdProfessionalExpertise) throws Exception {
		List<TIdProfessionalExpertiseEntitySearch> tIdProfessionalExpertiseEntitySearchList = null;
		TIdProfessionalExpertiseEntitySearch tIdProfessionalExpertiseEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearchMst = null;
 
		//Only owner can create the data
		Long contactCreatorPinKey = tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(tIdProfessionalExpertise.get(0).getPpePinKey());
		
		if(contactCreatorPinKey==null || contactCreatorPinKey==0 ) {
			contactCreatorPinKey = tIdProfessionalExpertise.get(0).getPpePinKey();
		}
		
		for (TIdProfessionalExpertise professionalExp : tIdProfessionalExpertise) {
			if (professionalExp.getOtherSkillName() != null) {
				if (professionalExp.getPpeSkillKey() != null && professionalExp.getPpeSkillKey() != 0) {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategoryAndKeyNotIn(professionalExp.getOtherSkillName(), 782L,professionalExp.getPpeSkillKey());
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							professionalExp.setPpeSkillKey(tIdSkillMasterEntitySearch.getKey());
							professionalExp.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Professional expertise already exist!!!");
						}
					} else {
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findOne(professionalExp.getPpeSkillKey());
						tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdSkillMasterEntitySearch.setName(professionalExp.getOtherSkillName());
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
						professionalExp.setOtherSkillName(null);
					}

				} else {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategory(professionalExp.getOtherSkillName(), 782L);
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							professionalExp.setPpeSkillKey(tIdSkillMasterEntitySearch.getKey());
							professionalExp.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Professional expertise name already exist!!!");
						}
					}
				}
			}
		}
		for (TIdProfessionalExpertise professionalExpertise : tIdProfessionalExpertise) {
			tIdProfessionalExpertiseEntitySearchList = new ArrayList<TIdProfessionalExpertiseEntitySearch>();
			if (professionalExpertise.getKey() != null) {
				tIdProfessionalExpertiseEntitySearch = tIdProfessionalExpertiseSearchJpaRepository
						.findOne(professionalExpertise.getKey());
			} else {
				tIdProfessionalExpertiseEntitySearch = new TIdProfessionalExpertiseEntitySearch();
			}

			tIdProfessionalExpertiseServiceMapper.mapTIdProfessionalExpertiseToTIdProfessionalExpertiseEntitySearch(
					professionalExpertise, tIdProfessionalExpertiseEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(professionalExpertise.getPpePinKey());
			tIdProfessionalExpertiseEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
			//tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(
			tIdProfessionalExpertiseEntitySearch.setPpeCreatedBy(contactCreatorPinKey);
			if (professionalExpertise.getOtherSkillName() != null) {
				tIdSkillMasterEntitySearchMst = new TIdSkillMasterEntitySearch();
				tIdSkillMasterEntitySearchMst.setName(professionalExpertise.getOtherSkillName());
				tIdSkillMasterEntitySearchMst.setLockKey(0L);
				tIdSkillMasterEntitySearchMst.setProfileKey(1L);
				tIdSkillMasterEntitySearchMst.setSkillCategory(782L);
				tIdSkillMasterEntitySearchMst.setActiveFrom(new Date());
				tIdSkillMasterEntitySearchMst.setActiveStatus(PENDING_STATUS);
				tIdSkillMasterEntitySearchMst.setSkillActiveStatusKey(1L);
				tIdSkillMasterEntitySearchMst = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearchMst);
				tIdProfessionalExpertiseEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearchMst);

			} else if (professionalExpertise.getPpeSkillKey() != null) {
				tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
						.findOne(professionalExpertise.getPpeSkillKey());
				tIdProfessionalExpertiseEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearch);
			}

			tIdProfessionalExpertiseEntitySearchList.add(tIdProfessionalExpertiseEntitySearch);
			tIdPersonalInformationEntitySearch
					.setListOfTIdProfessionalExpertise(tIdProfessionalExpertiseEntitySearchList);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.save(tIdPersonalInformationEntitySearch);

			if (professionalExpertise.getKey() == null) {
				tIdLandingProfessionalExpertiseJpaRepository.updateLatestUpdate(professionalExpertise.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdProfessionalExpertise().get(0).getPpeKey());
			}
		}

		return tIdProfessionalExpertise;
	}

	@Override
	public List<TIdProfessionalInterests> saveProfessionalInterestsInfo(
			List<TIdProfessionalInterests> tIdProfessionalInterests) throws Exception {
		List<TIdProfessionalInterestsEntitySearch> tIdProfessionalInterestsEntitySearchList = null;
		TIdProfessionalInterestsEntitySearch tIdProfessionalInterestsEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearch = null;
		TIdSkillMasterEntitySearch tIdSkillMasterEntitySearchMst = null;

		//Only owner can create the data
		Long contactCreatorPinKey = tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(tIdProfessionalInterests.get(0).getPriPinKey());
		if(contactCreatorPinKey==null || contactCreatorPinKey==0 ) {
			contactCreatorPinKey = tIdProfessionalInterests.get(0).getPriPinKey();
		}
		for (TIdProfessionalInterests professionalInt : tIdProfessionalInterests) {
			if (professionalInt.getOtherSkillName() != null) {
				if (professionalInt.getPriSkillKey() != null && professionalInt.getPriSkillKey() != 0) {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findByNameAndSkillCategoryAndKeyNotIn(professionalInt.getOtherSkillName(), 781L,professionalInt.getPriSkillKey());
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							professionalInt.setPriSkillKey(tIdSkillMasterEntitySearch.getKey());
							professionalInt.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Professional interests already exist!!!");
						}
					} else {
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.findOne(professionalInt.getPriSkillKey());
						tIdSkillMasterEntitySearch.setName(professionalInt.getOtherSkillName());
						tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
						professionalInt.setOtherSkillName(null);
					}

				} else {
					tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
							.findByNameAndSkillCategory(professionalInt.getOtherSkillName(), 781L);
					if (tIdSkillMasterEntitySearch != null) {
						if (tIdSkillMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdSkillMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdSkillMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearch);
							professionalInt.setPriSkillKey(tIdSkillMasterEntitySearch.getKey());
							professionalInt.setOtherSkillName(null);
						} else {
							throw new DataIntegrityViolationException("Professional interests already exist!!!");
						}
					}
				}
			}

		}
		for (TIdProfessionalInterests professionalInterests : tIdProfessionalInterests) {
			tIdProfessionalInterestsEntitySearchList = new ArrayList<TIdProfessionalInterestsEntitySearch>();
			if (professionalInterests.getKey() != null) {
				tIdProfessionalInterestsEntitySearch = tIdProfessionalInterestsSearchJpaRepository
						.findOne(professionalInterests.getKey());
			} else {
				tIdProfessionalInterestsEntitySearch = new TIdProfessionalInterestsEntitySearch();
			}

			tIdProfessionalInterestsServiceMapper.mapTIdProfessionalInterestsToTIdProfessionalInterestsEntitySearch(
					professionalInterests, tIdProfessionalInterestsEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(professionalInterests.getPriPinKey());
			tIdProfessionalInterestsEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdProfessionalInterestsEntitySearch.setPriCreatedBy(contactCreatorPinKey);
			if (professionalInterests.getOtherSkillName() != null) {
				tIdSkillMasterEntitySearchMst = new TIdSkillMasterEntitySearch();
				tIdSkillMasterEntitySearchMst.setName(professionalInterests.getOtherSkillName());
				tIdSkillMasterEntitySearchMst.setLockKey(0L);
				tIdSkillMasterEntitySearchMst.setProfileKey(1L);
				tIdSkillMasterEntitySearchMst.setSkillCategory(781L);
				tIdSkillMasterEntitySearchMst.setActiveFrom(new Date());
				tIdSkillMasterEntitySearchMst.setActiveStatus(PENDING_STATUS);
				tIdSkillMasterEntitySearchMst.setSkillActiveStatusKey(1L);
				tIdSkillMasterEntitySearchMst = tIdSkillMasterSearchJpaRepository.save(tIdSkillMasterEntitySearchMst);
				tIdProfessionalInterestsEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearchMst);

			} else if (professionalInterests.getPriSkillKey() != null) {
				tIdSkillMasterEntitySearch = tIdSkillMasterSearchJpaRepository
						.findOne(professionalInterests.getPriSkillKey());
				tIdProfessionalInterestsEntitySearch.settIdSkillMaster(tIdSkillMasterEntitySearch);
			}

			tIdProfessionalInterestsEntitySearchList.add(tIdProfessionalInterestsEntitySearch);
			tIdPersonalInformationEntitySearch
					.setListOfTIdProfessionalInterests(tIdProfessionalInterestsEntitySearchList);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.save(tIdPersonalInformationEntitySearch);

			if (professionalInterests.getKey() == null) {
				tIdLandingProfessionalInterestJpaRepository.updateLatestUpdate(professionalInterests.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdProfessionalInterests().get(0).getPriKey());
			}
		}

		return tIdProfessionalInterests;
	}

	@Override
	public List<TIdRecreationInfo> saveRecreationInfo(List<TIdRecreationInfo> tIdRecreationInfo) throws Exception {
		List<TIdRecreationInfoEntitySearch> tIdRecreationInfoEntitySearchList = null;
		TIdRecreationInfoEntitySearch tIdRecreationInfoEntitySearch = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdRecreationMasterEntitySearch tIdRecreationMasterEntitySearch = null;

		for (TIdRecreationInfo recreationIn : tIdRecreationInfo) {
			if (recreationIn.getOthersRmName() != null) {
				if (recreationIn.getReiRmKey() != null && recreationIn.getReiRmKey() != 0) {
					tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository.findByNameAndKeyNotIn(recreationIn.getOthersRmName(), recreationIn.getReiRmKey());
					if (tIdRecreationMasterEntitySearch != null) {
						if (tIdRecreationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdRecreationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)|| tIdRecreationMasterEntitySearch.getActiveStatus().equals(PENDING_STATUS)) {
							tIdRecreationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository.save(tIdRecreationMasterEntitySearch);
							recreationIn.setReiRmKey(tIdRecreationMasterEntitySearch.getKey());
							recreationIn.setOthersRmName(null);
						} else {
							throw new DataIntegrityViolationException(
									"Recreation name already exist!!! :: " + recreationIn.getOthersRmName());
						}
					} else {
						tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository.findOne(recreationIn.getReiRmKey());
						tIdRecreationMasterEntitySearch.setName(recreationIn.getOthersRmName());
						tIdRecreationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
						tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository.save(tIdRecreationMasterEntitySearch);
						recreationIn.setOthersRmName(null);
					}

				} else {
					tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository.findByName(recreationIn.getOthersRmName());
					if (tIdRecreationMasterEntitySearch != null) {
						if (tIdRecreationMasterEntitySearch.getActiveStatus().equalsIgnoreCase(PENDING_STATUS)|| tIdRecreationMasterEntitySearch.getActiveStatus().equals(DELETE_STATUS)|| tIdRecreationMasterEntitySearch.getActiveStatus().equals(IN_ACTIVE_STATUS)) {
							tIdRecreationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
							tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository.save(tIdRecreationMasterEntitySearch);
							recreationIn.setReiRmKey(tIdRecreationMasterEntitySearch.getKey());
							recreationIn.setOthersRmName(null);
						} else {
							throw new HandledException(
									"Recreation name already exist!!! :: " + recreationIn.getOthersRmName());
						}

					}
				}
			}
		}

		for (TIdRecreationInfo recreationInfo : tIdRecreationInfo) {
			tIdRecreationInfoEntitySearchList = new ArrayList<TIdRecreationInfoEntitySearch>();
			if (recreationInfo.getKey() != null) {
				tIdRecreationInfoEntitySearch = tIdRecreationInfoSearchJpaRepository.findOne(recreationInfo.getKey());
			} else {
				tIdRecreationInfoEntitySearch = new TIdRecreationInfoEntitySearch();
			}

			tIdRecreationInfoServiceMapper.mapTIdRecreationInfoToTIdRecreationInfoEntitySearch(recreationInfo,
					tIdRecreationInfoEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(recreationInfo.getReiPinKey());
			tIdRecreationInfoEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdRecreationInfoEntitySearch.setReiCreatedBy(tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(recreationInfo.getReiPinKey()));
			if (recreationInfo.getOthersRmName() != null) {
				tIdRecreationMasterEntitySearch = new TIdRecreationMasterEntitySearch();
				tIdRecreationMasterEntitySearch.setName(recreationInfo.getOthersRmName());
				tIdRecreationMasterEntitySearch.setActiveStatus(PENDING_STATUS);
				tIdRecreationMasterEntitySearch.setActiveFrom(new Date());
				tIdRecreationMasterEntitySearch.setProfileKey(1L);
				tIdRecreationMasterEntitySearch.setLockKey(0L);
				tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository
						.save(tIdRecreationMasterEntitySearch);
				tIdRecreationInfoEntitySearch.settIdRecreationMaster(tIdRecreationMasterEntitySearch);

			} else if (recreationInfo.getReiRmKey() != null) {
				tIdRecreationMasterEntitySearch = tIdRecreationMasterSearchJpaRepository
						.findOne(recreationInfo.getReiRmKey());
				tIdRecreationInfoEntitySearch.settIdRecreationMaster(tIdRecreationMasterEntitySearch);
			}

			tIdRecreationInfoEntitySearchList.add(tIdRecreationInfoEntitySearch);
			tIdPersonalInformationEntitySearch.setListOfTIdRecreationInfo(tIdRecreationInfoEntitySearchList);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.save(tIdPersonalInformationEntitySearch);

			if (recreationInfo.getKey() == null) {
				tIdLandingRecreationJpaRepository.updateLatestUpdate(recreationInfo.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdRecreationInfo().get(0).getReiKey());
			}
		}

		return tIdRecreationInfo;
	}

	@Override
	public List<TIdPersonalPriorities> savePersonalPriorities(List<TIdPersonalPriorities> tIdPersonalPriorities)
			throws HandledException {
		List<TIdPersonalPrioritiesEntitySearch> tIdPersonalPrioritiesEntitySearchList = null;
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch = null;
		TIdPersonalPrioritiesEntitySearch tIdPersonalPrioritiesEntitySearch = null;

		for (TIdPersonalPriorities personalPrior : tIdPersonalPriorities) {
			Long key = personalPrior.getKey() != null ? personalPrior.getKey() : 0;
			TIdPersonalPrioritiesEntity tIdPersonalPrioritiesEntity = tIdPersonalPrioritiesJpaRepository
					.getbyPinkeyAndPinfonprky(personalPrior.getPerpPinKey(), personalPrior.getPerpInfo(), key);
			if (tIdPersonalPrioritiesEntity != null) {
				throw new HandledException(
						"priorities already available!!! :: " + tIdPersonalPrioritiesEntity.getPerpInfo());
			}
		}

		for (TIdPersonalPriorities personalPriorities : tIdPersonalPriorities) {
			tIdPersonalPrioritiesEntitySearchList = new ArrayList<TIdPersonalPrioritiesEntitySearch>();
			if (personalPriorities.getKey() != null) {
				tIdPersonalPrioritiesEntitySearch = tIdPersonalPrioritiesSearchJpaRepository
						.findOne(personalPriorities.getKey());
			} else {
				tIdPersonalPrioritiesEntitySearch = new TIdPersonalPrioritiesEntitySearch();
			}

			tIdPersonalPrioritiesServiceMapper.mapTIdPersonalPrioritiesToTIdPersonalPrioritiesEntitySearch(
					personalPriorities, tIdPersonalPrioritiesEntitySearch);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.findOne(personalPriorities.getPerpPinKey());
			tIdPersonalPrioritiesEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdPersonalPrioritiesEntitySearch.setPerpCreatedBy(tIdPersonalInformationJpaRepository.getCreatorKeyByPinkey(personalPriorities.getPerpPinKey()));
			tIdPersonalPrioritiesEntitySearch.setPerpValidityDate(personalPriorities.getPerpValidityDate());
			tIdPersonalPrioritiesEntitySearchList.add(tIdPersonalPrioritiesEntitySearch);
			tIdPersonalInformationEntitySearch.setListOfTIdPersonalPriorities(tIdPersonalPrioritiesEntitySearchList);
			tIdPersonalInformationEntitySearch = tIdPersonalInformationEntitySearchJpaRepository
					.save(tIdPersonalInformationEntitySearch);

			if (personalPriorities.getKey() == null) {
				tIdLandingPersonalPrioritiesJpaRepository.updateLatestUpdate(personalPriorities.getAuditJson(),
						tIdPersonalInformationEntitySearch.getListOfTIdPersonalPriorities().get(0).getKey());
			}
		}

		return tIdPersonalPriorities;
	}

	@Override
	public AccessBlocks getPotentialServicesInfo(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdAddPotentialServicesViewEntity> tIdAddPotentialServicesViewEntityList = tIdAddPotentialServicesViewJpaRepository
				.getPotentialServices(dashBoardRequest.getPinKey());
		TIdAddPotentialServicesView tIdAddPotentialServicesView = null;
		List<TIdAddPotentialServicesView> tIdAddPotentialServicesViewList = new ArrayList<TIdAddPotentialServicesView>();
		for (TIdAddPotentialServicesViewEntity tIdAddPotentialServicesViewEntity : tIdAddPotentialServicesViewEntityList) {
			tIdAddPotentialServicesView = genericServiceMapper.map(tIdAddPotentialServicesViewEntity,TIdAddPotentialServicesView.class);
			if(dashBoardRequest.getLoginPinKey().equals(tIdAddPotentialServicesView.getApsCreatedBy())){
				tIdAddPotentialServicesView.setEditAccessFlag(true);
				tIdAddPotentialServicesView.setViewAccessFlag(true);
			}else {
				tIdAddPotentialServicesView.setEditAccessFlag(false);
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdAddPotentialServicesView.getKey(), 
												tIdAddPotentialServicesView.getApsCreatedBy(),
												tIdAddPotentialServicesView.getApsPinKey(),
												ADD_POTENTIAL,"");
				tIdAddPotentialServicesView.setViewAccessFlag(viewAccessGranted);
			}
			tIdAddPotentialServicesViewList.add(tIdAddPotentialServicesView);
		}
		accessBlocks.setPotentialServicesList(tIdAddPotentialServicesViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getBusinessPotential(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdBusinessPotentialInfoViewEntity> tIdBusinessPotentialInfoViewEntityList = tIdBusinessPotentialInfoViewJpaRepository
																							.getBusinessPotential(dashBoardRequest.getPinKey());
		List<TIdBusinessPotentialInfoView> tIdBusinessPotentialInfoViewList = new ArrayList<TIdBusinessPotentialInfoView>();
		for (TIdBusinessPotentialInfoViewEntity tIdBusinessPotentialInfoViewEntity : tIdBusinessPotentialInfoViewEntityList) {
			TIdBusinessPotentialInfoView tIdBusinessPotentialInfoView = genericServiceMapper.map(tIdBusinessPotentialInfoViewEntity,TIdBusinessPotentialInfoView.class);
			if(dashBoardRequest.getLoginPinKey().equals(tIdBusinessPotentialInfoView.getBpiCreatedBy())){
				tIdBusinessPotentialInfoView.setEditAccessFlag(true);
				tIdBusinessPotentialInfoView.setViewAccessFlag(true);
			}else {
				tIdBusinessPotentialInfoView.setEditAccessFlag(false);
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdBusinessPotentialInfoView.getKey(), 
												tIdBusinessPotentialInfoViewEntity.getBpiCreatedBy(),
												tIdBusinessPotentialInfoView.getBpiPinKey(),
												BUSINESS_POTENTIAL, "");
				tIdBusinessPotentialInfoView.setViewAccessFlag(viewAccessGranted);
			}
			tIdBusinessPotentialInfoViewList.add(tIdBusinessPotentialInfoView);
		}
		accessBlocks.setBusinessPotentialList(tIdBusinessPotentialInfoViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getPersonalInterests(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdPersonalInterestsViewEntity> tIdPersonalInterestsViewEntityList = tIdPersonalInterestsViewJpaRepository
				.getPersonalInterests(dashBoardRequest.getPinKey());
		TIdPersonalInterestsView tIdPersonalInterestsView = null;
		List<TIdPersonalInterestsView> tIdPersonalInterestsViewList = new ArrayList<TIdPersonalInterestsView>();
		for (TIdPersonalInterestsViewEntity tIdPersonalInterestsViewEntity : tIdPersonalInterestsViewEntityList) {
			tIdPersonalInterestsView = genericServiceMapper.map(tIdPersonalInterestsViewEntity,TIdPersonalInterestsView.class);
			if(dashBoardRequest.getLoginPinKey().equals(tIdPersonalInterestsView.getPeriCreatedBy())) {
				tIdPersonalInterestsView.setViewAccessFlag(true);
			}else {
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdPersonalInterestsView.getKey(), 
												tIdPersonalInterestsView.getPeriCreatedBy(),
												tIdPersonalInterestsView.getPeriPinKey(),
												PERSONAL_INTEREST, "");
				tIdPersonalInterestsView.setViewAccessFlag(viewAccessGranted);
			}
			tIdPersonalInterestsViewList.add(tIdPersonalInterestsView);
		}
		accessBlocks.setPersonalInterestList(tIdPersonalInterestsViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getProfessionalExpertise(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdProfessionalExpertiseViewEntity> tIdProfessionalExpertiseViewEntityList = tIdProfessionalExpertiseViewJpaRepository
				.getProfessionalExpertise(dashBoardRequest.getPinKey());
		TIdProfessionalExpertiseView tIdProfessionalExpertiseView = null;
		List<TIdProfessionalExpertiseView> tIdProfessionalExpertiseViewList = new ArrayList<TIdProfessionalExpertiseView>();
		for (TIdProfessionalExpertiseViewEntity tIdProfessionalExpertiseViewEntity : tIdProfessionalExpertiseViewEntityList) {
			tIdProfessionalExpertiseView = genericServiceMapper.map(tIdProfessionalExpertiseViewEntity, TIdProfessionalExpertiseView.class);
			if(dashBoardRequest.getLoginPinKey().equals(tIdProfessionalExpertiseView.getPpeCreatedBy()) ) { 
				tIdProfessionalExpertiseView.setViewAccessFlag(true);
			}else {
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdProfessionalExpertiseView.getKey(), 
												tIdProfessionalExpertiseView.getPpeCreatedBy(),
												tIdProfessionalExpertiseView.getPpePinKey(),
												PROF_EXPERTISE, null);
				tIdProfessionalExpertiseView.setViewAccessFlag(viewAccessGranted);
			}
			tIdProfessionalExpertiseViewList.add(tIdProfessionalExpertiseView);
		}
		accessBlocks.setProfExpertiseList(tIdProfessionalExpertiseViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getProfessionalInterests(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdProfessionalInterestsViewEntity> tIdProfessionalInterestsViewEntityList = tIdProfessionalInterestsViewJpaRepository
				.getProfessionalInterests(dashBoardRequest.getPinKey());
		TIdProfessionalInterestsView tIdProfessionalInterestsView = null;
		List<TIdProfessionalInterestsView> tIdProfessionalInterestsViewList = new ArrayList<TIdProfessionalInterestsView>();
		for (TIdProfessionalInterestsViewEntity tIdProfessionalInterestsViewEntity : tIdProfessionalInterestsViewEntityList) {
			tIdProfessionalInterestsView = new TIdProfessionalInterestsView();
			tIdProfessionalInterestsView = genericServiceMapper.map(tIdProfessionalInterestsViewEntity, TIdProfessionalInterestsView.class);
			System.out.println(tIdProfessionalInterestsView.getPriCreatedBy()+"---------------------------");
			if(dashBoardRequest.getLoginPinKey().equals(tIdProfessionalInterestsView.getPriCreatedBy())){
				tIdProfessionalInterestsView.setViewAccessFlag(true);
			}else {
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdProfessionalInterestsView.getKey(), 
												tIdProfessionalInterestsView.getPriCreatedBy(),
												tIdProfessionalInterestsView.getPriPinKey(),
												PROFESSIONAL_INTEREST, "");
				tIdProfessionalInterestsView.setViewAccessFlag(viewAccessGranted);
			}
			tIdProfessionalInterestsViewList.add(tIdProfessionalInterestsView);
		}
		accessBlocks.setProfInterestList(tIdProfessionalInterestsViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getRecreationInfo(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdRecreationInfoViewEntity> tIdRecreationInfoViewEntityList = tIdRecreationInfoViewJpaRepository
				.getRecreationInfo(dashBoardRequest.getPinKey());
		TIdRecreationInfoView tIdRecreationInfoView = null;
		List<TIdRecreationInfoView> tIdRecreationInfoViewList = new ArrayList<TIdRecreationInfoView>();
		for (TIdRecreationInfoViewEntity tIdRecreationInfoViewEntity : tIdRecreationInfoViewEntityList) {
			tIdRecreationInfoView = genericServiceMapper.map(tIdRecreationInfoViewEntity, TIdRecreationInfoView.class);
			if(dashBoardRequest.getLoginPinKey().equals(tIdRecreationInfoView.getReiCreatedBy())){
				tIdRecreationInfoView.setViewAccessFlag(true);
			}else {
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdRecreationInfoView.getKey(), 
												tIdRecreationInfoView.getReiCreatedBy(),
												tIdRecreationInfoView.getReiPinKey(),
												RECREATION, "");
				tIdRecreationInfoView.setViewAccessFlag(viewAccessGranted);
			}
			tIdRecreationInfoViewList.add(tIdRecreationInfoView);
		}
		accessBlocks.setRecreationList(tIdRecreationInfoViewList);
		return accessBlocks;
	}

	@Override
	public AccessBlocks getPersonalPrioritiesInfo(DashBoardRequestBean dashBoardRequest) {
		AccessBlocks accessBlocks = new AccessBlocks();
		List<TIdPersonalPrioritiesEntity> tIdPersonalPrioritiesEntityList = tIdPersonalPrioritiesJpaRepository
				.findByPerpPinKey(dashBoardRequest.getPinKey());
		TIdPersonalPriorities tIdPersonalPriorities = null;
		List<TIdPersonalPriorities> tIdPersonalPrioritiesList = new ArrayList<TIdPersonalPriorities>();
		for (TIdPersonalPrioritiesEntity tIdPersonalPrioritiesEntity : tIdPersonalPrioritiesEntityList) {
			tIdPersonalPriorities = genericServiceMapper.map(tIdPersonalPrioritiesEntity, TIdPersonalPriorities.class);
			if(dashBoardRequest.getLoginPinKey().equals(tIdPersonalPriorities.getPerpCreatedBy())){
				tIdPersonalPriorities.setViewAccessFlag(true);
			}else {
				boolean viewAccessGranted = shareInfoService.chkShareInfoDtls(
												dashBoardRequest.getLoginPinKey(),
												tIdPersonalPriorities.getKey(), 
												tIdPersonalPriorities.getPerpCreatedBy(),
												tIdPersonalPriorities.getPerpPinKey(),
												PERSONAL_PRIORITIES, "");
				tIdPersonalPriorities.setViewAccessFlag(viewAccessGranted);
			}
			tIdPersonalPrioritiesList.add(tIdPersonalPriorities);
		}
		accessBlocks.setPersonalPriorityList(tIdPersonalPrioritiesList);
		return accessBlocks;
	}

}
/*if (!dashBoardRequest.isCurrentUser()) {

}*/