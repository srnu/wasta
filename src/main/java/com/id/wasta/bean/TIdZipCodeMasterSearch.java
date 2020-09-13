package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TIdZipCodeMasterSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long zcmKey;
	
	@NotNull
	private String zcmCode;
	
	@NotNull
	private Long zcmStateKey;
	
	@NotNull
	private Long zcmCityKey;
	
	private String zcmRemarks;
	
	@NotNull
	private Long lockKey;
	
	@NotNull
	private Long profileKey;

	
	public Long getZcmKey() {
		return zcmKey;
	}

	public void setZcmKey(Long zcmKey) {
		this.zcmKey = zcmKey;
	}

	public String getZcmCode() {
		return zcmCode;
	}

	public void setZcmCode(String zcmCode) {
		this.zcmCode = zcmCode;
	}

	public Long getZcmStateKey() {
		return zcmStateKey;
	}

	public void setZcmStateKey(Long zcmStateKey) {
		this.zcmStateKey = zcmStateKey;
	}

	public Long getZcmCityKey() {
		return zcmCityKey;
	}

	public void setZcmCityKey(Long zcmCityKey) {
		this.zcmCityKey = zcmCityKey;
	}

	public String getZcmRemarks() {
		return zcmRemarks;
	}

	public void setZcmRemarks(String zcmRemarks) {
		this.zcmRemarks = zcmRemarks;
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

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(zcmKey);
        sb.append("|");
        sb.append(zcmCode);
        sb.append("|");
        sb.append(zcmStateKey);
        sb.append("|");
        sb.append(zcmCityKey);
        sb.append("|");
        sb.append(zcmRemarks);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
