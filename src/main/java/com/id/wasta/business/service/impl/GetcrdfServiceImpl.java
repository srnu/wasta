package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailEntity;
import com.id.wasta.business.service.GetcrdfService;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdFunctionalAreaMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesHeaderJpaRepository;

@Service
public class GetcrdfServiceImpl implements GetcrdfService{
	
	@Autowired
	private TIdCompanyMasterJpaRepository tIdCompanyMasterJpaRepository;
	
	@Autowired
	private TIdDesignationMasterJpaRepository tIdDesignationMasterJpaRepository;
	
	@Autowired
	private TIdFunctionalAreaMasterJpaRepository tIdFunctionalAreaMasterJpaRepository;
	
	@Autowired
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	
	
	@Autowired
	private TIdReferenceCodesHeaderJpaRepository tIdReferenceCodesHeadeJpaRepository;


	public List<SelectListBean> getCompany(Long profileKey, String searchString) { 
		List<SelectListBean> listOfCompanyMaster = tIdCompanyMasterJpaRepository.getAllData(profileKey,searchString);
		return listOfCompanyMaster;	
	}
	
	public List<SelectListBean> getRoles(Long profileKey, String searchString) { 
		Long roleKey =  tIdReferenceCodesHeadeJpaRepository.getRoleHeaderKey();
		List<TIdReferenceCodesDetailEntity> tIdReferenceCodesDetailEntity = tIdReferenceCodesDetailJpaRepository.getAllData(profileKey,searchString,roleKey);
		List<SelectListBean> listOfSelectListBean = null;
		
		if(tIdReferenceCodesDetailEntity!=null && tIdReferenceCodesDetailEntity.size()>0) {
			listOfSelectListBean = new ArrayList<SelectListBean>();
			SelectListBean selectListBean = null;
			for (TIdReferenceCodesDetailEntity tIdReferenceCodesDetailObj : tIdReferenceCodesDetailEntity) {
				selectListBean = new SelectListBean();
				selectListBean.setId(tIdReferenceCodesDetailObj.getRcdDetailKey());
				selectListBean.setName(tIdReferenceCodesDetailObj.getRcdValue());
				listOfSelectListBean.add(selectListBean);
			}
			return listOfSelectListBean;
			
		}
		
		return listOfSelectListBean;
	}
	
	public List<SelectListBean> getDesignation(Long profileKey, String searchString) { 
		List<SelectListBean> listOfDesignationMasterMaster = tIdDesignationMasterJpaRepository.getAllData(profileKey,searchString);
		return listOfDesignationMasterMaster;
	}
	
	public List<SelectListBean> getFunctionalArea(Long profileKey, String searchString) {
		List<SelectListBean> listOfFunctionalMaster = tIdFunctionalAreaMasterJpaRepository.getAllData(profileKey,searchString);
		return listOfFunctionalMaster;
	}

}
