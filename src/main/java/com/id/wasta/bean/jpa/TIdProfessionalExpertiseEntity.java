
/*
 * Created on 20 Feb 2017 ( Time 18:41:29 )
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

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Persistent class for entity stored in table "t_id_professional_expertise"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_professional_expertise")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfessionalExpertiseEntity.countAll", query="SELECT COUNT(x) FROM TIdProfessionalExpertiseEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProfessionalExpertiseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ppe_key", nullable=false)
    private Long       key       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ppe_skill_key", nullable=false)
		
     private Long       ppeSkillKey  ;

    @Column(name="ppe_pin_key")
		
     private Long       ppePinKey    ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    

    @Column(name="ppe_created_by", length=20)
    private Long ppeCreatedBy;
    
    
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
    public TIdProfessionalExpertiseEntity() {
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
    //--- DATABASE MAPPING : ppe_skill_key ( BIGINT ) 
    public void setPpeSkillKey( Long ppeSkillKey ) {
        this.ppeSkillKey = ppeSkillKey;
    }
    public Long getPpeSkillKey() {
        return this.ppeSkillKey;
    }

    //--- DATABASE MAPPING : ppe_pin_key ( BIGINT ) 
    public void setPpePinKey( Long ppePinKey ) {
        this.ppePinKey = ppePinKey;
    }
    public Long getPpePinKey() {
        return this.ppePinKey;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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
    
    
    


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    public Long getPpeCreatedBy() {
		return ppeCreatedBy;
	}

	public void setPpeCreatedBy(Long ppeCreatedBy) {
		this.ppeCreatedBy = ppeCreatedBy;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
        sb.append(ppeSkillKey);
        sb.append("|");
        sb.append(ppePinKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(ppeCreatedBy);
        sb.append("|");
        sb.append(createdOn);
        return sb.toString(); 
    } 

}
