package com.id.wasta.business.service;

import java.util.Date;
import java.util.List;

import com.id.wasta.bean.LandingInfoBean;
import com.id.wasta.bean.TIdLandingMaster;
import com.id.wasta.bean.TIdLandingNotification;
import com.id.wasta.bean.TIdProfileFollowDetailsView;
import com.id.wasta.bean.ToolTipNotificationLandBean;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;


/**
 * Business Service Interface for entity LandingInfoService.
 */
public interface LandingInfoService { 

	TIdLandingMaster getLandMenuCount(Date logoutDate, Long loggedPinKey);
	
	List<LandingInfoBean> getLandPageList(String menuType, Date logoutDate, Long loggedPinKey, int page, int size);
	
	List<LandingInfoBean> getAuditLogList(Long pinKey, int page, int size);
	
	String saveNotification(TIdLandingNotification tIdLandingNotification);
	
	boolean removeNotification(TIdLandingNotification tIdLandingNotification);
	
	TIdLandingMaster getNotificationLeftMenu(Long loggedPinKey);
	
	List<TIdLandingNotification> getNotificationList(String menuType, Long loggedPinKey, int page, int size);
	
	String updateNotification(Long ldKey);
	
	TIdLandingMaster getTopMenuCount(Long pinKey,Date createdOn);
	
	TIdLandingMaster getContactsInfo();
	
	List<PersonIndividualExperienceViewEntity> getMyContactInfoList(Long pinKey);
	
	List<TIdProfileFollowDetailsViewEntity> getMyContactFollowList(Long pinKey);
	
	List<TIdProfileFollowDetailsView> getFavoriteFollowList(Long pinKey);
	
	TIdLandingMaster getMyContactLeftMenu(Date logoutDate, Long loggedPinKey, String menuType);
	
	List<LandingInfoBean> getMyContactLandList(Date logoutDate, Long loggedPinKey, String menuType, String topMenuType);
	
	String saveLandPageLink(Long ldKey, Long loggedPinKey, String menuType);

	public ToolTipNotificationLandBean getToolTipDataNotification(String ldBoxName, Long loggedPinKey, int page, int size);
	public ToolTipNotificationLandBean getToolTipDataLanding(String ldBoxName, Date createdOn,  Long loggedPinKey, int page, int size);

}
