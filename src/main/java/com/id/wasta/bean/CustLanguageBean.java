package com.id.wasta.bean;

import java.io.Serializable;

public class CustLanguageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long primaryKey;
	private Long languageKey;
	private Long lockKey;
	public Long getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Long getLanguageKey() {
		return languageKey;
	}
	public void setLanguageKey(Long languageKey) {
		this.languageKey = languageKey;
	}
	public Long getLockKey() {
		return lockKey;
	}
	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}
	
	
	
	
	
	

}
