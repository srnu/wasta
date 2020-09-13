/*
 * Created on 20 Feb 2017 ( Time 18:41:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdProfessionalExpertise implements Serializable {

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
    private Long ppeSkillKey;


    private Long ppePinKey;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;

    private Long otherSkillKey;
    
    private String otherSkillName;

    private String auditJson;
    
    private Long ppeCreatedBy;

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
    public void setPpeSkillKey( Long ppeSkillKey ) {
        this.ppeSkillKey = ppeSkillKey;
    }
    public Long getPpeSkillKey() {
        return this.ppeSkillKey;
    }

    public void setPpePinKey( Long ppePinKey ) {
        this.ppePinKey = ppePinKey;
    }
    public Long getPpePinKey() {
        return this.ppePinKey;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public Long getOtherSkillKey() {
		return otherSkillKey;
	}

	public void setOtherSkillKey(Long otherSkillKey) {
		this.otherSkillKey = otherSkillKey;
	}

	public String getOtherSkillName() {
		return otherSkillName;
	}

	public void setOtherSkillName(String otherSkillName) {
		this.otherSkillName = otherSkillName;
	}

	public String getAuditJson() {
		return auditJson;
	}

	public void setAuditJson(String auditJson) {
		this.auditJson = auditJson;
	}
	
	public Long getPpeCreatedBy() {
		return ppeCreatedBy;
	}

	public void setPpeCreatedBy(Long ppeCreatedBy) {
		this.ppeCreatedBy = ppeCreatedBy;
	}
	
	

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
    

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(key);
        sb.append("|");
        sb.append(ppeSkillKey);
        sb.append("|");
        sb.append(ppePinKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(ppeCreatedBy);
        return sb.toString(); 
    }

}