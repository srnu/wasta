/*
 * Created on 22 Feb 2017 ( Time 14:28:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdAddPotentialServicesView implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long key;

    @NotNull
    private Long apsPinKey;

    @NotNull
    private Long apsSkillKey;


    private Long apsOthers;


    private Long apsCityKey;

    @Size( max = 2000 )
    private String apsRemarks;
    
    private Long       apsCreatedBy   ;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long profileKey;

    @NotNull
    private Long lockKey;


    private Long pinKey;

    @Size( max = 240 )
    private String name;
    
    private String cityName;

    private Long skillCategory;

    private boolean viewAccessFlag = true; 
    
    private boolean editAccessFlag = true;
    
    private String apsSkillStatus;
    
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setKey( Long key ) {
        this.key = key;
    }
    public Long getKey() {
        return this.key;
    }

    public void setApsPinKey( Long apsPinKey ) {
        this.apsPinKey = apsPinKey;
    }
    public Long getApsPinKey() {
        return this.apsPinKey;
    }

    public void setApsSkillKey( Long apsSkillKey ) {
        this.apsSkillKey = apsSkillKey;
    }
    public Long getApsSkillKey() {
        return this.apsSkillKey;
    }

    public void setApsOthers( Long apsOthers ) {
        this.apsOthers = apsOthers;
    }
    public Long getApsOthers() {
        return this.apsOthers;
    }

    public void setApsCityKey( Long apsCityKey ) {
        this.apsCityKey = apsCityKey;
    }
    public Long getApsCityKey() {
        return this.apsCityKey;
    }

    public void setApsRemarks( String apsRemarks ) {
        this.apsRemarks = apsRemarks;
    }
    public String getApsRemarks() {
        return this.apsRemarks;
    }
    
    public Long getApsCreatedBy() {
		return apsCreatedBy;
	}
	public void setApsCreatedBy(Long apsCreatedBy) {
		this.apsCreatedBy = apsCreatedBy;
	}

	public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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

    public void setPinKey( Long pinKey ) {
        this.pinKey = pinKey;
    }
    public Long getPinKey() {
        return this.pinKey;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setSkillCategory( Long skillCategory ) {
        this.skillCategory = skillCategory;
    }
    public Long getSkillCategory() {
        return this.skillCategory;
    }

    public boolean isViewAccessFlag() {
		return viewAccessFlag;
	}
	public void setViewAccessFlag(boolean viewAccessFlag) {
		this.viewAccessFlag = viewAccessFlag;
	}
	
	public boolean isEditAccessFlag() {
		return editAccessFlag;
	}
	public void setEditAccessFlag(boolean editAccessFlag) {
		this.editAccessFlag = editAccessFlag;
	}
	public String getApsSkillStatus() {
  		return apsSkillStatus;
  	}

  	public void setApsSkillStatus(String apsSkillStatus) {
  		this.apsSkillStatus = apsSkillStatus;
  	}
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(key);
        sb.append("|");
        sb.append(apsPinKey);
        sb.append("|");
        sb.append(apsSkillKey);
        sb.append("|");
        sb.append(apsOthers);
        sb.append("|");
        sb.append(apsCityKey);
        sb.append("|");
        sb.append(apsRemarks);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(pinKey);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(skillCategory);
        sb.append("|");
        sb.append(apsSkillStatus);
        return sb.toString(); 
    } 


}
