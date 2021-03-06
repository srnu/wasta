/*
 * Created on 1 Nov 2016 ( Time 10:41:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.util.action.CommonConstants;

public class TIdProfileViewDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pvdKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long pvdPinKey;

    @NotNull
    private Long pvdPinViewedbyKey;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date pvdViewedDate;

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
    public void setPvdKey( Long pvdKey ) {
        this.pvdKey = pvdKey ;
    }

    public Long getPvdKey() {
        return this.pvdKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPvdPinKey( Long pvdPinKey ) {
        this.pvdPinKey = pvdPinKey;
    }
    public Long getPvdPinKey() {
        return this.pvdPinKey;
    }

    public void setPvdPinViewedbyKey( Long pvdPinViewedbyKey ) {
        this.pvdPinViewedbyKey = pvdPinViewedbyKey;
    }
    public Long getPvdPinViewedbyKey() {
        return this.pvdPinViewedbyKey;
    }

    public void setPvdViewedDate( Date pvdViewedDate ) {
        this.pvdViewedDate = pvdViewedDate;
    }
    public Date getPvdViewedDate() {
        return this.pvdViewedDate;
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
        sb.append(pvdKey);
        sb.append("|");
        sb.append(pvdPinKey);
        sb.append("|");
        sb.append(pvdPinViewedbyKey);
        sb.append("|");
        sb.append(pvdViewedDate);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 


}
