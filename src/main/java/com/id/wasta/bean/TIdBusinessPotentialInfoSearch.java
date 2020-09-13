/*
 * Created on 20 Feb 2017 ( Time 18:45:44 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;


public class TIdBusinessPotentialInfoSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long       key       ;

     private Long       bpiOthers    ;

     private Long       bpiCityKey   ;

     private String     bpiRemarks   ;
     
     private Long       bpiCreatedBy   ;

     private String     activeStatus ;

     private Long       profileKey   ;

     private Long       lockKey      ;

    //private TIdPersonalInformationSearch tIdPersonalInformation;
    
    private TIdSkillMasterSearch tIdSkillMaster;

   
    public TIdBusinessPotentialInfoSearch() {
		super();
    }
    
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

    //--- DATABASE MAPPING : bpi_others ( BIGINT ) 
    public void setBpiOthers( Long bpiOthers ) {
        this.bpiOthers = bpiOthers;
    }
    public Long getBpiOthers() {
        return this.bpiOthers;
    }

    //--- DATABASE MAPPING : bpi_city_key ( BIGINT ) 
    public void setBpiCityKey( Long bpiCityKey ) {
        this.bpiCityKey = bpiCityKey;
    }
    public Long getBpiCityKey() {
        return this.bpiCityKey;
    }

    //--- DATABASE MAPPING : bpi_remarks ( VARCHAR ) 
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

	//--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    /*public TIdPersonalInformationSearch gettIdPersonalInformation() {
		return tIdPersonalInformation;
	}

	public void settIdPersonalInformation(TIdPersonalInformationSearch tIdPersonalInformation) {
		this.tIdPersonalInformation = tIdPersonalInformation;
	}*/

	public TIdSkillMasterSearch gettIdSkillMaster() {
		return tIdSkillMaster;
	}

	public void settIdSkillMaster(TIdSkillMasterSearch tIdSkillMaster) {
		this.tIdSkillMaster = tIdSkillMaster;
	}
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
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
        return sb.toString(); 
    } 

}