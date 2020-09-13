
/*
 * Created on 1 Nov 2016 ( Time 10:40:37 )
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

/**
 * Persistent class for entity stored in table "t_id_visit_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_visit_information")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdVisitInformationEntity.countAll", query="SELECT COUNT(x) FROM TIdVisitInformationEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdVisitInformationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="piv_key", nullable=false)
    private Long       pivKey       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="piv_pin_key", nullable=false)
		
     private Long       pivPinKey    ;

    @Column(name="piv_rel_ship_key")
    private Long pivRelShipKey;
    
    @Column(name="piv_rel_ship_type")
    private String pivRelShipType;
    
    @Column(name="piv_visited_by", nullable=false)
	 private Long       pivVisitedBy ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="piv_visited_date", nullable=false)
	 private Date       pivVisitedDate ;

    @Column(name="piv_visit_mode")
	 private Long     pivVisitMode ;

    @Column(name="piv_visit_purpose", nullable=false)
	 private Long     pivVisitPurpose ;

    @Column(name="piv_visit_notes", nullable=false, length=1000)
	private String     pivVisitNotes ;

    @Column(name="piv_visit_priority", nullable=false, length=1)
	private String     pivVisitPriority ;

    @Column(name="active_status", nullable=false, length=75)
	 private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
    @Version
     private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
     private Long       profileKey   ;

    @Column(name="piv_secretary", nullable=false)
    private Long pivSecretary;
    
    @Column(name="piv_created_by")
    private Long pivCreatedBy;
    
    
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
    public TIdVisitInformationEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPivKey( Long pivKey ) {
        this.pivKey = pivKey ;
    }
    public Long getPivKey() {
        return this.pivKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : piv_pin_key ( BIGINT ) 
    public void setPivPinKey( Long pivPinKey ) {
        this.pivPinKey = pivPinKey;
    }
    public Long getPivPinKey() {
        return this.pivPinKey;
    }
    
    public Long getPivRelShipKey() {
		return pivRelShipKey;
	}
	public void setPivRelShipKey(Long pivRelShipKey) {
		this.pivRelShipKey = pivRelShipKey;
	}

	public String getPivRelShipType() {
		return pivRelShipType;
	}
	public void setPivRelShipType(String pivRelShipType) {
		this.pivRelShipType = pivRelShipType;
	}

	//--- DATABASE MAPPING : piv_visited_by ( BIGINT ) 
    public void setPivVisitedBy( Long pivVisitedBy ) {
        this.pivVisitedBy = pivVisitedBy;
    }
    public Long getPivVisitedBy() {
        return this.pivVisitedBy;
    }

    //--- DATABASE MAPPING : piv_visited_date ( DATETIME ) 
    public void setPivVisitedDate( Date pivVisitedDate ) {
        this.pivVisitedDate = pivVisitedDate;
    }
    public Date getPivVisitedDate() {
        return this.pivVisitedDate;
    }

    //--- DATABASE MAPPING : piv_visit_mode ( VARCHAR ) 
    public void setPivVisitMode( Long pivVisitMode ) {
        this.pivVisitMode = pivVisitMode;
    }
    public Long getPivVisitMode() {
        return this.pivVisitMode;
    }

    //--- DATABASE MAPPING : piv_visit_purpose ( VARCHAR ) 
    public void setPivVisitPurpose( Long pivVisitPurpose ) {
        this.pivVisitPurpose = pivVisitPurpose;
    }
    public Long getPivVisitPurpose() {
        return this.pivVisitPurpose;
    }

    //--- DATABASE MAPPING : piv_visit_notes ( VARCHAR ) 
    public void setPivVisitNotes( String pivVisitNotes ) {
        this.pivVisitNotes = pivVisitNotes;
    }
    public String getPivVisitNotes() {
        return this.pivVisitNotes;
    }

    //--- DATABASE MAPPING : piv_visit_priority ( VARCHAR ) 
    public void setPivVisitPriority( String pivVisitPriority ) {
        this.pivVisitPriority = pivVisitPriority;
    }
    public String getPivVisitPriority() {
        return this.pivVisitPriority;
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

    public Long getPivSecretary() {
		return pivSecretary;
	}

	public void setPivSecretary(Long pivSecretary) {
		this.pivSecretary = pivSecretary;
	}
	
	public Long getPivCreatedBy() {
		return pivCreatedBy;
	}

	public void setPivCreatedBy(Long pivCreatedBy) {
		this.pivCreatedBy = pivCreatedBy;
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
        sb.append(pivKey);
        sb.append("]:"); 
        sb.append(pivPinKey);
        sb.append("|");
        sb.append(pivVisitedBy);
        sb.append("|");
        sb.append(pivVisitedDate);
        sb.append("|");
        sb.append(pivVisitMode);
        sb.append("|");
        sb.append(pivVisitPurpose);
        sb.append("|");
        sb.append(pivVisitNotes);
        sb.append("|");
        sb.append(pivVisitPriority);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(createdOn);
        
        return sb.toString(); 
    } 

}