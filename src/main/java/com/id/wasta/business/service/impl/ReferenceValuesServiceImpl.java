package com.id.wasta.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.id.util.CommonConstants;
import com.id.util.bean.common.SelectListBean;
import com.id.wasta.business.service.ReferenceValuesViewService;
import com.id.wasta.data.repository.jpa.ReferenceValuesJpaRepository;
@Service
public class ReferenceValuesServiceImpl implements ReferenceValuesViewService{

	@Resource
	private ReferenceValuesJpaRepository referenceValuesJpaRepository;
	
	@Override
	public List<SelectListBean> getReferences(String searchString,String domainName, Long profileKey) {
		
		List<SelectListBean> refValuesList=referenceValuesJpaRepository.getReferenceValues(CommonConstants.ACTIVE_STATUS, searchString, profileKey, domainName);		
		return refValuesList;
	}
	@Override
	public List<SelectListBean> getReferences(String domainName, Long profileKey) {
		// TODO Auto-generated method stub
		List<SelectListBean> refValuesList=referenceValuesJpaRepository.getReferenceValues(CommonConstants.ACTIVE_STATUS,  profileKey, domainName);		
		return refValuesList;
	}

}
