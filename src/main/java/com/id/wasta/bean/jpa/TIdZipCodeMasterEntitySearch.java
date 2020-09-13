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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_zip_code_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdZipCodeMasterEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdZipCodeMasterEntitySearch x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdZipCodeMasterEntitySearch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zcm_key", nullable=false)
	private Long zcmKey;

	@Column(name="zcm_code", nullable=false)
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String zcmCode;
	
	@Column(name="zcm_state_key", nullable=false)
	private Long zcmStateKey;
	
	@Column(name="zcm_city_key", nullable=false)
	private Long zcmCityKey;
	
	@Column(name="zcm_remarks")
	private String zcmRemarks;
	
	@Column(name="lock_key", nullable=false)
	private Long lockKey;
	
	@Column(name="profile_key", nullable=false)
	private Long profileKey;
	
	/*@OneToMany(mappedBy="tIdZipCodeMasterSearch", targetEntity=TIdProfileAddressDetailsEntitySearch.class)
    private List<TIdProfileAddressDetailsEntitySearch> listOfTIdProfileAddressDetails;*/
	
	public TIdZipCodeMasterEntitySearch() {
		super();
    }

	public Long getZcmKey() {
		return zcmKey;
	}

	public void setZcmKey(Long zcmKey) {
		this.zcmKey = zcmKey;
	}

	public String getZcmCode() {
		return zcmCode;
	}

	public void setZcmCode(String zcmCode) {
		this.zcmCode = zcmCode;
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

	public String getZcmRemarks() {
		return zcmRemarks;
	}

	public void setZcmRemarks(String zcmRemarks) {
		this.zcmRemarks = zcmRemarks;
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
	
	
	/*public List<TIdProfileAddressDetailsEntitySearch> getListOfTIdProfileAddressDetails() {
		return listOfTIdProfileAddressDetails;
	}

	public void setListOfTIdProfileAddressDetails(
			List<TIdProfileAddressDetailsEntitySearch> listOfTIdProfileAddressDetails) {
		this.listOfTIdProfileAddressDetails = listOfTIdProfileAddressDetails;
	}*/

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(zcmKey);
        sb.append("|");
        sb.append(zcmCode);
        sb.append("|");
        sb.append(zcmStateKey);
        sb.append("|");
        sb.append(zcmCityKey);
        sb.append("|");
        sb.append(zcmRemarks);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
