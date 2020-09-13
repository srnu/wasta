package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.util.action.CommonConstants;

public class TIdZipCodeMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long key;
	
	@NotNull
	private String code;
	
	private String name;
	
	@NotNull
	private Long zcmStateKey;
	
	@NotNull
	private Long zcmCityKey;
	
	private String zcmRemarks;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date activeFrom;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date activeTo;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;
    
	@NotNull
	private Long lockKey;
	
	@NotNull
	private Long profileKey;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Date getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	public Date getActiveTo() {
		return activeTo;
	}

	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getZcmRemarks() {
		return zcmRemarks;
	}

	public void setZcmRemarks(String zcmRemarks) {
		this.zcmRemarks = zcmRemarks;
	}

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(key);
        sb.append("|");
        sb.append(code);
        sb.append("|");
        sb.append(zcmStateKey);
        sb.append("|");
        sb.append(zcmCityKey);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 
	
}
