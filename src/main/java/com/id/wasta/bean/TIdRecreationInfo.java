/*
 * Created on 20 Feb 2017 ( Time 18:43:44 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdRecreationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long key;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long reiPinKey;


    private Long reiRmKey;

    @Size( max = 75 )
    private String reiRmOthers;

    @NotNull
    private Long profileKey;

    @NotNull
    private Long lockKey;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    private Long othersRmKey;
    
    private String othersRmName;

    private String auditJson;
    
    private Long     reiCreatedBy;
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setKey( Long key ) {
        this.key = key ;
    }

    public Long getKey() {
        return this.key;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setReiPinKey( Long reiPinKey ) {
        this.reiPinKey = reiPinKey;
    }
    public Long getReiPinKey() {
        return this.reiPinKey;
    }

    public void setReiRmKey( Long reiRmKey ) {
        this.reiRmKey = reiRmKey;
    }
    public Long getReiRmKey() {
        return this.reiRmKey;
    }

    public void setReiRmOthers( String reiRmOthers ) {
        this.reiRmOthers = reiRmOthers;
    }
    public String getReiRmOthers() {
        return this.reiRmOthers;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    public Long getOthersRmKey() {
		return othersRmKey;
	}

	public void setOthersRmKey(Long othersRmKey) {
		this.othersRmKey = othersRmKey;
	}

	public String getOthersRmName() {
		return othersRmName;
	}

	public void setOthersRmName(String othersRmName) {
		this.othersRmName = othersRmName;
	}

	public String getAuditJson() {
		return auditJson;
	}

	public void setAuditJson(String auditJson) {
		this.auditJson = auditJson;
	} 

	public Long getReiCreatedBy() {
		return reiCreatedBy;
	}

	public void setReiCreatedBy(Long reiCreatedBy) {
		this.reiCreatedBy = reiCreatedBy;
	}
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
    

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(key);
        sb.append("|");
        sb.append(reiPinKey);
        sb.append("|");
        sb.append(reiRmKey);
        sb.append("|");
        sb.append(reiRmOthers);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(reiCreatedBy);
        
        return sb.toString(); 
    }

}
