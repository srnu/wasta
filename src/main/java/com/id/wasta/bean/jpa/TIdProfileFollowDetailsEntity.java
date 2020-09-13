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

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_profile_follow_details")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfileFollowDetailsEntity.countAll", query="SELECT COUNT(x) FROM TIdProfileFollowDetailsEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProfileFollowDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pfd_key", nullable=false)
    private Long pfdKey;

    @Column(name="pfd_pin_key", nullable=false)
    private Long pfdPinKey;
    
    @Column(name="pfd_pin_followby_key", nullable=false)
    private Long pfdPinFollowbyKey;
    
    @Column(name="pfd_followed_date", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date pfdFollowedDate;
    
    @Version
    @Column(name="lock_key", nullable=false)
    private Long lockKey;
    
    @Column(name="profile_key", nullable=false)
    private Long profileKey;
    
    @Column(name="active_status", nullable=false)
    private String activeStatus;

    
    public TIdProfileFollowDetailsEntity() {
		super();
    }

	public Long getPfdKey() {
		return pfdKey;
	}

	public void setPfdKey(Long pfdKey) {
		this.pfdKey = pfdKey;
	}

	public Long getPfdPinKey() {
		return pfdPinKey;
	}

	public void setPfdPinKey(Long pfdPinKey) {
		this.pfdPinKey = pfdPinKey;
	}

	public Long getPfdPinFollowbyKey() {
		return pfdPinFollowbyKey;
	}

	public void setPfdPinFollowbyKey(Long pfdPinFollowbyKey) {
		this.pfdPinFollowbyKey = pfdPinFollowbyKey;
	}

	public Date getPfdFollowedDate() {
		return pfdFollowedDate;
	}

	public void setPfdFollowedDate(Date pfdFollowedDate) {
		this.pfdFollowedDate = pfdFollowedDate;
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

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pfdKey);
        sb.append("]:"); 
        sb.append(pfdPinKey);
        sb.append("|");
        sb.append(pfdPinFollowbyKey);
        sb.append("|");
        sb.append(pfdFollowedDate);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(activeStatus);
        return sb.toString(); 
    } 
  
}
