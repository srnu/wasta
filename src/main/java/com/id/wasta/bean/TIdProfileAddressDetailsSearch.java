package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TIdProfileAddressDetailsSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long padKey;
	
	@NotNull
	private Long padPinKey;
	
	@NotNull
	private Long padAddressType;
	
	private String padAddressLine1;
	
	private String padAddressLine2;
	
	private Long padCityKey;
	
	private Long padStateKey;
	
	private Long padCountryKey;
	
	private Long padPinzip;
	
	@NotNull
	private Long lockKey;
	
	@NotNull
	private Long profileKey;
	
	@NotNull
	private String activeStatus;

	public Long getPadKey() {
		return padKey;
	}

	public void setPadKey(Long padKey) {
		this.padKey = padKey;
	}

	public Long getPadPinKey() {
		return padPinKey;
	}

	public void setPadPinKey(Long padPinKey) {
		this.padPinKey = padPinKey;
	}

	public Long getPadAddressType() {
		return padAddressType;
	}

	public void setPadAddressType(Long padAddressType) {
		this.padAddressType = padAddressType;
	}

	public String getPadAddressLine1() {
		return padAddressLine1;
	}

	public void setPadAddressLine1(String padAddressLine1) {
		this.padAddressLine1 = padAddressLine1;
	}

	public String getPadAddressLine2() {
		return padAddressLine2;
	}

	public void setPadAddressLine2(String padAddressLine2) {
		this.padAddressLine2 = padAddressLine2;
	}

	public Long getPadCityKey() {
		return padCityKey;
	}

	public void setPadCityKey(Long padCityKey) {
		this.padCityKey = padCityKey;
	}

	public Long getPadStateKey() {
		return padStateKey;
	}

	public void setPadStateKey(Long padStateKey) {
		this.padStateKey = padStateKey;
	}

	public Long getPadCountryKey() {
		return padCountryKey;
	}

	public void setPadCountryKey(Long padCountryKey) {
		this.padCountryKey = padCountryKey;
	}

	public Long getPadPinzip() {
		return padPinzip;
	}

	public void setPadPinzip(Long padPinzip) {
		this.padPinzip = padPinzip;
	}

	public Long getLockKey() {
		return lockKey;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(padKey);
        sb.append("|");
        sb.append(padPinKey);
        sb.append("|");
        sb.append(padAddressType);
        sb.append("|");
        sb.append(padAddressLine1);
        sb.append("|");
        sb.append(padAddressLine2);
        sb.append("|");
        sb.append(padCityKey);
        sb.append("|");
        sb.append(padStateKey);
        sb.append("|");
        sb.append(padCountryKey);
        sb.append("|");
        sb.append(padPinzip);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}
