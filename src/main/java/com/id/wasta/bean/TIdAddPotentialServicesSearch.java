/*
 * Created on 20 Feb 2017 ( Time 18:46:19 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;


public class TIdAddPotentialServicesSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long       key       ;

     private Long       apsOthers    ;

     private Long       apsCityKey   ;

     private String     apsRemarks   ;

     private Long       apsCreatedBy   ;
     
     private String     activeStatus ;

     private Long       profileKey   ;

     private Long       lockKey      ;

    //private TIdPersonalInformationSearch tIdPersonalInformation;
    
    private TIdSkillMasterSearch tIdSkillMaster;
    //----------------------------------------------------------------------
    //  LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdAddPotentialServicesSearch() {
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
    //--- DATABASE MAPPING : aps_pin_key ( BIGINT ) 

    //--- DATABASE MAPPING : aps_others ( BIGINT ) 
    public void setApsOthers( Long apsOthers ) {
        this.apsOthers = apsOthers;
    }
    public Long getApsOthers() {
        return this.apsOthers;
    }

    //--- DATABASE MAPPING : aps_city_key ( BIGINT ) 
    public void setApsCityKey( Long apsCityKey ) {
        this.apsCityKey = apsCityKey;
    }
    public Long getApsCityKey() {
        return this.apsCityKey;
    }

    //--- DATABASE MAPPING : aps_remarks ( VARCHAR ) 
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

   /* public TIdPersonalInformationSearch gettIdPersonalInformation() {
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
        return sb.toString(); 
    } 

}