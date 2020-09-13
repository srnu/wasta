package com.id.wasta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.id.util.bean.common.SelectListBean;

public class ShareInfoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String menuType;
	
	private String fieldType;
	
	private Long pinKey;
	
	private Long dataRefKey;
	
	private String shareType; //none, all, oneToOne, group
	
	private String accessType; // view, share
	
	private String accessInfo;
	
	private Long createdBy;
	
	private boolean admin;
	
	private boolean recall;
	
	private boolean isApprove;
	
	private List<Long> recallOneToOneList = new ArrayList<Long>();
	private List<Long> recallGroupList = new ArrayList<Long>();
	
	@JsonIgnore
	private List<Long> oneToOneList = new ArrayList<Long>();//already Shared pin Keys
	
	@JsonIgnore
	private  List<Long> groupList = new ArrayList<Long>();//already shared group keys 
	
	@JsonIgnore
	private List<Long> boxOneToOneList = new ArrayList<Long>();//already Shared pin Keys
	
	@JsonIgnore
	private  List<Long> boxGroupList = new ArrayList<Long>();//already shared group keys 
	
	@JsonIgnore
	private List<Long> fullOneToOneList = new ArrayList<Long>();//already Shared pin Keys
	
	@JsonIgnore
	private  List<Long> fullGroupList = new ArrayList<Long>();//already shared group keys 
	
	@JsonIgnore
	boolean fullShare = false;
	
	@JsonIgnore
	boolean boxShare = false;
	
	@JsonIgnore
	boolean propertyShare = false;
	
	private Set<SelectListBean> recallList = new HashSet();

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Long getPinKey() {
		return pinKey;
	}

	public void setPinKey(Long pinKey) {
		this.pinKey = pinKey;
	}

	public Long getDataRefKey() {
		return dataRefKey;
	}

	public void setDataRefKey(Long dataRefKey) {
		this.dataRefKey = dataRefKey;
	}

	public String getAccessInfo() {
		return accessInfo;
	}

	public void setAccessInfo(String accessInfo) {
		this.accessInfo = accessInfo;
	}
	
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public Set<SelectListBean> getRecallList() {
		return recallList;
	}

	public void setRecallList(Set<SelectListBean> recallList) {
		this.recallList = recallList;
	}

	public boolean isRecall() {
		return recall;
	}

	public void setRecall(boolean recall) {
		this.recall = recall;
	}

	public boolean isApprove() {
		return isApprove;
	}

	public void setApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}

	public List<Long> getRecallOneToOneList() {
		return recallOneToOneList;
	}

	public void setRecallOneToOneList(List<Long> recallOneToOneList) {
		this.recallOneToOneList = recallOneToOneList;
	}

	public List<Long> getRecallGroupList() {
		return recallGroupList;
	}

	public void setRecallGroupList(List<Long> recallGroupList) {
		this.recallGroupList = recallGroupList;
	}

	public List<Long> getOneToOneList() {
		return oneToOneList;
	}

	public void setOneToOneList(List<Long> oneToOneList) {
		this.oneToOneList = oneToOneList;
	}

	public List<Long> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Long> groupList) {
		this.groupList = groupList;
	}

	public List<Long> getBoxOneToOneList() {
		return boxOneToOneList;
	}

	public void setBoxOneToOneList(List<Long> boxOneToOneList) {
		this.boxOneToOneList = boxOneToOneList;
	}

	public List<Long> getBoxGroupList() {
		return boxGroupList;
	}

	public void setBoxGroupList(List<Long> boxGroupList) {
		this.boxGroupList = boxGroupList;
	}

	public List<Long> getFullOneToOneList() {
		return fullOneToOneList;
	}

	public void setFullOneToOneList(List<Long> fullOneToOneList) {
		this.fullOneToOneList = fullOneToOneList;
	}

	public List<Long> getFullGroupList() {
		return fullGroupList;
	}

	public void setFullGroupList(List<Long> fullGroupList) {
		this.fullGroupList = fullGroupList;
	}

	public boolean isFullShare() {
		return fullShare;
	}

	public void setFullShare(boolean fullShare) {
		this.fullShare = fullShare;
	}

	public boolean isBoxShare() {
		return boxShare;
	}

	public void setBoxShare(boolean boxShare) {
		this.boxShare = boxShare;
	}

	public boolean isPropertyShare() {
		return propertyShare;
	}

	public void setPropertyShare(boolean propertyShare) {
		this.propertyShare = propertyShare;
	}
 	
	
	
	
}
