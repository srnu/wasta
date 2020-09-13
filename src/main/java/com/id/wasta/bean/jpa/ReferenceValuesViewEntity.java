/*
 * Created on 7 Nov 2016 ( Time 16:10:23 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Persistent class for entity stored in table "reference_values_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="reference_values_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ReferenceValuesViewEntity.countAll", query="SELECT COUNT(x) FROM ReferenceValuesViewEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReferenceValuesViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------  
    @Id
    @Column(name="detail_key", nullable=false)
    private Long       detailKey    ;

    @Column(name="parent_id", nullable=false)
    private Long       parentId     ;

    @Column(name="domain_name", nullable=false, length=240)
    private String     domainName   ;

    @Column(name="value", nullable=false, length=50)
    private String     value        ;

    @Column(name="display_order", nullable=false)
    private Long       displayOrder ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ReferenceValuesViewEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : detail_key ( BIGINT ) 
    public void setDetailKey( Long detailKey ) {
        this.detailKey = detailKey;
    }
    public Long getDetailKey() {
        return this.detailKey;
    }

    //--- DATABASE MAPPING : parent_id ( BIGINT ) 
    public void setParentId( Long parentId ) {
        this.parentId = parentId;
    }
    public Long getParentId() {
        return this.parentId;
    }

    //--- DATABASE MAPPING : domain_name ( VARCHAR ) 
    public void setDomainName( String domainName ) {
        this.domainName = domainName;
    }
    public String getDomainName() {
        return this.domainName;
    }

    //--- DATABASE MAPPING : value ( VARCHAR ) 
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    //--- DATABASE MAPPING : display_order ( BIGINT ) 
    public void setDisplayOrder( Long displayOrder ) {
        this.displayOrder = displayOrder;
    }
    public Long getDisplayOrder() {
        return this.displayOrder;
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

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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
        sb.append(detailKey);
        sb.append("|");
        sb.append(parentId);
        sb.append("|");
        sb.append(domainName);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(displayOrder);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        return sb.toString(); 
    } 

}