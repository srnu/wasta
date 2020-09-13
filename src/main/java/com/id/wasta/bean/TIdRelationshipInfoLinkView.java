package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdRelationshipInfoLinkView implements Serializable {

	private static final long serialVersionUID = 1L;
		
			@NotNull
		    private Long prlkKey;
			
			private Long       prlkPrlKey      ;
			    
		    @NotNull
		    @Size( min = 1, max = 1 )
		    private String prlkRelationType;

		    @NotNull
		    @Size( min = 1, max = 1 )
		    private String prlkRelationship;

		    @NotNull
		    private Long prlkFromPinKey;


		    private Long prlkToPinKey;


		    private Long prlkToPscKey;

		    @NotNull
		    private String activeStatus;

		    @NotNull
		    private Long lockKey;

		    @NotNull
		    @Size( min = 1, max = 75 )
		    private Long profileKey;
		    
		    private String prlFirstName;
		    
		    private String prlLirstName;
		    
		    private String pinFirstName;
		    
		    private String pinLirstName;

			public Long getPrlkKey() {
				return prlkKey;
			}

			public void setPrlkKey(Long prlkKey) {
				this.prlkKey = prlkKey;
			}

			public Long getPrlkPrlKey() {
				return prlkPrlKey;
			}

			public void setPrlkPrlKey(Long prlkPrlKey) {
				this.prlkPrlKey = prlkPrlKey;
			}

			public String getPrlkRelationType() {
				return prlkRelationType;
			}

			public void setPrlkRelationType(String prlkRelationType) {
				this.prlkRelationType = prlkRelationType;
			}

			public String getPrlkRelationship() {
				return prlkRelationship;
			}

			public void setPrlkRelationship(String prlkRelationship) {
				this.prlkRelationship = prlkRelationship;
			}

			public Long getPrlkFromPinKey() {
				return prlkFromPinKey;
			}

			public void setPrlkFromPinKey(Long prlkFromPinKey) {
				this.prlkFromPinKey = prlkFromPinKey;
			}

			public Long getPrlkToPinKey() {
				return prlkToPinKey;
			}

			public void setPrlkToPinKey(Long prlkToPinKey) {
				this.prlkToPinKey = prlkToPinKey;
			}

			public Long getPrlkToPscKey() {
				return prlkToPscKey;
			}

			public void setPrlkToPscKey(Long prlkToPscKey) {
				this.prlkToPscKey = prlkToPscKey;
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

			public String getPrlFirstName() {
				return prlFirstName;
			}

			public void setPrlFirstName(String prlFirstName) {
				this.prlFirstName = prlFirstName;
			}

			public String getPrlLirstName() {
				return prlLirstName;
			}

			public void setPrlLirstName(String prlLirstName) {
				this.prlLirstName = prlLirstName;
			}

			public String getPinFirstName() {
				return pinFirstName;
			}

			public void setPinFirstName(String pinFirstName) {
				this.pinFirstName = pinFirstName;
			}

			public String getPinLirstName() {
				return pinLirstName;
			}

			public void setPinLirstName(String pinLirstName) {
				this.pinLirstName = pinLirstName;
			}
		    
			  public String toString() { 
			        StringBuffer sb = new StringBuffer(); 
			        sb.append(prlkKey);
			        sb.append("|");
			        sb.append(prlkRelationType);
			        sb.append("|");
			        sb.append(prlkRelationship);
			        sb.append("|");
			        sb.append(prlkFromPinKey);
			        sb.append("|");
			        sb.append(prlkToPinKey);
			        sb.append("|");
			        sb.append(prlkToPscKey);
			        sb.append("|");
			        sb.append(activeStatus);
			        sb.append("|");
			        sb.append(lockKey);
			        sb.append("|");
			        sb.append(profileKey);
			        sb.append("|");
			        sb.append(prlFirstName);
			        sb.append("|");
			        sb.append(prlLirstName);
			        sb.append("|");
			        sb.append(pinFirstName);
			        sb.append("|");
			        sb.append(pinLirstName);
			        return sb.toString(); 
			    } 
		    
}
