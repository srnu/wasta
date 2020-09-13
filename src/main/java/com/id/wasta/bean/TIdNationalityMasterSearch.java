/*
 * Created on 20 Nov 2016 ( Time 14:55:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

/**
 * Persistent class for entity stored in table "t_id_nationality_master"
 *
 * @author Telosys Tools Generator
 *
 */

public class TIdNationalityMasterSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long       key          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String     code         ;

    private String     name         ;

    private Long       nationalityCountryKey ;

    private Long       nationalityActiveFlag ;

    private Date       activeFrom   ;

    private Date       activeTo     ;

    private String     activeStatus ;

    private String nationalityLanguage ;
    
    private Long       profileKey   ;

    private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //private List<TIdPersonalInformationSearch> listOfTIdPersonalInformation;
    
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdNationalityMasterSearch() {
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
    //--- DATABASE MAPPING : code ( VARCHAR ) 
    public void setCode( String code ) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : nationality_country_key ( BIGINT ) 
    public void setNationalityCountryKey( Long nationalityCountryKey ) {
        this.nationalityCountryKey = nationalityCountryKey;
    }
    public Long getNationalityCountryKey() {
        return this.nationalityCountryKey;
    }

    //--- DATABASE MAPPING : nationality_active_flag ( BIGINT ) 
    public void setNationalityActiveFlag( Long nationalityActiveFlag ) {
        this.nationalityActiveFlag = nationalityActiveFlag;
    }
    public Long getNationalityActiveFlag() {
        return this.nationalityActiveFlag;
    }

    //--- DATABASE MAPPING : active_from ( DATETIME ) 
    public void setActiveFrom( Date activeFrom ) {
        this.activeFrom = activeFrom;
    }
    public Date getActiveFrom() {
        return this.activeFrom;
    }

    //--- DATABASE MAPPING : active_to ( DATE ) 
    public void setActiveTo( Date activeTo ) {
        this.activeTo = activeTo;
    }
    public Date getActiveTo() {
        return this.activeTo;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    public String getNationalityLanguage() {
		return nationalityLanguage;
	}
	public void setNationalityLanguage(String nationalityLanguage) {
		this.nationalityLanguage = nationalityLanguage;
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


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    /*public List<TIdPersonalInformationSearch> getListOfTIdPersonalInformation() {
		return listOfTIdPersonalInformation;
	}

	public void setListOfTIdPersonalInformation(
			List<TIdPersonalInformationSearch> listOfTIdPersonalInformation) {
		this.listOfTIdPersonalInformation = listOfTIdPersonalInformation;
	}*/

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
        sb.append(code);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(nationalityCountryKey);
        sb.append("|");
        sb.append(nationalityActiveFlag);
        sb.append("|");
        sb.append(activeFrom);
        sb.append("|");
        sb.append(activeTo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
