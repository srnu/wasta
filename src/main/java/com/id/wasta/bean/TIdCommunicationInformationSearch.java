package com.id.wasta.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class TIdCommunicationInformationSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pcmKey;
    private String pcmType;
    private String pcmDescription ;
    private String activeStatus ;
    private Long lockKey;
    private Long profileKey;
    @JsonBackReference
	private TIdPersonalInformationSearch tIdPersonalInformation;
	
	public Long getPcmKey() {
		return pcmKey;
	}
	
	public void setPcmKey(Long pcmKey) {
		this.pcmKey = pcmKey;
	}
	
	public String getPcmType() {
		return pcmType;
	}
	
	public void setPcmType(String pcmType) {
		this.pcmType = pcmType;
	}
	
	public String getPcmDescription() {
		return pcmDescription;
	}
	
	public void setPcmDescription(String pcmDescription) {
		this.pcmDescription = pcmDescription;
	}
	
	public String getActiveStatus() {
		return activeStatus;
	}
	
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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
	
	public TIdPersonalInformationSearch gettIdPersonalInformation() {
		return tIdPersonalInformation;
	}
	
	public void settIdPersonalInformation(TIdPersonalInformationSearch tIdPersonalInformation) {
		this.tIdPersonalInformation = tIdPersonalInformation;
	}
}
