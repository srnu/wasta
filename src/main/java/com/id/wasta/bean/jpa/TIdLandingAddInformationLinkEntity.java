/*
 * Created on 19 Apr 2019 ( Time 12:50:42 )
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
 * Persistent class for entity stored in table "t_id_landing_add_information_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_landing_add_information_link" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdLandingAddInformationLinkEntity.countAll", query="SELECT COUNT(x) FROM TIdLandingAddInformationLinkEntity x" )
} )
public class TIdLandingAddInformationLinkEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ll_key", nullable=false)
     private Long       llKey        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ll_ld_key", nullable=false)
    private Long       llLdKey      ;

    @Column(name="ll_pin_key", nullable=false)
    private Long       llPinKey     ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdLandingAddInformationLinkEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLlKey( Long llKey ) {
        this.llKey = llKey ;
    }
    public Long getLlKey() {
        return this.llKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ll_ld_key ( BIGINT ) 
    public void setLlLdKey( Long llLdKey ) {
        this.llLdKey = llLdKey;
    }
    public Long getLlLdKey() {
        return this.llLdKey;
    }

    //--- DATABASE MAPPING : ll_pin_key ( BIGINT ) 
    public void setLlPinKey( Long llPinKey ) {
        this.llPinKey = llPinKey;
    }
    public Long getLlPinKey() {
        return this.llPinKey;
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
        sb.append(llKey);
        sb.append("]:"); 
        sb.append(llLdKey);
        sb.append("|");
        sb.append(llPinKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}
