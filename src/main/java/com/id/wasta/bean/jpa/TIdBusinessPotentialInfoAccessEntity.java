/*
 * Created on 19 Mar 2019 ( Time 15:04:00 )
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
 * Persistent class for entity stored in table "t_id_business_potential_info_access"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_business_potential_info_access")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdBusinessPotentialInfoAccessEntity.countAll", query="SELECT COUNT(x) FROM TIdBusinessPotentialInfoAccessEntity x" )
} )
public class TIdBusinessPotentialInfoAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="bpia_key", nullable=false)
    private Long       bpiaKey      ;

    @Column(name="bpia_bpi_key")
    private Long bpiaBpiKey;
    
    @Column(name="bpia_share_type", nullable=false)
    private String shareType; //none, all, oneToOne, group
    
    @Column(name="bpia_access_type", nullable=false)
	private String accessType; // view, share
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="bpia_access_info", nullable=false, length=2250)
    private String     bpiaAccessInfo ;

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
    public TIdBusinessPotentialInfoAccessEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setBpiaKey( Long bpiaKey ) {
        this.bpiaKey = bpiaKey ;
    }
    public Long getBpiaKey() {
        return this.bpiaKey;
    }
    
    public Long getBpiaBpiKey() {
		return bpiaBpiKey;
	}
	public void setBpiaBpiKey(Long bpiaBpiKey) {
		this.bpiaBpiKey = bpiaBpiKey;
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

	//----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : bpia_pin_key ( BIGINT ) 

    

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	//--- DATABASE MAPPING : bpia_access_info ( VARCHAR ) 
    public void setBpiaAccessInfo( String bpiaAccessInfo ) {
        this.bpiaAccessInfo = bpiaAccessInfo;
    }
    public String getBpiaAccessInfo() {
        return this.bpiaAccessInfo;
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
        sb.append(bpiaKey);
        sb.append("]:");
        sb.append(shareType);
        sb.append("|");
        sb.append(accessType);
        sb.append("|");
        sb.append(bpiaAccessInfo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(createdBy);
        return sb.toString(); 
    } 

}
