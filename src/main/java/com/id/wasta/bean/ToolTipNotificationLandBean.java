package com.id.wasta.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ToolTipNotificationLandBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<TIdLandingNotification> sortedLandingNotificationList;
	private List<LandingInfoBean> sortedLandingInfoBeanList;
	private Map<Long,ToolTipBean> toolTipMap;
	
	
	public List<TIdLandingNotification> getSortedLandingNotificationList() {
		return sortedLandingNotificationList;
	}
	public void setSortedLandingNotificationList(List<TIdLandingNotification> sortedLandingNotificationList) {
		this.sortedLandingNotificationList = sortedLandingNotificationList;
	}
	public List<LandingInfoBean> getSortedLandingInfoBeanList() {
		return sortedLandingInfoBeanList;
	}
	public void setSortedLandingInfoBeanList(List<LandingInfoBean> sortedLandingInfoBeanList) {
		this.sortedLandingInfoBeanList = sortedLandingInfoBeanList;
	}
	public Map<Long, ToolTipBean> getToolTipMap() {
		return toolTipMap;
	}
	public void setToolTipMap(Map<Long, ToolTipBean> toolTipMap) {
		this.toolTipMap = toolTipMap;
	}
	
	
	
}
