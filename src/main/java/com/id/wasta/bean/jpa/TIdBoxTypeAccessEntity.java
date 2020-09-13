/*
 * Created on 2019-11-01 ( Time 12:28:26 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "t_id_box_type_access"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_box_type_access")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdBoxTypeAccessEntity.countAll", query="SELECT COUNT(x) FROM TIdBoxTypeAccessEntity x" )
} )
public class TIdBoxTypeAccessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="bta_key", nullable=false)
    private Long       btaKey       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="bta_menu_type", length=50)
    private String     btaMenuType  ;

    @Column(name="bta_filed_type", length=50)
    private String     btaFiledType ;

    @Column(name="bta_filed_type_2", length=50)
    private String     btaFiledType2 ;

    @Column(name="bta_pin_key")
    private Long       btaPinKey    ;

    @Column(name="bta_share_type", length=15)
    private String     btaShareType ;

    @Column(name="bta_access_type", length=10)
    private String     btaAccessType ;

    @Column(name="bta_remove_access", length=2250)
    private String     btaRemoveAccess ;

    @Column(name="created_by")
    private Long       createdBy    ;

    @Column(name="active_status")
    private String       activeStatus ;

    @Column(name="lock_key")
    private Long       lockKey      ;
    
    
    @Column(name="bta_profile_pin_Key")
    private Long btaProfilePinKey;
    



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdBoxTypeAccessEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setBtaKey( Long btaKey ) {
        this.btaKey = btaKey ;
    }
    public Long getBtaKey() {
        return this.btaKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : bta_menu_type ( VARCHAR ) 
    public void setBtaMenuType( String btaMenuType ) {
        this.btaMenuType = btaMenuType;
    }
    public String getBtaMenuType() {
        return this.btaMenuType;
    }

    //--- DATABASE MAPPING : bta_filed_type ( VARCHAR ) 
    public void setBtaFiledType( String btaFiledType ) {
        this.btaFiledType = btaFiledType;
    }
    public String getBtaFiledType() {
        return this.btaFiledType;
    }

    //--- DATABASE MAPPING : bta_filed_type_2 ( VARCHAR ) 
    public void setBtaFiledType2( String btaFiledType2 ) {
        this.btaFiledType2 = btaFiledType2;
    }
    public String getBtaFiledType2() {
        return this.btaFiledType2;
    }

    //--- DATABASE MAPPING : bta_pin_key ( BIGINT ) 
    public void setBtaPinKey( Long btaPinKey ) {
        this.btaPinKey = btaPinKey;
    }
    public Long getBtaPinKey() {
        return this.btaPinKey;
    }

    //--- DATABASE MAPPING : bta_share_type ( VARCHAR ) 
    public void setBtaShareType( String btaShareType ) {
        this.btaShareType = btaShareType;
    }
    public String getBtaShareType() {
        return this.btaShareType;
    }

    //--- DATABASE MAPPING : bta_access_type ( VARCHAR ) 
    public void setBtaAccessType( String btaAccessType ) {
        this.btaAccessType = btaAccessType;
    }
    public String getBtaAccessType() {
        return this.btaAccessType;
    }

    //--- DATABASE MAPPING : bta_remove_access ( VARCHAR ) 
    public void setBtaRemoveAccess( String btaRemoveAccess ) {
        this.btaRemoveAccess = btaRemoveAccess;
    }
    public String getBtaRemoveAccess() {
        return this.btaRemoveAccess;
    }

    //--- DATABASE MAPPING : created_by ( BIGINT ) 
    public void setCreatedBy( Long createdBy ) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    //--- DATABASE MAPPING : active_status ( BIGINT ) 
    

    public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	//--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }
    
    public Long getBtaProfilePinKey() {
		return btaProfilePinKey;
	}

	public void setBtaProfilePinKey(Long btaProfilePinKey) {
		this.btaProfilePinKey = btaProfilePinKey;
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
        sb.append(btaKey);
        sb.append("]:"); 
        sb.append(btaMenuType);
        sb.append("|");
        sb.append(btaFiledType);
        sb.append("|");
        sb.append(btaFiledType2);
        sb.append("|");
        sb.append(btaPinKey);
        sb.append("|");
        sb.append(btaShareType);
        sb.append("|");
        sb.append(btaAccessType);
        sb.append("|");
        sb.append(btaRemoveAccess);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(btaProfilePinKey);
        return sb.toString(); 
    } 

}
