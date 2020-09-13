package com.id.wasta.business.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.id.util.CommonConstants;
import com.id.util.bean.common.SelectListBean;
import com.id.wasta.business.service.CompanyListService;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterJpaRepository;
@Service
public class CompanyLIstServiceImpl implements CompanyListService {

	@Resource
	private TIdCompanyMasterJpaRepository tIdCompanyMasterJpaRepository;
	
	@Override
	public List<SelectListBean> getGroupCompaniesList(String searchString,Long profileKey) {
		
		List<SelectListBean> selectList=tIdCompanyMasterJpaRepository.getGroupCompanies(CommonConstants.ACTIVE_STATUS, searchString, profileKey, new Date());
		return selectList;
	}
	
	@Override
	public List<SelectListBean> getGroupCompany(Long profileKey) {
		
		List<SelectListBean> selectList=tIdCompanyMasterJpaRepository.getGroupCompany(CommonConstants.ACTIVE_STATUS, profileKey, new Date());
		return selectList;
	}

}
