/*
 * Created on 19 Mar 2019 ( Time 15:03:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdBusinessPotentialInfoAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long bpiaKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long bpiaBpiKey;

    @NotNull
    @Size( min = 1, max = 2250 )
    private String bpiaAccessInfo;

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
    public void setBpiaKey( Long bpiaKey ) {
        this.bpiaKey = bpiaKey ;
    }

    public Long getBpiaKey() {
        return this.bpiaKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setBpiaBpiKey( Long bpiaBpiKey ) {
        this.bpiaBpiKey = bpiaBpiKey;
    }
    public Long getBpiaBpiKey() {
        return this.bpiaBpiKey;
    }

    public void setBpiaAccessInfo( String bpiaAccessInfo ) {
        this.bpiaAccessInfo = bpiaAccessInfo;
    }
    public String getBpiaAccessInfo() {
        return this.bpiaAccessInfo;
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
        sb.append(bpiaKey);
        sb.append("|");
        sb.append(bpiaBpiKey);
        sb.append("|");
        sb.append(bpiaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 


}
