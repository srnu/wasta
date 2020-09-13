/*
 * Created on 7 Nov 2016 ( Time 16:07:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ReferenceValuesView implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------   

    @NotNull
    private Long detailKey;

    @NotNull
    private Long parentId;

    @NotNull
    @Size( min = 1, max = 240 )
    private String domainName;

    @NotNull
    @Size( min = 1, max = 50 )
    private String value;

    @NotNull
    private Long displayOrder;

    @NotNull
    private Long profileKey;

    @NotNull
    private Long lockKey;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setDetailKey( Long detailKey ) {
        this.detailKey = detailKey;
    }
    public Long getDetailKey() {
        return this.detailKey;
    }

    public void setParentId( Long parentId ) {
        this.parentId = parentId;
    }
    public Long getParentId() {
        return this.parentId;
    }

    public void setDomainName( String domainName ) {
        this.domainName = domainName;
    }
    public String getDomainName() {
        return this.domainName;
    }

    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public void setDisplayOrder( Long displayOrder ) {
        this.displayOrder = displayOrder;
    }
    public Long getDisplayOrder() {
        return this.displayOrder;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
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
        sb.append(detailKey);
        sb.append("|");
        sb.append(parentId);
        sb.append("|");
        sb.append(domainName);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(displayOrder);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        return sb.toString(); 
    } 


}