package com.id.wasta.bean;

import java.io.Serializable;

public class RequestKeyBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long userKey;
	private Long pinKey;
	private boolean contactToEmployee;
	
	public Long getUserKey() {
		return userKey;
	}
	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}
	public Long getPinKey() {
		return pinKey;
	}
	public void setPinKey(Long pinKey) {
		this.pinKey = pinKey;
	}
	public boolean isContactToEmployee() {
		return contactToEmployee;
	}
	public void setContactToEmployee(boolean contactToEmployee) {
		this.contactToEmployee = contactToEmployee;
	}
}
