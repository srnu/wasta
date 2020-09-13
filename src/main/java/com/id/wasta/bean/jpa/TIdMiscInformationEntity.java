
/*
 * Created on 1 Nov 2016 ( Time 10:40:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Persistent class for entity stored in table "t_id_misc_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_misc_information")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdMiscInformationEntity.countAll", query="SELECT COUNT(x) FROM TIdMiscInformationEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdMiscInformationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pimi_key", nullable=false)
    private Long       pimiKey      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="pimi_pin_key", nullable=false)
		
     private Long       pimiPinKey   ;

    @Column(name="pimi_recreation", length=1000)
		
     private String     pimiRecreation ;

    @Column(name="pimi_business_potential", length=1000)
		
     private String     pimiBusinessPotential ;

    @Column(name="pimi_professional_expertise", length=1000)
		
     private String     pimiProfessionalExpertise ;
    
    @Column(name="pimi_professional_expertise_key", length=1000)
	
    private Long     pimiProfessionalExpertiseKey ;

    @Column(name="pimi_professional_interests", length=1000)
		
     private String     pimiProfessionalInterests ;

    @Column(name="pimi_personal_interests", length=1000)
		
     private String     pimiPersonalInterests ;

    @Column(name="pimi_business_opportunities", length=1000)
		
     private String     pimiBusinessOpportunities ;

    @Column(name="pimi_personal_priorities", length=1000)
		
     private String     pimiPersonalPriorities ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdMiscInformationEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : pimi_pin_key ( BIGINT ) 
    public void setPimiPinKey( Long pimiPinKey ) {
        this.pimiPinKey = pimiPinKey;
    }
    public Long getPimiPinKey() {
        return this.pimiPinKey;
    }

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

   
	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pimiKey);
        sb.append("]:"); 
        sb.append(pimiPinKey);
        sb.append("|");
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
