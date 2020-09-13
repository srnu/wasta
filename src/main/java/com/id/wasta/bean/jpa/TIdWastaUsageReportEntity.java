package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.util.action.CommonConstants;

@Entity
@Table(name="t_id_wasta_usage_report")
@NamedQueries ( {
	  @NamedQuery ( name="TIdWastaUsageReportEntity.countAll", query="SELECT COUNT(x) FROM TIdWastaUsageReportEntity x" )
	} )
public class TIdWastaUsageReportEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="usage_key")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long usage_key;
	
	@Column(name="usage_user_key",length=10)
	private Long usageUserkey;
	
	
	@Column(name="usage_pin_key",length=10)
	private Long usagePinkey;
	
	
	@Column(name="usage_designation_key",length=10)
	private Long usageDesignationkey;
	
	@Column(name="usage_function_key",length=10)
	private Long usageFunctionkey;
	
		
	@Column(name="usage_role_key",length=10)
	private Long usageRolekey;
	
	
	@Column(name="usage_company_key",length=10)
	private Long usageCompanykey;
	
	
	@Column(name="usage_status",length=10)
	private Long usageStatus;
	
	
	@Column(name="usage_no_of_total_contact",length=10)
	private Long usageNoOfTotalContact;
	
	
	@Column(name="usage_no_of_new_contact",length=10)
	private Long usageNoOfNewContact;
	
	
	@Column(name="usage_no_of_discussion",length=10)
	private Long usageNoOfDiscussion;
	
	
	@Column(name="usage_no_of_business_potential",length=10)
	private Long usageNoOfBusinessPotential;
	
	
	@Column(name="usage_no_of_additional_service",length=10)
	private Long usageNoOfAdditionalService;
	
	@Column(name="usage_others",length=10)
	private Long usageOthers;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)  
	@Column(name="usage_date")
	private Date usageDate;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
	@Temporal(TemporalType.TIMESTAMP)  
	@Column(name="usage_last_build_date")
	private Date usageLastBuildDate;
		
	@Column(name="profile_key")
	private Long profileKey;
	
	@Column(name="lock_key")
	private Long lockKey;
	
	
	

	

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

	public Long getUsage_key() {
		return usage_key;
	}

	public void setUsage_key(Long usage_key) {
		this.usage_key = usage_key;
	}

	public Long getUsageUserkey() {
		return usageUserkey;
	}

	public void setUsageUserkey(Long usageUserkey) {
		this.usageUserkey = usageUserkey;
	}

	public Long getUsagePinkey() {
		return usagePinkey;
	}

	public void setUsagePinkey(Long usagePinkey) {
		this.usagePinkey = usagePinkey;
	}

	public Long getUsageDesignationkey() {
		return usageDesignationkey;
	}

	public void setUsageDesignationkey(Long usageDesignationkey) {
		this.usageDesignationkey = usageDesignationkey;
	}

	public Long getUsageFunctionkey() {
		return usageFunctionkey;
	}

	public void setUsageFunctionkey(Long usageFunctionkey) {
		this.usageFunctionkey = usageFunctionkey;
	}

	public Long getUsageRolekey() {
		return usageRolekey;
	}

	public void setUsageRolekey(Long usageRolekey) {
		this.usageRolekey = usageRolekey;
	}

	public Long getUsageCompanykey() {
		return usageCompanykey;
	}

	public void setUsageCompanykey(Long usageCompanykey) {
		this.usageCompanykey = usageCompanykey;
	}

	public Long getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(Long usageStatus) {
		this.usageStatus = usageStatus;
	}

	public Long getUsageNoOfTotalContact() {
		return usageNoOfTotalContact;
	}

	public void setUsageNoOfTotalContact(Long usageNoOfTotalContact) {
		this.usageNoOfTotalContact = usageNoOfTotalContact;
	}

	public Long getUsageNoOfNewContact() {
		return usageNoOfNewContact;
	}

	public void setUsageNoOfNewContact(Long usageNoOfNewContact) {
		this.usageNoOfNewContact = usageNoOfNewContact;
	}

	public Long getUsageNoOfDiscussion() {
		return usageNoOfDiscussion;
	}

	public void setUsageNoOfDiscussion(Long usageNoOfDiscussion) {
		this.usageNoOfDiscussion = usageNoOfDiscussion;
	}

	public Long getUsageNoOfBusinessPotential() {
		return usageNoOfBusinessPotential;
	}

	public void setUsageNoOfBusinessPotential(Long usageNoOfBusinessPotential) {
		this.usageNoOfBusinessPotential = usageNoOfBusinessPotential;
	}

	public Long getUsageNoOfAdditionalService() {
		return usageNoOfAdditionalService;
	}

	public void setUsageNoOfAdditionalService(Long usageNoOfAdditionalService) {
		this.usageNoOfAdditionalService = usageNoOfAdditionalService;
	}

	public Long getUsageOthers() {
		return usageOthers;
	}

	public void setUsageOthers(Long usageOthers) {
		this.usageOthers = usageOthers;
	}

	public Date getUsageDate() {
		return usageDate;
	}

	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}

	public Date getUsageLastBuildDate() {
		return usageLastBuildDate;
	}

	public void setUsageLastBuildDate(Date usageLastBuildDate) {
		this.usageLastBuildDate = usageLastBuildDate;
	}
	
	
	

}
