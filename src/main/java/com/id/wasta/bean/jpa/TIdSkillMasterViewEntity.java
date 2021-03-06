
/*
 * Created on 22 Feb 2017 ( Time 12:58:03 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.util.action.CommonConstants;

/**
 * Persistent class for entity stored in table "t_id_skill_master_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_skill_master_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdSkillMasterViewEntity.countAll", query="SELECT COUNT(x) FROM TIdSkillMasterViewEntity x" )
} )
public class TIdSkillMasterViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------  
    @Id
    @Column(name="skill_key", nullable=false)
		
     private Long       key     ;

    @Column(name="code", length=75)
		
     private String     code         ;

    @Column(name="name", nullable=false, length=240)
		
     private String     name         ;

    @Column(name="skill_active_status_key", nullable=false)
		
     private Long       skillActiveStatusKey ;

    @Column(name="skill_category")
		
     private Long       skillCategory ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Column(name="active_from", nullable=false)
		
     private Date       activeFrom   ;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Column(name="active_to")
		
     private Date       activeTo     ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="skill_category_desc", length=240)
		
     private String     skillCategoryDesc ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdSkillMasterViewEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : skill_key ( BIGINT ) 
    public void setKey( Long key ) {
        this.key = key;
    }
    public Long getKey() {
        return this.key;
    }

    //--- DATABASE MAPPING : code ( VARCHAR ) 
    public void setCode( String code ) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : skill_active_status_key ( BIGINT ) 
    public void setSkillActiveStatusKey( Long skillActiveStatusKey ) {
        this.skillActiveStatusKey = skillActiveStatusKey;
    }
    public Long getSkillActiveStatusKey() {
        return this.skillActiveStatusKey;
    }

    //--- DATABASE MAPPING : skill_category ( BIGINT ) 
    public void setSkillCategory( Long skillCategory ) {
        this.skillCategory = skillCategory;
    }
    public Long getSkillCategory() {
        return this.skillCategory;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : active_from ( DATETIME ) 
    public void setActiveFrom( Date activeFrom ) {
        this.activeFrom = activeFrom;
    }
    public Date getActiveFrom() {
        return this.activeFrom;
    }

    //--- DATABASE MAPPING : active_to ( DATETIME ) 
    public void setActiveTo( Date activeTo ) {
        this.activeTo = activeTo;
    }
    public Date getActiveTo() {
        return this.activeTo;
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

    //--- DATABASE MAPPING : skill_category_desc ( VARCHAR ) 
    public void setSkillCategoryDesc( String skillCategoryDesc ) {
        this.skillCategoryDesc = skillCategoryDesc;
    }
    public String getSkillCategoryDesc() {
        return this.skillCategoryDesc;
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
        sb.append(code);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(skillActiveStatusKey);
        sb.append("|");
        sb.append(skillCategory);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(activeFrom);
        sb.append("|");
        sb.append(activeTo);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(skillCategoryDesc);
        return sb.toString(); 
    } 

}
