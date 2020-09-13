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

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_template_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdTemplateMasterEntity.countAll", query="SELECT COUNT(x) FROM TIdTemplateMasterEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdTemplateMasterEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="tm_id", nullable=false)
	private Long tmId;
	
	@Column(name="tm_code")
	private String tmCode;

	@Column(name="tm_type")
	private String tmType;
	
	@Column(name="tm_functionality")
	private String tmFunctionality;
	
	@Column(name="tm_status")
	private String tmStatus;
	
	@Column(name="tm_content")
	private String tmContent;
	
	@Column(name="tm_subject")
	private String tmSubject;
	
	@Column(name="profile_key", nullable=false)
	private Long profileKey;
	
	@Column(name="lock_key", nullable=false)
	private Long lockKey;
	
	@Column(name="active_status", nullable=false)
	private String activeStatus;
	
	public TIdTemplateMasterEntity() {
		super();
    }

	public Long getTmId() {
		return tmId;
	}

	public void setTmId(Long tmId) {
		this.tmId = tmId;
	}

	public String getTmCode() {
		return tmCode;
	}

	public void setTmCode(String tmCode) {
		this.tmCode = tmCode;
	}

	public String getTmType() {
		return tmType;
	}

	public void setTmType(String tmType) {
		this.tmType = tmType;
	}

	public String getTmFunctionality() {
		return tmFunctionality;
	}

	public void setTmFunctionality(String tmFunctionality) {
		this.tmFunctionality = tmFunctionality;
	}

	public String getTmStatus() {
		return tmStatus;
	}

	public void setTmStatus(String tmStatus) {
		this.tmStatus = tmStatus;
	}

	public String getTmContent() {
		return tmContent;
	}

	public void setTmContent(String tmContent) {
		this.tmContent = tmContent;
	}

	public String getTmSubject() {
		return tmSubject;
	}

	public void setTmSubject(String tmSubject) {
		this.tmSubject = tmSubject;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public Long getLockKey() {
		return lockKey;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(tmId);
        sb.append("|");
        sb.append(tmCode);
        sb.append("|");
        sb.append(tmType);
        sb.append("|");
        sb.append(tmFunctionality);
        sb.append("|");
        sb.append(tmStatus);
        sb.append("|");
        sb.append(tmContent);
        sb.append("|");
        sb.append(tmSubject);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}
