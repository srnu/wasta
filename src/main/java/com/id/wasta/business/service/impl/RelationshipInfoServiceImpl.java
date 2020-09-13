package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.id.wasta.bean.TIdRelationshipInformation;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailEntity;
import com.id.wasta.bean.jpa.TIdReferenceCodesHeaderEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdRelationshipInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdRelationshipInformationViewEntity;
import com.id.wasta.business.service.RelationshipInfoService;
import com.id.wasta.business.service.mapper.TIdRelationshipInformationSearchServiceMapper;
import com.id.wasta.business.service.mapper.TIdRelationshipInformationServiceMapper;
import com.id.wasta.data.repository.jpa.TIdLandingPersonalRelationshipsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingProfessionalRelationshipJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesHeaderJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationSearchJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterViewJpaRepository;

@Service
@Transactional
public class RelationshipInfoServiceImpl implements RelationshipInfoService {

	@Resource
	private TIdRelationshipInformationServiceMapper tIdRelationshipInformationServiceMapper;
	@Resource
	private TIdRelationshipInformationJpaRepository tIdRelationshipInformationJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	@Resource
	private TIdRelationshipInformationViewJpaRepository tIdRelationshipInformationViewJpaRepository;
	@Resource
	private TIdPersonalInformationSearchJpaRepository tIdPersonalInformationEntitySearchJpaRepository;
	@Resource
	private TIdRelationshipInformationSearchJpaRepository tIdRelationshipInformationSearchJpaRepository;
	@Resource
	private TIdRelationshipInformationSearchServiceMapper tIdRelationshipInformationSearchServiceMapper;
	@Resource
	private TIdReferenceCodesHeaderJpaRepository tIdReferenceCodesHeaderJpaRepository;
	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	@Resource
	private TIdUserMasterViewJpaRepository tIdUserMasterViewJpaRepository;
	@Resource
	private TIdLandingPersonalRelationshipsJpaRepository tIdLandingPersonalRelationshipsJpaRepository;
	@Resource
	private TIdLandingProfessionalRelationshipJpaRepository tIdLandingProfessionalRelationshipJpaRepository;
	
