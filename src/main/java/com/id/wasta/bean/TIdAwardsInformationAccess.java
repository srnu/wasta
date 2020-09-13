/*
 * Created on 19 Mar 2019 ( Time 15:03:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdAwardsInformationAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long aiaKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long aiaPiaKey;

    @NotNull
    @Size( min = 1, max = 2250 )
    private String aiaAccessInfo;

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
    public void setAiaKey( Long aiaKey ) {
        this.aiaKey = aiaKey ;
    }

    public Long getAiaKey() {
        return this.aiaKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setAiaPiaKey( Long aiaPiaKey ) {
        this.aiaPiaKey = aiaPiaKey;
    }
    public Long getAiaPiaKey() {
        return this.aiaPiaKey;
    }

    public void setAiaAccessInfo( String aiaAccessInfo ) {
        this.aiaAccessInfo = aiaAccessInfo;
    }
    public String getAiaAccessInfo() {
        return this.aiaAccessInfo;
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
        sb.append(aiaKey);
        sb.append("|");
        sb.append(aiaPiaKey);
        sb.append("|");
        sb.append(aiaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 


}
