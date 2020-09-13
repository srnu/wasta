package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_profile_address_details")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfileAddressDetailsEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdProfileAddressDetailsEntitySearch x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProfileAddressDetailsEntitySearch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pad_key", nullable=false)
	private Long padKey;
	
	/*@Column(name="pad_pin_key", nullable=false)
	private Long padPinKey;*/
	
	/*@Column(name="pad_address_type", nullable=false)
	private String padAddressType;*/
	
	@Column(name="pad_address_line1")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String padAddressLine1;
	
	@Column(name="pad_address_line2")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String padAddressLine2;
	
	/*@Column(name="pad_city_key")
	private Long padCityKey;*/
	
	/*@Column(name="pad_state_key")
	private Long padStateKey;
*/	
	/*@Column(name="pad_country_key")
	private Long padCountryKey;*/
	
	@Column(name="pad_pinzip")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String padPinzip;
	
	@Column(name="lock_key", nullable=false)
	private Long lockKey;
	
	@Column(name="profile_key", nullable=false)
	private Long profileKey;
	
	@Column(name="active_status", nullable=false)
	private String activeStatus;
	
	@ManyToOne
	@JoinColumn(name="pad_pin_key", referencedColumnName="pin_key")
	private TIdPersonalInformationEntitySearch tIdPersonalInformation;
	
	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name="pad_city_key", referencedColumnName="city_key")
	private TIdCityMasterEntitySearch tIdCityMasterSearch;
	
	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name="pad_state_key", referencedColumnName="state_key")
	private TIdStateMasterEntitySearch tIdStateMasterSearch;
	
	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name="pad_country_key", referencedColumnName="country_key")
	private TIdCountryMasterEntitySearch tIdCountryMasterSearch;

	/*@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name="pad_pinzip_key", referencedColumnName="zcm_key")
	private TIdZipCodeMasterEntitySearch tIdZipCodeMasterSearch;*/
	
	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name="pad_address_type", referencedColumnName="rcd_detail_key")
	private TIdReferenceCodesDetailEntity tIdReferenceCodesDetail;
	
	public TIdProfileAddressDetailsEntitySearch() {
			super();
	    }

	public Long getPadKey() {
		return padKey;
	}

	public void setPadKey(Long padKey) {
		this.padKey = padKey;
	}

	/*public Long getPadPinKey() {
		return padPinKey;
	}

	public void setPadPinKey(Long padPinKey) {
		this.padPinKey = padPinKey;
	}*/

	/*public String getPadAddressType() {
		return padAddressType;
	}

	public void setPadAddressType(String padAddressType) {
		this.padAddressType = padAddressType;
	}*/

	public String getPadAddressLine1() {
		return padAddressLine1;
	}

	public void setPadAddressLine1(String padAddressLine1) {
		this.padAddressLine1 = padAddressLine1;
	}

	public String getPadAddressLine2() {
		return padAddressLine2;
	}

	public void setPadAddressLine2(String padAddressLine2) {
		this.padAddressLine2 = padAddressLine2;
	}

	/*public Long getPadCityKey() {
		return padCityKey;
	}

	public void setPadCityKey(Long padCityKey) {
		this.padCityKey = padCityKey;
	}*/

	/*public Long getPadStateKey() {
		return padStateKey;
	}

	public void setPadStateKey(Long padStateKey) {
		this.padStateKey = padStateKey;
	}
*/
	/*public Long getPadCountryKey() {
		return padCountryKey;
	}

	public void setPadCountryKey(Long padCountryKey) {
		this.padCountryKey = padCountryKey;
	}*/

	public String getPadPinzip() {
		return padPinzip;
	}

	public void setPadPinzip(String padPinzip) {
		this.padPinzip = padPinzip;
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
	
	
	public TIdPersonalInformationEntitySearch gettIdPersonalInformation() {
		return tIdPersonalInformation;
	}

	public void settIdPersonalInformation(TIdPersonalInformationEntitySearch tIdPersonalInformation) {
		this.tIdPersonalInformation = tIdPersonalInformation;
	}
	
	public TIdCityMasterEntitySearch gettIdCityMasterSearch() {
		return tIdCityMasterSearch;
	}

	public void settIdCityMasterSearch(TIdCityMasterEntitySearch tIdCityMasterSearch) {
		this.tIdCityMasterSearch = tIdCityMasterSearch;
	}
	public TIdStateMasterEntitySearch gettIdStateMasterSearch() {
		return tIdStateMasterSearch;
	}

	public void settIdStateMasterSearch(TIdStateMasterEntitySearch tIdStateMasterSearch) {
		this.tIdStateMasterSearch = tIdStateMasterSearch;
	}

	public TIdCountryMasterEntitySearch gettIdCountryMasterSearch() {
		return tIdCountryMasterSearch;
	}

	public void settIdCountryMasterSearch(TIdCountryMasterEntitySearch tIdCountryMasterSearch) {
		this.tIdCountryMasterSearch = tIdCountryMasterSearch;
	}
	
	/*public TIdZipCodeMasterEntitySearch gettIdZipCodeMasterSearch() {
		return tIdZipCodeMasterSearch;
	}

	public void settIdZipCodeMasterSearch(TIdZipCodeMasterEntitySearch tIdZipCodeMasterSearch) {
		this.tIdZipCodeMasterSearch = tIdZipCodeMasterSearch;
	}*/

	public TIdReferenceCodesDetailEntity gettIdReferenceCodesDetail() {
		return tIdReferenceCodesDetail;
	}

	public void settIdReferenceCodesDetail(TIdReferenceCodesDetailEntity tIdReferenceCodesDetail) {
		this.tIdReferenceCodesDetail = tIdReferenceCodesDetail;
	}

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(padKey);
        /*sb.append("|");
        sb.append(padPinKey);*/
       /* sb.append("|");
        sb.append(padAddressType);*/
        sb.append("|");
        sb.append(padAddressLine1);
        sb.append("|");
        sb.append(padAddressLine2);
        /*sb.append("|");
        sb.append(padCityKey);*/
       /* sb.append("|");
        sb.append(padStateKey);*/
        /*sb.append("|");
        sb.append(padCountryKey);
*/      sb.append("|");
        sb.append(padPinzip);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    }

}
