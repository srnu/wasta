/*
 * Created on 8 Dec 2016 ( Time 09:59:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 * Persistent class for entity stored in table "t_id_visit_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_visit_information" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdVisitInformationEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdVisitInformationEntitySearch x" )
} )
public class TIdVisitInformationEntitySearch implements Serializable {

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
    
    @Column(name="piv_rel_ship_key")
    private Long pivRelShipKey;
    
    @Column(name="piv_rel_ship_type")
    private String pivRelShipType;
    
    @Column(name="piv_visited_by", nullable=false)
    private Long       pivVisitedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="piv_visited_date", nullable=false)
    private Date       pivVisitedDate ;
/*
    @Column(name="piv_visit_mode", length=100)
    private String     pivVisitMode ;*/

    /*@Column(name="piv_visit_purpose", nullable=false)
    private Long     pivVisitPurpose ;*/

    @Column(name="piv_visit_notes", nullable=false, length=1000)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     pivVisitNotes ;

    @Column(name="piv_visit_priority", nullable=false, length=20)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     pivVisitPriority ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

	// "pivPinKey" (column "piv_pin_key") is not defined by itself because used as FK in a link 
    @Column(name="piv_secretary")
    private Long pivSecretary;
    
    @Column(name="piv_created_by")
    private Long pivCreatedBy;
    
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="piv_pin_key", referencedColumnName="pin_key")
    private TIdPersonalInformationEntitySearch tIdPersonalInformation;
    
    @ManyToOne
    @JoinColumn(name="piv_visit_mode", referencedColumnName="rcd_detail_key")
    private TIdReferenceCodesDetailEntity tIdReferenceCodesDetail;

    @ManyToOne
    @JoinColumn(name="piv_visit_purpose", referencedColumnName="rcd_detail_key")
    private TIdReferenceCodesDetailEntity tIdReferenceCodesDetail2;
   
    @IndexedEmbedded
    @OneToMany(mappedBy="tIdVisitInformationSearch", targetEntity=TIdVisitRemarksEntitySearch.class,cascade = CascadeType.ALL)
    private List<TIdVisitRemarksEntitySearch> listOfVisitRemarks;
    

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdVisitInformationEntitySearch() {
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
   /* public void setPivVisitMode( String pivVisitMode ) {
        this.pivVisitMode = pivVisitMode;
    }
    public String getPivVisitMode() {
        return this.pivVisitMode;
    }*/

    //--- DATABASE MAPPING : piv_visit_purpose ( VARCHAR ) 
    /*public void setPivVisitPurpose( Long pivVisitPurpose ) {
        this.pivVisitPurpose = pivVisitPurpose;
    }
    public Long getPivVisitPurpose() {
        return this.pivVisitPurpose;
    }*/

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

	public TIdReferenceCodesDetailEntity getTIdReferenceCodesDetail() {
		return tIdReferenceCodesDetail;
	}

	public void setTIdReferenceCodesDetail(TIdReferenceCodesDetailEntity tIdReferenceCodesDetail) {
		this.tIdReferenceCodesDetail = tIdReferenceCodesDetail;
	}
	
	public TIdReferenceCodesDetailEntity getTIdReferenceCodesDetail2() {
		return tIdReferenceCodesDetail2;
	}

	public void setTIdReferenceCodesDetail2(
			TIdReferenceCodesDetailEntity tIdReferenceCodesDetail2) {
		this.tIdReferenceCodesDetail2 = tIdReferenceCodesDetail2;
	}

	//----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTIdPersonalInformation( TIdPersonalInformationEntitySearch tIdPersonalInformation ) {
        this.tIdPersonalInformation = tIdPersonalInformation;
    }
    public TIdPersonalInformationEntitySearch getTIdPersonalInformation() {
        return this.tIdPersonalInformation;
    }


    public List<TIdVisitRemarksEntitySearch> getListOfVisitRemarks() {
		return listOfVisitRemarks;
	}

	public void setListOfVisitRemarks(List<TIdVisitRemarksEntitySearch> listOfVisitRemarks) {
		this.listOfVisitRemarks = listOfVisitRemarks;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pivKey);
        sb.append("]:"); 
        sb.append(pivVisitedBy);
        sb.append("|");
        sb.append(pivVisitedDate);
       /* sb.append("|");
        sb.append(pivVisitMode);*/
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
        return sb.toString(); 
    } 

}