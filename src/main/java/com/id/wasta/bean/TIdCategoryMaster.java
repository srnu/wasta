
/*
 * Created on 28 Aug 2017 ( Time 18:08:44 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.* ;

public class TIdCategoryMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long camKey;

	@NotNull
	@Size(min = 1, max = 200)
	private String camName;

	@Size(max = 75)
	private String activeStatus;

	@NotNull
	private Long lockKey;

	@NotNull
	private Long profileKey;

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setCamKey(Long camKey) {
		this.camKey = camKey;
	}

	public Long getCamKey() {
		return this.camKey;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : cam_name ( VARCHAR )
	public void setCamName(String camName) {
		this.camName = camName;
	}

	public String getCamName() {
		return this.camName;
	}

	// --- DATABASE MAPPING : active_status ( VARCHAR )
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	// --- DATABASE MAPPING : lock_key ( BIGINT )
	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public Long getLockKey() {
		return this.lockKey;
	}

	// --- DATABASE MAPPING : profile_key ( BIGINT )
	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public Long getProfileKey() {
		return this.profileKey;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(camKey);
		sb.append("]:");
		sb.append(camName);
		sb.append("|");
		sb.append(activeStatus);
		sb.append("|");
		sb.append(lockKey);
		sb.append("|");
		sb.append(profileKey);
		return sb.toString();
	}

}