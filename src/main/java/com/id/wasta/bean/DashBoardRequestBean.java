package com.id.wasta.bean;

import java.io.Serializable;

public class DashBoardRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long pinKey;

	private Long userId;

	private boolean currentUser;
	
	private String blkName;
	
	private Long dataRefKey;
	
	private String relationType;

	private Long loginPinKey;
	
	
	public Long getPinKey() {
		return pinKey;
	}

	public void setPinKey(Long pinKey) {
		this.pinKey = pinKey;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(boolean currentUser) {
		this.currentUser = currentUser;
	}
	
	public String getBlkName() {
		return blkName;
	}

	public void setBlkName(String blkName) {
		this.blkName = blkName;
	}
	
	public Long getDataRefKey() {
		return dataRefKey;
	}

	public void setDataRefKey(Long dataRefKey) {
		this.dataRefKey = dataRefKey;
	}
	
	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public Long getLoginPinKey() {
		return loginPinKey;
	}

	public void setLoginPinKey(Long loginPinKey) {
		this.loginPinKey = loginPinKey;
	}

	
	
}
