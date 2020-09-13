
/*
 * Created on 1 Nov 2016 ( Time 10:40:34 )
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
 * Persistent class for entity stored in table "t_id_profile_view_details"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_profile_view_details")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfileViewDetailsEntity.countAll", query="SELECT COUNT(x) FROM TIdProfileViewDetailsEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProfileViewDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pvd_key", nullable=false)
    private Long       pvdKey       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="pvd_pin_key", nullable=false)
		
     private Long       pvdPinKey    ;

    @Column(name="pvd_pin_viewedby_key", nullable=false)
		
     private Long       pvdPinViewedbyKey ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="pvd_viewed_date", nullable=false)
		
     private Date       pvdViewedDate ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdProfileViewDetailsEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPvdKey( Long pvdKey ) {
        this.pvdKey = pvdKey ;
    }
    public Long getPvdKey() {
        return this.pvdKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pvd_pin_key ( BIGINT ) 
    public void setPvdPinKey( Long pvdPinKey ) {
        this.pvdPinKey = pvdPinKey;
    }
    public Long getPvdPinKey() {
        return this.pvdPinKey;
    }

    //--- DATABASE MAPPING : pvd_pin_viewedby_key ( BIGINT ) 
    public void setPvdPinViewedbyKey( Long pvdPinViewedbyKey ) {
        this.pvdPinViewedbyKey = pvdPinViewedbyKey;
    }
    public Long getPvdPinViewedbyKey() {
        return this.pvdPinViewedbyKey;
    }

    //--- DATABASE MAPPING : pvd_viewed_date ( DATETIME ) 
    public void setPvdViewedDate( Date pvdViewedDate ) {
        this.pvdViewedDate = pvdViewedDate;
    }
    public Date getPvdViewedDate() {
        return this.pvdViewedDate;
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

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pvdKey);
        sb.append("]:"); 
        sb.append(pvdPinKey);
        sb.append("|");
        sb.append(pvdPinViewedbyKey);
        sb.append("|");
        sb.append(pvdViewedDate);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}
