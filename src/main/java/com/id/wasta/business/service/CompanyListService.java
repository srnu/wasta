package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;

public interface CompanyListService {
	
	List<SelectListBean> getGroupCompaniesList(String searchString,Long profileKey);
	
	List<SelectListBean> getGroupCompany(Long profileKey);
}

