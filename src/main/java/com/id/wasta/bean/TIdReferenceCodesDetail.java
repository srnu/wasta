/*
 * Created on 1 Nov 2016 ( Time 10:41:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdReferenceCodesDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long rcdDetailKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long rcdHeaderKey;

    @NotNull
    @Size( min = 1, max = 50 )
    private String rcdValue;

    @NotNull
    @Size( min = 1, max = 240 )
    private String rcdAbbreviation;

    @NotNull
    @Size( min = 1, max = 240 )
    private String rcdMeaning;

    @NotNull
    private Long rcdLowRange;

    @NotNull
    private Long rcdHighRange;

    @NotNull
    private Long rcdOrderBy;

    @Size( max = 1 )
    private String rcdSetAsDefault;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setRcdDetailKey( Long rcdDetailKey ) {
        this.rcdDetailKey = rcdDetailKey ;
    }

    public Long getRcdDetailKey() {
        return this.rcdDetailKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setRcdHeaderKey( Long rcdHeaderKey ) {
        this.rcdHeaderKey = rcdHeaderKey;
    }
    public Long getRcdHeaderKey() {
        return this.rcdHeaderKey;
    }

    public void setRcdValue( String rcdValue ) {
        this.rcdValue = rcdValue;
    }
    public String getRcdValue() {
        return this.rcdValue;
    }

    public void setRcdAbbreviation( String rcdAbbreviation ) {
        this.rcdAbbreviation = rcdAbbreviation;
    }
    public String getRcdAbbreviation() {
        return this.rcdAbbreviation;
    }

    public void setRcdMeaning( String rcdMeaning ) {
        this.rcdMeaning = rcdMeaning;
    }
    public String getRcdMeaning() {
        return this.rcdMeaning;
    }

    public void setRcdLowRange( Long rcdLowRange ) {
        this.rcdLowRange = rcdLowRange;
    }
    public Long getRcdLowRange() {
        return this.rcdLowRange;
    }

    public void setRcdHighRange( Long rcdHighRange ) {
        this.rcdHighRange = rcdHighRange;
    }
    public Long getRcdHighRange() {
        return this.rcdHighRange;
    }

    public void setRcdOrderBy( Long rcdOrderBy ) {
        this.rcdOrderBy = rcdOrderBy;
    }
    public Long getRcdOrderBy() {
        return this.rcdOrderBy;
    }

    public void setRcdSetAsDefault( String rcdSetAsDefault ) {
        this.rcdSetAsDefault = rcdSetAsDefault;
    }
    public String getRcdSetAsDefault() {
        return this.rcdSetAsDefault;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(rcdDetailKey);
        sb.append("|");
        sb.append(rcdHeaderKey);
        sb.append("|");
        sb.append(rcdValue);
        sb.append("|");
        sb.append(rcdAbbreviation);
        sb.append("|");
        sb.append(rcdMeaning);
        sb.append("|");
        sb.append(rcdLowRange);
        sb.append("|");
        sb.append(rcdHighRange);
        sb.append("|");
        sb.append(rcdOrderBy);
        sb.append("|");
        sb.append(rcdSetAsDefault);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 


}