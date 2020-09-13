/*
 * Created on 19 Mar 2019 ( Time 15:03:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdPersonalPrioritiesAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long ppaKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long ppaPerpKey;

    @NotNull
    @Size( min = 1, max = 2250 )
    private String ppaAccessInfo;

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
    public void setPpaKey( Long ppaKey ) {
        this.ppaKey = ppaKey ;
    }

    public Long getPpaKey() {
        return this.ppaKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPpaPerpKey( Long ppaPerpKey ) {
        this.ppaPerpKey = ppaPerpKey;
    }
    public Long getPpaPerpKey() {
        return this.ppaPerpKey;
    }

    public void setPpaAccessInfo( String ppaAccessInfo ) {
        this.ppaAccessInfo = ppaAccessInfo;
    }
    public String getPpaAccessInfo() {
        return this.ppaAccessInfo;
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
        sb.append(ppaKey);
        sb.append("|");
        sb.append(ppaPerpKey);
        sb.append("|");
        sb.append(ppaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 


}
