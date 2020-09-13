package com.id.wasta.bean;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.util.action.CommonConstants;


public class TIdWastaUsageReportBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long usage_key;
	
	private Long usageUserkey;
	
	
	private Long usagePinkey;
	
	
	private Long usageDesignationkey;
	
	private Long usageFunctionkey;
	
		
	private Long usageRolekey;
	
	
	private Long usageCompanykey;
	
	
	private Long usageStatus;
	
	
	private Long usageNoOfTotalContact;
	
	
	private Long usageNoOfNewContact;
	
	
	private Long usageNoOfDiscussion;
	
	
	private Long usageNoOfBusinessPotential;
	
	
	private Long usageNoOfAdditionalService;
	
	
	private Long profileKey;
	
	private Long lockKey;
	
	
	private Long usageOthers;
	
	
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.DATE)
	private Date usageDate;
	
	
	private Date usageLastBuildDate;

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

	public Date getUsageLastBuildDate() {
		return usageLastBuildDate;
	}

	public void setUsageLastBuildDate(Date usageLastBuildDate) {
		this.usageLastBuildDate = usageLastBuildDate;
	}

	
	
	
	
	
	
	

}
