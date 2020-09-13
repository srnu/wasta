package com.id.wasta.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class TIdSocialMediaInformationSearch implements Serializable {

	    private static final long serialVersionUID = 1L;
	    private Long psmKey;
	    private String psmType;
	    private String psmId;
	    private Long lockKey;
	    private Long profileKey;
	    private String activeStatus;
	    @JsonBackReference
	   	private TIdPersonalInformationSearch tIdPersonalInformation;

		public Long getPsmKey() {
			return psmKey;
		}

		public void setPsmKey(Long psmKey) {
			this.psmKey = psmKey;
		}

		public String getPsmType() {
			return psmType;
		}

		public void setPsmType(String psmType) {
			this.psmType = psmType;
		}

		public String getPsmId() {
			return psmId;
		}

		public void setPsmId(String psmId) {
			this.psmId = psmId;
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

		public TIdPersonalInformationSearch gettIdPersonalInformation() {
			return tIdPersonalInformation;
		}

		public void settIdPersonalInformation(
				TIdPersonalInformationSearch tIdPersonalInformation) {
			this.tIdPersonalInformation = tIdPersonalInformation;
		}
	   	
}