	@Override
	public TIdRelationshipInformation saveRelationshipDtls(TIdRelationshipInformation tIdRelationshipInformation)throws Exception {
		
		TIdRelationshipInfoLinkEntitySearch tIdRelationshipInfoLinkEntitySearch =new TIdRelationshipInfoLinkEntitySearch();
		List<TIdRelationshipInfoLinkEntitySearch> tIdRelationshipInfoLinkEntitySearchList =new ArrayList<>();
		List<TIdRelationshipInfoLinkEntity> tIdRelationshipInfoLinkEntityList2 =new ArrayList<TIdRelationshipInfoLinkEntity>();
		if(("Father").equals(tIdRelationshipInformation.getRelationShip()) || ("Mother").equals(tIdRelationshipInformation.getRelationShip())){
			tIdRelationshipInfoLinkEntityList2=tIdRelationshipInfoLinkJpaRepository.getDetails(tIdRelationshipInformation.getRelationShip(),tIdRelationshipInformation.getPrlPinKey(),"A");
			if(tIdRelationshipInfoLinkEntityList2!=null && tIdRelationshipInfoLinkEntityList2.size()>=1){
				throw new DataIntegrityViolationException("Relationship already exist");
			}
		}
	
		TIdReferenceCodesDetailEntity  tIdReferenceCodesDetail = null;
		List<TIdRelationshipInformationEntitySearch> tIdRelationshipInformationEntitySearchList=new ArrayList<>();
		TIdRelationshipInformationEntitySearch tIdRelationshipInformationEntitySearch =new TIdRelationshipInformationEntitySearch();
		tIdRelationshipInformationSearchServiceMapper.mapTIdRelationshipInformationToTIdRelationshipInformationEntitySearch(tIdRelationshipInformation, tIdRelationshipInformationEntitySearch);
		TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.findOne(tIdRelationshipInformation.getPrlPinKey());
		tIdRelationshipInformationEntitySearch.setTIdPersonalInformation(tIdPersonalInformationEntitySearch);
		tIdRelationshipInformationEntitySearch.setActiveStatus("A");
		TIdReferenceCodesDetailEntity tIdReferenceCodesDetailEntity=null;
		TIdReferenceCodesHeaderEntity tIdReferenceCodesHeader = null;
		
		if(tIdRelationshipInformation.getOtherTitleName()!=null) {
			tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Title");
			tIdReferenceCodesDetailEntity=tIdReferenceCodesDetailJpaRepository.findByRcdHeaderKeyAndRcdValue(tIdReferenceCodesHeader.getRchHeaderKey(), tIdRelationshipInformation.getOtherTitleName());
			if(tIdReferenceCodesDetailEntity!=null){
				if(tIdReferenceCodesDetailEntity.getActiveStatus().equalsIgnoreCase("P")) {
					tIdRelationshipInformation.setPrlTitle(tIdReferenceCodesDetailEntity.getRcdDetailKey());
					tIdRelationshipInformation.setOtherTitleName(null);
				} else {
					throw new DataIntegrityViolationException("Title name already exist!!!");
				}
			}
		}
		
		if(tIdRelationshipInformation.getPrlKey()==null) {
			/*personal information save start*/
			TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch2 = new TIdPersonalInformationEntitySearch();
			if(tIdRelationshipInformation.getOtherTitleName()!=null)
			{
				tIdReferenceCodesDetail = new TIdReferenceCodesDetailEntity();
				tIdReferenceCodesHeader=tIdReferenceCodesHeaderJpaRepository.findByRchDomainName("Title");
				tIdReferenceCodesDetail.setRcdHeaderKey(tIdReferenceCodesHeader.getRchHeaderKey());
				tIdReferenceCodesDetail.setRcdAbbreviation(tIdRelationshipInformation.getOtherTitleName());
				tIdReferenceCodesDetail.setRcdValue(tIdRelationshipInformation.getOtherTitleName());
				tIdReferenceCodesDetail.setRcdMeaning(tIdRelationshipInformation.getOtherTitleName());
				tIdReferenceCodesDetail.setRcdLowRange(0L);
				tIdReferenceCodesDetail.setRcdHighRange(0L);
				tIdReferenceCodesDetail.setRcdOrderBy(0L);
				tIdReferenceCodesDetail.setActiveStatus("P");
				tIdReferenceCodesDetail.setRcdSetAsDefault("N");
				tIdReferenceCodesDetail.setProfileKey(1L);
				tIdReferenceCodesDetail.setLockKey(0L);
				tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.save(tIdReferenceCodesDetail);
				tIdPersonalInformationEntitySearch2.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
				tIdRelationshipInformationEntitySearch.setTIdReferenceCodesDetail(tIdReferenceCodesDetail);
			
			} else {
				tIdReferenceCodesDetail=tIdReferenceCodesDetailJpaRepository.findOne(tIdRelationshipInformation.getPrlTitle());
				tIdPersonalInformationEntitySearch2.settIdReferenceCodesDetail(tIdReferenceCodesDetail);
				tIdRelationshipInformationEntitySearch.setTIdReferenceCodesDetail(tIdReferenceCodesDetail);
			}
			
			tIdPersonalInformationEntitySearch2.setPinFirstName(tIdRelationshipInformation.getPrlFirstName());
			tIdPersonalInformationEntitySearch2.setPinLastName(tIdRelationshipInformation.getPrlLastName());
			tIdPersonalInformationEntitySearch2.setPinCreatorKey(tIdRelationshipInformation.getPinCreatorKey());
			tIdPersonalInformationEntitySearch2.setActiveStatus("A");
			tIdPersonalInformationEntitySearch2.setProfileKey(tIdRelationshipInformation.getProfileKey());
			tIdPersonalInformationEntitySearch2 = tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch2);
			
			tIdRelationshipInformation.setRelationPinKey(tIdPersonalInformationEntitySearch2.getPinKey());
			/*personal information save end*/
			
			tIdRelationshipInfoLinkEntitySearch.setTIdRelationshipInformation(tIdRelationshipInformationEntitySearch);
			tIdRelationshipInfoLinkEntitySearch.setPrlkRelationType(tIdRelationshipInformation.getRelationType());
			tIdRelationshipInfoLinkEntitySearch.setPrlkRelationship(tIdRelationshipInformation.getRelationShip());
			tIdRelationshipInfoLinkEntitySearch.settIdPersonalInformation(tIdPersonalInformationEntitySearch);
			tIdRelationshipInfoLinkEntitySearch.setPrlkToPinKey(tIdPersonalInformationEntitySearch2.getPinKey());
			tIdRelationshipInfoLinkEntitySearch.setPrlkContact(0L);
			tIdRelationshipInfoLinkEntitySearch.setActiveStatus("A");
			tIdRelationshipInfoLinkEntitySearch.setProfileKey(tIdRelationshipInformation.getProfileKey());
			tIdRelationshipInfoLinkEntitySearchList.add(tIdRelationshipInfoLinkEntitySearch);
			tIdRelationshipInformationEntitySearch.setListOfTIdRelationshipInfoLink(tIdRelationshipInfoLinkEntitySearchList);
		}
		
