/*
 * Created on 1 Nov 2016 ( Time 10:41:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdCompanyContactLinkSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long cclKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    /*@NotNull
    private Long cclPinKey;*/

    /*@NotNull
    @Size( min = 1, max = 1 )
    private Long cclCompanyRelation;

    @NotNull
    private Long cclCompanyKey;*/

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;

    private TIdReferenceCodesDetail tIdReferenceCodesDetail;
    
    private TIdCompanyMasterSearch tIdCompanyMaster;


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCclKey( Long cclKey ) {
        this.cclKey = cclKey ;
    }

    public Long getCclKey() {
        return this.cclKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    /*public void setCclPinKey( Long cclPinKey ) {
        this.cclPinKey = cclPinKey;
    }
    public Long getCclPinKey() {
        return this.cclPinKey;
    }*/


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
    
    public TIdReferenceCodesDetail getTIdReferenceCodesDetail() {
		return tIdReferenceCodesDetail;
	}
	public void setTIdReferenceCodesDetail(
			TIdReferenceCodesDetail tIdReferenceCodesDetail) {
		this.tIdReferenceCodesDetail = tIdReferenceCodesDetail;
	}

	public TIdCompanyMasterSearch getTIdCompanyMaster() {
		return tIdCompanyMaster;
	}
	public void setTIdCompanyMaster(TIdCompanyMasterSearch tIdCompanyMaster) {
		this.tIdCompanyMaster = tIdCompanyMaster;
	}


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(cclKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 


}
