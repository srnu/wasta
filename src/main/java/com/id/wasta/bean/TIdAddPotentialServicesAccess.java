/*
 * Created on 19 Mar 2019 ( Time 15:03:40 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdAddPotentialServicesAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long apsaKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long apsaApsKey;

    @NotNull
    @Size( min = 1, max = 2250 )
    private String apsaAccessInfo;

    @NotNull
    @Size( min = 1, max = 1 )
    private String activeStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long createdBy;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setApsaKey( Long apsaKey ) {
        this.apsaKey = apsaKey ;
    }

    public Long getApsaKey() {
        return this.apsaKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setApsaApsKey( Long apsaApsKey ) {
        this.apsaApsKey = apsaApsKey;
    }
    public Long getApsaApsKey() {
        return this.apsaApsKey;
    }

    public void setApsaAccessInfo( String apsaAccessInfo ) {
        this.apsaAccessInfo = apsaAccessInfo;
    }
    public String getApsaAccessInfo() {
        return this.apsaAccessInfo;
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

    public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(apsaKey);
        sb.append("|");
        sb.append(apsaApsKey);
        sb.append("|");
        sb.append(apsaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 


}