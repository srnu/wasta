
/*
 * Created on 1 Feb 2017 ( Time 18:58:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Persistent class for entity stored in table "person_individual_experience_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_personal_relation_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdPersonalRelationViewEntity.countAll", query="SELECT COUNT(x) FROM TIdPersonalRelationViewEntity x" )
} )
public class TIdPersonalRelationViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------   
    @Id
    @Column(name="pin_key")
		
     private Long       pinKey       ;

    @Column(name="pin_title", length=125)
		
     private String     pinTitle     ;

    @Column(name="pin_first_name", length=100)
		
     private String     pinFirstName ;

    @Column(name="pin_last_name", length=100)
		
     private String     pinLastName  ;

    @Column(name="pin_nick_name", length=100)
		
     private String     pinNickName  ;

    @Column(name="pin_gender", length=125)
		
     private String     pinGender    ;

    @Column(name="pin_nationality_key")
		
     private Long       pinNationalityKey ;

    @Column(name="pin_dob_str", length=20)
		
     private String     pinDobStr    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="pin_dob")
		
     private Date       pinDob       ;

    @Column(name="pin_email", length=200)
		
     private String     pinEmail     ;

    @Column(name="pin_address", length=500)
		
     private String     pinAddress   ;

    @Column(name="pin_city_key")
		
     private Long       pinCityKey   ;

    @Column(name="pin_state_key")
		
     private Long       pinStateKey  ;

    @Column(name="pin_country_key")
		
     private Long       pinCountryKey ;

    @Column(name="pin_remarks", length=1000)
		
     private String     pinRemarks   ;

    @Column(name="active_status", length=75)
		
     private String     activeStatus ;

    @Column(name="profile_key")
		
     private Long       profileKey   ;

    @Column(name="lock_key")
				@Version
		
     private Long       lockKey      ;

    @Column(name="relation_company_name", length=240)
		
     private String     relationCompanyName  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdPersonalRelationViewEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pin_key ( BIGINT ) 
    public void setPinKey( Long pinKey ) {
        this.pinKey = pinKey;
    }
    public Long getPinKey() {
        return this.pinKey;
    }

    //--- DATABASE MAPPING : pin_title ( VARCHAR ) 
    public void setPinTitle( String pinTitle ) {
        this.pinTitle = pinTitle;
    }
    public String getPinTitle() {
        return this.pinTitle;
    }

    //--- DATABASE MAPPING : pin_first_name ( VARCHAR ) 
    public void setPinFirstName( String pinFirstName ) {
        this.pinFirstName = pinFirstName;
    }
    public String getPinFirstName() {
        return this.pinFirstName;
    }

    //--- DATABASE MAPPING : pin_last_name ( VARCHAR ) 
    public void setPinLastName( String pinLastName ) {
        this.pinLastName = pinLastName;
    }
    public String getPinLastName() {
        return this.pinLastName;
    }

    //--- DATABASE MAPPING : pin_nick_name ( VARCHAR ) 
    public void setPinNickName( String pinNickName ) {
        this.pinNickName = pinNickName;
    }
    public String getPinNickName() {
        return this.pinNickName;
    }

    //--- DATABASE MAPPING : pin_gender ( VARCHAR ) 
    public void setPinGender( String pinGender ) {
        this.pinGender = pinGender;
    }
    public String getPinGender() {
        return this.pinGender;
    }

    //--- DATABASE MAPPING : pin_nationality_key ( BIGINT ) 
    public void setPinNationalityKey( Long pinNationalityKey ) {
        this.pinNationalityKey = pinNationalityKey;
    }
    public Long getPinNationalityKey() {
        return this.pinNationalityKey;
    }

    //--- DATABASE MAPPING : pin_dob_str ( VARCHAR ) 
    public void setPinDobStr( String pinDobStr ) {
        this.pinDobStr = pinDobStr;
    }
    public String getPinDobStr() {
        return this.pinDobStr;
    }

    //--- DATABASE MAPPING : pin_dob ( DATETIME ) 
    public void setPinDob( Date pinDob ) {
        this.pinDob = pinDob;
    }
    public Date getPinDob() {
        return this.pinDob;
    }

    //--- DATABASE MAPPING : pin_email ( VARCHAR ) 
    public void setPinEmail( String pinEmail ) {
        this.pinEmail = pinEmail;
    }
    public String getPinEmail() {
        return this.pinEmail;
    }

    //--- DATABASE MAPPING : pin_address ( VARCHAR ) 
    public void setPinAddress( String pinAddress ) {
        this.pinAddress = pinAddress;
    }
    public String getPinAddress() {
        return this.pinAddress;
    }

    //--- DATABASE MAPPING : pin_city_key ( BIGINT ) 
    public void setPinCityKey( Long pinCityKey ) {
        this.pinCityKey = pinCityKey;
    }
    public Long getPinCityKey() {
        return this.pinCityKey;
    }

    //--- DATABASE MAPPING : pin_state_key ( BIGINT ) 
    public void setPinStateKey( Long pinStateKey ) {
        this.pinStateKey = pinStateKey;
    }
    public Long getPinStateKey() {
        return this.pinStateKey;
    }

    //--- DATABASE MAPPING : pin_country_key ( BIGINT ) 
    public void setPinCountryKey( Long pinCountryKey ) {
        this.pinCountryKey = pinCountryKey;
    }
    public Long getPinCountryKey() {
        return this.pinCountryKey;
    }

    //--- DATABASE MAPPING : pin_remarks ( VARCHAR ) 
    public void setPinRemarks( String pinRemarks ) {
        this.pinRemarks = pinRemarks;
    }
    public String getPinRemarks() {
        return this.pinRemarks;
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

    public String getRelationCompanyName() {
		return relationCompanyName;
	}

	public void setRelationCompanyName(String relationCompanyName) {
		this.relationCompanyName = relationCompanyName;
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
        sb.append("]:"); 
        sb.append(pinKey);
        sb.append("|");
        sb.append(pinTitle);
        sb.append("|");
        sb.append(pinFirstName);
        sb.append("|");
        sb.append(pinLastName);
        sb.append("|");
        sb.append(pinNickName);
        sb.append("|");
        sb.append(pinGender);
        sb.append("|");
        sb.append(pinNationalityKey);
        sb.append("|");
        sb.append(pinDobStr);
        sb.append("|");
        sb.append(pinDob);
        sb.append("|");
        sb.append(pinEmail);
        sb.append("|");
        sb.append(pinAddress);
        sb.append("|");
        sb.append(pinCityKey);
        sb.append("|");
        sb.append(pinStateKey);
        sb.append("|");
        sb.append(pinCountryKey);
        sb.append("|");
        sb.append(pinRemarks);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(relationCompanyName);
        return sb.toString(); 
    } 

}
