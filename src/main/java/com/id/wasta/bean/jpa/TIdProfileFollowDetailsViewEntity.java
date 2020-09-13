package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_profile_follow_details_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfileFollowDetailsViewEntity.countAll", query="SELECT COUNT(x) FROM TIdProfileFollowDetailsViewEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProfileFollowDetailsViewEntity implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	 	@Id
	    @Column(name="pfd_key", nullable=false)
	    private Long pfdKey;

	    @Column(name="pfd_pin_key", nullable=false)
	    private Long pfdPinKey;
	    
	    @Column(name="pfd_pin_followby_key", nullable=false)
	    private Long pfdPinFollowbyKey;
	    
	    @Column(name="pfd_followed_date", nullable=false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	    private Date pfdFollowedDate;
	    
	    @Version
	    @Column(name="pfd_lock_key", nullable=false)
	    private Long lockKey;
	    
	    @Column(name="pfd_profile_key", nullable=false)
	    private Long profileKey;
	    
	    @Column(name="pfd_active_status", nullable=false)
	    private String activeStatus;
	    
	    @Column(name="company_name")
	    private String companyName;
		
	    @Column(name="designation")
		private String designation;
	    
	    @Column(name="role")
		private String role;
		
	    @Column(name="functional_area")
		private String functionalArea;
		
	    @Column(name="patt_internal_file_name")
		private String pattInternalFileName;
		
	    @Column(name="patt_reference_key")
		private Long pattReferenceKey;
		
	    @Column(name="pin_first_name")
		private String pinFirstName;
		
	    @Column(name="pin_last_name")
		private String pinLastName;
	    
	    @Column(name="followed_by_profile_key")
	    private Long followedByProfileKey;

	    public TIdProfileFollowDetailsViewEntity() {
			super();
	    }

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
