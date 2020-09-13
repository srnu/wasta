/*
 * Created on 3 Jan 2017 ( Time 19:10:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "t_id_specialization_information_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_specialization_information_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdSpecializationInformationViewEntity.countAll", query="SELECT COUNT(x) FROM TIdSpecializationInformationViewEntity x" )
} )
public class TIdSpecializationInformationViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Id
    @Column(name="pes_key", nullable=false)
    private Long       pesKey       ;

    @Column(name="pes_pei_key", nullable=false)
    private Long       pesPeiKey    ;

    @Column(name="pes_specialization_key", nullable=false)
    private Long       pesSpecializationKey ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;

    @Column(name="pes_specialization_value", nullable=false, length=240)
    private String     pesSpecializationValue         ;
    
    @Column(name="pes_specialization_status")
    private String     pesSpecializationStatus;
    



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdSpecializationInformationViewEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pes_key ( BIGINT ) 
    public void setPesKey( Long pesKey ) {
        this.pesKey = pesKey;
    }
    public Long getPesKey() {
        return this.pesKey;
    }

    //--- DATABASE MAPPING : pes_pei_key ( BIGINT ) 
    public void setPesPeiKey( Long pesPeiKey ) {
        this.pesPeiKey = pesPeiKey;
    }
    public Long getPesPeiKey() {
        return this.pesPeiKey;
    }

    //--- DATABASE MAPPING : pes_specialization_key ( BIGINT ) 
    public void setPesSpecializationKey( Long pesSpecializationKey ) {
        this.pesSpecializationKey = pesSpecializationKey;
    }
    public Long getPesSpecializationKey() {
        return this.pesSpecializationKey;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : code ( VARCHAR ) 
    
    public String getPesSpecializationValue() {
		return pesSpecializationValue;
	}

	public void setPesSpecializationValue(String pesSpecializationValue) {
		this.pesSpecializationValue = pesSpecializationValue;
	} 
	
	public String getPesSpecializationStatus() {
		return pesSpecializationStatus;
	}

	public void setPesSpecializationStatus(String pesSpecializationStatus) {
		this.pesSpecializationStatus = pesSpecializationStatus;
	}
	
	
	
	
	

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append("]:"); 
        sb.append(pesKey);
        sb.append("|");
        sb.append(pesPeiKey);
        sb.append("|");
        sb.append(pesSpecializationKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(pesSpecializationValue);
        sb.append("|");
        sb.append(pesSpecializationStatus);
        
        return sb.toString(); 
    }

	

}