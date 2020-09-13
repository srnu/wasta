/*
 * Created on 8 Dec 2016 ( Time 10:37:10 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class TIdMiscInformationSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long       pimiKey      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
		
     private String     pimiRecreation ;

		
     private String     pimiBusinessPotential ;

		
     private String     pimiProfessionalExpertise ;

		
     private String     pimiProfessionalInterests ;

		
     private String     pimiPersonalInterests ;

		
     private String     pimiBusinessOpportunities ;

		
     private String     pimiPersonalPriorities ;
     
     private Long pimiProfessionalExpertiseKey;

  
	private Long       lockKey      ;

		
     private String     activeStatus ;

		
     private Long       profileKey   ;
     
     private Map<Long,String> pimiProfessionalExpertiseMap; 

	// "pimiPinKey" (column "pimi_pin_key") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //private TIdPersonalInformationSearch tIdPersonalInformation;

    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPimiKey( Long pimiKey ) {
        this.pimiKey = pimiKey ;
    }
    public Long getPimiKey() {
        return this.pimiKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pimi_recreation ( VARCHAR ) 
    public void setPimiRecreation( String pimiRecreation ) {
        this.pimiRecreation = pimiRecreation;
    }
    public String getPimiRecreation() {
        return this.pimiRecreation;
    }

    //--- DATABASE MAPPING : pimi_business_potential ( VARCHAR ) 
    public void setPimiBusinessPotential( String pimiBusinessPotential ) {
        this.pimiBusinessPotential = pimiBusinessPotential;
    }
    public String getPimiBusinessPotential() {
        return this.pimiBusinessPotential;
    }

    //--- DATABASE MAPPING : pimi_professional_expertise ( VARCHAR ) 
    public void setPimiProfessionalExpertise( String pimiProfessionalExpertise ) {
        this.pimiProfessionalExpertise = pimiProfessionalExpertise;
    }
    public String getPimiProfessionalExpertise() {
        return this.pimiProfessionalExpertise;
    }

    //--- DATABASE MAPPING : pimi_professional_interests ( VARCHAR ) 
    public void setPimiProfessionalInterests( String pimiProfessionalInterests ) {
        this.pimiProfessionalInterests = pimiProfessionalInterests;
    }
    public String getPimiProfessionalInterests() {
        return this.pimiProfessionalInterests;
    }

    //--- DATABASE MAPPING : pimi_personal_interests ( VARCHAR ) 
    public void setPimiPersonalInterests( String pimiPersonalInterests ) {
        this.pimiPersonalInterests = pimiPersonalInterests;
    }
    public String getPimiPersonalInterests() {
        return this.pimiPersonalInterests;
    }

    //--- DATABASE MAPPING : pimi_business_opportunities ( VARCHAR ) 
    public void setPimiBusinessOpportunities( String pimiBusinessOpportunities ) {
        this.pimiBusinessOpportunities = pimiBusinessOpportunities;
    }
    public String getPimiBusinessOpportunities() {
        return this.pimiBusinessOpportunities;
    }

    //--- DATABASE MAPPING : pimi_personal_priorities ( VARCHAR ) 
    public void setPimiPersonalPriorities( String pimiPersonalPriorities ) {
        this.pimiPersonalPriorities = pimiPersonalPriorities;
    }
    public String getPimiPersonalPriorities() {
        return this.pimiPersonalPriorities;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
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
    public Long getPimiProfessionalExpertiseKey() {
 		return pimiProfessionalExpertiseKey;
 	}
 	public void setPimiProfessionalExpertiseKey(Long pimiProfessionalExpertiseKey) {
 		this.pimiProfessionalExpertiseKey = pimiProfessionalExpertiseKey;
 	}

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    /*public void setTIdPersonalInformation( TIdPersonalInformationSearch tIdPersonalInformation ) {
        this.tIdPersonalInformation = tIdPersonalInformation;
    }
    public TIdPersonalInformationSearch getTIdPersonalInformation() {
        return this.tIdPersonalInformation;
    }*/


    public Map<Long, String> getPimiProfessionalExpertiseMap() {
		return pimiProfessionalExpertiseMap;
	}
	public void setPimiProfessionalExpertiseMap(Map<Long, String> pimiProfessionalExpertiseMap) {
		this.pimiProfessionalExpertiseMap = pimiProfessionalExpertiseMap;
	}
	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pimiKey);
        sb.append("]:"); 
        sb.append(pimiRecreation);
        sb.append("|");
        sb.append(pimiBusinessPotential);
        sb.append("|");
        sb.append(pimiProfessionalExpertise);
        sb.append("|");
        sb.append(pimiProfessionalInterests);
        sb.append("|");
        sb.append(pimiPersonalInterests);
        sb.append("|");
        sb.append(pimiBusinessOpportunities);
        sb.append("|");
        sb.append(pimiPersonalPriorities);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}