		tIdRelationshipInformationEntitySearchList.add(tIdRelationshipInformationEntitySearch);
		tIdPersonalInformationEntitySearch.setListOfTIdRelationshipInformation(tIdRelationshipInformationEntitySearchList);
		tIdPersonalInformationEntitySearch=tIdPersonalInformationEntitySearchJpaRepository.save(tIdPersonalInformationEntitySearch);
		
		if(tIdRelationshipInformation.getPrlKey() == null) {
			if("Personal".equals(tIdRelationshipInformation.getRelationType())) {
				tIdLandingPersonalRelationshipsJpaRepository.updateLatestUpdate(tIdRelationshipInformation.getAuditJson(), 
						tIdPersonalInformationEntitySearch.getListOfTIdRelationshipInformation().get(0).getListOfTIdRelationshipInfoLink().get(0).getPrlkKey());
			}
			if("Professional".equals(tIdRelationshipInformation.getRelationType())) {
				tIdLandingProfessionalRelationshipJpaRepository.updateLatestUpdate(tIdRelationshipInformation.getAuditJson(), 
						tIdPersonalInformationEntitySearch.getListOfTIdRelationshipInformation().get(0).getListOfTIdRelationshipInfoLink().get(0).getPrlkKey());
			}
		}
		
		if(tIdRelationshipInformation.getPrlKey()==null) {
			tIdRelationshipInformation.setPrlLinkKey(tIdPersonalInformationEntitySearch.getListOfTIdRelationshipInformation().get(0).getListOfTIdRelationshipInfoLink().get(0).getPrlkKey());
		}
		tIdRelationshipInformation.setPrlKey(tIdPersonalInformationEntitySearch.getListOfTIdRelationshipInformation().get(0).getPrlKey());
		return tIdRelationshipInformation;
	}

	@Override
	public TIdRelationshipInformationViewEntity relationViewDtls(Long relationId) {
		TIdRelationshipInfoLinkEntity tIdRelationshipInfoLinkEntity = tIdRelationshipInfoLinkJpaRepository.findOne(relationId);
		if(tIdRelationshipInfoLinkEntity!=null) {
			return tIdRelationshipInformationViewJpaRepository.findOne(tIdRelationshipInfoLinkEntity.getPrlkPrlKey());
		}
		return null;
	}

	@Override
	public boolean chkRelationStatus(Long fromPinKey, Long toPinKey) {
		List<TIdRelationshipInfoLinkEntity>  tIdRelationshipInfoLinkEntityList = tIdRelationshipInfoLinkJpaRepository.checkRelationStatus(fromPinKey, toPinKey);
		if(tIdRelationshipInfoLinkEntityList.size()>0) {
			return true;
		}
		return false;
	}
	
}
