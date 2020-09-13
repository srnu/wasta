/*
 * Created on 19 Mar 2019 ( Time 15:04:01 )
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
 * Persistent class for entity stored in table "t_id_relationship_information_access"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_relationship_information_access")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdRelationshipInformationAccessEntity.countAll", query="SELECT COUNT(x) FROM TIdRelationshipInformationAccessEntity x" )
} )
public class TIdRelationshipInformationAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ria_key", nullable=false)
    private Long       riaKey       ;

    @Column(name="ria_prl_key", nullable=false) 
    private Long riaPrlKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ria_access_info", nullable=false, length=2250)
    private String     riaAccessInfo ;

    @Column(name="active_status", nullable=false, length=1)
    private String     activeStatus ;

    @Version
    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="created_by", nullable=false)
    private Long       createdBy   ;


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdRelationshipInformationAccessEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setRiaKey( Long riaKey ) {
        this.riaKey = riaKey ;
    }
    public Long getRiaKey() {
        return this.riaKey;
    }
    
    public Long getRiaPrlKey() {
		return riaPrlKey;
	}
	public void setRiaPrlKey(Long riaPrlKey) {
		this.riaPrlKey = riaPrlKey;
	}

	//----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    //--- DATABASE MAPPING : ria_access_info ( VARCHAR ) 
    public void setRiaAccessInfo( String riaAccessInfo ) {
        this.riaAccessInfo = riaAccessInfo;
    }
    public String getRiaAccessInfo() {
        return this.riaAccessInfo;
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
    public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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
        sb.append(riaKey);
        sb.append("]:"); 
        sb.append(riaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 

}