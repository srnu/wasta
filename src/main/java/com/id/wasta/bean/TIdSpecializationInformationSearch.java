/*
 * Created on 2 Jan 2017 ( Time 15:59:48 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdSpecializationInformationSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pesKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
   /* @NotNull
    private Long pesPeiKey;*/

   /* @NotNull
    private Long pesSpecializationKey;
*/
    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;
    
    private TIdSpecializationMasterSearch tIdSpecializationMaster;

   // private TIdEducationalInformationSearch tIdEducationalInformation;

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPesKey( Long pesKey ) {
        this.pesKey = pesKey ;
    }

    public Long getPesKey() {
        return this.pesKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
   /* public void setPesPeiKey( Long pesPeiKey ) {
        this.pesPeiKey = pesPeiKey;
    }
    public Long getPesPeiKey() {
        return this.pesPeiKey;
    }*/

   /* public void setPesSpecializationKey( Long pesSpecializationKey ) {
        this.pesSpecializationKey = pesSpecializationKey;
    }
    public Long getPesSpecializationKey() {
        return this.pesSpecializationKey;
    }
*/
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

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

	/*public TIdEducationalInformationSearch getTIdEducationalInformation() {
		return tIdEducationalInformation;
	}

	public void setTIdEducationalInformation(TIdEducationalInformationSearch tIdEducationalInformation) {
		this.tIdEducationalInformation = tIdEducationalInformation;
	}*/ 
    public TIdSpecializationMasterSearch getTIdSpecializationMaster() {
		return tIdSpecializationMaster;
	}

	public void setTIdSpecializationMaster(TIdSpecializationMasterSearch tIdSpecializationMaster) {
		this.tIdSpecializationMaster = tIdSpecializationMaster;
	}
		
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
      

		public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(pesKey);
        /*sb.append("|");
        sb.append(pesPeiKey);*/
        /*sb.append("|");
        sb.append(pesSpecializationKey);
*/        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(activeStatus);
        return sb.toString(); 
    }



}
