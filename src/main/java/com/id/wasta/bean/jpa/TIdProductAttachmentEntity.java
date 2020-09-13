
/*
 * Created on 1 Nov 2016 ( Time 10:40:34 )
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
import com.id.wasta.util.action.CommonConstants;

/**
 * Persistent class for entity stored in table "t_id_product_attachment"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_product_attachment")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProductAttachmentEntity.countAll", query="SELECT COUNT(x) FROM TIdProductAttachmentEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProductAttachmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="patt_key", nullable=false)
    private Long       pattKey      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="patt_product_key", nullable=false)
		
     private Long       pattProductKey ;

    @Column(name="patt_reference_type", nullable=false, length=1)
		
     private String     pattReferenceType ;

    @Column(name="patt_reference_key", nullable=false)
		
     private Long       pattReferenceKey ;

    @Column(name="patt_serial", nullable=false)
		
     private Long       pattSerial   ;

    @Column(name="patt_direction", length=1)
		
     private String     pattDirection ;

    @Column(name="patt_infobase_key", nullable=false)
		
     private Long       pattInfobaseKey ;

    @Column(name="patt_file_path_key", nullable=false)
		
     private Long       pattFilePathKey ;

    @Column(name="patt_file_name", nullable=false, length=240)
		
     private String     pattFileName ;

    @Column(name="patt_file_type", nullable=false, length=10)
		
     private String     pattFileType ;

    @Column(name="patt_uploaded_by", nullable=false)
		
     private Long       pattUploadedBy ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="patt_uploaded_on", nullable=false)
		
     private Date       pattUploadedOn ;

    @Column(name="patt_uploaded_ip", nullable=false, length=75)
		
     private String     pattUploadedIp ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="patt_internal_file_name", length=240)
		
     private String     pattInternalFileName ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="patt_active_from")
		
     private Date       pattActiveFrom ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="patt_active_to")
		
     private Date       pattActiveTo ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdProductAttachmentEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPattKey( Long pattKey ) {
        this.pattKey = pattKey ;
    }
    public Long getPattKey() {
        return this.pattKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : patt_product_key ( BIGINT ) 
    public void setPattProductKey( Long pattProductKey ) {
        this.pattProductKey = pattProductKey;
    }
    public Long getPattProductKey() {
        return this.pattProductKey;
    }

    //--- DATABASE MAPPING : patt_reference_type ( VARCHAR ) 
    public void setPattReferenceType( String pattReferenceType ) {
        this.pattReferenceType = pattReferenceType;
    }
    public String getPattReferenceType() {
        return this.pattReferenceType;
    }

    //--- DATABASE MAPPING : patt_reference_key ( BIGINT ) 
    public void setPattReferenceKey( Long pattReferenceKey ) {
        this.pattReferenceKey = pattReferenceKey;
    }
    public Long getPattReferenceKey() {
        return this.pattReferenceKey;
    }

    //--- DATABASE MAPPING : patt_serial ( BIGINT ) 
    public void setPattSerial( Long pattSerial ) {
        this.pattSerial = pattSerial;
    }
    public Long getPattSerial() {
        return this.pattSerial;
    }

    //--- DATABASE MAPPING : patt_direction ( VARCHAR ) 
    public void setPattDirection( String pattDirection ) {
        this.pattDirection = pattDirection;
    }
    public String getPattDirection() {
        return this.pattDirection;
    }

    //--- DATABASE MAPPING : patt_infobase_key ( BIGINT ) 
    public void setPattInfobaseKey( Long pattInfobaseKey ) {
        this.pattInfobaseKey = pattInfobaseKey;
    }
    public Long getPattInfobaseKey() {
        return this.pattInfobaseKey;
    }

    //--- DATABASE MAPPING : patt_file_path_key ( BIGINT ) 
    public void setPattFilePathKey( Long pattFilePathKey ) {
        this.pattFilePathKey = pattFilePathKey;
    }
    public Long getPattFilePathKey() {
        return this.pattFilePathKey;
    }

    //--- DATABASE MAPPING : patt_file_name ( VARCHAR ) 
    public void setPattFileName( String pattFileName ) {
        this.pattFileName = pattFileName;
    }
    public String getPattFileName() {
        return this.pattFileName;
    }

    //--- DATABASE MAPPING : patt_file_type ( VARCHAR ) 
    public void setPattFileType( String pattFileType ) {
        this.pattFileType = pattFileType;
    }
    public String getPattFileType() {
        return this.pattFileType;
    }

    //--- DATABASE MAPPING : patt_uploaded_by ( BIGINT ) 
    public void setPattUploadedBy( Long pattUploadedBy ) {
        this.pattUploadedBy = pattUploadedBy;
    }
    public Long getPattUploadedBy() {
        return this.pattUploadedBy;
    }

    //--- DATABASE MAPPING : patt_uploaded_on ( DATETIME ) 
    public void setPattUploadedOn( Date pattUploadedOn ) {
        this.pattUploadedOn = pattUploadedOn;
    }
    public Date getPattUploadedOn() {
        return this.pattUploadedOn;
    }

    //--- DATABASE MAPPING : patt_uploaded_ip ( VARCHAR ) 
    public void setPattUploadedIp( String pattUploadedIp ) {
        this.pattUploadedIp = pattUploadedIp;
    }
    public String getPattUploadedIp() {
        return this.pattUploadedIp;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : patt_internal_file_name ( VARCHAR ) 
    public void setPattInternalFileName( String pattInternalFileName ) {
        this.pattInternalFileName = pattInternalFileName;
    }
    public String getPattInternalFileName() {
        return this.pattInternalFileName;
    }

    //--- DATABASE MAPPING : patt_active_from ( DATETIME ) 
    public void setPattActiveFrom( Date pattActiveFrom ) {
        this.pattActiveFrom = pattActiveFrom;
    }
    public Date getPattActiveFrom() {
        return this.pattActiveFrom;
    }

    //--- DATABASE MAPPING : patt_active_to ( DATETIME ) 
    public void setPattActiveTo( Date pattActiveTo ) {
        this.pattActiveTo = pattActiveTo;
    }
    public Date getPattActiveTo() {
        return this.pattActiveTo;
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


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pattKey);
        sb.append("]:"); 
        sb.append(pattProductKey);
        sb.append("|");
        sb.append(pattReferenceType);
        sb.append("|");
        sb.append(pattReferenceKey);
        sb.append("|");
        sb.append(pattSerial);
        sb.append("|");
        sb.append(pattDirection);
        sb.append("|");
        sb.append(pattInfobaseKey);
        sb.append("|");
        sb.append(pattFilePathKey);
        sb.append("|");
        sb.append(pattFileName);
        sb.append("|");
        sb.append(pattFileType);
        sb.append("|");
        sb.append(pattUploadedBy);
        sb.append("|");
        sb.append(pattUploadedOn);
        sb.append("|");
        sb.append(pattUploadedIp);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(pattInternalFileName);
        sb.append("|");
        sb.append(pattActiveFrom);
        sb.append("|");
        sb.append(pattActiveTo);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
