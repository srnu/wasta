package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.bean.common.SelectListBean;
import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.TIdVisitInformationView;
import com.id.wasta.bean.TIdVisitRemarks;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdVisitInformationViewEntity;
import com.id.wasta.bean.jpa.TIdVisitRemarksEntity;
import com.id.wasta.business.service.DiscussionInfoService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalRelationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitRemarksJpaRepository;

@Service
@Transactional
public class DiscussionInfoServiceImpl implements DiscussionInfoService {

	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	
	@Resource
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	
	@Resource
	private TIdPersonalRelationViewJpaRepository tIdPersonalRelationViewJpaRepository;
	
	@Resource
	private TIdVisitInformationViewJpaRepository tIdVisitInformationViewJpaRepository;
	
	@Resource
	private TIdUserMasterViewJpaRepository tIdUserMasterViewJpaRepository;
	
	@Resource
	private TIdVisitRemarksJpaRepository tIdVisitRemarksJpaRepository;
	
	@Resource
	private GenericServiceMapper genericServiceMapper;
	
	@Override
	public String getDiscussionRelation(Long pinKey) {
		
		return tIdReferenceCodesDetailJpaRepository.getRelation(pinKey)+" of "+ tIdPersonalRelationViewJpaRepository.getRelationCompanyName(pinKey);
	}

	@Override
	public List<SelectListBean> getDiscussionCustInfo(Long profileKey) {
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		SelectListBean selectListBean = null;
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = (List<PersonIndividualExperienceViewEntity>)
				personIndividualExperienceViewJpaRepository.findByProfileKey(profileKey);
		String lastName, designation, company;
		
		for(PersonIndividualExperienceViewEntity PersonIndividualExperienceViewEntity : personIndividualExperienceViewEntityList) {
			selectListBean = new SelectListBean();
			selectListBean.setId(PersonIndividualExperienceViewEntity.getPinKey());
			selectListBean.setCode(PersonIndividualExperienceViewEntity.getPinFirstName());
			
			lastName = PersonIndividualExperienceViewEntity.getPinLastName()!=null?" "+PersonIndividualExperienceViewEntity.getPinLastName():"";
			designation = PersonIndividualExperienceViewEntity.getDesignation()!=null?" - "+PersonIndividualExperienceViewEntity.getDesignation():"";
			company = PersonIndividualExperienceViewEntity.getCompany()!=null?" - "+PersonIndividualExperienceViewEntity.getCompany():"";
			
			selectListBean.setName(PersonIndividualExperienceViewEntity.getPinFirstName()+lastName+designation+company); 
			selectListBeanList.add(selectListBean);
		}
		return selectListBeanList;
	}

	@Override
	public List<SelectListBean> getDiscussionCustInfoAllDtls() {
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		SelectListBean selectListBean = null;
		List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = (List<PersonIndividualExperienceViewEntity>)
				personIndividualExperienceViewJpaRepository.findByUserKey(0L);
		String lastName, designation, company;
		
		for(PersonIndividualExperienceViewEntity PersonIndividualExperienceViewEntity : personIndividualExperienceViewEntityList) {
			selectListBean = new SelectListBean();
			selectListBean.setId(PersonIndividualExperienceViewEntity.getPinKey());
			selectListBean.setCode(PersonIndividualExperienceViewEntity.getPinFirstName());
			
			lastName = PersonIndividualExperienceViewEntity.getPinLastName()!=null?" "+PersonIndividualExperienceViewEntity.getPinLastName():"";
			designation = PersonIndividualExperienceViewEntity.getDesignation()!=null?" - "+PersonIndividualExperienceViewEntity.getDesignation():"";
			company = PersonIndividualExperienceViewEntity.getCompany()!=null?" - "+PersonIndividualExperienceViewEntity.getCompany():"";
			
			selectListBean.setName(PersonIndividualExperienceViewEntity.getPinFirstName()+lastName+designation+company); 
			selectListBeanList.add(selectListBean);
		}
		return selectListBeanList;
	}
	
	@Override
	public List<SelectListBean> getDiscussionUserInfoAllDtls() {

		return tIdUserMasterViewJpaRepository.getUserInfoAll();
	}
	
	@Override
	public boolean chkDiscussionApprovalDtls(Long pivPinKey){
		
		List<TIdVisitInformationViewEntity> visitInfodmation= tIdVisitInformationViewJpaRepository.findByPivVisitedPinKeyAndActiveStatus(pivPinKey, "P");
		
		if(visitInfodmation.size()>0){
			return true;
		}
		return false;
	}
	
	@Override
	public List<TIdVisitInformationView> getDiscApprovInfoDetails(Long pivPinKey, String status){
		List<TIdVisitInformationViewEntity> TIdVisitInformationViewEntityList  = tIdVisitInformationViewJpaRepository.findByPivVisitedPinKeyAndActiveStatus(pivPinKey, status);
		List<TIdVisitInformationView> tIdVisitInformationViewList = new ArrayList<TIdVisitInformationView>();
		TIdVisitInformationView tIdVisitInformationView = null;
		List<TIdVisitRemarks> tIdVisitRemarksList = null;
		for(TIdVisitInformationViewEntity tIdVisitInformationViewEntity : TIdVisitInformationViewEntityList) {
			tIdVisitInformationView = genericServiceMapper.map(tIdVisitInformationViewEntity, TIdVisitInformationView.class);
			tIdVisitRemarksList = new ArrayList<TIdVisitRemarks>();
			for(TIdVisitRemarksEntity tIdVisitRemarksEntity : tIdVisitRemarksJpaRepository.findByPivrPivKey(tIdVisitInformationViewEntity.getPivKey())) {
				tIdVisitRemarksList.add(genericServiceMapper.map(tIdVisitRemarksEntity, TIdVisitRemarks.class));
			}
			tIdVisitInformationView.setListOfVisitRemarks(tIdVisitRemarksList);
			tIdVisitInformationViewList.add(tIdVisitInformationView);
		}
		return tIdVisitInformationViewList;
	}
	
}

