/*
 * Created on 24 Nov 2016 ( Time 15:55:49 )
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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "t_id_change_log_details"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_change_log_details" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdChangeLogDetailsEntity.countAll", query="SELECT COUNT(x) FROM TIdChangeLogDetailsEntity x" )
} )
public class TIdChangeLogDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Id
    @Column(name="tchg_table_name", nullable=false, length=75)
    private String     tchgTableName ;

    @Column(name="tchg_column_name", nullable=false, length=75)
    private String     tchgColumnName ;

    @Column(name="tchg_serial", nullable=false)
    private Long       tchgSerial   ;

    @Column(name="tchg_change_type", nullable=false, length=1)
    private String     tchgChangeType ;

    @Column(name="tchg_table_key_col_name_1", nullable=false, length=240)
    private String     tchgTableKeyColName1 ;

    @Column(name="tchg_table_key_col_value_1", nullable=false)
    private Long       tchgTableKeyColValue1 ;

    @Column(name="tchg_table_key_col_name_2", length=240)
    private String     tchgTableKeyColName2 ;

    @Column(name="tchg_table_key_col_value_2")
    private Long       tchgTableKeyColValue2 ;

    @Column(name="tchg_table_key_col_name_3", length=240)
    private String     tchgTableKeyColName3 ;

    @Column(name="tchg_table_key_col_value_3")
    private Long       tchgTableKeyColValue3 ;

    @Column(name="tchg_table_key_col_name_4", length=240)
    private String     tchgTableKeyColName4 ;

    @Column(name="tchg_table_key_col_value_4")
    private Long       tchgTableKeyColValue4 ;

    @Column(name="tchg_table_key_col_name_5", length=240)
    private String     tchgTableKeyColName5 ;

    @Column(name="tchg_table_key_col_value_5")
    private Long       tchgTableKeyColValue5 ;

    @Column(name="tchg_table_old_char_value", length=4000)
    private String     tchgTableOldCharValue ;

    @Column(name="tchg_table_new_char_value", length=4000)
    private String     tchgTableNewCharValue ;

    @Column(name="tchg_table_old_num_value")
    private Long       tchgTableOldNumValue ;

    @Column(name="tchg_table_new_num_value")
    private Long       tchgTableNewNumValue ;

    @Temporal(TemporalType.DATE)
    @Column(name="tchg_table_old_date_value")
    private Date       tchgTableOldDateValue ;

    @Temporal(TemporalType.DATE)
    @Column(name="tchg_table_new_date_value")
    private Date       tchgTableNewDateValue ;

    @Column(name="tchg_modified_by", nullable=false)
    private Long       tchgModifiedBy ;

    @Temporal(TemporalType.DATE)
    @Column(name="tchg_modified_on", nullable=false)
    private Date       tchgModifiedOn ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tchg_time_stamp", nullable=false)
    private Date       tchgTimeStamp ;

    @Column(name="tchg_modified_ip", length=240)
    private String     tchgModifiedIp ;

    @Column(name="tchg_remarks", length=240)
    private String     tchgRemarks  ;

    @Column(name="tchg_lock_key", nullable=false)
    private Long       tchgLockKey  ;

    @Column(name="tchg_profile_key", nullable=false)
    private Long       tchgProfileKey ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdChangeLogDetailsEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : tchg_table_name ( VARCHAR ) 
    public void setTchgTableName( String tchgTableName ) {
        this.tchgTableName = tchgTableName;
    }
    public String getTchgTableName() {
        return this.tchgTableName;
    }

    //--- DATABASE MAPPING : tchg_column_name ( VARCHAR ) 
    public void setTchgColumnName( String tchgColumnName ) {
        this.tchgColumnName = tchgColumnName;
    }
    public String getTchgColumnName() {
        return this.tchgColumnName;
    }

    //--- DATABASE MAPPING : tchg_serial ( BIGINT ) 
    public void setTchgSerial( Long tchgSerial ) {
        this.tchgSerial = tchgSerial;
    }
    public Long getTchgSerial() {
        return this.tchgSerial;
    }

    //--- DATABASE MAPPING : tchg_change_type ( VARCHAR ) 
    public void setTchgChangeType( String tchgChangeType ) {
        this.tchgChangeType = tchgChangeType;
    }
    public String getTchgChangeType() {
        return this.tchgChangeType;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_name_1 ( VARCHAR ) 
    public void setTchgTableKeyColName1( String tchgTableKeyColName1 ) {
        this.tchgTableKeyColName1 = tchgTableKeyColName1;
    }
    public String getTchgTableKeyColName1() {
        return this.tchgTableKeyColName1;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_value_1 ( BIGINT ) 
    public void setTchgTableKeyColValue1( Long tchgTableKeyColValue1 ) {
        this.tchgTableKeyColValue1 = tchgTableKeyColValue1;
    }
    public Long getTchgTableKeyColValue1() {
        return this.tchgTableKeyColValue1;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_name_2 ( VARCHAR ) 
    public void setTchgTableKeyColName2( String tchgTableKeyColName2 ) {
        this.tchgTableKeyColName2 = tchgTableKeyColName2;
    }
    public String getTchgTableKeyColName2() {
        return this.tchgTableKeyColName2;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_value_2 ( BIGINT ) 
    public void setTchgTableKeyColValue2( Long tchgTableKeyColValue2 ) {
        this.tchgTableKeyColValue2 = tchgTableKeyColValue2;
    }
    public Long getTchgTableKeyColValue2() {
        return this.tchgTableKeyColValue2;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_name_3 ( VARCHAR ) 
    public void setTchgTableKeyColName3( String tchgTableKeyColName3 ) {
        this.tchgTableKeyColName3 = tchgTableKeyColName3;
    }
    public String getTchgTableKeyColName3() {
        return this.tchgTableKeyColName3;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_value_3 ( BIGINT ) 
    public void setTchgTableKeyColValue3( Long tchgTableKeyColValue3 ) {
        this.tchgTableKeyColValue3 = tchgTableKeyColValue3;
    }
    public Long getTchgTableKeyColValue3() {
        return this.tchgTableKeyColValue3;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_name_4 ( VARCHAR ) 
    public void setTchgTableKeyColName4( String tchgTableKeyColName4 ) {
        this.tchgTableKeyColName4 = tchgTableKeyColName4;
    }
    public String getTchgTableKeyColName4() {
        return this.tchgTableKeyColName4;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_value_4 ( BIGINT ) 
    public void setTchgTableKeyColValue4( Long tchgTableKeyColValue4 ) {
        this.tchgTableKeyColValue4 = tchgTableKeyColValue4;
    }
    public Long getTchgTableKeyColValue4() {
        return this.tchgTableKeyColValue4;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_name_5 ( VARCHAR ) 
    public void setTchgTableKeyColName5( String tchgTableKeyColName5 ) {
        this.tchgTableKeyColName5 = tchgTableKeyColName5;
    }
    public String getTchgTableKeyColName5() {
        return this.tchgTableKeyColName5;
    }

    //--- DATABASE MAPPING : tchg_table_key_col_value_5 ( BIGINT ) 
    public void setTchgTableKeyColValue5( Long tchgTableKeyColValue5 ) {
        this.tchgTableKeyColValue5 = tchgTableKeyColValue5;
    }
    public Long getTchgTableKeyColValue5() {
        return this.tchgTableKeyColValue5;
    }

    //--- DATABASE MAPPING : tchg_table_old_char_value ( VARCHAR ) 
    public void setTchgTableOldCharValue( String tchgTableOldCharValue ) {
        this.tchgTableOldCharValue = tchgTableOldCharValue;
    }
    public String getTchgTableOldCharValue() {
        return this.tchgTableOldCharValue;
    }

    //--- DATABASE MAPPING : tchg_table_new_char_value ( VARCHAR ) 
    public void setTchgTableNewCharValue( String tchgTableNewCharValue ) {
        this.tchgTableNewCharValue = tchgTableNewCharValue;
    }
    public String getTchgTableNewCharValue() {
        return this.tchgTableNewCharValue;
    }

    //--- DATABASE MAPPING : tchg_table_old_num_value ( BIGINT ) 
    public void setTchgTableOldNumValue( Long tchgTableOldNumValue ) {
        this.tchgTableOldNumValue = tchgTableOldNumValue;
    }
    public Long getTchgTableOldNumValue() {
        return this.tchgTableOldNumValue;
    }

    //--- DATABASE MAPPING : tchg_table_new_num_value ( BIGINT ) 
    public void setTchgTableNewNumValue( Long tchgTableNewNumValue ) {
        this.tchgTableNewNumValue = tchgTableNewNumValue;
    }
    public Long getTchgTableNewNumValue() {
        return this.tchgTableNewNumValue;
    }

    //--- DATABASE MAPPING : tchg_table_old_date_value ( DATE ) 
    public void setTchgTableOldDateValue( Date tchgTableOldDateValue ) {
        this.tchgTableOldDateValue = tchgTableOldDateValue;
    }
    public Date getTchgTableOldDateValue() {
        return this.tchgTableOldDateValue;
    }

    //--- DATABASE MAPPING : tchg_table_new_date_value ( DATE ) 
    public void setTchgTableNewDateValue( Date tchgTableNewDateValue ) {
        this.tchgTableNewDateValue = tchgTableNewDateValue;
    }
    public Date getTchgTableNewDateValue() {
        return this.tchgTableNewDateValue;
    }

    //--- DATABASE MAPPING : tchg_modified_by ( BIGINT ) 
    public void setTchgModifiedBy( Long tchgModifiedBy ) {
        this.tchgModifiedBy = tchgModifiedBy;
    }
    public Long getTchgModifiedBy() {
        return this.tchgModifiedBy;
    }

    //--- DATABASE MAPPING : tchg_modified_on ( DATE ) 
    public void setTchgModifiedOn( Date tchgModifiedOn ) {
        this.tchgModifiedOn = tchgModifiedOn;
    }
    public Date getTchgModifiedOn() {
        return this.tchgModifiedOn;
    }

    //--- DATABASE MAPPING : tchg_time_stamp ( TIMESTAMP ) 
    public void setTchgTimeStamp( Date tchgTimeStamp ) {
        this.tchgTimeStamp = tchgTimeStamp;
    }
    public Date getTchgTimeStamp() {
        return this.tchgTimeStamp;
    }

    //--- DATABASE MAPPING : tchg_modified_ip ( VARCHAR ) 
    public void setTchgModifiedIp( String tchgModifiedIp ) {
        this.tchgModifiedIp = tchgModifiedIp;
    }
    public String getTchgModifiedIp() {
        return this.tchgModifiedIp;
    }

    //--- DATABASE MAPPING : tchg_remarks ( VARCHAR ) 
    public void setTchgRemarks( String tchgRemarks ) {
        this.tchgRemarks = tchgRemarks;
    }
    public String getTchgRemarks() {
        return this.tchgRemarks;
    }

    //--- DATABASE MAPPING : tchg_lock_key ( BIGINT ) 
    public void setTchgLockKey( Long tchgLockKey ) {
        this.tchgLockKey = tchgLockKey;
    }
    public Long getTchgLockKey() {
        return this.tchgLockKey;
    }

    //--- DATABASE MAPPING : tchg_profile_key ( BIGINT ) 
    public void setTchgProfileKey( Long tchgProfileKey ) {
        this.tchgProfileKey = tchgProfileKey;
    }
    public Long getTchgProfileKey() {
        return this.tchgProfileKey;
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
        sb.append(tchgTableName);
        sb.append("|");
        sb.append(tchgColumnName);
        sb.append("|");
        sb.append(tchgSerial);
        sb.append("|");
        sb.append(tchgChangeType);
        sb.append("|");
        sb.append(tchgTableKeyColName1);
        sb.append("|");
        sb.append(tchgTableKeyColValue1);
        sb.append("|");
        sb.append(tchgTableKeyColName2);
        sb.append("|");
        sb.append(tchgTableKeyColValue2);
        sb.append("|");
        sb.append(tchgTableKeyColName3);
        sb.append("|");
        sb.append(tchgTableKeyColValue3);
        sb.append("|");
        sb.append(tchgTableKeyColName4);
        sb.append("|");
        sb.append(tchgTableKeyColValue4);
        sb.append("|");
        sb.append(tchgTableKeyColName5);
        sb.append("|");
        sb.append(tchgTableKeyColValue5);
        sb.append("|");
        sb.append(tchgTableOldCharValue);
        sb.append("|");
        sb.append(tchgTableNewCharValue);
        sb.append("|");
        sb.append(tchgTableOldNumValue);
        sb.append("|");
        sb.append(tchgTableNewNumValue);
        sb.append("|");
        sb.append(tchgTableOldDateValue);
        sb.append("|");
        sb.append(tchgTableNewDateValue);
        sb.append("|");
        sb.append(tchgModifiedBy);
        sb.append("|");
        sb.append(tchgModifiedOn);
        sb.append("|");
        sb.append(tchgTimeStamp);
        sb.append("|");
        sb.append(tchgModifiedIp);
        sb.append("|");
        sb.append(tchgRemarks);
        sb.append("|");
        sb.append(tchgLockKey);
        sb.append("|");
        sb.append(tchgProfileKey);
        return sb.toString(); 
    } 

}
