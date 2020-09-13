package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.TIdVisitInformationView;

public interface DiscussionInfoService { 

	String getDiscussionRelation(Long pinKey);

	List<SelectListBean> getDiscussionCustInfo(Long pinKey);

	List<SelectListBean> getDiscussionCustInfoAllDtls();
	
	List<SelectListBean> getDiscussionUserInfoAllDtls();
	
	boolean chkDiscussionApprovalDtls(Long pivPinKey);
	
	List<TIdVisitInformationView> getDiscApprovInfoDetails(Long pivPinKey, String status);
}
