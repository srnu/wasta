package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProfileFollowDetails implements Serializable {

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
	        return sb.toString(); 
	    } 

	
}
