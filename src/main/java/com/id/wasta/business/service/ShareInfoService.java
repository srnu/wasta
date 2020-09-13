package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.ShareInfoBean;
import com.id.wasta.bean.TIdLandingNotification;


public interface ShareInfoService {

	String saveShareInfoDtls(ShareInfoBean shareInfoBean);
	
	boolean shareInfoValid(ShareInfoBean shareInfoBean);

	boolean chkShareInfoDtls(Long loginPinKey, Long currentPinKey, Long contactPinKey, String menuType, String fieldType);
	
	boolean chkShareInfoDtls(Long loginPinKey, Long currentPinKey, Long contactPinKey, Long propertyCreatedBy, String menuType, String fieldType);

	//ShareInfoBean retrieveShareInfo(ShareInfoBean shareInfoBean);
	
	List<SelectListBean> getCreatorName();
	
	SelectListBean findCreator(Long pinKey);

	String saveShareNotification(TIdLandingNotification tIdLandingNotification);
	
}
