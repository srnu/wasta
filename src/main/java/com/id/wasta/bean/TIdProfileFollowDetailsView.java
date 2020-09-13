package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TIdProfileFollowDetailsView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long pfdKey;
	
	@NotNull
	private Long pfdPinKey;
	
	@NotNull
	private Long pfdPinFollowbyKey;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date pfdFollowedDate;
	
	@NotNull
	private Long lockKey;
	
	@NotNull
	private Long profileKey;
	
	@NotNull
	private String activeStatus;
	
	private String companyName;
	
	private String designation;
	
	private String role;
	
	private String functionalArea;
	
	private String pattInternalFileName;
	
	private Long pattReferenceKey;
	
	private String pinFirstName;
	
	private String pinLastName;
	
	private Long followedByProfileKey;

	public Long getPfdKey() {
		return pfdKey;
	}

	public void setPfdKey(Long pfdKey) {
		this.pfdKey = pfdKey;
	}

	public Long getPfdPinKey() {
		return pfdPinKey;
	}

	public void setPfdPinKey(Long pfdPinKey) {
		this.pfdPinKey = pfdPinKey;
	}

	public Long getPfdPinFollowbyKey() {
		return pfdPinFollowbyKey;
	}

	public void setPfdPinFollowbyKey(Long pfdPinFollowbyKey) {
		this.pfdPinFollowbyKey = pfdPinFollowbyKey;
	}

	public Date getPfdFollowedDate() {
		return pfdFollowedDate;
	}

	public void setPfdFollowedDate(Date pfdFollowedDate) {
		this.pfdFollowedDate = pfdFollowedDate;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFunctionalArea() {
		return functionalArea;
	}

	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}

	public String getPattInternalFileName() {
		return pattInternalFileName;
	}

	public void setPattInternalFileName(String pattInternalFileName) {
		this.pattInternalFileName = pattInternalFileName;
	}

	public Long getPattReferenceKey() {
		return pattReferenceKey;
	}

	public void setPattReferenceKey(Long pattReferenceKey) {
		this.pattReferenceKey = pattReferenceKey;
	}

	public String getPinFirstName() {
		return pinFirstName;
	}

	public void setPinFirstName(String pinFirstName) {
		this.pinFirstName = pinFirstName;
	}

	public String getPinLastName() {
		return pinLastName;
	}

	public void setPinLastName(String pinLastName) {
		this.pinLastName = pinLastName;
	}

	public Long getFollowedByProfileKey() {
		return followedByProfileKey;
	}

	public void setFollowedByProfileKey(Long followedByProfileKey) {
		this.followedByProfileKey = followedByProfileKey;
	}
	
	
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pfdKey);
        sb.append("]:"); 
        sb.append(pfdPinKey);
        sb.append("|");
        sb.append(pfdPinFollowbyKey);
        sb.append("|");
        sb.append(pfdFollowedDate);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(companyName);
        sb.append("|");
        sb.append(designation);
        sb.append("|");
        sb.append(role);
        sb.append("|");
        sb.append(functionalArea);
        sb.append("|");
        sb.append(pattInternalFileName);
        sb.append("|");
        sb.append(pattReferenceKey);
        sb.append("|");
        sb.append(pinFirstName);
        sb.append("|");
        sb.append(pinLastName);
        sb.append("|");
        sb.append(followedByProfileKey);
        return sb.toString(); 
    } 

}
