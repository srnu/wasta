
/*
 * Created on 1 Nov 2016 ( Time 10:40:36 )
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.id.wasta.util.action.CommonConstants;

/**
 * Persistent class for entity stored in table "t_id_status_master"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_status_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdStatusMasterEntity.countAll", query="SELECT COUNT(x) FROM TIdStatusMasterEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdStatusMasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="wfsm_key", nullable=false)
    private Long       key          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code", nullable=false, length=75)
		
     private String     code         ;

    @Column(name="wfsm_base_key", nullable=false)
		
     private Long       wfsmBaseKey  ;

    @Column(name="wfsm_status_code", nullable=false, length=75)
		
     private String     wfsmStatusCode ;

    @Column(name="name", length=240)
		
     private String     name         ;

    @Column(name="wfsm_abbreviation", length=25)
		
     private String     wfsmAbbreviation ;

    @Column(name="wfsm_status_type", nullable=false, length=1)
		
     private String     wfsmStatusType ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_from")
		
     private Date       activeFrom   ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_to")
		
     private Date       activeTo     ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdStatusMasterEntity() {
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
    //--- DATABASE MAPPING : code ( VARCHAR ) 
    public void setCode( String code ) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    //--- DATABASE MAPPING : wfsm_base_key ( BIGINT ) 
    public void setWfsmBaseKey( Long wfsmBaseKey ) {
        this.wfsmBaseKey = wfsmBaseKey;
    }
    public Long getWfsmBaseKey() {
        return this.wfsmBaseKey;
    }

    //--- DATABASE MAPPING : wfsm_status_code ( VARCHAR ) 
    public void setWfsmStatusCode( String wfsmStatusCode ) {
        this.wfsmStatusCode = wfsmStatusCode;
    }
    public String getWfsmStatusCode() {
        return this.wfsmStatusCode;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : wfsm_abbreviation ( VARCHAR ) 
    public void setWfsmAbbreviation( String wfsmAbbreviation ) {
        this.wfsmAbbreviation = wfsmAbbreviation;
    }
    public String getWfsmAbbreviation() {
        return this.wfsmAbbreviation;
    }

    //--- DATABASE MAPPING : wfsm_status_type ( VARCHAR ) 
    public void setWfsmStatusType( String wfsmStatusType ) {
        this.wfsmStatusType = wfsmStatusType;
    }
    public String getWfsmStatusType() {
        return this.wfsmStatusType;
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
        sb.append(code);
        sb.append("|");
        sb.append(wfsmBaseKey);
        sb.append("|");
        sb.append(wfsmStatusCode);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(wfsmAbbreviation);
        sb.append("|");
        sb.append(wfsmStatusType);
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
        return sb.toString(); 
    } 

}
