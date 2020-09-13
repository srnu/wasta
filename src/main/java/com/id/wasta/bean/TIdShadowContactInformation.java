/*
 * Created on 1 Nov 2016 ( Time 10:41:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdShadowContactInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pscKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 1 )
    private String pscTitle;

    @NotNull
    @Size( min = 1, max = 240 )
    private String pscFirstName;

    @Size( max = 240 )
    private String pscLastName;


    private Long pscCompanyKey;


    private Long pscDesignationKey;


    private Long pscFunctionalAreaKey;


    private Long pscRoleKey;


    private Long pscCityKey;


    private Long pscStateKey;


    private Long pscCountryKey;

    @Size( max = 1 )
    private String pscTraslateStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPscKey( Long pscKey ) {
        this.pscKey = pscKey ;
    }

    public Long getPscKey() {
        return this.pscKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPscTitle( String pscTitle ) {
        this.pscTitle = pscTitle;
    }
    public String getPscTitle() {
        return this.pscTitle;
    }

    public void setPscFirstName( String pscFirstName ) {
        this.pscFirstName = pscFirstName;
    }
    public String getPscFirstName() {
        return this.pscFirstName;
    }

    public void setPscLastName( String pscLastName ) {
        this.pscLastName = pscLastName;
    }
    public String getPscLastName() {
        return this.pscLastName;
    }

    public void setPscCompanyKey( Long pscCompanyKey ) {
        this.pscCompanyKey = pscCompanyKey;
    }
    public Long getPscCompanyKey() {
        return this.pscCompanyKey;
    }

    public void setPscDesignationKey( Long pscDesignationKey ) {
        this.pscDesignationKey = pscDesignationKey;
    }
    public Long getPscDesignationKey() {
        return this.pscDesignationKey;
    }

    public void setPscFunctionalAreaKey( Long pscFunctionalAreaKey ) {
        this.pscFunctionalAreaKey = pscFunctionalAreaKey;
    }
    public Long getPscFunctionalAreaKey() {
        return this.pscFunctionalAreaKey;
    }

    public void setPscRoleKey( Long pscRoleKey ) {
        this.pscRoleKey = pscRoleKey;
    }
    public Long getPscRoleKey() {
        return this.pscRoleKey;
    }

    public void setPscCityKey( Long pscCityKey ) {
        this.pscCityKey = pscCityKey;
    }
    public Long getPscCityKey() {
        return this.pscCityKey;
    }

    public void setPscStateKey( Long pscStateKey ) {
        this.pscStateKey = pscStateKey;
    }
    public Long getPscStateKey() {
        return this.pscStateKey;
    }

    public void setPscCountryKey( Long pscCountryKey ) {
        this.pscCountryKey = pscCountryKey;
    }
    public Long getPscCountryKey() {
        return this.pscCountryKey;
    }

    public void setPscTraslateStatus( String pscTraslateStatus ) {
        this.pscTraslateStatus = pscTraslateStatus;
    }
    public String getPscTraslateStatus() {
        return this.pscTraslateStatus;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(pscKey);
        sb.append("|");
        sb.append(pscTitle);
        sb.append("|");
        sb.append(pscFirstName);
        sb.append("|");
        sb.append(pscLastName);
        sb.append("|");
        sb.append(pscCompanyKey);
        sb.append("|");
        sb.append(pscDesignationKey);
        sb.append("|");
        sb.append(pscFunctionalAreaKey);
        sb.append("|");
        sb.append(pscRoleKey);
        sb.append("|");
        sb.append(pscCityKey);
        sb.append("|");
        sb.append(pscStateKey);
        sb.append("|");
        sb.append(pscCountryKey);
        sb.append("|");
        sb.append(pscTraslateStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(activeStatus);
        return sb.toString(); 
    } 


}