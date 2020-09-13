
/*
 * Created on 8 Dec 2016 ( Time 10:49:48 )
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

/**
 * Persistent class for entity stored in table "t_id_awards_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_awards_information")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdAwardsInformationEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdAwardsInformationEntitySearch x" )
} )
public class TIdAwardsInformationEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pia_key", nullable=false)
    private Long       piaKey       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="pia_award_name", nullable=false, length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     piaAwardName ;

    @Column(name="pia_position", length=240)
    private Long     piaPosition  ;

    @Column(name="pia_position_others", length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     piaPositionOthers ;

    @Column(name="pia_provided_by")
    private Long     piaProvidedBy ; 

    @Column(name="pia_provided_by_type")
    private String piaProvidedByType;
    
    @Column(name="pia_provided_by_others", length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     piaProvidedByOthers ;

    @Column(name="pia_month", length=3)
		
     private String     piaMonth     ;

    @Column(name="pia_year")
		
     private Long       piaYear      ;

    @Column(name="pia_description", length=1000)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     piaDescription ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;
    
    @Column(name="pia_created_by",length=20)
    private Long piaCreatedBy;

	// "piaPinKey" (column "pia_pin_key") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="pia_pin_key", referencedColumnName="pin_key")
    private TIdPersonalInformationEntitySearch tIdPersonalInformation;

    /*@ManyToOne
    @JoinColumn(name="pia_position", referencedColumnName="desig_key")
    private TIdDesignationMasterEntitySearch tIdDesignationMaster;*/
    
    /*@ManyToOne
    @JoinColumn(name="pia_provided_by", referencedColumnName="education_key")
    private TIdEducationalInstitutesEntitySearch tIdEducationalInstitutes;*/

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdAwardsInformationEntitySearch() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPiaKey( Long piaKey ) {
        this.piaKey = piaKey ;
    }
    public Long getPiaKey() {
        return this.piaKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pia_award_name ( VARCHAR ) 
    public void setPiaAwardName( String piaAwardName ) {
        this.piaAwardName = piaAwardName;
    }
    public String getPiaAwardName() {
        return this.piaAwardName;
    }

    //--- DATABASE MAPPING : pia_position ( VARCHAR ) 
    public void setPiaPosition( Long piaPosition ) {
        this.piaPosition = piaPosition;
    }
    public Long getPiaPosition() {
        return this.piaPosition;
    }

    //--- DATABASE MAPPING : pia_position_others ( VARCHAR ) 
    public void setPiaPositionOthers( String piaPositionOthers ) {
        this.piaPositionOthers = piaPositionOthers;
    }
    public String getPiaPositionOthers() {
        return this.piaPositionOthers;
    }

    //--- DATABASE MAPPING : pia_provided_by ( VARCHAR ) 
    public void setPiaProvidedBy( Long piaProvidedBy ) {
        this.piaProvidedBy = piaProvidedBy;
    }
    public Long getPiaProvidedBy() {
        return this.piaProvidedBy;
    }

    //--- DATABASE MAPPING : pia_provided_by_others ( VARCHAR ) 
    public void setPiaProvidedByOthers( String piaProvidedByOthers ) {
        this.piaProvidedByOthers = piaProvidedByOthers;
    }
    public String getPiaProvidedByOthers() {
        return this.piaProvidedByOthers;
    }
    
    public String getPiaProvidedByType() {
		return piaProvidedByType;
	}
	public void setPiaProvidedByType(String piaProvidedByType) {
		this.piaProvidedByType = piaProvidedByType;
	}

	//--- DATABASE MAPPING : pia_month ( VARCHAR ) 
    public void setPiaMonth( String piaMonth ) {
        this.piaMonth = piaMonth;
    }
    public String getPiaMonth() {
        return this.piaMonth;
    }

    //--- DATABASE MAPPING : pia_year ( BIGINT ) 
    public void setPiaYear( Long piaYear ) {
        this.piaYear = piaYear;
    }
    public Long getPiaYear() {
        return this.piaYear;
    }

    //--- DATABASE MAPPING : pia_description ( VARCHAR ) 
    public void setPiaDescription( String piaDescription ) {
        this.piaDescription = piaDescription;
    }
    public String getPiaDescription() {
        return this.piaDescription;
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
    public void setTIdPersonalInformation( TIdPersonalInformationEntitySearch tIdPersonalInformation ) {
        this.tIdPersonalInformation = tIdPersonalInformation;
    }
    public TIdPersonalInformationEntitySearch getTIdPersonalInformation() {
        return this.tIdPersonalInformation;
    }
    
    
    

	/*public TIdDesignationMasterEntitySearch getTIdDesignationMaster() {
		return tIdDesignationMaster;
	}

	public void setTIdDesignationMaster(TIdDesignationMasterEntitySearch tIdDesignationMaster) {
		this.tIdDesignationMaster = tIdDesignationMaster;
	}*/

	/*public TIdEducationalInstitutesEntitySearch getTIdEducationalInstitutes() {
		return tIdEducationalInstitutes;
	}

	public void setTIdEducationalInstitutes(TIdEducationalInstitutesEntitySearch tIdEducationalInstitutes) {
		this.tIdEducationalInstitutes = tIdEducationalInstitutes;
	}*/

	public Long getPiaCreatedBy() {
		return piaCreatedBy;
	}

	public void setPiaCreatedBy(Long piaCreatedBy) {
		this.piaCreatedBy = piaCreatedBy;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(piaKey);
        sb.append("]:"); 
        sb.append(piaAwardName);
       /* sb.append("|");
        sb.append(piaPosition);
        sb.append("|");
        sb.append(piaPositionOthers);
        sb.append("|");
        sb.append(piaProvidedBy);*/
        sb.append("|");
        sb.append(piaProvidedByOthers);
        sb.append("|");
        sb.append(piaMonth);
        sb.append("|");
        sb.append(piaYear);
        sb.append("|");
        sb.append(piaDescription);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(piaCreatedBy);
        return sb.toString(); 
    } 

}