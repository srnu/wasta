package com.id.wasta.bean.jpa;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.id.wasta.util.action.CommonConstants;

@Entity
@Table(name="t_id_zip_code_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdZipCodeMasterEntity.countAll", query="SELECT COUNT(x) FROM TIdZipCodeMasterEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdZipCodeMasterEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zcm_key", nullable=false)
	private Long key;

	@Column(name="zcm_code", nullable=false)
	private String code;
	
	@Column(name="zcm_code", nullable=false, insertable=false, updatable=false)
	private String name;
	
	@Column(name="zcm_state_key", nullable=false)
	private Long zcmStateKey;
	
	@Column(name="zcm_city_key", nullable=false)
	private Long zcmCityKey;
	
	@Column(name="zcm_remarks")
	private String zcmRemarks;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_from")
    private Date       activeFrom   ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_to")
    private Date       activeTo     ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;
    
	@Column(name="lock_key", nullable=false)
	private Long lockKey;
	
	@Column(name="profile_key", nullable=false)
	private Long profileKey;
	
	public TIdZipCodeMasterEntity() {
		super();
    }

	public Long getKey() {
		return key;
	}
	
	public void setKey(Long key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getZcmStateKey() {
		return zcmStateKey;
	}
	public void setZcmStateKey(Long zcmStateKey) {
		this.zcmStateKey = zcmStateKey;
	}

	public Long getZcmCityKey() {
		return zcmCityKey;
	}

	public void setZcmCityKey(Long zcmCityKey) {
		this.zcmCityKey = zcmCityKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLockKey() {
		return lockKey;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}
	
	public Date getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	public Date getActiveTo() {
		return activeTo;
	}

	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getZcmRemarks() {
		return zcmRemarks;
	}

	public void setZcmRemarks(String zcmRemarks) {
		this.zcmRemarks = zcmRemarks;
	}

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(key);
        sb.append("|");
        sb.append(code);
        sb.append("|");
        sb.append(zcmStateKey);
        sb.append("|");
        sb.append(zcmCityKey);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 
}
