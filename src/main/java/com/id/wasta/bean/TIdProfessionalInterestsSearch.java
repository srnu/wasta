/*
 * Created on 20 Feb 2017 ( Time 18:42:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;


public class TIdProfessionalInterestsSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long       priKey       ;

     private String     priOthers    ;

     private String     activeStatus ;

     private Long       profileKey   ;

     private Long       lockKey      ;

   // private TIdPersonalInformationSearch tIdPersonalInformation;
    
    private TIdSkillMasterSearch tIdSkillMaster;

    public TIdProfessionalInterestsSearch() {
		super();
    }
    
    public void setPriKey( Long priKey ) {
        this.priKey = priKey ;
    }
    public Long getPriKey() {
        return this.priKey;
    }

   

    //--- DATABASE MAPPING : pri_others ( VARCHAR ) 
    public void setPriOthers( String priOthers ) {
        this.priOthers = priOthers;
    }
    public String getPriOthers() {
        return this.priOthers;
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
        sb.append(priKey);
        sb.append("]:"); 
        sb.append("|");
        sb.append(priOthers);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
