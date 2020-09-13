
/*
 * Created on 22 Feb 2017 ( Time 14:30:16 )
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
import javax.persistence.Version;

/**
 * Persistent class for entity stored in table "t_id_personal_interests_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_personal_interests_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdPersonalInterestsViewEntity.countAll", query="SELECT COUNT(x) FROM TIdPersonalInterestsViewEntity x" )
} )
public class TIdPersonalInterestsViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------  
    @Id
    @Column(name="peri_key", nullable=false)
		
     private Long       key      ;

    @Column(name="peri_pin_key", nullable=false)
		
     private Long       periPinKey   ;

    @Column(name="peri_skill_key", nullable=false)
		
     private Long       periSkillKey ;

    @Column(name="peri_others", length=75)
		
     private String     periOthers   ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="pin_key")
		
     private Long       pinKey       ;

    @Column(name="name", length=240)
		
     private String     name         ;

    @Column(name="skill_category")
		
    private Long       skillCategory ;
    
    
    @Column(name="peri_skill_status")
    private String periSkillStatus;
    
    
    @Column(name="peri_created_by", length=20)
    private Long periCreatedBy;
    
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


	//----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdPersonalInterestsViewEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : peri_key ( BIGINT ) 
    public void setKey( Long key ) {
        this.key = key;
    }
    public Long getKey() {
        return this.key;
    }

    //--- DATABASE MAPPING : peri_pin_key ( BIGINT ) 
    public void setPeriPinKey( Long periPinKey ) {
        this.periPinKey = periPinKey;
    }
    public Long getPeriPinKey() {
        return this.periPinKey;
    }

    //--- DATABASE MAPPING : peri_skill_key ( BIGINT ) 
    public void setPeriSkillKey( Long periSkillKey ) {
        this.periSkillKey = periSkillKey;
    }
    public Long getPeriSkillKey() {
        return this.periSkillKey;
    }

    //--- DATABASE MAPPING : peri_others ( VARCHAR ) 
    public void setPeriOthers( String periOthers ) {
        this.periOthers = periOthers;
    }
    public String getPeriOthers() {
        return this.periOthers;
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

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : pin_key ( BIGINT ) 
    public void setPinKey( Long pinKey ) {
        this.pinKey = pinKey;
    }
    public Long getPinKey() {
        return this.pinKey;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : skill_category ( BIGINT ) 
    public void setSkillCategory( Long skillCategory ) {
        this.skillCategory = skillCategory;
    }
    public Long getSkillCategory() {
        return this.skillCategory;
    }

    public String getPeriSkillStatus() {
		return periSkillStatus;
	}

	public void setPeriSkillStatus(String periSkillStatus) {
		this.periSkillStatus = periSkillStatus;
	}
	
	
	public Long getPeriCreatedBy() {
		return periCreatedBy;
	}

	public void setPeriCreatedBy(Long periCreatedBy) {
		this.periCreatedBy = periCreatedBy;
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
        sb.append(key);
        sb.append("|");
        sb.append(periPinKey);
        sb.append("|");
        sb.append(periSkillKey);
        sb.append("|");
        sb.append(periOthers);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(pinKey);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(skillCategory);
        sb.append("|");
        sb.append(periSkillStatus);
        sb.append("|");
        sb.append(periCreatedBy);
        
        return sb.toString(); 
    } 

}
