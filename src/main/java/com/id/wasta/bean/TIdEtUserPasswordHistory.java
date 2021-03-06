/*
 * Created on 13 Nov 2017 ( Time 18:26:39 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TIdEtUserPasswordHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long uphId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long uphUserId;

    @NotNull
    @Size( min = 1, max = 200 )
    private String uphPasswordHash;

    @NotNull
    private Long profileKey;
    
    private Long uphLockCount;
    
    @NotNull
    private Long lockKey;

    @NotNull
    private Long activeStatus;

    @NotNull
    private Date createdOn;


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUphId( Long uphId ) {
        this.uphId = uphId ;
    }

    public Long getUphId() {
        return this.uphId;
    }

    public Long getUphLockCount() {
		return uphLockCount;
	}

	public void setUphLockCount(Long uphLockCount) {
		this.uphLockCount = uphLockCount;
	}

	//----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setUphUserId( Long uphUserId ) {
        this.uphUserId = uphUserId;
    }
    public Long getUphUserId() {
        return this.uphUserId;
    }

    public void setUphPasswordHash( String uphPasswordHash ) {
        this.uphPasswordHash = uphPasswordHash;
    }
    public String getUphPasswordHash() {
        return this.uphPasswordHash;
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

    public void setActiveStatus( Long activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public Long getActiveStatus() {
        return this.activeStatus;
    }

    public void setCreatedOn( Date createdOn ) {
        this.createdOn = createdOn;
    }
    public Date getCreatedOn() {
        return this.createdOn;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        @Override
		public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(uphId);
        sb.append("|");
        sb.append(uphUserId);
        sb.append("|");
        sb.append(uphPasswordHash);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(createdOn);
        return sb.toString(); 
    } 


}
