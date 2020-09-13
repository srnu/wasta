/*
 * Created on 20 Feb 2017 ( Time 18:41:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;


public class TIdProfessionalExpertiseSearch implements Serializable {

	 private static final long serialVersionUID = 1L;

	    private Long       ppeKey       ;

	    private String     activeStatus ;

	    private Long       lockKey      ;

	    private Long       profileKey   ;

	    //private TIdPersonalInformationSearch tIdPersonalInformation;
	    
	    private TIdSkillMasterSearch tIdSkillMaster;


		//----------------------------------------------------------------------
	    // CONSTRUCTOR(S)
	    //----------------------------------------------------------------------
	    public TIdProfessionalExpertiseSearch() {
			super();
	    }
	    
	    //----------------------------------------------------------------------
	    // GETTER & SETTER FOR THE KEY FIELD
	    //----------------------------------------------------------------------
	    public void setPpeKey( Long ppeKey ) {
	        this.ppeKey = ppeKey ;
	    }
	    public Long getPpeKey() {
	        return this.ppeKey;
	    }

	    //----------------------------------------------------------------------
	    // GETTERS & SETTERS FOR FIELDS
	    //----------------------------------------------------------------------
	    //--- DATABASE MAPPING : ppe_skill_key ( BIGINT ) 
	  
	  

	    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
	    public void setActiveStatus( String activeStatus ) {
	        this.activeStatus = activeStatus;
	    }
	    public String getActiveStatus() {
	        return this.activeStatus;
	    }

	    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
	    public void setLockKey( Long lockKey ) {
	        this.lockKey = lockKey;
	    }
	    public Long getLockKey() {
	        return this.lockKey;
	    }

	    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
	    public void setProfileKey( Long profileKey ) {
	        this.profileKey = profileKey;
	    }
	    public Long getProfileKey() {
	        return this.profileKey;
	    }
	    public TIdSkillMasterSearch gettIdSkillMaster() {
			return tIdSkillMaster;
		}

		public void settIdSkillMaster(TIdSkillMasterSearch tIdSkillMaster) {
			this.tIdSkillMaster = tIdSkillMaster;
		}

		/*public TIdPersonalInformationSearch gettIdPersonalInformation() {
			return tIdPersonalInformation;
		}

		public void settIdPersonalInformation(TIdPersonalInformationSearch tIdPersonalInformation) {
			this.tIdPersonalInformation = tIdPersonalInformation;
		}*/

	    //----------------------------------------------------------------------
	    // GETTERS & SETTERS FOR LINKS
	    //----------------------------------------------------------------------

	    //----------------------------------------------------------------------
	    // toString METHOD
	    //----------------------------------------------------------------------
	    public String toString() { 
	        StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(ppeKey);
	        sb.append("]:"); 
	        sb.append("|");
	        sb.append(activeStatus);
	        sb.append("|");
	        sb.append(lockKey);
	        sb.append("|");
	        sb.append(profileKey);
	        return sb.toString(); 
	    } 

}
