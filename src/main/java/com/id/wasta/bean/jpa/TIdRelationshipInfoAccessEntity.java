/*
 * Created on 25 Apr 2019 ( Time 16:50:41 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**	
 * Persistent class for entity stored in table "t_id_relationship_info_access"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_relationship_info_access" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdRelationshipInfoAccessEntity.countAll", query="SELECT COUNT(x) FROM TIdRelationshipInfoAccessEntity x" )
} )
public class TIdRelationshipInfoAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ria_key", nullable=false)
     private Long       riaKey       ;

    
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ria_prlk_key", nullable=false)
    private Long       riaPrlkKey    ;
    
    @Column(name="ria_relation_type", nullable=false)
    private String riaRelationType;

    @Column(name="ria_relationship", length=30)
    private String     riaRelationship ;

    @Column(name="ria_share_type", nullable=false, length=20)
    private String     riaShareType ;

    @Column(name="ria_access_type", nullable=false, length=20)
    private String     riaAccessType ;

    @Column(name="ria_access_info", nullable=false, length=2250)
    private String     riaAccessInfo ;

    @Column(name="created_by", nullable=false)
    private Long       createdBy    ;

    @Column(name="active_status", nullable=false, length=1)
    private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdRelationshipInfoAccessEntity() {
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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ria_prlk_key ( BIGINT ) 
    public Long getRiaPrlkKey() {
		return riaPrlkKey;
	}
	public void setRiaPrlkKey(Long riaPrlkKey) {
		this.riaPrlkKey = riaPrlkKey;
	}
    
  //--- DATABASE MAPPING : ria_relation_type ( VARCHAR )
    public String getRiaRelationType() {
		return riaRelationType;
	}
	public void setRiaRelationType(String riaRelationType) {
		this.riaRelationType = riaRelationType;
	}

	//--- DATABASE MAPPING : ria_relationship ( VARCHAR ) 
    public void setRiaRelationship( String riaRelationship ) {
        this.riaRelationship = riaRelationship;
    }
    public String getRiaRelationship() {
        return this.riaRelationship;
    }

    //--- DATABASE MAPPING : ria_share_type ( VARCHAR ) 
    public void setRiaShareType( String riaShareType ) {
        this.riaShareType = riaShareType;
    }
    public String getRiaShareType() {
        return this.riaShareType;
    }

    //--- DATABASE MAPPING : ria_access_type ( VARCHAR ) 
    public void setRiaAccessType( String riaAccessType ) {
        this.riaAccessType = riaAccessType;
    }
    public String getRiaAccessType() {
        return this.riaAccessType;
    }

    //--- DATABASE MAPPING : ria_access_info ( VARCHAR ) 
    public void setRiaAccessInfo( String riaAccessInfo ) {
        this.riaAccessInfo = riaAccessInfo;
    }
    public String getRiaAccessInfo() {
        return this.riaAccessInfo;
    }

    //--- DATABASE MAPPING : created_by ( BIGINT ) 
    public void setCreatedBy( Long createdBy ) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
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
        sb.append(riaPrlkKey);
        sb.append("|");
        sb.append(riaRelationship);
        sb.append("|");
        sb.append(riaShareType);
        sb.append("|");
        sb.append(riaAccessType);
        sb.append("|");
        sb.append(riaAccessInfo);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}