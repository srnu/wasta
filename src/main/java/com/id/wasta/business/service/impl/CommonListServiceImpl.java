package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.business.service.CommonListService;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkViewJpaRepository;

@Service
public class CommonListServiceImpl implements CommonListService{

	@Resource
	private TIdExperienceInformationViewJpaRepository tIdExperienceInformationViewJpaRepository;
	
	@Resource
	private TIdEducationalInformationViewJpaRepository tIdEducationalInformationViewJpaRepository;
	
	@Resource
	private TIdCompanyContactLinkViewJpaRepository tIdCompanyContactLinkViewJpaRepository;
	
	@Resource
	private TIdRelationshipInfoLinkViewJpaRepository tIdRelationshipInfoLinkViewJpaRepository;
	
	@Override
	public List<SelectListBean> getRetrievePosition(Long pinKey) {
		return tIdExperienceInformationViewJpaRepository.getRetrievePosition(pinKey);
	}

	@Override
	public List<SelectListBean> getRetrieveProvidedBy(Long pinKey) {
		 List<SelectListBean> selectListBean = new ArrayList<SelectListBean>();
		 selectListBean.addAll(tIdEducationalInformationViewJpaRepository.getRetrieveProvidedBy(pinKey));
		 selectListBean.addAll(tIdExperienceInformationViewJpaRepository.getRetrieveProvidedBy(pinKey));
		 return selectListBean;
	}

	@Override
	public List<SelectListBean> getRetriveRelationship(Long pinKey) {
		List<SelectListBean> selectListBean = new ArrayList<SelectListBean>();
		 selectListBean.addAll(tIdCompanyContactLinkViewJpaRepository.getRetriveRelationship(pinKey));
		 selectListBean.addAll(tIdRelationshipInfoLinkViewJpaRepository.getRetriveRelationship(pinKey));
		 return selectListBean;
	}
	
}
