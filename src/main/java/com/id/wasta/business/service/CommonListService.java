package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;

public interface CommonListService {
	
	List<SelectListBean> getRetrievePosition(Long pinKey);
	
	List<SelectListBean> getRetrieveProvidedBy(Long pinKey);
	
	List<SelectListBean> getRetriveRelationship(Long pinKey);
}

