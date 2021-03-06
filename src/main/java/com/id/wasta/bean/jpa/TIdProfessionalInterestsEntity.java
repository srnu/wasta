
/*
 * Created on 20 Feb 2017 ( Time 18:42:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.util.Date;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Persistent class for entity stored in table "t_id_professional_interests"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_professional_interests")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfessionalInterestsEntity.countAll", query="SELECT COUNT(x) FROM TIdProfessionalInterestsEntity x" )
} )
public class TIdProfessionalInterestsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pri_key", nullable=false)
    private Long       key       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="pri_pin_key", nullable=false)
		
     private Long       priPinKey    ;

    @Column(name="pri_skill_key", nullable=false)
		
     private Long       priSkillKey  ;

    @Column(name="pri_others", length=75)
		
     private String     priOthers    ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;
    
    
    @Column(name="pri_created_by", length=20)
    private Long priCreatedBy;
    
    
    @Column(name="created_on")
    private Date createdOn;

    
    public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdProfessionalInterestsEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setKey( Long key ) {
        this.key = key ;
    }
    public Long getKey() {
        return this.key;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pri_pin_key ( BIGINT ) 
    public void setPriPinKey( Long priPinKey ) {
        this.priPinKey = priPinKey;
    }
    public Long getPriPinKey() {
        return this.priPinKey;
    }

    //--- DATABASE MAPPING : pri_skill_key ( BIGINT ) 
    public void setPriSkillKey( Long priSkillKey ) {
        this.priSkillKey = priSkillKey;
    }
    public Long getPriSkillKey() {
        return this.priSkillKey;
    }

    //--- DATABASE MAPPING : pri_others ( VARCHAR ) 
    public void setPriOthers( String priOthers ) {
        this.priOthers = priOthers;
    }
    public String getPriOthers() {
        return this.priOthers;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }
    
    


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    

	public Long getPriCreatedBy() {
		return priCreatedBy;
	}

	public void setPriCreatedBy(Long priCreatedBy) {
		this.priCreatedBy = priCreatedBy;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
        sb.append(priPinKey);
        sb.append("|");
        sb.append(priSkillKey);
        sb.append("|");
        sb.append(priOthers);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(priCreatedBy); 
        sb.append("|");
        sb.append(createdOn);
        return sb.toString(); 
    } 

}
