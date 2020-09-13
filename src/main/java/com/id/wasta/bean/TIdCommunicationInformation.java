/*
 * Created on 4 Nov 2016 ( Time 12:24:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdCommunicationInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pcmKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private Long pcmPinKey;
    
    @NotNull
    @Size( min = 1, max = 1 )
    private String pcmType;

    @NotNull
    @Size( min = 1, max = 75 )
    private String pcmDescription;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;
    
    private boolean viewAccessFlag = true; 
    
	//----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPcmKey( Long pcmKey ) {
        this.pcmKey = pcmKey ;
    }

    public Long getPcmKey() {
        return this.pcmKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    public Long getPcmPinKey() {
		return pcmPinKey;
	}

	public void setPcmPinKey(Long pcmPinKey) {
		this.pcmPinKey = pcmPinKey;
	}

	public void setPcmType( String pcmType ) {
        this.pcmType = pcmType;
    }
    public String getPcmType() {
        return this.pcmType;
    }

    public void setPcmDescription( String pcmDescription ) {
        this.pcmDescription = pcmDescription;
    }
    public String getPcmDescription() {
        return this.pcmDescription;
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

    public boolean isViewAccessFlag() {
		return viewAccessFlag;
	}
	public void setViewAccessFlag(boolean viewAccessFlag) {
		this.viewAccessFlag = viewAccessFlag;
	}

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(pcmKey);
        sb.append("|");
        sb.append(pcmType);
        sb.append("|");
        sb.append(pcmDescription);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 


}
