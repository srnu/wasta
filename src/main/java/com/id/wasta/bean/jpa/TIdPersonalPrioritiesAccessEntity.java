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
 * Persistent class for entity stored in table "t_id_personal_priorities_access"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_personal_priorities_access")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdPersonalPrioritiesAccessEntity.countAll", query="SELECT COUNT(x) FROM TIdPersonalPrioritiesAccessEntity x" )
} )
public class TIdPersonalPrioritiesAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ppa_key", nullable=false)
    private Long       ppaKey       ;

    @Column(name="ppa_perp_key", nullable=false)
    private Long ppaPerpKey;
    
    @Column(name="ppa_share_type", nullable=false)
    private String shareType; //none, all, oneToOne, group

    @Column(name="ppa_access_type", nullable=false)
    private String accessType; // view, share
    
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ppa_access_info", nullable=false, length=2250)
    private String     ppaAccessInfo ;

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
    public TIdPersonalPrioritiesAccessEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPpaKey( Long ppaKey ) {
        this.ppaKey = ppaKey ;
    }
    public Long getPpaKey() {
        return this.ppaKey;
    }
    
    public Long getPpaPerpKey() {
		return ppaPerpKey;
	}
	public void setPpaPerpKey(Long ppaPerpKey) {
		this.ppaPerpKey = ppaPerpKey;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	//----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ppa_access_info ( VARCHAR ) 
    public void setPpaAccessInfo( String ppaAccessInfo ) {
        this.ppaAccessInfo = ppaAccessInfo;
    }
    public String getPpaAccessInfo() {
        return this.ppaAccessInfo;
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
        sb.append(ppaKey);
        sb.append("]:");
        sb.append(shareType);
        sb.append("|");
        sb.append(accessType);
        sb.append("|");
        sb.append(ppaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 

}