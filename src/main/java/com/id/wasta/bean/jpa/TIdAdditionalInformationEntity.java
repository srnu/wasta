
/*
 * Created on 1 Nov 2016 ( Time 10:40:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.util.Date;

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
 * Persistent class for entity stored in table "t_id_additional_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_additional_information")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdAdditionalInformationEntity.countAll", query="SELECT COUNT(x) FROM TIdAdditionalInformationEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdAdditionalInformationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="piad_key", nullable=false)
    private Long       piadKey      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="piad_pin_key", nullable=false)
		
     private Long       piadPinKey   ;

    @Column(name="piad_position", nullable=false, length=240)
		
     private String     piadPosition ;

    @Column(name="piad_organization", nullable=false)
		
     private String       piadOrganization ;

    @Column(name="piad_city_key", nullable=false)
		
     private Long       piadCityKey  ;

    @Column(name="piad_state_key")
		
     private Long       piadStateKey ;

    @Column(name="piad_country_key", nullable=false)
		
     private Long       piadCountryKey ;

    @Column(name="piad_from_month", length=3)
		
     private String     piadFromMonth ;

    @Column(name="piad_from_year")
		
     private Long       piadFromYear ;

    @Column(name="piad_to_month", length=3)
		
     private String     piadToMonth  ;

    @Column(name="piad_to_year")
		
     private Long       piadToYear   ;

    @Column(name="piad_years")
		
     private String       piadYears    ;

    @Column(name="piad_currently_working")
	
    private String       piadCurrentlyWorking    ;
    
    @Column(name="piad_description", length=1000)
		
     private String     piadDescription ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;
    
    
    @Column(name="piad_created_by",length=20)
    private Long piadCreatedBy;
    
    
    @Column(name="created_on")
    private Date createdOn;

    
    public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdAdditionalInformationEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPiadKey( Long piadKey ) {
        this.piadKey = piadKey ;
    }
    public Long getPiadKey() {
        return this.piadKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : piad_pin_key ( BIGINT ) 
    public void setPiadPinKey( Long piadPinKey ) {
        this.piadPinKey = piadPinKey;
    }
    public Long getPiadPinKey() {
        return this.piadPinKey;
    }

    //--- DATABASE MAPPING : piad_position ( VARCHAR ) 
    public void setPiadPosition( String piadPosition ) {
        this.piadPosition = piadPosition;
    }
    public String getPiadPosition() {
        return this.piadPosition;
    }

    //--- DATABASE MAPPING : piad_company_cms_key ( BIGINT ) 
   /* public void setPiadCompanyCmsKey( Long piadCompanyCmsKey ) {
        this.piadCompanyCmsKey = piadCompanyCmsKey;
    }
    public Long getPiadCompanyCmsKey() {
        return this.piadCompanyCmsKey;
    }*/

    //--- DATABASE MAPPING : piad_city_key ( BIGINT ) 
    public void setPiadCityKey( Long piadCityKey ) {
        this.piadCityKey = piadCityKey;
    }
    public Long getPiadCityKey() {
        return this.piadCityKey;
    }

    //--- DATABASE MAPPING : piad_state_key ( BIGINT ) 
    public void setPiadStateKey( Long piadStateKey ) {
        this.piadStateKey = piadStateKey;
    }
    public Long getPiadStateKey() {
        return this.piadStateKey;
    }

    //--- DATABASE MAPPING : piad_country_key ( BIGINT ) 
    public void setPiadCountryKey( Long piadCountryKey ) {
        this.piadCountryKey = piadCountryKey;
    }
    public Long getPiadCountryKey() {
        return this.piadCountryKey;
    }

    //--- DATABASE MAPPING : piad_from_month ( VARCHAR ) 
    public void setPiadFromMonth( String piadFromMonth ) {
        this.piadFromMonth = piadFromMonth;
    }
    public String getPiadFromMonth() {
        return this.piadFromMonth;
    }

    //--- DATABASE MAPPING : piad_from_year ( BIGINT ) 
    public void setPiadFromYear( Long piadFromYear ) {
        this.piadFromYear = piadFromYear;
    }
    public Long getPiadFromYear() {
        return this.piadFromYear;
    }

    //--- DATABASE MAPPING : piad_to_month ( VARCHAR ) 
    public void setPiadToMonth( String piadToMonth ) {
        this.piadToMonth = piadToMonth;
    }
    public String getPiadToMonth() {
        return this.piadToMonth;
    }

    //--- DATABASE MAPPING : piad_to_year ( BIGINT ) 
    public void setPiadToYear( Long piadToYear ) {
        this.piadToYear = piadToYear;
    }
    public Long getPiadToYear() {
        return this.piadToYear;
    }

    //--- DATABASE MAPPING : piad_years ( BIGINT ) 
    public void setPiadYears( String piadYears ) {
        this.piadYears = piadYears;
    }
    public String getPiadYears() {
        return this.piadYears;
    }
    
    public String getPiadCurrentlyWorking() {
		return piadCurrentlyWorking;
	}

	public void setPiadCurrentlyWorking(String piadCurrentlyWorking) {
		this.piadCurrentlyWorking = piadCurrentlyWorking;
	}

	//--- DATABASE MAPPING : piad_description ( VARCHAR ) 
    public void setPiadDescription( String piadDescription ) {
        this.piadDescription = piadDescription;
    }
    public String getPiadDescription() {
        return this.piadDescription;
    }

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
    
    


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    public Long getPiadCreatedBy() {
		return piadCreatedBy;
	}

	public void setPiadCreatedBy(Long piadCreatedBy) {
		this.piadCreatedBy = piadCreatedBy;
	}

	public String getPiadOrganization() {
		return piadOrganization;
	}

	public void setPiadOrganization(String piadOrganization) {
		this.piadOrganization = piadOrganization;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(piadKey);
        sb.append("]:"); 
        sb.append(piadPinKey);
        sb.append("|");
        sb.append(piadPosition);
        sb.append("|");
        sb.append(piadOrganization);
        sb.append("|");
        sb.append(piadCityKey);
        sb.append("|");
        sb.append(piadStateKey);
        sb.append("|");
        sb.append(piadCountryKey);
        sb.append("|");
        sb.append(piadFromMonth);
        sb.append("|");
        sb.append(piadFromYear);
        sb.append("|");
        sb.append(piadToMonth);
        sb.append("|");
        sb.append(piadToYear);
        sb.append("|");
        sb.append(piadYears);
        sb.append("|");
        sb.append(piadDescription);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(createdOn);
        sb.append("|");
        sb.append(piadCreatedBy);
        
        return sb.toString(); 
    } 

}
