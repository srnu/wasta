
/*
 * Created on 20 Feb 2017 ( Time 18:46:23 )
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
 * Persistent class for entity stored in table "t_id_add_potential_services"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_add_potential_services")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdAddPotentialServicesEntity.countAll", query="SELECT COUNT(x) FROM TIdAddPotentialServicesEntity x" )
} )
public class TIdAddPotentialServicesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="aps_key", nullable=false)
    private Long       key       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="aps_pin_key", nullable=false)
		
     private Long       apsPinKey    ;

    @Column(name="aps_skill_key", nullable=false)
		
     private Long       apsSkillKey  ;

    @Column(name="aps_others")
		
     private Long       apsOthers    ;

    @Column(name="aps_city_key")
		
     private Long       apsCityKey   ;

    @Column(name="aps_remarks", length=2000)
		
     private String     apsRemarks   ;
    
    @Column(name="aps_created_by", nullable=false)
    private Long       apsCreatedBy   ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;
    
    
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
    public TIdAddPotentialServicesEntity() {
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
    //--- DATABASE MAPPING : aps_pin_key ( BIGINT ) 
    public void setApsPinKey( Long apsPinKey ) {
        this.apsPinKey = apsPinKey;
    }
    public Long getApsPinKey() {
        return this.apsPinKey;
    }

    //--- DATABASE MAPPING : aps_skill_key ( BIGINT ) 
    public void setApsSkillKey( Long apsSkillKey ) {
        this.apsSkillKey = apsSkillKey;
    }
    public Long getApsSkillKey() {
        return this.apsSkillKey;
    }

    //--- DATABASE MAPPING : aps_others ( BIGINT ) 
    public void setApsOthers( Long apsOthers ) {
        this.apsOthers = apsOthers;
    }
    public Long getApsOthers() {
        return this.apsOthers;
    }

    //--- DATABASE MAPPING : aps_city_key ( BIGINT ) 
    public void setApsCityKey( Long apsCityKey ) {
        this.apsCityKey = apsCityKey;
    }
    public Long getApsCityKey() {
        return this.apsCityKey;
    }

    //--- DATABASE MAPPING : aps_remarks ( VARCHAR ) 
    public void setApsRemarks( String apsRemarks ) {
        this.apsRemarks = apsRemarks;
    }
    public String getApsRemarks() {
        return this.apsRemarks;
    }

    public Long getApsCreatedBy() {
		return apsCreatedBy;
	}
	public void setApsCreatedBy(Long apsCreatedBy) {
		this.apsCreatedBy = apsCreatedBy;
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

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
        sb.append(apsPinKey);
        sb.append("|");
        sb.append(apsSkillKey);
        sb.append("|");
        sb.append(apsOthers);
        sb.append("|");
        sb.append(apsCityKey);
        sb.append("|");
        sb.append(apsRemarks);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdOn);
        return sb.toString(); 
    } 

}
