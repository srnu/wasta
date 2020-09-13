package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdTemplateMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long tmId;
	
	private String tmCode;

	private String tmType;
	
	private String tmFunctionality;
	
	private String tmStatus;
	
	private String tmContent;
	
	private String tmSubject;
	
	@NotNull
	private Long profileKey;
	
	@NotNull
	private Long lockKey;
	
	@NotNull
	private String activeStatus;

	public Long getTmId() {
		return tmId;
	}

	public void setTmId(Long tmId) {
		this.tmId = tmId;
	}

	public String getTmCode() {
		return tmCode;
	}

	public void setTmCode(String tmCode) {
		this.tmCode = tmCode;
	}

	public String getTmType() {
		return tmType;
	}

	public void setTmType(String tmType) {
		this.tmType = tmType;
	}

	public String getTmFunctionality() {
		return tmFunctionality;
	}

	public void setTmFunctionality(String tmFunctionality) {
		this.tmFunctionality = tmFunctionality;
	}

	public String getTmStatus() {
		return tmStatus;
	}

	public void setTmStatus(String tmStatus) {
		this.tmStatus = tmStatus;
	}

	public String getTmContent() {
		return tmContent;
	}

	public void setTmContent(String tmContent) {
		this.tmContent = tmContent;
	}

	public String getTmSubject() {
		return tmSubject;
	}

	public void setTmSubject(String tmSubject) {
		this.tmSubject = tmSubject;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public Long getLockKey() {
		return lockKey;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(tmId);
        sb.append("|");
        sb.append(tmCode);
        sb.append("|");
        sb.append(tmType);
        sb.append("|");
        sb.append(tmFunctionality);
        sb.append("|");
        sb.append(tmStatus);
        sb.append("|");
        sb.append(tmContent);
        sb.append("|");
        sb.append(tmSubject);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}
