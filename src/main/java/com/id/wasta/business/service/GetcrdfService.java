package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;

public interface GetcrdfService {
	
	public List<SelectListBean> getCompany(Long profileKey, String searchString);
	public List<SelectListBean> getRoles(Long profileKey, String searchString);
	public List<SelectListBean> getDesignation(Long profileKey, String searchString);
	public List<SelectListBean> getFunctionalArea(Long profileKey, String searchString);
	
}
