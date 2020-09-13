package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.bean.common.SelectListBean;
import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.OverallRatingBean;
import com.id.wasta.bean.TIdMyContactsLink;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdLandingNotificationEntity;
import com.id.wasta.bean.jpa.TIdMyContactsLinkEntity;
import com.id.wasta.bean.jpa.TIdMyContactsLinkViewEntity;
import com.id.wasta.business.service.MyContactInfoService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingNotificationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdMyContactsLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdMyContactsLinkViewJpaRepository;

@Service
@Transactional
public class MyContactInfoServiceImpl implements MyContactInfoService {

	@Resource
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	
	@Resource
	private TIdMyContactsLinkJpaRepository tIdMyContactsLinkJpaRepository;
	
	@Resource
	private TIdMyContactsLinkViewJpaRepository tIdMyContactsLinkViewJpaRepository;
	
	@Resource
	private GenericServiceMapper genericServiceMapper;
	
	
	@Resource
	private TIdLandingNotificationJpaRepository tIdLandingNotificationJpaRepository;
	
	
	
	@Override
	public List<SelectListBean> getCustDtlsWithExpInfo() {
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		SelectListBean selectListBean = null;
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = (List<PersonIndividualExperienceViewEntity>)
				personIndividualExperienceViewJpaRepository.findAll();
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
	public String saveOrUpdateMycontact(TIdMyContactsLink tIdMyContactsLink) {
		TIdMyContactsLinkEntity tIdMyContactsLinkEntity=tIdMyContactsLinkJpaRepository.findByMclFromPinKeyAndMclToPinKey(tIdMyContactsLink.getMclFromPinKey(),tIdMyContactsLink.getMclToPinKey());
		if(tIdMyContactsLinkEntity==null) {
			tIdMyContactsLinkEntity = new TIdMyContactsLinkEntity();
			
			tIdMyContactsLinkEntity.setMclFromPinKey(tIdMyContactsLink.getMclFromPinKey());//logged userPinkey
			tIdMyContactsLinkEntity.setMclToPinKey(tIdMyContactsLink.getMclToPinKey());//contactPinkey
			tIdMyContactsLinkEntity.setLockKey(0L);
			tIdMyContactsLinkEntity.setProfileKey(1L);
		}
		tIdMyContactsLinkEntity.setActiveStatus(tIdMyContactsLink.getActiveStatus());
		tIdMyContactsLinkEntity.setMclStarRating(tIdMyContactsLink.getMclStarRating()!=null?tIdMyContactsLink.getMclStarRating():0L);
		tIdMyContactsLinkEntity=tIdMyContactsLinkJpaRepository.save(tIdMyContactsLinkEntity);
		/*
		 * Based userPinkey and contacPinkey getLandingNotifiction object and setting 
		 */
		if(tIdMyContactsLinkEntity!=null) {
			 TIdLandingNotificationEntity  tIdLandingNotificationEntityObj = tIdLandingNotificationJpaRepository.getNotification(tIdMyContactsLinkEntity.getMclFromPinKey(),tIdMyContactsLinkEntity.getMclToPinKey());
			if(tIdLandingNotificationEntityObj!=null) {
				tIdLandingNotificationEntityObj.setLdReadFlag(true);
				tIdLandingNotificationJpaRepository.save(tIdLandingNotificationEntityObj);
			}
		}
		return "Success";
	}

	@Override
	public boolean removeMycontact(TIdMyContactsLink tIdMyContactsLink) {
		tIdMyContactsLinkJpaRepository.removeMyContact(tIdMyContactsLink.getMclFromPinKey(),tIdMyContactsLink.getMclToPinKey());
		return true;
	}
	
	@Override
	public TIdMyContactsLinkEntity checkMyContact(TIdMyContactsLink tIdMyContactsLink) {
		return tIdMyContactsLinkJpaRepository.findByMclFromPinKeyAndMclToPinKeyAndActiveStatus(tIdMyContactsLink.getMclFromPinKey(),tIdMyContactsLink.getMclToPinKey(),"A");
	}

	@Override
	public List<TIdMyContactsLinkViewEntity> listOfMyContact(TIdMyContactsLink tIdMyContactsLink) {
		List<TIdMyContactsLinkViewEntity> selectListBean=tIdMyContactsLinkViewJpaRepository.getCustInfo(tIdMyContactsLink.getMclToPinKey());
		return selectListBean;
	}

	@Override
	public OverallRatingBean connectionDtls(TIdMyContactsLink tIdMyContactsLink) {
		List<TIdMyContactsLinkEntity> listOfTIdMyContactsLinkEntity=tIdMyContactsLinkJpaRepository.findByMclToPinKeyAndActiveStatus(tIdMyContactsLink.getMclToPinKey(),"A");
		long count = 0;
		float sum, total =0;
		double rating=0.0;
		if(listOfTIdMyContactsLinkEntity!=null && listOfTIdMyContactsLinkEntity.size()>0){
			count=tIdMyContactsLinkJpaRepository.getNoOfRecord(tIdMyContactsLink.getMclToPinKey());
	        sum=tIdMyContactsLinkJpaRepository.sumOverAllRating(tIdMyContactsLink.getMclToPinKey());
			if(count>0 && sum>0){
				total=sum/count;
				rating=checkRangeForRating(total);
			}
		}
		OverallRatingBean overallRatingBean=new OverallRatingBean();
		overallRatingBean.setNoOfConnection(count);
		overallRatingBean.setOverAllRating(rating);
		return overallRatingBean;
	}

	private double checkRangeForRating(float total) {
		double rating=0.0;
		if(total<=0.24)
			rating=0;
		else if(total>=0.25 && total <=0.74)
			rating= 0.5;
		else if(total>=0.75 && total <=1.24)
			rating= 1;
		else if(total>=1.25 && total <=1.74)
			rating= 1.5;
		else if(total>=1.75 && total <=2.24)
			rating= 2;
		else if(total>=2.25 && total <=2.74)
			rating= 2.5;
		else if(total>=2.75 && total <=3.24)
			rating= 3;
		else if(total>=3.25 && total <=3.74)
			rating= 3.5;
		else if(total>=3.75 && total <=4.24)
			rating= 4;
		else if(total>=4.25 && total <=4.74)
			rating= 4.5;
		else if(total>=4.75 && total <=5.00)
			rating= 5;
		return rating;
	}

}
