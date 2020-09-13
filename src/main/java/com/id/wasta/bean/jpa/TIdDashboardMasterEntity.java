/*
 * Created on 16 Dec 2016 ( Time 13:23:21 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

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
 * Persistent class for entity stored in table "t_id_dashboard_master"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_dashboard_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdDashboardMasterEntity.countAll", query="SELECT COUNT(x) FROM TIdDashboardMasterEntity x" )
} )
public class TIdDashboardMasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="dm_id", nullable=false)
    private Long       dmId         ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="dm_section_name", length=30)
    private String     dmSectionName ;

    @Version
    @Column(name="lock_key")
    private Long       lockKey      ;

    @Column(name="profile_key")
    private Long       profileKey   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdDashboardMasterEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setDmId( Long dmId ) {
        this.dmId = dmId ;
    }
    public Long getDmId() {
        return this.dmId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : dm_section_name ( VARCHAR ) 
    public void setDmSectionName( String dmSectionName ) {
        this.dmSectionName = dmSectionName;
    }
    public String getDmSectionName() {
        return this.dmSectionName;
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
        sb.append(dmId);
        sb.append("]:"); 
        sb.append(dmSectionName);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}