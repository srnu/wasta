/*
 * Created on 1 Nov 2016 ( Time 10:41:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdLanguageInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pliKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long pliPinKey;

    @NotNull
    private Long pliLanguageKey;

    @Size( max = 1 )
    private String pliProficiency;

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
    public void setPliKey( Long pliKey ) {
        this.pliKey = pliKey ;
    }

    public Long getPliKey() {
        return this.pliKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPliPinKey( Long pliPinKey ) {
        this.pliPinKey = pliPinKey;
    }
    public Long getPliPinKey() {
        return this.pliPinKey;
    }

    public void setPliLanguageKey( Long pliLanguageKey ) {
        this.pliLanguageKey = pliLanguageKey;
    }
    public Long getPliLanguageKey() {
        return this.pliLanguageKey;
    }

    public void setPliProficiency( String pliProficiency ) {
        this.pliProficiency = pliProficiency;
    }
    public String getPliProficiency() {
        return this.pliProficiency;
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
        sb.append(pliKey);
        sb.append("|");
        sb.append(pliPinKey);
        sb.append("|");
        sb.append(pliLanguageKey);
        sb.append("|");
        sb.append(pliProficiency);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 


}