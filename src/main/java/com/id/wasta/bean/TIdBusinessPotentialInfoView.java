/*
 * Created on 22 Feb 2017 ( Time 14:28:24 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdBusinessPotentialInfoView implements Serializable {

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
    private Long bpiPinKey;

    @NotNull
    private Long bpiSkillKey;


    private Long bpiOthers;


    private Long bpiCityKey;

    @Size( max = 2000 )
    private String bpiRemarks;

    private Long       bpiCreatedBy   ;
    
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
    
    private String bpiSkillStatus;
    
   

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

    public void setBpiPinKey( Long bpiPinKey ) {
        this.bpiPinKey = bpiPinKey;
    }
    public Long getBpiPinKey() {
        return this.bpiPinKey;
    }

    public void setBpiSkillKey( Long bpiSkillKey ) {
        this.bpiSkillKey = bpiSkillKey;
    }
    public Long getBpiSkillKey() {
        return this.bpiSkillKey;
    }

    public void setBpiOthers( Long bpiOthers ) {
        this.bpiOthers = bpiOthers;
    }
    public Long getBpiOthers() {
        return this.bpiOthers;
    }

    public void setBpiCityKey( Long bpiCityKey ) {
        this.bpiCityKey = bpiCityKey;
    }
    public Long getBpiCityKey() {
        return this.bpiCityKey;
    }

    public void setBpiRemarks( String bpiRemarks ) {
        this.bpiRemarks = bpiRemarks;
    }
    public String getBpiRemarks() {
        return this.bpiRemarks;
    }
    
    public Long getBpiCreatedBy() {
		return bpiCreatedBy;
	}
	public void setBpiCreatedBy(Long bpiCreatedBy) {
		this.bpiCreatedBy = bpiCreatedBy;
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
	
	public String getBpiSkillStatus() {
		return bpiSkillStatus;
	}

	public void setBpiSkillStatus(String bpiSkillStatus) {
		this.bpiSkillStatus = bpiSkillStatus;
	}
		
		
		 

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(key);
        sb.append("|");
        sb.append(bpiPinKey);
        sb.append("|");
        sb.append(bpiSkillKey);
        sb.append("|");
        sb.append(bpiOthers);
        sb.append("|");
        sb.append(bpiCityKey);
        sb.append("|");
        sb.append(bpiRemarks);
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
	    sb.append(bpiSkillStatus);
        return sb.toString(); 
    } 


}
